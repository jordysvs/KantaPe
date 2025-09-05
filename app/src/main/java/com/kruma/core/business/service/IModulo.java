package com.kruma.core.business.service;

import com.kruma.core.business.entity.Modulo;
import com.kruma.core.service.entity.ServiceResult;
import com.kruma.core.util.common.List;

import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by John on 27/06/2016.
 */
public interface IModulo {

    @GET("/Modulo_Listar/{IdModulo}/{Codigo}/{Descripcion}/{Estado}/{NumPagina}/{TamPagina}")
    ServiceResult<List<Modulo>> Listar(
            @Path("IdModulo") String str_pIdModulo,
            @Path("Codigo") String str_pCodigo,
            @Path("Descripcion") String str_pDescripcion,
            @Path("Estado") String str_pEstado,
            @Path("NumPagina") String str_pNumPagina,
            @Path("TamPagina") String str_pTamPagina);
}
