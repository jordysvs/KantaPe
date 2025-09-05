using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Script.Serialization;
using System.Web.Services;
using System.Web.UI;
using System.Web.UI.WebControls;
using Kruma.Core.Security;

public partial class Forms_Configuracion_RegistroEvento : System.Web.UI.Page
{
    #region Eventos

    /// <summary>
    /// Evento de carga de la pagina
    /// </summary>
    /// <remarks><list type="bullet">
    /// <item><CreadoPor>John Castillo</CreadoPor></item>
    /// <item><FecCrea>08/08/2016</FecCrea></item></list></remarks>
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
            obj_MasterPage.TituloPagina = "Agregar Evento";
        else
        {
            obj_MasterPage.TituloPagina = "Modificar Evento";
            hdIdLocal.Value = Request.QueryString["id"];
            hdIdEvento.Value = Request.QueryString["id2"];
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

        //Empresa
        //ddlEmpresa.DataSource = Kruma.Core.Business.Logical.Persona.Listar(null, 2, null, null, null, null, null, null).Result;
        ddlEmpresa.DataSource = Kruma.KantaPe.Negocio.Empresa.Listar(null, null, null, null, null, Kruma.KantaPe.Entidad.Constante.Estado_Activo, null, null).Result;
        ddlEmpresa.DataValueField = "IdPersona";
        ddlEmpresa.DataTextField = "NombreComercial";
        ddlEmpresa.DataBind();
        ddlEmpresa.Items.Insert(0, new ListItem("--Todos--", string.Empty));


        //VALIDAR
        List<Kruma.Core.Security.Entity.PerfilUsuario> lstPerfiles = Kruma.Core.Security.Data.PerfilUsuario.Listar(Kruma.Core.Security.SecurityManager.Usuario.IdUsuario, null, null, Kruma.KantaPe.Entidad.Constante.Estado_Activo);
        if (lstPerfiles.Count > 0)
        {
            Boolean bool_EsAdministrador = false;
            hdEsAdministrador.Value = "N";
            for (int i = 0; i < lstPerfiles.Count; i++)
            {
                if (lstPerfiles[i].IdPerfil == "ADMINISTRADOR")
                {
                    bool_EsAdministrador = true;
                    hdEsAdministrador.Value = "S";
                }
            }
            if (!bool_EsAdministrador)
            {
                List<Kruma.KantaPe.Entidad.Usuario> lst_Usuario = Kruma.KantaPe.Data.Usuario.Listar(SecurityManager.Usuario.IdUsuario, null, SecurityManager.Usuario.IdPersona, null, null, null, null, null, null, null, null, null).Result;
                if (lst_Usuario.Count > 0)
                {
                    ddlEmpresa.SelectedValue = lst_Usuario[0].IdEmpresa.ToString();

                    hdIdLocalValidar.Value = lst_Usuario[0].IdLocal.ToString();
                    hdIdEmpresa.Value = lst_Usuario[0].IdEmpresa.ToString();
                }
            }
        }
        //Local
        ddlLocal.Items.Insert(0, new ListItem("--Seleccione--", string.Empty));

        //Estado
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
        hdEventoImagen.Value = str_UrlImagen;
        imgEventoImagen.ImageUrl = str_UrlImagen;
    }
    #endregion

    #region Metodos Publicos

    /// <summary>
    /// Obtiene los datos del evento
    /// </summary>
    /// <param name="int_pIdEvento">Id del evento</param>
    /// <remarks><list type="bullet">
    /// <item><CreadoPor>John Castillo</CreadoPor></item>
    /// <item><FecCrea>08/08/2016</FecCrea></item></list></remarks>
    [WebMethod]
    public static Kruma.KantaPe.Entidad.Evento ObtenerEvento(
        int int_pIdLocal,
        int int_pIdEvento)
    {
        return Kruma.KantaPe.Negocio.Evento.Obtener(int_pIdLocal, int_pIdEvento);
    }

    /// <summary>
    /// Guarda la información del evento
    /// </summary>
    /// <param name="str_pEvento">Json Evento</param>
    /// <returns>Resultado del proceso</returns>
    /// <remarks><list type="bullet">
    /// <item><CreadoPor>John Castillo</CreadoPor></item>
    /// <item><FecCrea>08/08/2016</FecCrea></item></list></remarks>
    [WebMethod]
    public static Kruma.Core.Util.Common.ProcessResult GuardarEvento(string str_pEvento)
    {
        JavaScriptSerializer obj_JsSerializer = new JavaScriptSerializer();
        Kruma.KantaPe.Entidad.Evento obj_Evento = obj_JsSerializer.Deserialize<Kruma.KantaPe.Entidad.Evento>(str_pEvento);
        obj_Evento.UsuarioCreacion = Kruma.Core.Security.SecurityManager.Usuario.IdUsuario;
        obj_Evento.UsuarioModificacion = obj_Evento.UsuarioCreacion;

        Kruma.Core.Util.Common.ProcessResult obj_Resultado = null;
        if (!obj_Evento.IdEvento.HasValue)
            obj_Resultado = Kruma.KantaPe.Negocio.Evento.Insertar(obj_Evento);
        else
            obj_Resultado = Kruma.KantaPe.Negocio.Evento.Modificar(obj_Evento);
        return obj_Resultado;
    }

    /// <summary>
    /// Lista los locales de la empresa
    /// </summary>
    /// <param name="int_pIdEmpresa">Id de la empresa</param>
    /// <returns>Lista de locales</returns>
    /// <remarks><list type="bullet">
    /// <item><CreadoPor>John Castillo</CreadoPor></item>
    /// <item><FecCrea>16/08/2016</FecCrea></item></list></remarks>
    [WebMethod]
    public static object ListarLocal(int? int_pIdPersona)
    {
        //return Kruma.Core.Business.Data.PersonaDireccion.Listar(int_pIdPersona, null, null, null, null, null, null, null, null, null, null);
        return Kruma.KantaPe.Negocio.Local.Listar(null, int_pIdPersona, null, null, null, null, null, null, null, Kruma.KantaPe.Entidad.Constante.Estado_Activo, null, null, null, null, null, null);
    }

    #endregion
}