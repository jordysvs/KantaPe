package com.kruma.core.security.entity;

import java.util.Date;

/**
 * Created by John on 15/06/2016.
 */
public class GrupoDetalleProceso {

    //region VARIABLES
    private String idModulo;
    private String idGrupo;
    private String idDetalle;
    private Integer idProceso;
    private String descripcion;
    private String nombreControl;
    private String estado;
    private String usuarioCreacion;
    private Date fechaCreacion;
    private String usuarioModificacion;
    private Date fechaModificacion;
    private GrupoDetalle grupoDetalle;
    //endregion

    //region CONSTRUCTOR
    public GrupoDetalleProceso() {
    }
    //endregion

    //region PROPIEDADES
    public String getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(String idModulo) {
        this.idModulo = idModulo;
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

    public Integer getIdProceso() {
        return idProceso;
    }

    public void setIdProceso(Integer idProceso) {
        this.idProceso = idProceso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombreControl() {
        return nombreControl;
    }

    public void setNombreControl(String nombreControl) {
        this.nombreControl = nombreControl;
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

    public GrupoDetalle getGrupoDetalle() {
        return grupoDetalle;
    }

    public void setGrupoDetalle(GrupoDetalle grupoDetalle) {
        this.grupoDetalle = grupoDetalle;
    }
    //endregion
}
