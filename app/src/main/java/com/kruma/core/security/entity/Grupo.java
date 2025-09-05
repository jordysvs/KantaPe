package com.kruma.core.security.entity;

import java.util.Date;
import java.util.List;
import com.kruma.core.fileserver.entity.FileUpload;

public class Grupo {

    //region VARIABLES
    private String idModulo;
    private String idGrupo;
    private String idGrupoAnterior;
    private String descripcion;
    private Integer orden;
    private Integer idImagen;
    private String estado;
    private Integer total_Detalle;
    private String usuarioCreacion;
    private Date fechaCreacion;
    private String usuarioModificacion;
    private Date fechaModificacion;
    private List<GrupoDetalle> detalle;
    private Modulo modulo;
    private FileUpload foto;
    //endregion

    //region CONSTRUCTOR
    public Grupo() {
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

    public String getIdGrupoAnterior() {
        return idGrupoAnterior;
    }

    public void setIdGrupoAnterior(String idGrupoAnterior) {
        this.idGrupoAnterior = idGrupoAnterior;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
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

    public List<GrupoDetalle> getDetalle() {
        return detalle;
    }

    public void setDetalle(List<GrupoDetalle> detalle) {
        this.detalle = detalle;
    }

    public Modulo getModulo() {
        return modulo;
    }

    public void setModulo(Modulo modulo) {
        this.modulo = modulo;
    }

    public FileUpload getFoto() {
        return foto;
    }

    public void setFoto(FileUpload foto) {
        this.foto = foto;
    }
    //endregion
}
