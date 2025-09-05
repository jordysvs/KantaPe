using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Kruma.KantaPe.Data
{
    /// <summary>CancionSolicitud</summary>
    /// <remarks><list type="bullet">
    /// <item><CreadoPor>Creado por Carlos Gómez</CreadoPor></item>
    /// <item><FecCrea>11-07-2016</FecCrea></item></list></remarks>

    public class CancionSolicitud
    {

        #region Metodos Públicos

        /// <summary>Listado de CancionSolicitud</summary>
        /// <param name="int_pIdCancionSolicitud">Id de la CancionSolicitud</param>
        /// <param name="str_pDescripcion">Descripción de la CancionSolicitud</param>
        /// <param name="str_pEstado">Estado de la CancionSolicitud</param>
        /// <param name="int_pNumPagina" >Numero de pagina</param>
        /// <param name="int_pTamPagina" >Tamaño de pagina</param>
        /// <returns>Lista de cancion solicitud</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por Carlos Gómez</CreadoPor></item>
        /// <item><FecCrea>11-07-2016</FecCrea></item></list></remarks>
        public static Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.CancionSolicitud> Listar(
            int? int_pIdCancionSolicitud,
            string str_pDescripcion,
            string str_pEstado,
            int? int_pNumPagina,
            int? int_pTamPagina)
        {
            Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.CancionSolicitud> obj_Lista = new Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.CancionSolicitud>();
            obj_Lista.PageNumber = int_pNumPagina;
            obj_Lista.Total = 0;


            Kruma.Core.Data.Entity.DataOperation dop_Operacion = new Kruma.Core.Data.Entity.DataOperation("ListarCancionSolicitud");
            dop_Operacion.Parameters.Add(new Kruma.Core.Data.Entity.Parameter("@pIdCancionSolicitud", int_pIdCancionSolicitud.HasValue ? int_pIdCancionSolicitud.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Kruma.Core.Data.Entity.Parameter("@pDescripcion", !string.IsNullOrEmpty(str_pDescripcion) ? str_pDescripcion : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Kruma.Core.Data.Entity.Parameter("@pEstado", !string.IsNullOrEmpty(str_pEstado) ? str_pEstado : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Kruma.Core.Data.Entity.Parameter("@pNumPagina", int_pNumPagina.HasValue ? int_pNumPagina.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Kruma.Core.Data.Entity.Parameter("@pTamPagina", int_pTamPagina.HasValue ? int_pTamPagina.Value : (object)DBNull.Value));

            DataTable dt_Resultado = Kruma.Core.Data.DataManager.ExecuteDataSet(Conexiones.CO_KantaPe, dop_Operacion).Tables[0];

            List<Kruma.KantaPe.Entidad.CancionSolicitud> lst_CancionSolicitud = new List<Kruma.KantaPe.Entidad.CancionSolicitud>();
            Kruma.KantaPe.Entidad.CancionSolicitud obj_CancionSolicitud = new Kruma.KantaPe.Entidad.CancionSolicitud();
            foreach (DataRow obj_Row in dt_Resultado.Rows)
            {
                if (lst_CancionSolicitud.Count == 0)
                    obj_Lista.Total = (int)obj_Row["Total_Filas"];
                obj_CancionSolicitud = new Kruma.KantaPe.Entidad.CancionSolicitud();
                obj_CancionSolicitud.IdCancionSolicitud = obj_Row["IdCancionSolicitud"] is DBNull ? null : (int?)obj_Row["IdCancionSolicitud"];
                obj_CancionSolicitud.Descripcion = obj_Row["Descripcion"] is DBNull ? null : obj_Row["Descripcion"].ToString();
                obj_CancionSolicitud.Estado = obj_Row["Estado"] is DBNull ? null : obj_Row["Estado"].ToString();
                obj_CancionSolicitud.UsuarioCreacion = obj_Row["UsuarioCreacion"] is DBNull ? null : obj_Row["UsuarioCreacion"].ToString();
                obj_CancionSolicitud.FechaCreacion = obj_Row["FechaCreacion"] is DBNull ? null : (DateTime?)obj_Row["FechaCreacion"];
                obj_CancionSolicitud.UsuarioModificacion = obj_Row["UsuarioModificacion"] is DBNull ? null : obj_Row["UsuarioModificacion"].ToString();
                obj_CancionSolicitud.FechaModificacion = obj_Row["FechaModificacion"] is DBNull ? null : (DateTime?)obj_Row["FechaModificacion"];
                lst_CancionSolicitud.Add(obj_CancionSolicitud);
            }

            obj_Lista.Result = lst_CancionSolicitud;
            return obj_Lista;
        }


        /// <summary>Obtener solicitud de canción</summary>
        /// <param name="int_pIdCancionSolicitud">Id de la solicitud de canción</param>
        /// <returns>Objeto CancionSolicitud</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>12-07-2016</FecCrea></item></list></remarks>
        public static Kruma.KantaPe.Entidad.CancionSolicitud Obtener(int int_pIdCancionSolicitud)
        {
            Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.CancionSolicitud> lst_CancionSolicitud = Listar(int_pIdCancionSolicitud, null, null, null, null);
            return lst_CancionSolicitud.Result.Count > 0 ? lst_CancionSolicitud.Result[0] : null;
        }

        #endregion

    }
}
