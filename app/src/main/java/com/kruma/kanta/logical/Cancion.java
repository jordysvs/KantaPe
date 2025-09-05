package com.kruma.kanta.logical;

import com.kruma.core.service.entity.ServiceCallback;
import com.kruma.core.util.common.List;
import com.kruma.core.util.common.ProcessCallback;
import com.kruma.core.util.common.ProcessResult;

/**
 * Created by John on 27/07/2016.
 */

public class Cancion {


    public static void Listar(
            String int_pIdGenero,
            String int_pIdIdioma,
            String str_pPalabraClave,
            Integer int_pNumPagina,
            Integer int_pTamPagina,
            final ProcessCallback<
                    List<
                            com.kruma.kanta.entidad.Cancion>> obj_pCallback) {

        //Se establece los parametros
        String str_IdGenero = int_pIdGenero == null ? com.kruma.kanta.entidad.Constante.NULL_TYPE : int_pIdGenero;
        String str_IdIdioma = int_pIdIdioma == null ? com.kruma.kanta.entidad.Constante.NULL_TYPE : int_pIdIdioma;
        String str_PalabraClave = str_pPalabraClave == null ? com.kruma.kanta.entidad.Constante.NULL_TYPE : str_pPalabraClave;
        String str_NumPagina = int_pNumPagina == null ? com.kruma.kanta.entidad.Constante.NULL_TYPE : int_pNumPagina.toString();
        String str_TamPagina = int_pTamPagina == null ? com.kruma.kanta.entidad.Constante.NULL_TYPE : int_pTamPagina.toString();
        //Se inicializa el servicio
        com.kruma.kanta.service.ICancion ICancion =
                new com.kruma.core.service.ServiceManager(
                        com.kruma.kanta.entidad.Constante.SERVICE_CANCION,
                        com.kruma.kanta.service.ICancion.class
                ).getClient();

        //Se realiza el llamado del servicio
        ICancion.Listar(
                str_IdGenero,
                str_IdIdioma,
                str_PalabraClave,
                str_NumPagina,
                str_TamPagina,
                new ServiceCallback<List<com.kruma.kanta.entidad.Cancion>>(){

                    @Override
                    public void success(List<com.kruma.kanta.entidad.Cancion> obj_pResultado) {
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
