using System;
using System.Collections.Generic;
using System.Runtime.Serialization;

namespace Kruma.KantaPe.Entidad
{
    /// <summary>Apertura</summary>
    /// <remarks><list type="bullet">
    /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
    /// <item><FecCrea>25-07-2016</FecCrea></item></list></remarks>

    [DataContract]
    [Serializable]
    public class Apertura
    {

        [DataMember]
        public int? IdLocal { get; set; }
        [DataMember]
        public int? IdApertura { get; set; }
        [DataMember]
        public int? IdMozo { get; set; }
        [DataMember]
        public DateTime? FechaApertura { get; set; }
        [DataMember]
        public DateTime? FechaFinal { get; set; }
        [DataMember]
        public decimal? Total { get; set; }
        [DataMember]
        public int? IdAlerta { get; set; }
        [DataMember]
        public int? Ronda { get; set; }
        [DataMember]
        public string FlagTurno { get; set; }
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
        public Local Local { get; set; }
        [DataMember]
        public Empleado Empleado { get; set; }
        [DataMember]
        public Alerta Alerta { get; set; }
        [DataMember]
        public List<AperturaCancion> Canciones { get; set; }
        [DataMember]
        public List<AperturaUsuario> Usuarios { get; set; }
        [DataMember]
        public List<AperturaUbicacion> Ubicaciones { get; set; }
        [DataMember]
        public Kruma.Core.Security.Entity.Usuario Usuario { get; set; }
        [DataMember]
        public string NombreCompleto { get; set; }
        [DataMember]
        public int? Cantidad;
        [DataMember]
        public int? DiferenciaFechas;

        [DataMember]
        public Ubicacion Ubicacion;

        public int? CantidadCanciones { get; set; }
        public Apertura()
        {
            this.Canciones = new List<AperturaCancion>();
            this.Usuarios = new List<AperturaUsuario>();
            this.Ubicaciones = new List<AperturaUbicacion>();
        }
    }
}