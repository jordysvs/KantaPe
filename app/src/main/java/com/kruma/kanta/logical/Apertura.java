package com.kruma.kanta.logical;

import com.kruma.core.util.common.ProcessCallback;
import com.kruma.core.service.entity.ServiceCallback;
import com.kruma.core.util.common.List;
import com.kruma.core.util.common.ProcessResult;
import com.kruma.kanta.entidad.*;

/**
 * Created by John on 27/07/2016.
 */

public class Apertura {

    //region METODOS PUBLICOS
    public static void Notificar(
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
        com.kruma.kanta.service.IApertura IApertura =
                new com.kruma.core.service.ServiceManager(
                        com.kruma.kanta.entidad.Constante.SERVICE_APERTURA,
                        com.kruma.kanta.service.IApertura.class
                ).getClient();

        //Se realiza el llamado del servicio
        IApertura.Notificar(
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

    public static void ObtenerNotificacion(
            Integer int_pIdLocal,
            Integer int_pIdUbicacion,
            Integer int_pIdAlerta,
            final ProcessCallback<Alerta> obj_pCallback) {

        //Se establece los parametros
        String str_IdLocal = int_pIdLocal == null ? com.kruma.kanta.entidad.Constante.NULL_TYPE : int_pIdLocal.toString();
        String str_IdUbicacion = int_pIdUbicacion == null ? com.kruma.kanta.entidad.Constante.NULL_TYPE : int_pIdUbicacion.toString();
        String str_IdAlerta = int_pIdAlerta == null ? com.kruma.kanta.entidad.Constante.NULL_TYPE : int_pIdAlerta.toString();

        //Se inicializa el servicio
        com.kruma.kanta.service.IApertura IApertura =
                new com.kruma.core.service.ServiceManager(
                        com.kruma.kanta.entidad.Constante.SERVICE_APERTURA,
                        com.kruma.kanta.service.IApertura.class
                ).getClient();

        //Se realiza el llamado del servicio
        IApertura.ObtenerNotificacion(
                str_IdLocal,
                str_IdUbicacion,
                str_IdAlerta,
                new ServiceCallback<Alerta>() {
                    @Override
                    public void success(Alerta obj_pApertura) {
                        obj_pCallback.success(obj_pApertura);
                    }

                    @Override
                    public void failure(ProcessResult obj_pResultado) {
                        obj_pCallback.failure(obj_pResultado);
                    }
                });
    }

    public static void CancelarNotificacion(
            Integer int_pIdLocal,
            Integer int_pIdUbicacion,
            Integer int_pIdAlerta,
            String str_pIdUsuario,
            final ProcessCallback<ProcessResult> obj_pCallback) {

        com.kruma.kanta.entidad.Alerta obj_Alerta = new com.kruma.kanta.entidad.Alerta();

        //Se establece los parametros
        obj_Alerta.setIdAlerta(int_pIdAlerta);
        obj_Alerta.setIdLocal(int_pIdLocal);
        obj_Alerta.setIdUbicacion(int_pIdUbicacion);
        obj_Alerta.setIdUsuario(str_pIdUsuario);

        //Se inicializa el servicio
        com.kruma.kanta.service.IApertura IApertura =
                new com.kruma.core.service.ServiceManager(
                        com.kruma.kanta.entidad.Constante.SERVICE_APERTURA,
                        com.kruma.kanta.service.IApertura.class
                ).getClient();

        //Se realiza el llamado del servicio
        IApertura.CancelarNotificacion(
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

    public static void Insertar(
            com.kruma.kanta.entidad.Apertura obj_pApertura,
            final ProcessCallback<
                                ProcessResult> obj_pCallback) {

        //Se inicializa el servicio
        com.kruma.kanta.service.IApertura IApertura =
                new com.kruma.core.service.ServiceManager(
                        com.kruma.kanta.entidad.Constante.SERVICE_APERTURA,
                        com.kruma.kanta.service.IApertura.class
                ).getClient();

        //Se realiza el llamado del servicio
        IApertura.Insertar(
                obj_pApertura,
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

    public static void ObtenerActual(
            Integer int_pIdLocal,
            Integer int_pIdUbicacion,
            final ProcessCallback<com.kruma.kanta.entidad.Apertura> obj_pCallback) {

        //Se establece los parametros
        String str_IdLocal = int_pIdLocal == null ? com.kruma.kanta.entidad.Constante.NULL_TYPE : int_pIdLocal.toString();
        String str_IdUbicacion = int_pIdUbicacion == null ? com.kruma.kanta.entidad.Constante.NULL_TYPE : int_pIdUbicacion.toString();

        //Se inicializa el servicio
        com.kruma.kanta.service.IApertura IApertura =
                new com.kruma.core.service.ServiceManager(
                        com.kruma.kanta.entidad.Constante.SERVICE_APERTURA,
                        com.kruma.kanta.service.IApertura.class
                ).getClient();

        //Se realiza el llamado del servicio
        IApertura.ObtenerActual(
                str_IdLocal,
                str_IdUbicacion,
                new ServiceCallback<com.kruma.kanta.entidad.Apertura>() {
                    @Override
                    public void success(com.kruma.kanta.entidad.Apertura obj_pApertura) {
                        obj_pCallback.success(obj_pApertura);
                    }

                    @Override
                    public void failure(ProcessResult obj_pResultado) {
                        obj_pCallback.failure(obj_pResultado);
                    }
                });
    }

    public static void ListarCancion(
            Integer int_pIdLocal,
            Integer int_pIdApertura,
            String str_pIdUsuario,
            Integer int_pIdAperturaCancionTipo,
            final ProcessCallback<
                                List<com.kruma.kanta.entidad.AperturaCancion>> obj_pCallback) {

        //Se establece los parametros
        String str_IdLocal = int_pIdLocal == null ? com.kruma.kanta.entidad.Constante.NULL_TYPE : int_pIdLocal.toString();
        String str_IdApertura = int_pIdApertura == null ? com.kruma.kanta.entidad.Constante.NULL_TYPE : int_pIdApertura.toString();
        String str_IdUsuario = str_pIdUsuario == null ? com.kruma.kanta.entidad.Constante.NULL_TYPE : str_pIdUsuario;
        String str_IdAperturaCancionTipo = int_pIdAperturaCancionTipo == null ? com.kruma.kanta.entidad.Constante.NULL_TYPE : int_pIdAperturaCancionTipo.toString();

        //Se inicializa el servicio
        com.kruma.kanta.service.IApertura IApertura =
                new com.kruma.core.service.ServiceManager(
                        Constante.SERVICE_APERTURA,
                        com.kruma.kanta.service.IApertura.class
                ).getClient();

        //Se realiza el llamado del servicio
        IApertura.ListarCancion(

                str_IdLocal,
                str_IdApertura,
                str_IdUsuario,
                str_IdAperturaCancionTipo,
                new ServiceCallback<List<AperturaCancion>>() {
                    @Override
                    public void success(com.kruma.core.util.common.List<com.kruma.kanta.entidad.AperturaCancion> obj_pServiceResult) {

                        obj_pCallback.success(obj_pServiceResult);

                    }

                    @Override
                    public void failure(ProcessResult obj_pResultado) {

                        obj_pCallback.failure(obj_pResultado);

                    }
                });
    }

    public static void SolicitarCancion(
            com.kruma.kanta.entidad.AperturaCancion obj_pAperturaCancion,
            final ProcessCallback<
                                ProcessResult> obj_pCallback) {

        //Se inicializa el servicio
        com.kruma.kanta.service.IApertura IApertura =
                new com.kruma.core.service.ServiceManager(
                        com.kruma.kanta.entidad.Constante.SERVICE_APERTURA,
                        com.kruma.kanta.service.IApertura.class
                ).getClient();

        //Se realiza el llamado del servicio
        IApertura.SolicitarCancion(
                obj_pAperturaCancion,
                new ServiceCallback<ProcessResult>() {
                    @Override
                    public void success(ProcessResult obj_pResultado) {
                        obj_pCallback.success(obj_pResultado);
                    }

                    @Override
                    public void failure(ProcessResult obj_pResultado) {
                        obj_pCallback.failure(obj_pResultado);
                    }
                });
    }

    public static void CancelarCancion(
            com.kruma.kanta.entidad.AperturaCancion obj_pAperturaCancion,
            final ProcessCallback<
                                ProcessResult> obj_pCallback) {

        //Se inicializa el servicio
        com.kruma.kanta.service.IApertura IApertura =
                new com.kruma.core.service.ServiceManager(
                        com.kruma.kanta.entidad.Constante.SERVICE_APERTURA,
                        com.kruma.kanta.service.IApertura.class
                ).getClient();

        //Se realiza el llamado del servicio
        IApertura.CancelarCancion(
                obj_pAperturaCancion,
                new ServiceCallback<ProcessResult>() {
                    @Override
                    public void success(com.kruma.core.util.common.ProcessResult obj_pResultado) {
                        obj_pCallback.success(obj_pResultado);
                    }

                    @Override
                    public void failure(ProcessResult obj_pResultado) {
                        obj_pCallback.failure(obj_pResultado);
                    }
                });
    }
    //endregion

    public static void Cerrar(
            com.kruma.kanta.entidad.Apertura obj_pApertura,
            final ProcessCallback<
                    ProcessResult> obj_pCallback) {

        //Se inicializa el servicio
        com.kruma.kanta.service.IApertura IApertura =
                new com.kruma.core.service.ServiceManager(
                        com.kruma.kanta.entidad.Constante.SERVICE_APERTURA,
                        com.kruma.kanta.service.IApertura.class
                ).getClient();

        //Se realiza el llamado del servicio
        IApertura.Cerrar(
                obj_pApertura,
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
