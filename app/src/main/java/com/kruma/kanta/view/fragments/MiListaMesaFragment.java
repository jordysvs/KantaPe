package com.kruma.kanta.view.fragments;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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
import com.kruma.kanta.view.adapters.CancionMiListaAdapter;

public class MiListaMesaFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnNavigationListener mListener;
    private static CancionMiListaAdapter cancionMiListaAdapter;
    private static ListView lstCancionMiLista;

    public MiListaMesaFragment() {
        // Required empty public constructor
    }

    public static MiListaMesaFragment newInstance(String param1, String param2) {
        MiListaMesaFragment fragment = new MiListaMesaFragment();
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
        return inflater.inflate(R.layout.fragment_mi_lista_mesa, container, false);
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
        ((MainActivity) getActivity()).getSupportActionBar().setSubtitle("MI LISTA");

        lstCancionMiLista = (ListView) getView().findViewById(R.id.lstCancionMiLista);
       /*
        lstCancionMiLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(App.getContext(), "pos: "  + "\n" + position + "1", Toast.LENGTH_SHORT).show();
            }
        });
        */

        lstCancionMiLista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){

            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                final int idAperturaCancion = CancionMiListaAdapter.getIdAperturaCancion(i);

                com.kruma.kanta.logical.AperturaUsuario.Obtener(
                        //Integer.parseInt(Constante.ID_LOCAL),
                        com.kruma.core.security.SecurityManager.getKeyInteger(Constante.SESSION_IDLOCAL),
                        //Constante.ID_APERTURA,
                        com.kruma.core.security.SecurityManager.getKeyInteger(Constante.SESSION_IDAPERTURA),
                        //Constante.ID_APERTURA_USUARIO,
                        com.kruma.core.security.SecurityManager.getKeyInteger(Constante.SESSION_IDAPERTURAUSUARIO),
                        //Constante.TXT_USUARIO_LOGEADO,
                        com.kruma.core.security.SecurityManager.getUsuario(),
                        new ProcessCallback<com.kruma.kanta.entidad.AperturaUsuario>() {
                            @Override
                            public void success(com.kruma.kanta.entidad.AperturaUsuario obj_pResultado) {

                                if (obj_pResultado != null) {
                                    if (obj_pResultado.getAdministrador().equals(Constante.CONDICION_POSITIVO)) {

                                        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

                                        builder.setMessage("¿Desea eliminar la canción seleccionada?")
                                                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener(){
                                                    public void onClick(DialogInterface dialog, int id) {
                                                        // FIRE ZE MISSILES!
                                                        CancelarLocalCancion(idAperturaCancion);
                                                    }
                                                })
                                                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                                                    public void onClick(DialogInterface dialog, int id) {
                                                        // User cancelled the dialog
                                                        dialog.cancel();
                                                    }
                                                });
                                        // Create the AlertDialog object and return it
                                        //return builder.create();

                                        AlertDialog dialog = builder.create();
                                        dialog.show();



                                    } else
                                        Toast.makeText(App.getContext(), "No puedes hacer ninguna acción", Toast.LENGTH_SHORT).show();
                                }

                            }

                            @Override
                            public void failure(ProcessResult obj_pResultado) {

                            }
                        });

                return true;
            }

    });
        ListarCancionesPorUsuario();
    }

    public void CancelarLocalCancion(final int idAperturaCancion) {
        AperturaCancion obj_pAperturaCancion = new AperturaCancion();
        //obj_pAperturaCancion.setIdLocal(Integer.parseInt(Constante.ID_LOCAL));
        obj_pAperturaCancion.setIdLocal(com.kruma.core.security.SecurityManager.getKeyInteger(Constante.SESSION_IDLOCAL));
        //obj_pAperturaCancion.setIdApertura(Constante.ID_APERTURA);
        obj_pAperturaCancion.setIdApertura(com.kruma.core.security.SecurityManager.getKeyInteger(Constante.SESSION_IDAPERTURA));
        obj_pAperturaCancion.setIdAperturaCancion(idAperturaCancion);
        //obj_pAperturaCancion.setIdUsuario(Constante.TXT_USUARIO_LOGEADO);
        obj_pAperturaCancion.setIdUsuario(com.kruma.core.security.SecurityManager.getUsuario());

        com.kruma.kanta.logical.Apertura.CancelarCancion(obj_pAperturaCancion,
                new ProcessCallback<ProcessResult>() {
                    @Override
                    public void success(ProcessResult obj_pResultado) {
                        Toast.makeText(App.getContext(), obj_pResultado.getMessage(), Toast.LENGTH_SHORT).show();
                        ListarCancionesPorUsuario();
                    }
                    @Override
                    public void failure(ProcessResult obj_pResultado) {
                        Toast.makeText(App.getContext(), obj_pResultado.getMessage().toString(), Toast.LENGTH_SHORT).show();
                        //dismiss();
                    }
                });
    }

    public static void ListarCancionesPorUsuario() {
       com.kruma.kanta.logical.Apertura.ListarCancion(
               //Integer.parseInt(Constante.ID_LOCAL),
               com.kruma.core.security.SecurityManager.getKeyInteger(Constante.SESSION_IDLOCAL),
               //Constante.ID_APERTURA,
               com.kruma.core.security.SecurityManager.getKeyInteger(Constante.SESSION_IDAPERTURA),
               null, 1 ,
                new ProcessCallback<com.kruma.core.util.common.List<AperturaCancion>>() {

                    @Override
                    public void success(com.kruma.core.util.common.List<AperturaCancion> obj_pResultado) {
                        cancionMiListaAdapter= new CancionMiListaAdapter(App.getContext(), obj_pResultado.getResult());
                        lstCancionMiLista.setAdapter(cancionMiListaAdapter);

                    }

                    @Override
                    public void failure(ProcessResult obj_pResultado) {
                        Toast.makeText(App.getContext(), obj_pResultado.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
    }
}
