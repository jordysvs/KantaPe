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
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.kruma.core.configuration.App;
import com.kruma.core.util.common.List;
import com.kruma.core.util.common.ProcessCallback;
import com.kruma.core.util.common.ProcessResult;
import com.kruma.kanta.MainActivity;
import com.kruma.kanta.OnNavigationListener;
import com.kruma.kanta.R;
import com.kruma.kanta.ScanActivity;
import com.kruma.kanta.entidad.AperturaUsuario;
import com.kruma.kanta.entidad.Constante;
import com.kruma.kanta.entidad.Oferta;

import com.kruma.kanta.view.adapters.OfertaAdapter;

import me.relex.circleindicator.CircleIndicator;

//Para el Onclick  implements View.OnClickListener
//implements View.OnTouchListener
public class OfertasFragment extends Fragment {


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OfertaAdapter ofertaAdapter;

    private ViewPager lstOferta;

    private CircleIndicator indicator;


    Button btnAperturarMesa;

    //Apk
    //Verificacion de la apertura de la mesa
    public boolean bln_Termino;

    private OfertasFragment.VerificarAperturaDialog dg_gProceso;
    public static ProgressBar mProgressBar;

    //Para esperar la respuesta del servidor
    private Handler puente = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            //Mostramos el mensage recibido del servido en pantalla
            Toast.makeText(App.getContext(), "Su Apertura fue exitosa",
                    Toast.LENGTH_LONG).show();
        }
    };
    //FIN ScanActivity

    private OnNavigationListener mListener;

    public OfertasFragment() {
        // Required empty public constructor
    }

    public static OfertasFragment newInstance(String param1, String param2) {
        OfertasFragment fragment = new OfertasFragment();
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
        return inflater.inflate(R.layout.fragment_ofertas, container, false);

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

        //if (Constante.ID_LOCAL != null) {
        if (com.kruma.core.security.SecurityManager.getKey(Constante.SESSION_IDLOCAL) != null) {
            ((MainActivity) getActivity()).getSupportActionBar().setSubtitle("OFERTAS");
        }
        ((MainActivity) getActivity()).getSupportActionBar().setSubtitle("NOVEDADES");
        mProgressBar = (ProgressBar) getActivity().findViewById(R.id.progress_bar);
        //LinearLayoutManager layoutManager = new LinearLayoutManager(App.getContext(), LinearLayoutManager.HORIZONTAL, false);
        lstOferta = (ViewPager) getView().findViewById(R.id.lstOferta);

        indicator = (CircleIndicator) getView().findViewById(R.id.indicator);

        btnAperturarMesa = (Button) getView().findViewById(R.id.btnAperturarMesa);

        btnAperturarMesa.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent in = new Intent(App.getContext(), ScanActivity.class);
                startActivity(in);
            }
        });

        //Cuando la mesa esta aperturada
        if (com.kruma.core.security.SecurityManager.getKey(Constante.SESSION_IDLOCAL) != null) {
           // cargarOferta();
            btnAperturarMesa.setVisibility(View.INVISIBLE);
        }
        //Mesa sin aperturar
        else {
            //indicator.setVisibility(View.INVISIBLE);
            //
           ListarOferta();
           btnAperturarMesa.setVisibility(View.INVISIBLE);
        }

        bln_Termino = false;

        //if (Constante.ID_LOCAL != null) {
        if (com.kruma.core.security.SecurityManager.getKey(Constante.SESSION_IDLOCAL) != null) {
            dg_gProceso = new OfertasFragment.VerificarAperturaDialog();
            dg_gProceso.execute();
        }

    }

//Metodo para la validacion de la apertura

    private class VerificarAperturaDialog extends AsyncTask<Void, Integer, Boolean> {

        private void ObtenerAperturaUsuario() {
            bln_Termino = false;
            com.kruma.kanta.logical.AperturaUsuario.ObtenerEstadoAperturaUsuario(
                    //Integer.parseInt(Constante.ID_LOCAL),
                    com.kruma.core.security.SecurityManager.getKeyInteger(Constante.SESSION_IDLOCAL),
                    //Constante.ID_APERTURA,
                    com.kruma.core.security.SecurityManager.getKeyInteger(Constante.SESSION_IDAPERTURA),
                    //Constante.ID_APERTURA_USUARIO,
                    com.kruma.core.security.SecurityManager.getKeyInteger(Constante.SESSION_IDAPERTURAUSUARIO),
                    //Constante.TXT_USUARIO_LOGEADO,
                    com.kruma.core.security.SecurityManager.getUsuario(),
                    new ProcessCallback<AperturaUsuario>() {
                        @Override
                        public void success(AperturaUsuario obj_pResultado) {

                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            if (obj_pResultado != null) {
                                if (obj_pResultado.getEstado().equals(Constante.ESTADO_ACTIVO)) {
                                    //guardar en memoria la informacion de la apertura

                                    bln_gFinalizar = true;

                                } else if (obj_pResultado.getEstado().equals(Constante.ESTADO_RECHAZADO)) {
                                    //Toast.makeText(App.getContext(), "Su solicitud de Apertura a sido rechazada por el Administrador", Toast.LENGTH_SHORT).show();

                                    bln_gFinalizar = true;
                                    //*Constante.ID_LOCAL = null;
                                    com.kruma.core.security.SecurityManager.setKey(Constante.SESSION_IDLOCAL, null);

                                    Intent intent = new Intent(App.getContext(), MainActivity.class);
                                    //intent.putExtra("Logeado", Constante.TXT_USUARIO_LOGEADO);
                                    //Constante.ID_LOCAL = null;
                                    startActivity(intent);
                                } else if (obj_pResultado.getEstado().equals(Constante.ESTADO_PENDIENTE)) {
                                    //Constante.ID_APERTURA_USUARIO = obj_pResultado.getIdAperturaUsuario();
                                    com.kruma.core.security.SecurityManager.setKey(Constante.SESSION_IDAPERTURAUSUARIO, String.valueOf(obj_pResultado.getIdAperturaUsuario()));
                                    bln_gFinalizar = false;
                                } else if (obj_pResultado.getEstado().equals(Constante.ESTADO_INACTIVO)) {
                                    Toast.makeText(App.getContext(), "Su solicitud de apertura a sido inactivada  por el administrador", Toast.LENGTH_SHORT).show();

                                    bln_gFinalizar = true;
                                    //Intent intent = new Intent(App.getContext(), MainActivity.class);
                                    //intent.putExtra("Logeado", Constante.TXT_USUARIO_LOGEADO);
                                    //Constante.ID_LOCAL = null;
                                    com.kruma.core.security.SecurityManager.setKey(Constante.SESSION_IDLOCAL, null);
                                    //startActivity(intent);
                                }
                            }
                            bln_Termino = true;
                        }

                        @Override
                        public void failure(ProcessResult obj_pResultado) {
                            Toast.makeText(App.getContext(), "Se produjo un error en la espera de la solicitud", Toast.LENGTH_SHORT).show();
                            bln_Termino = true;
                            OfertasFragment.VerificarAperturaDialog.this.cancel(true);
                        }
                    });

        }

        public boolean bln_gFinalizar = false;

        @Override
        protected Boolean doInBackground(Void... params) {
            while (!bln_gFinalizar) {
                ObtenerAperturaUsuario();
                while (!bln_Termino) {
                    if (isCancelled())
                        break;
                }
                if (isCancelled())
                    break;
            }
            return true;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {

        }

        @Override
        protected void onPreExecute() {
/*
            btnCancelarApertura.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    RespuestaAperturaAdministradorActivity.RespuestaAperturaDialog.this.cancel(true);
                }
            });
            */
        }

        @Override
        protected void onPostExecute(Boolean result) {
            if (result) {
                //Toast.makeText(RespuestaAperturaActivity.this, "Mesa Aperturada", Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        protected void onCancelled() {

        }

    }

    private void ListarOferta() {
        mProgressBar.setVisibility(View.VISIBLE);
        com.kruma.kanta.logical.Oferta.ListarOfertaPromocion(
                new ProcessCallback<List<Oferta>>() {
            @Override
            public void success(List<Oferta> obj_pResultado) {

                ofertaAdapter = new OfertaAdapter(App.getContext(), obj_pResultado.getResult());
                lstOferta.setAdapter(ofertaAdapter);
                indicator.setViewPager(lstOferta);
                mProgressBar.setVisibility(View.GONE);
            }

            @Override
            public void failure(ProcessResult obj_pResultado) {
                mProgressBar.setVisibility(View.GONE);
            }
        });
    }
}
