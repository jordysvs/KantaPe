package com.kruma.core.security.entity;
import java.util.Date;
import java.util.List;

import com.kruma.core.fileserver.entity.FileUpload;

/**
 * Created by John on 15/06/2016.
 */
public class Modulo {

    //region VARIABLES
    private String idmodulo;
    private String descripcion;
    private Integer idimagen;
    private String estado;
    private String usuarioCreacion;
    private Date fechaCreacion;
    private String usuarioModificacion;
    private Date fechaModificacion;
    private FileUpload foto;
    private List<Grupo> grupos;
    //endregion

    //region CONSTRUCTOR
    public Modulo() {
    }
    //endregion

    //region PROPIEDADES
    public String getIdmodulo() {
        return idmodulo;
    }

    public void setIdmodulo(String idmodulo) {
        this.idmodulo = idmodulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getIdimagen() {
        return idimagen;
    }

    public void setIdimagen(Integer idimagen) {
        this.idimagen = idimagen;
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

    public FileUpload getFoto() {
        return foto;
    }

    public void setFoto(FileUpload foto) {
        this.foto = foto;
    }

    public List<Grupo> getGrupos() {
        return grupos;
    }

    public void setGrupos(List<Grupo> grupos) {
        this.grupos = grupos;
    }
    //endregion
}
