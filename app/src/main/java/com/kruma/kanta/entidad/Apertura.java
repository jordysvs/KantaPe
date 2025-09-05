package com.kruma.kanta.entidad;

import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by John on 27/07/2016.
 */

public class Apertura {

    //region ATRIBUTOS
    @SerializedName("IdLocal")
    private Integer idLocal;
    @SerializedName("IdApertura")
    private Integer idApertura;
    @SerializedName("IdMozo")
    private Integer idMozo;
    @SerializedName("FechaApertura")
    private Date fechaApertura;
    @SerializedName("FechaFinal")
    private Date fechaFinal;
    @SerializedName("Total")
    private BigDecimal total;
    @SerializedName("IdAlerta")
    private Integer idAlerta;
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
    @SerializedName("Empleado")
    private Empleado empleado;
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

    public Integer getIdMozo() {
        return idMozo;
    }

    public void setIdMozo(Integer idMozo) {
        this.idMozo = idMozo;
    }

    public Date getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(Date fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Integer getIdAlerta() {
        return idAlerta;
    }

    public void setIdAlerta(Integer idAlerta) {
        this.idAlerta = idAlerta;
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

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    //endregion
}
