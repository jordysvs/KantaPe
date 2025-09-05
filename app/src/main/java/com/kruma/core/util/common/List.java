package com.kruma.core.util.common;

import com.google.gson.annotations.SerializedName;

/**
 * Created by John on 27/06/2016.
 */
public class List<T> {

    //region VARIABLES
    @SerializedName("Result")
    public java.util.List<T> result;

    @SerializedName("PageNumber")
    public Integer pageNumber;

    @SerializedName("Total")
    public int total;
    //endregion

    //region PROPIEDADES
    public java.util.List<T> getResult() {
        return result;
    }

    public void setResult(java.util.List<T> result) {
        this.result = result;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    //endregion
}
