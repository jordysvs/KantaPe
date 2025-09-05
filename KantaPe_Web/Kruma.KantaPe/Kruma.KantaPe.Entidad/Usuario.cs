using System;
using System.Runtime.Serialization;

namespace Kruma.KantaPe.Entidad
{
    /// <summary>Usuario</summary>
    /// <remarks><list type="bullet">
    /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
    /// <item><FecCrea>18-07-2016</FecCrea></item></list></remarks>

    [Serializable]
    [DataContract]
    public class Usuario : Kruma.Core.Security.Entity.Usuario
    {
        [DataMember]
        public string Nombres { get; set; }
        [DataMember]
        public string ApellidoPaterno { get; set; }
        [DataMember]
        public string ApellidoMaterno { get; set; }
        [DataMember]
        public string NombreCompleto { get; set; }
        [DataMember]
        public string Mail { get; set; }
        [DataMember]
        public DateTime? FechaNacimiento { get; set; }
        [DataMember]
        public int? IdTipoDocumento { get; set; }
        [DataMember]
        public string NumeroDocumento { get; set; }
        [DataMember]
        public int? IdEstadoCivil { get; set; }
        [DataMember]
        public Kruma.Core.Business.Entity.Genero? Genero { get; set; }
        [DataMember]
        public int? IdEmpresa { get; set; }
        [DataMember]
        public int? IdLocal { get; set; }
        [DataMember]
        public string DesEmpresa { get; set; }
        [DataMember]
        public string DesLocal { get; set; }
        [DataMember]
        public string FlagMozo { get; set; }
        [DataMember]
        public Empleado Empleado { get; set; }
        [DataMember]
        public string IdToken { get; set; }
        [DataMember]
        public string FechaNacimientoString { get; set; }
        [DataMember]
        public string FechaNacimientoFormat { get; set; }
    }
}
