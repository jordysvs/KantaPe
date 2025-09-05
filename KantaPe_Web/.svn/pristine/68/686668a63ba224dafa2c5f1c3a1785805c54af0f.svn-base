using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Kruma.KantaPe.Negocio
{
    /// <summary>Empleado</summary>
    /// <remarks><list type="bullet">
    /// <item><CreadoPor>Creado por Kruma</CreadoPor></item>
    /// <item><FecCrea>13-07-2016</FecCrea></item></list></remarks>

    public class Empleado
    {
        #region Metodos Públicos

        /// <summary>Listado de Empleado</summary>
        /// <param name="int_pIdEmpleado">IdEmpleado</param>
        /// <param name="int_pIdPersona">IdPersona</param>
        /// <param name="int_pIdEmpresa">IdEmpresa</param>
        /// <param name="int_pIdArea">IdArea</param>
        /// <param name="int_pIdPuesto">IdPuesto</param>
        /// <param name="dt_pFechaIngreso">FechaIngreso</param>
        /// <param name="str_pEstado">Estado</param>
        /// <param name="int_pNumPagina" >Numero de pagina</param>
        /// <param name="int_pTamPagina" >Tamaño de pagina</param>
        /// <returns>Lista de Empleado</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por Kruma</CreadoPor></item>
        /// <item><FecCrea>13-07-2016</FecCrea></item></list></remarks>
        public static Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Empleado> Listar(
            int? int_pIdEmpleado,
            int? int_pIdEmpresa,
            int? int_pIdPersona,
            int? int_pIdLocal,
            int? int_pIdTipoDocumento,
            string str_pNumeroDocumento,
            string str_pNombreCompleto,
            string str_pEstado,
            int? int_pNumPagina,
            int? int_pTamPagina)
        {
            return Kruma.KantaPe.Data.Empleado.Listar(int_pIdEmpleado, int_pIdEmpresa, int_pIdPersona, int_pIdLocal, int_pIdTipoDocumento, str_pNumeroDocumento, str_pNombreCompleto, str_pEstado, int_pNumPagina, int_pTamPagina);
        }

        /// <summary>Obtener Empleado</summary>
        /// <param name="int_pIdEmpleado">IdEmpleado</param>
        /// <returns>Objeto Empleado</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por Kruma</CreadoPor></item>
        /// <item><FecCrea>13-07-2016</FecCrea></item></list></remarks>
        public static Kruma.KantaPe.Entidad.Empleado Obtener(int? int_pIdEmpleado, int? int_pIdPersona)
        {
            return Kruma.KantaPe.Data.Empleado.Obtener(int_pIdEmpleado, int_pIdPersona);
        }

        /// <summary>Obtener Empleado</summary>
        /// <param name="int_pIdEmpresa">Id de la empresa</param>
        /// <param name="int_pIdPersona">Id de la persona</param>
        /// <returns>Objeto Empleado</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por Kruma</CreadoPor></item>
        /// <item><FecCrea>13-07-2016</FecCrea></item></list></remarks>
        public static Kruma.KantaPe.Entidad.Empleado Obtener(int? int_pIdEmpresa, int int_pIdPersona)
        {
            System.Collections.Generic.List<Kruma.KantaPe.Entidad.Empleado> lst_Empleado = Kruma.KantaPe.Negocio.Empleado.Listar(null, int_pIdEmpresa, int_pIdPersona, null, null, null, null, Kruma.KantaPe.Entidad.Constante.Estado_Activo, null, null).Result;
            return lst_Empleado.Count > 0 ? lst_Empleado[0] : null;
        }

        /// <summary>Insertar Empleado</summary>
        /// <param name="obj_pEmpleado">Empleado</param>
        /// <returns>Id de Empleado</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por Kruma</CreadoPor></item>
        /// <item><FecCrea>13-07-2016</FecCrea></item></list></remarks>
        public static Kruma.Core.Util.Common.ProcessResult Insertar(Kruma.KantaPe.Entidad.Empleado obj_pEmpleado)
        {
            Kruma.Core.Util.Common.ProcessResult obj_Resultado = null;
            try
            {
                int int_IdEmpleado = Kruma.KantaPe.Data.Empleado.Insertar(obj_pEmpleado);
                obj_Resultado = new Kruma.Core.Util.Common.ProcessResult(int_IdEmpleado);
            }
            catch (Exception obj_pExcepcion)
            {
                obj_Resultado = new Kruma.Core.Util.Common.ProcessResult(obj_pExcepcion);
            }
            return obj_Resultado;
        }

        /// <summary>Modificar Empleado</summary>
        /// <param name="obj_pEmpleado">Empleado</param>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por Kruma</CreadoPor></item>
        /// <item><FecCrea>13-07-2016</FecCrea></item></list></remarks>
        public static Kruma.Core.Util.Common.ProcessResult Modificar(Kruma.KantaPe.Entidad.Empleado obj_pEmpleado)
        {
            Kruma.Core.Util.Common.ProcessResult obj_Resultado = null;
            try
            {
                Kruma.KantaPe.Data.Empleado.Modificar(obj_pEmpleado);
                obj_Resultado = new Kruma.Core.Util.Common.ProcessResult(obj_pEmpleado.IdEmpleado);
            }
            catch (Exception obj_pExcepcion)
            {
                obj_Resultado = new Kruma.Core.Util.Common.ProcessResult(obj_pExcepcion);
            }
            return obj_Resultado;
        }

        /// <summary>Modificar Estado Empleado</summary>
        /// <param name="obj_pEmpleado">Empleado</param>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por Kruma</CreadoPor></item>
        /// <item><FecCrea>13-07-2016</FecCrea></item></list></remarks>
        public static Kruma.Core.Util.Common.ProcessResult ModificarEstado(
            Kruma.KantaPe.Entidad.Empleado obj_pEmpleado)
        {
            Kruma.Core.Util.Common.ProcessResult obj_Resultado = null;
            try
            {
                Kruma.KantaPe.Entidad.Empleado obj_Empleado = Kruma.KantaPe.Data.Empleado.Obtener(obj_pEmpleado.IdEmpleado.Value, null);
                if (obj_Empleado.Estado == obj_pEmpleado.Estado)
                {
                    string str_Mensaje = obj_pEmpleado.Estado ==
                        Kruma.KantaPe.Entidad.Constante.Estado_Activo ?
                        "El empleado ya se encuentra activo." :
                        "El empleado ya se encuentra inactivo.";
                    return new Kruma.Core.Util.Common.ProcessResult(new Exception(str_Mensaje), str_Mensaje);
                }
                obj_Empleado.Estado = obj_pEmpleado.Estado;
                obj_Empleado.UsuarioModificacion = obj_pEmpleado.UsuarioModificacion;
                Kruma.KantaPe.Data.Empleado.Modificar(obj_Empleado);

                obj_Resultado = new Kruma.Core.Util.Common.ProcessResult(obj_pEmpleado.IdEmpleado);
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