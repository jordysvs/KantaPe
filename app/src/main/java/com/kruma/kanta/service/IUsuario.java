package com.kruma.kanta.service;
import com.kruma.core.service.entity.ServiceCallback;
import com.kruma.core.util.common.ProcessResult;
import com.kruma.kanta.entidad.Usuario;

import retrofit.http.Body;
import retrofit.http.POST;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by Enrique on 26/07/2016.
 */
public interface IUsuario {
    @POST("/Insertar")
    void Insertar(
            @Body com.kruma.kanta.entidad.Usuario Usuario,
            ServiceCallback<ProcessResult> obj_pCallBack);


    @GET("/Obtener/{IdUsuario}")
    void Obtener(
            @Path("IdUsuario") String str_pUsuario,
            ServiceCallback<Usuario> obj_pCallBack);


    @POST("/Modificar")
    void Modificar(
            @Body com.kruma.kanta.entidad.Usuario Usuario,
            ServiceCallback<ProcessResult> obj_pCallBack);

}
