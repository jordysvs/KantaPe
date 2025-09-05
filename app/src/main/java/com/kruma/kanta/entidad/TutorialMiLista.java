package com.kruma.kanta.entidad;

import java.io.Serializable;

/**
 * Created by Enrique on 08/09/2016.
 */
public class TutorialMiLista implements Serializable {

    // Identificador de producto
    private int idTutorial;

    private int foto;

    public TutorialMiLista() {
    }

    public TutorialMiLista(int idTutorial, int foto) {
        this.idTutorial = idTutorial;
        this.foto = foto;
    }


    public int getIdTutorial() {
        return idTutorial;
    }

    public void setIdTutorial(int idTutorial) {
        this.idTutorial = idTutorial;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
