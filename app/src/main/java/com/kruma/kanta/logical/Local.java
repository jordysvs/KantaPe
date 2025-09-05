package com.kruma.kanta.logical;

import com.kruma.core.service.entity.ServiceCallback;
import com.kruma.core.util.common.List;
import com.kruma.core.util.common.ProcessCallback;
import com.kruma.core.util.common.ProcessResult;

/**
 * Created by John on 27/07/2016.
 */

public class Local {

    //region METODOS PUBLICOS
    public static void ListarLocal(
            Integer int_pIdLocalCancion,
            Integer int_pIdPais,
            String str_pPalabraClave,
            Integer int_pNumPagina,
            Integer int_pTamPagina,
            final ProcessCallback<
                                List<
                                        com.kruma.kanta.entidad.Local>> obj_pCallback) {

        //Se establece los parametros
        String str_IdLocalCancion = int_pIdLocalCancion == null ? com.kruma.kanta.entidad.Constante.NULL_TYPE : int_pIdLocalCancion.toString();
        String str_IdPais = int_pIdPais == null ? com.kruma.kanta.entidad.Constante.NULL_TYPE : int_pIdPais.toString();
        String str_PalabraClave = str_pPalabraClave == null ? com.kruma.kanta.entidad.Constante.NULL_TYPE : str_pPalabraClave;
        String str_NumPagina = int_pNumPagina == null ? com.kruma.kanta.entidad.Constante.NULL_TYPE : int_pNumPagina.toString();
        String str_TamPagina = int_pTamPagina == null ? com.kruma.kanta.entidad.Constante.NULL_TYPE : int_pTamPagina.toString();

        //Se inicializa el servicio
        com.kruma.kanta.service.ILocal ILocal =
                new com.kruma.core.service.ServiceManager(
                        com.kruma.kanta.entidad.Constante.SERVICE_LOCAL,
                        com.kruma.kanta.service.ILocal.class
                ).getClient();

        //Se realiza el llamado del servicio
        ILocal.Listar(
                str_IdLocalCancion,
                str_IdPais,
                str_PalabraClave,
                str_NumPagina,
                str_TamPagina,
                new ServiceCallback<List<com.kruma.kanta.entidad.Local>>(){

                    @Override
                    public void success(List<com.kruma.kanta.entidad.Local> obj_pResultado) {
                        obj_pCallback.success(obj_pResultado);
                    }

                    @Override
                    public void failure(ProcessResult obj_pResultado) {
                        obj_pCallback.failure(obj_pResultado);
                    }
                });
    }



    public static void ListarPais(
            final ProcessCallback<
                    List<
                            com.kruma.kanta.entidad.Pais>> obj_pCallback) {

        //Se inicializa el servicio
        com.kruma.kanta.service.ILocal ILocal =
                new com.kruma.core.service.ServiceManager(
                        com.kruma.kanta.entidad.Constante.SERVICE_LOCAL,
                        com.kruma.kanta.service.ILocal.class
                ).getClient();

        //Se realiza el llamado del servicio
        ILocal.ListarPais(new ServiceCallback<List<com.kruma.kanta.entidad.Pais>>(){

            @Override
            public void success(List<com.kruma.kanta.entidad.Pais> obj_pResultado) {
                obj_pCallback.success(obj_pResultado);
            }

            @Override
            public void failure(ProcessResult obj_pResultado) {
                obj_pCallback.failure(obj_pResultado);
            }
        });
    }



    //endregion
}
