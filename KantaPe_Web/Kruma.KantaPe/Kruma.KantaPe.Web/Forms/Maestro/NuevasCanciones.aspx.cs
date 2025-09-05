using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class Forms_Maestro_NuevasCanciones : System.Web.UI.Page
{
    #region Eventos

    /// <summary>
    /// Carga inicial de la pagina
    /// </summary>
    /// <param name="sender"></param>
    /// <param name="e"></param>
    protected void Page_Load(object sender, EventArgs e)
    {
        if (!IsPostBack)
            CargaInicial();
    }

    #endregion

    #region Metodos Privados

    /// <summary>
    /// Carga inicial del formulario
    /// </summary>
    private void CargaInicial()
    {
        Master_Default obj_MasterPage = (Master_Default)this.Master;
        obj_MasterPage.TituloPagina = "Nuevas Canciones";

    }

    #endregion

    [WebMethod]
    public static Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.SolicitudCancion> ListarCancionesNuevas(
        string str_pTitulo, string str_pArtista, string str_pAlbum, string str_pGenero, string str_pIdioma, string str_pEstado,
        int? int_pNumPagina, int? int_pTamPagina)
    {
        return Kruma.KantaPe.Negocio.SolicitudCancion.Listar(null, str_pTitulo, str_pArtista, str_pAlbum, str_pIdioma, str_pGenero, null, str_pEstado, int_pNumPagina, int_pTamPagina);
    }

    [WebMethod]
    public static Kruma.Core.Util.Common.ProcessResult RechazarSolicitud(int? int_pIdSolicitudCancion, string str_pMotivo)
    {

        Kruma.Core.Util.Common.ProcessResult obj_Resultado = null;
        obj_Resultado = Kruma.KantaPe.Negocio.LocalCancion.RechazarSolicitud(int_pIdSolicitudCancion, str_pMotivo);

        return obj_Resultado;
    }
}