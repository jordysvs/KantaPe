package com.kruma.kanta.view.fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.kruma.core.configuration.App;
import com.kruma.core.util.common.ProcessCallback;
import com.kruma.core.util.common.ProcessResult;
import com.kruma.kanta.entidad.AperturaCancion;

/**
 * Created by Enrique on 05/09/2016.
 */
public class CancionesEliminarDialogFragment extends DialogFragment {

    TextView txtEscuchar;
    TextView txtCantar;
    static int var = 0;


    private ListView lstDialogAperturaCancionEliminar;

    //private String[] opciones = {"Aceptar", "Cancelar"};

    public CancionesEliminarDialogFragment() {
    }

    public static CancionesEliminarDialogFragment newInstance(String titulo) {

        CancionesEliminarDialogFragment frag = new CancionesEliminarDialogFragment();
        Bundle args = new Bundle();
        args.putString("titulo", titulo);
        frag.setArguments(args);
        return frag;
    }

    //@Override
    //public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
     //   return inflater.inflate(R.layout.dialog_fragment_canciones_eliminar, container);
   // }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String tituloDialog = getArguments().getString("titulo", "Esta seguro que eliminara la cancion");
        getDialog().setTitle(tituloDialog);
        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_MODE_CHANGED);

      //  lstDialogAperturaCancionEliminar = (ListView) getView().findViewById(R.id.lstDialogAperturaCancionEliminar);

//        lstDialogAperturaCancionEliminar.setOnItemClickListener(new AdapterView.OnItemClickListener() {
  //          @Override
    //        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {




      //      }
        //});

        //cargarCancionMiLista();

    }


    //public void cargarCancionMiLista() {

//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(App.getContext(), android.R.layout.select_dialog_item, opciones);

  //      lstDialogAperturaCancionEliminar.setAdapter(adapter);


//    }





    public void EliminarLocalCancion() {

        AperturaCancion obj_pAperturaCancion = new AperturaCancion();

        obj_pAperturaCancion.setIdLocal(1);
        obj_pAperturaCancion.setIdApertura(1);
        obj_pAperturaCancion.setIdAperturaCancionSolicitud(null);
        //obj_pAperturaCancion.setIdUsuario(Constante.TXT_USUARIO_LOGEADO);
        obj_pAperturaCancion.setIdUsuario(com.kruma.core.security.SecurityManager.getUsuario());
        obj_pAperturaCancion.setIdLocalCancion(4288);
        obj_pAperturaCancion.setIdAperturaCancionTipo(1);

        com.kruma.kanta.logical.Apertura.CancelarCancion(obj_pAperturaCancion,
                new ProcessCallback<ProcessResult>() {
                    @Override
                    public void success(ProcessResult obj_pResultado) {
                        Toast.makeText(App.getContext(), obj_pResultado.getMessage(), Toast.LENGTH_SHORT).show();
                        dismiss();
                    }

                    @Override
                    public void failure(ProcessResult obj_pResultado) {
                        Toast.makeText(App.getContext(), obj_pResultado.getMessage().toString(), Toast.LENGTH_SHORT).show();
                        dismiss();
                    }
                });
    }



    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("DESEA ELIMINAR LA CANCION")
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id) {
                        // FIRE ZE MISSILES!

                            EliminarLocalCancion();

                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }


}

