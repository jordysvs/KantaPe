using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;
using System.Threading.Tasks;

namespace Kruma.KantaPe.Entidad
{
    /// <summary>Oferta</summary>
    /// <remarks><list type="bullet">
    /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
    /// <item><FecCrea>12-07-2016</FecCrea></item></list></remarks>

    [Serializable]
    [DataContract]
    public class Oferta
    {
        [DataMember]
        public int? IdLocal { get; set; }
        [DataMember]
        public int? IdOferta { get; set; }
        [DataMember]
        public string Nombre { get; set; }
        [DataMember]
        public string Descripcion { get; set; }
        [DataMember]
        public DateTime? FechaOferta { get; set; }
        [DataMember]
        public DateTime? FechaVencimiento { get; set; }
        [DataMember]
        public int? IdImagen { get; set; }
        [DataMember]
        public string Estado { get; set; }
        [DataMember]
        public string UsuarioCreacion { get; set; }
        [DataMember]
        public DateTime? FechaCreacion { get; set; }
        [DataMember]
        public string UsuarioModificacion { get; set; }
        [DataMember]
        public DateTime? FechaModficacion { get; set; }
        [DataMember]
        public Kruma.KantaPe.Entidad.Local Local { get; set; }
        [DataMember]
        public Kruma.Core.FileServer.Entity.FileUpload Foto { get; set; }
        [DataMember]
        public string ImagenURL { get; set; }
        [DataMember]
        public string FlagPromocion { get; set; }
        [DataMember]
        public DateTime? FechaPromocion { get; set; }
    }
}