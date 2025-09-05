package com.kruma.core.business.entity;

import com.google.gson.annotations.SerializedName;
import com.kruma.core.fileserver.entity.FileUpload;

import java.util.Date;

/**
 * Created by John on 15/06/2016.
 */
public class Persona {

    //region VARIABLES
    @SerializedName("IdPersona")
    private Integer idPersona;

    @SerializedName("ApellidoPaterno")
    private String apellidoPaterno;

    @SerializedName("ApellidoMaterno")
    private String apellidoMaterno;

    @SerializedName("Nombres")
    private String nombres;

    @SerializedName("NombreCompleto")
    private String nombreCompleto;

    @SerializedName("Mail")
    private String mail;

    @SerializedName("Sistema")
    private String sistema;

    @SerializedName("Estado")
    private String estado;

    @SerializedName("IdTipoDocumento")
    private Integer idTipoDocumento;

    @SerializedName("NumeroDocumento")
    private String numeroDocumento;

    @SerializedName("Celular")
    private String celular;

    @SerializedName("UsuarioCreacion")
    private String usuarioCreacion;

    @SerializedName("FechaCreacion")
    private Date fechaCreacion;

    @SerializedName("UsuarioModificacion")
    private String usuarioModificacion;

    @SerializedName("FechaModificacion")
    private Date fechaModificacion;

    @SerializedName("TipoDocumento")
    private TipoDocumento tipoDocumento;

    @SerializedName("FechaNacimiento")
    private Date fechaNacimiento;

    @SerializedName("Foto")
    private FileUpload foto;
    //endregion

    //region PROPIEDADES
    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
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

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
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

    public String getSistema() {
        return sistema;
    }

    public void setSistema(String sistema) {
        this.sistema = sistema;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(Integer idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
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

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public FileUpload getFoto() {
        return foto;
    }

    public void setFoto(FileUpload foto) {
        this.foto = foto;
    }
    //endregion
}

