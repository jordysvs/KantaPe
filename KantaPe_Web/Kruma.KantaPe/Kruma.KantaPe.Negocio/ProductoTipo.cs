using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Kruma.Core.Util.Common;

namespace Kruma.KantaPe.Negocio
{
	/// <summary>tipo de producto</summary>
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
            return Kruma.KantaPe.Data.ProductoTipo.Listar(
                int_pIdProductoTipo, 
                str_pDescripcion, 
                str_pEstado, 
                int_pNumPagina, 
                int_pTamPagina);
        }

        /// <summary>Obtener tipo de producto</summary>
        /// <param name="int_pIdProductoTipo">Id del tipo de producto</param>
        /// <returns>Objeto tipo de producto</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>18-08-2016</FecCrea></item></list></remarks>
        public static Kruma.KantaPe.Entidad.ProductoTipo Obtener(int int_pIdProductoTipo)
        {
            return Kruma.KantaPe.Data.ProductoTipo.Obtener(int_pIdProductoTipo);
        }

        /// <summary>Insertar tipo de producto</summary>
        /// <param name="obj_pProductoTipo">Tipo de producto</param>
        /// <returns>Id de tipo de producto</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>18-08-2016</FecCrea></item></list></remarks>
        public static ProcessResult Insertar(Kruma.KantaPe.Entidad.ProductoTipo obj_pProductoTipo)
        {
            ProcessResult obj_Resultado = null;
            try
            {
                int int_IdProductoTipo = Kruma.KantaPe.Data.ProductoTipo.Insertar(obj_pProductoTipo);
                obj_Resultado = new ProcessResult(int_IdProductoTipo);
            }
            catch (Exception obj_pExcepcion)
            {
                obj_Resultado = new ProcessResult(obj_pExcepcion);
            }
            return obj_Resultado;
        }

        /// <summary>Modificar tipo de producto</summary>
        /// <param name="obj_pProductoTipo">Tipo de producto</param>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>18-08-2016</FecCrea></item></list></remarks>
        public static ProcessResult Modificar(Kruma.KantaPe.Entidad.ProductoTipo obj_pProductoTipo)
        {
            ProcessResult obj_Resultado = null;
            try
            {
                Kruma.KantaPe.Data.ProductoTipo.Modificar(obj_pProductoTipo);
                obj_Resultado = new ProcessResult(obj_pProductoTipo.IdProductoTipo);
            }
            catch (Exception obj_pExcepcion)
            {
                obj_Resultado = new ProcessResult(obj_pExcepcion);
            }
            return obj_Resultado;
        }

        #endregion
    }
}