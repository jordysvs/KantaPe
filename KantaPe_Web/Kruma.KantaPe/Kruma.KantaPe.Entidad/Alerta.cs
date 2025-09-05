using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;
using System.Threading.Tasks;

namespace Kruma.KantaPe.Entidad
{
    /// <summary>Alerta</summary>
    /// <remarks><list type="bullet">
    /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
    /// <item><FecCrea>25-07-2016</FecCrea></item></list></remarks>
    [DataContract]
    [Serializable]
    public class Alerta
    {
        [DataMember]
        public int? IdLocal { get; set; }
        [DataMember]
        public int? IdUbicacion { get; set; }
        [DataMember]
        public int? IdAlerta { get; set; }
        [DataMember]
        public int? IdAlertaTipo { get; set; }
        [DataMember]
        public DateTime? FechaAlerta { get; set; }
        [DataMember]
        public DateTime? FechaAtencion { get; set; }
        [DataMember]
        public string IdUsuario { get; set; }
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
        public Kruma.KantaPe.Entidad.Local Local { get; set; }
        [DataMember]
        public Ubicacion Ubicacion { get; set; }
        [DataMember]
        public AlertaTipo AlertaTipo { get; set; }
        [DataMember]
        public Apertura Apertura { get; set; }
        [DataMember]
        public Kruma.Core.Security.Entity.Usuario Usuario { get; set; }
    }
}