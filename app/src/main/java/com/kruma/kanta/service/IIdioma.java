package com.kruma.kanta.service;

import com.kruma.core.service.entity.ServiceCallback;
import com.kruma.core.util.common.List;
import com.kruma.kanta.entidad.Idioma;

import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by Carlos Gomez on 28/10/2016.
 */

public interface IIdioma {

    @GET("/Listar")
    void Listar(ServiceCallback<List<Idioma>> obj_pCallBack);

    @GET("/ListarIdiomaPorLocal/{IdLocal}")
    void ListarIdiomaPorLocal(
            @Path("IdLocal") String str_pIdLocal,
            ServiceCallback<List<Idioma>> obj_pCallBack);
}
