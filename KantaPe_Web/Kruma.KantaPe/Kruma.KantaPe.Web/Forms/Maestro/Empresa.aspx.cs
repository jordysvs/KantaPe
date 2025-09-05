using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class Forms_Maestro_Empresa : System.Web.UI.Page
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
        obj_MasterPage.TituloPagina = "Empresa";

        ddlEstado.DataSource = Kruma.Core.Util.CommonUtil.ListarEstado();
        ddlEstado.DataValueField = "Code";
        ddlEstado.DataTextField = "Description";
        ddlEstado.DataBind();
        ddlEstado.Items.Insert(0, new ListItem("--Todos--", string.Empty));
    }

    #endregion

    #region Metodos Publicos

    [WebMethod]
    public static Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Empresa> ListarEmpresa(
        string str_pRUC,
        string str_pRazonSocial,
        string str_pNombreComercial,
        string str_pEstado,
        int? int_pNumPagina,
        int? int_pTamPagina)
    {
        return Kruma.KantaPe.Negocio.Empresa.Listar(null, null, str_pRUC, str_pRazonSocial, str_pNombreComercial, str_pEstado, int_pNumPagina, int_pTamPagina);
    }

    [WebMethod]
    public static Kruma.Core.Util.Common.ProcessResult ModificarEstado(
        int int_pIdEmpresa, string str_pEstado)
    {
        Kruma.KantaPe.Entidad.Empresa obj_Empresa = new Kruma.KantaPe.Entidad.Empresa();
        obj_Empresa.IdEmpresa = int_pIdEmpresa;
        obj_Empresa.Estado = str_pEstado;
        return Kruma.KantaPe.Negocio.Empresa.ModificarEstado(obj_Empresa);
    }

    #endregion
}