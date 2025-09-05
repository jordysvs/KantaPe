using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Kruma.Core.Util.Common;
using System.Transactions;

namespace Kruma.KantaPe.Negocio
{
    /// <summary>LocalCancion</summary>
    /// <remarks><list type="bullet">
    /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
    /// <item><FecCrea>12-07-2016</FecCrea></item></list></remarks>

    public class LocalCancion
    {
        #region Metodos Públicos

        /// <summary>Listado de LocalCancion</summary>
        /// <param name="int_pIdLocal">IdLocal</param>
        /// <param name="int_pIdCancion">IdCancion</param>
        /// <param name="str_pPalabraClave">Palabra Clave</param>
        /// <param name="str_pEstado">Estado</param>
        /// <param name="int_pNumPagina" >Numero de pagina</param>
        /// <param name="int_pTamPagina" >Tamaño de pagina</param>
        /// <returns>Lista de LocalCancion</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>12-07-2016</FecCrea></item></list></remarks>
        public static Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.LocalCancion> Listar(
            int? int_pIdLocal,
            int? int_pIdCancion,
            int? int_pIdEmpresa,
            string str_PalabraClave,
            string str_pTitulo,
            string str_pArtista,
            string str_pAlbum,
            int? int_pIdGenero,
            int? int_pIdIdioma,
            string str_pEstado,
            int? int_pNumPagina,
            int? int_pTamPagina)
        {
            return Kruma.KantaPe.Data.LocalCancion.Listar(
                    int_pIdLocal,
                    null,
                    int_pIdEmpresa,
                    str_PalabraClave,
                    str_pTitulo,
                    str_pArtista,
                    str_pAlbum,
                    int_pIdGenero,
                    int_pIdIdioma,
                    str_pEstado,
                    int_pNumPagina,
                    int_pTamPagina);
        }

        //Listar po Usuario Logeado

        public static Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.LocalCancion> ListarCancionesUsuarioLogeado(
        int? int_pIdLocal,
        int? int_pIdCancion,
        int? int_pIdEmpresa,
        string str_pUsuarioLogeado,
        string str_pTitulo,
        string str_pArtista,
        string str_pAlbum,
        int? int_pIdGenero,
        int? int_pIdIdioma,
        string str_pEstado,
        int? int_pNumPagina,
        int? int_pTamPagina)
        {
            return Kruma.KantaPe.Data.LocalCancion.ListarCancionesUsuarioLogeado(
                    int_pIdLocal,
                    null,
                    int_pIdEmpresa,
                    str_pUsuarioLogeado,
                    str_pTitulo,
                    str_pArtista,
                    str_pAlbum,
                    int_pIdGenero,
                    int_pIdIdioma,
                    str_pEstado,
                    int_pNumPagina,
                    int_pTamPagina);
        }


        //ListadoDoble

        public static Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.LocalCancion> ListarDoble(
        int? int_pIdLocal,
        int? int_pIdCancion,
        int? int_pIdEmpresa,
        string str_PalabraClave1,
        string str_PalabraClave2,
        string str_pTitulo,
        string str_pArtista,
        string str_pAlbum,
        int? int_pIdGenero,
        int? int_pIdIdioma,
        string str_pEstado,
        int? int_pNumPagina,
        int? int_pTamPagina)
        {
            return Kruma.KantaPe.Data.LocalCancion.ListarDoble(
                    int_pIdLocal,
                    null,
                    int_pIdEmpresa,
                    str_PalabraClave1,
                    str_PalabraClave2,
                    str_pTitulo,
                    str_pArtista,
                    str_pAlbum,
                    int_pIdGenero,
                    int_pIdIdioma,
                    str_pEstado,
                    int_pNumPagina,
                    int_pTamPagina);
        }
        /// <summary>Obtener LocalCancion</summary>
        /// <param name="int_pIdLocal">IdLocal</param>
        /// <param name="int_pIdCancion">IdCancion</param>
        /// <returns>Objeto LocalCancion</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>12-07-2016</FecCrea></item></list></remarks>
        public static Kruma.KantaPe.Entidad.LocalCancion Obtener(int int_pIdLocal, int int_pIdCancion)
        {
            return Kruma.KantaPe.Data.LocalCancion.Obtener(int_pIdLocal, int_pIdCancion);
        }

        /// <summary>Insertar canción del local</summary>
        /// <param name="obj_pLocalCancion">LocalCancion</param>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>02-07-2016</FecCrea></item></list></remarks>
        public static Kruma.Core.Util.Common.ProcessResult Insertar(Kruma.KantaPe.Entidad.LocalCancion obj_pLocalCancion)
        {
            Kruma.Core.Util.Common.ProcessResult obj_Resultado = null;

            try
            {
                Kruma.KantaPe.Data.LocalCancion.Insertar(obj_pLocalCancion);

                obj_Resultado = new Kruma.Core.Util.Common.ProcessResult(obj_pLocalCancion.IdCancion);
            }
            catch (Exception obj_pExcepcion)
            {
                obj_Resultado = new Kruma.Core.Util.Common.ProcessResult(obj_pExcepcion);
            }
            return obj_Resultado;
        }

        /// <summary>Modificar canción del local</summary>
        /// <param name="obj_pLocalCancion">LocalCancion</param>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>02-07-2016</FecCrea></item></list></remarks>
        public static Kruma.Core.Util.Common.ProcessResult Modificar(Kruma.KantaPe.Entidad.LocalCancion obj_pLocalCancion)
        {
            Kruma.Core.Util.Common.ProcessResult obj_Resultado = null;
            try
            {
                Kruma.KantaPe.Data.LocalCancion.Modificar(obj_pLocalCancion);
                obj_Resultado = new Kruma.Core.Util.Common.ProcessResult(obj_pLocalCancion.IdCancion);
            }
            catch (Exception obj_pExcepcion)
            {
                obj_Resultado = new Kruma.Core.Util.Common.ProcessResult(obj_pExcepcion);
            }
            return obj_Resultado;
        }

        /// <summary>Insertar canción del local</summary>
        /// <param name="obj_pLocalCancion">LocalCancion</param>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>02-07-2016</FecCrea></item></list></remarks>
        public static Kruma.Core.Util.Common.ProcessResult Solicitar(Kruma.KantaPe.Entidad.LocalCancion obj_pLocalCancion)
        {
            Kruma.Core.Util.Common.ProcessResult obj_Resultado = null;
            try
            {
                using (TransactionScope obj_Transaccion = new TransactionScope())
                {
                    //Cancion
                    Kruma.KantaPe.Entidad.LocalCancion obj_Cancion = obj_pLocalCancion.Cancion;
                    obj_Cancion.Estado = Kruma.KantaPe.Entidad.Constante.Estado_Activo;
                    obj_Cancion.UsuarioCreacion = obj_pLocalCancion.UsuarioCreacion;

                    //Artista
                    Kruma.KantaPe.Entidad.Artista obj_Artista = obj_Cancion.Artista;
                    obj_Artista.Estado = Kruma.KantaPe.Entidad.Constante.Estado_Activo;
                    obj_Artista.UsuarioCreacion = obj_pLocalCancion.UsuarioCreacion;
                    //Validacion si eligio un artista
                    if (!obj_Artista.IdArtista.HasValue)
                    {
                        System.Collections.Generic.List<Kruma.KantaPe.Entidad.Artista> lst_Artista =
                            Kruma.KantaPe.Data.Artista.Listar(null, obj_Artista.Nombre, null, null, null).Result;
                        if (lst_Artista.Count <= 0)
                            //Inserción del artista
                            obj_Artista.IdArtista = Kruma.KantaPe.Data.Artista.Insertar(obj_Artista);
                        else
                        {
                            //Actualización del artista
                            obj_Artista = lst_Artista[0];
                            obj_Artista.Estado = Kruma.KantaPe.Entidad.Constante.Estado_Activo;
                            Kruma.KantaPe.Data.Artista.Modificar(obj_Artista);
                        }
                    }

                    //Album
                    Kruma.KantaPe.Entidad.Album obj_Album = obj_Cancion.Album;
                    obj_Album.Estado = Kruma.KantaPe.Entidad.Constante.Estado_Activo;
                    obj_Album.UsuarioCreacion = obj_pLocalCancion.UsuarioCreacion;
                    //Validacion si eligio un album
                    if (!obj_Album.IdAlbum.HasValue)
                    {
                        System.Collections.Generic.List<Kruma.KantaPe.Entidad.Album> lst_Album =
                            Kruma.KantaPe.Data.Album.Listar(null, obj_Artista.IdArtista, null, obj_Album.Titulo, null, null, null).Result;
                        if (lst_Album.Count <= 0)
                            //Inserción del album
                            obj_Album.IdAlbum = Kruma.KantaPe.Data.Album.Insertar(obj_Album);
                        else
                        {
                            //Actualización del album
                            obj_Album = lst_Album[0];
                            obj_Album.Estado = Kruma.KantaPe.Entidad.Constante.Estado_Activo;
                            Kruma.KantaPe.Data.Album.Modificar(obj_Album);
                        }
                    }

                    //Genero
                    Kruma.KantaPe.Entidad.Genero obj_Genero = obj_Cancion.Genero;
                    obj_Genero.Estado = Kruma.KantaPe.Entidad.Constante.Estado_Activo;
                    obj_Genero.UsuarioCreacion = obj_pLocalCancion.UsuarioCreacion;
                    //Validacion si eligio un genero
                    if (!obj_Genero.IdGenero.HasValue)
                    {
                        System.Collections.Generic.List<Kruma.KantaPe.Entidad.Genero> lst_Genero =
                            Kruma.KantaPe.Data.Genero.Listar(null, obj_Genero.Descripcion, null, null, null).Result;
                        if (lst_Genero.Count <= 0)
                            //Inserción del género
                            obj_Genero.IdGenero = Kruma.KantaPe.Data.Genero.Insertar(obj_Genero);
                        else
                        {
                            //Actualización del género
                            obj_Genero = lst_Genero[0];
                            obj_Genero.Estado = Kruma.KantaPe.Entidad.Constante.Estado_Activo;
                            Kruma.KantaPe.Data.Genero.Modificar(obj_Genero);
                        }

                    }

                    //Idioma
                    Kruma.KantaPe.Entidad.Idioma obj_Idioma = obj_Cancion.Idioma;
                    obj_Idioma.Estado = Kruma.KantaPe.Entidad.Constante.Estado_Activo;
                    obj_Idioma.UsuarioCreacion = obj_pLocalCancion.UsuarioCreacion;
                    //Validacion si eligio el idioma
                    if (!obj_Idioma.IdIdioma.HasValue)
                    {
                        System.Collections.Generic.List<Kruma.KantaPe.Entidad.Idioma> lst_Idioma =
                            Kruma.KantaPe.Data.Idioma.Listar(null, obj_Idioma.Descripcion, null, null, null).Result;
                        if (lst_Idioma.Count <= 0)
                            //Inserción del idioma
                            obj_Idioma.IdIdioma = Kruma.KantaPe.Data.Idioma.Insertar(obj_Idioma);
                        else
                        {
                            //Actualización del idioma
                            obj_Idioma = lst_Idioma[0];
                            obj_Idioma.Estado = Kruma.KantaPe.Entidad.Constante.Estado_Activo;
                            Kruma.KantaPe.Data.Idioma.Modificar(obj_Idioma);
                        }
                    }
                    obj_Cancion.IdCancionSolicitud = int.Parse(Kruma.Core.Business.Logical.Parametro.Obtener(
                        Kruma.KantaPe.Entidad.Constante.Parametro.Modulo,
                        Kruma.KantaPe.Entidad.Constante.Parametro.CancionSolicitud_Solicitada
                        ).Valor);

                    //Nueva Cancion
                    if (!obj_Cancion.IdCancion.HasValue)
                        Kruma.KantaPe.Data.LocalCancion.Insertar(obj_Cancion);

                    Kruma.KantaPe.Data.LocalCancion.Insertar(obj_pLocalCancion);
                    obj_Resultado = new Kruma.Core.Util.Common.ProcessResult(obj_pLocalCancion.IdCancion);
                    obj_Transaccion.Complete();
                }

            }
            catch (Exception obj_pExcepcion)
            {
                obj_Resultado = new Kruma.Core.Util.Common.ProcessResult(obj_pExcepcion);
            }
            return obj_Resultado;
        }

        /// <summary>Modificar Estado Local Cancion</summary>
        /// <param name="obj_pLocalCancion">LocalCancion</param>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>02-07-2016</FecCrea></item></list></remarks>
        public static Kruma.Core.Util.Common.ProcessResult ModificarEstado(Kruma.KantaPe.Entidad.LocalCancion obj_pLocalCancion)
        {
            Kruma.Core.Util.Common.ProcessResult obj_Resultado = null;
            try
            {
                Kruma.KantaPe.Entidad.LocalCancion obj_LocalCancion = Kruma.KantaPe.Data.LocalCancion.Obtener(
                    obj_pLocalCancion.IdLocal.Value,
                    obj_pLocalCancion.IdCancion.Value);

                if (obj_LocalCancion.Estado == obj_pLocalCancion.Estado)
                {
                    string str_Mensaje = obj_pLocalCancion.Estado ==
                        Kruma.KantaPe.Entidad.Constante.Estado_Activo ?
                        "La canción ya se encuentra activa." :
                        "La canción ya se encuentra inactiva.";
                    return new Kruma.Core.Util.Common.ProcessResult(new Exception(str_Mensaje), str_Mensaje);
                }
                obj_LocalCancion.Estado = obj_pLocalCancion.Estado;
                obj_LocalCancion.UsuarioModificacion = obj_pLocalCancion.UsuarioModificacion;
                Kruma.KantaPe.Data.LocalCancion.Modificar(obj_LocalCancion);

                obj_Resultado = new Kruma.Core.Util.Common.ProcessResult(obj_pLocalCancion.IdCancion);
            }
            catch (Exception obj_pExcepcion)
            {
                obj_Resultado = new Kruma.Core.Util.Common.ProcessResult(obj_pExcepcion);
            }

            return obj_Resultado;
        }

        #endregion
    }
}