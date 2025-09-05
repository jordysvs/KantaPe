using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Script.Serialization;
using System.Web.Services;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class Forms_Maestro_RegistroInsumo : System.Web.UI.Page
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
            obj_MasterPage.TituloPagina = "Agregar Insumo";
        }
        else
        {
            obj_MasterPage.TituloPagina = "Modificar Insumo";
            int_IdAlbum = int.Parse(Request.QueryString["id"]);
            hdIdInsumo.Value = int_IdAlbum.ToString();
        }

        ddlUnidadMedida.DataSource = Kruma.KantaPe.Negocio.UnidadMedida.Listar(null, null, Kruma.KantaPe.Entidad.Constante.Estado_Activo, null, null).Result.OrderBy(x => x.Descripcion);
        ddlUnidadMedida.DataValueField = "IdUnidadMedida";
        ddlUnidadMedida.DataTextField = "Descripcion";
        ddlUnidadMedida.DataBind();
        ddlUnidadMedida.Items.Insert(0, new ListItem("--Seleccione--", string.Empty));

        ddlEstado.DataSource = Kruma.Core.Util.CommonUtil.ListarEstado();
        ddlEstado.DataValueField = "Code";
        ddlEstado.DataTextField = "Description";
        ddlEstado.DataBind();
        ddlEstado.Items.Insert(0, new ListItem("--Seleccione--", string.Empty));
    }

    #endregion

    #region Metodos Publicos

    /// <summary>
    /// Obtiene los datos del insumo
    /// </summary>
    /// <param name="int_pIdInsumo">Id del insumo</param>
    /// <remarks><list type="bullet">
    /// <item><CreadoPor>John Castillo</CreadoPor></item>
    /// <item><FecCrea>13/07/2016</FecCrea></item></list></remarks>
    [WebMethod]
    public static Kruma.KantaPe.Entidad.Insumo ObtenerInsumo(int int_pIdInsumo)
    {
        return Kruma.KantaPe.Negocio.Insumo.Obtener(int_pIdInsumo);
    }

    /// <summary>
    /// Guarda la información del insumo
    /// </summary>
    /// <param name="str_pInsumo">Json Insumo</param>
    /// <returns>Resultado del proceso</returns>
    /// <remarks><list type="bullet">
    /// <item><CreadoPor>John Castillo</CreadoPor></item>
    /// <item><FecCrea>13/07/2016</FecCrea></item></list></remarks>
    [WebMethod]
    public static Kruma.Core.Util.Common.ProcessResult GuardarInsumo(string str_pInsumo)
    {
        JavaScriptSerializer obj_JsSerializer = new JavaScriptSerializer();
        Kruma.KantaPe.Entidad.Insumo obj_Insumo = obj_JsSerializer.Deserialize<Kruma.KantaPe.Entidad.Insumo>(str_pInsumo);
        obj_Insumo.UsuarioCreacion = Kruma.Core.Security.SecurityManager.Usuario.IdUsuario;
        obj_Insumo.UsuarioModificacion = obj_Insumo.UsuarioCreacion;

        Kruma.Core.Util.Common.ProcessResult obj_Resultado = null;
        if (!obj_Insumo.IdInsumo.HasValue)
            obj_Resultado = Kruma.KantaPe.Negocio.Insumo.Insertar(obj_Insumo);
        else
            obj_Resultado = Kruma.KantaPe.Negocio.Insumo.Modificar(obj_Insumo);
        return obj_Resultado;
    }

    #endregion
}