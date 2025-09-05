package com.kruma.kanta.entidad;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by Jordy on 20/03/2017.
 */
public class Ubicacion {

    //region VARIABLES
    @SerializedName("IdLocal")
    public Integer idLocal;

    @SerializedName("IdUbicacion")
    public Integer idUbicacion;

    @SerializedName("IdUbicacionTipo")
    public Integer idUbicacionTipo;

    @SerializedName("Numero")
    public Integer numero;

    @SerializedName("Capacidad")
    public Integer capacidad;

    @SerializedName("Estado")
    public String estado;

    @SerializedName("UsuarioCreacion")
    public String usuarioCreacion;

    @SerializedName("FechaCreacion")
    public Date fechaCreacion;

    @SerializedName("UsuarioModificacion")
    public String usuarioModificacion;

    @SerializedName("FechaModificacion")
    public Date fechaModificacion;

    @SerializedName("Local")
    private com.kruma.kanta.entidad.Local Local;


    //region CONSTRUCTOR
    public Ubicacion() {
    }


    public int getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(int idLocal) {
        this.idLocal = idLocal;
    }

    public int getIdUbicacion() {
        return idUbicacion;
    }

    public void setIdUbicacion(int idUbicacion) {
        this.idUbicacion = idUbicacion;
    }

    public int getIdUbicacionTipo() {
        return idUbicacionTipo;
    }

    public void setIdUbicacionTipo(int idUbicacionTipo) {
        this.idUbicacionTipo = idUbicacionTipo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
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

    public com.kruma.kanta.entidad.Local getLocal() {
        return Local;
    }

    public void setLocal(com.kruma.kanta.entidad.Local local) {
        Local = local;
    }
}
