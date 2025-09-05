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
    public interface IAperturaUsuario
    {
       
        [OperationContract]
        [WebInvoke(
        Method = "POST",
        RequestFormat = WebMessageFormat.Json,
        ResponseFormat = WebMessageFormat.Json,
        BodyStyle = WebMessageBodyStyle.Bare,
        UriTemplate = "Insertar")]
        Kruma.KantaPe.Service.Entity.ServiceResult<Kruma.Core.Util.Common.ProcessResult>
            Insertar(Kruma.KantaPe.Entidad.AperturaUsuario AperturaUsuario);

        [OperationContract]
        [WebInvoke(
       Method = "GET",
       ResponseFormat = WebMessageFormat.Json,
       BodyStyle = WebMessageBodyStyle.Bare,
       UriTemplate = "ListarAperturaUsuario/{IdLocal}/{IdApertura}")]
        Kruma.KantaPe.Service.Entity.ServiceResult<
           Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.AperturaUsuario>> ListarAperturaUsuario(
                   string IdLocal,
                   string IdApertura
           );

        [OperationContract]
        [WebInvoke(
              Method = "POST",
              RequestFormat = WebMessageFormat.Json,
              ResponseFormat = WebMessageFormat.Json,
              BodyStyle = WebMessageBodyStyle.Bare,
              UriTemplate = "ModificarAperturaCancion")]
        Kruma.KantaPe.Service.Entity.ServiceResult<Kruma.Core.Util.Common.ProcessResult>
                  ModificarAperturaCancion(Kruma.KantaPe.Entidad.AperturaCancion AperturaCancion);

        [OperationContract]
        [WebInvoke(
        Method = "POST",
        RequestFormat = WebMessageFormat.Json,
        ResponseFormat = WebMessageFormat.Json,
        BodyStyle = WebMessageBodyStyle.Bare,
        UriTemplate = "Modificar")]
        Kruma.KantaPe.Service.Entity.ServiceResult<Kruma.Core.Util.Common.ProcessResult>
            Modificar(Kruma.KantaPe.Entidad.AperturaUsuario AperturaUsuario);

        [OperationContract]
        [WebInvoke(
        Method = "GET",
        ResponseFormat = WebMessageFormat.Json,
        BodyStyle = WebMessageBodyStyle.Bare,
        UriTemplate = "Obtener/{IdLocal}/{IdApertura}/{IdAperturaUsuario}/{IdUsuario}")]
        Kruma.KantaPe.Service.Entity.ServiceResult<Kruma.KantaPe.Entidad.AperturaUsuario> Obtener(string IdLocal,
                   string IdApertura, string IdAperturaUsuario, string IdUsuario);

        [OperationContract]
        [WebInvoke(
        Method = "GET",
        ResponseFormat = WebMessageFormat.Json,
        BodyStyle = WebMessageBodyStyle.Bare,
        UriTemplate = "ObtenerEstadoAperturaUsuario/{IdLocal}/{IdApertura}/{IdAperturaUsuario}/{IdUsuario}")]
        Kruma.KantaPe.Service.Entity.ServiceResult<Kruma.KantaPe.Entidad.AperturaUsuario> ObtenerEstadoAperturaUsuario(string IdLocal,
                   string IdApertura, string IdAperturaUsuario, string IdUsuario);
    }
}
