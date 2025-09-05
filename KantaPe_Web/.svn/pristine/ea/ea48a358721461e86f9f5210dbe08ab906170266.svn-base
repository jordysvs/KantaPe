using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Kruma.Core.Util.Common;

namespace Kruma.KantaPe.Negocio
{
	/// <summary>Unidad de medida</summary>
	/// <remarks><list type="bullet">
	/// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
	/// <item><FecCrea>12-07-2016</FecCrea></item></list></remarks>

    public class UnidadMedida
    {
        #region Metodos Públicos

        /// <summary>Listado de unidad de medida</summary>
        /// <param name="int_pIdUnidadMedida">Id de la unidad de medida</param>
        /// <param name="str_pDescripcion">Descripcion</param>
        /// <param name="str_pEstado">Estado</param>
        /// <param name="int_pNumPagina" >Numero de pagina</param>
        /// <param name="int_pTamPagina" >Tamaño de pagina</param>
        /// <returns>Lista de UnidadMedida</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>12-07-2016</FecCrea></item></list></remarks>
        public static Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.UnidadMedida> Listar(
            int? int_pIdUnidadMedida, 
            string str_pDescripcion, 
            string str_pEstado, 
            int? int_pNumPagina, 
            int? int_pTamPagina)
        {
            return Kruma.KantaPe.Data.UnidadMedida.Listar(
                int_pIdUnidadMedida, 
                str_pDescripcion, 
                str_pEstado, 
                int_pNumPagina, 
                int_pTamPagina);
        }

        /// <summary>Obtener unidad de medida</summary>
        /// <param name="int_pIdUnidadMedida">Id de la unidad de medida</param>
        /// <returns>Objeto UnidadMedida</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>12-07-2016</FecCrea></item></list></remarks>
        public static Kruma.KantaPe.Entidad.UnidadMedida Obtener(int int_pIdUnidadMedida)
        {
            return Kruma.KantaPe.Data.UnidadMedida.Obtener(int_pIdUnidadMedida);
        }

        /// <summary>Insertar unidad de medida</summary>
        /// <param name="obj_pUnidadMedida">Unidad de medida</param>
        /// <returns>Id de UnidadMedida</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>12-07-2016</FecCrea></item></list></remarks>
        public static ProcessResult Insertar(Kruma.KantaPe.Entidad.UnidadMedida obj_pUnidadMedida)
        {
            ProcessResult obj_Resultado = null;
            try
            {
                int int_IdUnidadMedida = Kruma.KantaPe.Data.UnidadMedida.Insertar(obj_pUnidadMedida);
                obj_Resultado = new ProcessResult(int_IdUnidadMedida);
            }
            catch (Exception obj_pExcepcion)
            {
                obj_Resultado = new ProcessResult(obj_pExcepcion);
            }
            return obj_Resultado;
        }

        /// <summary>Modificar unidad de medida</summary>
        /// <param name="obj_pUnidadMedida">UnidadMedida</param>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>12-07-2016</FecCrea></item></list></remarks>
        public static ProcessResult Modificar(Kruma.KantaPe.Entidad.UnidadMedida obj_pUnidadMedida)
        {
            ProcessResult obj_Resultado = null;
            try
            {
                Kruma.KantaPe.Data.UnidadMedida.Modificar(obj_pUnidadMedida);
                obj_Resultado = new ProcessResult(obj_pUnidadMedida.IdUnidadMedida);
            }
            catch (Exception obj_pExcepcion)
            {
                obj_Resultado = new ProcessResult(obj_pExcepcion);
            }
            return obj_Resultado;
        }

        /// <summary>Modificar estado de la unidad de medida</summary>
        /// <param name="obj_pUnidadMedida">Unidad de medida</param>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>12-07-2016</FecCrea></item></list></remarks>
        public static Kruma.Core.Util.Common.ProcessResult ModificarEstado(Kruma.KantaPe.Entidad.UnidadMedida obj_pUnidadMedida)
        {
            Kruma.Core.Util.Common.ProcessResult obj_Resultado = null;
            try
            {
                Kruma.KantaPe.Entidad.UnidadMedida obj_UnidadMedida = 
                    Kruma.KantaPe.Data.UnidadMedida.Obtener(
                    obj_pUnidadMedida.IdUnidadMedida.Value);

                if (obj_UnidadMedida.Estado == obj_pUnidadMedida.Estado)
                {
                    string str_Mensaje = obj_pUnidadMedida.Estado ==
                        Kruma.KantaPe.Entidad.Constante.Estado_Activo ?
                        "La unidad de medida ya se encuentra activa." :
                        "La unidad de medida ya se encuentra inactiva.";
                    return new Kruma.Core.Util.Common.ProcessResult(new Exception(str_Mensaje), str_Mensaje);
                }
                obj_UnidadMedida.Estado = obj_pUnidadMedida.Estado;
                obj_UnidadMedida.UsuarioModificacion = obj_pUnidadMedida.UsuarioModificacion;
                Kruma.KantaPe.Data.UnidadMedida.Modificar(obj_UnidadMedida);

                obj_Resultado = new Kruma.Core.Util.Common.ProcessResult(obj_pUnidadMedida.IdUnidadMedida);
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