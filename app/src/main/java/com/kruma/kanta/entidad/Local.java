package com.kruma.kanta.entidad;

import com.google.gson.annotations.SerializedName;
import com.kruma.core.business.entity.PersonaDireccion;
import com.kruma.core.fileserver.entity.FileUpload;

import java.math.BigDecimal;

/**
 * Created by John on 27/07/2016.
 */

public class Local extends PersonaDireccion {

    //region ATRIBUTOS
    @SerializedName("IdLocal")
    private Integer idLocal;
    @SerializedName("IdEmpresa")
    private Integer idEmpresa;
    @SerializedName("IdImagen")
    private Integer idImagen;
    @SerializedName("Foto")
    private com.kruma.core.fileserver.entity.FileUpload foto;
    @SerializedName("Empresa")
    private com.kruma.kanta.entidad.Empresa Empresa;

    @SerializedName("ImagenURL")
    private String imagenURL;

    @SerializedName("Radio")
    private BigDecimal radio;

    @SerializedName("FlagLocalizacion")
    private String flagLocalizacion;

    //endregion

    //region PROPIEDADES
    public Integer getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(Integer idLocal) {
        this.idLocal = idLocal;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Integer getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(Integer idImagen) {
        this.idImagen = idImagen;
    }

    public FileUpload getFoto() {
        return foto;
    }

    public void setFoto(FileUpload foto) {
        this.foto = foto;
    }

    public com.kruma.kanta.entidad.Empresa getEmpresa() {
        return Empresa;
    }

    public void setEmpresa(com.kruma.kanta.entidad.Empresa empresa) {
        Empresa = empresa;
    }

    public String getImagenURL() {
        return imagenURL;
    }

    public void setImagenURL(String imagenURL) {
        this.imagenURL = imagenURL;
    }

    public BigDecimal getRadio() {
        return radio;
    }

    public void setRadio(BigDecimal radio) {
        this.radio = radio;
    }

    public String getFlagLocalizacion() {
        return flagLocalizacion;
    }

    public void setFlagLocalizacion(String flagLocalizacion) {
        this.flagLocalizacion = flagLocalizacion;
    }


    //endregion
}
