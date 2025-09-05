package com.kruma.core.security.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by John on 15/06/2016.
 */
public class SecurityResult {

    //region VARIABLES
    @SerializedName("IdUsuario")
    public String idUsuario;

    @SerializedName("ValidationResult")
    public ValidationResult validationResult;

    @SerializedName("Message")
    public String message;

    @SerializedName("Detail")
    public String detail;

    @SerializedName("Exception")
    public Exception exception;
    //endregion

    //region CONSTRUCTOR
    public SecurityResult() {
    }
    //endregion

    //region PROPIEDADES
    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public ValidationResult getValidationResult() {
        return validationResult;
    }

    public void setValidationResult(ValidationResult validationResult) {
        this.validationResult = validationResult;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }
    //endregion
}
