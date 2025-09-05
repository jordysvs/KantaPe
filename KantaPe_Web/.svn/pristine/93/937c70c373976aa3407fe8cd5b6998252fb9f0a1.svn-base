using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Kruma.KantaPe.Negocio
{
    /// <summary>SolicitudCancion</summary>
    /// <remarks><list type="bullet">
    /// <item><CreadoPor>Creado por Carlos Gómez</CreadoPor></item>
    /// <item><FecCrea>24-08-2016</FecCrea></item></list></remarks>

    public class SolicitudCancion
    {

        #region Metodos Públicos

        /// <summary>Listado de SolicitudCancion</summary>
		/// <param name="int_pIdSolicitudCancion">IdSolicitudCancion</param>
		/// <param name="str_pCancion">Cancion</param>
		/// <param name="str_pArtista">Artista</param>
		/// <param name="str_pAlbum">Album</param>
		/// <param name="str_pIdioma">Idioma</param>
		/// <param name="str_pGenero">Genero</param>
		/// <param name="str_pYoutube">Youtube</param>
		/// <param name="str_pEstado">Estado</param>
		/// <param name="int_pNumPagina" >Numero de pagina</param>
		/// <param name="int_pTamPagina" >Tamaño de pagina</param>
		/// <returns>Lista de SolicitudCancion</returns>
		/// <remarks><list type="bullet">
		/// <item><CreadoPor>Creado por Vicente Gonzales Osorio</CreadoPor></item>
		/// <item><FecCrea>23-02-2017</FecCrea></item></list></remarks>
		public static Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.SolicitudCancion> Listar(int? int_pIdSolicitudCancion, string str_pCancion, string str_pArtista, string str_pAlbum, string str_pIdioma, string str_pGenero, string str_pYoutube, string str_pEstado, int? int_pNumPagina, int? int_pTamPagina)
        {
            return Kruma.KantaPe.Data.SolicitudCancion.Listar(int_pIdSolicitudCancion, str_pCancion, str_pArtista, str_pAlbum, str_pIdioma, str_pGenero, str_pYoutube, str_pEstado, int_pNumPagina, int_pTamPagina);
        }

        /// <summary>Insertar SolicitudCancion</summary>
        /// <param name="obj_pSolicitudCancion">SolicitudCancion</param>
        /// <returns>Id de SolicitudCancion</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por Carlos Gómez</CreadoPor></item>
        /// <item><FecCrea>24-08-2016</FecCrea></item></list></remarks>
        public static Kruma.Core.Util.Common.ProcessResult Insertar(Kruma.KantaPe.Entidad.SolicitudCancion obj_pSolicitudCancion)
        {
            Kruma.Core.Util.Common.ProcessResult obj_Resultado = null;
            try
            {

                obj_pSolicitudCancion.Estado = Kruma.KantaPe.Entidad.Constante.Estado_Pendiente;

                int int_IdSolicitudCancion = Kruma.KantaPe.Data.SolicitudCancion.Insertar(obj_pSolicitudCancion);
                obj_Resultado = new Kruma.Core.Util.Common.ProcessResult(int_IdSolicitudCancion);
            }
            catch (Exception obj_pExcepcion)
            {
                obj_Resultado = new Kruma.Core.Util.Common.ProcessResult(obj_pExcepcion);
            }
            return obj_Resultado;
        }

        /// <summary>Actualizar SolicitudCancion</summary>
		/// <param name="obj_pSolicitudCancion">SolicitudCancion</param>
		/// <remarks><list type="bullet">
		/// <item><CreadoPor>Creado por Vicente Gonzales Osorio</CreadoPor></item>
		/// <item><FecCrea>26-02-2017</FecCrea></item></list></remarks>
		public static Kruma.Core.Util.Common.ProcessResult Modificar(Kruma.KantaPe.Entidad.SolicitudCancion obj_pSolicitudCancion)
        {
            Kruma.Core.Util.Common.ProcessResult obj_Resultado = null;
            try
            {
                Kruma.KantaPe.Data.SolicitudCancion.Modificar(obj_pSolicitudCancion);
                obj_Resultado = new Kruma.Core.Util.Common.ProcessResult(obj_pSolicitudCancion.IdSolicitudCancion);
            }
            catch (Exception obj_pExcepcion)
            {
                obj_Resultado = new Kruma.Core.Util.Common.ProcessResult(obj_pExcepcion);
            }
            return obj_Resultado;
        }

        /// <summary>Obtener SolicitudCancion</summary>
		/// <param name="int_pIdSolicitudCancion">IdSolicitudCancion</param>
		/// <returns>Objeto SolicitudCancion</returns>
		/// <remarks><list type="bullet">
		/// <item><CreadoPor>Creado por Vicente Gonzales Osorio</CreadoPor></item>
		/// <item><FecCrea>26-02-2017</FecCrea></item></list></remarks>
		public static Kruma.KantaPe.Entidad.SolicitudCancion Obtener(int? int_pIdSolicitudCancion)
        {
            return Kruma.KantaPe.Data.SolicitudCancion.Obtener(int_pIdSolicitudCancion);
        }
        /// <summary>Listado de usuarios que piden mas canciones</summary>
		/// <param name="int_pIdSolicitudCancion">IdSolicitudCancion</param>
		/// <returns>Lista de SolicitudCancion</returns>
		/// <remarks><list type="bullet">
		/// <item><CreadoPor>Creado por Vicente Gonzales Osorio</CreadoPor></item>
		/// <item><FecCrea>23-02-2017</FecCrea></item></list></remarks>
		public static Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.SolicitudCancion> ListarUsuarioPideCancionesTop(
            string str_pNombreCompleto,
            DateTime? dt_pFechaInicio,
            DateTime? dt_pFechaFin)
        {
            return Kruma.KantaPe.Data.SolicitudCancion.ListarUsuarioPideCancionesTop(str_pNombreCompleto, dt_pFechaInicio, dt_pFechaFin);
        }
        #endregion
    }
}
