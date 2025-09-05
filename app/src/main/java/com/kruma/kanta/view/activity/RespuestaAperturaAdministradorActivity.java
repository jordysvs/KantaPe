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

import com.kruma.core.configuration.App;
import com.kruma.core.util.common.ProcessCallback;
import com.kruma.core.util.common.ProcessResult;
import com.kruma.kanta.MainActivity;
import com.kruma.kanta.R;
import com.kruma.kanta.entidad.Alerta;
import com.kruma.kanta.entidad.AperturaUsuario;
import com.kruma.kanta.entidad.Constante;

/**
 * Created by JORDY on 27/04/2017.
 */

public class RespuestaAperturaAdministradorActivity extends Activity {

    public boolean bln_Termino;
    public Button btnCancelarApertura;
    //public ProgressDialog pDialog;
    private RespuestaAperturaAdministradorActivity.RespuestaAperturaDialog dg_gProceso;
    private Alerta obj_gAlerta = null;

    private ImageView loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_respuesta_apertura_administrador);

        bln_Termino = false;
        btnCancelarApertura = (Button) findViewById(R.id.btnCancelarAperturaAdministrador);

        loading = (ImageView) findViewById(R.id.loadingAdministrador);

        loading.setBackgroundResource(R.drawable.loading);

        AnimationDrawable frameAnimation = (AnimationDrawable) loading.getBackground();
        frameAnimation.start();

        //pDialog = new ProgressDialog(RespuestaAperturaActivity.this);
        //pDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        //pDialog.setMessage("Procesando...");
        //pDialog.setCancelable(true);
        //pDialog.setMax(100);

        dg_gProceso = new RespuestaAperturaAdministradorActivity.RespuestaAperturaDialog();
        dg_gProceso.execute();
    }

    private class RespuestaAperturaDialog extends AsyncTask<Void, Integer, Boolean> {

        private void ObtenerAperturaUsuario() {
            bln_Termino = false;
            com.kruma.kanta.logical.AperturaUsuario.ObtenerEstadoAperturaUsuario(
                    //Integer.parseInt(Constante.ID_LOCAL),
                    com.kruma.core.security.SecurityManager.getKeyInteger(Constante.SESSION_IDLOCAL),
                    //Constante.ID_APERTURA,
                    com.kruma.core.security.SecurityManager.getKeyInteger(Constante.SESSION_IDAPERTURA),
                    //Constante.ID_APERTURA_USUARIO,
                    com.kruma.core.security.SecurityManager.getKeyInteger(Constante.SESSION_IDAPERTURAUSUARIO),
                    //Constante.TXT_USUARIO_LOGEADO,
                    com.kruma.core.security.SecurityManager.getUsuario(),
                    new ProcessCallback<AperturaUsuario>() {
                        @Override
                        public void success(AperturaUsuario obj_pResultado) {

                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            if (obj_pResultado != null) {
                                if (obj_pResultado.getEstado().equals(Constante.ESTADO_ACTIVO)) {
                                    //guardar en memoria la informacion de la apertura
                                    //Constante.ID_APERTURA = obj_pResultado.AperturaUsuario().getIdApertura();
                                    bln_gFinalizar = true;
                                    Toast.makeText(App.getContext(), "Su solicitud de Apertura fue aceptada por el Administrador", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(App.getContext(), MainActivity.class);
                                    //Constante.ID_APERTURA_USUARIO = obj_pResultado.getIdAperturaUsuario();
                                    //intent.putExtra("Logeado", Constante.TXT_USUARIO_LOGEADO);
                                    intent.putExtra("Logeado", com.kruma.core.security.SecurityManager.getUsuario());
                                    startActivity(intent);
                                    finish();
                                } else if (obj_pResultado.getEstado().equals(Constante.ESTADO_RECHAZADO)) {
                                    Toast.makeText(App.getContext(), "Su solicitud de Apertura a sido rechazada por el Administrador", Toast.LENGTH_SHORT).show();

                                    bln_gFinalizar = true;

                                    Intent intent = new Intent(App.getContext(), MainActivity.class);
                                    //intent.putExtra("Logeado", Constante.TXT_USUARIO_LOGEADO);
                                    intent.putExtra("Logeado", com.kruma.core.security.SecurityManager.getUsuario());
                                    //intent.putExtra("ConstanteMozo", "N");
                                    //Constante.ID_LOCAL = null;
                                    com.kruma.core.security.SecurityManager.setKey(Constante.SESSION_IDLOCAL, null);
                                    startActivity(intent);
                                    finish();
                                } else if (obj_pResultado.getEstado().equals(Constante.ESTADO_PENDIENTE)) {
                                    //Constante.ID_APERTURA_USUARIO = obj_pResultado.getIdAperturaUsuario();
                                    com.kruma.core.security.SecurityManager.setKey(Constante.SESSION_IDAPERTURAUSUARIO,String.valueOf(obj_pResultado.getIdAperturaUsuario()));
                                    bln_gFinalizar = false;
                                }
                            }
                            bln_Termino = true;
                        }

                        @Override
                        public void failure(ProcessResult obj_pResultado) {
                            Toast.makeText(RespuestaAperturaAdministradorActivity.this, "Se produjo un error en la espera de la solicitud", Toast.LENGTH_SHORT).show();
                            bln_Termino = true;
                            RespuestaAperturaAdministradorActivity.RespuestaAperturaDialog.this.cancel(true);
                        }
                    });

        }

        public boolean bln_gFinalizar = false;

        @Override
        protected Boolean doInBackground(Void... params) {
            while (!bln_gFinalizar) {
                ObtenerAperturaUsuario();
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
                    RespuestaAperturaAdministradorActivity.RespuestaAperturaDialog.this.cancel(true);
                }
            });
        }

        @Override
        protected void onPostExecute(Boolean result) {
            if (result) {
                //Toast.makeText(RespuestaAperturaActivity.this, "Mesa Aperturada", Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        protected void onCancelled() {

            try {
                com.kruma.kanta.entidad.AperturaUsuario obj_AperturaUsuario = new com.kruma.kanta.entidad.AperturaUsuario();

                //obj_AperturaUsuario.setIdLocal(Integer.parseInt(Constante.ID_LOCAL));
                obj_AperturaUsuario.setIdLocal(com.kruma.core.security.SecurityManager.getKeyInteger(Constante.SESSION_IDLOCAL));
                //obj_AperturaUsuario.setIdApertura(Constante.ID_APERTURA);
                obj_AperturaUsuario.setIdApertura(com.kruma.core.security.SecurityManager.getKeyInteger(Constante.SESSION_IDAPERTURA));
                //obj_AperturaUsuario.setIdAperturaUsuario(Constante.ID_APERTURA_USUARIO);
                obj_AperturaUsuario.setIdAperturaUsuario(com.kruma.core.security.SecurityManager.getKeyInteger(Constante.SESSION_IDAPERTURAUSUARIO));
                //obj_AperturaUsuario.setIdUsuario(Constante.TXT_USUARIO_LOGEADO);
                obj_AperturaUsuario.setIdUsuario(com.kruma.core.security.SecurityManager.getUsuario());
                obj_AperturaUsuario.setAdministrador(Constante.CONDICION_NEGATIVO);
                obj_AperturaUsuario.setEstado(Constante.ESTADO_INACTIVO);
                //obj_AperturaUsuario.setUsuarioModificacion(Constante.TXT_USUARIO_LOGEADO);
                obj_AperturaUsuario.setUsuarioModificacion(com.kruma.core.security.SecurityManager.getUsuario());

                // Se realiza la inserción del usuario
                com.kruma.kanta.logical.AperturaUsuario.Modificar(
                        obj_AperturaUsuario,
                        new ProcessCallback<ProcessResult>() {
                            @Override
                            public void success(ProcessResult obj_pResultado) {
                                Toast.makeText(App.getContext(), obj_pResultado.getMessage(), Toast.LENGTH_LONG).show();
                                //Aca debe de regresar a la actividad anterior
                                Intent intent1 = new Intent(App.getContext(), MainActivity.class);
                                //intent1.putExtra("Logeado", Constante.TXT_USUARIO_LOGEADO);
                                intent1.putExtra("Logeado", com.kruma.core.security.SecurityManager.getUsuario());
                                //*Constante.ID_LOCAL = null;
                                com.kruma.core.security.SecurityManager.setKey(Constante.SESSION_IDLOCAL, null);
                                //Constante.ID_UBICACION = null;
                                //intent1.putExtra("ConstanteMozo", "N");
                                startActivity(intent1);

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

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //codigo adicional
        this.finish();
    }

}
