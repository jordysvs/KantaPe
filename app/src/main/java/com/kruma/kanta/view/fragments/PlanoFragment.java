package com.kruma.kanta.view.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kruma.kanta.MainActivity;
import com.kruma.kanta.OnNavigationListener;
import com.kruma.kanta.R;
import com.kruma.kanta.entidad.TouchImageView;

public class PlanoFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    TouchImageView iviPlano;
    private OnNavigationListener mListener;

    public PlanoFragment() {
        // Required empty public constructor
    }

    public static PlanoFragment newInstance(String param1, String param2) {
        PlanoFragment fragment = new PlanoFragment();
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
        return inflater.inflate(R.layout.fragment_plano, container, false);
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
        ((MainActivity) getActivity()).getSupportActionBar().setSubtitle("PLANO");

        iviPlano = (TouchImageView) getView().findViewById(R.id.iviPlano);

        //TouchImageView iv = new TouchImageView(App.getContext());
        //iviPlano.setImageResource(R.mipmap.iconoplanokaraoke);
        //setContentView(iv);

        iviPlano.setImageResource(R.mipmap.iconoplanokaraoke);
        //iviPlano.setScaleType(ImageView.ScaleType.FIT_XY);
        iviPlano.setMaxZoom(2f);
        iviPlano.setMinZoom(1f);
        iviPlano.setMinimumWidth(R.dimen.plano_ancho);
        iviPlano.setMinimumHeight(R.dimen.plano_alto);
    }
}
