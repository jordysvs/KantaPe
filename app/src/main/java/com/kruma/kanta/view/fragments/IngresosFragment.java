package com.kruma.kanta.view.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
//import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.kruma.core.configuration.App;
import com.kruma.core.util.common.ProcessCallback;
import com.kruma.core.util.common.List;
import com.kruma.core.util.common.ProcessResult;
import com.kruma.kanta.MainActivity;
import com.kruma.kanta.OnNavigationListener;
import com.kruma.kanta.R;
import com.kruma.kanta.entidad.Constante;
import com.kruma.kanta.entidad.LocalCancion;
import com.kruma.kanta.view.activity.SearchResultsActivity;
import com.kruma.kanta.view.adapters.NovedadesAdapter;

public class IngresosFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    private OnNavigationListener mListener;
    private LocalCancion localCancionEntity;
    private static NovedadesAdapter novedadesAdapter;

    private static ListView lstNovedades;

    public static TextView txtFiltroGeneroIngresos;
    public static TextView txtFiltroIdiomaIngresos;

    public IngresosFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment IngresosFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static IngresosFragment newInstance(String param1, String param2) {
        IngresosFragment fragment = new IngresosFragment();
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

        CancionesIdiomaDialogFragment.ToPrint(com.kruma.kanta.entidad.Constante.SEARCHRESULTS_INGRESOS);
        CancionesGeneroDialogFragment.ToPrint(com.kruma.kanta.entidad.Constante.SEARCHRESULTS_INGRESOS);
        SearchResultsActivity.ToPrint(com.kruma.kanta.entidad.Constante.SEARCHRESULTS_INGRESOS);
        return inflater.inflate(R.layout.fragment_ingresos, container, false);

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
        ((MainActivity) getActivity()).getSupportActionBar().setSubtitle("INGRESOS");

        lstNovedades = (ListView) getView().findViewById(R.id.lstCancion);

        txtFiltroGeneroIngresos = (TextView) getView().findViewById(R.id.txtFiltroGeneroIngresos);
        txtFiltroIdiomaIngresos = (TextView) getView().findViewById(R.id.txtFiltroIdiomaIngresos);
        lstNovedades.setOnItemClickListener(onItemClickListener);

        CargarNovedades();

    }


    private AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            Constante.ID_LOCALCANCION = NovedadesAdapter.getLocalCancion(position).getIdLocalCancion();

            FragmentManager fmVersion = getFragmentManager();
            CancionesVersionDialogFragment cancionesVersionDialogFragment = CancionesVersionDialogFragment.newInstance("Elegir versión");
            cancionesVersionDialogFragment.show(fmVersion, "dialog_fragment_canciones_version");
        }
    };


    private void CargarNovedades() {

        com.kruma.kanta.logical.LocalCancion.ListarNovedades(
                //Integer.parseInt(Constante.ID_LOCAL),
                com.kruma.core.security.SecurityManager.getKeyInteger(Constante.SESSION_IDLOCAL),
                null, null,
                new ProcessCallback<List<LocalCancion>>() {
                    @Override
                    public void success(List<LocalCancion> obj_pResultado) {
                        Constante.TXT_FILTRAR_IDIOMA = null;
                        Constante.TXT_FILTRAR_GENERO = null;
                        Constante.ID_GENERO = null;
                        Constante.ID_IDIOMA = null;


                        novedadesAdapter = new NovedadesAdapter(App.getContext(), obj_pResultado.getResult());
                        try {
                            lstNovedades.setAdapter(novedadesAdapter);
                        } catch (Exception ex) {
                            String a = "";
                        }
                    }

                    @Override
                    public void failure(ProcessResult obj_pResultado) {

                    }
                });
    }



    public static void ListarCancionesPorFiltro(final String int_IdGenero, final String int_IdIdioma) {
        com.kruma.kanta.logical.LocalCancion.ListarNovedadesFiltro(
                //Integer.parseInt(Constante.ID_LOCAL),
                com.kruma.core.security.SecurityManager.getKeyInteger(Constante.SESSION_IDLOCAL),
                int_IdGenero, int_IdIdioma, null, null, null,
                new ProcessCallback<List<LocalCancion>>() {
                    @Override
                    public void success(List<LocalCancion> obj_pResultado) {
                        novedadesAdapter = new NovedadesAdapter(App.getContext(), obj_pResultado.getResult());
                        lstNovedades.setAdapter(novedadesAdapter);

                        if (Constante.TXT_FILTRAR_GENERO != null) {

                            if (!Constante.TXT_FILTRAR_GENERO.equals("")) {
                                txtFiltroGeneroIngresos.setText("Genero  : " + Constante.TXT_FILTRAR_GENERO);

                            }
                        }

                        if (Constante.TXT_FILTRAR_IDIOMA != null) {

                            if (!Constante.TXT_FILTRAR_IDIOMA.equals("")) {

                                txtFiltroIdiomaIngresos.setText("Idioma  : " + Constante.TXT_FILTRAR_IDIOMA);
                            }
                        }
                    }

                    @Override
                    public void failure(ProcessResult obj_pResultado) {

                    }

                });
    }
}
