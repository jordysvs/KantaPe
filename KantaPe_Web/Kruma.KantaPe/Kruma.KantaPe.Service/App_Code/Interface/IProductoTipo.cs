using System.ServiceModel;
using System.ServiceModel.Web;

namespace Kruma.KantaPe.Service.Interface
{
    [ServiceContract]
    public interface IProductoTipo
    {
        [OperationContract]
        [WebInvoke(
            Method = "GET",
            ResponseFormat = WebMessageFormat.Json,
            BodyStyle = WebMessageBodyStyle.Bare,
            UriTemplate = "Listar")]
        Kruma.KantaPe.Service.Entity.ServiceResult<
            Kruma.Core.Util.Common.List<
                Kruma.KantaPe.Entidad.ProductoTipo>> Listar();
    }
}