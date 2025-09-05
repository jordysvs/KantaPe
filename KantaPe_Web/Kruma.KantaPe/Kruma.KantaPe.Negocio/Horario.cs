using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Kruma.Core.Util.Common;

namespace Kruma.KantaPe.Negocio
{
    /// <summary>Horario</summary>
    /// <remarks><list type="bullet">
    /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
    /// <item><FecCrea>12-07-2016</FecCrea></item></list></remarks>

    public class Horario
    {
        #region Metodos Públicos

        /// <summary>Listado de Horario</summary>
        /// <param name="int_pIdLocal">IdLocal</param>
        /// <param name="int_pIdUbicacion">IdUbicacion</param>
        /// <param name="int_pIdHorario">IdHorario</param>
        /// <param name="int_pIdMozo">IdMozo</param>
        /// <param name="int_pDia">Dia</param>
        /// <param name="str_pEstado">Estado</param>
        /// <param name="int_pNumPagina" >Numero de pagina</param>
        /// <param name="int_pTamPagina" >Tamaño de pagina</param>
        /// <returns>Lista de Horario</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>12-07-2016</FecCrea></item></list></remarks>
        public static Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Horario> Listar(
            int? int_pIdLocal,
            int? int_pIdUbicacion,
            int? int_pIdHorario,
            int? int_pIdMozo,
            int? int_pDia,
            string str_pEstado,
            int? int_pNumPagina,
            int? int_pTamPagina)
        {
            return Kruma.KantaPe.Data.Horario.Listar(
                int_pIdLocal,
                int_pIdUbicacion,
                int_pIdHorario,
                int_pIdMozo,
                int_pDia,
                str_pEstado,
                int_pNumPagina,
                int_pTamPagina);
        }

        /// <summary>Obtener Horario</summary>
        /// <param name="int_pIdLocal">IdLocal</param>
        /// <param name="int_pIdUbicacion">IdUbicacion</param>
        /// <param name="int_pIdHorario">IdHorario</param>
        /// <returns>Objeto Horario</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>12-07-2016</FecCrea></item></list></remarks>
        public static Kruma.KantaPe.Entidad.Horario Obtener(
            int int_pIdLocal,
            int int_pIdUbicacion,
            int int_pIdHorario)
        {
            return Kruma.KantaPe.Data.Horario.Obtener(
                int_pIdLocal,
                int_pIdUbicacion,
                int_pIdHorario);
        }

        /// <summary>Insertar Horario</summary>
        /// <param name="obj_pHorario">Horario</param>
        /// <returns>Id de Horario</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>12-07-2016</FecCrea></item></list></remarks>
        public static ProcessResult Insertar(Kruma.KantaPe.Entidad.Horario obj_pHorario)
        {
            ProcessResult obj_Resultado = null;
            try
            {
                int int_IdHorario = Kruma.KantaPe.Data.Horario.Insertar(obj_pHorario);
                obj_Resultado = new ProcessResult(int_IdHorario);
            }
            catch (Exception obj_pExcepcion)
            {
                obj_Resultado = new ProcessResult(obj_pExcepcion);
            }
            return obj_Resultado;
        }

        /// <summary>Modificar Horario</summary>
        /// <param name="obj_pHorario">Horario</param>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>12-07-2016</FecCrea></item></list></remarks>
        public static ProcessResult Modificar(Kruma.KantaPe.Entidad.Horario obj_pHorario)
        {
            ProcessResult obj_Resultado = null;
            try
            {
                Kruma.KantaPe.Data.Horario.Modificar(obj_pHorario);
                obj_Resultado = new ProcessResult(obj_pHorario.IdHorario);
            }
            catch (Exception obj_pExcepcion)
            {
                obj_Resultado = new ProcessResult(obj_pExcepcion);
            }
            return obj_Resultado;
        }

        /// <summary>Modificar Estado Horario</summary>
        /// <param name="obj_pHorario">Horario</param>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>12-07-2016</FecCrea></item></list></remarks>
        public static Kruma.Core.Util.Common.ProcessResult ModificarEstado(Kruma.KantaPe.Entidad.Horario obj_pHorario)
        {
            Kruma.Core.Util.Common.ProcessResult obj_Resultado = null;
            try
            {
                Kruma.KantaPe.Entidad.Horario obj_Horario = Kruma.KantaPe.Data.Horario.Obtener(
                    obj_pHorario.IdLocal.Value,
                    obj_pHorario.IdUbicacion.Value,
                    obj_pHorario.IdHorario.Value);

                if (obj_Horario.Estado == obj_pHorario.Estado)
                {
                    string str_Mensaje = obj_pHorario.Estado ==
                        Kruma.KantaPe.Entidad.Constante.Estado_Activo ?
                        "El horario ya se encuentra activo." :
                        "El horario ya se encuentra inactivo.";
                    return new Kruma.Core.Util.Common.ProcessResult(new Exception(str_Mensaje), str_Mensaje);
                }
                obj_Horario.Estado = obj_pHorario.Estado;
                obj_Horario.UsuarioModificacion = obj_pHorario.UsuarioModificacion;
                Kruma.KantaPe.Data.Horario.Modificar(obj_Horario);

                obj_Resultado = new Kruma.Core.Util.Common.ProcessResult(obj_pHorario.IdHorario);
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