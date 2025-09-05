using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Kruma.Core.Util.Common;

namespace Kruma.KantaPe.Negocio
{
	/// <summary>LocalInsumo</summary>
	/// <remarks><list type="bullet">
	/// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
	/// <item><FecCrea>12-07-2016</FecCrea></item></list></remarks>

    public class LocalInsumo
    {
        #region Metodos Públicos

        /// <summary>Listado de LocalInsumo</summary>
        /// <param name="int_pIdLocal">IdLocal</param>
        /// <param name="int_pIdInsumo">IdInsumo</param>
        /// <param name="int_pCantidad">Cantidad</param>
        /// <param name="int_pMinimo">Minimo</param>
        /// <param name="str_pEstado">Estado</param>
        /// <param name="int_pNumPagina" >Numero de pagina</param>
        /// <param name="int_pTamPagina" >Tamaño de pagina</param>
        /// <returns>Lista de LocalInsumo</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>12-07-2016</FecCrea></item></list></remarks>
        public static Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.LocalInsumo> Listar(
            int? int_pIdLocal, 
            int? int_pIdInsumo, 
            string str_pEstado, 
            int? int_pNumPagina, 
            int? int_pTamPagina)
        {
            return Kruma.KantaPe.Data.LocalInsumo.Listar(
                int_pIdLocal, 
                int_pIdInsumo, 
                str_pEstado, 
                int_pNumPagina, 
                int_pTamPagina);
        }

        /// <summary>Obtener LocalInsumo</summary>
        /// <param name="int_pIdLocal">IdLocal</param>
        /// <param name="int_pIdInsumo">IdInsumo</param>
        /// <returns>Objeto LocalInsumo</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>12-07-2016</FecCrea></item></list></remarks>
        public static Kruma.KantaPe.Entidad.LocalInsumo Obtener(int int_pIdLocal, int int_pIdInsumo)
        {
            return Kruma.KantaPe.Data.LocalInsumo.Obtener(int_pIdLocal, int_pIdInsumo);
        }

        #endregion
    }
}