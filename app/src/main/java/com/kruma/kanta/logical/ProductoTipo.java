package com.kruma.kanta.logical;

import com.kruma.core.util.common.ProcessCallback;
import com.kruma.core.service.entity.ServiceCallback;
import com.kruma.core.util.common.List;
import com.kruma.core.util.common.ProcessResult;

/**
 * Created by Carlos Gomez on 28/10/2016.
 */

public class ProductoTipo {

    public static void ListarProductoTipo(
            final ProcessCallback<
                                List<
                                        com.kruma.kanta.entidad.ProductoTipo>> obj_pCallback) {

        //Se inicializa el servicio
        com.kruma.kanta.service.IProductoTipo IProductoTipo =
                new com.kruma.core.service.ServiceManager(
                        com.kruma.kanta.entidad.Constante.SERVICE_PRODUCTOTIPO,
                        com.kruma.kanta.service.IProductoTipo.class
                ).getClient();

        //Se realiza el llamado del servicio
        IProductoTipo.Listar(new ServiceCallback<List<com.kruma.kanta.entidad.ProductoTipo>>() {

            @Override
            public void success(List<com.kruma.kanta.entidad.ProductoTipo> obj_pResultado) {
                obj_pCallback.success(obj_pResultado);
            }

            @Override
            public void failure(ProcessResult obj_pResultado) {
                obj_pCallback.failure(obj_pResultado);
            }
        });
    }
}
