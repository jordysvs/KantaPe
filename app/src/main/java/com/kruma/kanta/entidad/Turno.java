package com.kruma.kanta.entidad;

import java.io.Serializable;

/**
 * Created by Enrique on 05/09/2016.
 */
public class Turno implements Serializable {

    // Identificador de producto
    private int idTurno;

    // Atributos base
    private String mesa;
    private String tiempo;
    private int alarma;

    public Turno() {
    }

    public Turno(int idTurno, String mesa, String tiempo, int alarma) {
        this.idTurno = idTurno;
        this.mesa = mesa;
        this.tiempo = tiempo;
        this.alarma = alarma;
    }

    public Turno(int idTurno, String mesa, String tiempo) {
        this.idTurno = idTurno;
        this.mesa = mesa;
        this.tiempo = tiempo;
    }

    public int getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(int idTurno) {
        this.idTurno = idTurno;
    }

    public String getMesa() {
        return mesa;
    }

    public void setMesa(String mesa) {
        this.mesa = mesa;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public int getAlarma() {
        return alarma;
    }

    public void setAlarma(int alarma) {
        this.alarma = alarma;
    }
}
