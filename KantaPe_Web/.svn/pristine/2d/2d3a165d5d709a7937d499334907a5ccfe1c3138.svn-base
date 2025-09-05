using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Kruma.Core.Util.Common;

namespace Kruma.KantaPe.Negocio
{
	/// <summary>ubicacíón de la apertura</summary>
	/// <remarks><list type="bullet">
	/// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
	/// <item><FecCrea>25-07-2016</FecCrea></item></list></remarks>

    public class AperturaUbicacion
    {
        #region Metodos Públicos

        /// <summary>Listado de ubicación de la apertura</summary>
        /// <param name="int_pIdLocal">IdLocal</param>
        /// <param name="int_pIdApertura">IdApertura</param>
        /// <param name="int_pIdUbicacion">IdUbicacion</param>
        /// <param name="str_pEstado">Estado</param>
        /// <param name="int_pNumPagina" >Numero de pagina</param>
        /// <param name="int_pTamPagina" >Tamaño de pagina</param>
        /// <returns>Lista de AperturaUbicacion</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>25-07-2016</FecCrea></item></list></remarks>
        public static Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.AperturaUbicacion> Listar(
            int? int_pIdLocal, 
            int? int_pIdApertura, 
            int? int_pIdUbicacion, 
            string str_pEstado, 
            int? int_pNumPagina, 
            int? int_pTamPagina)
        {
            return Kruma.KantaPe.Data.AperturaUbicacion.Listar(int_pIdLocal, int_pIdApertura, int_pIdUbicacion, str_pEstado, int_pNumPagina, int_pTamPagina);
        }

        /// <summary>Obtener ubicación de la apertura</summary>
        /// <param name="int_pIdLocal">IdLocal</param>
        /// <param name="int_pIdApertura">IdApertura</param>
        /// <param name="int_pIdUbicacion">IdUbicacion</param>
        /// <returns>Objeto AperturaUbicacion</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>25-07-2016</FecCrea></item></list></remarks>
        public static Kruma.KantaPe.Entidad.AperturaUbicacion Obtener(int int_pIdLocal, int int_pIdApertura, int int_pIdUbicacion)
        {
            return Kruma.KantaPe.Data.AperturaUbicacion.Obtener(int_pIdLocal, int_pIdApertura, int_pIdUbicacion);
        }

        /// <summary>Insertar ubicación de la apertura</summary>
        /// <param name="obj_pAperturaUbicacion">AperturaUbicacion</param>
        /// <returns>Id de AperturaUbicacion</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>25-07-2016</FecCrea></item></list></remarks>
        public static ProcessResult Insertar(Kruma.KantaPe.Entidad.AperturaUbicacion obj_pAperturaUbicacion)
        {
            ProcessResult obj_Resultado = null;
            try
            {
                Kruma.KantaPe.Data.AperturaUbicacion.Insertar(obj_pAperturaUbicacion);
                obj_Resultado = new ProcessResult(obj_pAperturaUbicacion.IdUbicacion);
            }
            catch (Exception obj_pExcepcion)
            {
                obj_Resultado = new ProcessResult(obj_pExcepcion);
            }
            return obj_Resultado;
        }

        /// <summary>Modificar AperturaUbicacion</summary>
        /// <param name="obj_pAperturaUbicacion">AperturaUbicacion</param>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>25-07-2016</FecCrea></item></list></remarks>
        public static ProcessResult Modificar(Kruma.KantaPe.Entidad.AperturaUbicacion obj_pAperturaUbicacion)
        {
            ProcessResult obj_Resultado = null;
            try
            {
                Kruma.KantaPe.Data.AperturaUbicacion.Modificar(obj_pAperturaUbicacion);
                obj_Resultado = new ProcessResult(obj_pAperturaUbicacion.IdUbicacion);
            }
            catch (Exception obj_pExcepcion)
            {
                obj_Resultado = new ProcessResult(obj_pExcepcion);
            }
            return obj_Resultado;
        }

        /// <summary>ReporteUbicacionAperturaHora</summary>
        /// <returns>ListarUbicacionAperturaMesaGrafico</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Vicente Gonzales Osorio</CreadoPor></item>
        /// <item><FecCrea>20-03-2017</FecCrea></item></list></remarks>
        public static Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.AperturaUbicacion> ReporteUbicacionAperturaHora(
            int? int_pIdEmpresa,
            int? int_pIdLocal,
            DateTime? dt_pFecha,
            int? int_pHoraInicio,
            int? int_pHoraFin,
            int? int_pIdUbicacionTipo,
            int? int_pNroUbicacion)
        {
            return Kruma.KantaPe.Data.AperturaUbicacion.ReporteUbicacionAperturaHora(int_pIdEmpresa, int_pIdLocal, dt_pFecha, int_pHoraInicio, int_pHoraFin, int_pIdUbicacionTipo, int_pNroUbicacion);
        }
        //LISTAR HORA
        public static Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.AperturaUbicacion> ListarHoraReporte(
            int? int_pIdEmpresa,
            int? int_pIdLocal,
            DateTime? dt_pFecha,
            int? int_pHoraInicio,
            int? int_pHoraFin,
            int? int_pIdUbicacionTipo,
            int? int_pNroUbicacion)
        {
            return Kruma.KantaPe.Data.AperturaUbicacion.ListarHoraReporte(int_pIdEmpresa, int_pIdLocal, dt_pFecha, int_pHoraInicio, int_pHoraFin, int_pIdUbicacionTipo, int_pNroUbicacion);
        }
        //LISTAR TIPO DE UBICACION Y NUMERO
        public static Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.AperturaUbicacion> ListaUbicacionReporte(
            int? int_pIdEmpresa,
            int? int_pIdLocal)
        {
            return Kruma.KantaPe.Data.AperturaUbicacion.ListaUbicacionReporte(int_pIdEmpresa, int_pIdLocal);
        }
        /// <summary>ListarUbicacionAperturaMesaGrafico</summary>
        /// <returns>ListarUbicacionAperturaMesaGrafico</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Vicente Gonzales Osorio</CreadoPor></item>
        /// <item><FecCrea>20-03-2017</FecCrea></item></list></remarks>
        public static Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.AperturaUbicacion> ListarUbicacionAperturaMesaGrafico(
            int? int_pIdEmpresa,
            int? int_pIdLocal,
            DateTime? dt_pFecha,
            int? int_pHoraInicio,
            int? int_pHoraFin,
            int? int_pIdUbicacionTipo,
            int? int_pNroUbicacion)
        {
            return Kruma.KantaPe.Data.AperturaUbicacion.ListarUbicacionAperturaMesaGrafico(int_pIdEmpresa,int_pIdLocal, dt_pFecha, int_pHoraInicio, int_pHoraFin, int_pIdUbicacionTipo, int_pNroUbicacion);
        }

        /// <summary>ListarUbicacionAperturaBoxGrafico</summary>
        /// <returns>ListarUbicacionAperturaBoxGrafico</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Vicente Gonzales Osorio</CreadoPor></item>
        /// <item><FecCrea>20-03-2017</FecCrea></item></list></remarks>
        public static Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.AperturaUbicacion> ListarUbicacionAperturaBoxGrafico(
            int? int_pIdEmpresa,
            int? int_pIdLocal,
            DateTime? dt_pFecha,
            int? int_pHoraInicio,
            int? int_pHoraFin,
            int? int_pIdUbicacionTipo,
            int? int_pNroUbicacion)
        {
            return Kruma.KantaPe.Data.AperturaUbicacion.ListarUbicacionAperturaBoxGrafico(int_pIdEmpresa, int_pIdLocal, dt_pFecha, int_pHoraInicio, int_pHoraFin, int_pIdUbicacionTipo, int_pNroUbicacion);
        }
        #endregion
    }
}