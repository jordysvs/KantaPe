package com.kruma.core.business.logical;
import com.kruma.core.service.entity.ServiceCallback;
import com.kruma.core.util.common.ProcessCallback;
import com.kruma.core.util.common.Entity;
import com.kruma.core.util.common.List;
import com.kruma.core.util.common.ProcessResult;

/**
 * Created by John on 27/06/2016.
 */
public class Genero {

    public static void Listar(
            final ProcessCallback<
                                List<
                                        Entity>> obj_pCallback) {

        com.kruma.core.business.service.IGenero IGenero =
                new com.kruma.core.service.ServiceManager(
                        com.kruma.core.business.entity.Constante.SERVICE_NAME,
                        com.kruma.core.business.service.IGenero.class
                ).getClient();

        IGenero.Listar(
                new ServiceCallback<
                                        List<Entity>>() {

                    @Override
                    public void success(com.kruma.core.util.common.List<com.kruma.core.util.common.Entity> obj_pServiceResult) {
                        obj_pCallback.success(obj_pServiceResult);
                    }

                    @Override
                    public void failure(ProcessResult obj_pResultado) {
                        obj_pCallback.failure(obj_pResultado);
                    }
                });
    }
}