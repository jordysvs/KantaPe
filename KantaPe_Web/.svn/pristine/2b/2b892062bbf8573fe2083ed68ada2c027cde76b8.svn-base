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
	/// <summary>AlertaTipo</summary>
	/// <remarks><list type="bullet">
	/// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
	/// <item><FecCrea>25-07-2016</FecCrea></item></list></remarks>

    public class AlertaTipo
    {
        #region Metodos Públicos

        /// <summary>Listado de tipo de alerta</summary>
        /// <param name="int_pIdAlertaTipo">IdAlertaTipo</param>
        /// <param name="str_pDescripcion">Descripcion</param>
        /// <param name="str_pEstado">Estado</param>
        /// <param name="int_pNumPagina" >Numero de pagina</param>
        /// <param name="int_pTamPagina" >Tamaño de pagina</param>
        /// <returns>Lista de AlertaTipo</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>25-07-2016</FecCrea></item></list></remarks>
        public static Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.AlertaTipo> Listar(
            int? int_pIdAlertaTipo, 
            string str_pDescripcion, 
            string str_pEstado, 
            int? int_pNumPagina, 
            int? int_pTamPagina)
        {
            Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.AlertaTipo> obj_Lista = new Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.AlertaTipo>();
            obj_Lista.PageNumber = int_pNumPagina;
            obj_Lista.Total = 0;

            DataOperation dop_Operacion = new DataOperation("ListarAlertaTipo");
            dop_Operacion.Parameters.Add(new Parameter("@pIdAlertaTipo", int_pIdAlertaTipo.HasValue ? int_pIdAlertaTipo.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pDescripcion", !string.IsNullOrEmpty(str_pDescripcion) ? str_pDescripcion : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pEstado", !string.IsNullOrEmpty(str_pEstado) ? str_pEstado : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pNumPagina", int_pNumPagina.HasValue ? int_pNumPagina.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pTamPagina", int_pTamPagina.HasValue ? int_pTamPagina.Value : (object)DBNull.Value));

            DataTable dt_Resultado = DataManager.ExecuteDataSet(Conexiones.CO_KantaPe, dop_Operacion).Tables[0];

            List<Kruma.KantaPe.Entidad.AlertaTipo> lst_AlertaTipo = new List<Kruma.KantaPe.Entidad.AlertaTipo>();
            Kruma.KantaPe.Entidad.AlertaTipo obj_AlertaTipo = new Kruma.KantaPe.Entidad.AlertaTipo();
            foreach (DataRow obj_Row in dt_Resultado.Rows)
            {
                if (lst_AlertaTipo.Count == 0)
                    obj_Lista.Total = (int)obj_Row["Total_Filas"];
                obj_AlertaTipo = new Kruma.KantaPe.Entidad.AlertaTipo();
                obj_AlertaTipo.IdAlertaTipo = obj_Row["IdAlertaTipo"] is DBNull ? null : (int?)obj_Row["IdAlertaTipo"];
                obj_AlertaTipo.Descripcion = obj_Row["Descripcion"] is DBNull ? null : obj_Row["Descripcion"].ToString();
                obj_AlertaTipo.Estado = obj_Row["Estado"] is DBNull ? null : obj_Row["Estado"].ToString();
                obj_AlertaTipo.UsuarioCreacion = obj_Row["UsuarioCreacion"] is DBNull ? null : obj_Row["UsuarioCreacion"].ToString();
                obj_AlertaTipo.FechaCreacion = obj_Row["FechaCreacion"] is DBNull ? null : (DateTime?)obj_Row["FechaCreacion"];
                obj_AlertaTipo.UsuarioModificacion = obj_Row["UsuarioModificacion"] is DBNull ? null : obj_Row["UsuarioModificacion"].ToString();
                obj_AlertaTipo.FechaModificacion = obj_Row["FechaModificacion"] is DBNull ? null : (DateTime?)obj_Row["FechaModificacion"];
                lst_AlertaTipo.Add(obj_AlertaTipo);
            }

            obj_Lista.Result = lst_AlertaTipo;
            return obj_Lista;
        }

        /// <summary>Obtener tipo de alerta</summary>
        /// <param name="int_pIdAlertaTipo">IdAlertaTipo</param>
        /// <returns>Objeto AlertaTipo</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>25-07-2016</FecCrea></item></list></remarks>
        public static Kruma.KantaPe.Entidad.AlertaTipo Obtener(int int_pIdAlertaTipo)
        {
            Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.AlertaTipo> lst_AlertaTipo = Listar(int_pIdAlertaTipo, null, null, null, null);
            return lst_AlertaTipo.Result.Count > 0 ? lst_AlertaTipo.Result[0] : null;
        }

        /// <summary>Insertar tipo de alerta</summary>
        /// <param name="obj_pAlertaTipo">AlertaTipo</param>
        /// <returns>Id de AlertaTipo</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>25-07-2016</FecCrea></item></list></remarks>
        public static int Insertar(Kruma.KantaPe.Entidad.AlertaTipo obj_pAlertaTipo)
        {
            DataOperation dop_Operacion = new DataOperation("InsertarAlertaTipo");

            dop_Operacion.Parameters.Add(new Parameter("@pDescripcion", obj_pAlertaTipo.Descripcion));
            dop_Operacion.Parameters.Add(new Parameter("@pEstado", obj_pAlertaTipo.Estado));
            dop_Operacion.Parameters.Add(new Parameter("@pUsuarioCreacion", obj_pAlertaTipo.UsuarioCreacion));

            Parameter obj_IdAlertaTipo = new Parameter("@pIdAlertaTipo", DbType.Int32);
            obj_IdAlertaTipo.Direction = ParameterDirection.Output;
            dop_Operacion.Parameters.Add(obj_IdAlertaTipo);

            DataManager.ExecuteNonQuery(Conexiones.CO_KantaPe, dop_Operacion, false);
            int int_IdAlertaTipo = (int)obj_IdAlertaTipo.Value;
            return int_IdAlertaTipo;
        }

        /// <summary>Modificar AlertaTipo</summary>
        /// <param name="obj_pAlertaTipo">AlertaTipo</param>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>25-07-2016</FecCrea></item></list></remarks>
        public static void Modificar(Kruma.KantaPe.Entidad.AlertaTipo obj_pAlertaTipo)
        {
            DataOperation dop_Operacion = new DataOperation("ActualizarAlertaTipo");

            dop_Operacion.Parameters.Add(new Parameter("@pIdAlertaTipo", obj_pAlertaTipo.IdAlertaTipo));
            dop_Operacion.Parameters.Add(new Parameter("@pDescripcion", obj_pAlertaTipo.Descripcion));
            dop_Operacion.Parameters.Add(new Parameter("@pEstado", obj_pAlertaTipo.Estado));
            dop_Operacion.Parameters.Add(new Parameter("@pUsuarioModificacion", obj_pAlertaTipo.UsuarioModificacion));

            DataManager.ExecuteNonQuery(Conexiones.CO_KantaPe, dop_Operacion, false);
        }

        #endregion
    }
}