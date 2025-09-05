using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Kruma.Core.Util.Common;

namespace Kruma.KantaPe.Negocio
{
	/// <summary>Ubicacion</summary>
	/// <remarks><list type="bullet">
	/// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
	/// <item><FecCrea>12-07-2016</FecCrea></item></list></remarks>

    public class Ubicacion
    {
        #region Metodos Públicos

        /// <summary>Listado de Ubicacion</summary>
        /// <param name="int_pIdLocal">IdLocal</param>
        /// <param name="int_pIdUbicacion">IdUbicacion</param>
        /// <param name="int_pIdTipoUbicacion">IdTipoUbicacion</param>
        /// <param name="int_pNumero">Numero</param>
        /// <param name="int_pCapacidad">Capacidad</param>
        /// <param name="str_pEstado">Estado</param>
        /// <param name="int_pNumPagina" >Numero de pagina</param>
        /// <param name="int_pTamPagina" >Tamaño de pagina</param>
        /// <returns>Lista de Ubicacion</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>12-07-2016</FecCrea></item></list></remarks>
        public static Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Ubicacion> Listar(
            int? int_pIdEmpresa,
            int? int_pIdLocal,
            int? int_pIdUbicacion,
            int? int_pIdUbicacionTipo,
            string str_pNumero,
            string str_pCapacidad,
            string str_pEstado,
            int? int_pNumPagina,
            int? int_pTamPagina)
        {
            return Kruma.KantaPe.Data.Ubicacion.Listar(
                int_pIdEmpresa,
                int_pIdLocal, 
                int_pIdUbicacion,
                int_pIdUbicacionTipo, 
                str_pNumero, 
                str_pCapacidad, 
                str_pEstado, 
                int_pNumPagina, 
                int_pTamPagina);
        }

        /// <summary>Obtener Ubicacion</summary>
        /// <param name="int_pIdLocal">IdLocal</param>
        /// <param name="int_pIdUbicacion">IdUbicacion</param>
        /// <param name="int_pIdUnidadProduccion">IdUnidadProduccion</param>
        /// <param name="int_pIdUbicacion">IdUbicacion</param>
        /// <returns>Objeto Ubicacion</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>12-07-2016</FecCrea></item></list></remarks>
        public static Kruma.KantaPe.Entidad.Ubicacion Obtener(
            int int_pIdLocal, 
            int int_pIdUbicacion)
        {
            return Kruma.KantaPe.Data.Ubicacion.Obtener(
                int_pIdLocal, 
                int_pIdUbicacion);
        }

        /// <summary>Insertar Ubicacion</summary>
        /// <param name="obj_pUbicacion">Ubicacion</param>
        /// <returns>Id de Ubicacion</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>12-07-2016</FecCrea></item></list></remarks>
        public static ProcessResult Insertar(Kruma.KantaPe.Entidad.Ubicacion obj_pUbicacion)
        {
            ProcessResult obj_Resultado = null;
            try
            {
                int int_IdUbicacion = Kruma.KantaPe.Data.Ubicacion.Insertar(obj_pUbicacion);
                obj_Resultado = new ProcessResult(int_IdUbicacion);
            }
            catch (Exception obj_pExcepcion)
            {
                obj_Resultado = new ProcessResult(obj_pExcepcion);
            }
            return obj_Resultado;
        }

        /// <summary>Modificar Ubicacion</summary>
        /// <param name="obj_pUbicacion">Ubicacion</param>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>12-07-2016</FecCrea></item></list></remarks>
        public static ProcessResult Modificar(Kruma.KantaPe.Entidad.Ubicacion obj_pUbicacion)
        {
            ProcessResult obj_Resultado = null;
            try
            {
                Kruma.KantaPe.Data.Ubicacion.Modificar(obj_pUbicacion);
                obj_Resultado = new ProcessResult(obj_pUbicacion.IdUbicacion);
            }
            catch (Exception obj_pExcepcion)
            {
                obj_Resultado = new ProcessResult(obj_pExcepcion);
            }
            return obj_Resultado;
        }

        /// <summary>Modificar Estado Ubicación</summary>
        /// <param name="obj_pUbicacion">Ubicación</param>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>12-07-2016</FecCrea></item></list></remarks>
        public static Kruma.Core.Util.Common.ProcessResult ModificarEstado(Kruma.KantaPe.Entidad.Ubicacion obj_pUbicacion)
        {
            Kruma.Core.Util.Common.ProcessResult obj_Resultado = null;
            try
            {
                Kruma.KantaPe.Entidad.Ubicacion obj_Ubicacion = Kruma.KantaPe.Data.Ubicacion.Obtener(
                    obj_pUbicacion.IdLocal.Value,
                    obj_pUbicacion.IdUbicacion.Value);

                if (obj_Ubicacion.Estado == obj_pUbicacion.Estado)
                {
                    string str_Mensaje = obj_pUbicacion.Estado ==
                        Kruma.KantaPe.Entidad.Constante.Estado_Activo ?
                        "La ubicación ya se encuentra activa." :
                        "La ubicación ya se encuentra inactiva.";
                    return new Kruma.Core.Util.Common.ProcessResult(new Exception(str_Mensaje), str_Mensaje);
                }
                obj_Ubicacion.Estado = obj_pUbicacion.Estado;
                obj_Ubicacion.UsuarioModificacion = obj_pUbicacion.UsuarioModificacion;
                Kruma.KantaPe.Data.Ubicacion.Modificar(obj_Ubicacion);

                obj_Resultado = new Kruma.Core.Util.Common.ProcessResult(obj_pUbicacion.IdUbicacion);
            }
            catch (Exception obj_pExcepcion)
            {
                obj_Resultado = new Kruma.Core.Util.Common.ProcessResult(obj_pExcepcion);
            }

            return obj_Resultado;
        }
        /// <summary>Listado de Total por tipo de ubicacion</summary>
        /// <param name="int_pIdLocal">Id del local</param>
        /// <param name="int_pIdUbicacionTipo">Id del tipo de la ubicación</param>

        /// <returns>Lista de total por tipo Ubicacion</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Vicente Gonzales Osorio</CreadoPor></item>
        /// <item><FecCrea>30-03-2017</FecCrea></item></list></remarks>
        public static Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Ubicacion> ListarTotalUbicacion(
            int? int_pIdUbicacionTipo,
            int? int_pIdLocal)
        {
            return Kruma.KantaPe.Data.Ubicacion.ListarTotalUbicacion(
                int_pIdUbicacionTipo,
                int_pIdLocal         
                );
        }
        #endregion
    }
}