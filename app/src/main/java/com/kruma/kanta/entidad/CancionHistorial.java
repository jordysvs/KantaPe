package com.kruma.kanta.entidad;

import java.io.Serializable;

/**
 * Created by Enrique on 06/09/2016.
 */
public class CancionHistorial implements Serializable {
	
	// Identificador de producto
    private int idCancion;

    // Atributos base
    private String titulo;
    private String artista;
	private String genero;
	private String idioma;
    private int foto;

    public CancionHistorial() {
    }

    public CancionHistorial(int idCancion, String titulo, String artista, String genero, String idioma, int foto) {
        this.idCancion = idCancion;
        this.titulo = titulo;
        this.artista = artista;
        this.genero = genero;
        this.idioma = idioma;
        this.foto = foto;
    }

    public CancionHistorial(int idCancion, String titulo, String artista, String genero, String idioma) {
        this.idCancion = idCancion;
        this.titulo = titulo;
        this.artista = artista;
        this.genero = genero;
        this.idioma = idioma;
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

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
