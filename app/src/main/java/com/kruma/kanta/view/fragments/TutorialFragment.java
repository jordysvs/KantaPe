package com.kruma.kanta.view.fragments;


import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.kruma.core.configuration.App;

import com.kruma.kanta.MainActivity;
import com.kruma.kanta.OnNavigationListener;
import com.kruma.kanta.R;
import com.kruma.kanta.entidad.TutorialMiLista;
import com.kruma.kanta.view.adapters.TutorialAdapter;

import java.util.ArrayList;
import java.util.List;
import me.relex.circleindicator.CircleIndicator;

//Para el Onclick  implements View.OnClickListener
//implements View.OnTouchListener
public class TutorialFragment extends Fragment {


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    private ViewPager lstTutorial;
    private  TutorialMiLista tutorialMiListaEntity;
    private TutorialAdapter tutorialAdapter;
    private CircleIndicator indicator;




    private OnNavigationListener mListener;

    public TutorialFragment() {
        // Required empty public constructor
    }

    public static TutorialFragment newInstance(String param1, String param2) {
        TutorialFragment fragment = new TutorialFragment();
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
        return inflater.inflate(R.layout.fragment_tutorial, container, false);

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

        ((MainActivity) getActivity()).getSupportActionBar().setTitle("INICIO");
        ((MainActivity) getActivity()).getSupportActionBar().setSubtitle("TUTORIAL");


        lstTutorial = (ViewPager) getView().findViewById(R.id.lstTutorial);
        indicator = (CircleIndicator) getView().findViewById(R.id.indicatorTutorial);

            cargarTutorial();
    }

//Metodo para la validacion de la apertura



    private void cargarTutorial() {

        List<TutorialMiLista> data = new ArrayList<TutorialMiLista>();

         data.add(new TutorialMiLista(1, R.drawable.control_acceso));
        data.add(new TutorialMiLista(2, R.drawable.control_pedidos));
        data.add(new TutorialMiLista(3, R.drawable.control_mesa));
        data.add(new TutorialMiLista(4, R.drawable.solicitud_cancion));

        tutorialAdapter = new TutorialAdapter(App.getContext(), data);

        lstTutorial.setAdapter(tutorialAdapter);

        indicator.setViewPager(lstTutorial);


    }


}
