package com.kruma.kanta.service;

import com.kruma.core.service.entity.ServiceCallback;
import com.kruma.core.util.common.List;
import com.kruma.kanta.entidad.LocalCancion;

import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by John on 27/07/2016.
 */

public interface ILocalCancion {

    @GET("/Listar/{IdLocal}/{IdCancion}/{PalabraClave}/{NumPagina}/{TamPagina}")
    void Listar(
            @Path("IdLocal") String str_pIdLocal,
            @Path("IdCancion") String str_pIdCancion,
            @Path("PalabraClave") String str_pPalabraClave,
            @Path("NumPagina") String str_pNumPagina,
            @Path("TamPagina") String str_pTamPagina,
            ServiceCallback<List<LocalCancion>> obj_pCallBack);

    @GET("/ListarLista/{IdLocal}/{NumPagina}/{TamPagina}")
    void ListarLista(
            @Path("IdLocal") String str_pIdLocal,
            @Path("NumPagina") String str_pNumPagina,
            @Path("TamPagina") String str_pTamPagina,
            ServiceCallback<List<LocalCancion>> obj_pCallBack);

    @GET("/ListarRanking/{IdLocal}/{NumPagina}/{TamPagina}")
    void ListarRanking(
            @Path("IdLocal") String str_pIdLocal,
            @Path("NumPagina") String str_pNumPagina,
            @Path("TamPagina") String str_pTamPagina,
            ServiceCallback<List<LocalCancion>> obj_pCallBack);

    @GET("/ListarCancionesPorUsuario/{IdLocal}/{UsuarioLogeado}/{NumPagina}/{TamPagina}")
    void ListarCancionesPorUsuario(
            @Path("IdLocal") String str_pIdLocal,
            @Path("UsuarioLogeado") String str_pUsuarioLogeado,
            @Path("NumPagina") String str_pNumPagina,
            @Path("TamPagina") String str_pTamPagina,
            ServiceCallback<List<LocalCancion>> obj_pCallBack);


    @GET("/ListarRankingFiltro/{IdLocal}/{IdGenero}/{IdIdioma}/{PalabraClave}/{NumPagina}/{TamPagina}")
    void ListarRankingFiltro(
            @Path("IdLocal") String str_pIdLocal,
            @Path("IdGenero") String str_pIdGenero,
            @Path("IdIdioma") String str_pIdIdioma,
            @Path("PalabraClave") String str_pPalabraClave,
            @Path("NumPagina") String str_pNumPagina,
            @Path("TamPagina") String str_pTamPagina,
            ServiceCallback<List<LocalCancion>> obj_pCallBack);


    @GET("/ListarNovedades/{IdLocal}/{NumPagina}/{TamPagina}")
    void ListarNovedades(
            @Path("IdLocal") String str_pIdLocal,
            @Path("NumPagina") String str_pNumPagina,
            @Path("TamPagina") String str_pTamPagina,
            ServiceCallback<List<LocalCancion>> obj_pCallBack);


    @GET("/ListarListaFiltro/{IdLocal}/{IdGenero}/{IdIdioma}/{PalabraClave}/{NumPagina}/{TamPagina}")
    void ListarListaFiltro(
            @Path("IdLocal") String str_pIdLocal,
            @Path("IdGenero") String str_pIdGenero,
            @Path("IdIdioma") String str_pIdIdioma,
            @Path("PalabraClave") String str_pPalabraClave,
            @Path("NumPagina") String str_pNumPagina,
            @Path("TamPagina") String str_pTamPagina,
            ServiceCallback<List<LocalCancion>> obj_pCallBack);

    @GET("/ListarNovedadesFiltro/{IdLocal}/{IdGenero}/{IdIdioma}/{PalabraClave}/{NumPagina}/{TamPagina}")
    void ListarNovedadesFiltro(
            @Path("IdLocal") String str_pIdLocal,
            @Path("IdGenero") String str_pIdGenero,
            @Path("IdIdioma") String str_pIdIdioma,
            @Path("PalabraClave") String str_pPalabraClave,
            @Path("NumPagina") String str_pNumPagina,
            @Path("TamPagina") String str_pTamPagina,
            ServiceCallback<List<LocalCancion>> obj_pCallBack);

    @GET("/ListarTodos/{IdGenero}/{IdIdioma}/{PalabraClave}/{NumPagina}/{TamPagina}")
    void ListarTodos(
            @Path("IdGenero") String str_pIdGenero,
            @Path("IdIdioma") String str_pIdIdioma,
            @Path("PalabraClave") String str_pPalabraClave,
            @Path("NumPagina") String str_pNumPagina,
            @Path("TamPagina") String str_pTamPagina,
            ServiceCallback<List<LocalCancion>> obj_pCallBack);
}
