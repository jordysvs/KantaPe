using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;
using System.Threading.Tasks;

namespace Kruma.KantaPe.Entidad
{
    /// <summary>Album</summary>
    /// <remarks><list type="bullet">
    /// <item><CreadoPor>Creado por Carlos Gómez</CreadoPor></item>
    /// <item><FecCrea>02-07-2016</FecCrea></item></list></remarks>

    [Serializable]
    [DataContract]
    public class Album
    {
        [DataMember]
        public int? IdAlbum { get; set; }
        [DataMember]
        public int? IdArtista { get; set; }
        [DataMember]
        public string Titulo { get; set; }
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
        public Artista Artista { get; set; }
        [DataMember]
        public Kruma.Core.FileServer.Entity.FileUpload Foto { get; set; }
        [DataMember]
        public string ImagenURL { get; set; }

    }
}
