package com.kruma.kanta.entidad;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by John  on 27/07/2016.
 */

public class Cancion {

    //region ATRIBUTOS
    @SerializedName("IdCancion")
    private Integer idCancion;
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


    @SerializedName("Artista")
    private Artista artista;
    @SerializedName("Album")
    private Album album;
    @SerializedName("Genero")
    private Genero genero;
    @SerializedName("Idioma")
    private Idioma idioma;
    //endregion

    //region PROPIEDADES
    public Integer getIdCancion() {
        return idCancion;
    }

    public void setIdCancion(Integer idCancion) {
        this.idCancion = idCancion;
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

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    //endregion
}
