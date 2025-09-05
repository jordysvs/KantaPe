package com.kruma.core.util.common;

import com.google.gson.annotations.SerializedName;

/**
 * Created by John on 27/06/2016.
 */
public class Entity {

    //region VARIABLES
    @SerializedName("Id")
    public String id;

    @SerializedName("Code")
    public String Code;

    @SerializedName("Description")
    public String Description;
    //endregion

    //region PROPIEDADES
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    @Override
    public String toString() {
        return Description;
    }
    //endregion
}
