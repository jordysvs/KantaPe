package com.kruma.core.business.service;

import com.kruma.core.business.entity.TipoDocumento;
import com.kruma.core.service.entity.ServiceCallback;
import com.kruma.core.util.common.List;

import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by John on 27/06/2016.
 */
public interface ITipoDocumento {

    @GET("/TipoDocumento/Listar/{Codigo}/{Descripcion}/{Estado}/{NumPagina}/{TamPagina}")
    void Listar(
            @Path("Codigo") String str_pCodigo,
            @Path("Descripcion") String str_pDescripcion,
            @Path("Estado") String str_pEstado,
            @Path("NumPagina") String str_pNumPagina,
            @Path("TamPagina") String str_pTamPagina,
            ServiceCallback<List<TipoDocumento>> obj_pCallBack);
}
