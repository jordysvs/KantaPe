package com.kruma.kanta.service;

import com.kruma.core.service.entity.ServiceCallback;
import com.kruma.core.util.common.List;
import com.kruma.kanta.entidad.ProductoTipo;

import retrofit.http.GET;

/**
 * Created by Carlos Gomez on 28/10/2016.
 */

public interface IProductoTipo {
    @GET("/Listar")
    void Listar(ServiceCallback<List<ProductoTipo>> obj_pCallBack);
}
