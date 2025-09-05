package com.kruma.core.security.entity;
import java.util.Date;

/**
 * Created by John on 15/06/2016.
 */
public class PerfilGrupoDetalleAcceso {

    //region VARIABLES
    public String IdModulo;
    public String IdPerfil;
    public String IdModuloGrupo;
    public String IdGrupo;
    public String IdDetalle;
    public String Estado;
    public String UsuarioCreacion;
    public Date FechaCreacion;
    public String UsuarioModificacion;
    public Date FechaModificacion;
    public GrupoDetalle GrupoDetalle;
    public Perfil Perfil;
    //endregion

    //region CONSTRUCTOR
    public PerfilGrupoDetalleAcceso() {
    }
    //endregion

    //region PROPIEDADES
    public String getIdModulo() {
        return IdModulo;
    }

    public void setIdModulo(String idModulo) {
        IdModulo = idModulo;
    }

    public String getIdPerfil() {
        return IdPerfil;
    }

    public void setIdPerfil(String idPerfil) {
        IdPerfil = idPerfil;
    }

    public String getIdModuloGrupo() {
        return IdModuloGrupo;
    }

    public void setIdModuloGrupo(String idModuloGrupo) {
        IdModuloGrupo = idModuloGrupo;
    }

    public String getIdGrupo() {
        return IdGrupo;
    }

    public void setIdGrupo(String idGrupo) {
        IdGrupo = idGrupo;
    }

    public String getIdDetalle() {
        return IdDetalle;
    }

    public void setIdDetalle(String idDetalle) {
        IdDetalle = idDetalle;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public String getUsuarioCreacion() {
        return UsuarioCreacion;
    }

    public void setUsuarioCreacion(String usuarioCreacion) {
        UsuarioCreacion = usuarioCreacion;
    }

    public Date getFechaCreacion() {
        return FechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        FechaCreacion = fechaCreacion;
    }

    public String getUsuarioModificacion() {
        return UsuarioModificacion;
    }

    public void setUsuarioModificacion(String usuarioModificacion) {
        UsuarioModificacion = usuarioModificacion;
    }

    public Date getFechaModificacion() {
        return FechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        FechaModificacion = fechaModificacion;
    }

    public com.kruma.core.security.entity.GrupoDetalle getGrupoDetalle() {
        return GrupoDetalle;
    }

    public void setGrupoDetalle(com.kruma.core.security.entity.GrupoDetalle grupoDetalle) {
        GrupoDetalle = grupoDetalle;
    }

    public com.kruma.core.security.entity.Perfil getPerfil() {
        return Perfil;
    }

    public void setPerfil(com.kruma.core.security.entity.Perfil perfil) {
        Perfil = perfil;
    }
    //endregion
}
