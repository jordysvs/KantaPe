package com.kruma.core.business.entity;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by John on 15/06/2016.
 */
public class TipoDocumento {

    //region VARIABLES
    @SerializedName("IdTipoDocumento")
    private Integer idTipoDocumento;

    @SerializedName("Codigo")
    private String codigo;

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
    public TipoDocumento() {
    }
    //endregion

    //region PROPIEDADES
    public Integer getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(Integer idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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
