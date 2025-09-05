package com.kruma.kanta.service;

import com.kruma.core.service.entity.ServiceCallback;
import com.kruma.core.util.common.ProcessResult;
import com.kruma.kanta.entidad.SolicitudCancion;

import retrofit.http.Body;
import retrofit.http.POST;

/**
 * Created by Enrique on 25/08/2016.
 */
public interface ISolicitudCancion {
    @POST("/Insertar")
    void Insertar(
            @Body SolicitudCancion SolicitudCancion,
            ServiceCallback<ProcessResult> obj_pCallBack);
    /*
    void Insertar( @Path("SolicitudCancion") com.kruma.kantape.entidad.SolicitudCancion obj_pSolicitudCancion,
           Callback<
                   com.kruma.core.service.entity.ServiceResult<
                           com.kruma.core.util.common.ProcessResult>> obj_pCallBack);
*/
}
