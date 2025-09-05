package com.kruma.kanta.view.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.kruma.core.configuration.App;
import com.kruma.kanta.MainActivity;
import com.kruma.kanta.OnNavigationListener;
import com.kruma.kanta.R;
import com.kruma.kanta.entidad.Turno;
import com.kruma.kanta.view.adapters.TurnosAdapter;

import java.util.ArrayList;
import java.util.List;

public class TurnosFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnNavigationListener mListener;
    private Turno turnoEntity;
    private TurnosAdapter turnosAdapter;
    private ListView lstTurnos;

    public TurnosFragment() {
        // Required empty public constructor
    }

    public static TurnosFragment newInstance(String param1, String param2) {
        TurnosFragment fragment = new TurnosFragment();
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
        return inflater.inflate(R.layout.fragment_turnos, container, false);
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

        ((MainActivity) getActivity()).getSupportActionBar().setTitle("TURNOS");
        ((MainActivity) getActivity()).getSupportActionBar().setSubtitle("TURNOS");

        lstTurnos = (ListView) getView().findViewById(R.id.lstTurnos);

        lstTurnos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(App.getContext(), "pos: " + position, Toast.LENGTH_SHORT).show();
            }
        });

        cargarTurno();
    }

    private void cargarTurno() {

        List<Turno> data = new ArrayList<Turno>();

        data.add(new Turno(1, "Mesa 1", "2:00", R.drawable.iconoalarma));
        data.add(new Turno(2, "Mesa 2", "5:00"));
        data.add(new Turno(3, "Mesa 4", "3:00", R.drawable.iconoalarma));
        data.add(new Turno(4, "Mesa 7", "9:00", R.drawable.iconoalarma));
        data.add(new Turno(5, "Mesa 9", "10:00"));

        turnosAdapter = new TurnosAdapter(App.getContext(), data);
        lstTurnos.setAdapter(turnosAdapter);

    }
}
