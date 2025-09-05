using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Kruma.KantaPe.Data
{
    /// <summary>AperturaCancionSolicitud</summary>
    /// <remarks><list type="bullet">
    /// <item><CreadoPor>Creado por Carlos Gómez</CreadoPor></item>
    /// <item><FecCrea>29-10-2016</FecCrea></item></list></remarks>

    public class AperturaCancionSolicitud
    {

        #region Metodos Públicos

        /// <summary>Listado de Genero</summary>
        /// <param name="int_pIdAperturaCancionSolicitud">Id de AperturaCancionSolicitud</param>
        /// <param name="str_pDescripcion">Descripción de AperturaCancionSolicitud</param>
        /// <param name="str_pEstado">Estado de AperturaCancionSolicitud</param>
        /// <param name="int_pNumPagina" >Numero de pagina</param>
        /// <param name="int_pTamPagina" >Tamaño de pagina</param>
        /// <returns>Lista de AperturaCancionSolicitud</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por Carlos Gómez</CreadoPor></item>
        /// <item><FecCrea>29-10-2016</FecCrea></item></list></remarks>
        public static Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.AperturaCancionSolicitud> Listar(
            int? int_pIdAperturaCancionSolicitud,
            string str_pDescripcion,
            string str_pEstado,
            int? int_pNumPagina,
            int? int_pTamPagina)
        {

            Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.AperturaCancionSolicitud> obj_Lista = new Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.AperturaCancionSolicitud>();
            obj_Lista.PageNumber = int_pNumPagina;
            obj_Lista.Total = 0;

            Kruma.Core.Data.Entity.DataOperation dop_Operacion = new Kruma.Core.Data.Entity.DataOperation("ListarAperturaCancionSolicitud");

            dop_Operacion.Parameters.Add(new Kruma.Core.Data.Entity.Parameter("@pIdAperturaCancionSolicitud", int_pIdAperturaCancionSolicitud.HasValue ? int_pIdAperturaCancionSolicitud.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Kruma.Core.Data.Entity.Parameter("@pDescripcion", !string.IsNullOrEmpty(str_pDescripcion) ? str_pDescripcion : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Kruma.Core.Data.Entity.Parameter("@pEstado", !string.IsNullOrEmpty(str_pEstado) ? str_pEstado : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Kruma.Core.Data.Entity.Parameter("@pNumPagina", int_pNumPagina.HasValue ? int_pNumPagina.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Kruma.Core.Data.Entity.Parameter("@pTamPagina", int_pTamPagina.HasValue ? int_pTamPagina.Value : (object)DBNull.Value));

            DataTable dt_Resultado = Kruma.Core.Data.DataManager.ExecuteDataSet(Conexiones.CO_KantaPe, dop_Operacion).Tables[0];

            List<Kruma.KantaPe.Entidad.AperturaCancionSolicitud> lst_AperturaCancionSolicitud = new List<Kruma.KantaPe.Entidad.AperturaCancionSolicitud>();

            Kruma.KantaPe.Entidad.AperturaCancionSolicitud obj_AperturaCancionSolicitud = new Kruma.KantaPe.Entidad.AperturaCancionSolicitud();

            foreach (DataRow obj_Row in dt_Resultado.Rows)
            {
                if (lst_AperturaCancionSolicitud.Count == 0)
                    obj_Lista.Total = (int)obj_Row["Total_Filas"];

                obj_AperturaCancionSolicitud = new Kruma.KantaPe.Entidad.AperturaCancionSolicitud();

                obj_AperturaCancionSolicitud.IdAperturaCancionSolicitud = obj_Row["IdAperturaCancionSolicitud"] is DBNull ? null : (int?)obj_Row["IdAperturaCancionSolicitud"];
                obj_AperturaCancionSolicitud.Descripcion = obj_Row["Descripcion"] is DBNull ? null : obj_Row["Descripcion"].ToString();
                obj_AperturaCancionSolicitud.Estado = obj_Row["Estado"] is DBNull ? null : obj_Row["Estado"].ToString();
                obj_AperturaCancionSolicitud.UsuarioCreacion = obj_Row["UsuarioCreacion"] is DBNull ? null : obj_Row["UsuarioCreacion"].ToString();
                obj_AperturaCancionSolicitud.FechaCreacion = obj_Row["FechaCreacion"] is DBNull ? null : (DateTime?)obj_Row["FechaCreacion"];
                obj_AperturaCancionSolicitud.UsuarioModificacion = obj_Row["UsuarioModificacion"] is DBNull ? null : obj_Row["UsuarioModificacion"].ToString();
                obj_AperturaCancionSolicitud.FechaModificacion = obj_Row["FechaModificacion"] is DBNull ? null : (DateTime?)obj_Row["FechaModificacion"];

                lst_AperturaCancionSolicitud.Add(obj_AperturaCancionSolicitud);
            }

            obj_Lista.Result = lst_AperturaCancionSolicitud;

            return obj_Lista;
        }

        #endregion
    }
}
