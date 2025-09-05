package com.kruma.kanta;

import android.Manifest;
import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.kruma.core.configuration.App;
import com.kruma.core.util.common.ProcessCallback;
import com.kruma.core.util.common.ProcessResult;
import com.kruma.kanta.entidad.Apertura;
import com.kruma.kanta.entidad.AperturaUsuario;
import com.kruma.kanta.entidad.Constante;
import com.kruma.kanta.entidad.Ubicacion;
import com.kruma.kanta.view.activity.RespuestaAperturaActivity;
import com.kruma.kanta.view.activity.RespuestaAperturaAdministradorActivity;

//import com.google.android.gms.common.api.GoogleApiClient;

/**
 * Created by JORDY on 27/01/2017.
 */

public class ScanActivity extends Activity {

    private static final int ID_NOTIFICACION_PERSONAL = 1;
    public Button btnAperturarMiMesaScanner;
    NotificationManager nm;

    //Para esperar la respuesta del servidor
    private Handler puente = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            //Mostramos el mensage recibido del servido en pantalla
            Toast.makeText(getApplicationContext(), "Su Apertura fue exitosa",
                    Toast.LENGTH_LONG).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner);

        btnAperturarMiMesaScanner = (Button) findViewById(R.id.btnAperturarMiMesaScanner);

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION,}, 1000);
        } else {
            InicioLocalizacion();
        }

        //Activacion de la camara y la lectura del codigo QR
        nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        final Activity activity = this;

        IntentIntegrator integrator = new IntentIntegrator(activity);
        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
        integrator.setPrompt("APERTURA DE MESA");
        integrator.setCameraId(0);
        integrator.setBeepEnabled(false);
        integrator.setBarcodeImageEnabled(false);
        integrator.initiateScan();

        btnAperturarMiMesaScanner.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                IntentIntegrator integrator = new IntentIntegrator(activity);
                integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
                integrator.setPrompt("APERTURA DE MESA");
                integrator.setCameraId(0);
                integrator.setBeepEnabled(false);
                integrator.setBarcodeImageEnabled(false);
                integrator.initiateScan();
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() == null) {
                Toast.makeText(this, "Se canceló la operación", Toast.LENGTH_LONG).show();
                finish();
            } else {
                try {
                    ObtenerActual(result.getContents());
                } catch (Exception ex) {
                    Toast.makeText(App.getContext(), "Error en la lectura del código QR", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    public void Notificar() {
        try {
            // Se realiza la inserción del usuario
            com.kruma.kanta.logical.Apertura.Notificar(
                    //Integer.parseInt(Constante.ID_LOCAL),
                    com.kruma.core.security.SecurityManager.getKeyInteger(Constante.SESSION_IDLOCAL),
                    //Integer.parseInt(Constante.ID_UBICACION),
                    com.kruma.core.security.SecurityManager.getKeyInteger(Constante.SESSION_IDUBICACION),
                    //Constante.TXT_USUARIO_LOGEADO,
                    com.kruma.core.security.SecurityManager.getUsuario(),

                    new ProcessCallback<ProcessResult>() {

                        @Override
                        public void success(ProcessResult obj_pResultado) {
                            Toast.makeText(App.getContext(), obj_pResultado.getMessage(), Toast.LENGTH_LONG).show();
                            //Se asigna la alerta
                            //*Constante.ID_ALERTA = Integer.toString(((Double) obj_pResultado.getReturnId()).intValue());
                            com.kruma.core.security.SecurityManager.setKey(Constante.SESSION_IDALERTA, String.valueOf(((Double) obj_pResultado.getReturnId()).intValue()));
                            //Se muestra el mensaje de espera
                            Intent obj_Intent = new Intent(App.getContext(), RespuestaAperturaActivity.class);
                            startActivity(obj_Intent);

                            finish();
                        }

                        @Override
                        public void failure(ProcessResult obj_pResultado) {
                            Toast.makeText(App.getContext(), obj_pResultado.getMessage().toString(), Toast.LENGTH_LONG).show();
                        }
                    });

        } catch (Exception ex) {
            Toast.makeText(App.getContext(), ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        //Al destruiir la aplicacion de la pila de aplicaciones , el Mensaje de la barra tambien se destruye.
        nm.cancel(ID_NOTIFICACION_PERSONAL);
    }


//Servicios de Geolocalizacion, LATITUD Y LONGITUD

    //private void ObtenerLocalizacion(Location loc) {
    //   if (loc != null) {
    //     Constante.TXT_LATITUD = String.valueOf(loc.getLatitude());
    //  Constante.TXT_LONGITUD =  String.valueOf(loc.getLongitude());
    //} else {
    //      Constante.TXT_LATITUD = "(desconocida)";
    //    Constante.TXT_LONGITUD = "(desconocida)";
    //}
    //}

    public void ObtenerActual(String str_pQR) {
        try {
            // Se realiza la inserción del usuario
            com.kruma.kanta.logical.Ubicacion.ObtenerQR(str_pQR,
                    new ProcessCallback<Ubicacion>() {
                        @Override
                        public void success(com.kruma.kanta.entidad.Ubicacion obj_pUbicacion) {
                            //Si no existe la apertura se notifica
                            if (obj_pUbicacion != null) {
                                if (obj_pUbicacion.getEstado().equals(Constante.ESTADO_ACTIVO)) {
                                    //*Constante.ID_LOCAL = String.valueOf(obj_pUbicacion.getIdLocal());
                                    com.kruma.core.security.SecurityManager.setKey(Constante.SESSION_IDLOCAL, String.valueOf(obj_pUbicacion.getIdLocal()));
                                    //Constante.ID_UBICACION = String.valueOf(obj_pUbicacion.getIdUbicacion());
                                    com.kruma.core.security.SecurityManager.setKey(Constante.SESSION_IDUBICACION, String.valueOf(obj_pUbicacion.getIdUbicacion()));

                                    //Obtengo Y Registro la Latitud y Longitud del LOCAL SCANEADO

                                    //String Latitud = obj_pUbicacion.getLocal().getLatitud();
                                    //String Longitud = obj_pUbicacion.getLocal().getLongitud();
                                    //BigDecimal Radio = obj_pUbicacion.getLocal().getRadio();

                                    com.kruma.core.security.SecurityManager.setKey(Constante.SESSION_LATITUD, obj_pUbicacion.getLocal().getLatitud());
                                    com.kruma.core.security.SecurityManager.setKey(Constante.SESSION_LONGITUD, obj_pUbicacion.getLocal().getLongitud());
                                    com.kruma.core.security.SecurityManager.setKey(Constante.SESSION_RADIO, String.valueOf(obj_pUbicacion.getLocal().getRadio()));

                                    com.kruma.core.security.SecurityManager.setKey(Constante.SESSION_FLAGLOCALIZACION, obj_pUbicacion.getLocal().getFlagLocalizacion());


                                    ObtenerApertura();
                                } else
                                    Toast.makeText(App.getContext(), "La mesa escaneada se encuentra inactivada", Toast.LENGTH_LONG).show();
                                    finish();
                            } else {
                                Toast.makeText(App.getContext(), "No existe el local y ubicacion escaneada ", Toast.LENGTH_LONG).show();
                                finish();
                            }
                        }

                        @Override
                        public void failure(ProcessResult obj_pResultado) {
                            Toast.makeText(App.getContext(), "Error en la lectura del código QR", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    });
        } catch (Exception ex) {
            Toast.makeText(App.getContext(), ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void ObtenerApertura() {
        try {
            com.kruma.kanta.logical.Apertura.ObtenerActual(
                    //Integer.parseInt(Constante.ID_LOCAL),
                    com.kruma.core.security.SecurityManager.getKeyInteger(Constante.SESSION_IDLOCAL),
                    //Integer.parseInt(Constante.ID_UBICACION),
                    com.kruma.core.security.SecurityManager.getKeyInteger(Constante.SESSION_IDUBICACION),
                    new ProcessCallback<Apertura>() {
                        @Override
                        public void success(com.kruma.kanta.entidad.Apertura obj_pApertura) {
                            if(com.kruma.core.security.SecurityManager.getKey(Constante.SESSION_FLAGLOCALIZACION) != null) {
                                if(com.kruma.core.security.SecurityManager.getKey(Constante.SESSION_FLAGLOCALIZACION).equals("S")) {
                                    if (getDistance() <= com.kruma.core.security.SecurityManager.getKeyDouble(Constante.SESSION_RADIO)) {
                                        if (obj_pApertura == null) {
                                            Notificar();
                                        } else {
                                            com.kruma.core.security.SecurityManager.setKey(Constante.SESSION_IDAPERTURA, String.valueOf(obj_pApertura.getIdApertura()));
                                            InsertarAperturaUsuario();
                                        }
                                    } else {
                                        com.kruma.core.security.SecurityManager.setKey(Constante.SESSION_IDLOCAL, null);
                                        Toast.makeText(App.getContext(), "No se encuentra en el rango del local", Toast.LENGTH_LONG).show();
                                    }
                                } else{
                                    if (obj_pApertura == null) {
                                        Notificar();
                                    } else {
                                        com.kruma.core.security.SecurityManager.setKey(Constante.SESSION_IDAPERTURA, String.valueOf(obj_pApertura.getIdApertura()));
                                        InsertarAperturaUsuario();
                                    }
                                }
                            } else {
                                if (obj_pApertura == null) {
                                    Notificar();
                                } else {
                                    com.kruma.core.security.SecurityManager.setKey(Constante.SESSION_IDAPERTURA, String.valueOf(obj_pApertura.getIdApertura()));
                                    InsertarAperturaUsuario();
                                }
                            }

                        }

                        @Override
                        public void failure(ProcessResult obj_pResultado) {
                            Toast.makeText(App.getContext(), obj_pResultado.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });
        } catch (Exception ex) {
            Toast.makeText(App.getContext(), ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public static double getDistance(){

        Integer Radius = 6371000; //Radio de la tierra
        //Distancia = 6371 * ACOS(COS(Lat1) * COS(Lat2) * COS(Long2 - Long1) + SIN(Lat1) * SIN(Lat2));

        double latitudCelular = com.kruma.core.security.SecurityManager.getKeyDouble(Constante.SESSION_MI_LATITUD) / 1E6;
        double latitudLocal = com.kruma.core.security.SecurityManager.getKeyDouble(Constante.SESSION_LATITUD) / 1E6;
        //lat2 = latitudLocal
        double longitudCelular = com.kruma.core.security.SecurityManager.getKeyDouble(Constante.SESSION_MI_LONGITUD) / 1E6;
        double longitudLocal = com.kruma.core.security.SecurityManager.getKeyDouble(Constante.SESSION_LONGITUD) / 1E6;

        double diferenciaLatitud = Math.toRadians(latitudLocal-latitudCelular);
        double diferenciaLongitud = Math.toRadians(longitudLocal-longitudCelular);

        double a = Math.sin(diferenciaLatitud / 2) * Math.sin(diferenciaLatitud / 2) + Math.cos(Math.toRadians(latitudCelular)) * Math.cos(Math.toRadians(latitudLocal)) * Math.sin(diferenciaLongitud /2) * Math.sin(diferenciaLongitud/2);
        double c = 2 * Math.asin(Math.sqrt(a));

        double d = Radius * c * 1000000;

        return (d);

    }

    private void InsertarAperturaUsuario() {
        try {
            AperturaUsuario obj_AperturaUsuario = new AperturaUsuario();
            //obj_AperturaUsuario.setIdLocal(Integer.parseInt(Constante.ID_LOCAL));
            obj_AperturaUsuario.setIdLocal(com.kruma.core.security.SecurityManager.getKeyInteger(Constante.SESSION_IDLOCAL));
            //obj_AperturaUsuario.setIdApertura(Constante.ID_APERTURA);
            obj_AperturaUsuario.setIdApertura(com.kruma.core.security.SecurityManager.getKeyInteger(Constante.SESSION_IDAPERTURA));
            //obj_AperturaUsuario.setIdUsuario(Constante.TXT_USUARIO_LOGEADO);
            obj_AperturaUsuario.setIdUsuario(com.kruma.core.security.SecurityManager.getUsuario());
            obj_AperturaUsuario.setAdministrador(Constante.CONDICION_NEGATIVO);
            obj_AperturaUsuario.setEstado(Constante.ESTADO_PENDIENTE);
            //obj_AperturaUsuario.setUsuarioCreacion(Constante.TXT_USUARIO_LOGEADO);
            obj_AperturaUsuario.setUsuarioCreacion(com.kruma.core.security.SecurityManager.getUsuario());


            com.kruma.kanta.logical.AperturaUsuario.Insertar(
                    obj_AperturaUsuario,
                    new ProcessCallback<ProcessResult>() {
                        @Override
                        public void success(ProcessResult obj_pResultado) {

                            String idperturaUsuario = Integer.toString(((Double) obj_pResultado.getReturnId()).intValue());
                            //Se asigna la Apertura
                            //Constante.ID_APERTURA_USUARIO = Integer.valueOf(idperturaUsuario);
                            com.kruma.core.security.SecurityManager.setKey(Constante.SESSION_IDAPERTURAUSUARIO, idperturaUsuario);

                            Intent obj_Intent = new Intent(App.getContext(), RespuestaAperturaAdministradorActivity.class);
                            startActivity(obj_Intent);

                            finish();
                        }

                        @Override
                        public void failure(ProcessResult obj_pResultado) {
                            Toast.makeText(App.getContext(), obj_pResultado.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });

        } catch (Exception ex) {
            Toast.makeText(App.getContext(), ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void InicioLocalizacion() {
        LocationManager mlocManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Localizacion Local = new Localizacion();
        Local.setScanActivity(this);
        final boolean gpsEnabled = mlocManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        if (!gpsEnabled) {
            Intent settingsIntent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            startActivity(settingsIntent);
        }
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION,}, 1000);
            return;
        }
        mlocManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, (LocationListener) Local);
        mlocManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, (LocationListener) Local);

        //mensaje1.setText("Localizacion agregada");
        //mensaje2.setText("");
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == 1000) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                InicioLocalizacion();
                return;
            }
        }
    }

    /*
    public void setLocation(Location loc) {
        //Obtener la direccion de la calle a partir de la latitud y la longitud
        if (loc.getLatitude() != 0.0 && loc.getLongitude() != 0.0) {
            try {
                Geocoder geocoder = new Geocoder(this, Locale.getDefault());
                List<Address> list = geocoder.getFromLocation(
                        loc.getLatitude(), loc.getLongitude(), 1);
                if (!list.isEmpty()) {
                    Address DirCalle = list.get(0);
                   // mensaje2.setText("Mi direccion es: \n"
                         //   + DirCalle.getAddressLine(0));
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
*/

    /* Aqui empieza la Clase Localizacion */
    public class Localizacion implements LocationListener {
        ScanActivity scanActivity;

        public ScanActivity getScanActivity() {
            return scanActivity;
        }

        public void setScanActivity(ScanActivity scanActivity) {
            this.scanActivity = scanActivity;
        }

        @Override
        public void onLocationChanged(Location loc) {
            // Este metodo se ejecuta cada vez que el GPS recibe nuevas coordenadas
            // debido a la deteccion de un cambio de ubicacion

            loc.getLatitude();
            loc.getLongitude();

            com.kruma.core.security.SecurityManager.setKey(Constante.SESSION_MI_LONGITUD, String.valueOf(loc.getLongitude()));
            com.kruma.core.security.SecurityManager.setKey(Constante.SESSION_MI_LATITUD, String.valueOf(loc.getLatitude()));

            //String Textoo = "Mi ubicacion actual es: " + "\n Lat = "
              //      + loc.getLatitude() + "\n Long = " + loc.getLongitude();

           // Toast.makeText(App.getContext(), "Latitud y Longitud" + loc.getLatitude() + loc.getLongitude(), Toast.LENGTH_SHORT).show();
            //this.scanActivity.setLocation(loc);
        }


        @Override
        public void onProviderDisabled(String provider) {
            // Este metodo se ejecuta cuando el GPS es desactivado
            //mensaje1.setText("GPS Desactivado");

            com.kruma.core.security.SecurityManager.setKey(Constante.SESSION_IDLOCAL, null);
            Toast.makeText(App.getContext(), "Se necesita la activacion GPS", Toast.LENGTH_SHORT).show();
            com.kruma.core.security.SecurityManager.goToMain();
            finish();
        }

        @Override
        public void onProviderEnabled(String provider) {
            // Este metodo se ejecuta cuando el GPS es activado
            //mensaje1.setText("GPS Activado");



        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
            switch (status) {
                case LocationProvider.AVAILABLE:
                    Log.d("debug", "LocationProvider.AVAILABLE");
                    break;
                case LocationProvider.OUT_OF_SERVICE:
                    Log.d("debug", "LocationProvider.OUT_OF_SERVICE");
                    break;
                case LocationProvider.TEMPORARILY_UNAVAILABLE:
                    Log.d("debug", "LocationProvider.TEMPORARILY_UNAVAILABLE");
                    break;
            }
        }
    }
//    @Override
//    public void onBackPressed() {
//        //Añade más funciones si fuese necesario
//        super.onBackPressed();  // Invoca al método
//    }
}
