using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Kruma.Core.Util.Common;

namespace Kruma.KantaPe.Negocio
{
    /// <summary>Insumo</summary>
    /// <remarks><list type="bullet">
    /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
    /// <item><FecCrea>12-07-2016</FecCrea></item></list></remarks>

    public class Insumo
    {
        #region Metodos Públicos

        /// <summary>Listado de Insumo</summary>
        /// <param name="int_pIdInsumo">IdInsumo</param>
        /// <param name="str_pCodigo">Codigo</param>
        /// <param name="str_pDescripcion">Descripcion</param>
        /// <param name="int_pIdUnidadMedida">IdUnidadMedida</param>
        /// <param name="str_pEstado">Estado</param>
        /// <param name="int_pNumPagina" >Numero de pagina</param>
        /// <param name="int_pTamPagina" >Tamaño de pagina</param>
        /// <returns>Lista de Insumo</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>12-07-2016</FecCrea></item></list></remarks>
        public static Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Insumo> Listar(
            int? int_pIdInsumo, 
            string str_pCodigo, 
            string str_pDescripcion, 
            int? int_pIdUnidadMedida, 
            string str_pEstado, 
            int? int_pNumPagina, 
            int? int_pTamPagina)
        {
            return Kruma.KantaPe.Data.Insumo.Listar(
                int_pIdInsumo, 
                str_pCodigo, 
                str_pDescripcion, 
                int_pIdUnidadMedida, 
                str_pEstado, 
                int_pNumPagina, 
                int_pTamPagina);
        }

        /// <summary>Obtener Insumo</summary>
        /// <param name="int_pIdInsumo">IdInsumo</param>
        /// <returns>Objeto Insumo</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>12-07-2016</FecCrea></item></list></remarks>
        public static Kruma.KantaPe.Entidad.Insumo Obtener(int int_pIdInsumo)
        {
            return Kruma.KantaPe.Data.Insumo.Obtener(int_pIdInsumo);
        }

        /// <summary>Insertar Insumo</summary>
        /// <param name="obj_pInsumo">Insumo</param>
        /// <returns>Id de Insumo</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>12-07-2016</FecCrea></item></list></remarks>
        public static ProcessResult Insertar(Kruma.KantaPe.Entidad.Insumo obj_pInsumo)
        {
            ProcessResult obj_Resultado = null;
            try
            {
                int int_IdInsumo = Kruma.KantaPe.Data.Insumo.Insertar(obj_pInsumo);
                obj_Resultado = new ProcessResult(int_IdInsumo);
            }
            catch (Exception obj_pExcepcion)
            {
                obj_Resultado = new ProcessResult(obj_pExcepcion);
            }
            return obj_Resultado;
        }

        /// <summary>Modificar Insumo</summary>
        /// <param name="obj_pInsumo">Insumo</param>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>12-07-2016</FecCrea></item></list></remarks>
        public static ProcessResult Modificar(Kruma.KantaPe.Entidad.Insumo obj_pInsumo)
        {
            ProcessResult obj_Resultado = null;
            try
            {
                Kruma.KantaPe.Data.Insumo.Modificar(obj_pInsumo);
                obj_Resultado = new ProcessResult(obj_pInsumo.IdInsumo);
            }
            catch (Exception obj_pExcepcion)
            {
                obj_Resultado = new ProcessResult(obj_pExcepcion);
            }
            return obj_Resultado;
        }

        /// <summary>Modificar Estado Insumo</summary>
        /// <param name="obj_pInsumo">Insumo</param>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>12-07-2016</FecCrea></item></list></remarks>
        public static Kruma.Core.Util.Common.ProcessResult ModificarEstado(Kruma.KantaPe.Entidad.Insumo obj_pInsumo)
        {
            Kruma.Core.Util.Common.ProcessResult obj_Resultado = null;
            try
            {
                Kruma.KantaPe.Entidad.Insumo obj_Insumo = Kruma.KantaPe.Data.Insumo.Obtener(
                    obj_pInsumo.IdInsumo.Value);

                if (obj_Insumo.Estado == obj_pInsumo.Estado)
                {
                    string str_Mensaje = obj_pInsumo.Estado ==
                        Kruma.KantaPe.Entidad.Constante.Estado_Activo ?
                        "El insumo ya se encuentra activo." :
                        "El insumo ya se encuentra inactivo.";
                    return new Kruma.Core.Util.Common.ProcessResult(new Exception(str_Mensaje), str_Mensaje);
                }
                obj_Insumo.Estado = obj_pInsumo.Estado;
                obj_Insumo.UsuarioModificacion = obj_pInsumo.UsuarioModificacion;
                Kruma.KantaPe.Data.Insumo.Modificar(obj_Insumo);

                obj_Resultado = new Kruma.Core.Util.Common.ProcessResult(obj_pInsumo.IdInsumo);
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