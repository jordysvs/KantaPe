package com.kruma.core.business.entity;

import com.google.gson.annotations.SerializedName;
import com.kruma.core.fileserver.entity.FileUpload;

import java.util.Date;

/**
 * Created by John on 27/06/2016.
 */
public class Modulo {

    //region VARIABLES
    @SerializedName("IdModulo")
    private String idModulo;

    @SerializedName("Descripcion")
    private String descripcion;

    @SerializedName("IdImagen")
    private Integer idImagen;

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

    @SerializedName("Foto")
    private FileUpload foto;
    //endregion

    //region CONSTRUCTOR
    public Modulo() {
    }
    //endregion

    //region PROPIEDADES
    public String getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(String idModulo) {
        this.idModulo = idModulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(Integer idImagen) {
        this.idImagen = idImagen;
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

    public FileUpload getFoto() {
        return foto;
    }

    public void setFoto(FileUpload foto) {
        this.foto = foto;
    }
    //endregion
}
