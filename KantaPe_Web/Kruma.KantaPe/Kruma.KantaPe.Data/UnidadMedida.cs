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
	/// <summary>UnidadMedida</summary>
	/// <remarks><list type="bullet">
	/// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
	/// <item><FecCrea>12-07-2016</FecCrea></item></list></remarks>

    public class UnidadMedida
    {
        #region Metodos Públicos

        /// <summary>Listado de UnidadMedida</summary>
        /// <param name="int_pIdUnidadMedida">IdUnidadMedida</param>
        /// <param name="str_pDescripcion">Descripcion</param>
        /// <param name="str_pEstado">Estado</param>
        /// <param name="int_pNumPagina" >Numero de pagina</param>
        /// <param name="int_pTamPagina" >Tamaño de pagina</param>
        /// <returns>Lista de UnidadMedida</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>12-07-2016</FecCrea></item></list></remarks>
        public static Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.UnidadMedida> Listar(
            int? int_pIdUnidadMedida, 
            string str_pDescripcion, 
            string str_pEstado, 
            int? int_pNumPagina, 
            int? int_pTamPagina)
        {
            Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.UnidadMedida> obj_Lista = new Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.UnidadMedida>();
            obj_Lista.PageNumber = int_pNumPagina;
            obj_Lista.Total = 0;

            DataOperation dop_Operacion = new DataOperation("ListarUnidadMedida");
            dop_Operacion.Parameters.Add(new Parameter("@pIdUnidadMedida", int_pIdUnidadMedida.HasValue ? int_pIdUnidadMedida.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pDescripcion", !string.IsNullOrEmpty(str_pDescripcion) ? str_pDescripcion : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pEstado", !string.IsNullOrEmpty(str_pEstado) ? str_pEstado : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pNumPagina", int_pNumPagina.HasValue ? int_pNumPagina.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pTamPagina", int_pTamPagina.HasValue ? int_pTamPagina.Value : (object)DBNull.Value));

            DataTable dt_Resultado = DataManager.ExecuteDataSet(Conexiones.CO_KantaPe, dop_Operacion).Tables[0];

            List<Kruma.KantaPe.Entidad.UnidadMedida> lst_UnidadMedida = new List<Kruma.KantaPe.Entidad.UnidadMedida>();
            Kruma.KantaPe.Entidad.UnidadMedida obj_UnidadMedida = new Kruma.KantaPe.Entidad.UnidadMedida();
            foreach (DataRow obj_Row in dt_Resultado.Rows)
            {
                if (lst_UnidadMedida.Count == 0)
                    obj_Lista.Total = (int)obj_Row["Total_Filas"];
                obj_UnidadMedida = new Kruma.KantaPe.Entidad.UnidadMedida();
                obj_UnidadMedida.IdUnidadMedida = obj_Row["IdUnidadMedida"] is DBNull ? null : (int?)obj_Row["IdUnidadMedida"];
                obj_UnidadMedida.Descripcion = obj_Row["Descripcion"] is DBNull ? null : obj_Row["Descripcion"].ToString();
                obj_UnidadMedida.Estado = obj_Row["Estado"] is DBNull ? null : obj_Row["Estado"].ToString();
                obj_UnidadMedida.UsuarioCreacion = obj_Row["UsuarioCreacion"] is DBNull ? null : obj_Row["UsuarioCreacion"].ToString();
                obj_UnidadMedida.FechaCreacion = obj_Row["FechaCreacion"] is DBNull ? null : (DateTime?)obj_Row["FechaCreacion"];
                obj_UnidadMedida.UsuarioModificacion = obj_Row["UsuarioModificacion"] is DBNull ? null : obj_Row["UsuarioModificacion"].ToString();
                obj_UnidadMedida.FechaModificacion = obj_Row["FechaModificacion"] is DBNull ? null : (DateTime?)obj_Row["FechaModificacion"];
                lst_UnidadMedida.Add(obj_UnidadMedida);
            }

            obj_Lista.Result = lst_UnidadMedida;
            return obj_Lista;
        }

        /// <summary>Obtener UnidadMedida</summary>
        /// <param name="int_pIdUnidadMedida">IdUnidadMedida</param>
        /// <returns>Objeto UnidadMedida</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>12-07-2016</FecCrea></item></list></remarks>
        public static Kruma.KantaPe.Entidad.UnidadMedida Obtener(int int_pIdUnidadMedida)
        {
            Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.UnidadMedida> lst_UnidadMedida = Listar(int_pIdUnidadMedida, null, null, null, null);
            return lst_UnidadMedida.Result.Count > 0 ? lst_UnidadMedida.Result[0] : null;
        }

        /// <summary>Insertar UnidadMedida</summary>
        /// <param name="obj_pUnidadMedida">UnidadMedida</param>
        /// <returns>Id de UnidadMedida</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>12-07-2016</FecCrea></item></list></remarks>
        public static int Insertar(Kruma.KantaPe.Entidad.UnidadMedida obj_pUnidadMedida)
        {
            DataOperation dop_Operacion = new DataOperation("InsertarUnidadMedida");

            dop_Operacion.Parameters.Add(new Parameter("@pDescripcion", obj_pUnidadMedida.Descripcion));
            dop_Operacion.Parameters.Add(new Parameter("@pEstado", obj_pUnidadMedida.Estado));
            dop_Operacion.Parameters.Add(new Parameter("@pUsuarioCreacion", obj_pUnidadMedida.UsuarioCreacion));

            Parameter obj_IdUnidadMedida = new Parameter("@pIdUnidadMedida", DbType.Int32);
            obj_IdUnidadMedida.Direction = ParameterDirection.Output;
            dop_Operacion.Parameters.Add(obj_IdUnidadMedida);

            DataManager.ExecuteNonQuery(Conexiones.CO_KantaPe, dop_Operacion, false);
            int int_IdUnidadMedida = (int)obj_IdUnidadMedida.Value;
            return int_IdUnidadMedida;
        }

        /// <summary>Modificar UnidadMedida</summary>
        /// <param name="obj_pUnidadMedida">UnidadMedida</param>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>12-07-2016</FecCrea></item></list></remarks>
        public static void Modificar(Kruma.KantaPe.Entidad.UnidadMedida obj_pUnidadMedida)
        {
            DataOperation dop_Operacion = new DataOperation("ActualizarUnidadMedida");

            dop_Operacion.Parameters.Add(new Parameter("@pIdUnidadMedida", obj_pUnidadMedida.IdUnidadMedida));
            dop_Operacion.Parameters.Add(new Parameter("@pDescripcion", obj_pUnidadMedida.Descripcion));
            dop_Operacion.Parameters.Add(new Parameter("@pEstado", obj_pUnidadMedida.Estado));
            dop_Operacion.Parameters.Add(new Parameter("@pUsuarioModificacion", obj_pUnidadMedida.UsuarioModificacion));

            DataManager.ExecuteNonQuery(Conexiones.CO_KantaPe, dop_Operacion, false);
        }

        #endregion
    }
}