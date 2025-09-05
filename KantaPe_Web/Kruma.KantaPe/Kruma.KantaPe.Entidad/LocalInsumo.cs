using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;
using System.Threading.Tasks;

namespace Kruma.KantaPe.Entidad
{
    /// <summary>LocalInsumo</summary>
    /// <remarks><list type="bullet">
    /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
    /// <item><FecCrea>12-07-2016</FecCrea></item></list></remarks>

    [Serializable]
    [DataContract]
    public class LocalInsumo
    {
        #region Propiedades

        [DataMember]
        public int? IdLocal { get; set; }
        [DataMember]
        public int? IdInsumo { get; set; }
        [DataMember]
        public int? Cantidad { get; set; }
        [DataMember]
        public int? Minimo { get; set; }
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
        public Insumo Local { get; set; }
        [DataMember]
        public Insumo Insumo { get; set; }

        #endregion

        #region Constructor
        public LocalInsumo()
        {

        }

        #endregion
    }
}