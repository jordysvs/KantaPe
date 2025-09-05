using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Kruma.Core.Util.Common;
using System.Transactions;

namespace Kruma.KantaPe.Negocio
{
    /// <summary>Cancion</summary>
    /// <remarks><list type="bullet">
    /// <item><CreadoPor>Creado por Vicente Gonzales</CreadoPor></item>
    /// <item><FecCrea>02-06-2017</FecCrea></item></list></remarks>

    public class LocalCancionTemporal
    {
        #region Metodos Públicos

        /// <summary>Listado de LocalCancionTemporal</summary>
        /// <param name="int_pNumPagina" >Número de página</param>
        /// <param name="int_pTamPagina" >Tamaño de página</param>
        /// <returns>Lista de albumes</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por Vicente Gonzales</CreadoPor></item>
        /// <item><FecCrea>02-06-2017</FecCrea></item></list></remarks>
        public static Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.LocalCancionTemporal> Listar(
            int? int_pIdEmpresa,
            int? int_pIdLocal,
            int? int_pNumPagina,
            int? int_pTamPagina)
        {
            return Kruma.KantaPe.Data.LocalCancionTemporal.Listar(
                int_pIdEmpresa,
                int_pIdLocal,
                int_pNumPagina,
                int_pTamPagina);
        }
        /// <summary>Modificar LocalCancionTemporal</summary>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por Vicente Gonzales</CreadoPor></item>
        /// <item><FecCrea>02-06-2017</FecCrea></item></list></remarks>
        public static Kruma.Core.Util.Common.ProcessResult Modificar(Kruma.KantaPe.Entidad.LocalCancionTemporal obj_pLocalCancionTemporal)
        {
            Kruma.Core.Util.Common.ProcessResult obj_Resultado = null;
            try
            {
                Kruma.KantaPe.Data.LocalCancionTemporal.Modificar(obj_pLocalCancionTemporal);
                obj_Resultado = new Kruma.Core.Util.Common.ProcessResult(obj_pLocalCancionTemporal.IdLocalCancionTemporal);
            }
            catch (Exception obj_pExcepcion)
            {
                obj_Resultado = new Kruma.Core.Util.Common.ProcessResult(obj_pExcepcion);
            }
            return obj_Resultado;
        }
        #endregion
    }
}
