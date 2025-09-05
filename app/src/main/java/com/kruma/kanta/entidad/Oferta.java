package com.kruma.kanta.entidad;

import com.google.gson.annotations.SerializedName;
import com.kruma.core.fileserver.entity.FileUpload;

import java.util.Date;

/**
 * Created by Carlos Gomez on 21/10/2016.
 */

public class Oferta {

    //region ATRIBUTOS
    @SerializedName("IdLocal")
    private Integer idLocal;
    @SerializedName("IdOferta")
    private Integer idOferta;
    @SerializedName("Nombre")
    private String nombre;
    @SerializedName("Descripcion")
    private String descripcion;
    @SerializedName("FechaOferta")
    private Date fechaOferta;
    @SerializedName("FechaVencimiento")
    private Date fechaVencimiento;
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

    //region PROPIEDADES
    public Integer getIdLocal() {
        return idLocal;
    }
    public void setIdLocal(Integer idLocal) {
        this.idLocal = idLocal;
    }

    public Integer getIdOferta() {
        return idOferta;
    }
    public void setIdOferta(Integer idOferta) {
        this.idOferta = idOferta;
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

    public Date getFechaOferta() {
        return fechaOferta;
    }
    public void setFechaOferta(Date fechaOferta) {
        this.fechaOferta = fechaOferta;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }
    public void setFechaVencimiento(Date fechaVencimiento) { this.fechaVencimiento = fechaVencimiento; }

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
    public void setUsuarioCreacion(String usuarioCreacion) {
        UsuarioCreacion = usuarioCreacion;
    }

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
    //endregion


    public String getImagenURL() {
        return imagenURL;
    }

    public void setImagenURL(String imagenURL) {
        this.imagenURL = imagenURL;
    }
}
