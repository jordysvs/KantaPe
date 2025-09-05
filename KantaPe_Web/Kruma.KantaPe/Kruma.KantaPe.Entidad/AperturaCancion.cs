using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;
using System.Threading.Tasks;

namespace Kruma.KantaPe.Entidad
{
    /// <summary>AperturaCancion</summary>
    /// <remarks><list type="bullet">
    /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
    /// <item><FecCrea>25-07-2016</FecCrea></item></list></remarks>
    [DataContract]
    [Serializable]
    public class AperturaCancion
    {
        [DataMember]
        public int? IdLocal { get; set; }
        [DataMember]
        public int? IdApertura { get; set; }
        [DataMember]
        public int? IdAperturaCancion { get; set; }
        [DataMember]
        public int? IdAperturaCancionSolicitud { get; set; }
        [DataMember]
        public string IdUsuario { get; set; }
        [DataMember]
        public int? IdLocalCancion { get; set; }
        [DataMember]
        public int? IdAperturaCancionTipo { get; set; }
        [DataMember]
        public int? Orden { get; set; }
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
        public LocalCancion LocalCancion { get; set; }
        [DataMember]
        public Kruma.Core.Security.Entity.Usuario Usuario { get; set; }
        [DataMember]
        public AperturaCancionTipo AperturaCancionTipo { get; set; }
        [DataMember]
        public int? CantidadPedido { get; set; }
        [DataMember]
        public Artista Artista { get; set; }
        [DataMember]
        public Genero Genero { get; set; }
        [DataMember]
        public Idioma Idioma { get; set; }
    }
}