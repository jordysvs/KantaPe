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
    public interface ISolicitudCancion
    {
        [OperationContract]
        [WebInvoke(
            Method = "POST",
            RequestFormat = WebMessageFormat.Json,
            ResponseFormat = WebMessageFormat.Json,
            BodyStyle = WebMessageBodyStyle.Bare,
            UriTemplate = "Insertar")]
            Kruma.KantaPe.Service.Entity.ServiceResult<Kruma.Core.Util.Common.ProcessResult>
                Insertar(Kruma.KantaPe.Entidad.SolicitudCancion SolicitudCancion);
    }
}