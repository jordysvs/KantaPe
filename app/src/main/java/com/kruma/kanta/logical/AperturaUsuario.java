package com.kruma.kanta.logical;

import com.kruma.core.service.entity.ServiceCallback;
import com.kruma.core.util.common.List;
import com.kruma.core.util.common.ProcessCallback;
import com.kruma.core.util.common.ProcessResult;
import com.kruma.kanta.entidad.Constante;

/**
 * Created by John on 27/07/2016.
 */

public class AperturaUsuario {

    //region METODOS PUBLICOS

    public static void Insertar(
            com.kruma.kanta.entidad.AperturaUsuario obj_pAperturaUsuario,
            final ProcessCallback<
                                ProcessResult> obj_pCallback) {

        //Se inicializa el servicio
        com.kruma.kanta.service.IAperturaUsuario IAperturaUsuario =
                new com.kruma.core.service.ServiceManager(
                        Constante.SERVICE_APERTURAUSUARIO,
                        com.kruma.kanta.service.IAperturaUsuario.class
                ).getClient();

        //Se realiza el llamado del servicio
        IAperturaUsuario.Insertar(
                obj_pAperturaUsuario,
                new ServiceCallback<ProcessResult>() {
                    @Override
                    public void success(ProcessResult obj_pServiceResult) {
                        obj_pCallback.success(obj_pServiceResult);
                    }

                    @Override
                    public void failure(ProcessResult obj_pResultado) {
                        obj_pCallback.failure(obj_pResultado);
                    }
                });
    }



    public static void ListarAperturaUsuario(
            Integer int_pIdLocal,
            Integer int_pIdApertura,
            final ProcessCallback<
                    List<
                            com.kruma.kanta.entidad.AperturaUsuario>> obj_pCallback) {

        //Se establece los parametros
        String str_IdLocal = int_pIdLocal == null ? com.kruma.kanta.entidad.Constante.NULL_TYPE : int_pIdLocal.toString();
        String str_IdApertura = int_pIdApertura == null ? com.kruma.kanta.entidad.Constante.NULL_TYPE : int_pIdApertura.toString();

        //Se inicializa el servicio
        com.kruma.kanta.service.IAperturaUsuario IAperturaUsuario =
                new com.kruma.core.service.ServiceManager(
                        Constante.SERVICE_APERTURAUSUARIO,
                        com.kruma.kanta.service.IAperturaUsuario.class
                ).getClient();

        //Se realiza el llamado del servicio
        IAperturaUsuario.ListarAperturaUsuario(
                str_IdLocal,
                str_IdApertura,
                new ServiceCallback<List<com.kruma.kanta.entidad.AperturaUsuario>>(){

                    @Override
                    public void success(List<com.kruma.kanta.entidad.AperturaUsuario> obj_pResultado) {
                        obj_pCallback.success(obj_pResultado);
                    }

                    @Override
                    public void failure(ProcessResult obj_pResultado) {
                        obj_pCallback.failure(obj_pResultado);
                    }
                });
    }


    public static void Modificar(
            com.kruma.kanta.entidad.AperturaUsuario obj_pAperturaUsuario,
            final ProcessCallback<
                    ProcessResult> obj_pCallback) {

        //Se inicializa el servicio
        com.kruma.kanta.service.IAperturaUsuario IAperturaUsuario =
                new com.kruma.core.service.ServiceManager(
                        Constante.SERVICE_APERTURAUSUARIO,
                        com.kruma.kanta.service.IAperturaUsuario.class
                ).getClient();

        //Se realiza el llamado del servicio
        IAperturaUsuario.Modificar(
                obj_pAperturaUsuario,
                new ServiceCallback<ProcessResult>() {
                    @Override
                    public void success(ProcessResult obj_pServiceResult) {
                        obj_pCallback.success(obj_pServiceResult);
                    }

                    @Override
                    public void failure(ProcessResult obj_pResultado) {
                        obj_pCallback.failure(obj_pResultado);
                    }
                });
    }


    public static void ObtenerEstadoAperturaUsuario(
            Integer int_pIdLocal,
            Integer int_pIdApertura,
            Integer int_pIdAperturaUsuario,
            String int_pUsuario,
            final ProcessCallback<
                    com.kruma.kanta.entidad.AperturaUsuario> obj_pCallback) {

        //Obtiene el id del usuario
        String str_IdLocal = int_pIdLocal == null ? com.kruma.kanta.entidad.Constante.NULL_TYPE : int_pIdLocal.toString();
        String str_IdApertura = int_pIdApertura == null ? com.kruma.kanta.entidad.Constante.NULL_TYPE : int_pIdApertura.toString();
        String str_IdAperturaUsuario = int_pIdAperturaUsuario == null ? com.kruma.kanta.entidad.Constante.NULL_TYPE : int_pIdAperturaUsuario.toString();
        String str_pIdUsuario = int_pUsuario == null ? com.kruma.kanta.entidad.Constante.NULL_TYPE : int_pUsuario;

        //Se inicializa el servicio
        com.kruma.kanta.service.IAperturaUsuario IAperturaUsuario = new com.kruma.core.service.ServiceManager(
                Constante.SERVICE_APERTURAUSUARIO,
                com.kruma.kanta.service.IAperturaUsuario.class
        ).getClient();

        //Se obtiene el usuario
        IAperturaUsuario.ObtenerEstadoAperturaUsuario(str_IdLocal , str_IdApertura,str_IdAperturaUsuario, str_pIdUsuario,
                new ServiceCallback<
                        com.kruma.kanta.entidad.AperturaUsuario>() {

                    @Override
                    public void success(com.kruma.kanta.entidad.AperturaUsuario obj_pAperturaUsuario) {
                        obj_pCallback.success(obj_pAperturaUsuario);
                    }

                    @Override
                    public void failure(ProcessResult obj_pResultado) {
                        obj_pCallback.failure(obj_pResultado);
                    }
                });
    }


    public static void Obtener(
            Integer int_pIdLocal,
            Integer int_pIdApertura,
            Integer int_pIdAperturaUsuario,
            String int_pUsuario,
            final ProcessCallback<
                    com.kruma.kanta.entidad.AperturaUsuario> obj_pCallback) {

        //Obtiene el id del usuario
        String str_IdLocal = int_pIdLocal == null ? com.kruma.kanta.entidad.Constante.NULL_TYPE : int_pIdLocal.toString();
        String str_IdApertura = int_pIdApertura == null ? com.kruma.kanta.entidad.Constante.NULL_TYPE : int_pIdApertura.toString();
        String str_IdAperturaUsuario = int_pIdAperturaUsuario == null ? com.kruma.kanta.entidad.Constante.NULL_TYPE : int_pIdAperturaUsuario.toString();
        String str_pIdUsuario = int_pUsuario == null ? com.kruma.kanta.entidad.Constante.NULL_TYPE : int_pUsuario;

        //Se inicializa el servicio
        com.kruma.kanta.service.IAperturaUsuario IAperturaUsuario = new com.kruma.core.service.ServiceManager(
                Constante.SERVICE_APERTURAUSUARIO,
                com.kruma.kanta.service.IAperturaUsuario.class
        ).getClient();

        //Se obtiene el usuario
        IAperturaUsuario.Obtener(str_IdLocal , str_IdApertura, str_IdAperturaUsuario, str_pIdUsuario,
                new ServiceCallback<
                        com.kruma.kanta.entidad.AperturaUsuario>() {

                    @Override
                    public void success(com.kruma.kanta.entidad.AperturaUsuario obj_pAperturaUsuario) {
                        obj_pCallback.success(obj_pAperturaUsuario);
                    }

                    @Override
                    public void failure(ProcessResult obj_pResultado) {
                        obj_pCallback.failure(obj_pResultado);
                    }
                });
    }

    public static void ModificarAperturaCancion(
            com.kruma.kanta.entidad.AperturaCancion obj_pAperturaCancion,
            final ProcessCallback<
                    ProcessResult> obj_pCallback) {

        //Se inicializa el servicio
        com.kruma.kanta.service.IAperturaUsuario IAperturaUsuario =
                new com.kruma.core.service.ServiceManager(
                        com.kruma.kanta.entidad.Constante.SERVICE_APERTURAUSUARIO,
                        com.kruma.kanta.service.IAperturaUsuario.class
                ).getClient();

        //Se realiza el llamado del servicio
        IAperturaUsuario.ModificarAperturaCancion(
                obj_pAperturaCancion,
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
    //endregion
}
