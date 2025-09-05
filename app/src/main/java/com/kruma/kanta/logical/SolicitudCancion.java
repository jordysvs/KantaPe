package com.kruma.kanta.logical;

import com.kruma.core.util.common.ProcessCallback;
import com.kruma.core.service.entity.ServiceCallback;
import com.kruma.core.util.common.ProcessResult;
import com.kruma.kanta.entidad.Constante;

/**
 * Created by Enrique on 25/08/2016.
 */
public class SolicitudCancion {

    public static void Insertar(
            com.kruma.kanta.entidad.SolicitudCancion obj_pSolicitudCancion,
            final ProcessCallback<
                                ProcessResult> obj_pCallback) {

        // Se inicializa el servicio
        com.kruma.kanta.service.ISolicitudCancion ISolicitudCancion = new com.kruma.core.service.ServiceManager(
                Constante.SERVICE_SOLICITUDCANCION,
                com.kruma.kanta.service.ISolicitudCancion.class
        ).getClient();

        //Se realiza el llamado del servicio
        ISolicitudCancion.Insertar(obj_pSolicitudCancion, new ServiceCallback<ProcessResult>() {

            @Override
            public void success(ProcessResult obj_pResultado) {
                obj_pCallback.success(obj_pResultado);
            }

            @Override
            public void failure(ProcessResult obj_pResultado) {
                obj_pCallback.failure(obj_pResultado);
            }
        });
    }

}
