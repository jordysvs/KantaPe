package com.kruma.kanta.service;

import com.kruma.core.service.entity.ServiceCallback;
import com.kruma.core.util.common.List;
import com.kruma.kanta.entidad.Local;
import com.kruma.kanta.entidad.LocalCancion;
import com.kruma.kanta.entidad.Pais;

import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by John on 27/07/2016.
 */

public interface ILocal {

    @GET("/ListarLocal/{IdLocalCancion}/{IdPais}/{PalabraClave}/{NumPagina}/{TamPagina}")
    void Listar(
            @Path("IdLocalCancion") String str_pIdLocalCancion,
            @Path("IdPais") String str_pIdPais,
            @Path("PalabraClave") String str_pPalabraClave,
            @Path("NumPagina") String str_pNumPagina,
            @Path("TamPagina") String str_pTamPagina,
            ServiceCallback<List<Local>> obj_pCallBack);

    @GET("/ObtenerLocal/{IdLocal}")
    void Obtener(
            @Path("IdLocal") String str_pIdLocal,
            ServiceCallback<Local> obj_pCallBack);

    @GET("/ListarPais")
    void ListarPais(ServiceCallback<List<Pais>> obj_pCallBack);

}
