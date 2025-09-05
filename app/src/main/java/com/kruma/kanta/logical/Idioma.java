package com.kruma.kanta.logical;

import com.kruma.core.util.common.ProcessCallback;
import com.kruma.core.service.entity.ServiceCallback;
import com.kruma.core.util.common.List;
import com.kruma.core.util.common.ProcessResult;

/**
 * Created by Carlos Gomez on 28/10/2016.
 */

public class Idioma {

    public static void ListarIdioma(
            final ProcessCallback<
                                List<
                                        com.kruma.kanta.entidad.Idioma>> obj_pCallback) {

        //Se inicializa el servicio
        com.kruma.kanta.service.IIdioma IIdioma =
                new com.kruma.core.service.ServiceManager(
                        com.kruma.kanta.entidad.Constante.SERVICE_IDIOMA,
                        com.kruma.kanta.service.IIdioma.class
                ).getClient();

        //Se realiza el llamado del servicio
        IIdioma.Listar(new ServiceCallback<List<com.kruma.kanta.entidad.Idioma>>() {

            @Override
            public void success(List<com.kruma.kanta.entidad.Idioma> obj_pResultado) {
                obj_pCallback.success(obj_pResultado);
            }

            @Override
            public void failure(ProcessResult obj_pResultado) {
                obj_pCallback.failure(obj_pResultado);
            }
        });
    }

    public static void ListarIdiomaPorLocal(
            Integer int_pIdLocal,
            final ProcessCallback<
                    List<
                            com.kruma.kanta.entidad.Idioma>> obj_pCallback) {

        //Se establece los parametros
        String str_IdLocal = int_pIdLocal == null ? com.kruma.kanta.entidad.Constante.NULL_TYPE : int_pIdLocal.toString();

        //Se inicializa el servicio
        com.kruma.kanta.service.IIdioma IIdioma =
                new com.kruma.core.service.ServiceManager(
                        com.kruma.kanta.entidad.Constante.SERVICE_IDIOMA,
                        com.kruma.kanta.service.IIdioma.class
                ).getClient();

        //Se realiza el llamado del servicio
        IIdioma.ListarIdiomaPorLocal(str_IdLocal,new ServiceCallback<List<com.kruma.kanta.entidad.Idioma>>() {

            @Override
            public void success(List<com.kruma.kanta.entidad.Idioma> obj_pResultado) {
                obj_pCallback.success(obj_pResultado);
            }

            @Override
            public void failure(ProcessResult obj_pResultado) {
                obj_pCallback.failure(obj_pResultado);
            }
        });
    }
}
