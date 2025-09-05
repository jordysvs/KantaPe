using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;
using System.Threading.Tasks;

namespace Kruma.KantaPe.Entidad
{
	/// <summary>Turno</summary>
	/// <remarks><list type="bullet">
	/// <item><CreadoPor>Creado por Diego Mendoza</CreadoPor></item>
	/// <item><FecCrea>20-03-2017</FecCrea></item></list></remarks>

	[Serializable]
	public class Turno
	{
        public Turno()
        {
            this.Detalles = new List<TurnoDetalle>();
        }
		public int? IdLocal { get; set; }
		public int? IdTurno { get; set; }
		public int? IdApertura { get; set; }
		public DateTime? FechaTurno { get; set; }
		public string Estado { get; set; }
		public string UsuarioCreacion { get; set; }
		public DateTime? FechaCreacion { get; set; }
		public string UsuarioModificacion { get; set; }
		public DateTime? FechaModificacion { get; set; }
        public Local Local { get; set; }
        public List<TurnoDetalle> Detalles { get; set; }
	}
}