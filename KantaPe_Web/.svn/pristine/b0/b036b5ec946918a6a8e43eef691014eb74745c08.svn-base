using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data;
using Kruma.Core.Data;
using Kruma.Core.Data.Entity;

namespace Kruma.KantaPe.Data
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
			Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.TurnoDetalle> obj_Lista = new Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.TurnoDetalle>();
			obj_Lista.PageNumber = int_pNumPagina;
			obj_Lista.Total = 0;

			DataOperation dop_Operacion = new DataOperation("ListarTurnoDetalle");
			dop_Operacion.Parameters.Add(new Parameter("@pIdLocal", int_pIdLocal.HasValue ? int_pIdLocal.Value : (object)DBNull.Value));
			dop_Operacion.Parameters.Add(new Parameter("@pIdTurno", int_pIdTurno.HasValue ? int_pIdTurno.Value : (object)DBNull.Value));
			dop_Operacion.Parameters.Add(new Parameter("@pIdApertura", int_pIdApertura.HasValue ? int_pIdApertura.Value : (object)DBNull.Value));
			dop_Operacion.Parameters.Add(new Parameter("@pIdAperturaCancion", int_pIdAperturaCancion.HasValue ? int_pIdAperturaCancion.Value : (object)DBNull.Value));
			dop_Operacion.Parameters.Add(new Parameter("@pEstado", !string.IsNullOrEmpty(str_pEstado) ? str_pEstado : (object)DBNull.Value));
			dop_Operacion.Parameters.Add(new Parameter("@pNumPagina", int_pNumPagina.HasValue ? int_pNumPagina.Value : (object)DBNull.Value));
			dop_Operacion.Parameters.Add(new Parameter("@pTamPagina", int_pTamPagina.HasValue ? int_pTamPagina.Value : (object)DBNull.Value));

			DataTable dt_Resultado = DataManager.ExecuteDataSet(Conexiones.CO_KantaPe, dop_Operacion).Tables[0];

			List<Kruma.KantaPe.Entidad.TurnoDetalle> lst_TurnoDetalle= new List<Kruma.KantaPe.Entidad.TurnoDetalle>();
			Kruma.KantaPe.Entidad.TurnoDetalle obj_TurnoDetalle= new Kruma.KantaPe.Entidad.TurnoDetalle();
			foreach (DataRow obj_Row in dt_Resultado.Rows)
			{
				if (lst_TurnoDetalle.Count == 0)
					obj_Lista.Total = (int)obj_Row["Total_Filas"];
				obj_TurnoDetalle = new Kruma.KantaPe.Entidad.TurnoDetalle();
			    obj_TurnoDetalle.IdLocal = obj_Row["IdLocal"] is DBNull ? null : (int?)obj_Row["IdLocal"];
			    obj_TurnoDetalle.IdTurno = obj_Row["IdTurno"] is DBNull ? null : (int?)obj_Row["IdTurno"];
			    obj_TurnoDetalle.IdApertura = obj_Row["IdApertura"] is DBNull ? null : (int?)obj_Row["IdApertura"];
			    obj_TurnoDetalle.IdAperturaCancion = obj_Row["IdAperturaCancion"] is DBNull ? null : (int?)obj_Row["IdAperturaCancion"];
			    obj_TurnoDetalle.Estado = obj_Row["Estado"] is DBNull ? null : obj_Row["Estado"].ToString();
			    obj_TurnoDetalle.UsuarioCreacion = obj_Row["UsuarioCreacion"] is DBNull ? null : obj_Row["UsuarioCreacion"].ToString();
			    obj_TurnoDetalle.FechaCreacion = obj_Row["FechaCreacion"] is DBNull ? null : (DateTime?)obj_Row["FechaCreacion"];
			    obj_TurnoDetalle.UsuarioModificacion = obj_Row["UsuarioModificacion"] is DBNull ? null : obj_Row["UsuarioModificacion"].ToString();
			    obj_TurnoDetalle.FechaModificacion = obj_Row["FechaModificacion"] is DBNull ? null : (DateTime?)obj_Row["FechaModificacion"];
			    lst_TurnoDetalle.Add(obj_TurnoDetalle);
			}

			obj_Lista.Result = lst_TurnoDetalle;
			return obj_Lista;
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
			Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.TurnoDetalle> lst_TurnoDetalle = Listar(int_pIdLocal, int_pIdTurno, int_pIdApertura, int_pIdAperturaCancion, null, null,null);
			return lst_TurnoDetalle.Result.Count > 0 ? lst_TurnoDetalle.Result[0] : null;
		}

		/// <summary>Insertar TurnoDetalle</summary>
		/// <param name="obj_pTurnoDetalle">TurnoDetalle</param>
		/// <returns>Id de TurnoDetalle</returns>
		/// <remarks><list type="bullet">
		/// <item><CreadoPor>Creado por Diego Mendoza</CreadoPor></item>
		/// <item><FecCrea>20-03-2017</FecCrea></item></list></remarks>
		public static void Insertar(Kruma.KantaPe.Entidad.TurnoDetalle obj_pTurnoDetalle)
		{
			DataOperation dop_Operacion = new DataOperation("InsertarTurnoDetalle");

			dop_Operacion.Parameters.Add(new Parameter("@pIdLocal", obj_pTurnoDetalle.IdLocal));
			dop_Operacion.Parameters.Add(new Parameter("@pIdTurno", obj_pTurnoDetalle.IdTurno));
			dop_Operacion.Parameters.Add(new Parameter("@pIdApertura", obj_pTurnoDetalle.IdApertura));
			dop_Operacion.Parameters.Add(new Parameter("@pIdAperturaCancion", obj_pTurnoDetalle.IdAperturaCancion));
			dop_Operacion.Parameters.Add(new Parameter("@pEstado", obj_pTurnoDetalle.Estado));
            dop_Operacion.Parameters.Add(new Parameter("@pUsuarioCreacion", obj_pTurnoDetalle.UsuarioCreacion));
            
			DataManager.ExecuteNonQuery(Conexiones.CO_KantaPe, dop_Operacion, false);
		}

		/// <summary>Actualizar TurnoDetalle</summary>
		/// <param name="obj_pTurnoDetalle">TurnoDetalle</param>
		/// <remarks><list type="bullet">
		/// <item><CreadoPor>Creado por Diego Mendoza</CreadoPor></item>
		/// <item><FecCrea>20-03-2017</FecCrea></item></list></remarks>
		public static void Modificar(Kruma.KantaPe.Entidad.TurnoDetalle obj_pTurnoDetalle)
		{
			DataOperation dop_Operacion = new DataOperation("ActualizarTurnoDetalle");

			dop_Operacion.Parameters.Add(new Parameter("@pIdLocal", obj_pTurnoDetalle.IdLocal));
			dop_Operacion.Parameters.Add(new Parameter("@pIdTurno", obj_pTurnoDetalle.IdTurno));
			dop_Operacion.Parameters.Add(new Parameter("@pIdApertura", obj_pTurnoDetalle.IdApertura));
			dop_Operacion.Parameters.Add(new Parameter("@pIdAperturaCancion", obj_pTurnoDetalle.IdAperturaCancion));
			dop_Operacion.Parameters.Add(new Parameter("@pEstado", obj_pTurnoDetalle.Estado));
            dop_Operacion.Parameters.Add(new Parameter("@pUsuarioModificacion", obj_pTurnoDetalle.UsuarioModificacion));

            DataManager.ExecuteNonQuery(Conexiones.CO_KantaPe, dop_Operacion, false);
		}

		#endregion
	}
}