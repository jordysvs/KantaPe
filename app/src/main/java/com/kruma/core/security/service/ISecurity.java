package com.kruma.core.security.service;

import com.kruma.core.security.entity.SecurityResult;
import com.kruma.core.service.entity.ServiceCallback;
import com.kruma.core.util.common.ProcessResult;

import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;

/**
 * Created by John on 15/06/2016.
 */
public interface ISecurity {

    @GET("/Autenticar/{Usuario}/{Clave}")
    void autenticacionUsuario(
            @Path("Usuario") String str_pUsuario,
            @Path("Clave") String str_pClave,
            ServiceCallback<SecurityResult> callback);

    @POST("/AutenticarToken")
    void autenticacionUsuarioToken(
            @Body com.kruma.kanta.entidad.Usuario Usuario,
            ServiceCallback<SecurityResult> callback);

    @POST("/ActualizarToken")
    void actualizarToken(
            @Body com.kruma.kanta.entidad.Usuario Usuario,
            ServiceCallback<ProcessResult> callback);

    @POST("/Modificar")
    void Modificar(
            @Body com.kruma.kanta.entidad.Usuario Usuario,
            ServiceCallback<ProcessResult> obj_pCallBack);

    @GET("/CambiarContrasenia/{Usuario}/{Mail}")
    void cambiarContrasenia(
            @Path("Usuario") String str_pUsuario,
            @Path("Mail") String str_pMail,
            ServiceCallback<ProcessResult> callback);
}