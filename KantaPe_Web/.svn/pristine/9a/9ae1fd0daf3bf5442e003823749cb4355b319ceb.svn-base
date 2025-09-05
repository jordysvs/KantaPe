using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data;
using Kruma.Core.Data;
using Kruma.Core.Data.Entity;

namespace Kruma.KantaPe.Data
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
            Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.SolicitudCancion> obj_Lista = new Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.SolicitudCancion>();
            obj_Lista.PageNumber = int_pNumPagina;
            obj_Lista.Total = 0;

            DataOperation dop_Operacion = new DataOperation("ListarSolicitudCancion");
            dop_Operacion.Parameters.Add(new Parameter("@pIdSolicitudCancion", int_pIdSolicitudCancion.HasValue ? int_pIdSolicitudCancion.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pCancion", !string.IsNullOrEmpty(str_pCancion) ? str_pCancion : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pArtista", !string.IsNullOrEmpty(str_pArtista) ? str_pArtista : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pAlbum", !string.IsNullOrEmpty(str_pAlbum) ? str_pAlbum : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pIdioma", !string.IsNullOrEmpty(str_pIdioma) ? str_pIdioma : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pGenero", !string.IsNullOrEmpty(str_pGenero) ? str_pGenero : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pYoutube", !string.IsNullOrEmpty(str_pYoutube) ? str_pYoutube : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pEstado", !string.IsNullOrEmpty(str_pEstado) ? str_pEstado : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pNumPagina", int_pNumPagina.HasValue ? int_pNumPagina.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pTamPagina", int_pTamPagina.HasValue ? int_pTamPagina.Value : (object)DBNull.Value));

            DataTable dt_Resultado = DataManager.ExecuteDataSet(Conexiones.CO_KantaPe, dop_Operacion).Tables[0];

            List<Kruma.KantaPe.Entidad.SolicitudCancion> lst_SolicitudCancion = new List<Kruma.KantaPe.Entidad.SolicitudCancion>();
            Kruma.KantaPe.Entidad.SolicitudCancion obj_SolicitudCancion = new Kruma.KantaPe.Entidad.SolicitudCancion();
            foreach (DataRow obj_Row in dt_Resultado.Rows)
            {
                if (lst_SolicitudCancion.Count == 0)
                    obj_Lista.Total = (int)obj_Row["Total_Filas"];
                obj_SolicitudCancion = new Kruma.KantaPe.Entidad.SolicitudCancion();
                obj_SolicitudCancion.IdSolicitudCancion = obj_Row["IdSolicitudCancion"] is DBNull ? null : (int?)obj_Row["IdSolicitudCancion"];
                obj_SolicitudCancion.Cancion = obj_Row["Cancion"] is DBNull ? null : obj_Row["Cancion"].ToString();
                obj_SolicitudCancion.Artista = obj_Row["Artista"] is DBNull ? null : obj_Row["Artista"].ToString();
                obj_SolicitudCancion.Album = obj_Row["Album"] is DBNull ? null : obj_Row["Album"].ToString();
                obj_SolicitudCancion.Idioma = obj_Row["Idioma"] is DBNull ? null : obj_Row["Idioma"].ToString();
                obj_SolicitudCancion.Genero = obj_Row["Genero"] is DBNull ? null : obj_Row["Genero"].ToString();
                obj_SolicitudCancion.Youtube = obj_Row["Youtube"] is DBNull ? null : obj_Row["Youtube"].ToString();
                obj_SolicitudCancion.Estado = obj_Row["Estado"] is DBNull ? null : obj_Row["Estado"].ToString();
                obj_SolicitudCancion.UsuarioCreacion = obj_Row["UsuarioCreacion"] is DBNull ? null : obj_Row["UsuarioCreacion"].ToString();
                obj_SolicitudCancion.FechaCreacion = obj_Row["FechaCreacion"] is DBNull ? null : (DateTime?)obj_Row["FechaCreacion"];
                obj_SolicitudCancion.UsuarioModificacion = obj_Row["UsuarioModificacion"] is DBNull ? null : obj_Row["UsuarioModificacion"].ToString();
                obj_SolicitudCancion.FechaModificacion = obj_Row["FechaModificacion"] is DBNull ? null : (DateTime?)obj_Row["FechaModificacion"];
                lst_SolicitudCancion.Add(obj_SolicitudCancion);
            }

            obj_Lista.Result = lst_SolicitudCancion;
            return obj_Lista;
        }

        /// <summary>Insertar SolicitudCancion</summary>
        /// <param name="obj_pSolicitudCancion">SolicitudCancion</param>
        /// <returns>Id de SolicitudCancion</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por Carlos Gómez</CreadoPor></item>
        /// <item><FecCrea>25-08-2016</FecCrea></item></list></remarks>
        public static int Insertar(Kruma.KantaPe.Entidad.SolicitudCancion obj_pSolicitudCancion)
        {
            Kruma.Core.Data.Entity.DataOperation dop_Operacion = new Kruma.Core.Data.Entity.DataOperation("InsertarSolicitudCancion");

            dop_Operacion.Parameters.Add(new Kruma.Core.Data.Entity.Parameter("@pCancion", obj_pSolicitudCancion.Cancion));
            dop_Operacion.Parameters.Add(new Kruma.Core.Data.Entity.Parameter("@pArtista", obj_pSolicitudCancion.Artista));
            dop_Operacion.Parameters.Add(new Kruma.Core.Data.Entity.Parameter("@pAlbum", obj_pSolicitudCancion.Album));
            dop_Operacion.Parameters.Add(new Kruma.Core.Data.Entity.Parameter("@pIdioma", obj_pSolicitudCancion.Idioma));
            dop_Operacion.Parameters.Add(new Kruma.Core.Data.Entity.Parameter("@pGenero", obj_pSolicitudCancion.Genero));
            dop_Operacion.Parameters.Add(new Kruma.Core.Data.Entity.Parameter("@pYoutube", obj_pSolicitudCancion.Youtube));
            dop_Operacion.Parameters.Add(new Kruma.Core.Data.Entity.Parameter("@pEstado", obj_pSolicitudCancion.Estado));
            dop_Operacion.Parameters.Add(new Kruma.Core.Data.Entity.Parameter("@pUsuarioCreacion", obj_pSolicitudCancion.UsuarioCreacion));

            Kruma.Core.Data.Entity.Parameter obj_IdSolicitudCancion = new Kruma.Core.Data.Entity.Parameter("@pIdSolicitudCancion", DbType.Int32);
            obj_IdSolicitudCancion.Direction = ParameterDirection.Output;
            dop_Operacion.Parameters.Add(obj_IdSolicitudCancion);

            Kruma.Core.Data.DataManager.ExecuteNonQuery(Conexiones.CO_KantaPe, dop_Operacion, false);
            int int_IdSolicituCancion = (int)obj_IdSolicitudCancion.Value;

            return int_IdSolicituCancion;
        }

        /// <summary>Actualizar SolicitudCancion</summary>
		/// <param name="obj_pSolicitudCancion">SolicitudCancion</param>
		/// <remarks><list type="bullet">
		/// <item><CreadoPor>Creado por Vicente Gonzales Osorio</CreadoPor></item>
		/// <item><FecCrea>26-02-2017</FecCrea></item></list></remarks>
		public static void Modificar(Kruma.KantaPe.Entidad.SolicitudCancion obj_pSolicitudCancion)
        {
            DataOperation dop_Operacion = new DataOperation("ActualizarSolicitudCancion");

            dop_Operacion.Parameters.Add(new Parameter("@pIdSolicitudCancion", obj_pSolicitudCancion.IdSolicitudCancion));
            dop_Operacion.Parameters.Add(new Parameter("@pCancion", obj_pSolicitudCancion.Cancion));
            dop_Operacion.Parameters.Add(new Parameter("@pArtista", obj_pSolicitudCancion.Artista));
            dop_Operacion.Parameters.Add(new Parameter("@pAlbum", obj_pSolicitudCancion.Album));
            dop_Operacion.Parameters.Add(new Parameter("@pIdioma", obj_pSolicitudCancion.Idioma));
            dop_Operacion.Parameters.Add(new Parameter("@pGenero", obj_pSolicitudCancion.Genero));
            dop_Operacion.Parameters.Add(new Parameter("@pYoutube", obj_pSolicitudCancion.Youtube));
            dop_Operacion.Parameters.Add(new Parameter("@pEstado", obj_pSolicitudCancion.Estado));
            dop_Operacion.Parameters.Add(new Parameter("@pMotivo", obj_pSolicitudCancion.Motivo));
            dop_Operacion.Parameters.Add(new Parameter("@pUsuarioModificacion", obj_pSolicitudCancion.UsuarioModificacion));

            DataManager.ExecuteNonQuery(Conexiones.CO_KantaPe, dop_Operacion, false);
        }

        /// <summary>Obtener SolicitudCancion</summary>
		/// <param name="int_pIdSolicitudCancion">IdSolicitudCancion</param>
		/// <returns>Objeto SolicitudCancion</returns>
		/// <remarks><list type="bullet">
		/// <item><CreadoPor>Creado por Vicente Gonzales Osorio</CreadoPor></item>
		/// <item><FecCrea>26-02-2017</FecCrea></item></list></remarks>
		public static Kruma.KantaPe.Entidad.SolicitudCancion Obtener(int? int_pIdSolicitudCancion)
        {
            Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.SolicitudCancion> lst_SolicitudCancion = Listar(int_pIdSolicitudCancion, null, null, null, null, null, null, null, null, null);
            return lst_SolicitudCancion.Result.Count > 0 ? lst_SolicitudCancion.Result[0] : null;
        }

        /// <summary>LISTADO DE USUARIOS QUE MAS PIDEN CANCIONES</summary>
		/// <param name="int_pIdSolicitudCancion">IdSolicitudCancion</param>
		/// <returns>Lista de SolicitudCancion</returns>
		/// <remarks><list type="bullet">
		/// <item><CreadoPor>Creado por Vicente Gonzales Osorio</CreadoPor></item>
		/// <item><FecCrea>23-02-2017</FecCrea></item></list></remarks>
		public static Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.SolicitudCancion> ListarUsuarioPideCancionesTop(
            string str_pNombreCompleto,
            DateTime? dt_pFechaInicio,
            DateTime? dt_pFechaFin
            )
        {
            Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.SolicitudCancion> obj_Lista = new Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.SolicitudCancion>();
            obj_Lista.Total = 0;

            DataOperation dop_Operacion = new DataOperation("ListarUsuarioPideCancionesTop");
            dop_Operacion.Parameters.Add(new Parameter("@pNombreCompleto", !string.IsNullOrEmpty(str_pNombreCompleto) ? str_pNombreCompleto : (object)DBNull.Value));

            Parameter obj_FechaInicio = new Parameter("@pFechaInicio", DbType.DateTime);
            obj_FechaInicio.Direction = ParameterDirection.Input;
            obj_FechaInicio.Value = dt_pFechaInicio.HasValue ? dt_pFechaInicio.Value : (object)DBNull.Value;
            dop_Operacion.Parameters.Add(obj_FechaInicio);

            Parameter obj_FechaFin = new Parameter("@pFechaFin", DbType.DateTime);
            obj_FechaFin.Direction = ParameterDirection.Input;
            obj_FechaFin.Value = dt_pFechaFin.HasValue ? dt_pFechaFin.Value : (object)DBNull.Value;
            dop_Operacion.Parameters.Add(obj_FechaFin);
            DataTable dt_Resultado = DataManager.ExecuteDataSet(Conexiones.CO_KantaPe, dop_Operacion).Tables[0];

            List<Kruma.KantaPe.Entidad.SolicitudCancion> lst_SolicitudCancion = new List<Kruma.KantaPe.Entidad.SolicitudCancion>();
            Kruma.KantaPe.Entidad.SolicitudCancion obj_SolicitudCancion = new Kruma.KantaPe.Entidad.SolicitudCancion();
            foreach (DataRow obj_Row in dt_Resultado.Rows)
            {
                obj_SolicitudCancion = new Kruma.KantaPe.Entidad.SolicitudCancion();
                obj_SolicitudCancion.Cantidad = obj_Row["Cantidad"] is DBNull ? null : (int?)obj_Row["Cantidad"];
                obj_SolicitudCancion.NombreCompleto = obj_Row["Usuario_NombreCompleto"] is DBNull ? null : obj_Row["Usuario_NombreCompleto"].ToString();

                lst_SolicitudCancion.Add(obj_SolicitudCancion);
            }

            obj_Lista.Result = lst_SolicitudCancion;
            return obj_Lista;
        }
        #endregion
    }
}
