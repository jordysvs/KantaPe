package com.kruma.core.security.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by John on 15/06/2016.
 */
public enum ValidationResult {

    //region ENUM
    @SerializedName("1")
    Authenticated(1), // El usuario se auntenticó correctamente
    @SerializedName("2")
    InvalidUser(2), //El usuario no existe
    @SerializedName("3")
    InvalidPassword(3), //Password incorrecto
    @SerializedName("4")
    UnknownError(4), //Error general
    @SerializedName("5")
    ExpiredUser(5), //El usuario ha expirado
    @SerializedName("6")
    NoApplicationAvailable(6), //El usuario fue autenticado pero no tiene accesos
    @SerializedName("7")
    PasswordOutOfDate(7); //Password vencido
    //endregion

    //region VARIABLES
    private final int id;
    //endregion

    //region CONSTRUCTOR
    ValidationResult(int id) {
        this.id = id;
    }
    //endregion

    //region PROPIEDADES
    public int getValue() {
        return id;
    }
    //endregion
}
