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
    /// <summary>Tipo de producto</summary>
    /// <remarks><list type="bullet">
    /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
    /// <item><FecCrea>18-08-2016</FecCrea></item></list></remarks>

    public class ProductoTipo
    {
        #region Metodos Públicos

        /// <summary>Listado de tipo de producto</summary>
        /// <param name="int_pIdProductoTipo">Id de tipo de producto</param>
        /// <param name="str_pDescripcion">Descripcion</param>
        /// <param name="str_pEstado">Estado</param>
        /// <param name="int_pNumPagina" >Numero de pagina</param>
        /// <param name="int_pTamPagina" >Tamaño de pagina</param>
        /// <returns>Lista de tipo de producto</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>18-08-2016</FecCrea></item></list></remarks>
        public static Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.ProductoTipo> Listar(
            int? int_pIdProductoTipo,
            string str_pDescripcion,
            string str_pEstado,
            int? int_pNumPagina,
            int? int_pTamPagina)
        {
            Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.ProductoTipo> obj_Lista = 
                new Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.ProductoTipo>();
            obj_Lista.PageNumber = int_pNumPagina;
            obj_Lista.Total = 0;

            DataOperation dop_Operacion = new DataOperation("ListarProductoTipo");
            dop_Operacion.Parameters.Add(new Parameter("@pIdProductoTipo", int_pIdProductoTipo.HasValue ? int_pIdProductoTipo.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pDescripcion", !string.IsNullOrEmpty(str_pDescripcion) ? str_pDescripcion : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pEstado", !string.IsNullOrEmpty(str_pEstado) ? str_pEstado : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pNumPagina", int_pNumPagina.HasValue ? int_pNumPagina.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pTamPagina", int_pTamPagina.HasValue ? int_pTamPagina.Value : (object)DBNull.Value));

            DataTable dt_Resultado = DataManager.ExecuteDataSet(Conexiones.CO_KantaPe, dop_Operacion).Tables[0];

            List<Kruma.KantaPe.Entidad.ProductoTipo> lst_ProductoTipo = new List<Kruma.KantaPe.Entidad.ProductoTipo>();
            Kruma.KantaPe.Entidad.ProductoTipo obj_ProductoTipo = new Kruma.KantaPe.Entidad.ProductoTipo();
            foreach (DataRow obj_Row in dt_Resultado.Rows)
            {
                if (lst_ProductoTipo.Count == 0)
                    obj_Lista.Total = (int)obj_Row["Total_Filas"];
                obj_ProductoTipo = new Kruma.KantaPe.Entidad.ProductoTipo();
                obj_ProductoTipo.IdProductoTipo = obj_Row["IdProductoTipo"] is DBNull ? null : (int?)obj_Row["IdProductoTipo"];
                obj_ProductoTipo.Descripcion = obj_Row["Descripcion"] is DBNull ? null : obj_Row["Descripcion"].ToString();
                obj_ProductoTipo.Estado = obj_Row["Estado"] is DBNull ? null : obj_Row["Estado"].ToString();
                obj_ProductoTipo.UsuarioCreacion = obj_Row["UsuarioCreacion"] is DBNull ? null : obj_Row["UsuarioCreacion"].ToString();
                obj_ProductoTipo.FechaCreacion = obj_Row["FechaCreacion"] is DBNull ? null : (DateTime?)obj_Row["FechaCreacion"];
                obj_ProductoTipo.UsuarioModificacion = obj_Row["UsuarioModificacion"] is DBNull ? null : obj_Row["UsuarioModificacion"].ToString();
                obj_ProductoTipo.FechaModificacion = obj_Row["FechaModificacion"] is DBNull ? null : (DateTime?)obj_Row["FechaModificacion"];
                lst_ProductoTipo.Add(obj_ProductoTipo);
            }

            obj_Lista.Result = lst_ProductoTipo;
            return obj_Lista;
        }

        /// <summary>Obtener tipo de producto</summary>
        /// <param name="int_pIdProductoTipo">Id del tipo de producto</param>
        /// <returns>Objeto Tipo de producto</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>18-08-2016</FecCrea></item></list></remarks>
        public static Kruma.KantaPe.Entidad.ProductoTipo Obtener(int int_pIdProductoTipo)
        {
            Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.ProductoTipo> lst_ProductoTipo = Listar(int_pIdProductoTipo, null, null, null, null);
            return lst_ProductoTipo.Result.Count > 0 ? lst_ProductoTipo.Result[0] : null;
        }

        /// <summary>Insertar tipo de producto</summary>
        /// <param name="obj_pProductoTipo">Tipo de producto</param>
        /// <returns>Id de tipo de producto</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>18-08-2016</FecCrea></item></list></remarks>
        public static int Insertar(Kruma.KantaPe.Entidad.ProductoTipo obj_pProductoTipo)
        {
            DataOperation dop_Operacion = new DataOperation("InsertarProductoTipo");

            dop_Operacion.Parameters.Add(new Parameter("@pDescripcion", obj_pProductoTipo.Descripcion));
            dop_Operacion.Parameters.Add(new Parameter("@pEstado", obj_pProductoTipo.Estado));
            dop_Operacion.Parameters.Add(new Parameter("@pUsuarioCreacion", obj_pProductoTipo.UsuarioCreacion));

            Parameter obj_IdProductoTipo = new Parameter("@pIdProductoTipo", DbType.Int32);
            obj_IdProductoTipo.Direction = ParameterDirection.Output;
            dop_Operacion.Parameters.Add(obj_IdProductoTipo);

            DataManager.ExecuteNonQuery(Conexiones.CO_KantaPe, dop_Operacion, false);
            int int_IdProductoTipo = (int)obj_IdProductoTipo.Value;
            return int_IdProductoTipo;
        }

        /// <summary>Modificar tipo de producto</summary>
        /// <param name="obj_pProductoTipo">Tipo de producto</param>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>18-08-2016</FecCrea></item></list></remarks>
        public static void Modificar(Kruma.KantaPe.Entidad.ProductoTipo obj_pProductoTipo)
        {
            DataOperation dop_Operacion = new DataOperation("ActualizarProductoTipo");

            dop_Operacion.Parameters.Add(new Parameter("@pIdProductoTipo", obj_pProductoTipo.IdProductoTipo));
            dop_Operacion.Parameters.Add(new Parameter("@pDescripcion", obj_pProductoTipo.Descripcion));
            dop_Operacion.Parameters.Add(new Parameter("@pEstado", obj_pProductoTipo.Estado));
            dop_Operacion.Parameters.Add(new Parameter("@pUsuarioModificacion", obj_pProductoTipo.UsuarioModificacion));

            DataManager.ExecuteNonQuery(Conexiones.CO_KantaPe, dop_Operacion, false);
        }

        #endregion
    }
}