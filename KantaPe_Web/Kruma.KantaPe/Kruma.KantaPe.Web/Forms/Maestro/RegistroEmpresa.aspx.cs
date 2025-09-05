using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Script.Serialization;
using System.Web.Services;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class Forms_Maestro_RegistroEmpresa : System.Web.UI.Page
{
    #region Eventos

    /// <summary>
    /// Evento de carga de la pagina
    /// </summary>
    /// <remarks><list type="bullet">
    /// <item><CreadoPor>John Castillo</CreadoPor></item>
    /// <item><FecCrea>13/07/2016</FecCrea></item></list></remarks>
    protected void Page_Load(object sender, EventArgs e)
    {
        CargaInicial();
    }

    #endregion

    #region Metodos Privados

    /// <summary>
    /// Carga inicial del formulario
    /// </summary>
    private void CargaInicial()
    {
        int? int_IdAlbum = null;

        Master_Default obj_MasterPage = (Master_Default)this.Master;

        if (Request.QueryString["id"] == null)
        {
            obj_MasterPage.TituloPagina = "Agregar Empresa";
        }
        else
        {
            obj_MasterPage.TituloPagina = "Modificar Empresa";
            int_IdAlbum = int.Parse(Request.QueryString["id"]);
            hdIdEmpresa.Value = int_IdAlbum.ToString();
        }

        ddlEstado.DataSource = Kruma.Core.Util.CommonUtil.ListarEstado();
        ddlEstado.DataValueField = "Code";
        ddlEstado.DataTextField = "Description";
        ddlEstado.DataBind();
        ddlEstado.Items.Insert(0, new ListItem("--Seleccione--", string.Empty));
    }

    #endregion

    #region Metodos Publicos

    /// <summary>
    /// Obtiene los datos de la empresa
    /// </summary>
    /// <param name="int_pIdEmpresa">Id de la empresa</param>
    /// <remarks><list type="bullet">
    /// <item><CreadoPor>John Castillo</CreadoPor></item>
    /// <item><FecCrea>13/07/2016</FecCrea></item></list></remarks>
    [WebMethod]
    public static Kruma.KantaPe.Entidad.Empresa ObtenerEmpresa(int int_pIdEmpresa)
    {
        return Kruma.KantaPe.Negocio.Empresa.Obtener(int_pIdEmpresa);
    }

    /// <summary>
    /// Guarda la información de la empresa
    /// </summary>
    /// <param name="str_pEmpresa">Json Empresa</param>
    /// <returns>Resultado del proceso</returns>
    /// <remarks><list type="bullet">
    /// <item><CreadoPor>John Castillo</CreadoPor></item>
    /// <item><FecCrea>13/07/2016</FecCrea></item></list></remarks>
    [WebMethod]
    public static Kruma.Core.Util.Common.ProcessResult GuardarEmpresa(string str_pEmpresa)
    {
        JavaScriptSerializer obj_JsSerializer = new JavaScriptSerializer();
        Kruma.KantaPe.Entidad.Empresa obj_Empresa = obj_JsSerializer.Deserialize<Kruma.KantaPe.Entidad.Empresa>(str_pEmpresa);
        obj_Empresa.UsuarioCreacion = Kruma.Core.Security.SecurityManager.Usuario.IdUsuario;
        obj_Empresa.UsuarioModificacion = obj_Empresa.UsuarioCreacion;

        Kruma.Core.Util.Common.ProcessResult obj_Resultado = null;
        if (!obj_Empresa.IdEmpresa.HasValue)
            obj_Resultado = Kruma.KantaPe.Negocio.Empresa.Insertar(obj_Empresa);
        else
            obj_Resultado = Kruma.KantaPe.Negocio.Empresa.Modificar(obj_Empresa);
        return obj_Resultado;
    }

    #endregion
}