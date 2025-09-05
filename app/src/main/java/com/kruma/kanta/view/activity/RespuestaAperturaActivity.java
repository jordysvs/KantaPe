package com.kruma.kanta.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

//

//
import com.kruma.core.configuration.App;
import com.kruma.core.util.common.ProcessCallback;
import com.kruma.core.util.common.ProcessResult;
import com.kruma.kanta.MainActivity;
import com.kruma.kanta.R;
import com.kruma.kanta.entidad.Alerta;
import com.kruma.kanta.entidad.Constante;
import com.kruma.kanta.entidad.Ubicacion;

/**
 * Created by JORDY on 15/03/2017.
 */

public class RespuestaAperturaActivity extends Activity {

    public boolean bln_Termino;
    public Button btnCancelarApertura;
    //public ProgressDialog pDialog;
    private RespuestaAperturaDialog dg_gProceso;
    private Alerta obj_gAlerta = null;

    //

    private ImageView loading;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_respuesta_apertura);

        bln_Termino = false;
        btnCancelarApertura = (Button) findViewById(R.id.btnCancelarApertura);

        loading = (ImageView) findViewById(R.id.loading);

        loading.setBackgroundResource(R.drawable.loading);

        AnimationDrawable frameAnimation = (AnimationDrawable) loading.getBackground();
        frameAnimation.start();


        dg_gProceso = new RespuestaAperturaDialog();
        dg_gProceso.execute();
    }

    private class RespuestaAperturaDialog extends AsyncTask<Void, Integer, Boolean> {

        private void ObtenerNotificacion() {
            bln_Termino = false;
            com.kruma.kanta.logical.Apertura.ObtenerNotificacion(
                    //Integer.parseInt(Constante.ID_LOCAL),
                    com.kruma.core.security.SecurityManager.getKeyInteger(Constante.SESSION_IDLOCAL),
                    //Integer.parseInt(Constante.ID_UBICACION),
                    com.kruma.core.security.SecurityManager.getKeyInteger(Constante.SESSION_IDUBICACION),
                    //Integer.parseInt(Constante.ID_ALERTA),
                    com.kruma.core.security.SecurityManager.getKeyInteger(Constante.SESSION_IDALERTA),
                    new ProcessCallback<Alerta>() {
                        @Override
                        public void success(Alerta obj_pResultado) {
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            if (obj_pResultado != null) {
                                if (obj_pResultado.getEstado().equals(Constante.ESTADO_ACTIVO)) {
                                    //guardar en memoria la informacion de la apertura
                                    //Constante.ID_APERTURA = obj_pResultado.getApertura().getIdApertura();
                                    com.kruma.core.security.SecurityManager.setKey(Constante.SESSION_IDAPERTURA, String.valueOf(obj_pResultado.getApertura().getIdApertura()));

                                    //Constante.ID_APERTURA_USUARIO = 1;
                                    com.kruma.core.security.SecurityManager.setKey(Constante.SESSION_IDAPERTURAUSUARIO, String.valueOf(1));
                                    bln_gFinalizar = true;

                                    Toast.makeText(App.getContext(), "Su solicitud de Apertura fue aceptada por el mozo" + "\n" + "Sera usted el administrador de la mesa", Toast.LENGTH_SHORT).show();
                                    //ObtencionDatosGeolocalizacion();
                                    Intent intent = new Intent(App.getContext(), MainActivity.class);
                                    //intent.putExtra("Logeado", Constante.TXT_USUARIO_LOGEADO);
                                    intent.putExtra("Logeado", com.kruma.core.security.SecurityManager.getUsuario());

                                    //Mis datos Geolocalizacion
                                    //Toast.makeText(App.getContext(), String.valueOf(com.kruma.core.security.SecurityManager.getKeyDouble(Constante.SESSION_MI_LONGITUD)), Toast.LENGTH_SHORT).show();
                                    //Toast.makeText(App.getContext(), String.valueOf(com.kruma.core.security.SecurityManager.getKeyDouble(Constante.SESSION_MI_LATITUD)), Toast.LENGTH_SHORT).show();

                                    startActivity(intent);

                                    finish();

                                } else if (obj_pResultado.getEstado().equals(Constante.ESTADO_RECHAZADO)) {
                                    Toast.makeText(App.getContext(), "Su solicitud de apertura a sido rechazada por el mozo", Toast.LENGTH_SHORT).show();
                                    bln_gFinalizar = true;
                                    Intent intent = new Intent(App.getContext(), MainActivity.class);

                                    intent.putExtra("Logeado", com.kruma.core.security.SecurityManager.getUsuario());

                                    //intent.putExtra("ConstanteMozo", "N");
                                    //Constante.ID_LOCAL = null;
                                    com.kruma.core.security.SecurityManager.setKey(Constante.SESSION_IDLOCAL, null);
                                    startActivity(intent);

                                    finish();

                                } else if (obj_pResultado.getEstado().equals(Constante.ESTADO_PENDIENTE)) {
                                    bln_gFinalizar = false;
                                }
                            }
                            bln_Termino = true;
                        }

                        @Override
                        public void failure(ProcessResult obj_pResultado) {
                            Toast.makeText(RespuestaAperturaActivity.this, "Se produjo un error en la espera de la solicitud", Toast.LENGTH_SHORT).show();
                            bln_Termino = true;
                            RespuestaAperturaDialog.this.cancel(true);
                        }
                    });

        }

        public boolean bln_gFinalizar = false;

        @Override
        protected Boolean doInBackground(Void... params) {
            while (!bln_gFinalizar) {
                ObtenerNotificacion();
                while (!bln_Termino) {
                    if (isCancelled())
                        break;
                }
                if (isCancelled())
                    break;
            }
            return true;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {

        }

        @Override
        protected void onPreExecute() {

            btnCancelarApertura.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    RespuestaAperturaDialog.this.cancel(true);
                }
            });
        }

        @Override
        protected void onPostExecute(Boolean result) {
            if (result) {
                //Toast.makeText(RespuestaAperturaActivity.this, "Mesa Aperturada", Toast.LENGTH_SHORT).show();
            }
        }

        public void ObtencionDatosGeolocalizacion() {
            try {
                // Obtencion de Latitud y Longitud
                com.kruma.kanta.logical.Ubicacion.Obtener(com.kruma.core.security.SecurityManager.getKeyInteger(Constante.SESSION_IDLOCAL),
                        com.kruma.core.security.SecurityManager.getKeyInteger(Constante.SESSION_IDUBICACION),
                        new ProcessCallback<Ubicacion>() {
                            @Override
                            public void success(com.kruma.kanta.entidad.Ubicacion obj_pUbicacion) {
                               // com.kruma.core.security.SecurityManager.setKey(Constante.SESSION_LONGITUD, String.valueOf(obj_pUbicacion.getLocal().getLongitud()));
                               // com.kruma.core.security.SecurityManager.setKey(Constante.SESSION_LATITUD, String.valueOf(obj_pUbicacion.getLocal().getLatitud()));
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

        @Override
        protected void onCancelled() {
            com.kruma.kanta.logical.Apertura.CancelarNotificacion(
                    //Integer.parseInt(Constante.ID_LOCAL),
                    com.kruma.core.security.SecurityManager.getKeyInteger(Constante.SESSION_IDLOCAL),
                    //Integer.parseInt(Constante.ID_UBICACION),
                    com.kruma.core.security.SecurityManager.getKeyInteger(Constante.SESSION_IDUBICACION),
                    //Integer.parseInt(Constante.ID_ALERTA),
                    com.kruma.core.security.SecurityManager.getKeyInteger(Constante.SESSION_IDALERTA),
                    //Constante.TXT_USUARIO_LOGEADO,
                    com.kruma.core.security.SecurityManager.getUsuario(),

                    new ProcessCallback<ProcessResult>() {


                        @Override
                        public void success(ProcessResult obj_pResultado) {
                            Toast.makeText(App.getContext(), obj_pResultado.getMessage(), Toast.LENGTH_LONG).show();
                            //Aca debe de regresar a la actividad anterior
                            Intent intent1 = new Intent(App.getContext(), MainActivity.class);

                            //intent1.putExtra("Logeado", Constante.TXT_USUARIO_LOGEADO);
                            intent1.putExtra("Logeado", com.kruma.core.security.SecurityManager.getUsuario());

                            //Constante.ID_LOCAL = null;
                            com.kruma.core.security.SecurityManager.setKey(Constante.SESSION_IDLOCAL, null);
                            //Constante.ID_UBICACION = null;
                            //intent1.putExtra("ConstanteMozo", "N");
                            startActivity(intent1);

                            finish();
                        }

                        @Override
                        public void failure(ProcessResult obj_pResultado) {
                            Toast.makeText(App.getContext(), obj_pResultado.getMessage().toString(), Toast.LENGTH_LONG).show();
                        }
                    });

        }
    }
}
