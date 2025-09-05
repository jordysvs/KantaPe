package com.kruma.kanta.service;

import com.kruma.core.service.entity.ServiceCallback;
import com.kruma.core.util.common.List;
import com.kruma.core.util.common.ProcessResult;
import com.kruma.kanta.entidad.AperturaUsuario;

import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;

/**
 * Created by Jordy on 19/04/2017.
 */

public interface IAperturaUsuario {



    @POST("/Insertar")
    void Insertar(
            @Body com.kruma.kanta.entidad.AperturaUsuario AperturaUsuario,
            ServiceCallback<ProcessResult> obj_pCallBack);

    @GET("/ListarAperturaUsuario/{IdLocal}/{IdApertura}")
    void ListarAperturaUsuario(
            @Path("IdLocal") String str_pIdLocal,
            @Path("IdApertura") String str_pIdApertura,
            ServiceCallback<List<AperturaUsuario>> obj_pCallBack);

    @POST("/Modificar")
    void Modificar(
            @Body com.kruma.kanta.entidad.AperturaUsuario AperturaUsuario,
            ServiceCallback<ProcessResult> obj_pCallBack);


    @GET("/Obtener/{IdLocal}/{IdApertura}/{IdAperturaUsuario}/{IdUsuario}")
    void Obtener(
            @Path("IdLocal") String str_pIdLocal,
            @Path("IdApertura") String str_pIdApertura,
            @Path("IdAperturaUsuario") String str_pIdAperturaUsuario,
            @Path("IdUsuario") String str_pUsuario,
            ServiceCallback<AperturaUsuario> obj_pCallBack);



    @GET("/ObtenerEstadoAperturaUsuario/{IdLocal}/{IdApertura}/{IdAperturaUsuario}/{IdUsuario}")
    void ObtenerEstadoAperturaUsuario(
            @Path("IdLocal") String str_pIdLocal,
            @Path("IdApertura") String str_pIdApertura,
            @Path("IdAperturaUsuario") String str_pIdAperturaUsuario,
            @Path("IdUsuario") String str_pUsuario,
            ServiceCallback<AperturaUsuario> obj_pCallBack);


    @POST("/ModificarAperturaCancion")
    void ModificarAperturaCancion(
            @Body com.kruma.kanta.entidad.AperturaCancion AperturaCancion,
            ServiceCallback<ProcessResult> obj_pCallBack);
}
