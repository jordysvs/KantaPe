using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.ServiceModel.Web;
using System.Text;

namespace Kruma.KantaPe.Service.Interface
{
    [ServiceContract]
    public interface IUbicacion
    {
        [OperationContract]
        [WebInvoke(
        Method = "GET",
        ResponseFormat = WebMessageFormat.Json,
        BodyStyle = WebMessageBodyStyle.Bare,
        UriTemplate = "Obtener/{IdLocal}/{IdUbicacion}")]
        Kruma.KantaPe.Service.Entity.ServiceResult<Kruma.KantaPe.Entidad.Ubicacion> Obtener(string IdLocal, string IdUbicacion);

        [OperationContract]
        [WebInvoke(
        Method = "POST",
        ResponseFormat = WebMessageFormat.Json,
        BodyStyle = WebMessageBodyStyle.Bare,
        UriTemplate = "ObtenerQR")]
            Kruma.KantaPe.Service.Entity.ServiceResult<Kruma.KantaPe.Entidad.Ubicacion> ObtenerQR(string QR);
    }
}
