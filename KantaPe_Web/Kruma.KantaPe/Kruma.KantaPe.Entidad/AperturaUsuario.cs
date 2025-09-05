using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;
using System.Threading.Tasks;

namespace Kruma.KantaPe.Entidad
{
    /// <summary>AperturaUsuario</summary>
    /// <remarks><list type="bullet">
    /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
    /// <item><FecCrea>25-07-2016</FecCrea></item></list></remarks>
    [DataContract]
    [Serializable]
    public class AperturaUsuario
    {
        [DataMember]
        public int? IdLocal { get; set; }
        [DataMember]
        public int? IdApertura { get; set; }
        [DataMember]
        public int? IdAperturaUsuario { get; set; }
        [DataMember]
        public string IdUsuario { get; set; }
        [DataMember]
        public string Administrador { get; set; }
        [DataMember]
        public decimal? Latitud { get; set; }
        [DataMember]
        public decimal? Longitud { get; set; }
        [DataMember]
        public DateTime? FechaIngreso { get; set; }
        [DataMember]
        public DateTime? FechaFinal { get; set; }
        [DataMember]
        public string Estado { get; set; }
        [DataMember]
        public string NombreCompleto { get; set; }
        [DataMember]
        public Local Local { get; set; }
        [DataMember]
        public Empresa Empresa { get; set; }
        [DataMember]
        public int? Cantidad { get; set; }
        [DataMember]
        public Kruma.Core.Business.Entity.Persona Persona { get; set; }
        [DataMember]
        public string UsuarioCreacion { get; set; }
        [DataMember]
        public DateTime? FechaCreacion { get; set; }
        [DataMember]
        public string UsuarioModificacion { get; set; }
        [DataMember]
        public DateTime? FechaModificacion { get; set; }
        [DataMember]
        public Kruma.Core.Security.Entity.Usuario  Usuario { get; set; }
    }
}