package com.kruma.core.business.logical;

import com.kruma.core.business.entity.Constante;
import com.kruma.core.configuration.ConfigurationManager;
import com.kruma.core.service.entity.ServiceResult;
import com.kruma.core.util.common.List;

/**
 * Created by John on 27/06/2016.
 */
public class Modulo {

    public static List<com.kruma.core.business.entity.Modulo> Listar(
            String str_pIdModulo,
            String str_pCodigo,
            String str_pDescripcion,
            String str_pEstado,
            String str_pNumPagina,
            String str_pTamPagina) {

            com.kruma.core.business.service.IModulo IModulo = new com.kruma.core.service.ServiceManager(
                    Constante.SERVICE_NAME,
                    com.kruma.core.business.service.IModulo.class
            ).getClient();

            ServiceResult<List<com.kruma.core.business.entity.Modulo>> lst_Resultado = IModulo.Listar(
                    str_pIdModulo,
                    str_pCodigo,
                    str_pDescripcion,
                    str_pEstado,
                    str_pNumPagina,
                    str_pTamPagina);

            return lst_Resultado.getResultado();
    }
}
