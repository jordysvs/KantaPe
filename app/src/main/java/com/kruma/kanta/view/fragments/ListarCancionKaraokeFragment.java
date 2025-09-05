package com.kruma.kanta.view.fragments;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.kruma.core.configuration.App;
import com.kruma.core.util.common.List;
import com.kruma.core.util.common.ProcessCallback;
import com.kruma.core.util.common.ProcessResult;
import com.kruma.kanta.KaraokesActivity;
import com.kruma.kanta.MainActivity;
import com.kruma.kanta.OnNavigationListener;
import com.kruma.kanta.R;
import com.kruma.kanta.entidad.Constante;
import com.kruma.kanta.entidad.LocalCancion;
import com.kruma.kanta.view.activity.SearchResultsActivity;
import com.kruma.kanta.view.adapters.CancionesAdapter;

public class ListarCancionKaraokeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
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
    public static String str_gPalabraClave = "";
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
    public static ProgressBar mProgressBar;
    //endregion

    //region Constructor
    public ListarCancionKaraokeFragment() {
    }
    //endregion

    public static ListarCancionKaraokeFragment newInstance(String param1, String param2) {
        ListarCancionKaraokeFragment fragment = new ListarCancionKaraokeFragment();
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
        CancionesIdiomaDialogFragment.ToPrint(Constante.SEARCHRESULTS_LISTAR_CANCION_KARAOKES);
        CancionesGeneroDialogFragment.ToPrint(Constante.SEARCHRESULTS_LISTAR_CANCION_KARAOKES);
        SearchResultsActivity.ToPrint(Constante.SEARCHRESULTS_LISTAR_CANCION_KARAOKES);

        return inflater.inflate(R.layout.fragment_listar_cancion_karaoke, container, false);
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
        ((KaraokesActivity) getActivity()).getSupportActionBar().setSubtitle("CANCIONERO");

        mProgressBar = (ProgressBar) getActivity().findViewById(R.id.progress_bar);

        lstCanciones = (ListView) getView().findViewById(R.id.lstCancion);
        txtFiltroGeneroLista = (TextView) getView().findViewById(R.id.txtFiltroGeneroLista);
        txtFiltroIdiomaLista = (TextView) getView().findViewById(R.id.txtFiltroIdiomaLista);

        LayoutInflater li = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ftView = li.inflate(R.layout.footer_view, null);
        mHandler = new MyHandler();

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

        Constante.TXT_FILTRAR_GENERO = null;
        Constante.TXT_FILTRAR_IDIOMA = null;
        ListarCancionesPorFiltro(null, null, null);
    }

    public static void ListarCancionesPorFiltro(
            final String str_pIdGenero,
            final String str_pIdioma,
            final String str_gPalabraClave) {
        ListarCancionesPorFiltro(str_pIdGenero, str_pIdioma, str_gPalabraClave, 1, null);
    }

    public static void ListarCancionesPorFiltro(
            final String str_pIdGenero,
            final String str_pIdioma,
            final String str_pPalabraClave,
            final int int_pNumPagina,
            final ProcessCallback<List<LocalCancion>> obj_pCallback) {

        str_gIdGenero = str_pIdGenero;
        str_gIdIdioma = str_pIdioma;
        str_gPalabraClave = str_pPalabraClave;
        int_gNumPagina = int_pNumPagina;

        if (obj_pCallback == null)
            mProgressBar.setVisibility(View.VISIBLE);

        com.kruma.kanta.logical.LocalCancion.ListarListaFiltro(
                //Integer.parseInt(Constante.ID_LOCAL),
                com.kruma.core.security.SecurityManager.getKeyInteger(Constante.SESSION_IDKARAOKE),
                str_pIdGenero,
                str_pIdioma,
                str_pPalabraClave,
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
                        if (obj_pCallback == null)
                            mProgressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void failure(ProcessResult obj_pResultado) {
                        if (obj_pCallback != null)
                            obj_pCallback.failure(obj_pResultado);
                        if (obj_pCallback == null)
                            mProgressBar.setVisibility(View.GONE);

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
            ListarCancionesPorFiltro(str_gIdGenero, str_gIdIdioma, str_gPalabraClave, int_NumPagina, new ProcessCallback<List<LocalCancion>>() {
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