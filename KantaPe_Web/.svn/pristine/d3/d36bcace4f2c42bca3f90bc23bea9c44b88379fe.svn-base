using System.ServiceModel;
using System.ServiceModel.Web;

namespace Kruma.KantaPe.Service.Interface
{
    [ServiceContract]
    public interface IGenero
    {
        //[OperationContract]
        //[WebInvoke(
        //Method = "GET",
        //ResponseFormat = WebMessageFormat.Json,
        //BodyStyle = WebMessageBodyStyle.Bare,
        //UriTemplate = "Listar/{IdGenero}/{Codigo}/{Descripcion}/{Estado}/{NumPagina}/{TamPagina}")]
        //Kruma.KantaPe.Service.Entity.ServiceResult<
        //    Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Genero>> Listar(
        //            string IdGenero,
        //            string Codigo,
        //            string Descripcion,
        //            string Estado,
        //            string NumPagina,
        //            string TamPagina
        //    );

        [OperationContract]
        [WebInvoke(
            Method = "GET", 
            ResponseFormat = WebMessageFormat.Json, 
            BodyStyle = WebMessageBodyStyle.Bare, 
            UriTemplate = "Listar")]
        Kruma.KantaPe.Service.Entity.ServiceResult<Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Genero>> Listar();


        [OperationContract]
        [WebInvoke(
         Method = "GET",
         ResponseFormat = WebMessageFormat.Json,
         BodyStyle = WebMessageBodyStyle.Bare,
         UriTemplate = "/ListarGeneroMusicalPorLocal/{IdLocal}")]
        Kruma.KantaPe.Service.Entity.ServiceResult<Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Genero>> ListarGeneroMusicalPorLocal(string IdLocal);

        [OperationContract]
        [WebInvoke(
            Method = "POST",
            RequestFormat = WebMessageFormat.Json,
            ResponseFormat = WebMessageFormat.Json,
            BodyStyle = WebMessageBodyStyle.Bare,
            UriTemplate = "Insertar")]
            Kruma.KantaPe.Service.Entity.ServiceResult<Kruma.Core.Util.Common.ProcessResult> Insertar(Kruma.KantaPe.Entidad.Genero Genero);
    }
}
