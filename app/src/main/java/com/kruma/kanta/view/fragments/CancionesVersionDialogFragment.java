package com.kruma.kanta.view.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.kruma.core.configuration.App;
import com.kruma.core.util.common.ProcessCallback;
import com.kruma.core.util.common.List;
import com.kruma.core.util.common.ProcessResult;
import com.kruma.kanta.MainActivity;
import com.kruma.kanta.R;
import com.kruma.kanta.entidad.AperturaCancion;
import com.kruma.kanta.entidad.AperturaCancionSolicitud;
import com.kruma.kanta.entidad.AperturaUsuario;
import com.kruma.kanta.entidad.Constante;
import com.kruma.kanta.view.adapters.DialogAperturaCancionSolicitudAdapter;

/**
 * Created by Enrique on 05/09/2016.
 */
public class CancionesVersionDialogFragment extends DialogFragment {

    TextView txtEscuchar;
    TextView txtCantar;
    static int var = 0;
    private ListView lstDialogAperturaCancionSolicitud;
    private DialogAperturaCancionSolicitudAdapter dialogAperturaCancionSolicitudAdapter;

    public CancionesVersionDialogFragment() {
    }

    public static CancionesVersionDialogFragment newInstance(String titulo) {
        CancionesVersionDialogFragment frag = new CancionesVersionDialogFragment();
        Bundle args = new Bundle();
        args.putString("titulo", titulo);
        frag.setArguments(args);
        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_fragment_canciones_version, container);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String tituloDialog = getArguments().getString("titulo", "Elegir versión");
        getDialog().setTitle(tituloDialog);
        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_MODE_CHANGED);
        lstDialogAperturaCancionSolicitud = (ListView) getView().findViewById(R.id.lstDialogAperturaCancionSolicitud);

        com.kruma.kanta.logical.AperturaCancionSolicitud.ListarAperturaCancionSolicitud(
                new ProcessCallback<List<AperturaCancionSolicitud>>() {
                    @Override
                    public void success(List<AperturaCancionSolicitud> obj_pResultado) {
                        dialogAperturaCancionSolicitudAdapter = new DialogAperturaCancionSolicitudAdapter(App.getContext(), obj_pResultado.getResult());
                        lstDialogAperturaCancionSolicitud.setAdapter(dialogAperturaCancionSolicitudAdapter);
                    }

                    @Override
                    public void failure(ProcessResult obj_pResultado) {
                    }
                });

        lstDialogAperturaCancionSolicitud.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                Integer IdTipoCancion = position + 1;

                //Integer IdTipoCancion = DialogAperturaCancionSolicitudAdapter.getIdAperturaCancionSolicitud(position);
                ObtenerAperturaUsuario(IdTipoCancion);
                //TODO Revisar la seleccion del tipo de cancion

            }
        });
    }

    private void ObtenerAperturaUsuario(final int IdTipoCancion) {

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

                        if (obj_pResultado != null) {
                            if (obj_pResultado.getEstado().equals(Constante.ESTADO_ACTIVO)) {
                                insertarLocalCancion(IdTipoCancion);
                            } else if (obj_pResultado.getEstado().equals(Constante.ESTADO_RECHAZADO)) {
                                Toast.makeText(App.getContext(), " No puede solicitar canciones", Toast.LENGTH_SHORT).show();
                                dismiss();
                            } else if (obj_pResultado.getEstado().equals(Constante.ESTADO_PENDIENTE)) {
                                Toast.makeText(App.getContext(), " No puede solicitar canciones", Toast.LENGTH_SHORT).show();
                                dismiss();
                            } else if (obj_pResultado.getEstado().equals(Constante.ESTADO_INACTIVO)) {
                                Toast.makeText(App.getContext(), " No puede solicitar canciones, usted fue eliminado de la mesa", Toast.LENGTH_SHORT).show();

                                Intent intent = new Intent(App.getContext(), MainActivity.class);
                                //intent.putExtra("Logeado", Constante.TXT_USUARIO_LOGEADO);
                                intent.putExtra("Logeado", com.kruma.core.security.SecurityManager.getUsuario());
                                //Constante.ID_LOCAL = null;
                                com.kruma.core.security.SecurityManager.setKey(Constante.SESSION_IDLOCAL, null);
                                startActivity(intent);
                                dismiss();
                                getActivity().finish();
                            }
                        }

                    }

                    @Override
                    public void failure(ProcessResult obj_pResultado) {
                        Toast.makeText(App.getContext(), "Se produjo un error en la espera de la solicitud", Toast.LENGTH_SHORT).show();

                    }
                });

    }

    public void insertarLocalCancion(final int IdTipoCancion) {
        AperturaCancion obj_pAperturaCancion = new AperturaCancion();

        //obj_pAperturaCancion.setIdLocal(Integer.parseInt(Constante.ID_LOCAL));
        obj_pAperturaCancion.setIdLocal(com.kruma.core.security.SecurityManager.getKeyInteger(Constante.SESSION_IDLOCAL));
        //obj_pAperturaCancion.setIdApertura(Constante.ID_APERTURA);
        obj_pAperturaCancion.setIdApertura(com.kruma.core.security.SecurityManager.getKeyInteger(Constante.SESSION_IDAPERTURA));
        obj_pAperturaCancion.setIdAperturaCancionSolicitud(IdTipoCancion);
        //obj_pAperturaCancion.setIdUsuario(Constante.TXT_USUARIO_LOGEADO);
        obj_pAperturaCancion.setIdUsuario(com.kruma.core.security.SecurityManager.getUsuario());
        obj_pAperturaCancion.setIdLocalCancion(Constante.ID_LOCALCANCION);
        obj_pAperturaCancion.setIdAperturaCancionTipo(1);

        com.kruma.kanta.logical.Apertura.SolicitarCancion(obj_pAperturaCancion,
                new ProcessCallback<ProcessResult>() {
                    @Override
                    public void success(ProcessResult obj_pResultado) {
                        //Toast.makeText(App.getContext(), obj_pResultado.getMessage(), Toast.LENGTH_SHORT).show();
                        Toast.makeText(App.getContext(), "Se agregó la canción a la lista de su mesa", Toast.LENGTH_SHORT).show();
                        dismiss();
                    }

                    @Override
                    public void failure(ProcessResult obj_pResultado) {
                        Toast.makeText(App.getContext(), obj_pResultado.getMessage().toString(), Toast.LENGTH_SHORT).show();
                        dismiss();
                    }
                });
    }
}
