using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Script.Serialization;
using System.Web.Services;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class Forms_Maestro_RegistroLocal : System.Web.UI.Page
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
        lnkEliminarFoto.ClientIDMode = System.Web.UI.ClientIDMode.Static;
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
        {
            obj_MasterPage.TituloPagina = "Agregar Local";
        }
        else
        {
            obj_MasterPage.TituloPagina = "Modificar Local";
            hdIdLocal.Value = Request.QueryString["id"];
        }

        //Lista de empresa
        List<Kruma.KantaPe.Entidad.Empresa> lst_Empresa = null;
        if (Kruma.Core.Security.SecurityManager.Usuario.Sistema == Kruma.Core.Security.Entity.Constante.Condicion_Positivo)
            lst_Empresa = Kruma.KantaPe.Negocio.Empresa.Listar(null, null, null, null, null, Kruma.KantaPe.Entidad.Constante.Estado_Activo, null, null).Result;
        else
        {
            List<Kruma.KantaPe.Entidad.Empleado> lst_Empleado = Kruma.KantaPe.Negocio.Empleado.Listar(null, null, Kruma.Core.Security.SecurityManager.Usuario.IdPersona.Value, null, null, null, null, Kruma.KantaPe.Entidad.Constante.Estado_Activo, null, null).Result;
            lst_Empresa = Kruma.KantaPe.Negocio.Empresa.Listar(null, null, null, null, null, Kruma.KantaPe.Entidad.Constante.Estado_Activo, null, null).Result;
            lst_Empresa = (from obj_Empresa in lst_Empresa
                           from obj_Empleado in lst_Empleado.Where(x => obj_Empresa.IdEmpresa == x.IdEmpresa).DefaultIfEmpty()
                           select obj_Empresa).ToList();
        }

        ddlEmpresa.DataSource = lst_Empresa;
        ddlEmpresa.DataValueField = "IdEmpresa";
        ddlEmpresa.DataTextField = "RazonSocial";
        ddlEmpresa.DataBind();
        ddlEmpresa.Items.Insert(0, new ListItem("--Seleccione--", string.Empty));

        //Ubigeo
        ddlDepartamento.Items.Insert(0, new ListItem("--Seleccione--", string.Empty));
        ddlProvincia.Items.Insert(0, new ListItem("--Seleccione--", string.Empty));
        ddlDistrito.Items.Insert(0, new ListItem("--Seleccione--", string.Empty));

        ddlEstado.DataSource = Kruma.Core.Util.CommonUtil.ListarEstado();
        ddlEstado.DataValueField = "Code";
        ddlEstado.DataTextField = "Description";
        ddlEstado.DataBind();
        ddlEstado.Items.Insert(0, new ListItem("--Seleccione--", string.Empty));

        //Id del almacen
        int int_IdAlmacen = int.Parse(Kruma.Core.Business.Logical.Parametro.Obtener(
        Kruma.Core.Business.Entity.Constante.Parametro.Modulo,
        Kruma.Core.Business.Entity.Constante.Parametro.Almacen_Temporal).Valor);
        hdIdAlmacen.Value = int_IdAlmacen.ToString();

        //Imagen por defecto
        string str_UrlImagen = string.Format("{0}{1}", Page.ResolveUrl("~"),
        Kruma.Core.Business.Logical.Parametro.Obtener(
        Kruma.Core.Business.Entity.Constante.Parametro.Modulo,
        "IMAGENMENU").Valor);
        hdLocalImagen.Value = str_UrlImagen;
        imgLocalImagen.ImageUrl = str_UrlImagen;
    }

    #endregion

    #region Metodos Publicos

    /// <summary>
    /// Obtiene los datos del local
    /// </summary>
    /// <param name="int_pIdLocal">Id del local</param>
    /// <remarks><list type="bullet">
    /// <item><CreadoPor>John Castillo</CreadoPor></item>
    /// <item><FecCrea>13/07/2016</FecCrea></item></list></remarks>
    [WebMethod]
    public static Kruma.KantaPe.Entidad.Local ObtenerLocal(int int_pIdLocal)
    {
        return Kruma.KantaPe.Negocio.Local.Obtener(int_pIdLocal);
    }

    /// <summary>
    /// Guarda la información del local
    /// </summary>
    /// <param name="str_pLocal">Json Local</param>
    /// <returns>Resultado del proceso</returns>
    /// <remarks><list type="bullet">
    /// <item><CreadoPor>John Castillo</CreadoPor></item>
    /// <item><FecCrea>13/07/2016</FecCrea></item></list></remarks>
    [WebMethod]
    public static Kruma.Core.Util.Common.ProcessResult GuardarLocal(string str_pLocal)
    {
        JavaScriptSerializer obj_JsSerializer = new JavaScriptSerializer();
        Kruma.KantaPe.Entidad.Local obj_Local = obj_JsSerializer.Deserialize<Kruma.KantaPe.Entidad.Local>(str_pLocal);
        obj_Local.UsuarioCreacion = Kruma.Core.Security.SecurityManager.Usuario.IdUsuario;
        obj_Local.UsuarioModificacion = obj_Local.UsuarioCreacion;

        Kruma.Core.Util.Common.ProcessResult obj_Resultado = null;
        if (!obj_Local.IdLocal.HasValue)
            obj_Resultado = Kruma.KantaPe.Negocio.Local.Insertar(obj_Local);
        else
            obj_Resultado = Kruma.KantaPe.Negocio.Local.Modificar(obj_Local);
        return obj_Resultado;
    }

    [WebMethod]
    public static List<Kruma.Core.Business.Entity.Ubigeo> ListarPais()
    {
        return Kruma.Core.Business.Logical.Ubigeo.ListarPais(
            null, Kruma.Core.Business.Entity.Constante.Estado_Activo, null, null).Result;
    }


    [WebMethod]
    public static List<Kruma.Core.Business.Entity.Ubigeo> ListarDepartamento(
        int int_pIdPais)
    {
        return Kruma.Core.Business.Logical.Ubigeo.ListarDepartamento(
            null, int_pIdPais, Kruma.Core.Business.Entity.Constante.Estado_Activo, null, null).Result;
    }

    [WebMethod]
    public static List<Kruma.Core.Business.Entity.Ubigeo> ListarProvincia(
        int int_pIdPais,
        int int_pIdDepartamento)
    {
        return Kruma.Core.Business.Logical.Ubigeo.ListarProvincia(
            null, int_pIdPais, int_pIdDepartamento, Kruma.Core.Business.Entity.Constante.Estado_Activo, null, null).Result;
    }

    [WebMethod]
    public static List<Kruma.Core.Business.Entity.Ubigeo> ListarDistrito(
        int int_pIdPais,
        int int_pIdDepartamento,
        int int_pIdProvincia)
    {
        return Kruma.Core.Business.Logical.Ubigeo.ListarDistrito(
            null, int_pIdPais, int_pIdDepartamento, int_pIdProvincia, Kruma.Core.Business.Entity.Constante.Estado_Activo, null, null).Result;
    }

    /// <summary>
    /// Permite obtener la URL de la imagen
    /// </summary>
    /// <param name="int_pIdRegistro">Id del registro</param>
    /// <returns>URL de la imagen</returns>
    /// <remarks><list type="bullet">
    /// <item><CreadoPor>John Castillo</CreadoPor></item>
    /// <item><FecCrea>16/08/2016</FecCrea></item></list></remarks>
    [WebMethod]
    public static string ObtenerImagenURL(int? int_pIdRegistro)
    {
        string str_UrlImagen = string.Empty;
        if (int_pIdRegistro.HasValue)
        {
            int? int_IdAlmacen = int.Parse(Kruma.Core.Business.Logical.Parametro.Obtener(
                Kruma.KantaPe.Entidad.Constante.Parametro.Modulo,
                Kruma.KantaPe.Entidad.Constante.Parametro.Almacen_Local).Valor);

            Kruma.Core.FileServer.FileServerManager obj_FileServerManager = new Kruma.Core.FileServer.FileServerManager();
            List<Kruma.Core.FileServer.Entity.FileUpload> lst_Fotos = obj_FileServerManager.getFiles(int_IdAlmacen.Value, int_pIdRegistro.Value);
            if (lst_Fotos.Count > 0)
            {
                str_UrlImagen = string.Format("../../Ashx/FileServerViewHandler.ashx?ref={0}",
                    new Kruma.Core.Criptography.CriptographyManager().Encrypt(
                    string.Format("{0}|{1}|{2}", lst_Fotos[0].IdAlmacen, lst_Fotos[0].IdRegistro, lst_Fotos[0].IdDocumento)
                    ));
            }
        }
        return str_UrlImagen;
    }

    #endregion
}