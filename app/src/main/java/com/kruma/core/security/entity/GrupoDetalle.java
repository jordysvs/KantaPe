package com.kruma.core.security.entity;

import java.util.Date;
import java.util.List;

import com.kruma.core.fileserver.entity.FileUpload;

public class GrupoDetalle {

    //region VARIABLES
    private String idModulo;
    private String idGrupo;
    private String idDetalle;
    private String descripcion;
    private String idDetallePadre;
    private Integer orden;
    private String url;
    private String flagVisible;
    private Integer idImagen;
    private String estado;
    private Integer total_Detalle;
    private String usuarioCreacion;
    private Date fechaCreacion;
    private String usuarioModificacion;
    private Date fechaModificacion;
    private String idGrupoAnterior;
    private Grupo grupo;
    private List<GrupoDetalle> detalle;
    private List<GrupoDetalleProceso> proceso;
    private Boolean seleccion;
    private FileUpload foto;
    //endregion

    //region CONSTRUCTOR
    public GrupoDetalle() {
    }
    //enregion

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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getIdDetallePadre() {
        return idDetallePadre;
    }

    public void setIdDetallePadre(String idDetallePadre) {
        this.idDetallePadre = idDetallePadre;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFlagVisible() {
        return flagVisible;
    }

    public void setFlagVisible(String flagVisible) {
        this.flagVisible = flagVisible;
    }

    public Integer getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(Integer idImagen) {
        this.idImagen = idImagen;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getTotal_Detalle() {
        return total_Detalle;
    }

    public void setTotal_Detalle(Integer total_Detalle) {
        this.total_Detalle = total_Detalle;
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

    public String getIdGrupoAnterior() {
        return idGrupoAnterior;
    }

    public void setIdGrupoAnterior(String idGrupoAnterior) {
        this.idGrupoAnterior = idGrupoAnterior;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public List<GrupoDetalle> getDetalle() {
        return detalle;
    }

    public void setDetalle(List<GrupoDetalle> detalle) {
        this.detalle = detalle;
    }

    public List<GrupoDetalleProceso> getProceso() {
        return proceso;
    }

    public void setProceso(List<GrupoDetalleProceso> proceso) {
        this.proceso = proceso;
    }

    public Boolean getSeleccion() {
        return seleccion;
    }

    public void setSeleccion(Boolean seleccion) {
        this.seleccion = seleccion;
    }

    public FileUpload getFoto() {
        return foto;
    }

    public void setFoto(FileUpload foto) {
        this.foto = foto;
    }
    //endregion
}
