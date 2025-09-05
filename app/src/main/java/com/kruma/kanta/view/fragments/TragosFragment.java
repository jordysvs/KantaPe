package com.kruma.kanta.view.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.kruma.core.configuration.App;
import com.kruma.core.util.common.ProcessCallback;
import com.kruma.core.util.common.ProcessResult;
import com.kruma.kanta.KaraokesActivity;
import com.kruma.kanta.MainActivity;
import com.kruma.kanta.OnNavigationListener;
import com.kruma.kanta.R;
import com.kruma.kanta.entidad.AperturaUsuario;
import com.kruma.kanta.entidad.Carta;
import com.kruma.kanta.entidad.Constante;
import com.kruma.kanta.view.activity.SearchResultsActivity;
import com.kruma.kanta.view.adapters.CartaAdapter;

public class TragosFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public static Integer TipoElegido;
    private OnNavigationListener mListener;
    private Carta cartaEntity;

    private static CartaAdapter cartaAdapter;
    private static ListView lstCarta;
    private static TextView txtFiltroCarta;
    Button btnSolicitarPedido;
    public static ProgressBar mProgressBar;
    public static String str_gPalabraClave = "";


    public TragosFragment() {
        // Required empty public constructor
    }

    public static TragosFragment newInstance(String param1, String param2) {
        TragosFragment fragment = new TragosFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

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
        SearchResultsActivity.ToPrint(com.kruma.kanta.entidad.Constante.SEARCHRESULTS_CARTA);

        return inflater.inflate(R.layout.fragment_tragos, container, false);
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
        ((KaraokesActivity) getActivity()).getSupportActionBar().setTitle(com.kruma.core.security.SecurityManager.getKey(Constante.SESSION_NOMBREKARAOKE));
        ((KaraokesActivity) getActivity()).getSupportActionBar().setSubtitle("CARTA");

        mProgressBar = (ProgressBar) getActivity().findViewById(R.id.progress_bar);
        lstCarta = (ListView) getView().findViewById(R.id.lstCarta);
        txtFiltroCarta = (TextView) getView().findViewById(R.id.txtFiltroCarta);
        btnSolicitarPedido = (Button) getView().findViewById(R.id.btnSolicitarPedido);
        btnSolicitarPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObtenerAperturaUsuario();
            }
        });
        btnSolicitarPedido.setVisibility(View.INVISIBLE);

        Constante.TXT_FILTRO_BEBIDA_PIQUEO = 0;

        Constante.ID_PRODUCTO_TIPO = null;

        ListarCartaPorFiltro(null, null);
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
                                SolicitarPedido();
                            } else if (obj_pResultado.getEstado().equals(Constante.ESTADO_RECHAZADO)) {
                                Toast.makeText(App.getContext(), " No puede solicitar pedidos", Toast.LENGTH_SHORT).show();
                            } else if (obj_pResultado.getEstado().equals(Constante.ESTADO_PENDIENTE)) {
                                Toast.makeText(App.getContext(), " No puede solicitar pedidos", Toast.LENGTH_SHORT).show();
                            } else if (obj_pResultado.getEstado().equals(Constante.ESTADO_INACTIVO)) {
                                Toast.makeText(App.getContext(), " No puede solicitar pedidos, Usted fue eliminado de la mesa", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(App.getContext(), MainActivity.class);
                                //intent.putExtra("Logeado", Constante.TXT_USUARIO_LOGEADO);
                                intent.putExtra("Logeado", com.kruma.core.security.SecurityManager.getUsuario());
                                //Constante.ID_LOCAL = null;
                                com.kruma.core.security.SecurityManager.setKey(Constante.SESSION_IDLOCAL, null);
                                startActivity(intent);
                                getActivity().finish();
                            }
                        }
                    }

                    @Override
                    public void failure(ProcessResult obj_pResultado) {
                        Toast.makeText(App.getContext(), "Se produjo un error en la espera de la solicitud", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public void SolicitarPedido() {
        try {
            // Se realiza la inserción del usuario
            com.kruma.kanta.logical.Carta.SolicitarPedido(
                    //Integer.parseInt(Constante.ID_LOCAL),
                    com.kruma.core.security.SecurityManager.getKeyInteger(Constante.SESSION_IDLOCAL),
                    //Integer.parseInt(Constante.ID_UBICACION),
                    com.kruma.core.security.SecurityManager.getKeyInteger(Constante.SESSION_IDUBICACION),
                    //Constante.TXT_USUARIO_LOGEADO,
                    com.kruma.core.security.SecurityManager.getUsuario(),

                    new ProcessCallback<ProcessResult>() {

                        @Override
                        public void success(ProcessResult obj_pResultado) {
                            Toast.makeText(App.getContext(), obj_pResultado.getMessage().toString(), Toast.LENGTH_LONG).show();
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

//    private void cargarCarta() {
//
//        //com.kruma.kanta.logical.Carta.ListarCarta(null, com.kruma.core.security.SecurityManager.getKeyInteger(Constante.SESSION_IDLOCAL), null, null, null, null, null,
//        com.kruma.kanta.logical.Carta.ListarCarta(null, null, null, null, null, null, null,
//                new ProcessCallback<com.kruma.core.util.common.List<Carta>>() {
//                    @Override
//                    public void success(com.kruma.core.util.common.List<Carta> obj_pResultado) {
//
//
//                        cartaAdapter = new CartaAdapter(App.getContext(), obj_pResultado.getResult());
//                        lstCarta.setAdapter(cartaAdapter);
//
//                        Constante.TXT_FILTRO_BEBIDA_PIQUEO = 0;
//                        Constante.ID_PRODUCTO_TIPO = null;
//
//                    }
//
//                    @Override
//                    public void failure(ProcessResult obj_pResultado) {
//
//                    }
//                });
//    }

    public static void ListarCartaPorFiltro(final String idProductoTipo, final String str_PalabraClave) {

        mProgressBar.setVisibility(View.VISIBLE);

        com.kruma.kanta.logical.Carta.ListarCarta(null,  com.kruma.core.security.SecurityManager.getKeyInteger(Constante.SESSION_IDKARAOKE), null, str_PalabraClave, idProductoTipo, null, null,
                new ProcessCallback<com.kruma.core.util.common.List<Carta>>() {
                    @Override
                    public void success(com.kruma.core.util.common.List<Carta> obj_pResultado) {
                        cartaAdapter = new CartaAdapter(App.getContext(), obj_pResultado.getResult());
                        lstCarta.setAdapter(cartaAdapter);
                        if (idProductoTipo.equals("1")) {
                            txtFiltroCarta.setText("Filtro  :  Piqueo");
                        }
                        if (idProductoTipo.equals("2")) {
                            txtFiltroCarta.setText("Filtro  :  Bebida");
                        }
                        mProgressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void failure(ProcessResult obj_pResultado) {
                        mProgressBar.setVisibility(View.GONE);
                    }
                });
    }
}
