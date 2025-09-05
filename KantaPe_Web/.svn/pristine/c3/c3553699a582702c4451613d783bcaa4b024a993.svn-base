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
    /// <summary>Insumo</summary>
    /// <remarks><list type="bullet">
    /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
    /// <item><FecCrea>12-07-2016</FecCrea></item></list></remarks>

    public class Insumo
    {
        #region Metodos Públicos

        /// <summary>Listado de Insumo</summary>
        /// <param name="int_pIdInsumo">IdInsumo</param>
        /// <param name="str_pCodigo">Codigo</param>
        /// <param name="str_pDescripcion">Descripcion</param>
        /// <param name="int_pIdUnidadMedida">IdUnidadMedida</param>
        /// <param name="str_pEstado">Estado</param>
        /// <param name="int_pNumPagina" >Numero de pagina</param>
        /// <param name="int_pTamPagina" >Tamaño de pagina</param>
        /// <returns>Lista de Insumo</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>12-07-2016</FecCrea></item></list></remarks>
        public static Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Insumo> Listar(
            int? int_pIdInsumo,
            string str_pCodigo,
            string str_pDescripcion,
            int? int_pIdUnidadMedida,
            string str_pEstado,
            int? int_pNumPagina,
            int? int_pTamPagina)
        {
            Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Insumo> obj_Lista = new Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Insumo>();
            obj_Lista.PageNumber = int_pNumPagina;
            obj_Lista.Total = 0;

            DataOperation dop_Operacion = new DataOperation("ListarInsumo");
            dop_Operacion.Parameters.Add(new Parameter("@pIdInsumo", int_pIdInsumo.HasValue ? int_pIdInsumo.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pCodigo", !string.IsNullOrEmpty(str_pCodigo) ? str_pCodigo : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pDescripcion", !string.IsNullOrEmpty(str_pDescripcion) ? str_pDescripcion : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pIdUnidadMedida", int_pIdUnidadMedida.HasValue ? int_pIdUnidadMedida.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pEstado", !string.IsNullOrEmpty(str_pEstado) ? str_pEstado : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pNumPagina", int_pNumPagina.HasValue ? int_pNumPagina.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pTamPagina", int_pTamPagina.HasValue ? int_pTamPagina.Value : (object)DBNull.Value));

            DataTable dt_Resultado = DataManager.ExecuteDataSet(Conexiones.CO_KantaPe, dop_Operacion).Tables[0];

            List<Kruma.KantaPe.Entidad.Insumo> lst_Insumo = new List<Kruma.KantaPe.Entidad.Insumo>();
            Kruma.KantaPe.Entidad.Insumo obj_Insumo = new Kruma.KantaPe.Entidad.Insumo();
            foreach (DataRow obj_Row in dt_Resultado.Rows)
            {
                if (lst_Insumo.Count == 0)
                    obj_Lista.Total = (int)obj_Row["Total_Filas"];
                obj_Insumo = new Kruma.KantaPe.Entidad.Insumo();
                obj_Insumo.IdInsumo = obj_Row["IdInsumo"] is DBNull ? null : (int?)obj_Row["IdInsumo"];
                obj_Insumo.Codigo = obj_Row["Codigo"] is DBNull ? null : obj_Row["Codigo"].ToString();
                obj_Insumo.Descripcion = obj_Row["Descripcion"] is DBNull ? null : obj_Row["Descripcion"].ToString();
                obj_Insumo.IdUnidadMedida = obj_Row["IdUnidadMedida"] is DBNull ? null : (int?)obj_Row["IdUnidadMedida"];
                obj_Insumo.Estado = obj_Row["Estado"] is DBNull ? null : obj_Row["Estado"].ToString();
                obj_Insumo.UsuarioCreacion = obj_Row["UsuarioCreacion"] is DBNull ? null : obj_Row["UsuarioCreacion"].ToString();
                obj_Insumo.FechaCreacion = obj_Row["FechaCreacion"] is DBNull ? null : (DateTime?)obj_Row["FechaCreacion"];
                obj_Insumo.UsuarioModificacion = obj_Row["UsuarioModificacion"] is DBNull ? null : obj_Row["UsuarioModificacion"].ToString();
                obj_Insumo.FechaModificacion = obj_Row["FechaModificacion"] is DBNull ? null : (DateTime?)obj_Row["FechaModificacion"];

                obj_Insumo.UnidadMedida = new Entidad.UnidadMedida();
                obj_Insumo.UnidadMedida.IdUnidadMedida = obj_Row["UnidadMedida_IdUnidadMedida"] is DBNull ? null : (int?)obj_Row["UnidadMedida_IdUnidadMedida"];
                obj_Insumo.UnidadMedida.Descripcion = obj_Row["UnidadMedida_Descripcion"] is DBNull ? null : obj_Row["UnidadMedida_Descripcion"].ToString();

                lst_Insumo.Add(obj_Insumo);
            }

            obj_Lista.Result = lst_Insumo;
            return obj_Lista;
        }

        /// <summary>Obtener Insumo</summary>
        /// <param name="int_pIdInsumo">IdInsumo</param>
        /// <returns>Objeto Insumo</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>12-07-2016</FecCrea></item></list></remarks>
        public static Kruma.KantaPe.Entidad.Insumo Obtener(int int_pIdInsumo)
        {
            Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Insumo> lst_Insumo = Listar(int_pIdInsumo, null, null, null, null, null, null);
            return lst_Insumo.Result.Count > 0 ? lst_Insumo.Result[0] : null;
        }

        /// <summary>Insertar Insumo</summary>
        /// <param name="obj_pInsumo">Insumo</param>
        /// <returns>Id de Insumo</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>12-07-2016</FecCrea></item></list></remarks>
        public static int Insertar(Kruma.KantaPe.Entidad.Insumo obj_pInsumo)
        {
            DataOperation dop_Operacion = new DataOperation("InsertarInsumo");

            dop_Operacion.Parameters.Add(new Parameter("@pCodigo", obj_pInsumo.Codigo));
            dop_Operacion.Parameters.Add(new Parameter("@pDescripcion", obj_pInsumo.Descripcion));
            dop_Operacion.Parameters.Add(new Parameter("@pIdUnidadMedida", obj_pInsumo.IdUnidadMedida));
            dop_Operacion.Parameters.Add(new Parameter("@pEstado", obj_pInsumo.Estado));
            dop_Operacion.Parameters.Add(new Parameter("@pUsuarioCreacion", obj_pInsumo.UsuarioCreacion));

            Parameter obj_IdInsumo = new Parameter("@pIdInsumo", DbType.Int32);
            obj_IdInsumo.Direction = ParameterDirection.Output;
            dop_Operacion.Parameters.Add(obj_IdInsumo);

            DataManager.ExecuteNonQuery(Conexiones.CO_KantaPe, dop_Operacion, false);
            int int_IdInsumo = (int)obj_IdInsumo.Value;
            return int_IdInsumo;
        }

        /// <summary>Modificar Insumo</summary>
        /// <param name="obj_pInsumo">Insumo</param>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>12-07-2016</FecCrea></item></list></remarks>
        public static void Modificar(Kruma.KantaPe.Entidad.Insumo obj_pInsumo)
        {
            DataOperation dop_Operacion = new DataOperation("ActualizarInsumo");

            dop_Operacion.Parameters.Add(new Parameter("@pIdInsumo", obj_pInsumo.IdInsumo));
            dop_Operacion.Parameters.Add(new Parameter("@pCodigo", obj_pInsumo.Codigo));
            dop_Operacion.Parameters.Add(new Parameter("@pDescripcion", obj_pInsumo.Descripcion));
            dop_Operacion.Parameters.Add(new Parameter("@pIdUnidadMedida", obj_pInsumo.IdUnidadMedida));
            dop_Operacion.Parameters.Add(new Parameter("@pEstado", obj_pInsumo.Estado));
            dop_Operacion.Parameters.Add(new Parameter("@pUsuarioModificacion", obj_pInsumo.UsuarioModificacion));

            DataManager.ExecuteNonQuery(Conexiones.CO_KantaPe, dop_Operacion, false);
        }

        #endregion
    }
}