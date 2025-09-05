package com.kruma.kanta.logical;

import com.kruma.core.util.common.ProcessCallback;
import com.kruma.core.service.entity.ServiceCallback;
import com.kruma.core.util.common.List;
import com.kruma.core.util.common.ProcessResult;
import com.kruma.kanta.entidad.Constante;

/**
 * Created by Carlos Gomez on 25/10/2016.
 */

public class Carta {

    public static void ListarCarta(
            Integer int_pIdEmpresa,
            Integer int_pIdLocal,
            Integer int_pIdProducto,
            String str_pNombre,
            String str_pIdProductoTipo,
            Integer int_pNumPagina,
            Integer int_pTamPagina,
            final ProcessCallback<
                                List<
                                        com.kruma.kanta.entidad.Carta>> obj_pCallback) {

        //Se establece los parametros
        String str_IdEmpresa = int_pIdEmpresa == null ? com.kruma.kanta.entidad.Constante.NULL_TYPE : int_pIdEmpresa.toString();
        String str_IdLocal = int_pIdLocal == null ? com.kruma.kanta.entidad.Constante.NULL_TYPE : int_pIdLocal.toString();
        String str_IdProducto = int_pIdProducto == null ? com.kruma.kanta.entidad.Constante.NULL_TYPE : int_pIdProducto.toString();
        String str_Nombre = str_pNombre == null ? com.kruma.kanta.entidad.Constante.NULL_TYPE : str_pNombre;
        String str_IdProductoTipo = str_pIdProductoTipo == null ? com.kruma.kanta.entidad.Constante.NULL_TYPE : str_pIdProductoTipo;
        String str_NumPagina = int_pNumPagina == null ? com.kruma.kanta.entidad.Constante.NULL_TYPE : int_pNumPagina.toString();
        String str_TamPagina = int_pTamPagina == null ? com.kruma.kanta.entidad.Constante.NULL_TYPE : int_pTamPagina.toString();

        //Se inicializa el servicio
        com.kruma.kanta.service.ICarta ICarta =
                new com.kruma.core.service.ServiceManager(
                        com.kruma.kanta.entidad.Constante.SERVICE_CARTA,
                        com.kruma.kanta.service.ICarta.class
                ).getClient();

        //Se realiza el llamado del servicio
        ICarta.ListarCarta(
                str_IdEmpresa,
                str_IdLocal,
                str_IdProducto,
                str_Nombre,
                str_IdProductoTipo,
                str_NumPagina,
                str_TamPagina,
                new ServiceCallback<List<com.kruma.kanta.entidad.Carta>>() {
                    @Override
                    public void success(List<com.kruma.kanta.entidad.Carta> obj_pResultado) {
                        obj_pCallback.success(obj_pResultado);
                    }

                    @Override
                    public void failure(ProcessResult obj_pResultado) {
                        obj_pCallback.failure(obj_pResultado);
                    }
                });
    }



    //region METODOS PUBLICOS
    public static void SolicitarPedido(
            Integer int_pIdLocal,
            Integer int_pIdUbicacion,
            String str_pIdUsuario,
            final ProcessCallback<
                    ProcessResult> obj_pCallback) {


        com.kruma.kanta.entidad.Alerta obj_Alerta = new com.kruma.kanta.entidad.Alerta();

        //Se establece los parametros
        obj_Alerta.setIdLocal(int_pIdLocal);
        obj_Alerta.setIdUbicacion(int_pIdUbicacion);
        obj_Alerta.setIdUsuario(str_pIdUsuario);

        //Se inicializa el servicio
        com.kruma.kanta.service.ICarta ICarta =
                new com.kruma.core.service.ServiceManager(
                        Constante.SERVICE_CARTA,
                        com.kruma.kanta.service.ICarta.class
                ).getClient();

        //Se realiza el llamado del servicio
        ICarta.SolicitarPedido(
                obj_Alerta,
                new ServiceCallback<ProcessResult>() {
                    @Override
                    public void success(com.kruma.core.util.common.ProcessResult obj_pServiceResult) {
                        obj_pCallback.success(obj_pServiceResult);
                    }

                    @Override
                    public void failure(ProcessResult obj_pResultado) {
                        obj_pCallback.failure(obj_pResultado);
                    }
                });
    }



}
