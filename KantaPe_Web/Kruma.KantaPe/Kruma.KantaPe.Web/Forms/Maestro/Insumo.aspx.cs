using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class Forms_Maestro_Insumo : System.Web.UI.Page
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
        obj_MasterPage.TituloPagina = "Insumo";

        ddlUnidadMedida.DataSource = Kruma.KantaPe.Negocio.UnidadMedida.Listar(null, null, Kruma.KantaPe.Entidad.Constante.Estado_Activo, null, null).Result.OrderBy(x => x.Descripcion);
        ddlUnidadMedida.DataValueField = "IdUnidadMedida";
        ddlUnidadMedida.DataTextField = "Descripcion";
        ddlUnidadMedida.DataBind();
        ddlUnidadMedida.Items.Insert(0, new ListItem("--Todos--", string.Empty));

        ddlEstado.DataSource = Kruma.Core.Util.CommonUtil.ListarEstado();
        ddlEstado.DataValueField = "Code";
        ddlEstado.DataTextField = "Description";
        ddlEstado.DataBind();
        ddlEstado.Items.Insert(0, new ListItem("--Todos--", string.Empty));
    }

    #endregion

    #region Metodos Publicos

    [WebMethod]
    public static Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Insumo> ListarInsumo(
        string str_pCodigo,
        string str_pDescripcion,
        int? int_pIdUnidadMedida,
        string str_pEstado,
        int? int_pNumPagina,
        int? int_pTamPagina)
    {
        return Kruma.KantaPe.Negocio.Insumo.Listar(null, str_pCodigo, str_pDescripcion, int_pIdUnidadMedida, str_pEstado, int_pNumPagina, int_pTamPagina);
    }

    [WebMethod]
    public static Kruma.Core.Util.Common.ProcessResult ModificarEstado(
        int int_pIdInsumo, string str_pEstado)
    {
        Kruma.KantaPe.Entidad.Insumo obj_Insumo = new Kruma.KantaPe.Entidad.Insumo();
        obj_Insumo.IdInsumo = int_pIdInsumo;
        obj_Insumo.Estado = str_pEstado;
        return Kruma.KantaPe.Negocio.Insumo.ModificarEstado(obj_Insumo);
    }

    #endregion
}