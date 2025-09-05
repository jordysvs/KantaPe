using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Kruma.Core.Util.Common;

namespace Kruma.KantaPe.Negocio
{
	/// <summary>tipo de ubicación</summary>
	/// <remarks><list type="bullet">
	/// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
	/// <item><FecCrea>25-07-2016</FecCrea></item></list></remarks>

    public class UbicacionTipo
    {
        #region Metodos Públicos

        /// <summary>Listado de tipo de cancion de la apertura</summary>
        /// <param name="int_pIdAperturaCancionTipo">IdAperturaCancionTipo</param>
        /// <param name="str_pDescripcion">Descripcion</param>
        /// <param name="str_pEstado">Estado</param>
        /// <param name="int_pNumPagina" >Numero de pagina</param>
        /// <param name="int_pTamPagina" >Tamaño de pagina</param>
        /// <returns>Lista de AperturaCancionTipo</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>25-07-2016</FecCrea></item></list></remarks>
        public static Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.UbicacionTipo> Listar(
            int? int_pIdUbicacionTipo, 
            string str_pDescripcion, 
            string str_pEstado, 
            int? int_pNumPagina, 
            int? int_pTamPagina)
        {
            return Kruma.KantaPe.Data.UbicacionTipo.Listar(int_pIdUbicacionTipo, str_pDescripcion, str_pEstado, int_pNumPagina, int_pTamPagina);
        }

        /// <summary>Obtener tipo de ubicación</summary>
        /// <param name="int_pIdUbicacionTipo">Id del tipo de ubicación</param>
        /// <returns>Objeto UbicacionTipo</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>25-07-2016</FecCrea></item></list></remarks>
        public static Kruma.KantaPe.Entidad.UbicacionTipo Obtener(int int_pIdUbicacionTipo)
        {
            return Kruma.KantaPe.Data.UbicacionTipo.Obtener(int_pIdUbicacionTipo);
        }

        #endregion
    }
}