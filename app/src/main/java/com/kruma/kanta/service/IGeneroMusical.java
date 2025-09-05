package com.kruma.kanta.service;

import com.kruma.core.service.entity.ServiceCallback;
import com.kruma.core.util.common.List;
import com.kruma.kanta.entidad.GeneroMusical;

import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by Jordy Vilchez on 14/10/2016.
 */

public interface IGeneroMusical {

    @GET("/Listar")
    void Listar(ServiceCallback<List<GeneroMusical>> obj_pCallBack);

    @GET("/ListarGeneroMusicalPorLocal/{IdLocal}")
    void ListarGeneroMusicalPorLocal(
            @Path("IdLocal") String str_pIdLocal,
            ServiceCallback<List<GeneroMusical>> obj_pCallBack);


}
