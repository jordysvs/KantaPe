package com.kruma.kanta.view.activity;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.kruma.core.configuration.App;
import com.kruma.core.security.entity.SecurityResult;
import com.kruma.core.util.common.ProcessCallback;
import com.kruma.core.util.common.Entity;
import com.kruma.core.util.common.List;
import com.kruma.core.util.common.ProcessResult;
import com.kruma.kanta.R;
import com.kruma.kanta.entidad.Constante;
import com.kruma.kanta.entidad.Usuario;
import com.kruma.kanta.view.fragments.DatePickerFragment;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class RegistroActivity extends AppCompatActivity {

    //region CONTROLES
    private TextView txtUsuario;
    private TextView txtClave;
    private TextView txtNombre;
    private TextView txtApellidoPaterno;
    private TextView txtApellidoMaterno;
    private TextView txtMail;
    private TextView txtFechaNacimiento;
    private Spinner spnEstadoCivil;
    private Spinner spnGenero;
    private Button btnIngresar;
    private Button btnCancelar;
    //endregion

    //SessionManager session;

    //region ATRIBUTOS
    String str_Usuario;
    String str_Clave;
    String str_Nombre;
    String str_ApellidoPaterno;
    String str_ApellidoMaterno;
    String str_Mail;
    String str_FechaNacimiento;
    String str_Genero;
    int int_IdEstadoCivil;
    int int_IdGenero;
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        init();
    }

    private void init() {
        txtUsuario = (EditText) findViewById(R.id.txtUsuarioRegistro);
        txtClave = (EditText) findViewById(R.id.txtClaveRegistro);
        txtNombre = (EditText) findViewById(R.id.txtNombreRegistro);
        //txtApellidoPaterno = (EditText) findViewById(R.id.txtApellidoPaternoRegistro);
        //txtApellidoMaterno = (EditText) findViewById(R.id.txtApellidoMaternoRegistro);
        txtMail = (EditText) findViewById(R.id.txtMailRegistro);
        //txtFechaNacimiento = (TextView) findViewById(R.id.txtFechaNacimientoRegistro);
        //spnEstadoCivil = (Spinner) findViewById(R.id.spnEstadoCivilRegistro);
        //spnGenero = (Spinner) findViewById(R.id.spnGeneroRegistro);
        btnIngresar = (Button) findViewById(R.id.btnIngresarRegistro);
        btnCancelar = (Button) findViewById(R.id.btnCancelarRegistro);



        loadGenero();
        //loadEstadoCivil();

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    if (ValidarFormulario()) {
                        ValidarIngresoDeUsuario();
                    }
                } catch (Exception ex) {

                }
            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void InsertarUsuario() {
        try {
            Usuario obj_Usuario = new Usuario();
            obj_Usuario.setIdUsuario(txtUsuario.getText().toString());
            obj_Usuario.setClave(txtClave.getText().toString());
            obj_Usuario.setNombres(txtNombre.getText().toString());
            //obj_Usuario.setApellidoPaterno(txtApellidoPaterno.getText().toString());
            //obj_Usuario.setApellidoMaterno(txtApellidoMaterno.getText().toString());
            obj_Usuario.setMail(txtMail.getText().toString());

            //int_IdEstadoCivil = ((com.kruma.core.business.entity.EstadoCivil) spnEstadoCivil.getSelectedItem()).getIdEstadoCivil();
            //obj_Usuario.setIdEstadoCivil(int_IdEstadoCivil);

            int_IdGenero = Integer.parseInt(((com.kruma.core.util.common.Entity) spnGenero.getSelectedItem()).getId());
            obj_Usuario.setIdGenero(int_IdGenero);

            if(!str_FechaNacimiento.isEmpty()) {
                obj_Usuario.setFechaNacimientoFormat("yyyy-MM-dd");
                SimpleDateFormat sdf_Formato = new SimpleDateFormat(obj_Usuario.getFechaNacimientoFormat());
                Date dtm_FechaNacimiento = sdf_Formato.parse(str_FechaNacimiento);
                obj_Usuario.setFechaNacimientoString(sdf_Formato.format(dtm_FechaNacimiento));
            }

            // Se realiza la inserción del usuario
            com.kruma.kanta.logical.Usuario.Insertar(
                    obj_Usuario,
                    new ProcessCallback<ProcessResult>() {

                        @Override
                        public void success(ProcessResult obj_pResultado) {
                            Toast.makeText(App.getContext(), "Se registró correctamente", Toast.LENGTH_LONG).show();
                            Login();
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

    private void Login() {
        com.kruma.core.security.SecurityManager.AutenticacionUsuarioToken(
                str_Usuario, str_Clave, new ProcessCallback<SecurityResult>() {
                    @Override
                    public void success(SecurityResult obj_pResultado) {
                        com.kruma.core.security.SecurityManager.CrearSession(str_Usuario.toUpperCase());
                        com.kruma.core.security.SecurityManager.setKey(Constante.SESSION_FLAGMOZO,"N");

                        com.kruma.core.security.SecurityManager.goToMain();
                        finish();

                    }
                    @Override
                    public void failure(ProcessResult obj_pResultado) {
                        Toast.makeText(RegistroActivity.this, "Error en el usuario o contraseña, Intentar nuevamente" , Toast.LENGTH_SHORT).show();
                    }
                });
    }

//    private void goToMain() {
//        session = new SessionManager(getApplicationContext());
//        session.createLoginSession();
//        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//        Constante.TXT_USUARIO_LOGEADO = txtUsuario.getText().toString();
//        Constante.FLAG_MOZO = "N";
//        intent.putExtra("Logeado", str_Usuario);
//        //intent.putExtra("ConstanteMozo", "N");
//        savePreferences();
//        startActivity(intent);
//
//        finish();
//    }

//    public void savePreferences() {
//        com.kruma.core.security.SecurityManager.saveSession(str_Usuario, str_Clave);
//    }

    private boolean ValidarFormulario() {
        str_Usuario = txtUsuario.getText().toString();
        str_Clave = txtClave.getText().toString();
        str_Nombre = txtNombre.getText().toString();
        //str_ApellidoPaterno = txtApellidoPaterno.getText().toString();
        //str_ApellidoMaterno = txtApellidoMaterno.getText().toString();
        str_Mail = txtMail.getText().toString();
        str_FechaNacimiento = txtFechaNacimiento.getText().toString();
        str_Genero = spnGenero.getSelectedItem().toString();

        //Drawable warning = (Drawable) getResources().getDrawable(R.drawable.iconoalarma);
        //Drawable warning = ContextCompat.getDrawable(App.getContext(), R.drawable.iconoalarma);
        //Drawable warning = (Drawable) getResources().getDrawable(R.drawable.iconoalarma);

        if (str_Usuario.isEmpty()) {
            txtUsuario.setError("Debe ingresar su Usuario");
            return false;
        }

        if (str_Clave.isEmpty()) {
            txtClave.setError("Debe ingresar su clave");
            return false;
        }

        if (str_Nombre.isEmpty()) {
            txtNombre.setError("Debe ingresar su Nombre");
            return false;
        }
/*
        if (str_ApellidoPaterno.isEmpty()) {
            txtApellidoPaterno.setError("Debe ingresar su Apellido Paterno");
            return false;
        }
*/
        if (str_Mail.isEmpty()) {
            txtMail.setError("Debe ingresar su Correo electrónico");
            return false;
        }

        if (!str_Mail.matches("[a-zA-Z0-9._-]+@[a-z]+\\.[a-z]+")) {
            txtMail.setError("Verificar si lo ingresado es un correo electrónico");
            return false;
        }


        return true;
    }

    private void loadGenero() {
        //Lista de genero
        com.kruma.core.business.logical.Genero.Listar(
                new ProcessCallback<
                                        List<Entity>>() {
                    @Override
                    public void success(List<Entity> obj_pResultado) {
                        java.util.List<Object> ListaGenero = new ArrayList<>();

                        for (int i = 0; i < obj_pResultado.getResult().size(); i++) {
                            ListaGenero.add(obj_pResultado.getResult().get(i));
                        }
                        //creacion del adapter
                        ArrayAdapter<Object> adapterGenero =
                                new ArrayAdapter<Object>(
                                        RegistroActivity.this,
                                        android.R.layout.simple_spinner_item,
                                        ListaGenero);

                        adapterGenero.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spnGenero.setAdapter(adapterGenero);
                        spnGenero.setSelection(0);
                        //Evento de seleccion del spinner
                        spnGenero.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {
                            }
                        });
                    }

                    @Override
                    public void failure(ProcessResult obj_pResultado) {
                    }
                }
        );
    }
/*
    private void loadEstadoCivil() {
        //Lista de tipo de documento
        com.kruma.core.business.logical.EstadoCivil.Listar(
                null, null, Constante.ESTADO_ACTIVO, null, null,
                new ProcessCallback<
                                        List<
                                                EstadoCivil>>() {
                    @Override
                    public void success(List<EstadoCivil> obj_pResultado) {
                        //creacion del adapter
                        ArrayAdapter<com.kruma.core.business.entity.EstadoCivil> adapterEstadoCivil =
                                new ArrayAdapter<com.kruma.core.business.entity.EstadoCivil>(
                                        RegistroActivity.this,
                                        android.R.layout.simple_spinner_item,
                                        obj_pResultado.getResult());

                        adapterEstadoCivil.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spnEstadoCivil.setAdapter(adapterEstadoCivil);
                        spnEstadoCivil.setSelection(0);

                        //Evento de seleccion del spinner
                        spnEstadoCivil.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {
                            }
                        });
                    }

                    @Override
                    public void failure(ProcessResult obj_pResultado) {

                    }
                }
        );
    }
*/
    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment(txtFechaNacimiento);
        newFragment.show(getFragmentManager(), "datePicker");
    }

    public void ValidarIngresoDeUsuario() {
        try {
            // Se realiza la inserción del usuario
            com.kruma.kanta.logical.Usuario.Obtener(
                   str_Usuario,
                    new ProcessCallback<
                            Usuario>() {
                        @Override
                        public void success(com.kruma.kanta.entidad.Usuario obj_pUsuarioObtenido) {
                            if (obj_pUsuarioObtenido == null) {
                                InsertarUsuario();
                            }
                            else
                                Toast.makeText(App.getContext(), "EL USUARIO INGRESADO YA EXISTE, PRUEBE CON OTRO USUARIO", Toast.LENGTH_LONG).show();
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
