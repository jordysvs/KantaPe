package com.kruma.core.security.entity;

import java.util.Date;

/**
 * Created by John on 15/06/2016.
 */
public class PerfilGrupoDetalleProcesoAcceso {

    //region VARIABLES
    public String idModulo;
    public String idPerfil;
    public String idGrupo;
    public String idDetalle;
    public String idProceso;
    public String estado;
    public String usuarioCreacion;
    public Date fechaCreacion;
    public String usuarioModificacion;
    public Date fechaModificacion;
    public GrupoDetalleProceso grupoDetalleProceso;

    //endregion

    //region CONSTRUCTOR
    public PerfilGrupoDetalleProcesoAcceso() {
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

    public String getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(String idGrupo) {
        this.idGrupo = idGrupo;
    }

    public String getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(String idDetalle) {
        this.idDetalle = idDetalle;
    }

    public String getIdProceso() {
        return idProceso;
    }

    public void setIdProceso(String idProceso) {
        this.idProceso = idProceso;
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

    public GrupoDetalleProceso getGrupoDetalleProceso() {
        return grupoDetalleProceso;
    }

    public void setGrupoDetalleProceso(GrupoDetalleProceso grupoDetalleProceso) {
        this.grupoDetalleProceso = grupoDetalleProceso;
    }

    //endregion
}


