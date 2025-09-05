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
	/// <summary>Insumo del producto</summary>
	/// <remarks><list type="bullet">
	/// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
	/// <item><FecCrea>12-07-2016</FecCrea></item></list></remarks>

    public class ProductoInsumo
    {
        #region Metodos Públicos

        /// <summary>Listado de ProductoInsumo</summary>
        /// <param name="int_pIdLocal">IdLocal</param>
        /// <param name="int_pIdProducto">IdProducto</param>
        /// <param name="int_pIdInsumo">IdInsumo</param>
        /// <param name="int_pCantidad">Cantidad</param>
        /// <param name="str_pEstado">Estado</param>
        /// <param name="int_pNumPagina" >Numero de pagina</param>
        /// <param name="int_pTamPagina" >Tamaño de pagina</param>
        /// <returns>Lista de ProductoInsumo</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>12-07-2016</FecCrea></item></list></remarks>
        public static Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.ProductoInsumo> Listar(
            int? int_pIdLocal, 
            int? int_pIdProducto, 
            int? int_pIdInsumo, 
            string str_pEstado, 
            int? int_pNumPagina, 
            int? int_pTamPagina)
        {
            Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.ProductoInsumo> obj_Lista = new Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.ProductoInsumo>();
            obj_Lista.PageNumber = int_pNumPagina;
            obj_Lista.Total = 0;

            DataOperation dop_Operacion = new DataOperation("ListarProductoInsumo");
            dop_Operacion.Parameters.Add(new Parameter("@pIdLocal", int_pIdLocal.HasValue ? int_pIdLocal.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pIdProducto", int_pIdProducto.HasValue ? int_pIdProducto.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pIdInsumo", int_pIdInsumo.HasValue ? int_pIdInsumo.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pEstado", !string.IsNullOrEmpty(str_pEstado) ? str_pEstado : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pNumPagina", int_pNumPagina.HasValue ? int_pNumPagina.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pTamPagina", int_pTamPagina.HasValue ? int_pTamPagina.Value : (object)DBNull.Value));

            DataTable dt_Resultado = DataManager.ExecuteDataSet(Conexiones.CO_KantaPe, dop_Operacion).Tables[0];

            List<Kruma.KantaPe.Entidad.ProductoInsumo> lst_ProductoInsumo = new List<Kruma.KantaPe.Entidad.ProductoInsumo>();
            Kruma.KantaPe.Entidad.ProductoInsumo obj_ProductoInsumo = new Kruma.KantaPe.Entidad.ProductoInsumo();
            foreach (DataRow obj_Row in dt_Resultado.Rows)
            {
                if (lst_ProductoInsumo.Count == 0)
                    obj_Lista.Total = (int)obj_Row["Total_Filas"];
                
                obj_ProductoInsumo = new Kruma.KantaPe.Entidad.ProductoInsumo();
                obj_ProductoInsumo.IdLocal = obj_Row["IdLocal"] is DBNull ? null : (int?)obj_Row["IdLocal"];
                obj_ProductoInsumo.IdProducto = obj_Row["IdProducto"] is DBNull ? null : (int?)obj_Row["IdProducto"];
                obj_ProductoInsumo.IdInsumo = obj_Row["IdInsumo"] is DBNull ? null : (int?)obj_Row["IdInsumo"];
                obj_ProductoInsumo.Cantidad = obj_Row["Cantidad"] is DBNull ? null : (int?)obj_Row["Cantidad"];
                obj_ProductoInsumo.Estado = obj_Row["Estado"] is DBNull ? null : obj_Row["Estado"].ToString();
                obj_ProductoInsumo.UsuarioCreacion = obj_Row["UsuarioCreacion"] is DBNull ? null : obj_Row["UsuarioCreacion"].ToString();
                obj_ProductoInsumo.FechaCreacion = obj_Row["FechaCreacion"] is DBNull ? null : (DateTime?)obj_Row["FechaCreacion"];
                obj_ProductoInsumo.UsuarioModificacion = obj_Row["UsuarioModificacion"] is DBNull ? null : obj_Row["UsuarioModificacion"].ToString();
                obj_ProductoInsumo.FechaModificacion = obj_Row["FechaModificacion"] is DBNull ? null : (DateTime?)obj_Row["FechaModificacion"];
                
                obj_ProductoInsumo.Insumo = new Entidad.Insumo();
                obj_ProductoInsumo.Insumo.IdInsumo = obj_Row["Insumo_IdInsumo"] is DBNull ? null : (int?)obj_Row["Insumo_IdInsumo"];
                obj_ProductoInsumo.Insumo.Codigo = obj_Row["Insumo_Codigo"] is DBNull ? null : obj_Row["Insumo_Codigo"].ToString();
                obj_ProductoInsumo.Insumo.Descripcion = obj_Row["Insumo_Descripcion"] is DBNull ? null : obj_Row["Insumo_Descripcion"].ToString();
                obj_ProductoInsumo.Insumo.IdUnidadMedida = obj_Row["Insumo_IdUnidadMedida"] is DBNull ? null : (int?)obj_Row["Insumo_IdUnidadMedida"];

                obj_ProductoInsumo.Insumo.UnidadMedida = new Entidad.UnidadMedida();
                obj_ProductoInsumo.Insumo.UnidadMedida.Descripcion = obj_Row["UnidadMedida_Descripcion"] is DBNull ? null : obj_Row["UnidadMedida_Descripcion"].ToString();
               
                lst_ProductoInsumo.Add(obj_ProductoInsumo);
            }

            obj_Lista.Result = lst_ProductoInsumo;
            return obj_Lista;
        }

        /// <summary>Obtener insumo del producto</summary>
        /// <param name="int_pIdLocal">IdLocal</param>
        /// <param name="int_pIdProducto">IdProducto</param>
        /// <param name="int_pIdInsumo">IdInsumo</param>
        /// <returns>Objeto Insumo del producto</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>12-07-2016</FecCrea></item></list></remarks>
        public static Kruma.KantaPe.Entidad.ProductoInsumo Obtener(
            int int_pIdLocal, 
            int int_pIdProducto, 
            int int_pIdInsumo)
        {
            Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.ProductoInsumo> lst_ProductoInsumo = Listar(int_pIdLocal, int_pIdProducto, int_pIdInsumo, null, null, null);
            return lst_ProductoInsumo.Result.Count > 0 ? lst_ProductoInsumo.Result[0] : null;
        }

        /// <summary>Insertar insumo del producto</summary>
        /// <param name="obj_pProductoInsumo">Insumo del producto</param>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>12-07-2016</FecCrea></item></list></remarks>
        public static void Insertar(Kruma.KantaPe.Entidad.ProductoInsumo obj_pProductoInsumo)
        {
            DataOperation dop_Operacion = new DataOperation("InsertarProductoInsumo");

            dop_Operacion.Parameters.Add(new Parameter("@pIdLocal", obj_pProductoInsumo.IdLocal));
            dop_Operacion.Parameters.Add(new Parameter("@pIdProducto", obj_pProductoInsumo.IdProducto));
            dop_Operacion.Parameters.Add(new Parameter("@pIdInsumo", obj_pProductoInsumo.IdInsumo));
            dop_Operacion.Parameters.Add(new Parameter("@pCantidad", obj_pProductoInsumo.Cantidad));
            dop_Operacion.Parameters.Add(new Parameter("@pEstado", obj_pProductoInsumo.Estado));
            dop_Operacion.Parameters.Add(new Parameter("@pUsuarioCreacion", obj_pProductoInsumo.UsuarioCreacion));
            
            DataManager.ExecuteNonQuery(Conexiones.CO_KantaPe, dop_Operacion, false);
        }

        /// <summary>Modificar insumo del producto</summary>
        /// <param name="obj_pProductoInsumo">Insumo del producto</param>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>12-07-2016</FecCrea></item></list></remarks>
        public static void Modificar(Kruma.KantaPe.Entidad.ProductoInsumo obj_pProductoInsumo)
        {
            DataOperation dop_Operacion = new DataOperation("ActualizarProductoInsumo");

            dop_Operacion.Parameters.Add(new Parameter("@pIdLocal", obj_pProductoInsumo.IdLocal));
            dop_Operacion.Parameters.Add(new Parameter("@pIdProducto", obj_pProductoInsumo.IdProducto));
            dop_Operacion.Parameters.Add(new Parameter("@pIdInsumo", obj_pProductoInsumo.IdInsumo));
            dop_Operacion.Parameters.Add(new Parameter("@pCantidad", obj_pProductoInsumo.Cantidad));
            dop_Operacion.Parameters.Add(new Parameter("@pEstado", obj_pProductoInsumo.Estado));
            dop_Operacion.Parameters.Add(new Parameter("@pUsuarioModificacion", obj_pProductoInsumo.UsuarioModificacion));

            DataManager.ExecuteNonQuery(Conexiones.CO_KantaPe, dop_Operacion, false);
        }

        #endregion
    }
}