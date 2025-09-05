package com.kruma.kanta.view.fragments;

import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.kruma.core.configuration.App;
import com.kruma.core.util.common.Entity;
import com.kruma.core.util.common.List;
import com.kruma.core.util.common.ProcessCallback;
import com.kruma.core.util.common.ProcessResult;
import com.kruma.kanta.MainActivity;
import com.kruma.kanta.OnNavigationListener;
import com.kruma.kanta.R;
import com.kruma.kanta.entidad.Usuario;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class DatosPerfilFragment extends Fragment {

    //region Controles
    public TextView txtUsuarioPerfil;
    private Spinner spnGeneroPerfil;
    public TextView txtNombrePerfil;
    public TextView txtApellidoPaternoPerfil;
    public TextView txtApellidoMaternoPerfil;
    public TextView txtUsuarioCorreoPerfil;
    public TextView txtFechaNacimientoPerfil;
    private Spinner spnTipoDocumentoPerfil;
    public TextView txtNumeroDocumentoPerfil;
    private Spinner spnEstadoCivilPerfil;
    private Button btnActualizarDatos;
    //endregion

    //region ATRIBUTOS
    String str_Usuario;
    String str_Nombre;
    String str_ApellidoPaterno;
    String str_ApellidoMaterno;
    String str_Mail;
    String str_FechaNacimiento;
    int int_IdEstadoCivil;
    int int_IdGenero;
    //endregion

    private OnNavigationListener mListener;

    public DatosPerfilFragment() {
    }

    public static DatosPerfilFragment newInstance(String param1, String param2) {
        DatosPerfilFragment fragment = new DatosPerfilFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_datos_perfil, container, false);

        //txtUsuarioPerfil = (TextView) view.findViewById(R.id.txtUsuarioPerfil);
        spnGeneroPerfil = (Spinner) view.findViewById(R.id.txtSexoPerfil);
        txtNombrePerfil = (TextView) view.findViewById(R.id.txtNombrePerfil);
        //txtApellidoPaternoPerfil = (TextView) view.findViewById(R.id.txtApellidoPaternoPerfil);
        //txtApellidoMaternoPerfil = (TextView) view.findViewById(R.id.txtApellidoMaternoPerfil);
        txtUsuarioCorreoPerfil = (TextView) view.findViewById(R.id.txtUsuarioCorreoPerfil);
        txtFechaNacimientoPerfil = (TextView) view.findViewById(R.id.txtFechaNacimientoPerfil);
        //spnEstadoCivilPerfil = (Spinner) view.findViewById(R.id.txtEstadoCivilPerfil);
        btnActualizarDatos = (Button) view.findViewById(R.id.btnActualizarDatos);


        //Obtiene la informacion del perfil
        ObtenerPerfil();

        txtFechaNacimientoPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog1();
            }
        });

        btnActualizarDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ValidarFormulario()) {
                    ActualizarUsuario();
                }
            }
        });

        //txtUsuarioPerfil.setText(Constante.TXT_USUARIO_LOGEADO);
        return view;
    }

    private void loadGenero(final int IdGenero) {
        //Lista de genero
        com.kruma.core.business.logical.Genero.Listar(
                new ProcessCallback<List<Entity>>() {
                    @Override
                    public void success(List<Entity> obj_pResultado) {
                        java.util.List<Object> ListaGenero = new ArrayList<>();
                        for (int i = 0; i < obj_pResultado.getResult().size(); i++) {
                            ListaGenero.add(obj_pResultado.getResult().get(i));
                        }
                        //ListaGenero.add(0, "Ingrese género");
                        //creacion del adapter
                        ArrayAdapter<Object> adapterGenero =
                                new ArrayAdapter<Object>(
                                        getActivity(),
                                        //android.R.layout.simple_spinner_item,
                                        R.layout.spinner_personalizado_blanco,
                                        ListaGenero);

                        adapterGenero.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spnGeneroPerfil.setAdapter(adapterGenero);
                        spnGeneroPerfil.setSelection(IdGenero-1);

                        //Evento de seleccion del spinner
                        spnGeneroPerfil.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
    private void loadEstadoCivil(final int IdEstadoCivil) {

        //Lista de tipo de documento
        com.kruma.core.business.logical.EstadoCivil.Listar(
                IdEstadoCivil, null, Constante.ESTADO_ACTIVO, null, null,
                new ProcessCallback<List<EstadoCivil>>() {

                    @Override
                    public void success(List<EstadoCivil> obj_pResultado) {
                        //creacion del adapter
                        ArrayAdapter<com.kruma.core.business.entity.EstadoCivil> adapterEstadoCivil =
                                new ArrayAdapter<com.kruma.core.business.entity.EstadoCivil>(
                                        getActivity(),
                                        R.layout.spinner_personalizado_blanco,
                                        //android.R.layout.simple_spinner_item,
                                        obj_pResultado.getResult());

                        adapterEstadoCivil.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spnEstadoCivilPerfil.setAdapter(adapterEstadoCivil);
                        spnEstadoCivilPerfil.setSelection(0);

                        //Evento de seleccion del spinner
                        spnEstadoCivilPerfil.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnNavigationListener) {
            mListener = (OnNavigationListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public void ObtenerPerfil() {
        try {
            // Se realiza la inserción del usuario
            com.kruma.kanta.logical.Usuario.Obtener(
                    //Constante.TXT_USUARIO_LOGEADO,
                    com.kruma.core.security.SecurityManager.getUsuario(),
                    new ProcessCallback<Usuario>() {

                        @Override
                        public void success(com.kruma.kanta.entidad.Usuario obj_pUsuario) {
                            //Se establece los valores del formulario
                            txtNombrePerfil.setText(obj_pUsuario.getNombreCompleto());
                            //txtApellidoPaternoPerfil.setText(obj_pUsuario.getApellidoPaterno());
                            //txtApellidoMaternoPerfil.setText(obj_pUsuario.getApellidoMaterno());
                            txtUsuarioCorreoPerfil.setText(obj_pUsuario.getMail());

                            if (obj_pUsuario.getFechaNacimiento() != null) {
                                SimpleDateFormat sdf_Formato = new SimpleDateFormat("yyyy-MM-dd");
                                txtFechaNacimientoPerfil.setText(sdf_Formato.format(obj_pUsuario.getFechaNacimiento()));
                            }

                            //Carga el combo de genero
                            loadGenero(obj_pUsuario.getIdGenero());

                            //Carga el combo de estado civil
                            //loadEstadoCivil(obj_pUsuario.getIdEstadoCivil());

                            //spnGeneroPerfil.getItemAtPosition(obj_pUsuario.getIdGenero());
                            //spnEstadoCivilPerfil.getItemAtPosition(obj_pUsuario.getIdEstadoCivil());
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

    private boolean ValidarFormulario() {
        //Se obtiene los valores del formulario
        //str_Usuario = txtUsuarioPerfil.getText().toString();
        str_Nombre = txtNombrePerfil.getText().toString();
        //str_ApellidoPaterno = txtApellidoPaternoPerfil.getText().toString();
        //str_ApellidoMaterno = txtApellidoMaternoPerfil.getText().toString();
        str_Mail = txtUsuarioCorreoPerfil.getText().toString();
        str_FechaNacimiento = txtFechaNacimientoPerfil.getText().toString();

        if (str_Nombre.isEmpty()) {
            txtNombrePerfil.setError("Debe ingresar su Nombre");
            return false;
        }
/*
        if (str_ApellidoPaterno.isEmpty()) {
            txtApellidoPaternoPerfil.setError("Debe ingresar su Apellido Paterno");
            return false;
        }
*/
        if (str_Mail.isEmpty()) {
            txtUsuarioCorreoPerfil.setError("Debe ingresar su Correo electrónico");
            return false;
        }

        if (!str_Mail.matches("[a-zA-Z0-9._-]+@[a-z]+\\.[a-z]+")) {
            txtUsuarioCorreoPerfil.setError("Verificar si lo ingresado es un correo electrónico");
            return false;
        }
        return true;
    }

    private void ActualizarUsuario() {
        try {
            Usuario obj_Usuario = new Usuario();

            obj_Usuario.setIdUsuario(com.kruma.core.security.SecurityManager.getUsuario());
            obj_Usuario.setNombres(txtNombrePerfil.getText().toString());
            //obj_Usuario.setApellidoPaterno(txtApellidoPaternoPerfil.getText().toString());
            //obj_Usuario.setApellidoMaterno(txtApellidoMaternoPerfil.getText().toString());
            obj_Usuario.setMail(txtUsuarioCorreoPerfil.getText().toString());
/*
            int_IdEstadoCivil = ((com.kruma.core.business.entity.EstadoCivil) spnEstadoCivilPerfil.getSelectedItem()).getIdEstadoCivil();
            obj_Usuario.setIdEstadoCivil(int_IdEstadoCivil);
*/
            int_IdGenero = Integer.parseInt(((com.kruma.core.util.common.Entity) spnGeneroPerfil.getSelectedItem()).getId());
            obj_Usuario.setIdGenero(int_IdGenero);

            if(!str_FechaNacimiento.isEmpty()) {
                obj_Usuario.setFechaNacimientoFormat("yyyy-MM-dd");
                SimpleDateFormat sdf_Formato = new SimpleDateFormat(obj_Usuario.getFechaNacimientoFormat());
                Date dtm_FechaNacimiento = sdf_Formato.parse(str_FechaNacimiento);
                obj_Usuario.setFechaNacimientoString(sdf_Formato.format(dtm_FechaNacimiento));
            }
            // Se realiza la inserción del usuario
            com.kruma.kanta.logical.Usuario.Modificar(
                    obj_Usuario,
                    new ProcessCallback<ProcessResult>() {
                        @Override
                        public void success(ProcessResult obj_pResultado) {
                            Toast.makeText(App.getContext(), obj_pResultado.getMessage(), Toast.LENGTH_LONG).show();
                            //Toast.makeText(App.getContext(), "Si funciono", Toast.LENGTH_LONG).show();
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
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("MI PERFIL");
        ((MainActivity) getActivity()).getSupportActionBar().setSubtitle("DATOS");
    }

    public void showDatePickerDialog1() {
        DialogFragment newFragment = new DatePickerFragment(txtFechaNacimientoPerfil);
        newFragment.show(getActivity().getFragmentManager(), "datePicker");
    }

}
