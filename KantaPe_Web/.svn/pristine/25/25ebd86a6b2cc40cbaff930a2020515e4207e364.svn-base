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
    public interface ILocal
    {

        [OperationContract]
        [WebInvoke(
        Method = "GET",
        ResponseFormat = WebMessageFormat.Json,
        BodyStyle = WebMessageBodyStyle.Bare,
        UriTemplate = "ListarLocal/{IdLocalCancion}/{IdPais}/{PalabraClave}/{NumPagina}/{TamPagina}")]
        Kruma.KantaPe.Service.Entity.ServiceResult<
        Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Local>> Listar(
            string IdLocalCancion,
            string IdPais,
            string PalabraClave,
            string NumPagina,
            string TamPagina);

        [OperationContract]
        [WebInvoke(
        Method = "GET",
        ResponseFormat = WebMessageFormat.Json,
        BodyStyle = WebMessageBodyStyle.Bare,
        UriTemplate = "ObtenerLocal/{IdLocal}")]
        Kruma.KantaPe.Service.Entity.ServiceResult<Kruma.KantaPe.Entidad.Local> Obtener(string IdLocal);

        [OperationContract]
        [WebInvoke(
        Method = "GET",
        ResponseFormat = WebMessageFormat.Json,
        BodyStyle = WebMessageBodyStyle.Bare,
        UriTemplate = "ListarPais")]
        Kruma.KantaPe.Service.Entity.ServiceResult<
        Kruma.Core.Util.Common.List<Kruma.Core.Business.Entity.Pais>> ListarPais();
    }
}
