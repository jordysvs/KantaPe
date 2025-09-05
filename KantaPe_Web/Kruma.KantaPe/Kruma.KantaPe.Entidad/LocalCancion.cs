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
    public class LocalCancion
    {
        [DataMember]
        public int? IdLocalCancion { get; set; }
        [DataMember]
        public int? IdCancion { get; set; }
        [DataMember]
        public int? IdArtista { get; set; }
        [DataMember]
        public int? IdAlbum { get; set; }
        [DataMember]
        public int? IdGenero { get; set; }
        [DataMember]
        public int? IdIdioma { get; set; }
        [DataMember]
        public string Decada { get; set; }
        [DataMember]
        public string Version { get; set; }
        [DataMember]
        public string NombreArchivo { get; set; }
        [DataMember]
        public DateTime? FechaRegistro { get; set; }
        [DataMember]
        public int? Anio { get; set; }
        [DataMember]
        public string Letra { get; set; }
        [DataMember]
        public int? Duracion { get; set; }
        [DataMember]
        public string Youtube { get; set; }
        [DataMember]
        public int? IdCancionSolicitud { get; set; }
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
        public Album Album { get; set; }
        [DataMember]
        public Genero Genero { get; set; }
        [DataMember]
        public Idioma Idioma { get; set; }
        [DataMember]
        public CancionSolicitud CancionSolicitud { get; set; }
        [DataMember]
        public Cancion Cancion { get; set; }

        [DataMember]
        public int? IdEmpresa { get; set; }
        [DataMember]
        public int? IdLocal { get; set; }

        [DataMember]
        public string DesEmpresa { get; set; }
        [DataMember]
        public string DesLocal { get; set; }

        [DataMember]
        public Local Local { get; set; }
        //[DataMember]
        //public string ArtistaNombre { get; set; }
        //[DataMember]
        //public string AlbumTitulo { get; set; }
        //[DataMember]
        //public string GeneroDescripcion { get; set; }
        //[DataMember]
        //public string IdiomaDescripcion { get; set; }
        //[DataMember]
        //public string CancionSolicitudDescripcion { get; set; }
        [DataMember]
        public Kruma.Core.FileServer.Entity.FileUpload Foto { get; set; }
        [DataMember]
        public string ImagenURL { get; set; }
        [DataMember]
        public LocalCancionTemporal LocalCancionTemporal { get; set; }
    }
}
