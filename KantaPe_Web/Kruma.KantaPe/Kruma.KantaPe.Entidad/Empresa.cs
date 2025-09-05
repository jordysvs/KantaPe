using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;
using System.Threading.Tasks;

namespace Kruma.KantaPe.Entidad
{
    /// <summary>Empresa</summary>
    /// <remarks><list type="bullet">
    /// <item><CreadoPor>Creado por Kruma</CreadoPor></item>
    /// <item><FecCrea>13-07-2016</FecCrea></item></list></remarks>

    [Serializable]
    [DataContract]
    public class Empresa : Kruma.Core.Business.Entity.Persona
    {
        public Empresa()
        {
        }

        [DataMember]
        public int? IdEmpresa
        {
            get { return this.IdPersona; }
            set { this.IdPersona = value; }
        }

        [DataMember]
        public string RUC
        {
            get { return this.NumeroDocumento; }
            set { this.NumeroDocumento = value; }
        }
    }
}