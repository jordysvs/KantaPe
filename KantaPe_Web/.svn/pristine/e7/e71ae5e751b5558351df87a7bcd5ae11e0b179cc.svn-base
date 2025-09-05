using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;
using System.Threading.Tasks;

namespace Kruma.KantaPe.Entidad
{
    /// <summary>Ubicacion</summary>
    /// <remarks><list type="bullet">
    /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
    /// <item><FecCrea>12-07-2016</FecCrea></item></list></remarks>

    [Serializable]
    [DataContract]
    public class Ubicacion
    {

        #region Constructor
        public Ubicacion()
        {
            this.Horarios = new List<Horario>();
        }

        #endregion

        #region Propiedades

        [DataMember]
        public int? IdLocal { get; set; }
        [DataMember]
        public int? IdUbicacion { get; set; }
        [DataMember]
        public int? IdUbicacionTipo { get; set; }
        [DataMember]
        public int? Numero { get; set; }
        [DataMember]
        public int? Capacidad { get; set; }
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
        public UbicacionTipo UbicacionTipo { get; set; }
        [DataMember]
        public List<Horario> Horarios { get; set; }
        [DataMember]
        public Apertura Apertura { get; set; }
        [DataMember]
        public Alerta Alerta { get; set; }
        [DataMember]
        public int? Cantidad { get; set; }
        #endregion

    }
}