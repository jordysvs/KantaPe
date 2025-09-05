using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Kruma.Core.Util.Common;

namespace Kruma.KantaPe.Negocio
{
	/// <summary>tipo de cancion de la apertura</summary>
	/// <remarks><list type="bullet">
	/// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
	/// <item><FecCrea>25-07-2016</FecCrea></item></list></remarks>

    public class AperturaCancionTipo
    {
        #region Metodos Públicos

        /// <summary>Listado de tipo de cancion de la apertura</summary>
        /// <param name="int_pIdAperturaCancionTipo">IdAperturaCancionTipo</param>
        /// <param name="str_pDescripcion">Descripcion</param>
        /// <param name="str_pEstado">Estado</param>
        /// <param name="int_pNumPagina" >Numero de pagina</param>
        /// <param name="int_pTamPagina" >Tamaño de pagina</param>
        /// <returns>Lista de AperturaCancionTipo</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>25-07-2016</FecCrea></item></list></remarks>
        public static Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.AperturaCancionTipo> Listar(
            int? int_pIdAperturaCancionTipo, 
            string str_pDescripcion, 
            string str_pEstado, 
            int? int_pNumPagina, 
            int? int_pTamPagina)
        {
            return Kruma.KantaPe.Data.AperturaCancionTipo.Listar(int_pIdAperturaCancionTipo, str_pDescripcion, str_pEstado, int_pNumPagina, int_pTamPagina);
        }

        /// <summary>Obtener tipo de cancion de la apertura</summary>
        /// <param name="int_pIdAperturaCancionTipo">IdAperturaCancionTipo</param>
        /// <returns>Objeto AperturaCancionTipo</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>25-07-2016</FecCrea></item></list></remarks>
        public static Kruma.KantaPe.Entidad.AperturaCancionTipo Obtener(int int_pIdAperturaCancionTipo)
        {
            return Kruma.KantaPe.Data.AperturaCancionTipo.Obtener(int_pIdAperturaCancionTipo);
        }

        /// <summary>Insertar tipo de cancion de la apertura</summary>
        /// <param name="obj_pAperturaCancionTipo">AperturaCancionTipo</param>
        /// <returns>Id de AperturaCancionTipo</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>25-07-2016</FecCrea></item></list></remarks>
        public static ProcessResult Insertar(Kruma.KantaPe.Entidad.AperturaCancionTipo obj_pAperturaCancionTipo)
        {
            ProcessResult obj_Resultado = null;
            try
            {
                int int_IdAperturaCancionTipo = Kruma.KantaPe.Data.AperturaCancionTipo.Insertar(obj_pAperturaCancionTipo);
                obj_Resultado = new ProcessResult(int_IdAperturaCancionTipo);
            }
            catch (Exception obj_pExcepcion)
            {
                obj_Resultado = new ProcessResult(obj_pExcepcion);
            }
            return obj_Resultado;
        }

        /// <summary>Modificar tipo de cancion de la apertura</summary>
        /// <param name="obj_pAperturaCancionTipo">AperturaCancionTipo</param>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>25-07-2016</FecCrea></item></list></remarks>
        public static ProcessResult Modificar(Kruma.KantaPe.Entidad.AperturaCancionTipo obj_pAperturaCancionTipo)
        {
            ProcessResult obj_Resultado = null;
            try
            {
                Kruma.KantaPe.Data.AperturaCancionTipo.Modificar(obj_pAperturaCancionTipo);
                obj_Resultado = new ProcessResult(obj_pAperturaCancionTipo.IdAperturaCancionTipo);
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