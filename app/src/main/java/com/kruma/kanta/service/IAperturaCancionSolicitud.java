package com.kruma.kanta.service;

import com.kruma.core.service.entity.ServiceCallback;
import com.kruma.core.util.common.List;
import com.kruma.kanta.entidad.AperturaCancionSolicitud;

import retrofit.http.GET;

/**
 * Created by Carlos Gomez on 30/10/2016.
 */

public interface IAperturaCancionSolicitud {

    @GET("/Listar")
    void Listar(ServiceCallback<List<AperturaCancionSolicitud>> obj_pCallBack);
}
