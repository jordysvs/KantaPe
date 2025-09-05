package com.kruma.kanta.logical;

import com.kruma.core.util.common.ProcessCallback;
import com.kruma.core.service.entity.ServiceCallback;
import com.kruma.core.util.common.List;
import com.kruma.core.util.common.ProcessResult;

/**
 * Created by Carlos Gomez on 30/10/2016.
 */

public class AperturaCancionSolicitud {

    public static void ListarAperturaCancionSolicitud(
            final ProcessCallback<
                                List<
                                        com.kruma.kanta.entidad.AperturaCancionSolicitud>> obj_pCallback) {

        //Se inicializa el servicio
        com.kruma.kanta.service.IAperturaCancionSolicitud IAperturaCancionSolicitud =
                new com.kruma.core.service.ServiceManager(
                        com.kruma.kanta.entidad.Constante.SERVICE_APERTURACANCIONSOLICITUD,
                        com.kruma.kanta.service.IAperturaCancionSolicitud.class
                ).getClient();

        //Se realiza el llamado del servicio
        IAperturaCancionSolicitud.Listar(new ServiceCallback<List<com.kruma.kanta.entidad.AperturaCancionSolicitud>>() {

            @Override
            public void success(com.kruma.core.util.common.List<com.kruma.kanta.entidad.AperturaCancionSolicitud> obj_pServiceResult) {
                obj_pCallback.success(obj_pServiceResult);
            }

            @Override
            public void failure(ProcessResult obj_pResultado) {
                obj_pCallback.failure(obj_pResultado);
            }
        });
    }
}
