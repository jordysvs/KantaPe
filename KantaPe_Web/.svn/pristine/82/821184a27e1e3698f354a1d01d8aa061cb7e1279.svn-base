using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;
using System.Threading.Tasks;

namespace Kruma.KantaPe.Entidad
{
    /// <summary>Horario</summary>
    /// <remarks><list type="bullet">
    /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
    /// <item><FecCrea>12-07-2016</FecCrea></item></list></remarks>

    [Serializable]
    [DataContract]
    public class Horario
    {
        [DataMember]
        public int? IdLocal { get; set; }
        [DataMember]
        public int? IdUbicacion { get; set; }
        [DataMember]
        public int? IdHorario { get; set; }
        [DataMember]
        public int? IdMozo { get; set; }
        [DataMember]
        public DayOfWeek? Dia { get; set; }
        [DataMember]
        public string Estado { get; set; }
        [DataMember]
        public string UsuarioCreacion { get; set; }
        [DataMember]
        public DateTime? FechaCreacion { get; set; }
        [DataMember]
        public string UsuarioModificacion { get; set; }
        [DataMember]
        public DateTime? FechaModificacion { get; set; }
        [DataMember]
        public Kruma.KantaPe.Entidad.Empleado Empleado { get; set; }
    }
}