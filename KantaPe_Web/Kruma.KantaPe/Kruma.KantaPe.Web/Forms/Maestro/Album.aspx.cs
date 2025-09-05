using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class Forms_Maestro_Album : System.Web.UI.Page
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
        obj_MasterPage.TituloPagina = "Álbum";

        ddlEstado.DataSource = Kruma.Core.Util.CommonUtil.ListarEstado();
        ddlEstado.DataValueField = "Code";
        ddlEstado.DataTextField = "Description";
        ddlEstado.DataBind();

        ddlEstado.Items.Insert(0, new ListItem("--Todos--", string.Empty));
    }

    #endregion

    #region Metodos Publicos

    [WebMethod]
    public static object ListarAlbum(
        int? int_pIdArtista, string str_pArtistaNombre, string str_pTitulo, string str_pEstado, int? int_pNumPagina, int? int_pTamPagina)
    {
        string str_Sistema = Kruma.Core.Security.SecurityManager.Usuario.Sistema;
        if (str_Sistema == Kruma.Core.Security.Entity.Constante.Condicion_Positivo)
            str_Sistema = string.Empty;
        return Kruma.KantaPe.Negocio.Album.Listar(int_pIdArtista, str_pArtistaNombre, str_pTitulo, str_pEstado, int_pNumPagina, int_pTamPagina);
    }

    [WebMethod]
    public static Kruma.Core.Util.Common.ProcessResult ModificarEstado(
        int int_pIdAlbum, string str_pEstado)
    {
        Kruma.KantaPe.Entidad.Album obj_Album = new Kruma.KantaPe.Entidad.Album();
        obj_Album.IdAlbum = int_pIdAlbum;
        obj_Album.Estado = str_pEstado;
        return Kruma.KantaPe.Negocio.Album.ModificarEstado(obj_Album);
    }

    #endregion
}