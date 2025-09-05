package com.kruma.core.util.common;

import com.google.gson.annotations.SerializedName;
import com.kruma.core.util.common.OperationResult;

/**
 * Created by Enrique on 17/06/2016.
 */
public class ProcessResult {

    //region VARIABLES
    @SerializedName("ReturnId")
    public Object returnId;
    @SerializedName("OperationResult")
    public com.kruma.core.util.common.OperationResult operationResult;
    @SerializedName("Message")
    public String message;
    @SerializedName("Detail")
    public String detail;
    @SerializedName("Objeto")
    public Object objeto;
    //endregion

    //region PROPIEDADES
    public Object getReturnId() {
        return this.returnId;
    }

    public void setReturnId(Object returnId) {
        this.returnId = returnId;
    }

    public OperationResult getOperationResult() {
        return this.operationResult;
    }

    public void setOperationResult(OperationResult operationResult) {
        this.operationResult = operationResult;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetail() {
        return this.detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Object getObjeto() {
        return this.objeto;
    }

    public void setObjeto(Object objeto) {
        this.objeto = objeto;
    }
    //endregion

    //region CONSTRUCTOR
    public ProcessResult(Object obj_pReturnId)
    {
        this.operationResult = operationResult.Success;
        this.returnId = obj_pReturnId;
        this.message = "Kruma_Core_util_Comun_ProcessResult_ERR001";
    }

    public ProcessResult(Exception obj_pException)
    {
        this.operationResult = operationResult.InvalidOperation;
        this.detail = obj_pException.getMessage();
        this.message = "Kruma_Core_util_Comun_ProcessResult_ERR002";
    }

    public ProcessResult(Exception obj_pException, String str_pMensaje)
    {
        this.operationResult = operationResult.InvalidOperation;
        this.detail = obj_pException.getMessage();
        this.message = str_pMensaje;
    }
    //enregion
}
