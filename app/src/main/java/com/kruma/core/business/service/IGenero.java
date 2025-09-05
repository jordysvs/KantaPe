package com.kruma.core.business.service;

import com.kruma.core.service.entity.ServiceCallback;
import com.kruma.core.util.common.Entity;
import com.kruma.core.util.common.List;

import retrofit.http.GET;

/**
 * Created by John on 27/06/2016.
 */
public interface IGenero {

    @GET("/Genero/Listar")
    void Listar(ServiceCallback<List<Entity>> obj_pCallBack);
}
