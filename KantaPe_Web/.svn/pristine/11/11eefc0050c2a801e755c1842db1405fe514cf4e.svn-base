using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Transactions;
using Kruma.Core.Util.Common;

namespace Kruma.KantaPe.Negocio
{
	/// <summary>Turno</summary>
	/// <remarks><list type="bullet">
	/// <item><CreadoPor>Creado por Diego Mendoza</CreadoPor></item>
	/// <item><FecCrea>20-03-2017</FecCrea></item></list></remarks>

	public class Turno
	{
		#region Metodos Públicos

		/// <summary>Listado de Turno</summary>
		/// <param name="int_pIdLocal">IdLocal</param>
		/// <param name="int_pIdTurno">IdTurno</param>
		/// <param name="dt_pFechaTurno">FechaTurno</param>
		/// <param name="str_pEstado">Estado</param>
		/// <param name="int_pNumPagina" >Numero de pagina</param>
		/// <param name="int_pTamPagina" >Tamaño de pagina</param>
		/// <returns>Lista de Turno</returns>
		/// <remarks><list type="bullet">
		/// <item><CreadoPor>Creado por Diego Mendoza</CreadoPor></item>
		/// <item><FecCrea>20-03-2017</FecCrea></item></list></remarks>
		public static Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Turno> Listar(int? int_pIdLocal, int? int_pIdTurno, DateTime? dt_pFechaTurno, string str_pEstado,  int? int_pNumPagina, int? int_pTamPagina)
		{
			return Kruma.KantaPe.Data.Turno.Listar(int_pIdLocal, int_pIdTurno, dt_pFechaTurno, str_pEstado, int_pNumPagina, int_pTamPagina);
		}

		/// <summary>Obtener Turno</summary>
		/// <param name="int_pIdLocal">IdLocal</param>
		/// <param name="int_pIdTurno">IdTurno</param>
		/// <returns>Objeto Turno</returns>
		/// <remarks><list type="bullet">
		/// <item><CreadoPor>Creado por Diego Mendoza</CreadoPor></item>
		/// <item><FecCrea>20-03-2017</FecCrea></item></list></remarks>
		public static Kruma.KantaPe.Entidad.Turno Obtener(int int_pIdLocal, int int_pIdTurno)
		{
			return Kruma.KantaPe.Data.Turno.Obtener(int_pIdLocal, int_pIdTurno);
		}

		/// <summary>Insertar Turno</summary>
		/// <param name="obj_pTurno">Turno</param>
		/// <returns>Id de Turno</returns>
		/// <remarks><list type="bullet">
		/// <item><CreadoPor>Creado por Diego Mendoza</CreadoPor></item>
		/// <item><FecCrea>20-03-2017</FecCrea></item></list></remarks>
		public static ProcessResult Insertar(Kruma.KantaPe.Entidad.Turno obj_pTurno, int? int_pIdAperturaDrop, int? int_pIdUbicacionDrag, Kruma.KantaPe.Entidad.AperturaCancion obj_CancionTurno)
		{
			ProcessResult obj_Resultado = null;
			try
			{
                using (TransactionScope obj_Transaction = new TransactionScope())
                {
                    int int_IdTurno = Kruma.KantaPe.Data.Turno.Insertar(obj_pTurno);
                    int? int_IdAperturaDrag = obj_pTurno.IdApertura;
                    foreach(Kruma.KantaPe.Entidad.TurnoDetalle obj_Detalle in obj_pTurno.Detalles)
                    {
                        //int_IdAperturaDrag = obj_Detalle.IdApertura.Value;
                        obj_Detalle.IdTurno = int_IdTurno;
                        obj_Detalle.UsuarioCreacion = obj_pTurno.UsuarioCreacion;
                        obj_Detalle.UsuarioModificacion = obj_Detalle.UsuarioCreacion;
                        Kruma.KantaPe.Data.TurnoDetalle.Insertar(obj_Detalle);
                    }

                    //Modificando el FlagTurno en S de la apertura origen
                    Kruma.KantaPe.Entidad.Apertura obj_AperturaDrag = Kruma.KantaPe.Data.Apertura.Obtener(obj_pTurno.IdLocal.Value, int_IdAperturaDrag.Value);
                    obj_AperturaDrag.FlagTurno = Kruma.KantaPe.Entidad.Constante.Condicion_Positivo;
                    obj_AperturaDrag.UsuarioModificacion = obj_pTurno.UsuarioModificacion;
                    Kruma.KantaPe.Data.Apertura.Modificar(obj_AperturaDrag);

                    //Insertando la alerta para la notificación
                    Kruma.KantaPe.Entidad.Alerta obj_Alerta = new Kruma.KantaPe.Entidad.Alerta();
                    obj_Alerta.IdLocal = obj_pTurno.IdLocal;
                    obj_Alerta.IdUbicacion = int_pIdUbicacionDrag;
                    obj_Alerta.IdAlertaTipo = Kruma.KantaPe.Entidad.Constante.AlertaTipo_Turno;
                    obj_Alerta.FechaAlerta = DateTime.Now;
                    obj_Alerta.IdUsuario = obj_pTurno.UsuarioCreacion;
                    obj_Alerta.UsuarioCreacion = obj_pTurno.UsuarioCreacion;
                    obj_Alerta.UsuarioModificacion = obj_pTurno.UsuarioCreacion;
                    Kruma.KantaPe.Data.Alerta.Insertar(obj_Alerta);

                    //Modificando la apertura del destino
                    if (int_pIdAperturaDrop.HasValue)
                    {
                        Kruma.KantaPe.Entidad.Apertura obj_AperturaDrop = Kruma.KantaPe.Data.Apertura.Obtener(obj_pTurno.IdLocal.Value, int_pIdAperturaDrop.Value);
                        obj_AperturaDrop.Ronda++;
                        obj_AperturaDrop.FlagTurno = Kruma.KantaPe.Entidad.Constante.Condicion_Negativo;
                        obj_AperturaDrop.UsuarioModificacion = obj_pTurno.UsuarioModificacion;
                        Kruma.KantaPe.Data.Apertura.Modificar(obj_AperturaDrop);

                        if(obj_CancionTurno != null)
                        {
                            obj_CancionTurno.IdAperturaCancionTipo = Kruma.KantaPe.Entidad.Constante.AperturaCancionTipo_Cantada;
                            obj_CancionTurno.UsuarioModificacion = obj_pTurno.UsuarioModificacion;
                            Kruma.KantaPe.Data.AperturaCancion.Modificar(obj_CancionTurno);
                        }
                    }

                    obj_Resultado = new ProcessResult(int_IdTurno);
                    obj_Transaction.Complete();
                }
			}
			catch (Exception obj_pExcepcion)
			{
				obj_Resultado = new ProcessResult(obj_pExcepcion);
			}
			return obj_Resultado;
		}

		/// <summary>Actualizar Turno</summary>
		/// <param name="obj_pTurno">Turno</param>
		/// <remarks><list type="bullet">
		/// <item><CreadoPor>Creado por Diego Mendoza</CreadoPor></item>
		/// <item><FecCrea>20-03-2017</FecCrea></item></list></remarks>
		public static ProcessResult Modificar(Kruma.KantaPe.Entidad.Turno obj_pTurno)
		{
			ProcessResult obj_Resultado = null;
			try
			{
				Kruma.KantaPe.Data.Turno.Modificar(obj_pTurno);
				obj_Resultado = new ProcessResult(obj_pTurno.IdTurno);
			}
			catch (Exception obj_pExcepcion)
			{
				obj_Resultado = new ProcessResult(obj_pExcepcion);
			}
			return obj_Resultado;
		}

		/// <summary>Modificar Estado Turno</summary>
		/// <param name="obj_pTurno">Turno</param>
		/// <remarks><list type="bullet">
		/// <item><CreadoPor>Creado por Diego Mendoza</CreadoPor></item>
		/// <item><FecCrea>20-03-2017</FecCrea></item></list></remarks>
		public static ProcessResult ModificarEstado(Kruma.KantaPe.Entidad.Turno obj_pTurno)
		{
			ProcessResult obj_Resultado = null;
			try
			{
                Kruma.KantaPe.Entidad.Turno obj_Turno = Kruma.KantaPe.Data.Turno.Obtener(obj_pTurno.IdLocal.Value, obj_pTurno.IdTurno.Value);
				if(obj_Turno.Estado == obj_pTurno.Estado)
				{
					string str_Mensaje = obj_pTurno.Estado == Kruma.KantaPe.Entidad.Constante.Estado_Activo ? "El cliente ya se encuentra activo." : "El cliente ya se encuentra inactivo.";
					return new ProcessResult(new Exception(str_Mensaje), str_Mensaje);
				}
					obj_Turno.Estado = obj_pTurno.Estado;
					obj_Turno.UsuarioModificacion = obj_pTurno.UsuarioModificacion;
					Kruma.KantaPe.Data.Turno.Modificar(obj_Turno);

					obj_Resultado = new ProcessResult(obj_pTurno.IdTurno);
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