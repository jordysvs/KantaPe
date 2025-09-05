package com.kruma.core.business.entity;

import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by John on 27/07/2016.
 */

public class PersonaDireccion {

    //region ATRIBUTOS
    @SerializedName("IdDireccion")
    private Integer idDireccion;
    @SerializedName("IdPersona")
    private Integer idPersona;
    @SerializedName("IdUbigeo")
    private Integer idUbigeo;
    @SerializedName("Latitud")
    private String latitud;
    @SerializedName("Longitud")
    private String longitud;
    @SerializedName("Nombre")
    private String nombre;
    @SerializedName("Direccion")
    private String direccion;
    @SerializedName("Estado")
    private String estado;
    @SerializedName("Principal")
    private String principal;
    @SerializedName("UsuarioCreacion")
    private String usuarioCreacion;
    @SerializedName("UsuarioModificacion")
    private String usuarioModificacion;
    @SerializedName("FechaCreacion")
    private Date fechaCreacion;
    @SerializedName("FechaModificacion")
    private Date fechaModificacion;
    //endregion

    //region PROPIEDADES
    public Integer getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(Integer idDireccion) {
        this.idDireccion = idDireccion;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public Integer getIdUbigeo() {
        return idUbigeo;
    }

    public void setIdUbigeo(Integer idUbigeo) {
        this.idUbigeo = idUbigeo;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public String getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

    public String getUsuarioModificacion() {
        return usuarioModificacion;
    }

    public void setUsuarioModificacion(String usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    //endregion
}
