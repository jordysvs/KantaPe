package com.kruma.kanta.entidad;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by John  on 27/07/2016.
 */

public class LocalCancion {

    //region ATRIBUTOS
    @SerializedName("IdLocalCancion")
    private Integer idLocalCancion;
    @SerializedName("IdEmpresa")
    private Integer idEmpresa;
    @SerializedName("IdLocal")
    private Integer idLocal;
    @SerializedName("IdCancion")
    private Integer idCancion;
    @SerializedName("Titulo")
    private String titulo;
    @SerializedName("IdArtista")
    private Integer idArtista;
    @SerializedName("IdAlbum")
    private Integer IdAlbum;
    @SerializedName("IdGenero")
    private Integer idGenero;
    @SerializedName("IdIdioma")
    private Integer idIdioma;
    @SerializedName("Decada")
    private String decada;
    @SerializedName("Version")
    private String version;
    @SerializedName("NombreArchivo")
    private String nombreArchivo;
    @SerializedName("FechaRegistro")
    private Date fechaRegistro;
    @SerializedName("Anio")
    private Integer anio;
    @SerializedName("Letra")
    private String letra;
    @SerializedName("Duracion")
    private Integer duracion;
    @SerializedName("Youtube")
    private String youtube;
    @SerializedName("ImagenURL")
    private String imagenURL;
    @SerializedName("IdCancionSolicitud")
    private Integer idCancionSolicitud;
    @SerializedName("Estado")
    private String estado;
    @SerializedName("UsuarioCreacion")
    private String usuarioCreacion;
    @SerializedName("DesEmpresa")
    private String desEmpresa;
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
    @SerializedName("Local")
    private Local local;
    @SerializedName("Cancion")
    private Cancion cancion;
    @SerializedName("CancionSolicitud")
    private CancionSolicitud cancionSolicitud;
    //endregion

    //region PROPIEDADES

    public Integer getIdLocalCancion() {
        return idLocalCancion;
    }

    public void setIdLocalCancion(Integer idLocalCancion) {
        this.idLocalCancion = idLocalCancion;
    }



    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Integer getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(Integer idLocal) {
        this.idLocal = idLocal;
    }

    public Integer getIdCancion() {
        return idCancion;
    }

    public void setIdCancion(Integer idCancion) {
        this.idCancion = idCancion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getIdArtista() {
        return idArtista;
    }

    public void setIdArtista(Integer idArtista) {
        this.idArtista = idArtista;
    }

    public Integer getIdAlbum() {
        return IdAlbum;
    }

    public void setIdAlbum(Integer idAlbum) {
        IdAlbum = idAlbum;
    }

    public Integer getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(Integer idGenero) {
        this.idGenero = idGenero;
    }

    public Integer getIdIdioma() {
        return idIdioma;
    }

    public void setIdIdioma(Integer idIdioma) {
        this.idIdioma = idIdioma;
    }

    public String getDecada() {
        return decada;
    }

    public void setDecada(String decada) {
        this.decada = decada;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public String getYoutube() {
        return youtube;
    }

    public void setYoutube(String youtube) {
        this.youtube = youtube;
    }

    public Integer getIdCancionSolicitud() {
        return idCancionSolicitud;
    }

    public void setIdCancionSolicitud(Integer idCancionSolicitud) {
        this.idCancionSolicitud = idCancionSolicitud;
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

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public Cancion getCancion() {
        return cancion;
    }

    public void setCancion(Cancion cancion) {
        this.cancion = cancion;
    }

    public CancionSolicitud getCancionSolicitud() {
        return cancionSolicitud;
    }

    public void setCancionSolicitud(CancionSolicitud cancionSolicitud) {
        this.cancionSolicitud = cancionSolicitud;
    }

    public String getImagenURL() {
        return imagenURL;
    }

    public void setImagenURL(String imagenURL) {
        this.imagenURL = imagenURL;
    }

    public String getDesEmpresa() {
        return desEmpresa;
    }

    public void setDesEmpresa(String desEmpresa) {
        this.desEmpresa = desEmpresa;
    }


    //endregion
}
