package com.kruma.kanta.logical;

import com.kruma.core.util.common.ProcessCallback;
import com.kruma.core.service.entity.ServiceCallback;
import com.kruma.core.util.common.List;
import com.kruma.core.util.common.ProcessResult;

/**
 * Created by Carlos Gomez on 14/10/2016.
 */

public class GeneroMusical{

    public static void ListarGeneroMusical(
            final ProcessCallback<
                                List<
                                        com.kruma.kanta.entidad.GeneroMusical>> obj_pCallback) {

        //Se inicializa el servicio
        com.kruma.kanta.service.IGeneroMusical IGeneroMusical =
                new com.kruma.core.service.ServiceManager(
                        com.kruma.kanta.entidad.Constante.SERVICE_GENEROMUSICAL,
                        com.kruma.kanta.service.IGeneroMusical.class
                ).getClient();

        //Se realiza el llamado del servicio
        IGeneroMusical.Listar(new ServiceCallback<List<com.kruma.kanta.entidad.GeneroMusical>>(){

            @Override
            public void success(List<com.kruma.kanta.entidad.GeneroMusical> obj_pResultado) {
                obj_pCallback.success(obj_pResultado);
            }

            @Override
            public void failure(ProcessResult obj_pResultado) {
                obj_pCallback.failure(obj_pResultado);
            }
        });
    }


    public static void ListarGeneroMusicalPorLocal(
            Integer int_pIdLocal,
            final ProcessCallback<
                    List<
                            com.kruma.kanta.entidad.GeneroMusical>> obj_pCallback) {
        //Se establece los parametros
        String str_IdLocal = int_pIdLocal == null ? com.kruma.kanta.entidad.Constante.NULL_TYPE : int_pIdLocal.toString();

        //Se inicializa el servicio
        com.kruma.kanta.service.IGeneroMusical IGeneroMusical =
                new com.kruma.core.service.ServiceManager(
                        com.kruma.kanta.entidad.Constante.SERVICE_GENEROMUSICAL,
                        com.kruma.kanta.service.IGeneroMusical.class
                ).getClient();

        //Se realiza el llamado del servicio
        IGeneroMusical.ListarGeneroMusicalPorLocal(str_IdLocal,new ServiceCallback<List<com.kruma.kanta.entidad.GeneroMusical>>(){

            @Override
            public void success(List<com.kruma.kanta.entidad.GeneroMusical> obj_pResultado) {
                obj_pCallback.success(obj_pResultado);
            }

            @Override
            public void failure(ProcessResult obj_pResultado) {
                obj_pCallback.failure(obj_pResultado);
            }
        });
    }




}
