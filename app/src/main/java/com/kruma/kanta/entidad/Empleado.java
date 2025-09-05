package com.kruma.kanta.entidad;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by John on 27/07/2016.
 */

public class Empleado {

    //region ATRIBUTOS
    @SerializedName("IdArea")
    private Integer idArea;
    @SerializedName("IdEmpleado")
    private Integer idEmpleado;
    @SerializedName("IdEmpresa")
    private Integer idEmpresa;
    @SerializedName("IdPersona")
    private Integer idPersona;
    @SerializedName("IdPuesto")
    private Integer idPuesto;
    @SerializedName("Persona")
    private com.kruma.core.business.entity.Persona Persona;
//    @SerializedName("Puesto")
//    private Puesto Puesto;
//    @SerializedName("Area")
//    private Area Area;
    @SerializedName("Empresa")
    private Empresa empresa;
    @SerializedName("Estado")
    private String estado;
    @SerializedName("UsuarioCreacion")
    private String usuarioCreacion;
    @SerializedName("UsuarioModificacion")
    private String usuarioModificacion;
    @SerializedName("FechaCreacion")
    private Date fechaCreacion;
    @SerializedName("FechaIngreso")
    private Date fechaIngreso;
    @SerializedName("FechaModificacion")
    private Date fechaModificacion;
    //endregion

    //region PROPIEDADES

    public Integer getIdArea() {
        return idArea;
    }

    public void setIdArea(Integer idArea) {
        this.idArea = idArea;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public Integer getIdPuesto() {
        return idPuesto;
    }

    public void setIdPuesto(Integer idPuesto) {
        this.idPuesto = idPuesto;
    }

    public com.kruma.core.business.entity.Persona getPersona() {
        return Persona;
    }

    public void setPersona(com.kruma.core.business.entity.Persona persona) {
        Persona = persona;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
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

    public String getUsuarioModificacion() {
        return usuarioModificacion;
    }

    public void setUsuarioModificacion(String usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    //endregion
}
