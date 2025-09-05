package com.kruma.core.business.entity;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by John on 27/06/2016.
 */
public class Parametro {

    //region VARIABLES
    @SerializedName("IdModulo")
    private String idModulo;

    @SerializedName("IdParametro")
    private String idParametro;

    @SerializedName("Descripcion")
    private String descripcion;

    @SerializedName("Valor")
    private String valor;

    @SerializedName("Sistema")
    private String sistema;

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

    @SerializedName("Modulo")
    private Modulo modulo;
    //endregion

    //region CONSTRUCTOR
    public Parametro() {
    }
    //endregion

    //region PROPIEDADES
    public String getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(String idModulo) {
        this.idModulo = idModulo;
    }

    public String getIdParametro() {
        return idParametro;
    }

    public void setIdParametro(String idParametro) {
        this.idParametro = idParametro;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getSistema() {
        return sistema;
    }

    public void setSistema(String sistema) {
        this.sistema = sistema;
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

    public Modulo getModulo() {
        return modulo;
    }

    public void setModulo(Modulo modulo) {
        this.modulo = modulo;
    }
    //endregion
}
