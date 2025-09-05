package com.kruma.kanta.entidad;

import com.google.gson.annotations.SerializedName;

/**
 * Created by John on 27/07/2016.
 */

public class Empresa extends com.kruma.core.business.entity.Persona {

    //region ATRIBUTOS

    @SerializedName("IdEmpresa")
    private Integer idEmpresa;

    //@SerializedName("IdLocal")
    //public List<EmpresaArea> Areas ;
    //@SerializedName("IdLocal")
    //public List<EmpresaPuesto> Puestos { get; set; }
    //endregion

    //region PROPIEDADES
    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }
    //endregion

}
