package com.kruma.kanta.view.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.kruma.core.configuration.App;
import com.kruma.core.util.common.ProcessCallback;
import com.kruma.core.util.common.ProcessResult;
import com.kruma.kanta.MainActivity;
import com.kruma.kanta.OnNavigationListener;
import com.kruma.kanta.R;
import com.kruma.kanta.entidad.AperturaCancion;
import com.kruma.kanta.entidad.Constante;
import com.kruma.kanta.view.adapters.CancionMiListaCantadasAdapter;

public class MiListaMesaCantadasFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnNavigationListener mListener;
    private static CancionMiListaCantadasAdapter cancionMiListaCantadasAdapter;
    private static ListView lstCancionMiLista;

    public MiListaMesaCantadasFragment() {
        // Required empty public constructor
    }

    public static MiListaMesaCantadasFragment newInstance(String param1, String param2) {
        MiListaMesaCantadasFragment fragment = new MiListaMesaCantadasFragment();
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
        return inflater.inflate(R.layout.fragment_mi_lista_cantadas_mesa, container, false);
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

        ((MainActivity) getActivity()).getSupportActionBar().setTitle("MI MESA");
        ((MainActivity) getActivity()).getSupportActionBar().setSubtitle("CANTADAS");

        lstCancionMiLista = (ListView) getView().findViewById(R.id.lstCancionMiListaCantadas);

        ListarCancionesPorUsuario();
    }


    public static void ListarCancionesPorUsuario() {
       com.kruma.kanta.logical.Apertura.ListarCancion(
               //Integer.parseInt(Constante.ID_LOCAL),
               com.kruma.core.security.SecurityManager.getKeyInteger(Constante.SESSION_IDLOCAL),
               //Constante.ID_APERTURA,
               com.kruma.core.security.SecurityManager.getKeyInteger(Constante.SESSION_IDAPERTURA),
               null, 3,
       // com.kruma.kantape.logical.Apertura.ListarCancion(1, 38, null,3,
                new ProcessCallback<com.kruma.core.util.common.List<AperturaCancion>>() {

                    @Override
                    public void success(com.kruma.core.util.common.List<AperturaCancion> obj_pResultado) {
                        cancionMiListaCantadasAdapter= new CancionMiListaCantadasAdapter(App.getContext(), obj_pResultado.getResult());
                        lstCancionMiLista.setAdapter(cancionMiListaCantadasAdapter);

                    }

                    @Override
                    public void failure(ProcessResult obj_pResultado) {
                        Toast.makeText(App.getContext(), obj_pResultado.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
    }
}

