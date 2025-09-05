package com.kruma.kanta.logical;

import com.kruma.core.util.common.ProcessCallback;
import com.kruma.core.service.entity.ServiceCallback;
import com.kruma.core.util.common.List;
import com.kruma.core.util.common.ProcessResult;

/**
 * Created by Carlos Gomez on 21/10/2016.
 */

public class Evento {

    public static void ListarEvento(
            final ProcessCallback<
                                List<
                                        com.kruma.kanta.entidad.Evento>> obj_pCallback) {

        //Se inicializa el servicio
        com.kruma.kanta.service.IEvento IEvento =
                new com.kruma.core.service.ServiceManager(
                        com.kruma.kanta.entidad.Constante.SERVICE_EVENTO,
                        com.kruma.kanta.service.IEvento.class
                ).getClient();

        //Se realiza el llamado del servicio
        IEvento.Listar(new ServiceCallback<List<com.kruma.kanta.entidad.Evento>>() {

            @Override
            public void success(List<com.kruma.kanta.entidad.Evento> obj_pResultado) {
                obj_pCallback.success(obj_pResultado);
            }

            @Override
            public void failure(ProcessResult obj_pResultado) {
                obj_pCallback.failure(obj_pResultado);
            }
        });
    }

    public static void ListarEventoLocal(
            Integer int_pIdLocal,
            final ProcessCallback<
                    List<
                            com.kruma.kanta.entidad.Evento>> obj_pCallback) {

        //Se establece los parametros
        String str_IdLocal = int_pIdLocal == null ? com.kruma.kanta.entidad.Constante.NULL_TYPE : int_pIdLocal.toString();

        //Se inicializa el servicio
        com.kruma.kanta.service.IEvento IEvento =
                new com.kruma.core.service.ServiceManager(
                        com.kruma.kanta.entidad.Constante.SERVICE_EVENTO,
                        com.kruma.kanta.service.IEvento.class
                ).getClient();

        //Se realiza el llamado del servicio
        IEvento.ListarEventoLocal(
                str_IdLocal,
        new ServiceCallback<List<com.kruma.kanta.entidad.Evento>>() {

            @Override
            public void success(List<com.kruma.kanta.entidad.Evento> obj_pResultado) {
                obj_pCallback.success(obj_pResultado);
            }

            @Override
            public void failure(ProcessResult obj_pResultado) {
                obj_pCallback.failure(obj_pResultado);
            }
        });
    }
}
