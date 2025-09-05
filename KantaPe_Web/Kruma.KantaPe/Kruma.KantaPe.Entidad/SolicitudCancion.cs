using System;
using System.Runtime.Serialization;

namespace Kruma.KantaPe.Entidad
{
    /// <summary>SolicitudCancion</summary>
    /// <remarks><list type="bullet">
    /// <item><CreadoPor>Creado por Carlos Gómez</CreadoPor></item>
    /// <item><FecCrea>24-08-2016</FecCrea></item></list></remarks>

    [Serializable]
    [DataContract]
    public class SolicitudCancion
    {
        [DataMember]
        public int? IdSolicitudCancion { get; set; }
        [DataMember]
        public string Cancion { get; set; }
        [DataMember]
        public string Artista { get; set; }
        [DataMember]
        public string Album { get; set; }
        [DataMember]
        public string Idioma { get; set; }
        [DataMember]
        public string Genero { get; set; }
        [DataMember]
        public string Youtube { get; set; }
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
        public string Motivo { get; set; }
        [DataMember]
        public string NombreCompleto { get; set; }
        [DataMember]
        public int? Cantidad { get; set; }
    }
}
