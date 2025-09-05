package com.kruma.kanta.view.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.kruma.core.configuration.App;
import com.kruma.core.util.common.List;
import com.kruma.core.util.common.ProcessCallback;
import com.kruma.core.util.common.ProcessResult;

import com.kruma.kanta.CancioneroActivity;
import com.kruma.kanta.MainActivity;
import com.kruma.kanta.OnNavigationListener;
import com.kruma.kanta.R;
import com.kruma.kanta.entidad.Constante;
import com.kruma.kanta.entidad.LocalCancion;
import com.kruma.kanta.view.adapters.BuscarCancionesAdapter;

public class BuscarCancionFragment extends Fragment {

    //region Variables
    public boolean bln_gIsLoading = false;

    public static String str_gIdGenero = "";
    public static String str_gIdIdioma = "";
    public static String str_gPalabraClave = "";
    public static int int_gNumPagina = 1;
    public static int int_gTamPagina = 10;

    private OnNavigationListener mListener;
    public Handler mHandler;
    public View ftView;
    //endregion

    //region Controles
    private static BuscarCancionesAdapter buscarCancionesAdapter;
    private static ListView lstCanciones;
    public static TextView txtFiltroGeneroLista;
    public static TextView txtFiltroIdiomaLista;
    public static ProgressBar mProgressBar;
    //endregion

    //region Constructor
    public BuscarCancionFragment() {
    }
    //endregion

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState) {
        CancionesIdiomaDialogFragment.ToPrint(Constante.SEARCHRESULTS_BUSCARCANCION);
        CancionesGeneroDialogFragment.ToPrint(Constante.SEARCHRESULTS_BUSCARCANCION);
        return inflater.inflate(R.layout.fragment_buscar_cancion, container, false);
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
        ((MainActivity) getActivity()).getSupportActionBar().setSubtitle("");

        mProgressBar = (ProgressBar) getActivity().findViewById(R.id.progress_bar);

        lstCanciones = (ListView) getView().findViewById(R.id.lstCancion);
        txtFiltroGeneroLista = (TextView) getView().findViewById(R.id.txtFiltroGeneroLista);
        txtFiltroIdiomaLista = (TextView) getView().findViewById(R.id.txtFiltroIdiomaLista);

        LayoutInflater li = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ftView = li.inflate(R.layout.footer_view, null);
        mHandler = new MyHandler();

        lstCanciones.setOnItemClickListener(onItemClickListener);

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
        ListarCancionesPorFiltro(null, null, null);
        Constante.TXT_FILTRAR_GENERO = null;
        Constante.TXT_FILTRAR_IDIOMA = null;
    }

    private AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            com.kruma.core.security.SecurityManager.setKey(Constante.SESSION_IDLOCAL_CANCION, String.valueOf(BuscarCancionesAdapter.getLocalCancion(position).getIdLocalCancion()));

            Intent intent = new Intent(App.getContext(), CancioneroActivity.class);
            startActivity(intent);
        }
    };

    public static void ListarCancionesPorFiltro(
            final String str_pIdGenero,
            final String str_pIdioma,
            final String str_pPalabraClave) {
        ListarCancionesPorFiltro(str_pIdGenero, str_pIdioma, str_pPalabraClave, 1, null);
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

        com.kruma.kanta.logical.LocalCancion.ListarTodos(
                str_pIdGenero,
                str_pIdioma,
                str_pPalabraClave,
                int_gNumPagina, int_gTamPagina,
                new ProcessCallback<List<LocalCancion>>() {
                    @Override
                    public void success(List<LocalCancion> obj_pResultado) {
                        if (obj_pCallback == null) {
                            buscarCancionesAdapter = new BuscarCancionesAdapter(App.getContext(), obj_pResultado.getResult());
                            lstCanciones.setAdapter(buscarCancionesAdapter);
                        } else {
                            buscarCancionesAdapter.addListItemToAdapter(obj_pResultado.getResult());
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