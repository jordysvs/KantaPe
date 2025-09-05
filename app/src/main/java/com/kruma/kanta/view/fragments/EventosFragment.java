package com.kruma.kanta.view.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.kruma.kanta.MainActivity;
import com.kruma.kanta.OnNavigationListener;
import com.kruma.kanta.R;
import com.kruma.kanta.entidad.TouchImageView;

public class EventosFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    //ListView lstEvento;
    //EventoAdapter eventoAdapter;
    TouchImageView iviEvento;
    TouchImageView iviEvento2;
    private OnNavigationListener mListener;

    public EventosFragment() {
        // Required empty public constructor
    }

    public static EventosFragment newInstance(String param1, String param2) {
        EventosFragment fragment = new EventosFragment();
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
        return inflater.inflate(R.layout.fragment_eventos, container, false);
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
        ((MainActivity) getActivity()).getSupportActionBar().setSubtitle("EVENTOS");

        //lstEvento = (ListView)getView().findViewById(R.id.lstEvento);
        //lstEvento.setOnItemClickListener(onItemClickListener);
        //cargarEvento();

        iviEvento = (TouchImageView) getView().findViewById(R.id.iviEvento);

        iviEvento.setImageResource(R.mipmap.evento);
        iviEvento.setScaleType(ImageView.ScaleType.FIT_XY);
        iviEvento.setMaxZoom(2f);
        iviEvento.setMinZoom(1f);
        iviEvento.setMinimumWidth(R.dimen.plano_ancho);
        iviEvento.setMinimumHeight(R.dimen.plano_alto);

    }

    /*
    AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        }
    };
    */

    /*
    private void cargarEvento() {

        com.kruma.kantape.logical.Evento.ListarEvento(new ProcessCallback<List<Evento>>() {
            @Override
            public void success(ServiceResult<List<Evento>> obj_pServiceResult) {
                eventoAdapter = new EventoAdapter(App.getContext(), obj_pServiceResult.getResultado().getResult());
                lstEvento.setAdapter(eventoAdapter);
                Toast.makeText(App.getContext(), "Lista de eventos cargada", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void failure(ServiceResult<List<Evento>> obj_pServiceResult) {

            }
        });
    }
    */
}
