package com.kruma.core.util.dialog;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

public class MessageFragment<T> extends DialogFragment {

    private final int type = 100;
    private String message;
    private T entity;
    private MessageCallback<T> callback;

    public MessageFragment()
    {

    }

    @SuppressLint("ValidFragment")
    public MessageFragment(
            String str_pMessage,
            T obj_pEntity,
        final MessageCallback<T> obj_pCallback){
        this.message = str_pMessage;
        this.entity = obj_pEntity;
        this.callback = obj_pCallback;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        return new AlertDialog.Builder(getActivity())
                .setTitle(this.message)
                .setPositiveButton("Aceptar",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                callback.onAceptar(entity);
                            }
                        }
                )
                .create();

    }
}
