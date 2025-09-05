package com.kruma.kanta.service;

import com.kruma.core.service.entity.ServiceCallback;
import com.kruma.core.util.common.List;
import com.kruma.kanta.entidad.Cancion;
import com.kruma.kanta.entidad.LocalCancion;

import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by John on 27/07/2016.
 */

public interface ICancion {

    @GET("/Listar/{IdGenero}/{IdIdioma}/{PalabraClave}/{NumPagina}/{TamPagina}")
    void Listar(
            @Path("IdGenero") String str_pIdGenero,
            @Path("IdIdioma") String str_pIdIdioma,
            @Path("PalabraClave") String str_pPalabraClave,
            @Path("NumPagina") String str_pNumPagina,
            @Path("TamPagina") String str_pTamPagina,
            ServiceCallback<List<Cancion>> obj_pCallBack);
}
