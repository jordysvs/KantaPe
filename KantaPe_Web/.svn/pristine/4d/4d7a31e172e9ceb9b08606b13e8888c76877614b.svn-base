using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Kruma.KantaPe.Negocio
{
    /// <summary>CancionSolicitud</summary>
    /// <remarks><list type="bullet">
    /// <item><CreadoPor>Creado por Carlos Gómez</CreadoPor></item>
    /// <item><FecCrea>11-07-2016</FecCrea></item></list></remarks>

    public class CancionSolicitud
    {
        #region Metodos Públicos

        /// <summary>Listado de CancionSolicitud</summary>
        /// <param name="int_pIdCancionSolicitud">Id de la CancionSolicitud</param>
        /// <param name="str_pDescripcion">Descripción de la CancionSolicitud</param>
        /// <param name="str_pEstado">Estado de la CancionSolicitud</param>
        /// <param name="int_pNumPagina" >Numero de pagina</param>
        /// <param name="int_pTamPagina" >Tamaño de pagina</param>
        /// <returns>Lista de cancion solicitud</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>17-08-2016</FecCrea></item></list></remarks>
        public static Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.CancionSolicitud> Listar(
            string str_pDescripcion,
            string str_pEstado,
            int? int_pNumPagina,
            int? int_pTamPagina)
        {
            return Kruma.KantaPe.Data.CancionSolicitud.Listar(null, str_pDescripcion, str_pEstado, int_pNumPagina, int_pTamPagina);
        }

        /// <summary>Obtener CancionSolicitud</summary>
        /// <param name="int_pIdCancionSolicitud">Id de canción solicitud</param>
        /// <returns>Solicitud de la canción</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por Carlos Gómez</CreadoPor></item>
        /// <item><FecCrea>11-07-2016</FecCrea></item></list></remarks>
        public static Kruma.KantaPe.Entidad.CancionSolicitud Obtener(
            int int_pIdCancionSolicitud)
        {
            return Kruma.KantaPe.Data.CancionSolicitud.Obtener(int_pIdCancionSolicitud);
        }

        #endregion
    }
}
