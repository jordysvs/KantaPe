package com.kruma.kanta.service;

import com.kruma.core.service.entity.ServiceCallback;
import com.kruma.kanta.entidad.Ubicacion;


import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;

/**
 * Created by JORDY on 20/03/2017.
 */

public interface IUbicacion {

    @GET("/Obtener/{IdLocal}/{IdUbicacion}")
    void Obtener(
            @Path("IdLocal") String str_pIdLocal,
            @Path("IdUbicacion")String str_pIdUbicacion,
            ServiceCallback<Ubicacion> obj_pCallBack);

    @POST("/ObtenerQR")
    void ObtenerQR(
            @Body String QR,
            ServiceCallback<Ubicacion> obj_pCallBack);

}
