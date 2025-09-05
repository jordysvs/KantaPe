using System.ServiceModel;
using System.ServiceModel.Web;

namespace Kruma.KantaPe.Service.Interface
{
    [ServiceContract]
    public interface IIdioma
    {
        [OperationContract]
        [WebInvoke(
            Method = "GET",
            ResponseFormat = WebMessageFormat.Json,
            BodyStyle = WebMessageBodyStyle.Bare,
            UriTemplate = "Listar")]
        Kruma.KantaPe.Service.Entity.ServiceResult<
            Kruma.Core.Util.Common.List<
                Kruma.KantaPe.Entidad.Idioma>> Listar();

        [OperationContract]
        [WebInvoke(
           Method = "GET",
           ResponseFormat = WebMessageFormat.Json,
           BodyStyle = WebMessageBodyStyle.Bare,
           UriTemplate = "ListarIdiomaPorLocal/{IdLocal}")]
        Kruma.KantaPe.Service.Entity.ServiceResult<
           Kruma.Core.Util.Common.List<
               Kruma.KantaPe.Entidad.Idioma>> ListarIdiomaPorLocal(string IdLocal);
        
    }
}