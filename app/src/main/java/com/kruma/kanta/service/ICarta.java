package com.kruma.kanta.service;

import com.kruma.core.service.entity.ServiceCallback;
import com.kruma.core.util.common.List;
import com.kruma.core.util.common.ProcessResult;
import com.kruma.kanta.entidad.Alerta;
import com.kruma.kanta.entidad.Carta;

import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;

/**
 * Created by Carlos Gomez on 25/10/2016.
 */

public interface ICarta {

    @GET("/Listar/{IdEmpresa}/{IdLocal}/{IdProducto}/{Nombre}/{IdProductoTipo}/{NumPagina}/{TamPagina}")
    void ListarCarta(
            @Path("IdEmpresa") String str_pIdEmpresa,
            @Path("IdLocal") String str_pIdLocal,
            @Path("IdProducto") String str_pIdProducto,
            @Path("Nombre") String str_pNombre,
            @Path("IdProductoTipo") String str_pIdProductoTipo,
            @Path("NumPagina") String str_pNumPagina,
            @Path("TamPagina") String str_pTamPagina,
            ServiceCallback<List<Carta>> obj_pCallBack);



    @POST("/SolicitarPedido")
    void SolicitarPedido(
            @Body Alerta Alerta,
            ServiceCallback<ProcessResult> obj_pCallBack);


}
