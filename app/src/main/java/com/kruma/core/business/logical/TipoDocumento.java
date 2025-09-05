package com.kruma.core.business.logical;

import com.kruma.core.service.entity.ServiceCallback;
import com.kruma.core.util.common.ProcessCallback;
import com.kruma.core.util.common.List;
import com.kruma.core.util.common.ProcessResult;

/**
 * Created by John on 27/06/2016.
 */
public class TipoDocumento {

    public static void Listar(
            String str_pCodigo,
            String str_pDescripcion,
            String str_pEstado,
            Integer int_pNumPagina,
            Integer int_pTamPagina,
            final ProcessCallback<
                                List<com.kruma.core.business.entity.TipoDocumento>> obj_pCallback) {

        String str_Codigo = str_pCodigo == null ? com.kruma.kanta.entidad.Constante.NULL_TYPE : str_pCodigo;
        String str_Descripcion = str_pDescripcion == null ? com.kruma.kanta.entidad.Constante.NULL_TYPE : str_pDescripcion;
        String str_Estado = str_pEstado == null ? com.kruma.kanta.entidad.Constante.NULL_TYPE : str_pEstado;
        String str_NumPagina = int_pNumPagina == null ? com.kruma.kanta.entidad.Constante.NULL_TYPE : int_pNumPagina.toString();
        String str_TamPagina = int_pTamPagina == null ? com.kruma.kanta.entidad.Constante.NULL_TYPE : int_pTamPagina.toString();

        com.kruma.core.business.service.ITipoDocumento ITipoDocumento =
                new com.kruma.core.service.ServiceManager(
                        com.kruma.core.business.entity.Constante.SERVICE_NAME,
                        com.kruma.core.business.service.ITipoDocumento.class
                ).getClient();

        ITipoDocumento.Listar(
                str_Codigo,
                str_Descripcion,
                str_Estado,
                str_NumPagina,
                str_TamPagina,
                new ServiceCallback<
                                        List<com.kruma.core.business.entity.TipoDocumento>>() {
                    @Override
                    public void success(com.kruma.core.util.common.List<com.kruma.core.business.entity.TipoDocumento> obj_pServiceResult) {
                        obj_pCallback.success(obj_pServiceResult);
                    }

                    @Override
                    public void failure(ProcessResult obj_pResultado) {
                        obj_pCallback.failure(obj_pResultado);
                    }
                });
    }
}
