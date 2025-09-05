package com.kruma.core.security.entity;

import java.util.Date;
import java.util.List;

/**
 * Created by John on 15/06/2016.

 */
public class Perfil {

    //region VARIABLES
    public String idModulo;
    public String idPerfil;
    public String descripcion;
    public String sistema;
    public String estado;
    public String usuarioCreacion;
    public Date fechaCreacion;
    public String usuarioModificacion;
    public Date fechaModificacion;
    public List<PerfilGrupoDetalleAcceso> accesos;
    public Modulo modulo;
    //endregion

    //region CONSTRUCTOR
    public Perfil() {
    }
    //endregion

    //region PROPIEDADES
    public String getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(String idModulo) {
        this.idModulo = idModulo;
    }

    public String getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(String idPerfil) {
        this.idPerfil = idPerfil;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public List<PerfilGrupoDetalleAcceso> getAccesos() {
        return accesos;
    }

    public void setAccesos(List<PerfilGrupoDetalleAcceso> accesos) {
        this.accesos = accesos;
    }

    public Modulo getModulo() {
        return modulo;
    }

    public void setModulo(Modulo modulo) {
        this.modulo = modulo;
    }
    //endregion
}
