package com.kruma.kanta.entidad;

import com.google.gson.annotations.SerializedName;
import com.kruma.core.fileserver.entity.FileUpload;

import java.util.Date;

/**
 * Created by Enrique on 05/09/2016.
 */
public class Carta {

    //region ATRIBUTOS
    @SerializedName("IdLocal")
    private Integer idLocal;
    @SerializedName("IdProducto")
    private Integer idProducto;
    @SerializedName("Nombre")
    private String nombre;
    @SerializedName("IdProductoTipo")
    private Integer idProductoTipo;
    @SerializedName("Costo")
    private double costo;
    @SerializedName("Precio")
    private double precio;
    @SerializedName("IdImagen")
    private Integer idImagen;
    @SerializedName("ImagenURL")
    private String imagenURL;
    @SerializedName("Estado")
    private String estado;
    @SerializedName("UsuarioCreacion")
    private String UsuarioCreacion;
    @SerializedName("FechaCreacion")
    private Date fechaCreacion;
    @SerializedName("UsuarioModificacion")
    private String UsuarioModificacion;
    @SerializedName("FechaModificacion")
    private Date fechaModificacion;
    @SerializedName("Local")
    private Local local;

    //@SerializedName("Insumos")
    //private List<LocalInsumo> insumos;

    //@SerializedName("ProductoTipo")
    //private ProductoTipo productoTipo;

    @SerializedName("Foto")
    private com.kruma.core.fileserver.entity.FileUpload foto;
    //endregion


    public Integer getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(Integer idLocal) {
        this.idLocal = idLocal;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdProductoTipo() {
        return idProductoTipo;
    }

    public void setIdProductoTipo(Integer idProductoTipo) {
        this.idProductoTipo = idProductoTipo;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
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

    public String getUsuarioCreacion() {
        return UsuarioCreacion;
    }

    public void setUsuarioCreacion(String usuarioCreacion) {
        UsuarioCreacion = usuarioCreacion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getUsuarioModificacion() {
        return UsuarioModificacion;
    }

    public void setUsuarioModificacion(String usuarioModificacion) {
        UsuarioModificacion = usuarioModificacion;
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

    public FileUpload getFoto() {
        return foto;
    }

    public void setFoto(FileUpload foto) {
        this.foto = foto;
    }

    public String getImagenURL() {
        return imagenURL;
    }

    public void setImagenURL(String imagenURL) {
        this.imagenURL = imagenURL;
    }
}
