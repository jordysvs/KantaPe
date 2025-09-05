package com.kruma.kanta.entidad;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by Carlos Gomez on 28/10/2016.
 */

public class ProductoTipo {

    @SerializedName("IdProductoTipo")
    public Integer idProductoTipo;
    @SerializedName("Descripcion")
    public String descripcion;
    @SerializedName("Estado")
    public String Estado;
    @SerializedName("UsuarioCreacion")
    public String usuarioCreacion;
    @SerializedName("FechaCreacion")
    public Date fechaCreacion;
    @SerializedName("UsuarioModificacion")
    public String usuarioModificacion;
    @SerializedName("FechaModificacion")
    public Date fechaModificacion;

    public Integer getIdProductoTipo() {
        return idProductoTipo;
    }
    public void setIdProductoTipo(Integer idProductoTipo) {
        this.idProductoTipo = idProductoTipo;
    }

    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return Estado;
    }
    public void setEstado(String estado) {
        Estado = estado;
    }

    public String getUsuarioCreacion() {
        return usuarioCreacion;
    }
    public void setUsuarioCreacion(String usuarioCreacion) { this.usuarioCreacion = usuarioCreacion; }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }
    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getUsuarioModificacion() {
        return usuarioModificacion;
    }
    public void setUsuarioModificacion(String usuarioModificacion) { this.usuarioModificacion = usuarioModificacion; }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }
    public void setFechaModificacion(Date fechaModificacion) { this.fechaModificacion = fechaModificacion; }
}
