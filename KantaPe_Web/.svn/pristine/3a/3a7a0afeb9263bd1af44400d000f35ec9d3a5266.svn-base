using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;
using System.Threading.Tasks;

namespace Kruma.KantaPe.Service.Entity
{
    [DataContract]
    [Serializable]
    public class ServiceResult<T>
    {
        #region Propiedades

        [DataMember]
        public T Resultado { get; set; }

        [DataMember]
        public string Mensaje { get; set; }

        #endregion

        #region Constructores

        public ServiceResult() { }

        public ServiceResult(string str_pMensaje) { this.Mensaje = str_pMensaje; }

        public ServiceResult(T obj_pResultado) { this.Resultado = obj_pResultado;
                                                 this.Mensaje = string.Empty;
        }

        #endregion
    }
}