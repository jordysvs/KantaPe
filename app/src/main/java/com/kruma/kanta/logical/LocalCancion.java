package com.kruma.kanta.logical;

import com.kruma.core.util.common.ProcessCallback;
import com.kruma.core.service.entity.ServiceCallback;
import com.kruma.core.util.common.List;
import com.kruma.core.util.common.ProcessResult;
import com.kruma.kanta.entidad.Constante;

/**
 * Created by John on 27/07/2016.
 */

public class LocalCancion {

    //region METODOS PUBLICOS
    public static void Listar(
            Integer int_pIdLocal,
            Integer int_pIdCancion,
            String str_pPalabraClave,
            Integer int_pNumPagina,
            Integer int_pTamPagina,
            final ProcessCallback<
                                List<
                                        com.kruma.kanta.entidad.LocalCancion>> obj_pCallback) {

        //Se establece los parametros
        String str_IdLocal = int_pIdLocal == null ? com.kruma.kanta.entidad.Constante.NULL_TYPE : int_pIdLocal.toString();
        String str_IdCancion = int_pIdCancion == null ? com.kruma.kanta.entidad.Constante.NULL_TYPE : int_pIdCancion.toString();
        String str_PalabraClave = str_pPalabraClave == null ? com.kruma.kanta.entidad.Constante.NULL_TYPE : str_pPalabraClave;
        String str_NumPagina = int_pNumPagina == null ? com.kruma.kanta.entidad.Constante.NULL_TYPE : int_pNumPagina.toString();
        String str_TamPagina = int_pTamPagina == null ? com.kruma.kanta.entidad.Constante.NULL_TYPE : int_pTamPagina.toString();

        //Se inicializa el servicio
        com.kruma.kanta.service.ILocalCancion ILocalCancion =
                new com.kruma.core.service.ServiceManager(
                        com.kruma.kanta.entidad.Constante.SERVICE_LOCALCANCION,
                        com.kruma.kanta.service.ILocalCancion.class
                ).getClient();

        //Se realiza el llamado del servicio
        ILocalCancion.Listar(
                str_IdLocal,
                str_IdCancion,
                str_PalabraClave,
                str_NumPagina,
                str_TamPagina,
                new ServiceCallback<List<com.kruma.kanta.entidad.LocalCancion>>(){

                    @Override
                    public void success(List<com.kruma.kanta.entidad.LocalCancion> obj_pResultado) {
                        obj_pCallback.success(obj_pResultado);
                    }

                    @Override
                    public void failure(ProcessResult obj_pResultado) {
                        obj_pCallback.failure(obj_pResultado);
                    }
                });
    }

    public static void ListarLista(
            Integer int_pIdLocal,
            Integer int_pNumPagina,
            Integer int_pTamPagina,
            final ProcessCallback<
                    List<
                            com.kruma.kanta.entidad.LocalCancion>> obj_pCallback) {

        //Se establece los parametros
        String str_IdLocal = int_pIdLocal == null ? com.kruma.kanta.entidad.Constante.NULL_TYPE : int_pIdLocal.toString();
        String str_NumPagina = int_pNumPagina == null ? com.kruma.kanta.entidad.Constante.NULL_TYPE : int_pNumPagina.toString();
        String str_TamPagina = int_pTamPagina == null ? com.kruma.kanta.entidad.Constante.NULL_TYPE : int_pTamPagina.toString();

        //Se inicializa el servicio
        com.kruma.kanta.service.ILocalCancion ILocalCancion =
                new com.kruma.core.service.ServiceManager(
                        com.kruma.kanta.entidad.Constante.SERVICE_LOCALCANCION,
                        com.kruma.kanta.service.ILocalCancion.class
                ).getClient();

        //Se realiza el llamado del servicio
        ILocalCancion.ListarLista(
                str_IdLocal,
                str_NumPagina,
                str_TamPagina,
                new ServiceCallback<List<com.kruma.kanta.entidad.LocalCancion>>(){

                    @Override
                    public void success(List<com.kruma.kanta.entidad.LocalCancion> obj_pResultado) {
                        obj_pCallback.success(obj_pResultado);
                    }

                    @Override
                    public void failure(ProcessResult obj_pResultado) {
                        obj_pCallback.failure(obj_pResultado);
                    }
                });
    }


    public static void ListarNovedades(
            Integer int_pIdLocal,
            Integer int_pNumPagina,
            Integer int_pTamPagina,
            final ProcessCallback<
                    List<
                            com.kruma.kanta.entidad.LocalCancion>> obj_pCallback) {

        //Se establece los parametros
        String str_IdLocal = int_pIdLocal == null ? com.kruma.kanta.entidad.Constante.NULL_TYPE : int_pIdLocal.toString();
        String str_NumPagina = int_pNumPagina == null ? com.kruma.kanta.entidad.Constante.NULL_TYPE : int_pNumPagina.toString();
        String str_TamPagina = int_pTamPagina == null ? com.kruma.kanta.entidad.Constante.NULL_TYPE : int_pTamPagina.toString();

        //Se inicializa el servicio
        com.kruma.kanta.service.ILocalCancion ILocalCancion =
                new com.kruma.core.service.ServiceManager(
                        com.kruma.kanta.entidad.Constante.SERVICE_LOCALCANCION,
                        com.kruma.kanta.service.ILocalCancion.class
                ).getClient();

        //Se realiza el llamado del servicio
        ILocalCancion.ListarNovedades(
                str_IdLocal,
                str_NumPagina,
                str_TamPagina,
                new ServiceCallback<List<com.kruma.kanta.entidad.LocalCancion>>(){

                    @Override
                    public void success(List<com.kruma.kanta.entidad.LocalCancion> obj_pResultado) {
                        obj_pCallback.success(obj_pResultado);
                    }

                    @Override
                    public void failure(ProcessResult obj_pResultado) {
                        obj_pCallback.failure(obj_pResultado);
                    }
                });
    }

    public static void ListarRanking(
            Integer int_pIdLocal,
            Integer int_pNumPagina,
            Integer int_pTamPagina,
            final ProcessCallback<
                                List<
                                        com.kruma.kanta.entidad.LocalCancion>> obj_pCallback) {

        //Se establece los parametros
        String str_IdLocal = int_pIdLocal == null ? com.kruma.kanta.entidad.Constante.NULL_TYPE : int_pIdLocal.toString();
        String str_NumPagina = int_pNumPagina == null ? com.kruma.kanta.entidad.Constante.NULL_TYPE : int_pNumPagina.toString();
        String str_TamPagina = int_pTamPagina == null ? com.kruma.kanta.entidad.Constante.NULL_TYPE : int_pTamPagina.toString();

        //Se inicializa el servicio
        com.kruma.kanta.service.ILocalCancion ILocalCancion =
                new com.kruma.core.service.ServiceManager(
                        com.kruma.kanta.entidad.Constante.SERVICE_LOCALCANCION,
                        com.kruma.kanta.service.ILocalCancion.class
                ).getClient();

        //Se realiza el llamado del servicio
        ILocalCancion.ListarRanking(
                str_IdLocal,
                str_NumPagina,
                str_TamPagina,
                new ServiceCallback<List<com.kruma.kanta.entidad.LocalCancion>>(){

                    @Override
                    public void success(List<com.kruma.kanta.entidad.LocalCancion> obj_pResultado) {
                        obj_pCallback.success(obj_pResultado);
                    }

                    @Override
                    public void failure(ProcessResult obj_pResultado) {
                        obj_pCallback.failure(obj_pResultado);
                    }
                });
    }
/*
    public static void ListarRankingFiltro(
            Integer int_pIdLocal,
            String str_pPalabraClave,
            Integer int_pNumPagina,
            Integer int_pTamPagina,
            final ProcessCallback<
                                List<
                                        com.kruma.kantape.entidad.LocalCancion>> obj_pCallback) {

        //Se establece los parametros
        String str_IdLocal = int_pIdLocal == null ? com.kruma.kantape.entidad.Constante.NULL_TYPE : int_pIdLocal.toString();
        String str_PalabraClave = str_pPalabraClave == null ? com.kruma.kantape.entidad.Constante.NULL_TYPE : str_pPalabraClave;
        String str_NumPagina = int_pNumPagina == null ? com.kruma.kantape.entidad.Constante.NULL_TYPE : int_pNumPagina.toString();
        String str_TamPagina = int_pTamPagina == null ? com.kruma.kantape.entidad.Constante.NULL_TYPE : int_pTamPagina.toString();

        //Se inicializa el servicio
        com.kruma.kantape.service.ILocalCancion ILocalCancion =
                new com.kruma.core.service.ServiceManager(
                        com.kruma.kantape.entidad.Constante.SERVICE_LOCALCANCION,
                        com.kruma.kantape.service.ILocalCancion.class
                ).getClient();

        //Se realiza el llamado del servicio
        ILocalCancion.ListarRankingFiltro(
                str_IdLocal,
                str_PalabraClave,
                str_NumPagina,
                str_TamPagina,
                new ServiceCallback<List<com.kruma.kantape.entidad.LocalCancion>>(){

                    @Override
                    public void success(List<com.kruma.kantape.entidad.LocalCancion> obj_pResultado) {
                        obj_pCallback.success(obj_pResultado);
                    }

                    @Override
                    public void failure(ProcessResult obj_pResultado) {
                        obj_pCallback.failure(obj_pResultado);
                    }
                });
    }

*/

    public static void ListarRankingFiltro(
            Integer int_pIdLocal,
            String int_pIdGenero,
            String int_pIdIdioma,
            String str_pPalabraClave,
            Integer int_pNumPagina,
            Integer int_pTamPagina,
            final ProcessCallback<
                    List<
                            com.kruma.kanta.entidad.LocalCancion>> obj_pCallback) {

        //Se establece los parametros
        String str_IdLocal = int_pIdLocal == null ? com.kruma.kanta.entidad.Constante.NULL_TYPE : int_pIdLocal.toString();
        String str_IdGenero = int_pIdGenero == null ? com.kruma.kanta.entidad.Constante.NULL_TYPE : int_pIdGenero;
        String str_IdIdioma = int_pIdIdioma == null ? com.kruma.kanta.entidad.Constante.NULL_TYPE : int_pIdIdioma;
        String str_PalabraClave = str_pPalabraClave == null ? com.kruma.kanta.entidad.Constante.NULL_TYPE : str_pPalabraClave;
        String str_NumPagina = int_pNumPagina == null ? com.kruma.kanta.entidad.Constante.NULL_TYPE : int_pNumPagina.toString();
        String str_TamPagina = int_pTamPagina == null ? com.kruma.kanta.entidad.Constante.NULL_TYPE : int_pTamPagina.toString();
        //Se inicializa el servicio
        com.kruma.kanta.service.ILocalCancion ILocalCancion =
                new com.kruma.core.service.ServiceManager(
                        com.kruma.kanta.entidad.Constante.SERVICE_LOCALCANCION,
                        com.kruma.kanta.service.ILocalCancion.class
                ).getClient();

        //Se realiza el llamado del servicio
        ILocalCancion.ListarRankingFiltro(
                str_IdLocal,
                str_IdGenero,
                str_IdIdioma,
                str_PalabraClave,
                str_NumPagina,
                str_TamPagina,
                new ServiceCallback<List<com.kruma.kanta.entidad.LocalCancion>>(){

                    @Override
                    public void success(List<com.kruma.kanta.entidad.LocalCancion> obj_pResultado) {
                        obj_pCallback.success(obj_pResultado);
                    }

                    @Override
                    public void failure(ProcessResult obj_pResultado) {
                        obj_pCallback.failure(obj_pResultado);
                    }
                });
    }


    public static void ListarCancionesPorUsuario(
            Integer int_pIdLocal,
            String str_pUsuarioLogeado,
            Integer int_pNumPagina,
            Integer int_pTamPagina,
            final ProcessCallback<
                                List<
                                        com.kruma.kanta.entidad.LocalCancion>> obj_pCallback) {

        //Se establece los parametros
        String str_IdLocal = int_pIdLocal == null ? com.kruma.kanta.entidad.Constante.NULL_TYPE : int_pIdLocal.toString();
        String str_UsuarioLogeado = str_pUsuarioLogeado == null ? com.kruma.kanta.entidad.Constante.NULL_TYPE : str_pUsuarioLogeado;
        String str_NumPagina = int_pNumPagina == null ? com.kruma.kanta.entidad.Constante.NULL_TYPE : int_pNumPagina.toString();
        String str_TamPagina = int_pTamPagina == null ? com.kruma.kanta.entidad.Constante.NULL_TYPE : int_pTamPagina.toString();

        //Se inicializa el servicio
        com.kruma.kanta.service.ILocalCancion ILocalCancion =
                new com.kruma.core.service.ServiceManager(
                        com.kruma.kanta.entidad.Constante.SERVICE_LOCALCANCION,
                        com.kruma.kanta.service.ILocalCancion.class
                ).getClient();

        //Se realiza el llamado del servicio
        ILocalCancion.ListarCancionesPorUsuario(
                str_IdLocal,
                str_UsuarioLogeado,
                str_NumPagina,
                str_TamPagina,
                new ServiceCallback<List<com.kruma.kanta.entidad.LocalCancion>>() {

                    @Override
                    public void success(List<com.kruma.kanta.entidad.LocalCancion> obj_pResultado) {
                        obj_pCallback.success(obj_pResultado);
                    }

                    @Override
                    public void failure(ProcessResult obj_pResultado) {
                        obj_pCallback.failure(obj_pResultado);
                    }
                });
    }
/*
    public static void ListarListaFiltro(
            Integer int_pIdLocal,
            String str_pPalabraClave,
            Integer int_pNumPagina,
            Integer int_pTamPagina,
            final ProcessCallback<
                    List<
                            com.kruma.kantape.entidad.LocalCancion>> obj_pCallback) {

        //Se establece los parametros
        String str_IdLocal = int_pIdLocal == null ? com.kruma.kantape.entidad.Constante.NULL_TYPE : int_pIdLocal.toString();
        String str_PalabraClave = str_pPalabraClave == null ? com.kruma.kantape.entidad.Constante.NULL_TYPE : str_pPalabraClave;
        String str_NumPagina = int_pNumPagina == null ? com.kruma.kantape.entidad.Constante.NULL_TYPE : int_pNumPagina.toString();
        String str_TamPagina = int_pTamPagina == null ? com.kruma.kantape.entidad.Constante.NULL_TYPE : int_pTamPagina.toString();

        //Se inicializa el servicio
        com.kruma.kantape.service.ILocalCancion ILocalCancion =
                new com.kruma.core.service.ServiceManager(
                        Constante.SERVICE_LOCALCANCION,
                        com.kruma.kantape.service.ILocalCancion.class
                ).getClient();

        //Se realiza el llamado del servicio
        ILocalCancion.ListarListaFiltro(
                str_IdLocal,
                str_PalabraClave,
                str_NumPagina,
                str_TamPagina,
                new ServiceCallback<List<com.kruma.kantape.entidad.LocalCancion>>(){

                    @Override
                    public void success(List<com.kruma.kantape.entidad.LocalCancion> obj_pResultado) {
                        obj_pCallback.success(obj_pResultado);
                    }

                    @Override
                    public void failure(ProcessResult obj_pResultado) {
                        obj_pCallback.failure(obj_pResultado);
                    }
                });
    }
*/

    public static void ListarListaFiltro(
            Integer int_pIdLocal,
            String int_pIdGenero,
            String int_pIdIdioma,
            String str_pPalabraClave,
            Integer int_pNumPagina,
            Integer int_pTamPagina,
            final ProcessCallback<
                    List<
                            com.kruma.kanta.entidad.LocalCancion>> obj_pCallback) {

        //Se establece los parametros
        String str_IdLocal = int_pIdLocal == null ? com.kruma.kanta.entidad.Constante.NULL_TYPE : int_pIdLocal.toString();
        String str_IdGenero = int_pIdGenero == null ? com.kruma.kanta.entidad.Constante.NULL_TYPE : int_pIdGenero;
        String str_IdIdioma = int_pIdIdioma == null ? com.kruma.kanta.entidad.Constante.NULL_TYPE : int_pIdIdioma;
        String str_PalabraClave = str_pPalabraClave == null ? com.kruma.kanta.entidad.Constante.NULL_TYPE : str_pPalabraClave;
        String str_NumPagina = int_pNumPagina == null ? com.kruma.kanta.entidad.Constante.NULL_TYPE : int_pNumPagina.toString();
        String str_TamPagina = int_pTamPagina == null ? com.kruma.kanta.entidad.Constante.NULL_TYPE : int_pTamPagina.toString();


        //Se inicializa el servicio
        com.kruma.kanta.service.ILocalCancion ILocalCancion =
                new com.kruma.core.service.ServiceManager(
                        com.kruma.kanta.entidad.Constante.SERVICE_LOCALCANCION,
                        com.kruma.kanta.service.ILocalCancion.class
                ).getClient();

        //Se realiza el llamado del servicio
        ILocalCancion.ListarListaFiltro(
                str_IdLocal,
                str_IdGenero,
                str_IdIdioma,
                str_PalabraClave,
                str_NumPagina,
                str_TamPagina,
                new ServiceCallback<List<com.kruma.kanta.entidad.LocalCancion>>(){

                    @Override
                    public void success(List<com.kruma.kanta.entidad.LocalCancion> obj_pResultado) {
                        obj_pCallback.success(obj_pResultado);
                    }

                    @Override
                    public void failure(ProcessResult obj_pResultado) {
                        obj_pCallback.failure(obj_pResultado);
                    }
                });
    }



    public static void ListarNovedadesFiltro(
            Integer int_pIdLocal,
            String int_pIdGenero,
            String int_pIdIdioma,
            String str_pPalabraClave,
            Integer int_pNumPagina,
            Integer int_pTamPagina,
            final ProcessCallback<
                    List<
                            com.kruma.kanta.entidad.LocalCancion>> obj_pCallback) {

        //Se establece los parametros
        String str_IdLocal = int_pIdLocal == null ? com.kruma.kanta.entidad.Constante.NULL_TYPE : int_pIdLocal.toString();
        String str_IdGenero = int_pIdGenero == null ? com.kruma.kanta.entidad.Constante.NULL_TYPE : int_pIdGenero;
        String str_IdIdioma = int_pIdIdioma == null ? com.kruma.kanta.entidad.Constante.NULL_TYPE : int_pIdIdioma;
        String str_PalabraClave = str_pPalabraClave == null ? com.kruma.kanta.entidad.Constante.NULL_TYPE : str_pPalabraClave;
        String str_NumPagina = int_pNumPagina == null ? com.kruma.kanta.entidad.Constante.NULL_TYPE : int_pNumPagina.toString();
        String str_TamPagina = int_pTamPagina == null ? com.kruma.kanta.entidad.Constante.NULL_TYPE : int_pTamPagina.toString();

        //Se inicializa el servicio
        com.kruma.kanta.service.ILocalCancion ILocalCancion =
                new com.kruma.core.service.ServiceManager(
                        com.kruma.kanta.entidad.Constante.SERVICE_LOCALCANCION,
                        com.kruma.kanta.service.ILocalCancion.class
                ).getClient();

        //Se realiza el llamado del servicio
        ILocalCancion.ListarNovedadesFiltro(
                str_IdLocal,
                str_IdGenero,
                str_IdIdioma,
                str_PalabraClave,
                str_NumPagina,
                str_TamPagina,
                new ServiceCallback<List<com.kruma.kanta.entidad.LocalCancion>>(){

                    @Override
                    public void success(List<com.kruma.kanta.entidad.LocalCancion> obj_pResultado) {
                        obj_pCallback.success(obj_pResultado);
                    }

                    @Override
                    public void failure(ProcessResult obj_pResultado) {
                        obj_pCallback.failure(obj_pResultado);
                    }
                });
    }

    public static void ListarTodos(
            String int_pIdGenero,
            String int_pIdIdioma,
            String str_pPalabraClave,
            Integer int_pNumPagina,
            Integer int_pTamPagina,
            final ProcessCallback<
                    List<
                            com.kruma.kanta.entidad.LocalCancion>> obj_pCallback) {

        //Se establece los parametros
        String str_IdGenero = int_pIdGenero == null ? com.kruma.kanta.entidad.Constante.NULL_TYPE : int_pIdGenero;
        String str_IdIdioma = int_pIdIdioma == null ? com.kruma.kanta.entidad.Constante.NULL_TYPE : int_pIdIdioma;
        String str_PalabraClave = str_pPalabraClave == null ? com.kruma.kanta.entidad.Constante.NULL_TYPE : str_pPalabraClave;
        String str_NumPagina = int_pNumPagina == null ? com.kruma.kanta.entidad.Constante.NULL_TYPE : int_pNumPagina.toString();
        String str_TamPagina = int_pTamPagina == null ? com.kruma.kanta.entidad.Constante.NULL_TYPE : int_pTamPagina.toString();
        //Se inicializa el servicio
        com.kruma.kanta.service.ILocalCancion ILocalCancion =
                new com.kruma.core.service.ServiceManager(
                        Constante.SERVICE_LOCALCANCION,
                        com.kruma.kanta.service.ILocalCancion.class
                ).getClient();

        //Se realiza el llamado del servicio
        ILocalCancion.ListarTodos(
                str_IdGenero,
                str_IdIdioma,
                str_PalabraClave,
                str_NumPagina,
                str_TamPagina,
                new ServiceCallback<List<com.kruma.kanta.entidad.LocalCancion>>(){

                    @Override
                    public void success(List<com.kruma.kanta.entidad.LocalCancion> obj_pResultado) {
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
