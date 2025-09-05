using System;
using System.Runtime.Serialization;

namespace Kruma.KantaPe.Entidad
{
    /// <summary>CancionSimple</summary>
    /// <remarks><list type="bullet">
    /// <item><CreadoPor>Creado por Vicente Gonzales Osorio</CreadoPor></item>
    /// <item><FecCrea>10-03-2017</FecCrea></item></list></remarks>

    [Serializable]
    [DataContract]
    public class Cancion
    {
        [DataMember]
        public int? IdCancion { get; set; }
        [DataMember]
        public string Descripcion { get; set; }
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
    }
}