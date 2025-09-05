using Kruma.Core.Business.Entity;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;
using System.Threading.Tasks;

namespace Kruma.KantaPe.Entidad
{
    /// <summary>Empleado</summary>
    /// <remarks><list type="bullet">
    /// <item><CreadoPor>Creado por Kruma</CreadoPor></item>
    /// <item><FecCrea>13-07-2016</FecCrea></item></list></remarks>

    [Serializable]
    [DataContract]
    public class Empleado
    {
        [DataMember]
        public int? IdEmpleado { get; set; }
        [DataMember]
        public int? IdPersona { get; set; }
        [DataMember]
        public int? IdEmpresa { get; set; }
        [DataMember]
        public int? IdLocal { get; set; }
        [DataMember]
        public int? IdArea { get; set; }
        [DataMember]
        public int? IdPuesto { get; set; }
        [DataMember]
        public DateTime? FechaIngreso { get; set; }
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
        public Persona Persona { get; set; }
        [DataMember]
        public Empresa Empresa { get; set; }
        [DataMember]
        public Local Local { get; set; }
    }
}