package com.kruma.kanta.view.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.kruma.core.configuration.App;
import com.kruma.core.util.common.ProcessCallback;
import com.kruma.core.util.common.ProcessResult;
import com.kruma.kanta.MainActivity;
import com.kruma.kanta.OnNavigationListener;
import com.kruma.kanta.R;
import com.kruma.kanta.entidad.AperturaUsuario;
import com.kruma.kanta.entidad.Constante;
import com.kruma.kanta.entidad.SolicitudCancion;

public class NuevaCancionFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnNavigationListener mListener;
    TextView txtCancion;
    TextView txtArtista;
    TextView txtAlbum;
    TextView txtIdioma;
    TextView txtGenero;
    TextView txtYoutube;
    Button btnEnviar;

    public NuevaCancionFragment() {
        // Required empty public constructor
    }

    public static NuevaCancionFragment newInstance(String param1, String param2) {
        NuevaCancionFragment fragment = new NuevaCancionFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    //android:orientation="vertical"
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_nueva_cancion, container, false);
    }

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

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ((MainActivity) getActivity()).getSupportActionBar().setTitle("NUEVA CANCION");
        ((MainActivity) getActivity()).getSupportActionBar().setSubtitle("NUEVA CANCION");

        // Se inicializan los valores del formulario
        txtCancion = (EditText) getView().findViewById(R.id.txtCancion);
        txtArtista = (EditText) getView().findViewById(R.id.txtArtista);
        txtAlbum = (EditText) getView().findViewById(R.id.txtAlbum);
        txtIdioma = (EditText) getView().findViewById(R.id.txtIdioma);
        txtGenero = (EditText) getView().findViewById(R.id.txtGenero);
        txtYoutube = (EditText) getView().findViewById(R.id.txtYoutube);
        btnEnviar = (Button) getView().findViewById(R.id.btnEnviar);

        btnEnviar.setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            ObtenerAperturaUsuario();
        }
    };

    private boolean validarFormulario() {

        String str_Cancion = txtCancion.getText().toString();
        String str_Artista = txtArtista.getText().toString();
        String str_Album = txtAlbum.getText().toString();
        String str_Idioma = txtIdioma.getText().toString();
        String str_Genero = txtGenero.getText().toString();
        String str_Youtube = txtYoutube.getText().toString();

        if (str_Cancion.isEmpty()) {
            txtCancion.setError("Debe ingresar nombre del título");
            return false;
        }

        if (str_Artista.isEmpty()) {
            txtArtista.setError("Debe ingresar nombre del artista");
            return false;
        }

        /*
        if (str_Album.isEmpty()) {
            Toast.makeText(App.getContext(), "Debe ingresar nombre del album", Toast.LENGTH_LONG).show();
            return false;
        }
        */

        if (str_Idioma.isEmpty()) {
            txtIdioma.setError("Debe ingresar idioma");
            return false;
        }

        if (str_Genero.isEmpty()) {
            txtGenero.setError("Debe ingresar género");
            return false;
        }

        return true;
    }

    public void limpiarFormulario() {

        txtCancion.setText("");
        txtArtista.setText("");
        txtAlbum.setText("");
        txtIdioma.setText("");
        txtGenero.setText("");
        txtYoutube.setText("");

        txtCancion.requestFocus();
    }

    public void insertarSolicitudCancion() {

        try {

            // Se crea una instacia de la entidad SolicitudCancion
            SolicitudCancion obj_pSolicitudCancion = new SolicitudCancion();

            // Se obtienen los valores del formulario
            obj_pSolicitudCancion.setCancion(txtCancion.getText().toString());
            obj_pSolicitudCancion.setArtista(txtArtista.getText().toString());
            obj_pSolicitudCancion.setAlbum(txtAlbum.getText().toString());
            obj_pSolicitudCancion.setIdioma(txtIdioma.getText().toString());
            obj_pSolicitudCancion.setGenero(txtGenero.getText().toString());
            obj_pSolicitudCancion.setYoutube(txtYoutube.getText().toString());

            com.kruma.kanta.logical.SolicitudCancion.Insertar(obj_pSolicitudCancion,
                    new ProcessCallback<ProcessResult>() {
                        @Override
                        public void success(ProcessResult obj_pResultado) {

                            Toast.makeText(App.getContext(), "Solicitud de canción enviada", Toast.LENGTH_LONG).show();

                        }

                        @Override
                        public void failure(ProcessResult obj_pResultado) {
                            Toast.makeText(App.getContext(), obj_pResultado.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });

        } catch (Exception ex) {

        }

    }

    private void ObtenerAperturaUsuario() {

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

                        if (obj_pResultado != null) {
                            if (obj_pResultado.getEstado().equals(Constante.ESTADO_ACTIVO)) {
                                if (validarFormulario()) {
                                    insertarSolicitudCancion();
                                    limpiarFormulario();
                                }
                            } else if (obj_pResultado.getEstado().equals(Constante.ESTADO_RECHAZADO)) {
                                Toast.makeText(App.getContext(), " No puede solicitar Nuevas canciones", Toast.LENGTH_SHORT).show();
                            } else if (obj_pResultado.getEstado().equals(Constante.ESTADO_PENDIENTE)) {
                                Toast.makeText(App.getContext(), "No puede solicitar Nuevas canciones", Toast.LENGTH_SHORT).show();
                            } else if (obj_pResultado.getEstado().equals(Constante.ESTADO_INACTIVO)) {
                                Toast.makeText(App.getContext(), " No puede solicitar Nuevas canciones, Usted fue eliminado de la mesa", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(App.getContext(), MainActivity.class);
                                //intent.putExtra("Logeado", Constante.TXT_USUARIO_LOGEADO);
                                intent.putExtra("Logeado", com.kruma.core.security.SecurityManager.getUsuario());
                                //Constante.ID_LOCAL = null;
                                com.kruma.core.security.SecurityManager.setKey(Constante.SESSION_IDLOCAL, null);
                                startActivity(intent);
                            }
                        }
                    }

                    @Override
                    public void failure(ProcessResult obj_pResultado) {
                        Toast.makeText(App.getContext(), "Se produjo un error en la espera de la solicitud", Toast.LENGTH_SHORT).show();

                    }
                });

    }
}
