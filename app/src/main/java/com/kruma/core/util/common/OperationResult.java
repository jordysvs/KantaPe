package com.kruma.core.util.common;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Enrique on 17/06/2016.
 */
public enum OperationResult {

    //region ENUM
    @SerializedName("1")
    Success(1),
    @SerializedName("2")
    InvalidOperation(2),
    @SerializedName("3")
    ExceptionThrown(3);
    //endregion

    //region VARIABLES
    private final int id;
    //endregion

    //region CONSTRUCTOR
    OperationResult(int id) {
        this.id = id;
    }
    //endregion

    //region PROPIEDADES
    public int getValue() {
        return id;
    }
    //endregion
}
