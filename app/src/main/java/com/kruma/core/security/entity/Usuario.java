package com.kruma.core.security.entity;

import java.util.Date;
import java.util.List;
import com.kruma.core.business.entity.Persona;
/**
 * Created by John on 15/06/2016.
 */
public class Usuario {

    //region VARIABLES
    public String idUsuario;
    public String clave;
    public String usuarioRed;
    public Integer idPersona;
    public String flagExpiracion;
    public Date fechaExpiracion;
    public Date fechaOlvidoClave;
    public Date fechaCambioClave;
    public Date fechaUltimoLogin;
    public String sistema;
    public String estado;
    public String usuarioCreacion;
    public Date fechaCreacion;
    public String usuarioModificacion;
    public Date fechaModificacion;
    public List<Modulo> modulos;
    public List<Modulo> modulosPagina;
    public List<PerfilUsuario> perfiles;
    public Persona Persona;
    //endregion

    //region CONSTRUCTOR
    public Usuario() {
    }
    //endregion

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

    public String getUsuarioRed() {
        return usuarioRed;
    }

    public void setUsuarioRed(String usuarioRed) {
        this.usuarioRed = usuarioRed;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public String getFlagExpiracion() {
        return flagExpiracion;
    }

    public void setFlagExpiracion(String flagExpiracion) {
        this.flagExpiracion = flagExpiracion;
    }

    public Date getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(Date fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    public Date getFechaOlvidoClave() {
        return fechaOlvidoClave;
    }

    public void setFechaOlvidoClave(Date fechaOlvidoClave) {
        this.fechaOlvidoClave = fechaOlvidoClave;
    }

    public Date getFechaCambioClave() {
        return fechaCambioClave;
    }

    public void setFechaCambioClave(Date fechaCambioClave) {
        this.fechaCambioClave = fechaCambioClave;
    }

    public Date getFechaUltimoLogin() {
        return fechaUltimoLogin;
    }

    public void setFechaUltimoLogin(Date fechaUltimoLogin) {
        this.fechaUltimoLogin = fechaUltimoLogin;
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

    public List<Modulo> getModulos() {
        return modulos;
    }

    public void setModulos(List<Modulo> modulos) {
        this.modulos = modulos;
    }

    public List<Modulo> getModulosPagina() {
        return modulosPagina;
    }

    public void setModulosPagina(List<Modulo> modulosPagina) {
        this.modulosPagina = modulosPagina;
    }

    public List<PerfilUsuario> getPerfiles() {
        return perfiles;
    }

    public void setPerfiles(List<PerfilUsuario> perfiles) {
        this.perfiles = perfiles;
    }

    public com.kruma.core.business.entity.Persona getPersona() {
        return Persona;
    }

    public void setPersona(com.kruma.core.business.entity.Persona persona) {
        Persona = persona;
    }
    //endregion
}
