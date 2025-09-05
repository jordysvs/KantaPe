using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;
using System.Threading.Tasks;

namespace Kruma.KantaPe.Entidad
{
    /// <summary>Producto</summary>
    /// <remarks><list type="bullet">
    /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
    /// <item><FecCrea>12-07-2016</FecCrea></item></list></remarks>

    [Serializable]
    [DataContract]
    public class Producto
    {
        #region Propiedades

        [DataMember]
        public int? IdLocal { get; set; }
        [DataMember]
        public int? IdProducto { get; set; }
        [DataMember]
        public string Nombre { get; set; }
        [DataMember]
        public int? IdProductoTipo { get; set; }
        [DataMember]
        public decimal? Costo { get; set; }
        [DataMember]
        public decimal? Precio { get; set; }
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
        public DateTime? FechaModificacion { get; set; }
        [DataMember]
        public Kruma.KantaPe.Entidad.Local Local { get; set; }
        [DataMember]
        public List<LocalInsumo> Insumos { get; set; }
        [DataMember]
        public ProductoTipo ProductoTipo { get; set; }
        [DataMember]
        public string ImagenURL { get; set; }
        [DataMember]
        public Kruma.Core.FileServer.Entity.FileUpload Foto { get; set; }

        #endregion

        #region Constructor
        public Producto()
        {
            this.Insumos = new List<LocalInsumo>();
        }
        #endregion
    }
}