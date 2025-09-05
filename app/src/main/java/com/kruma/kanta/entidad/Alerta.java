package com.kruma.kanta.entidad;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by John on 27/07/2016.
 */

public class Alerta {

    //region ATRIBUTOS
    @SerializedName("IdLocal")
    private Integer idLocal;
    @SerializedName("IdUbicacion")
    private Integer idUbicacion;
    @SerializedName("IdAlerta")
    private Integer idAlerta;
    @SerializedName("IdAlertaTipo")
    private Integer idAlertaTipo;
    @SerializedName("FechaAlerta")
    private Date fechaAlerta;
    @SerializedName("FechaAtencion")
    private Date fechaAtencion;
    @SerializedName("IdUsuario")
    private String idUsuario;
    @SerializedName("Estado")
    private String estado;
    @SerializedName("UsuarioCreacion")
    private String usuarioCreacion;
    @SerializedName("FechaCreacion")
    private Date fechaCreacion;
    @SerializedName("UsuarioModificacion")
    private String usuarioModificacion;
    @SerializedName("FechaModificacion")
    private Date fechaModificacion;
    @SerializedName("Local")
    private Local local;
    @SerializedName("Ubicacion")
    private Local ubicacion;
    @SerializedName("AlertaTipo")
    private AlertaTipo alertaTipo;
    @SerializedName("Apertura")
    private Apertura apertura;
    @SerializedName("Usuario")
    private com.kruma.core.security.entity.Usuario usuario;
    //endregion

    //region PROPIEDADES
    public Integer getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(Integer idLocal) {
        this.idLocal = idLocal;
    }

    public Integer getIdUbicacion() {
        return idUbicacion;
    }

    public void setIdUbicacion(Integer idUbicacion) {
        this.idUbicacion = idUbicacion;
    }
    public Integer getIdAlerta() {
        return idAlerta;
    }

    public void setIdAlerta(Integer idAlerta) {
        this.idAlerta = idAlerta;
    }

    public Integer getIdAlertaTipo() {
        return idAlertaTipo;
    }

    public void setIdAlertaTipo(Integer idAlertaTipo) {
        this.idAlertaTipo = idAlertaTipo;
    }

    public Date getechaAlerta() {
        return fechaAlerta;
    }

    public void setFechaAlerta(Date fechaAlerta) {
        this.fechaAlerta = fechaAlerta;
    }

    public Date getechaAtencion() {
        return fechaAtencion;
    }

    public void setFechaAtencion(Date fechaAtencion) {
        this.fechaAtencion = fechaAtencion;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
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

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public AlertaTipo getAlertaTipo() {
        return alertaTipo;
    }

    public void setAlertaTipo(AlertaTipo alertaTipo) {
        this.alertaTipo = alertaTipo;
    }


    public com.kruma.core.security.entity.Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(com.kruma.core.security.entity.Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getFechaAlerta() {
        return fechaAlerta;
    }

    public Date getFechaAtencion() {
        return fechaAtencion;
    }

    public Local getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Local ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Apertura getApertura() {
        return apertura;
    }

    public void setApertura(Apertura apertura) {
        this.apertura = apertura;
    }

    //endregion
}
