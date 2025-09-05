using System.ServiceModel;
using System.ServiceModel.Web;

namespace Kruma.KantaPe.Service.Interface
{
    [ServiceContract]
    public interface IProducto
    {

        [OperationContract]
        [WebInvoke(
        Method = "GET",
        ResponseFormat = WebMessageFormat.Json,
        BodyStyle = WebMessageBodyStyle.Bare,
        UriTemplate = "Listar/{IdEmpresa}/{IdLocal}/{IdProducto}/{Nombre}/{IdProductoTipo}/{NumPagina}/{TamPagina}")]
        Kruma.KantaPe.Service.Entity.ServiceResult<
            Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Producto>> Listar(
                    string IdEmpresa,
                    string IdLocal,
                    string IdProducto,
                    string Nombre,
                    string IdProductoTipo,
                    string NumPagina,
                    string TamPagina
            );

        [OperationContract]
        [WebInvoke(
       Method = "POST",
       RequestFormat = WebMessageFormat.Json,
       ResponseFormat = WebMessageFormat.Json,
       BodyStyle = WebMessageBodyStyle.Bare,
       UriTemplate = "SolicitarPedido")]
        Kruma.KantaPe.Service.Entity.ServiceResult<Kruma.Core.Util.Common.ProcessResult>
           SolicitarPedido(Kruma.KantaPe.Entidad.Alerta Alerta);

    }

    
    
       

}