package com.kruma.core.business.logical;

import com.kruma.core.util.common.ProcessCallback;
import com.kruma.core.service.entity.ServiceCallback;
import com.kruma.core.util.common.List;
import com.kruma.core.util.common.ProcessResult;

/**
 * Created by John on 27/06/2016.
 */
public class EstadoCivil {

    public static void Listar(
            Integer int_pIdEstadoCivil,
            String str_pDescripcion,
            String str_pEstado,
            Integer int_pNumPagina,
            Integer int_pTamPagina,
            final ProcessCallback<
                                List<com.kruma.core.business.entity.EstadoCivil>> obj_pCallback) {

        String str_IdEstadoCivil = int_pIdEstadoCivil == null ? com.kruma.kanta.entidad.Constante.NULL_TYPE : int_pIdEstadoCivil.toString();
        String str_Descripcion = str_pDescripcion == null ? com.kruma.kanta.entidad.Constante.NULL_TYPE : str_pDescripcion;
        String str_Estado = str_pEstado == null ? com.kruma.kanta.entidad.Constante.NULL_TYPE : str_pEstado;
        String str_NumPagina = int_pNumPagina == null ? com.kruma.kanta.entidad.Constante.NULL_TYPE : int_pNumPagina.toString();
        String str_TamPagina = int_pTamPagina == null ? com.kruma.kanta.entidad.Constante.NULL_TYPE : int_pTamPagina.toString();

        com.kruma.core.business.service.IEstadoCivil IEstadoCivil =
                new com.kruma.core.service.ServiceManager(
                        com.kruma.core.business.entity.Constante.SERVICE_NAME,
                        com.kruma.core.business.service.IEstadoCivil.class
                ).getClient();

        IEstadoCivil.Listar(str_IdEstadoCivil,str_Descripcion,str_Estado,str_NumPagina,str_TamPagina,
                new ServiceCallback<List<com.kruma.core.business.entity.EstadoCivil>>() {

                    @Override
                    public void success(com.kruma.core.util.common.List<com.kruma.core.business.entity.EstadoCivil> lst_pResultado) {
                        obj_pCallback.success(lst_pResultado);
                    }

                    @Override
                    public void failure(ProcessResult obj_pResultado) {
                        obj_pCallback.failure(obj_pResultado);
                    }
                });
    }
}
