package com.kruma.kanta.entidad;

import com.google.gson.annotations.SerializedName;
import com.kruma.core.security.entity.Usuario;

import java.util.Date;

/**
 * Created by John  on 27/07/2016.
 */

public class AperturaCancion {

    //region ATRIBUTOS
    @SerializedName("IdLocal")
    private Integer idLocal;
    @SerializedName("IdApertura")
    private Integer idApertura;
    @SerializedName("IdAperturaCancionSolicitud")
    private Integer idAperturaCancionSolicitud;
    @SerializedName("IdAperturaCancion")
    private Integer idAperturaCancion;
    @SerializedName("IdUsuario")
    private String idUsuario;
    @SerializedName("IdLocalCancion")
    private Integer idLocalCancion;
    @SerializedName("IdAperturaCancionTipo")
    private Integer idAperturaCancionTipo;
    @SerializedName("Orden")
    private Integer orden;
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
    @SerializedName("Local")
    private Local local;
    @SerializedName("Album")
    private Album album;

    @SerializedName("Artista")
    private Artista artista;

    @SerializedName("LocalCancion")
    private LocalCancion localCancion;
    @SerializedName("Usuario")
    private com.kruma.core.security.entity.Usuario usuario;
    //endregion

    //region PROPIEDADES

    public Integer getIdLocal() {
        return idLocal;
    }
    public void setIdLocal(Integer idLocal) {
        this.idLocal = idLocal;
    }

    public Integer getIdApertura() {
        return idApertura;
    }
    public void setIdApertura(Integer idApertura) {
        this.idApertura = idApertura;
    }

    public Integer getIdAperturaCancionSolicitud() { return idAperturaCancionSolicitud; }
    public void setIdAperturaCancionSolicitud(Integer idAperturaCancionSolicitud) { this.idAperturaCancionSolicitud = idAperturaCancionSolicitud; }

    public Integer getIdAperturaCancion() {
        return idAperturaCancion;
    }
    public void setIdAperturaCancion(Integer idAperturaCancion) { this.idAperturaCancion = idAperturaCancion; }

    public String getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdLocalCancion() {
        return idLocalCancion;
    }
    public void setIdLocalCancion(Integer idLocalCancion) {
        this.idLocalCancion = idLocalCancion;
    }

    public Integer getIdAperturaCancionTipo() {
        return idAperturaCancionTipo;
    }
    public void setIdAperturaCancionTipo(Integer idAperturaCancionTipo) { this.idAperturaCancionTipo = idAperturaCancionTipo; }

    public Integer getOrden() {
        return orden;
    }
    public void setOrden(Integer orden) {
        this.orden = orden;
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

    public Local getLocal() {
        return local;
    }
    public void setLocal(Local local) {
        this.local = local;
    }

    public LocalCancion getLocalCancion() {
        return localCancion;
    }
    public void setLocalCancion(LocalCancion localCancion) {
        this.localCancion = localCancion;
    }

    public com.kruma.core.security.entity.Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }


    //endregion
}
