package com.kruma.kanta.entidad;

import com.google.gson.annotations.SerializedName;
import com.kruma.core.fileserver.entity.FileUpload;

import java.util.Date;

/**
 * Created by Carlos Gomez on 21/10/2016.
 */

public class Evento {

    //region ATRIBUTOS
    @SerializedName("IdLocal")
    private Integer idLocal;
    @SerializedName("IdEvento")
    private Integer idEvento;
    @SerializedName("Nombre")
    private String nombre;
    @SerializedName("Descripcion")
    private String descripcion;
    @SerializedName("FechaEvento")
    private Date fechaEvento;
    @SerializedName("IdImagen")
    private Integer idImagen;
    @SerializedName("Estado")
    private String estado;
    @SerializedName("ImagenURL")
    private String imagenURL;
    @SerializedName("UsuarioCreacion")
    private String UsuarioCreacion;
    @SerializedName("FechaCreacion")
    private Date fechaCreacion;
    @SerializedName("UsuarioModificacion")
    private String UsuarioModificacion;
    @SerializedName("FechaModificacion")
    private Date fechaModificacion;
    @SerializedName("Local")
    private Local local;
    @SerializedName("Foto")
    private com.kruma.core.fileserver.entity.FileUpload foto;
    //endregion

    //region ATRIBUTOS
    public Integer getIdLocal() {
        return idLocal;
    }
    public void setIdLocal(Integer idLocal) {
        this.idLocal = idLocal;
    }

    public Integer getIdEvento() {
        return idEvento;
    }
    public void setIdEvento(Integer idEvento) {
        this.idEvento = idEvento;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaEvento() {
        return fechaEvento;
    }
    public void setFechaEvento(Date fechaEvento) {
        this.fechaEvento = fechaEvento;
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
        return UsuarioCreacion;
    }
    public void setUsuarioCreacion(String usuarioCreacion) { UsuarioCreacion = usuarioCreacion; }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }
    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getUsuarioModificacion() {
        return UsuarioModificacion;
    }
    public void setUsuarioModificacion(String usuarioModificacion) { UsuarioModificacion = usuarioModificacion; }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }
    public void setFechaModificacion(Date fechaModificacion) { this.fechaModificacion = fechaModificacion; }

    public Local getLocal() {
        return local;
    }
    public void setLocal(Local local) {
        this.local = local;
    }

    public FileUpload getFoto() {
        return foto;
    }
    public void setFoto(FileUpload foto) {
        this.foto = foto;
    }

    public String getImagenURL() {
        return imagenURL;
    }

    public void setImagenURL(String imagenURL) {
        this.imagenURL = imagenURL;
    }

    //endregion


}
