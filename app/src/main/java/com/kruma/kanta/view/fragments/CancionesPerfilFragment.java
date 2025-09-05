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
import com.kruma.core.util.common.List;
import com.kruma.core.util.common.ProcessCallback;
import com.kruma.core.util.common.ProcessResult;
import com.kruma.kanta.MainActivity;
import com.kruma.kanta.OnNavigationListener;
import com.kruma.kanta.R;
import com.kruma.kanta.entidad.AperturaCancion;
import com.kruma.kanta.view.adapters.CancionHistorialAdapter;

import static com.kruma.kanta.R.id.lstCancionHistorial;

public class CancionesPerfilFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnNavigationListener mListener;
    private static CancionHistorialAdapter cancionHistorialAdapter;
    private static ListView lstCancionMiHistorial;

    public CancionesPerfilFragment() {
        // Required empty public constructor
    }

    public static CancionesPerfilFragment newInstance(String param1, String param2) {
        CancionesPerfilFragment fragment = new CancionesPerfilFragment();
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
        return inflater.inflate(R.layout.fragment_canciones_perfil, container, false);
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

        ((MainActivity) getActivity()).getSupportActionBar().setTitle("MI PERFIL");
        ((MainActivity) getActivity()).getSupportActionBar().setSubtitle("CANCIONES");

        lstCancionMiHistorial = (ListView) getView().findViewById(lstCancionHistorial);


        ListarCancionesPorUsuario();
    }



    public static void ListarCancionesPorUsuario() {

        com.kruma.kanta.logical.Apertura.ListarCancion(
                null,
                null,
                com.kruma.core.security.SecurityManager.getUsuario(),
                null,
                new ProcessCallback<List<AperturaCancion>>() {

                    @Override
                    public void success(List<AperturaCancion> obj_pResultado) {
                        cancionHistorialAdapter = new CancionHistorialAdapter(App.getContext(), obj_pResultado.getResult());
                        lstCancionMiHistorial.setAdapter(cancionHistorialAdapter);


                    }

                    @Override
                    public void failure(ProcessResult obj_pResultado) {
                        Toast.makeText(App.getContext(), obj_pResultado.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
    }
}
