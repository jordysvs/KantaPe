using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Script.Serialization;
using System.Web.Services;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class Forms_Maestro_RegistroIdioma : System.Web.UI.Page
{
    #region Eventos

    /// <summary>
    /// Evento de carga de la pagina
    /// </summary>
    /// <remarks><list type="bullet">
    /// <item><CreadoPor>Carlos Gómez</CreadoPor></item>
    /// <item><FecCrea>01/07/2016</FecCrea></item></list></remarks>
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
        Master_Default obj_MasterPage = (Master_Default)this.Master;

        if (Request.QueryString["id"] == null)
            obj_MasterPage.TituloPagina = "Agregar Idioma";
        else
        {
            obj_MasterPage.TituloPagina = "Modificar Idioma";
            hdIdIdioma.Value = Request.QueryString["id"];
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
    /// Obtiene los datos del idioma
    /// </summary>
    /// <param name="int_pIdIdioma">Id del idioma</param>
    /// <remarks><list type="bullet">
    /// <item><CreadoPor>Carlos Gómez</CreadoPor></item>
    /// <item><FecCrea>01/07/2016</FecCrea></item></list></remarks>
    [WebMethod]
    public static Kruma.KantaPe.Entidad.Idioma ObtenerIdioma(int int_pIdIdioma)
    {
        return Kruma.KantaPe.Negocio.Idioma.Obtener(int_pIdIdioma);
    }

    /// <summary>
    /// Guarda la informacion del idioma
    /// </summary>
    /// <param name="str_pIdioma">Json Idioma</param>
    /// <returns>Resultado del proceso</returns>
    /// <remarks><list type="bullet">
    /// <item><CreadoPor>Carlos Gómez</CreadoPor></item>
    /// <item><FecCrea>01/07/2016</FecCrea></item></list></remarks>
    [WebMethod]
    public static Kruma.Core.Util.Common.ProcessResult GuardarIdioma(string str_pIdioma)
    {
        JavaScriptSerializer obj_JsSerializer = new JavaScriptSerializer();
        Kruma.KantaPe.Entidad.Idioma obj_Idioma = obj_JsSerializer.Deserialize<Kruma.KantaPe.Entidad.Idioma>(str_pIdioma);
        obj_Idioma.UsuarioCreacion = Kruma.Core.Security.SecurityManager.Usuario.IdUsuario;
        obj_Idioma.UsuarioModificacion = obj_Idioma.UsuarioCreacion;

        Kruma.Core.Util.Common.ProcessResult obj_Resultado = null;
        if (!obj_Idioma.IdIdioma.HasValue)
            obj_Resultado = Kruma.KantaPe.Negocio.Idioma.Insertar(obj_Idioma);
        else
            obj_Resultado = Kruma.KantaPe.Negocio.Idioma.Modificar(obj_Idioma);
        return obj_Resultado;
    }

    #endregion
}