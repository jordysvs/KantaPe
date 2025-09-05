using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;
using System.Threading.Tasks;

namespace Kruma.KantaPe.Entidad
{
    /// <summary>Local</summary>
    /// <remarks><list type="bullet">
    /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
    /// <item><FecCrea>12-07-2016</FecCrea></item></list></remarks>

    [Serializable]
    [DataContract]
    public class Local : Kruma.Core.Business.Entity.PersonaDireccion
    {
        [DataMember]
        public Kruma.Core.FileServer.Entity.FileUpload Foto { get; set; }
        [DataMember]
        public string ImagenURL { get; set; }
        [DataMember]
        public int? IdLocal { get; set; }
        [DataMember]
        public int? IdEmpresa
        {
            get { return this.IdPersona; }
            set { this.IdPersona = value; }
        }
        [DataMember]
        public int? HoraInicio { get; set; }
        [DataMember]
        public int? HoraFin { get; set; }
        [DataMember]
        public decimal? Radio { get; set; }
        [DataMember]
        public Kruma.KantaPe.Entidad.Empresa Empresa { get; set; }
        [DataMember]
        public string Telefono { get; set; }
        [DataMember]
        public string Mail { get; set; }
        [DataMember]
        public string FlagLocalizacion { get; set; }
        [DataMember]
        public int Promocion { get; set; }
    }
}