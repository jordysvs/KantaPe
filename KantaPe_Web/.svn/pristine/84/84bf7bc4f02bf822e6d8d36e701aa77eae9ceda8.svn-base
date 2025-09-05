using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Script.Serialization;
using System.Web.Services;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class Forms_Maestro_RegistroCancionMaestro : System.Web.UI.Page
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
            obj_MasterPage.TituloPagina = "Agregar Canción";
        else
        {
            obj_MasterPage.TituloPagina = "Modificar Canción";
            hdIdCancion.Value = Request.QueryString["id"];
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
    /// <param name="int_pIdCancion">Id del género</param>
    /// <remarks><list type="bullet">
    /// <item><CreadoPor>Carlos Gómez</CreadoPor></item>
    /// <item><FecCrea>01/07/2016</FecCrea></item></list></remarks>
    [WebMethod]
    public static Kruma.KantaPe.Entidad.Cancion ObtenerCancion(int int_pIdCancion)
    {
        return Kruma.KantaPe.Negocio.Cancion.Obtener(int_pIdCancion);
    }

    /// <summary>
    /// Guarda la informacion del Cancion
    /// </summary>
    /// <param name="str_pCancion">Json Cancion</param>
    /// <returns>Resultado del proceso</returns>
    /// <remarks><list type="bullet">
    /// <item><CreadoPor>Carlos Gómez</CreadoPor></item>
    /// <item><FecCrea>30/05/2016</FecCrea></item></list></remarks>
    [WebMethod]
    public static Kruma.Core.Util.Common.ProcessResult GuardarCancion(string str_pCancion)
    {
        JavaScriptSerializer obj_JsSerializer = new JavaScriptSerializer();
        Kruma.KantaPe.Entidad.Cancion obj_Cancion = obj_JsSerializer.Deserialize<Kruma.KantaPe.Entidad.Cancion>(str_pCancion);
        obj_Cancion.UsuarioCreacion = Kruma.Core.Security.SecurityManager.Usuario.IdUsuario;
        obj_Cancion.UsuarioModificacion = obj_Cancion.UsuarioCreacion;

        Kruma.Core.Util.Common.ProcessResult obj_Resultado = null;
        if (!obj_Cancion.IdCancion.HasValue)
            obj_Resultado = Kruma.KantaPe.Negocio.Cancion.Insertar(obj_Cancion);
        else
            obj_Resultado = Kruma.KantaPe.Negocio.Cancion.Modificar(obj_Cancion);
        return obj_Resultado;
    }

    #endregion
}