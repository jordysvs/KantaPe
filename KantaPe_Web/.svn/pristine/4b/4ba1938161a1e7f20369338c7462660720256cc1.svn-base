using System.ServiceModel;
using System.ServiceModel.Web;

namespace Kruma.KantaPe.Service.Interface
{
    [ServiceContract]
    public interface ILocalCancion
    {
        [OperationContract]
        [WebInvoke(
        Method = "GET",
        ResponseFormat = WebMessageFormat.Json,
        BodyStyle = WebMessageBodyStyle.Bare,
        UriTemplate = "Listar/{IdLocal}/{IdCancion}/{PalabraClave}/{NumPagina}/{TamPagina}")]
        Kruma.KantaPe.Service.Entity.ServiceResult<
            Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.LocalCancion>> Listar(
                    string IdLocal,
                    string IdCancion,
                    string PalabraClave,
                    string NumPagina,
                    string TamPagina
            );
        [OperationContract]
        [WebInvoke(
        Method = "GET",
        ResponseFormat = WebMessageFormat.Json,
        BodyStyle = WebMessageBodyStyle.Bare,
        UriTemplate = "ListarLista/{IdLocal}/{NumPagina}/{TamPagina}")]
        Kruma.KantaPe.Service.Entity.ServiceResult<
            Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.LocalCancion>> ListarLista(
                    string IdLocal,
                    string NumPagina,
                    string TamPagina
            );

        [OperationContract]
        [WebInvoke(
        Method = "GET",
        ResponseFormat = WebMessageFormat.Json,
        BodyStyle = WebMessageBodyStyle.Bare,
        UriTemplate = "ListarRanking/{IdLocal}/{NumPagina}/{TamPagina}")]
        Kruma.KantaPe.Service.Entity.ServiceResult<
            Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.LocalCancion>> ListarRanking(
                    string IdLocal,
                    string NumPagina,
                    string TamPagina
            );

        [OperationContract]
        [WebInvoke(
        Method = "GET",
        ResponseFormat = WebMessageFormat.Json,
        BodyStyle = WebMessageBodyStyle.Bare,
        UriTemplate = "ListarRankingFiltro/{IdLocal}/{IdGenero}/{IdIdioma}/{PalabraClave}/{NumPagina}/{TamPagina}")]
        Kruma.KantaPe.Service.Entity.ServiceResult<
            Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.LocalCancion>> ListarRankingFiltro(
                    string IdLocal,
                    string IdGenero,
                    string IdIdioma,
                    string PalabraClave,
                    string NumPagina,
                    string TamPagina
            );

        [OperationContract]
        [WebInvoke(
        Method = "GET",
        ResponseFormat = WebMessageFormat.Json,
        BodyStyle = WebMessageBodyStyle.Bare,
        UriTemplate = "ListarListaFiltro/{IdLocal}/{IdGenero}/{IdIdioma}/{PalabraClave}/{NumPagina}/{TamPagina}")]
        Kruma.KantaPe.Service.Entity.ServiceResult<
            Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.LocalCancion>> ListarListaFiltro(
                    string IdLocal,
                    string IdGenero,
                    string IdIdioma,
                    string PalabraClave,
                    string NumPagina,
                    string TamPagina
            );


        [OperationContract]
        [WebInvoke(
        Method = "GET",
        ResponseFormat = WebMessageFormat.Json,
        BodyStyle = WebMessageBodyStyle.Bare,
        UriTemplate = "ListarNovedades/{IdLocal}/{NumPagina}/{TamPagina}")]
        Kruma.KantaPe.Service.Entity.ServiceResult<
             Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.LocalCancion>> ListarNovedades(
                     string IdLocal,
                     string NumPagina,
                     string TamPagina
         );

        [OperationContract]
        [WebInvoke(
        Method = "GET",
        ResponseFormat = WebMessageFormat.Json,
        BodyStyle = WebMessageBodyStyle.Bare,
        UriTemplate = "ListarNovedadesFiltro/{IdLocal}/{IdGenero}/{IdIdioma}/{PalabraClave}/{NumPagina}/{TamPagina}")]
        Kruma.KantaPe.Service.Entity.ServiceResult<
            Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.LocalCancion>> ListarNovedadesFiltro(
                    string IdLocal,
                    string IdGenero,
                    string IdIdioma,
                    string PalabraClave,
                    string NumPagina,
                    string TamPagina
            );

        [OperationContract]
        [WebInvoke(
        Method = "GET",
        ResponseFormat = WebMessageFormat.Json,
        BodyStyle = WebMessageBodyStyle.Bare,
        UriTemplate = "ListarCancionesPorUsuario/{IdLocal}/{UsuarioLogeado}/{NumPagina}/{TamPagina}")]
        Kruma.KantaPe.Service.Entity.ServiceResult<
          Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.LocalCancion>> ListarCancionesPorUsuario(
                  string IdLocal,
                  string UsuarioLogeado,
                  string NumPagina,
                  string TamPagina
          );

        [OperationContract]
        [WebInvoke(
        Method = "GET",
        ResponseFormat = WebMessageFormat.Json,
        BodyStyle = WebMessageBodyStyle.Bare,
        UriTemplate = "ListarTodos/{IdGenero}/{IdIdioma}/{PalabraClave}/{NumPagina}/{TamPagina}")]
        Kruma.KantaPe.Service.Entity.ServiceResult<
        Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.LocalCancion>> ListarTodos(
            string IdGenero,
            string IdIdioma,
            string PalabraClave,
            string NumPagina,
            string TamPagina
    );
    }
}
