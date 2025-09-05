package com.kruma.core.service.entity;

import com.google.gson.annotations.SerializedName;
import com.kruma.core.util.common.ProcessResult;

/**
 * Created by Enrique on 17/06/2016.
 */
public class ServiceResult<T> {

    //region VARIABLES
    @SerializedName("Resultado")
    public T resultado;

    @SerializedName("Mensaje")
    public String mensaje;
    //endregion

    //region PROPIEDADES
    public T getResultado() {
        return this.resultado;
    }
    public void setResultado(T resultado) {
        this.resultado = resultado;
    }

    public String getMensaje() {
        return this.mensaje;
    }
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    //endregion

    //region CONSTRUCTOR
    public ServiceResult() { }

    public ServiceResult(String str_pMensaje) { this.mensaje = str_pMensaje; }

    public ServiceResult(T obj_pResultado) {
        this.resultado = obj_pResultado;
        this.mensaje = "";
    }

    //endregion
}


