using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Kruma.KantaPe.Data
{
    public class LocalCancionTemporal
    {
        #region Metodos Públicos
        /// <summary>Listado de Canciones</summary>
        /// <param name="int_pIdCancion">Id de canción</param>
        /// <param name="str_pTitulo">Título del canción</param>
        /// <param name="int_pIdArtista">Id de artista</param>
        /// <param name="int_pIdAlbum">Id de álbum</param>
        /// <param name="int_pIdGenero">Id de género</param>
        /// <param name="int_pIdIdioma">Id de idioma</param>
        /// <param name="str_pDecada">Década de la canción</param>
        /// <param name="int_pAnio">Versión de la canción</param>
        /// <param name="str_pYoutube">Link de Youtube de la canción</param>
        /// <param name="int_pIdCancionSolicitud">Id de canción solicitud</param>
        /// <param name="str_pEstado">Estado del álbum</param>
        /// <param name="int_pNumPagina" >Número de página</param>
        /// <param name="int_pTamPagina" >Tamaño de página</param>
        /// <returns>Lista del Canciones</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por Carlos Gómez</CreadoPor></item>
        /// <item><FecCrea>11-07-2016</FecCrea></item></list></remarks>
        public static Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.LocalCancionTemporal> Listar(
            int? int_pIdEmpresa,
            int? int_pIdLocal,
            int? int_pNumPagina,
            int? int_pTamPagina)
        {
            Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.LocalCancionTemporal> obj_Lista = new Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.LocalCancionTemporal>();
            obj_Lista.PageNumber = int_pNumPagina;
            obj_Lista.Total = 0;


            Kruma.Core.Data.Entity.DataOperation dop_Operacion = new Kruma.Core.Data.Entity.DataOperation("ListarLocalCancionTemporal");

            dop_Operacion.Parameters.Add(new Kruma.Core.Data.Entity.Parameter("@pIdEmpresa", int_pIdEmpresa.HasValue ? int_pIdEmpresa.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Kruma.Core.Data.Entity.Parameter("@pIdLocal", int_pIdLocal.HasValue ? int_pIdLocal.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Kruma.Core.Data.Entity.Parameter("@pNumPagina", int_pNumPagina.HasValue ? int_pNumPagina.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Kruma.Core.Data.Entity.Parameter("@pTamPagina", int_pTamPagina.HasValue ? int_pTamPagina.Value : (object)DBNull.Value));

            DataTable dt_Resultado = Kruma.Core.Data.DataManager.ExecuteDataSet(Conexiones.CO_KantaPe, dop_Operacion).Tables[0];

            List<Kruma.KantaPe.Entidad.LocalCancionTemporal> lst_Cancion = new List<Kruma.KantaPe.Entidad.LocalCancionTemporal>();
            Kruma.KantaPe.Entidad.LocalCancionTemporal obj_Cancion = new Kruma.KantaPe.Entidad.LocalCancionTemporal();
            foreach (DataRow obj_Row in dt_Resultado.Rows)
            {
                if (lst_Cancion.Count == 0)
                    obj_Lista.Total = (int)obj_Row["Total_Filas"];
                obj_Cancion = new Kruma.KantaPe.Entidad.LocalCancionTemporal();
                obj_Cancion.IdLocalCancionTemporal = obj_Row["IdLocalCancionTemporal"] is DBNull ? null : (int?)obj_Row["IdLocalCancionTemporal"];
                obj_Cancion.NombreArchivo = obj_Row["NombreArchivo"] is DBNull ? null : obj_Row["NombreArchivo"].ToString();
                obj_Cancion.FlagVisible = obj_Row["FlagVisible"] is DBNull ? null : obj_Row["FlagVisible"].ToString();
                obj_Cancion.Estado = obj_Row["Estado"] is DBNull ? null : obj_Row["Estado"].ToString();
                obj_Cancion.IdEmpresa = obj_Row["IdEmpresa"] is DBNull ? null : (int?)obj_Row["IdEmpresa"];
                obj_Cancion.IdLocal = obj_Row["IdLocal"] is DBNull ? null : (int?)obj_Row["IdLocal"];
                obj_Cancion.UsuarioCreacion = obj_Row["UsuarioCreacion"] is DBNull ? null : obj_Row["Local_Direccion"].ToString();
                obj_Cancion.FechaCreacion = obj_Row["FechaCreacion"] is DBNull ? null : (DateTime?)obj_Row["FechaCreacion"];
                obj_Cancion.UsuarioModificacion = obj_Row["UsuarioModificacion"] is DBNull ? null : obj_Row["UsuarioModificacion"].ToString();
                obj_Cancion.FechaModificacion = obj_Row["FechaModificacion"] is DBNull ? null : (DateTime?)obj_Row["FechaModificacion"];

                lst_Cancion.Add(obj_Cancion);
            }

            obj_Lista.Result = lst_Cancion;
            return obj_Lista;
        }
        /// <summary>Modificar </summary>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por Vicente Gonzales</CreadoPor></item>
        /// <item><FecCrea>03-06-2017</FecCrea></item></list></remarks>
        public static void Modificar(Kruma.KantaPe.Entidad.LocalCancionTemporal obj_pCancion)
        {
            Kruma.Core.Data.Entity.DataOperation dop_Operacion = new Kruma.Core.Data.Entity.DataOperation("ActualizarLocalCancionTemporal");

            dop_Operacion.Parameters.Add(new Kruma.Core.Data.Entity.Parameter("@pIdLocalCancionTemporal", obj_pCancion.IdLocalCancionTemporal));
            dop_Operacion.Parameters.Add(new Kruma.Core.Data.Entity.Parameter("@pNombreArchivo", obj_pCancion.NombreArchivo));
            dop_Operacion.Parameters.Add(new Kruma.Core.Data.Entity.Parameter("@pFlagVisible", obj_pCancion.FlagVisible));
            dop_Operacion.Parameters.Add(new Kruma.Core.Data.Entity.Parameter("@pEstado", obj_pCancion.Estado));
            dop_Operacion.Parameters.Add(new Kruma.Core.Data.Entity.Parameter("@pIdEmpresa", obj_pCancion.IdEmpresa));
            dop_Operacion.Parameters.Add(new Kruma.Core.Data.Entity.Parameter("@pIdLocal", obj_pCancion.IdLocal));

            Kruma.Core.Data.DataManager.ExecuteNonQuery(Conexiones.CO_KantaPe, dop_Operacion, false);
        }
        #endregion
    }
}
