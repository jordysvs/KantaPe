using System;
using System.Runtime.Serialization;

namespace Kruma.KantaPe.Entidad
{
    /// <summary>Genero</summary>
    /// <remarks><list type="bullet">
    /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
    /// <item><FecCrea>29-06-2016</FecCrea></item></list></remarks>

    [Serializable]
    [DataContract]
    public class Genero
    {
        [DataMember]
        public int? IdGenero { get; set; }
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