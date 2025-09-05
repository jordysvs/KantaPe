package com.kruma.kanta.entidad;

import java.io.Serializable;

/**
 * Created by Enrique on 08/09/2016.
 */
public class CancionMiLista implements Serializable {

    // Identificador de producto
    private int idCancion;

    // Atributos base
    private String titulo;
    private String artista;
    private String genero;
    private String idioma;
    private int estado;
    private int foto;

    public CancionMiLista() {
    }

    public CancionMiLista(int idCancion, String titulo, String artista, String genero, String idioma, int estado, int foto) {
        this.idCancion = idCancion;
        this.titulo = titulo;
        this.artista = artista;
        this.genero = genero;
        this.idioma = idioma;
        this.estado = estado;
        this.foto = foto;
    }

    public int getIdCancion() {
        return idCancion;
    }

    public void setIdCancion(int idCancion) {
        this.idCancion = idCancion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
