package com.kruma.kanta.entidad;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by Carlos Gomez on 30/10/2016.
 */

public class AperturaCancionSolicitud {

    //region ATRIBUTOS
    @SerializedName("IdAperturaCancionSolicitud")
    private Integer idAperturaCancionSolicitud;
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

    //region PROPIEDADES

    public Integer getIdAperturaCancionSolicitud() {
        return idAperturaCancionSolicitud;
    }
    public void setIdAperturaCancionSolicitud(Integer idAperturaCancionSolicitud) { this.idAperturaCancionSolicitud = idAperturaCancionSolicitud; }

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

    //endregion
}
