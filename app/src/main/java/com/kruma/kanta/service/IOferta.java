package com.kruma.kanta.service;

import com.kruma.core.service.entity.ServiceCallback;
import com.kruma.core.util.common.List;
import com.kruma.kanta.entidad.Oferta;

import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by Carlos Gomez on 21/10/2016.
 */

public interface IOferta {

    @GET("/Listar")
    void Listar(ServiceCallback<List<Oferta>> obj_pCallBack);

    @GET("/ListarOfertaSinVencer/{IdLocal}")
    void ListarOfertaSinVencer(
            @Path("IdLocal") String str_pIdLocal,
            ServiceCallback<List<Oferta>> obj_pCallBack);

    @GET("/ListarOfertaPromocion")
    void ListarOfertaPromocion(ServiceCallback<List<Oferta>> obj_pCallBack);
}
