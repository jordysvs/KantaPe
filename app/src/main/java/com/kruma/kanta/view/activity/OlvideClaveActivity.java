package com.kruma.kanta.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.kruma.core.configuration.App;
import com.kruma.core.util.common.ProcessCallback;
import com.kruma.core.util.common.ProcessResult;
import com.kruma.kanta.LoginActivity;
import com.kruma.kanta.R;

public class OlvideClaveActivity extends AppCompatActivity {

    //region CONTROLES
    private TextView txtUsuario;
    private TextView txtMail;

    private TextInputLayout TextInputLayoutUsuario;
    private TextInputLayout TextInputLayoutClave;

    private Button btnEnviarCorreo;
    private Button btnCancelarEnvioCorreo;
    //endregion

    //region ATRIBUTOS
    String str_Usuario;
    String str_Mail;


    //com.kruma.core.util.common.Entity Genero;
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_olvide_clave);



        init();
    }

    private void init() {



        /*
        // -- Inicio Carga Spinner Tipo documento
        ArrayList<String> array = new ArrayList<String>();
        array.add("Seleccione tipo de documento");
        array.add("DNI");
        array.add("RUC");
        array.add("Pasaporte");
        ArrayAdapter<String> mAdapter;
        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, array);
        spnTipoDocumento.setAdapter(mAdapter);
        // -- Fin Carga Spinner Tipo documento
        */


        btnEnviarCorreo = (Button) findViewById(R.id.btnEnviarCorreo);
        btnCancelarEnvioCorreo = (Button) findViewById(R.id.btnCancelarEnvioCorreo);

        txtUsuario = (TextView) findViewById(R.id.txtUsuarioCorreo);
        txtMail = (TextView) findViewById(R.id.txtMailCorreo);


        /*
        // Ocultar teclado virtual
        InputMethodManager imm1 =
                (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        imm1.hideSoftInputFromWindow(txtMail.getWindowToken(), 0);
*/

        btnEnviarCorreo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ValidarFormulario()) {
                    EnviarCorreoUsuario();
                }

            }
        });

        btnCancelarEnvioCorreo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void EnviarCorreoUsuario() {


        //Se obtiene los valores  del formulario
        //str_NombreCompleto = str_Nombres + " " + str_ApellidoPaterno + " " + str_ApellidoMaterno;

        //Se crea la instancia de la entidad
        // Usuario obj_pUsuario = new Usuario();

        //Se establece los valores
        //obj_pUsuario.setIdUsuario(txtUsuario.getText().toString());
        //obj_pUsuario.setMail(txtMail.getText().toString());


        // Se realiza la inserción del usuario
        com.kruma.core.security.SecurityManager.CambiarContrasenia(
                str_Usuario,
                str_Mail,
                new ProcessCallback<ProcessResult>() {

                    @Override
                    public void success(ProcessResult obj_pResultado) {
                        Intent intent = new Intent(OlvideClaveActivity.this, LoginActivity.class);
                        startActivity(intent);
                        Toast.makeText(App.getContext(), obj_pResultado.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void failure(ProcessResult obj_pResultado) {
                        //   Toast.makeText(LoginActivity.this, obj_pServiceResult.getResultado().getMessage(), Toast.LENGTH_SHORT).show();
                        Toast.makeText(OlvideClaveActivity.this, "Error en el usuario o correo ingresado, Intentar nuevamente", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private boolean ValidarFormulario() {

        str_Usuario = txtUsuario.getText().toString();
        str_Mail = txtMail.getText().toString();

        if (str_Usuario.isEmpty()) {
            txtUsuario.setError("Ingrese usuario");
            return false;

        }

        if (str_Mail.isEmpty()) {
            txtMail.setError("Debe ingresar correo electrónico");
            return false;
        }

        if (!str_Mail.matches("[a-zA-Z0-9._-]+@[a-z]+.[a-z]+")) {
            txtMail.setError("Verificar si lo ingresado es un correo electrónico");
            //Toast.makeText(App.getContext(), "Verificar si lo ingresado es un correo electrónico", Toast.LENGTH_LONG).show();
            return false;
        }
       //else{
         //  Toast.makeText(App.getContext(), "Verificar si es un correo electrónico", Toast.LENGTH_LONG).show();
          //  return false;
        //}





        return true;

    }






}









