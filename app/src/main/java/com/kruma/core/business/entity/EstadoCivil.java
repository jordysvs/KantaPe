package com.kruma.core.business.entity;

import com.google.gson.annotations.SerializedName;
import com.kruma.core.fileserver.entity.FileUpload;

import java.util.Date;

/**
 * Created by John on 27/06/2016.
 */
public class EstadoCivil {

    //region VARIABLES
    @SerializedName("IdEstadoCivil")
    private Integer idEstadoCivil;

    @SerializedName("Descripcion")
    private String descripcion;

    @SerializedName("Estado")
    private String estado;

    @SerializedName("UsuarioCreacion")
    private String usuarioCreacion;

    @SerializedName("FechaCreacion")
    private Date fechaCreacion;

    @SerializedName("UsuarioModificacion")
    private String usuarioModificacion;

    @SerializedName("FechaModificacion")
    private Date fechaModificacion;
    //endregion

    //region CONSTRUCTOR
    public EstadoCivil() {
    }
    //endregion

    //region PROPIEDADES
    public Integer getIdEstadoCivil() {
        return idEstadoCivil;
    }

    public void setIdEstadoCivil(Integer idEstadoCivil) {
        this.idEstadoCivil = idEstadoCivil;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getUsuarioModificacion() {
        return usuarioModificacion;
    }

    public void setUsuarioModificacion(String usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    @Override
    public String toString() {
        return descripcion;
    }
    //endregion
}
