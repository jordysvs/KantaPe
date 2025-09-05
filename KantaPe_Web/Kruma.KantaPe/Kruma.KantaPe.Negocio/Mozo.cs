using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Kruma.Core.Util.Common;

namespace Kruma.KantaPe.Negocio
{
	/// <summary>Mozo</summary>
	/// <remarks><list type="bullet">
	/// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
	/// <item><FecCrea>12-07-2016</FecCrea></item></list></remarks>

    public class Mozo
    {
        #region Metodos Públicos

        /// <summary>Listado de Mozo</summary>
        /// <param name="int_pIdLocal">IdLocal</param>
        /// <param name="int_pIdMozo">IdMozo</param>
        /// <param name="int_pIdPersona">IdPersona</param>
        /// <param name="str_pEstado">Estado</param>
        /// <param name="int_pNumPagina" >Numero de pagina</param>
        /// <param name="int_pTamPagina" >Tamaño de pagina</param>
        /// <returns>Lista de Mozo</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>12-07-2016</FecCrea></item></list></remarks>
        public static Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Mozo> Listar(
            int? int_pIdLocal, 
            int? int_pIdMozo, 
            int? int_pIdPersona, 
            string str_pEstado, 
            int? int_pNumPagina, 
            int? int_pTamPagina)
        {
            return Kruma.KantaPe.Data.Mozo.Listar(
                int_pIdLocal, 
                int_pIdMozo, 
                int_pIdPersona, 
                str_pEstado, 
                int_pNumPagina, 
                int_pTamPagina);
        }

        /// <summary>Obtener Mozo</summary>
        /// <param name="int_pIdLocal">IdLocal</param>
        /// <param name="int_pIdMozo">IdMozo</param>
        /// <returns>Objeto Mozo</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>12-07-2016</FecCrea></item></list></remarks>
        public static Kruma.KantaPe.Entidad.Mozo Obtener(int int_pIdLocal, int int_pIdMozo)
        {
            return Kruma.KantaPe.Data.Mozo.Obtener(int_pIdLocal, int_pIdMozo);
        }

        /// <summary>Insertar Mozo</summary>
        /// <param name="obj_pMozo">Mozo</param>
        /// <returns>Id de Mozo</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>12-07-2016</FecCrea></item></list></remarks>
        public static ProcessResult Insertar(Kruma.KantaPe.Entidad.Mozo obj_pMozo)
        {
            ProcessResult obj_Resultado = null;
            try
            {
                int int_IdMozo = Kruma.KantaPe.Data.Mozo.Insertar(obj_pMozo);
                obj_Resultado = new ProcessResult(int_IdMozo);
            }
            catch (Exception obj_pExcepcion)
            {
                obj_Resultado = new ProcessResult(obj_pExcepcion);
            }
            return obj_Resultado;
        }

        /// <summary>Modificar Mozo</summary>
        /// <param name="obj_pMozo">Mozo</param>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>12-07-2016</FecCrea></item></list></remarks>
        public static ProcessResult Modificar(Kruma.KantaPe.Entidad.Mozo obj_pMozo)
        {
            ProcessResult obj_Resultado = null;
            try
            {
                Kruma.KantaPe.Data.Mozo.Modificar(obj_pMozo);
                obj_Resultado = new ProcessResult(obj_pMozo.IdMozo);
            }
            catch (Exception obj_pExcepcion)
            {
                obj_Resultado = new ProcessResult(obj_pExcepcion);
            }
            return obj_Resultado;
        }

        /// <summary>Modificar Estado Mozo</summary>
        /// <param name="obj_pMozo">Mozo</param>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>12-07-2016</FecCrea></item></list></remarks>
        public static Kruma.Core.Util.Common.ProcessResult ModificarEstado(Kruma.KantaPe.Entidad.Mozo obj_pMozo)
        {
            Kruma.Core.Util.Common.ProcessResult obj_Resultado = null;
            try
            {
                Kruma.KantaPe.Entidad.Mozo obj_Mozo = Kruma.KantaPe.Data.Mozo.Obtener(
                    obj_pMozo.IdLocal.Value,
                    obj_pMozo.IdMozo.Value);

                if (obj_Mozo.Estado == obj_pMozo.Estado)
                {
                    string str_Mensaje = obj_pMozo.Estado ==
                        Kruma.KantaPe.Entidad.Constante.Estado_Activo ?
                        "El mozo ya se encuentra activo." :
                        "El mozo ya se encuentra inactivo.";
                    return new Kruma.Core.Util.Common.ProcessResult(new Exception(str_Mensaje), str_Mensaje);
                }
                obj_Mozo.Estado = obj_pMozo.Estado;
                obj_Mozo.UsuarioModificacion = obj_pMozo.UsuarioModificacion;
                Kruma.KantaPe.Data.Mozo.Modificar(obj_Mozo);

                obj_Resultado = new Kruma.Core.Util.Common.ProcessResult(obj_pMozo.IdLocal);
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