using System;
using System.Runtime.Serialization;

namespace Kruma.KantaPe.Entidad
{
    /// <summary>LocalCancion</summary>
    /// <remarks><list type="bullet">
    /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
    /// <item><FecCrea>12-07-2016</FecCrea></item></list></remarks>

    [Serializable]
    [DataContract]
    public class LocalCancion_old
    {
        [DataMember]
        public int? IdLocal { get; set; }
        [DataMember]
        public int? IdCancion { get; set; }
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
        public Local Local { get; set; }
        [DataMember]
        public LocalCancion Cancion { get; set; }
        [DataMember]
        public Cancion CancionSimple { get; set; }
    }
}