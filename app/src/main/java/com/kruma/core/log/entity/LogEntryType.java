package com.kruma.core.log.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by John on 27/06/2016.
 */
public enum LogEntryType {

    @SerializedName("1")
    Error(1), //Indica un log de error.
    @SerializedName("2")
    Information(2),//Indica un log de información.
    @SerializedName("3")
    Warning(3);// Indica un log de advertencia.

    //region VARIABLES
    private final int id;
    //endregion

    //region CONSTRUCTOR
    LogEntryType(int id) {
        this.id = id;
    }
    //endregion

    //region PROPIEDADES
    public int getValue() {
        return id;
    }
    //endregion
}
