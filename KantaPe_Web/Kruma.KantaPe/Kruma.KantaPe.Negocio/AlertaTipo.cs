using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Kruma.Core.Util.Common;

namespace Kruma.KantaPe.Negocio
{
	/// <summary>Tipo de alerta</summary>
	/// <remarks><list type="bullet">
	/// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
	/// <item><FecCrea>25-07-2016</FecCrea></item></list></remarks>

    public class AlertaTipo
    {
        #region Metodos Públicos

        /// <summary>Listado de tipo de alerta</summary>
        /// <param name="int_pIdAlertaTipo">IdAlertaTipo</param>
        /// <param name="str_pDescripcion">Descripcion</param>
        /// <param name="str_pEstado">Estado</param>
        /// <param name="int_pNumPagina" >Numero de pagina</param>
        /// <param name="int_pTamPagina" >Tamaño de pagina</param>
        /// <returns>Lista de AlertaTipo</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>25-07-2016</FecCrea></item></list></remarks>
        public static Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.AlertaTipo> Listar(
            int? int_pIdAlertaTipo, 
            string str_pDescripcion, 
            string str_pEstado, 
            int? int_pNumPagina, 
            int? int_pTamPagina)
        {
            return Kruma.KantaPe.Data.AlertaTipo.Listar(int_pIdAlertaTipo, str_pDescripcion, str_pEstado, int_pNumPagina, int_pTamPagina);
        }

        /// <summary>Obtener tipo de alerta</summary>
        /// <param name="int_pIdAlertaTipo">IdAlertaTipo</param>
        /// <returns>Objeto AlertaTipo</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>25-07-2016</FecCrea></item></list></remarks>
        public static Kruma.KantaPe.Entidad.AlertaTipo Obtener(int int_pIdAlertaTipo)
        {
            return Kruma.KantaPe.Data.AlertaTipo.Obtener(int_pIdAlertaTipo);
        }

        /// <summary>Insertar AlertaTipo</summary>
        /// <param name="obj_pAlertaTipo">AlertaTipo</param>
        /// <returns>Id de AlertaTipo</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>25-07-2016</FecCrea></item></list></remarks>
        public static ProcessResult Insertar(Kruma.KantaPe.Entidad.AlertaTipo obj_pAlertaTipo)
        {
            ProcessResult obj_Resultado = null;
            try
            {
                int int_IdAlertaTipo = Kruma.KantaPe.Data.AlertaTipo.Insertar(obj_pAlertaTipo);
                obj_Resultado = new ProcessResult(int_IdAlertaTipo);
            }
            catch (Exception obj_pExcepcion)
            {
                obj_Resultado = new ProcessResult(obj_pExcepcion);
            }
            return obj_Resultado;
        }

        /// <summary>Modificar AlertaTipo</summary>
        /// <param name="obj_pAlertaTipo">AlertaTipo</param>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>25-07-2016</FecCrea></item></list></remarks>
        public static ProcessResult Modificar(Kruma.KantaPe.Entidad.AlertaTipo obj_pAlertaTipo)
        {
            ProcessResult obj_Resultado = null;
            try
            {
                Kruma.KantaPe.Data.AlertaTipo.Modificar(obj_pAlertaTipo);
                obj_Resultado = new ProcessResult(obj_pAlertaTipo.IdAlertaTipo);
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