package com.kruma.kanta.entidad;

import com.google.gson.annotations.SerializedName;
import com.kruma.core.business.entity.Persona;

import java.util.Date;

/**
 * Created by Enrique on 25/07/2016.
 */
public class Usuario {

    //region VARIABLES
    @SerializedName("IdUsuario")
    public String idUsuario;

    @SerializedName("Clave")
    public String clave;

    @SerializedName("Nombres")
    public String nombres;

    @SerializedName("ApellidoPaterno")
    public String apellidoPaterno;

    @SerializedName("ApellidoMaterno")
    public String apellidoMaterno;

    @SerializedName("NombreCompleto")
    public String nombreCompleto;

    @SerializedName("Mail")
    public String mail;

    @SerializedName("FechaNacimiento")
    public Date fechaNacimiento;

    @SerializedName("IdTipoDocumento")
    public int idTipoDocumento;

    @SerializedName("NumeroDocumento")
    public String numeroDocumento;

    @SerializedName("IdEstadoCivil")
    public int idEstadoCivil;

    @SerializedName("Genero")
    public int idGenero;

    @SerializedName("FlagMozo")
    public String flagMozo;

    @SerializedName("Estado")
    public String estado;

    @SerializedName("UsuarioCreacion")
    public String usuarioCreacion;

    @SerializedName("FechaCreacion")
    public Date fechaCreacion;

    @SerializedName("UsuarioModificacion")
    public String usuarioModificacion;

    @SerializedName("FechaModificacion")
    public Date fechaModificacion;

    @SerializedName("IdToken")
    public String idToken;

    @SerializedName("FechaNacimientoString")
    public String fechaNacimientoString;

    @SerializedName("FechaNacimientoFormat")
    public String fechaNacimientoFormat;

    @SerializedName("Persona")
    private Persona persona;

    //region CONSTRUCTOR
    public Usuario() {
    }

    //region PROPIEDADES
    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(int idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public int getIdEstadoCivil() {
        return idEstadoCivil;
    }

    public void setIdEstadoCivil(int idEstadoCivil) {
        this.idEstadoCivil = idEstadoCivil;
    }

    public int getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(int idGenero) {
        this.idGenero = idGenero;
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

    public String getFlagMozo() {
        return flagMozo;
    }

    public void setFlagMozo(String flagMozo) {
        this.flagMozo = flagMozo;
    }

    public String getIdToken() {
        return idToken;
    }

    public void setIdToken(String idToken) {
        this.idToken = idToken;
    }

    public String getFechaNacimientoString() {
        return fechaNacimientoString;
    }

    public void setFechaNacimientoString(String fechaNacimientoString) {
        this.fechaNacimientoString = fechaNacimientoString;
    }

    public String getFechaNacimientoFormat() {
        return fechaNacimientoFormat;
    }

    public void setFechaNacimientoFormat(String fechaNacimientoFormat) {
        this.fechaNacimientoFormat = fechaNacimientoFormat;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
}









