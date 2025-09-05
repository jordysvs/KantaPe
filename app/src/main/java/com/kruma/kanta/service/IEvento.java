package com.kruma.kanta.service;

import com.kruma.core.service.entity.ServiceCallback;
import com.kruma.core.util.common.List;
import com.kruma.kanta.entidad.Evento;


import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by Carlos Gomez on 21/10/2016.
 */

public interface IEvento {
    @GET("/Listar")
    void Listar(ServiceCallback<List<Evento>> obj_pCallBack);

    @GET("/ListarEventoLocal/{IdLocal}")
    void ListarEventoLocal(
            @Path("IdLocal") String str_pIdLocal,
            ServiceCallback<List<Evento>> obj_pCallBack);
}
