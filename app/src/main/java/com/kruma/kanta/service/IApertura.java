package com.kruma.kanta.service;

import com.kruma.core.service.entity.ServiceCallback;
import com.kruma.core.util.common.List;
import com.kruma.core.util.common.ProcessResult;
import com.kruma.kanta.entidad.Alerta;
import com.kruma.kanta.entidad.Apertura;
import com.kruma.kanta.entidad.AperturaCancion;


import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;

/**
 * Created by John on 27/07/2016.
 */

public interface IApertura {

    @POST("/Notificar")
    void Notificar(
            @Body Alerta Alerta,
            ServiceCallback<ProcessResult> obj_pCallBack);

    @GET("/ObtenerNotificacion/{IdLocal}/{IdUbicacion}/{IdAlerta}")
    void ObtenerNotificacion(
            @Path("IdLocal") String str_pIdLocal,
            @Path("IdUbicacion") String str_pIdUbicacion,
            @Path("IdAlerta") String str_pIdAlerta,
            ServiceCallback<Alerta> obj_pCallBack);

    @POST("/CancelarNotificacion")
    void CancelarNotificacion(
            @Body Alerta Alerta,
            ServiceCallback<ProcessResult> obj_pCallBack);

    @POST("/Insertar")
    void Insertar(
            @Path("Apertura") com.kruma.kanta.entidad.Apertura obj_pApertura,
            ServiceCallback<ProcessResult> obj_pCallBack);

    @GET("/ObtenerActual/{IdLocal}/{IdUbicacion}")
    void ObtenerActual(
            @Path("IdLocal") String str_pIdLocal,
            @Path("IdUbicacion") String str_pIdUbicacion,
            ServiceCallback<Apertura> obj_pCallBack);

    @GET("/ListarCancion/{IdLocal}/{IdApertura}/{IdUsuario}/{IdAperturaCancionTipo}")
    void ListarCancion(
            @Path("IdLocal") String str_pIdLocal,
            @Path("IdApertura") String str_pIdApertura,
            @Path("IdUsuario") String str_pIdUsuario,
            @Path("IdAperturaCancionTipo") String str_pIdAperturaCancionTipo,
            ServiceCallback<List<AperturaCancion>> obj_pCallBack);
/*
    @POST("/SolicitarCancion")
    void SolicitarCancion(
            @Path("AperturaCancion") com.kruma.kantape.entidad.AperturaCancion obj_pAperturaCancion,
            Callback<
                    com.kruma.core.service.entity.ServiceResult<
                                    com.kruma.core.util.common.ProcessResult>> obj_pCallBack);
*/

    @POST("/SolicitarCancion")
    void SolicitarCancion(
            @Body AperturaCancion AperturaCancion,
            ServiceCallback<ProcessResult> obj_pCallBack);

    @POST("/CancelarCancion")
    void CancelarCancion(
            @Body AperturaCancion AperturaCancion,
            //@Path("AperturaCancion") com.kruma.kantape.entidad.AperturaCancion obj_pAperturaCancion,
            ServiceCallback<ProcessResult> obj_pCallBack);

    @POST("/Cerrar")
    void Cerrar(
        @Body com.kruma.kanta.entidad.Apertura Apertura,
        ServiceCallback<ProcessResult> obj_pCallBack);
}
