package com.kruma.kanta;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import com.kruma.core.configuration.App;
import com.kruma.core.security.entity.SecurityResult;

import com.kruma.core.util.common.ProcessCallback;
import com.kruma.core.util.common.ProcessResult;
import com.kruma.kanta.entidad.Constante;
import com.kruma.kanta.entidad.Usuario;
import com.kruma.kanta.view.activity.OlvideClaveActivity;
import com.kruma.kanta.view.activity.RegistroActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

//<string name="facebook_app_id">1454429541258536</string>
public class LoginActivity extends AppCompatActivity {


    private static final String TAG = "LoginActivity";

    private EditText txtUsuario;
    private EditText txtClave;
    private TextView txtLink;
    private ImageView iviFacebook;
    private ImageView iviYoutube;
    private Button btnIngresar;
    private Button btnRegistrarse;


    //SessionManager session;

    private Button btnOlvideClave;

    private LoginButton btnIngresarFacebook;
    private CallbackManager callbackManager;
    private AccessTokenTracker accessTokenTracker;
    private ProfileTracker profileTracker;

    String str_Usuario;
    String str_Clave;
    String str_Usuario_Facebook;

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();

    }

    private void init() {

        callbackManager = CallbackManager.Factory.create();

        txtUsuario = (EditText) findViewById(R.id.txtUsuario);
        txtClave = (EditText) findViewById(R.id.txtClave);
        txtLink = (TextView) findViewById(R.id.txtLink);
        iviFacebook = (ImageView) findViewById(R.id.iviFacebook);
        iviYoutube = (ImageView) findViewById(R.id.iviYoutube);
        btnIngresar = (Button) findViewById(R.id.btnIngresar);
        btnRegistrarse = (Button) findViewById(R.id.btnRegistrarse);
        btnOlvideClave = (Button) findViewById(R.id.btnOlvideClave);
        btnIngresarFacebook = (LoginButton) findViewById(R.id.btnIngresarFacebook);

        txtUsuario.setTextColor(txtUsuario.getContext().getResources().getColor(R.color.dark_blue));

        // Ocultar teclado virtual
        InputMethodManager imm =
                (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(txtUsuario.getWindowToken(), 0);

        InputMethodManager imm1 =
                (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        imm1.hideSoftInputFromWindow(txtClave.getWindowToken(), 0);

        btnIngresarFacebook.setReadPermissions(Arrays.asList("public_profile", "email", "user_birthday"));
        btnIngresarFacebook.setReadPermissions("email");

        btnIngresarFacebook.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

                AccessToken accessToken = loginResult.getAccessToken();

                profileTracker = new ProfileTracker() {
                    @Override
                    protected void onCurrentProfileChanged(Profile oldProfile, Profile currentProfile) {
                        if (currentProfile != null) {
                            DatosFacebook(currentProfile);
                        }
                    }
                };

                if (AccessToken.getCurrentAccessToken() != null) {

                    RecogerDatosUsuarioFacebook(AccessToken.getCurrentAccessToken());


                    Profile profile = Profile.getCurrentProfile();
                    if(profile != null){
                        DatosFacebook(profile);
                    }else {
                        Profile.fetchProfileForCurrentAccessToken();
                    }
                }
            }

            @Override
            public void onCancel() {
                Toast.makeText(getApplicationContext(), R.string.cancel_login, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(FacebookException error) {
                Toast.makeText(getApplicationContext(), R.string.error_login, Toast.LENGTH_SHORT).show();
            }
        });


        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (ValidarFormulario()) {
                        Login();
                    }
                } catch (Exception ex) {

                }

            }
        });

        btnRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegistroActivity.class);
                startActivity(intent);
            }
        });

        btnOlvideClave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, OlvideClaveActivity.class);
                startActivity(intent);
            }
        });

        txtLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.kanta.pe"));
                startActivity(browserIntent);
            }
        });

        iviFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.facebook_kanta)));
                startActivity(browserIntent);
            }
        });

        iviYoutube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.youtube_kanta)));
                startActivity(browserIntent);
            }
        });
    }

    private void DatosFacebook(Profile perfil) {
        if (perfil != null) {
            com.kruma.core.security.SecurityManager.CrearSession(perfil.getId());
        }
    }

    private void GenerarTokkenFacebook() {
        com.kruma.core.security.SecurityManager.ActualizarToken(
                com.kruma.core.security.SecurityManager.getUsuario(), new ProcessCallback<ProcessResult>() {
                    @Override
                    public void success(ProcessResult obj_pResultado) {
                    }
                    @Override
                    public void failure(ProcessResult obj_pResultado) {
                        //Toast.makeText(App.getContext(), "Error al ingresar con Facebook", Toast.LENGTH_LONG).show();
                    }
                });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    private void Login() {
        com.kruma.core.security.SecurityManager.AutenticacionUsuarioToken(
                str_Usuario, str_Clave, new ProcessCallback<SecurityResult>() {
                    @Override
                    public void success(SecurityResult obj_pResultado) {
                        com.kruma.core.security.SecurityManager.CrearSession(str_Usuario.toUpperCase());
                        ObtenerUsuario();
                    }

                    @Override
                    public void failure(ProcessResult obj_pResultado) {
                        Toast.makeText(App.getContext(), "Error en el usuario o contraseña, Intentar nuevamente", Toast.LENGTH_LONG).show();
                    }
                });
    }

    private void RecogerDatosUsuarioFacebook(AccessToken currentAccessToken) {

        GraphRequest request = GraphRequest.newMeRequest(currentAccessToken, new GraphRequest.GraphJSONObjectCallback() {
            @Override
            public void onCompleted(JSONObject object, GraphResponse response) {
                if (response.getError() != null) {
                    Toast.makeText(getApplicationContext(), response.getError().getErrorMessage(), Toast.LENGTH_LONG).show();
                    return;
                }
                try {
                    String nombre = object.getString("first_name");
                    String apellido = object.getString("last_name");
                    String genero = object.getString("gender");
                    String email = object.getString("email");

                    ObtenerUsuarioParaFacebook(nombre, apellido ,genero, email);

                } catch (JSONException e) {
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                    com.kruma.core.security.SecurityManager.CerrarSesion();
                    CerrarFacebook();

                }
            }
        });
        Bundle parameters = new Bundle();
        parameters.putString("fields", "id, first_name, last_name, email, gender, birthday, location");
        request.setParameters(parameters);
        request.executeAsync();
    }

    public void ObtenerUsuario() {
        try {
            // Se realiza la inserción del usuario
            com.kruma.kanta.logical.Usuario.Obtener(
                    str_Usuario,
                    new ProcessCallback<
                            Usuario>() {

                        @Override
                        public void success(com.kruma.kanta.entidad.Usuario obj_pUsuario) {
                            com.kruma.core.security.SecurityManager.setKey(Constante.SESSION_FLAGMOZO,obj_pUsuario.getFlagMozo());
                            com.kruma.core.security.SecurityManager.goToMain();
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

    public void ObtenerUsuarioParaFacebook(final String nombre,final String apellido , final String genero, final String email) {
        try {
            // Se realiza la inserción del usuario
            com.kruma.kanta.logical.Usuario.Obtener(
                    com.kruma.core.security.SecurityManager.getUsuario(),
                    new ProcessCallback<
                            Usuario>() {

                        @Override
                        public void success(com.kruma.kanta.entidad.Usuario obj_pUsuario) {

                            if(obj_pUsuario != null){

                                com.kruma.core.security.SecurityManager.setKey(Constante.SESSION_FLAGMOZO, obj_pUsuario.getFlagMozo());
                                com.kruma.core.security.SecurityManager.goToMain();
                                finish();

                            } else{
                                InsertarUsuarioFacebook(nombre, apellido, genero, email);
                            }

                            GenerarTokkenFacebook();
                        }

                        @Override
                        public void failure(ProcessResult obj_pResultado) {

                           Toast.makeText(App.getContext(), "Error al ingresar con Facebook, Intentar Nuevamente", Toast.LENGTH_LONG).show();
                            com.kruma.core.security.SecurityManager.CerrarSesion();
                            CerrarFacebook();
                        }
                    });

        } catch (Exception ex) {
            Toast.makeText(App.getContext(), "Error al ingresar con Facebook, Intentarlo Nuevamente", Toast.LENGTH_SHORT).show();
            com.kruma.core.security.SecurityManager.CerrarSesion();
            CerrarFacebook();
        }
    }

    private void InsertarUsuarioFacebook(String nombre, String apellido, String genero, String Email) {
        try {
            Usuario obj_Usuario = new Usuario();

            obj_Usuario.setIdUsuario(com.kruma.core.security.SecurityManager.getUsuario());
            obj_Usuario.setNombres(nombre);
            obj_Usuario.setApellidoPaterno(apellido);

            if(genero.equals("male")){
                obj_Usuario.setIdGenero(1);
            } else {
                    obj_Usuario.setIdGenero(2);
                }

            obj_Usuario.setMail(Email);

            // Se realiza la inserción del usuario
            com.kruma.kanta.logical.Usuario.Insertar(
                    obj_Usuario,
                    new ProcessCallback<ProcessResult>() {

                        @Override
                        public void success(ProcessResult obj_pResultado) {
                            com.kruma.core.security.SecurityManager.setKey(Constante.SESSION_FLAGMOZO, "N");
                            com.kruma.core.security.SecurityManager.goToMain();
                            finish();
                        }

                        @Override
                        public void failure(ProcessResult obj_pResultado) {
                            Toast.makeText(App.getContext(), "Error al ingresar con Facebook, Intentar Nuevamente", Toast.LENGTH_LONG).show();
                            com.kruma.core.security.SecurityManager.CerrarSesion();
                            CerrarFacebook();
                        }
                    });

        } catch (Exception ex) {
            Toast.makeText(App.getContext(), "Error al ingresar con Facebook, Intentar Nuevamente", Toast.LENGTH_LONG).show();
            com.kruma.core.security.SecurityManager.CerrarSesion();
            CerrarFacebook();
        }
    }

    public void CerrarFacebook(){
        if(AccessToken.getCurrentAccessToken() != null) {
            LoginManager.getInstance().logOut();
        }
    }

    private boolean ValidarFormulario() {
        str_Usuario = txtUsuario.getText().toString();
        str_Clave = txtClave.getText().toString();

        if (str_Usuario.isEmpty()) {
            txtUsuario.setError("Ingrese usuario");
            return false;
        }
        if (str_Clave.isEmpty()) {
            txtClave.setError("Ingrese clave");
            return false;
        }
        return true;
    }
}
