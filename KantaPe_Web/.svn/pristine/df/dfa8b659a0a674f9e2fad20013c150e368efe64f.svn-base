using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Kruma.Core.Util.Common;

namespace Kruma.KantaPe.Negocio
{
	/// <summary>TurnoDetalle</summary>
	/// <remarks><list type="bullet">
	/// <item><CreadoPor>Creado por Diego Mendoza</CreadoPor></item>
	/// <item><FecCrea>20-03-2017</FecCrea></item></list></remarks>

	public class TurnoDetalle
	{
		#region Metodos Públicos

		/// <summary>Listado de TurnoDetalle</summary>
		/// <param name="int_pIdLocal">IdLocal</param>
		/// <param name="int_pIdTurno">IdTurno</param>
		/// <param name="int_pIdApertura">IdApertura</param>
		/// <param name="int_pIdAperturaCancion">IdAperturaCancion</param>
		/// <param name="str_pEstado">Estado</param>
		/// <param name="int_pNumPagina" >Numero de pagina</param>
		/// <param name="int_pTamPagina" >Tamaño de pagina</param>
		/// <returns>Lista de TurnoDetalle</returns>
		/// <remarks><list type="bullet">
		/// <item><CreadoPor>Creado por Diego Mendoza</CreadoPor></item>
		/// <item><FecCrea>20-03-2017</FecCrea></item></list></remarks>
		public static Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.TurnoDetalle> Listar(int? int_pIdLocal, int? int_pIdTurno, int? int_pIdApertura, int? int_pIdAperturaCancion, string str_pEstado,  int? int_pNumPagina, int? int_pTamPagina)
		{
			return Kruma.KantaPe.Data.TurnoDetalle.Listar(int_pIdLocal, int_pIdTurno, int_pIdApertura, int_pIdAperturaCancion, str_pEstado, int_pNumPagina, int_pTamPagina);
		}

		/// <summary>Obtener TurnoDetalle</summary>
		/// <param name="int_pIdLocal">IdLocal</param>
		/// <param name="int_pIdTurno">IdTurno</param>
		/// <param name="int_pIdApertura">IdApertura</param>
		/// <param name="int_pIdAperturaCancion">IdAperturaCancion</param>
		/// <returns>Objeto TurnoDetalle</returns>
		/// <remarks><list type="bullet">
		/// <item><CreadoPor>Creado por Diego Mendoza</CreadoPor></item>
		/// <item><FecCrea>20-03-2017</FecCrea></item></list></remarks>
		public static Kruma.KantaPe.Entidad.TurnoDetalle Obtener(int int_pIdLocal, int int_pIdTurno, int int_pIdApertura, int int_pIdAperturaCancion)
		{
			return Kruma.KantaPe.Data.TurnoDetalle.Obtener(int_pIdLocal, int_pIdTurno, int_pIdApertura, int_pIdAperturaCancion);
		}

		/// <summary>Insertar TurnoDetalle</summary>
		/// <param name="obj_pTurnoDetalle">TurnoDetalle</param>
		/// <returns>Id de TurnoDetalle</returns>
		/// <remarks><list type="bullet">
		/// <item><CreadoPor>Creado por Diego Mendoza</CreadoPor></item>
		/// <item><FecCrea>20-03-2017</FecCrea></item></list></remarks>
		public static ProcessResult Insertar(Kruma.KantaPe.Entidad.TurnoDetalle obj_pTurnoDetalle)
		{
			ProcessResult obj_Resultado = null;
			try
			{
				Kruma.KantaPe.Data.TurnoDetalle.Insertar(obj_pTurnoDetalle);
				obj_Resultado = new ProcessResult(obj_pTurnoDetalle.IdTurno);
			}
			catch (Exception obj_pExcepcion)
			{
				obj_Resultado = new ProcessResult(obj_pExcepcion);
			}
			return obj_Resultado;
		}

		/// <summary>Actualizar TurnoDetalle</summary>
		/// <param name="obj_pTurnoDetalle">TurnoDetalle</param>
		/// <remarks><list type="bullet">
		/// <item><CreadoPor>Creado por Diego Mendoza</CreadoPor></item>
		/// <item><FecCrea>20-03-2017</FecCrea></item></list></remarks>
		public static ProcessResult Modificar(Kruma.KantaPe.Entidad.TurnoDetalle obj_pTurnoDetalle)
		{
			ProcessResult obj_Resultado = null;
			try
			{
				Kruma.KantaPe.Data.TurnoDetalle.Modificar(obj_pTurnoDetalle);
				obj_Resultado = new ProcessResult(obj_pTurnoDetalle.IdTurno);
			}
			catch (Exception obj_pExcepcion)
			{
				obj_Resultado = new ProcessResult(obj_pExcepcion);
			}
			return obj_Resultado;
		}

		/// <summary>Modificar Estado TurnoDetalle</summary>
		/// <param name="obj_pTurnoDetalle">TurnoDetalle</param>
		/// <remarks><list type="bullet">
		/// <item><CreadoPor>Creado por Diego Mendoza</CreadoPor></item>
		/// <item><FecCrea>20-03-2017</FecCrea></item></list></remarks>
		public static ProcessResult ModificarEstado(Kruma.KantaPe.Entidad.TurnoDetalle obj_pTurnoDetalle)
		{
			ProcessResult obj_Resultado = null;
			try
			{
                Kruma.KantaPe.Entidad.TurnoDetalle obj_TurnoDetalle = Kruma.KantaPe.Data.TurnoDetalle.Obtener(obj_pTurnoDetalle.IdLocal.Value, obj_pTurnoDetalle.IdTurno.Value, obj_pTurnoDetalle.IdApertura.Value, obj_pTurnoDetalle.IdAperturaCancion.Value);
				if(obj_TurnoDetalle.Estado == obj_pTurnoDetalle.Estado)
				{
					string str_Mensaje = obj_pTurnoDetalle.Estado == Kruma.KantaPe.Entidad.Constante.Estado_Activo ? "El cliente ya se encuentra activo." : "El cliente ya se encuentra inactivo.";
					return new ProcessResult(new Exception(str_Mensaje), str_Mensaje);
				}
					obj_TurnoDetalle.Estado = obj_pTurnoDetalle.Estado;
					obj_TurnoDetalle.UsuarioModificacion = obj_pTurnoDetalle.UsuarioModificacion;
					Kruma.KantaPe.Data.TurnoDetalle.Modificar(obj_TurnoDetalle);

					obj_Resultado = new ProcessResult(obj_pTurnoDetalle.IdTurno);
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