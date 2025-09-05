package com.kruma.core.exception.entity;

/**
 * Created by John on 27/06/2016.
 */
public class Exception {

    //region ATRIBUTOS
    private String Message;
    private String Source;
    private String StackTrace;
    //endregion

    //region PROPIEDADES
    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public String getSource() {
        return Source;
    }

    public void setSource(String source) {
        Source = source;
    }

    public String getStackTrace() {
        return StackTrace;
    }

    public void setStackTrace(String stackTrace) {
        StackTrace = stackTrace;
    }
    //endregion
}
