using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Script.Serialization;
using System.Web.Services;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class Forms_Maestro_RegistroGenero : System.Web.UI.Page
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
            obj_MasterPage.TituloPagina = "Agregar Género";
        else
        {
            obj_MasterPage.TituloPagina = "Modificar Género";
            hdIdGenero.Value = Request.QueryString["id"];
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
    /// Obtiene los datos del género
    /// </summary>
    /// <param name="int_pIdGenero">Id del género</param>
    /// <remarks><list type="bullet">
    /// <item><CreadoPor>Carlos Gómez</CreadoPor></item>
    /// <item><FecCrea>01/07/2016</FecCrea></item></list></remarks>
    [WebMethod]
    public static Kruma.KantaPe.Entidad.Genero ObtenerGenero(int int_pIdGenero)
    {
        return Kruma.KantaPe.Negocio.Genero.Obtener(int_pIdGenero);
    }

    /// <summary>
    /// Guarda la informacion del genero
    /// </summary>
    /// <param name="str_pGenero">Json Genero</param>
    /// <returns>Resultado del proceso</returns>
    /// <remarks><list type="bullet">
    /// <item><CreadoPor>Carlos Gómez</CreadoPor></item>
    /// <item><FecCrea>30/05/2016</FecCrea></item></list></remarks>
    [WebMethod]
    public static Kruma.Core.Util.Common.ProcessResult GuardarGenero(string str_pGenero)
    {
        JavaScriptSerializer obj_JsSerializer = new JavaScriptSerializer();
        Kruma.KantaPe.Entidad.Genero obj_Genero = obj_JsSerializer.Deserialize<Kruma.KantaPe.Entidad.Genero>(str_pGenero);
        obj_Genero.UsuarioCreacion = Kruma.Core.Security.SecurityManager.Usuario.IdUsuario;
        obj_Genero.UsuarioModificacion = obj_Genero.UsuarioCreacion;

        Kruma.Core.Util.Common.ProcessResult obj_Resultado = null;
        if (!obj_Genero.IdGenero.HasValue)
            obj_Resultado = Kruma.KantaPe.Negocio.Genero.Insertar(obj_Genero);
        else
            obj_Resultado = Kruma.KantaPe.Negocio.Genero.Modificar(obj_Genero);
        return obj_Resultado;
    }

    #endregion
}