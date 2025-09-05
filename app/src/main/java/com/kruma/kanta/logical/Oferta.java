package com.kruma.kanta.logical;

import com.kruma.core.util.common.ProcessCallback;
import com.kruma.core.service.entity.ServiceCallback;
import com.kruma.core.util.common.List;
import com.kruma.core.util.common.ProcessResult;

/**
 * Created by Carlos Gomez on 21/10/2016.
 */

public class Oferta {

    public static void ListarOferta(
            final ProcessCallback<
                                List<
                                        com.kruma.kanta.entidad.Oferta>> obj_pCallback) {

        //Se inicializa el servicio
        com.kruma.kanta.service.IOferta IOferta =
                new com.kruma.core.service.ServiceManager(
                        com.kruma.kanta.entidad.Constante.SERVICE_OFERTA,
                        com.kruma.kanta.service.IOferta.class
                ).getClient();

        //Se realiza el llamado del servicio
        IOferta.Listar(new ServiceCallback<List<com.kruma.kanta.entidad.Oferta>>(){

            @Override
            public void success(List<com.kruma.kanta.entidad.Oferta> obj_pResultado) {
                obj_pCallback.success(obj_pResultado);
            }

            @Override
            public void failure(ProcessResult obj_pResultado) {
                obj_pCallback.failure(obj_pResultado);
            }
        });
    }

    public static void ListarOfertaPromocion(
            final ProcessCallback<
                    List<
                            com.kruma.kanta.entidad.Oferta>> obj_pCallback) {

        //Se inicializa el servicio
        com.kruma.kanta.service.IOferta IOferta =
                new com.kruma.core.service.ServiceManager(
                        com.kruma.kanta.entidad.Constante.SERVICE_OFERTA,
                        com.kruma.kanta.service.IOferta.class
                ).getClient();

        //Se realiza el llamado del servicio
        IOferta.ListarOfertaPromocion(new ServiceCallback<List<com.kruma.kanta.entidad.Oferta>>(){

            @Override
            public void success(List<com.kruma.kanta.entidad.Oferta> obj_pResultado) {
                obj_pCallback.success(obj_pResultado);
            }

            @Override
            public void failure(ProcessResult obj_pResultado) {
                obj_pCallback.failure(obj_pResultado);
            }
        });
    }

    public static void ListarOfertaSinVencer(
            Integer int_pIdLocal,
            final ProcessCallback<
                    List<
                            com.kruma.kanta.entidad.Oferta>> obj_pCallback) {
        //Se establece los parametros
        String str_IdLocal = int_pIdLocal == null ? com.kruma.kanta.entidad.Constante.NULL_TYPE : int_pIdLocal.toString();

        //Se inicializa el servicio
        com.kruma.kanta.service.IOferta IOferta =
                new com.kruma.core.service.ServiceManager(
                        com.kruma.kanta.entidad.Constante.SERVICE_OFERTA,
                        com.kruma.kanta.service.IOferta.class
                ).getClient();

        //Se realiza el llamado del servicio
        IOferta.ListarOfertaSinVencer(
                str_IdLocal
                ,new ServiceCallback<List<com.kruma.kanta.entidad.Oferta>>(){

            @Override
            public void success(List<com.kruma.kanta.entidad.Oferta> obj_pResultado) {
                obj_pCallback.success(obj_pResultado);
            }

            @Override
            public void failure(ProcessResult obj_pResultado) {
                obj_pCallback.failure(obj_pResultado);
            }
        });
    }

}
