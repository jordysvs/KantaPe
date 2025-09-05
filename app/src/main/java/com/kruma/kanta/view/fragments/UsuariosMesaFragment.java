package com.kruma.kanta.view.fragments;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.kruma.core.configuration.App;
import com.kruma.core.util.common.List;
import com.kruma.core.util.common.ProcessCallback;
import com.kruma.core.util.common.ProcessResult;
import com.kruma.kanta.MainActivity;
import com.kruma.kanta.OnNavigationListener;
import com.kruma.kanta.R;
import com.kruma.kanta.entidad.Constante;
import com.kruma.kanta.view.adapters.UsuariosMesaAdapter;

public class UsuariosMesaFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnNavigationListener mListener;

    private static UsuariosMesaAdapter usuariosMesaAdapter;
    private static ListView lstUsuariosMiMesa;

    //private FloatingActionButton ActionButton;

    public UsuariosMesaFragment() {
        // Required empty public constructor
    }

    public static UsuariosMesaFragment newInstance(String param1, String param2) {
        UsuariosMesaFragment fragment = new UsuariosMesaFragment();
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
        return inflater.inflate(R.layout.fragment_usuarios_mesa, container, false);
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

        ((MainActivity) getActivity()).getSupportActionBar().setTitle(R.string.title_mi_mesa);
        ((MainActivity) getActivity()).getSupportActionBar().setSubtitle("USUARIOS");

        lstUsuariosMiMesa = (ListView) getView().findViewById(R.id.lstUsuariosMiMesa);

        //ActionButton = (FloatingActionButton) getView().findViewById(R.id.ActionButton);
        cargarUsuarios();

        // ActionButton.setOnClickListener(new View.OnClickListener() {
        //     @Override
        //  public void onClick(View view) {

        //      cargarUsuarios();
        //  }
        //});
        lstUsuariosMiMesa.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                final String usuarioSeleccionado = UsuariosMesaAdapter.getIdUsuario(position);

                final String estadousuario = UsuariosMesaAdapter.getEstado(position);

                final int idAperturaUsuario = UsuariosMesaAdapter.getIdAperturaUsuario(position);

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

                                        //if (usuarioSeleccionado.equals(Constante.TXT_USUARIO_LOGEADO)) {
                                        if (usuarioSeleccionado.equals(com.kruma.core.security.SecurityManager.getUsuario())) {

                                            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

                                            builder.setMessage("¿Dejar de ser administrador?")
                                                    .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                                        public void onClick(DialogInterface dialog, int id) {
                                                            // FIRE ZE MISSILES!
                                                            AdministradorDejar(idAperturaUsuario);
                                                            cargarUsuarios();
                                                            dialog.cancel();
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
                                            cargarUsuarios();

                                        } else {
                                            if (estadousuario.equals(Constante.ESTADO_ACTIVO)) {
                                                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

                                                builder.setMessage("¿Eliminar este usuario?")
                                                        .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                                            public void onClick(DialogInterface dialog, int id) {
                                                                // FIRE ZE MISSILES!
                                                                EliminarUsuario(usuarioSeleccionado, idAperturaUsuario);
                                                                cargarUsuarios();
                                                                dialog.cancel();
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
                                                cargarUsuarios();
                                            } else {

                                                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

                                                builder.setMessage("¿Aceptar usuario?")
                                                        .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                                            public void onClick(DialogInterface dialog, int id) {
                                                                // FIRE ZE MISSILES!
                                                                AceptarUsuario(usuarioSeleccionado, idAperturaUsuario);
                                                                cargarUsuarios();
                                                                dialog.cancel();
                                                            }
                                                        })
                                                        .setNegativeButton("Rechazar", new DialogInterface.OnClickListener() {
                                                            public void onClick(DialogInterface dialog, int id) {
                                                                // User cancelled the dialog
                                                                RechazarUsuario(usuarioSeleccionado, idAperturaUsuario);
                                                                cargarUsuarios();
                                                                dialog.cancel();

                                                            }
                                                        })
                                                        .setNeutralButton("Cancelar", new DialogInterface.OnClickListener() {
                                                            public void onClick(DialogInterface dialog, int id) {
                                                                // User cancelled the dialog
                                                                dialog.cancel();

                                                            }
                                                        });
                                                // Create the AlertDialog object and return it
                                                //return builder.create();

                                                AlertDialog dialog = builder.create();
                                                dialog.show();
                                                cargarUsuarios();

                                            }
                                        }
                                    } else {
                                        //if(usuarioSeleccionado.equals(Constante.TXT_USUARIO_LOGEADO)){
                                        if (usuarioSeleccionado.equals(com.kruma.core.security.SecurityManager.getUsuario())) {

                                            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

                                            builder.setMessage("¿Retirarme de esta mesa?")
                                                    .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                                        public void onClick(DialogInterface dialog, int id) {
                                                            // FIRE ZE MISSILES!
                                                            DejarMesa(usuarioSeleccionado, idAperturaUsuario);
                                                            dialog.cancel();
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
                                            cargarUsuarios();

                                        } else
                                            Toast.makeText(App.getContext(), "No puedes hacer ninguna acción", Toast.LENGTH_SHORT).show();
                                    }
                                }

                            }

                            @Override
                            public void failure(ProcessResult obj_pResultado) {

                            }
                        });


            }

        });

    }

    private void cargarUsuarios() {

        com.kruma.kanta.logical.AperturaUsuario.ListarAperturaUsuario(
                //Integer.parseInt(Constante.ID_LOCAL),
                com.kruma.core.security.SecurityManager.getKeyInteger(Constante.SESSION_IDLOCAL),
                //Constante.ID_APERTURA,
                com.kruma.core.security.SecurityManager.getKeyInteger(Constante.SESSION_IDAPERTURA),
                new ProcessCallback<List<com.kruma.kanta.entidad.AperturaUsuario>>() {


                    @Override
                    public void success(List<com.kruma.kanta.entidad.AperturaUsuario> obj_pResultado) {
                        usuariosMesaAdapter = new UsuariosMesaAdapter(App.getContext(), obj_pResultado.getResult());
                        usuariosMesaAdapter.notifyDataSetChanged();
                        lstUsuariosMiMesa.setAdapter(usuariosMesaAdapter);
                        //usuariosMesaAdapter.addListItemToAdapter(obj_pResultado.getResult());
                        //usuariosMesaAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void failure(ProcessResult obj_pResultado) {

                    }
                });
    }


    private void RechazarUsuario(final String idUsuario, final int idAperturaUsuario) {
        try {
            com.kruma.kanta.entidad.AperturaUsuario obj_AperturaUsuario = new com.kruma.kanta.entidad.AperturaUsuario();

            //obj_AperturaUsuario.setIdLocal(Integer.parseInt(Constante.ID_LOCAL));
            obj_AperturaUsuario.setIdLocal(com.kruma.core.security.SecurityManager.getKeyInteger(Constante.SESSION_IDLOCAL));
            //obj_AperturaUsuario.setIdApertura(Constante.ID_APERTURA);
            obj_AperturaUsuario.setIdApertura(com.kruma.core.security.SecurityManager.getKeyInteger(Constante.SESSION_IDAPERTURA));
            obj_AperturaUsuario.setIdAperturaUsuario(idAperturaUsuario);
            obj_AperturaUsuario.setIdUsuario(idUsuario);
            obj_AperturaUsuario.setAdministrador(Constante.CONDICION_NEGATIVO);
            obj_AperturaUsuario.setEstado(Constante.ESTADO_RECHAZADO);
            //obj_AperturaUsuario.setUsuarioModificacion(Constante.TXT_USUARIO_LOGEADO);
            obj_AperturaUsuario.setUsuarioModificacion(com.kruma.core.security.SecurityManager.getUsuario());


            // Se realiza la inserción del usuario
            com.kruma.kanta.logical.AperturaUsuario.Modificar(
                    obj_AperturaUsuario,
                    new ProcessCallback<ProcessResult>() {

                        @Override
                        public void success(ProcessResult obj_pResultado) {
                            Toast.makeText(App.getContext(), "Se rechazo al usuario seleccionado", Toast.LENGTH_LONG).show();
                            cargarUsuarios();
                        }

                        @Override
                        public void failure(ProcessResult obj_pResultado) {
                            Toast.makeText(App.getContext(), "La solicitud ha sido cancelada por el usuario", Toast.LENGTH_LONG).show();
                        }
                    });

        } catch (Exception ex) {
            Toast.makeText(App.getContext(), ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void AceptarUsuario(final String idUsuario, final int idAperturaUsuario) {
        try {
            com.kruma.kanta.entidad.AperturaUsuario obj_AperturaUsuario = new com.kruma.kanta.entidad.AperturaUsuario();

            //obj_AperturaUsuario.setIdLocal(Integer.parseInt(Constante.ID_LOCAL));
            obj_AperturaUsuario.setIdLocal(com.kruma.core.security.SecurityManager.getKeyInteger(Constante.SESSION_IDLOCAL));
            //obj_AperturaUsuario.setIdApertura(Constante.ID_APERTURA);
            obj_AperturaUsuario.setIdApertura(com.kruma.core.security.SecurityManager.getKeyInteger(Constante.SESSION_IDAPERTURA));
            obj_AperturaUsuario.setIdAperturaUsuario(idAperturaUsuario);
            obj_AperturaUsuario.setIdUsuario(idUsuario);
            obj_AperturaUsuario.setAdministrador(Constante.CONDICION_NEGATIVO);
            obj_AperturaUsuario.setEstado(Constante.ESTADO_ACTIVO);
            //obj_AperturaUsuario.setUsuarioModificacion(Constante.TXT_USUARIO_LOGEADO);
            obj_AperturaUsuario.setUsuarioModificacion(com.kruma.core.security.SecurityManager.getUsuario());

            // Se realiza la inserción del usuario
            com.kruma.kanta.logical.AperturaUsuario.Modificar(
                    obj_AperturaUsuario,
                    new ProcessCallback<ProcessResult>() {

                        @Override
                        public void success(ProcessResult obj_pResultado) {

                            Toast.makeText(App.getContext(), "El usuario fue agregado correctamente a la mesa", Toast.LENGTH_LONG).show();
                            cargarUsuarios();
                        }

                        @Override
                        public void failure(ProcessResult obj_pResultado) {
                            Toast.makeText(App.getContext(), "La solicitud ha sido cancelada por el usuario", Toast.LENGTH_LONG).show();
                        }
                    });

        } catch (Exception ex) {
            Toast.makeText(App.getContext(), ex.getMessage(), Toast.LENGTH_SHORT).show();
            //Toast.makeText(App.getContext(), "La solicitud ha sido cancelada", Toast.LENGTH_LONG).show();
        }
    }

    private void AdministradorDejar(final int idAperturaUsuario) {
        try {
            com.kruma.kanta.entidad.AperturaUsuario obj_AperturaUsuario = new com.kruma.kanta.entidad.AperturaUsuario();

            //obj_AperturaUsuario.setIdLocal(Integer.parseInt(Constante.ID_LOCAL));
            obj_AperturaUsuario.setIdLocal(com.kruma.core.security.SecurityManager.getKeyInteger(Constante.SESSION_IDLOCAL));
            //obj_AperturaUsuario.setIdApertura(Constante.ID_APERTURA);
            obj_AperturaUsuario.setIdApertura(com.kruma.core.security.SecurityManager.getKeyInteger(Constante.SESSION_IDAPERTURA));
            obj_AperturaUsuario.setIdAperturaUsuario(idAperturaUsuario);
            //obj_AperturaUsuario.setIdUsuario(Constante.TXT_USUARIO_LOGEADO);
            obj_AperturaUsuario.setIdUsuario(com.kruma.core.security.SecurityManager.getUsuario());
            obj_AperturaUsuario.setAdministrador(Constante.CONDICION_NEGATIVO);
            obj_AperturaUsuario.setEstado(Constante.ESTADO_INACTIVO);
            //obj_AperturaUsuario.setUsuarioModificacion(Constante.TXT_USUARIO_LOGEADO);
            obj_AperturaUsuario.setUsuarioModificacion(com.kruma.core.security.SecurityManager.getUsuario());

            // Se realiza la inserción del usuario
            com.kruma.kanta.logical.AperturaUsuario.Modificar(
                    obj_AperturaUsuario,
                    new ProcessCallback<ProcessResult>() {

                        @Override
                        public void success(ProcessResult obj_pResultado) {

                            Toast.makeText(App.getContext(), "Usted dejo de ser administrador", Toast.LENGTH_LONG).show();
                            Intent intent1 = new Intent(App.getContext(), MainActivity.class);
                            //intent1.putExtra("Logeado", Constante.TXT_USUARIO_LOGEADO);
                            intent1.putExtra("Logeado", com.kruma.core.security.SecurityManager.getUsuario());
                            //Constante.ID_LOCAL = null;
                            com.kruma.core.security.SecurityManager.setKey(Constante.SESSION_IDLOCAL, null);
                            startActivity(intent1);

                            getActivity().finish();

                        }

                        @Override
                        public void failure(ProcessResult obj_pResultado) {
                            Toast.makeText(App.getContext(), obj_pResultado.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });

        } catch (Exception ex) {
            Toast.makeText(App.getContext(), ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void EliminarUsuario(final String idUsuario, final int idAperturaUsuario) {
        try {
            com.kruma.kanta.entidad.AperturaUsuario obj_AperturaUsuario = new com.kruma.kanta.entidad.AperturaUsuario();

            //obj_AperturaUsuario.setIdLocal(Integer.parseInt(Constante.ID_LOCAL));
            obj_AperturaUsuario.setIdLocal(com.kruma.core.security.SecurityManager.getKeyInteger(Constante.SESSION_IDLOCAL));
            //obj_AperturaUsuario.setIdApertura(Constante.ID_APERTURA);
            obj_AperturaUsuario.setIdApertura(com.kruma.core.security.SecurityManager.getKeyInteger(Constante.SESSION_IDAPERTURA));
            obj_AperturaUsuario.setIdAperturaUsuario(idAperturaUsuario);
            obj_AperturaUsuario.setIdUsuario(idUsuario);
            obj_AperturaUsuario.setAdministrador(Constante.CONDICION_NEGATIVO);
            obj_AperturaUsuario.setEstado(Constante.ESTADO_INACTIVO);
            //obj_AperturaUsuario.setUsuarioModificacion(Constante.TXT_USUARIO_LOGEADO);
            obj_AperturaUsuario.setUsuarioModificacion(com.kruma.core.security.SecurityManager.getUsuario());

            // Se realiza la inserción del usuario
            com.kruma.kanta.logical.AperturaUsuario.Modificar(
                    obj_AperturaUsuario,
                    new ProcessCallback<ProcessResult>() {

                        @Override
                        public void success(ProcessResult obj_pResultado) {

                            Toast.makeText(App.getContext(), "Se elimino correctamente al usuario", Toast.LENGTH_LONG).show();
                            cargarUsuarios();
                        }

                        @Override
                        public void failure(ProcessResult obj_pResultado) {
                            Toast.makeText(App.getContext(), "Se usuario se retiro de la mesa", Toast.LENGTH_LONG).show();
                        }
                    });

        } catch (Exception ex) {
            Toast.makeText(App.getContext(), ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void DejarMesa(final String idUsuario, final int idAperturaUsuario) {
        try {
            com.kruma.kanta.entidad.AperturaUsuario obj_AperturaUsuario = new com.kruma.kanta.entidad.AperturaUsuario();

            //obj_AperturaUsuario.setIdLocal(Integer.parseInt(Constante.ID_LOCAL));
            obj_AperturaUsuario.setIdLocal(com.kruma.core.security.SecurityManager.getKeyInteger(Constante.SESSION_IDLOCAL));
            //obj_AperturaUsuario.setIdApertura(Constante.ID_APERTURA);
            obj_AperturaUsuario.setIdApertura(com.kruma.core.security.SecurityManager.getKeyInteger(Constante.SESSION_IDAPERTURA));
            obj_AperturaUsuario.setIdAperturaUsuario(idAperturaUsuario);
            obj_AperturaUsuario.setIdUsuario(idUsuario);
            obj_AperturaUsuario.setAdministrador(Constante.CONDICION_NEGATIVO);
            obj_AperturaUsuario.setEstado(Constante.ESTADO_INACTIVO);
            //obj_AperturaUsuario.setUsuarioModificacion(Constante.TXT_USUARIO_LOGEADO);
            obj_AperturaUsuario.setUsuarioModificacion(com.kruma.core.security.SecurityManager.getUsuario());

            // Se realiza la inserción del usuario
            com.kruma.kanta.logical.AperturaUsuario.Modificar(
                    obj_AperturaUsuario,
                    new ProcessCallback<ProcessResult>() {
                        @Override
                        public void success(ProcessResult obj_pResultado) {

                            Toast.makeText(App.getContext(), "Se elimino correctamente al usuario", Toast.LENGTH_LONG).show();
                            Intent intent1 = new Intent(App.getContext(), MainActivity.class);
                            //intent1.putExtra("Logeado", Constante.TXT_USUARIO_LOGEADO);
                            intent1.putExtra("Logeado", com.kruma.core.security.SecurityManager.getUsuario());
                            //Constante.ID_LOCAL = null;
                            com.kruma.core.security.SecurityManager.setKey(Constante.SESSION_IDLOCAL, null);
                            startActivity(intent1);

                            getActivity().finish();
                        }

                        @Override
                        public void failure(ProcessResult obj_pResultado) {
                            Toast.makeText(App.getContext(), obj_pResultado.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });

        } catch (Exception ex) {
            Toast.makeText(App.getContext(), ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }


    private void CerrarApertura(final String idUsuario) {
        try {
            com.kruma.kanta.entidad.Apertura obj_Apertura = new com.kruma.kanta.entidad.Apertura();

            //obj_Apertura.setIdLocal(Integer.parseInt(Constante.ID_LOCAL));
            obj_Apertura.setIdLocal(com.kruma.core.security.SecurityManager.getKeyInteger(Constante.SESSION_IDLOCAL));
            //obj_Apertura.setIdApertura(Constante.ID_APERTURA);
            obj_Apertura.setIdApertura(com.kruma.core.security.SecurityManager.getKeyInteger(Constante.SESSION_IDAPERTURA));
            obj_Apertura.setUsuarioModificacion(idUsuario);

            // Se realiza la inserción del usuario
            com.kruma.kanta.logical.Apertura.Cerrar(
                    obj_Apertura,
                    new ProcessCallback<ProcessResult>() {
                        @Override
                        public void success(ProcessResult obj_pResultado) {
                            Toast.makeText(App.getContext(), "Usted dejo de ser administrador de esta mesa", Toast.LENGTH_LONG).show();
                            com.kruma.core.security.SecurityManager.setKey(Constante.SESSION_IDLOCAL, null);
                            //Constante.ID_LOCAL = null;

                        }

                        @Override
                        public void failure(ProcessResult obj_pResultado) {
                            Toast.makeText(App.getContext(), obj_pResultado.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });

        } catch (Exception ex) {
            Toast.makeText(App.getContext(), ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void ModificarCancionesUsuario(final String idUsuario) {
        try {
            com.kruma.kanta.entidad.AperturaCancion obj_AperturaCancion = new com.kruma.kanta.entidad.AperturaCancion();
            //obj_AperturaCancion.setIdLocal(Integer.parseInt(Constante.ID_LOCAL));
            obj_AperturaCancion.setIdLocal(com.kruma.core.security.SecurityManager.getKeyInteger(Constante.SESSION_IDLOCAL));
            //obj_AperturaCancion.setIdApertura(Constante.ID_APERTURA);
            obj_AperturaCancion.setIdApertura(com.kruma.core.security.SecurityManager.getKeyInteger(Constante.SESSION_IDAPERTURA));
            obj_AperturaCancion.setIdUsuario(idUsuario);

            // Se realiza la inserción del usuario
            com.kruma.kanta.logical.AperturaUsuario.ModificarAperturaCancion(
                    obj_AperturaCancion,
                    new ProcessCallback<ProcessResult>() {
                        @Override
                        public void success(ProcessResult obj_pResultado) {
                            Toast.makeText(App.getContext(), "Se inactivaron Las canciones del usuario eliminado", Toast.LENGTH_LONG).show();
                        }

                        @Override
                        public void failure(ProcessResult obj_pResultado) {
                            //Toast.makeText(App.getContext(), obj_pResultado.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });
        } catch (Exception ex) {
            Toast.makeText(App.getContext(), ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
