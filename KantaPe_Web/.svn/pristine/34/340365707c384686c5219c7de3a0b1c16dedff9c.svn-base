using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Kruma.Core.Util.Common;

namespace Kruma.KantaPe.Negocio
{
	/// <summary>ProductoInsumo</summary>
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
            return Kruma.KantaPe.Data.ProductoInsumo.Listar(
                int_pIdLocal, 
                int_pIdProducto, 
                int_pIdInsumo, 
                str_pEstado, 
                int_pNumPagina, 
                int_pTamPagina);
        }

        /// <summary>Obtener ProductoInsumo</summary>
        /// <param name="int_pIdLocal">IdLocal</param>
        /// <param name="int_pIdProducto">IdProducto</param>
        /// <param name="int_pIdInsumo">IdInsumo</param>
        /// <returns>Objeto ProductoInsumo</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>12-07-2016</FecCrea></item></list></remarks>
        public static Kruma.KantaPe.Entidad.ProductoInsumo Obtener(
            int int_pIdLocal, 
            int int_pIdProducto, 
            int int_pIdInsumo)
        {
            return Kruma.KantaPe.Data.ProductoInsumo.Obtener(
                int_pIdLocal, 
                int_pIdProducto, 
                int_pIdInsumo);
        }
       
        #endregion
    }
}