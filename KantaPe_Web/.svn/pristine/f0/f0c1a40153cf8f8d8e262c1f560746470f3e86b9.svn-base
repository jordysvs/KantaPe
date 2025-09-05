using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Kruma.KantaPe.Negocio
{
    /// <summary>AperturaCancionSolicitud</summary>
    /// <remarks><list type="bullet">
    /// <item><CreadoPor>Creado por Carlos Gómez</CreadoPor></item>
    /// <item><FecCrea>29-10-2016</FecCrea></item></list></remarks>

    public class AperturaCancionSolicitud
    {

        #region Metodos Públicos

        /// <summary>Listado de AperturaCancionSolicitud</summary>
        /// <param name="int_pIdAperturaCancionSolicitud">Id de AperturaCancionSolicitud</param>
        /// <param name="str_pDescripcion">Descripción de AperturaCancionSolicitud</param>
        /// <param name="str_pEstado">Estado de AperturaCancionSolicitud</param>
        /// <param name="int_pNumPagina" >Número de página</param>
        /// <param name="int_pTamPagina" >Tamaño de página</param>
        /// <returns>Lista de genero</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por Carlos Gómez</CreadoPor></item>
        /// <item><FecCrea>29-10-2016</FecCrea></item></list></remarks>
        public static Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.AperturaCancionSolicitud> Listar(
            string str_pDescripcion,
            string str_pEstado,
            int? int_pNumPagina,
            int? int_pTamPagina)
        {
            return Kruma.KantaPe.Data.AperturaCancionSolicitud.Listar(
                null,
                str_pDescripcion,
                str_pEstado,
                int_pNumPagina,
                int_pTamPagina);
        }

        #endregion
    }
}
