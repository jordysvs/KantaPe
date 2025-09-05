package com.kruma.core.notification.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by John on 27/06/2016.
 */
public enum MailType {

    @SerializedName("1")
    Body(1);
    //region VARIABLES
    private final int id;
    //endregion

    //region CONSTRUCTOR
    MailType(int id) {
        this.id = id;
    }
    //endregion

    //region PROPIEDADES
    public int getValue() {
        return id;
    }
    //endregion
}
