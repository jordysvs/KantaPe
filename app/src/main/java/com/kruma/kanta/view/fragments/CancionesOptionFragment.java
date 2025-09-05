package com.kruma.kanta.view.fragments;

import android.app.AlertDialog;
import android.app.Dialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.kruma.core.configuration.App;
import com.kruma.core.util.common.ProcessCallback;
import com.kruma.core.util.common.Entity;
import com.kruma.core.util.common.List;
import com.kruma.core.util.common.ProcessResult;

/**
 * Created by Enrique on 22/08/2016.
 */
public class CancionesOptionFragment extends DialogFragment {


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        /*
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(App.getContext(), android.R.layout.select_dialog_multichoice);
        adapter.add("whatever data1");
        adapter.add("whatever data2");
        adapter.add("whatever data3");

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity());

        dialogBuilder.setTitle("Sample Dialog");
        //dialogBuilder.setMessage("JOJOJOJOJO");
        */
/*
        dialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(App.getContext(), "which OK" + which, Toast.LENGTH_SHORT).show();
            }
        });

        dialogBuilder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(App.getContext(), "which CANCEL" + which, Toast.LENGTH_SHORT).show();
            }
        });

        dialogBuilder.show();
*/
/*
        dialogBuilder.setAdapter(adapter, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(App.getContext(), "which" + which, Toast.LENGTH_SHORT).show();
            }
        });

        dialogBuilder.show();
*/
        //Lista de genero
        com.kruma.core.business.logical.Genero.Listar(
                new ProcessCallback<
                                        List<Entity>>() {
                    @Override
                    public void success(List<Entity> obj_pResultado) {
                        //creacion del adapter
                        ArrayAdapter<com.kruma.core.util.common.Entity> adapterGenero = new ArrayAdapter<com.kruma.core.util.common.Entity>(App.getContext(), android.R.layout.select_dialog_multichoice, obj_pResultado.getResult());
                        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity());
                        dialogBuilder.setTitle("Sample Dialog");
                        dialogBuilder.setAdapter(adapterGenero, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(App.getContext(), "which" + which, Toast.LENGTH_SHORT).show();
                            }
                        }).setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(App.getContext(), "JOJOJO", Toast.LENGTH_SHORT).show();
                            }
                        });

                        dialogBuilder.show();
                    }

                    @Override
                    public void failure(ProcessResult obj_pResultado) {

                    }
                }
        );


        return super.onCreateDialog(savedInstanceState);
    }
}
