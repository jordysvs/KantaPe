package com.kruma.kanta.view.fragments;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.kruma.core.configuration.App;
import com.kruma.core.util.common.List;
import com.kruma.core.util.common.ProcessCallback;
import com.kruma.core.util.common.ProcessResult;
import com.kruma.kanta.MainActivity;
import com.kruma.kanta.OnNavigationListener;
import com.kruma.kanta.R;
import com.kruma.kanta.entidad.Constante;
import com.kruma.kanta.entidad.LocalCancion;
import com.kruma.kanta.view.activity.SearchResultsActivity;
import com.kruma.kanta.view.adapters.CancionesAdapter;

public class ListaFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    //region Variables
    private String mParam1;
    private String mParam2;
    public boolean bln_gIsLoading = false;
    public static int int_gNumPagina = 1;
    public static int int_gTamPagina = 10;
    public static String str_gIdGenero = "";
    public static String str_gIdIdioma = "";
    private LocalCancion localCancionEntity;
    private OnNavigationListener mListener;
    public Handler mHandler;
    public View ftView;
    //endregion

    //region Controles
    private static CancionesAdapter cancionesAdapter;
    private static ListView lstCanciones;
    public static TextView txtFiltroGeneroLista;
    public static TextView txtFiltroIdiomaLista;
    //endregion

    //region Constructor
    public ListaFragment() {
    }
    //endregion

    public static ListaFragment newInstance(String param1, String param2) {
        ListaFragment fragment = new ListaFragment();
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
        CancionesIdiomaDialogFragment.ToPrint(com.kruma.kanta.entidad.Constante.SEARCHRESULTS_LISTA);
        CancionesGeneroDialogFragment.ToPrint(com.kruma.kanta.entidad.Constante.SEARCHRESULTS_LISTA);
        SearchResultsActivity.ToPrint(com.kruma.kanta.entidad.Constante.SEARCHRESULTS_LISTA);
        return inflater.inflate(R.layout.fragment_lista, container, false);
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

        ((MainActivity) getActivity()).getSupportActionBar().setTitle("CANCIONERO");
        ((MainActivity) getActivity()).getSupportActionBar().setSubtitle("LISTA");

        lstCanciones = (ListView) getView().findViewById(R.id.lstCancion);
        txtFiltroGeneroLista = (TextView) getView().findViewById(R.id.txtFiltroGeneroLista);
        txtFiltroIdiomaLista = (TextView) getView().findViewById(R.id.txtFiltroIdiomaLista);

        LayoutInflater li = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ftView = li.inflate(R.layout.footer_view, null);
        mHandler = new MyHandler();

        lstCanciones.setOnItemClickListener(onItemClickListener);

        //Constante.CANCIONERO = 1;

        lstCanciones.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
            }
            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if (view.getLastVisiblePosition() == totalItemCount - 1 && lstCanciones.getCount() >= 10 && bln_gIsLoading == false) {
                    bln_gIsLoading = true;
                    Thread thread = new ThreadGetMoreData();
                    thread.start();
                }
            }
        });

        //Session
        //if(Constante.ID_LOCAL != null){
        if(com.kruma.core.security.SecurityManager.getKey(Constante.SESSION_IDLOCAL) != null){
            ListarCancionesPorFiltro(null, null);
        }


        Constante.TXT_FILTRAR_GENERO = null;
        Constante.TXT_FILTRAR_IDIOMA = null;
    }

    private AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Constante.ID_LOCALCANCION = CancionesAdapter.getLocalCancion(position).getIdLocalCancion();
            FragmentManager fmVersion = getFragmentManager();
            CancionesVersionDialogFragment df_CancionesVersionDialogFragment = CancionesVersionDialogFragment.newInstance("Elegir versión");
            df_CancionesVersionDialogFragment.show(fmVersion, "dialog_fragment_canciones_version");
        }
    };

    public static void ListarCancionesPorFiltro(
            final String str_pIdGenero,
            final String str_pIdioma) {
        ListarCancionesPorFiltro(str_pIdGenero, str_pIdioma, 1, null);
    }

    public static void ListarCancionesPorFiltro(
            final String str_pIdGenero,
            final String str_pIdioma,
            final int int_pNumPagina,
            final ProcessCallback<List<com.kruma.kanta.entidad.LocalCancion>> obj_pCallback) {

        str_gIdGenero = str_pIdGenero;
        str_gIdIdioma = str_pIdioma;
        int_gNumPagina = int_pNumPagina;

        com.kruma.kanta.logical.LocalCancion.ListarListaFiltro(
                //Integer.parseInt(Constante.ID_LOCAL),
                com.kruma.core.security.SecurityManager.getKeyInteger(Constante.SESSION_IDLOCAL),
                str_pIdGenero,
                str_pIdioma,
                null,
                int_gNumPagina, int_gTamPagina,
                new ProcessCallback<List<LocalCancion>>() {
                    @Override
                    public void success(List<LocalCancion> obj_pResultado) {
                        if (obj_pCallback == null) {
                            cancionesAdapter = new CancionesAdapter(App.getContext(), obj_pResultado.getResult());
                            lstCanciones.setAdapter(cancionesAdapter);
                        } else {
                            cancionesAdapter.addListItemToAdapter(obj_pResultado.getResult());
                            obj_pCallback.success(obj_pResultado);
                        }

                        if (Constante.TXT_FILTRAR_GENERO != null) {
                            if (!Constante.TXT_FILTRAR_GENERO.equals("")) {
                                txtFiltroGeneroLista.setText("Genero  : " + Constante.TXT_FILTRAR_GENERO);
                            }
                        }
                        if (Constante.TXT_FILTRAR_IDIOMA != null) {
                            if (!Constante.TXT_FILTRAR_IDIOMA.equals("")) {
                                txtFiltroIdiomaLista.setText("Idioma  : " + Constante.TXT_FILTRAR_IDIOMA);
                            }
                        }
                    }

                    @Override
                    public void failure(ProcessResult obj_pResultado) {
                        if (obj_pCallback != null)
                            obj_pCallback.failure(obj_pResultado);
                    }
                });
    }

    public class MyHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    lstCanciones.addFooterView(ftView);
                    break;
                case 1:
                    lstCanciones.removeFooterView(ftView);
                    bln_gIsLoading = false;
                    break;
                default:
                    break;
            }
        }
    }

    public class ThreadGetMoreData extends Thread {
        @Override
        public void run() {
            mHandler.sendEmptyMessage(0);
            int int_NumPagina = (int_gNumPagina + 1);
            ListarCancionesPorFiltro(str_gIdGenero, str_gIdIdioma, int_NumPagina, new ProcessCallback<List<LocalCancion>>() {
                @Override
                public void success(List<LocalCancion> obj_pResultado) {
                    Message msg = mHandler.obtainMessage(1);
                    mHandler.sendMessage(msg);
                }
                @Override
                public void failure(ProcessResult obj_pResultado) {
                    Message msg = mHandler.obtainMessage(1);
                    mHandler.sendMessage(msg);
                }
            });
        }
    }
}