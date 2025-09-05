package com.kruma.core.util.dialog;

public interface ConfirmCallback<T>{

    void onAceptar(T obj_pEntity);
    void onCancelar(T obj_pEntity);
}
