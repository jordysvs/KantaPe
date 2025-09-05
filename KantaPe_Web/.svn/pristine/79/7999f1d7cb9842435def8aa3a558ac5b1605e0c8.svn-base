using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Script.Serialization;
using System.Web.Services;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class Forms_Configuracion_RegistroEmpleado : System.Web.UI.Page
{

    //#region Eventos
    ///// <summary>
    ///// Evento de carga de la pagina
    ///// </summary>
    ///// <remarks><list type="bullet">
    ///// <item><CreadoPor>Jhonior Vivanco</CreadoPor></item>
    ///// <item><FecCrea>16/08/2016</FecCrea></item></list></remarks>
    //protected void Page_Load(object sender, EventArgs e)
    //{
    //    CargaInicial();
    //}
    //#endregion

    //#region Metodos Privados

    ///// <summary>
    ///// Carga inicial del formulario
    ///// </summary>
    //private void CargaInicial()
    //{
    //    Master_Default obj_MasterPage = (Master_Default)this.Master;

    //    if (Request.QueryString["id"] == null)
    //    {
    //        obj_MasterPage.TituloPagina = "Agregar Cliente";
    //    }
    //    else
    //    {
    //        obj_MasterPage.TituloPagina = "Modificar Cliente";
    //        hdIdCliente.Value = Request.QueryString["id"];
    //    }

    //    // //Lista de Cliente
    //    // List<JRG.AdmEsc.Entidad.Cliente> lst_Cliente = null;
    //    // if (Kruma.Core.Security.SecurityManager.Usuario.Sistema == Kruma.Core.Security.Entity.Constante.Condicion_Positivo)
    //    //     lst_Cliente = JRG.AdmEsc.Negocio.Cliente.Listar(null, null, null,null, null, null, JRG.AdmEsc.Entidad.Constante.Estado_Activo, 
    //    //                                                         null, null,null,null,null,null,null, null).Result;
    //    //else
    //    // {
    //    //     List<Kruma.Core.Business.Entity.TipoDocumento> lst_TipoDocumento = Kruma.Core.Business.Logical.TipoDocumento.Listar(null, null, JRG.AdmEsc.Entidad.Constante.Estado_Activo,null,null).Result;
    //    //     lst_Cliente = JRG.AdmEsc.Negocio.Cliente.Listar(null, null, null, null, JRG.AdmEsc.Entidad.Constante.Estado_Activo, 
    //    //                                                     null,null, null,null,null,null,null,null,null,null).Result;
    //    //     lst_Cliente = (from obj_Cliente in lst_Cliente
    //    //                    from obj_Persona in lst_TipoDocumento.Where(x => obj_Cliente.IdTipoDocumento == x.IdTipoDocumento ).DefaultIfEmpty()
    //    //                    select obj_Cliente).ToList();
    //    // }
    //    //ddlTipoDocumento.DataSource = lst_Cliente;

    //    ddlTipoDocumento.DataSource = Kruma.Core.Business.Logical.TipoDocumento.Listar(null, null, Kruma.Core.Business.Entity.Constante.Estado_Activo, null, null).Result;
    //    ddlTipoDocumento.DataValueField = "IdTipoDocumento";
    //    //ddlTipoDocumento.DataTextField = "NumeroDocumento";
    //    ddlTipoDocumento.DataTextField = "Descripcion";
    //    ddlTipoDocumento.DataBind();
    //    ddlTipoDocumento.Items.Insert(0, new ListItem("--Seleccione--", string.Empty));

    //    //Ubigeo
    //    //ddlPais.Items.Insert(0, new ListItem("--Seleccione--", string.Empty));
    //    ddlDepartamento.Items.Insert(0, new ListItem("--Seleccione--", string.Empty));
    //    ddlProvincia.Items.Insert(0, new ListItem("--Seleccione--", string.Empty));
    //    ddlDistrito.Items.Insert(0, new ListItem("--Seleccione--", string.Empty));

    //    //Estado
    //    ddlEstado.DataSource = Kruma.Core.Util.CommonUtil.ListarEstado();
    //    ddlEstado.DataValueField = "Code";
    //    ddlEstado.DataTextField = "Description";
    //    ddlEstado.DataBind();
    //    ddlEstado.Items.Insert(0, new ListItem("--Seleccione--", string.Empty));
    //}

    //#endregion

    //#region Metodos Publicos

    ///// <summary>
    ///// Obtiene los datos del Cliente
    ///// </summary>
    ///// <param name="int_pIdCliente">Id del Cliente</param>
    ///// <remarks><list type="bullet">
    ///// <item><CreadoPor>Jhonior Vivanco</CreadoPor></item>
    ///// <item><FecCrea>16/08/2016</FecCrea></item></list></remarks>
    //[WebMethod]
    //public static Kruma.KantaPe.Entidad.Empleado ObtenerCliente(int int_pIdCliente)
    //{
    //    return JRG.AdmEsc.Negocio.Cliente.Obtener(int_pIdCliente);
    //}

    ///// <summary>
    ///// Guarda la información del Cliente
    ///// </summary>
    ///// <param name="str_pCliente">Json Cliente</param>
    ///// <returns>Resultado del proceso</returns>
    ///// <remarks><list type="bullet">
    ///// <item><CreadoPor>Jhonior Vivanco</CreadoPor></item>
    ///// <item><FecCrea>16/08/2016</FecCrea></item></list></remarks>
    //[WebMethod]
    //public static Kruma.Core.Util.Common.ProcessResult GuardarCliente(string str_pCliente)
    //{
    //    JavaScriptSerializer obj_JsSerializer = new JavaScriptSerializer();
    //    JRG.AdmEsc.Entidad.Cliente obj_Cliente = obj_JsSerializer.Deserialize<JRG.AdmEsc.Entidad.Cliente>(str_pCliente);

    //    obj_Cliente.UsuarioCreacion = Kruma.Core.Security.SecurityManager.Usuario.IdUsuario;
    //    obj_Cliente.UsuarioModificacion = obj_Cliente.UsuarioCreacion;

    //    Kruma.Core.Util.Common.ProcessResult obj_Resultado = null;
    //    if (!obj_Cliente.IdCliente.HasValue)
    //        obj_Resultado = JRG.AdmEsc.Negocio.Cliente.Insertar(obj_Cliente);

    //    else
    //        obj_Resultado = JRG.AdmEsc.Negocio.Cliente.Modificar(obj_Cliente);
    //    return obj_Resultado;
    //}

    //[WebMethod]
    //public static List<Kruma.Core.Business.Entity.Ubigeo> ListarPais()
    //{
    //    return Kruma.Core.Business.Logical.Ubigeo.ListarPais(
    //        null, Kruma.Core.Business.Entity.Constante.Estado_Activo, null, null).Result;
    //}


    //[WebMethod]
    //public static List<Kruma.Core.Business.Entity.Ubigeo> ListarDepartamento(
    //    int int_pIdPais)
    //{
    //    return Kruma.Core.Business.Logical.Ubigeo.ListarDepartamento(
    //        null, int_pIdPais, Kruma.Core.Business.Entity.Constante.Estado_Activo, null, null).Result;
    //}

    //[WebMethod]
    //public static List<Kruma.Core.Business.Entity.Ubigeo> ListarProvincia(
    //    int int_pIdPais,
    //    int int_pIdDepartamento)
    //{
    //    return Kruma.Core.Business.Logical.Ubigeo.ListarProvincia(
    //        null, int_pIdPais, int_pIdDepartamento, Kruma.Core.Business.Entity.Constante.Estado_Activo, null, null).Result;
    //}

    //[WebMethod]
    //public static List<Kruma.Core.Business.Entity.Ubigeo> ListarDistrito(
    //    int int_pIdPais,
    //    int int_pIdDepartamento,
    //    int int_pIdProvincia)
    //{
    //    return Kruma.Core.Business.Logical.Ubigeo.ListarDistrito(
    //        null, int_pIdPais, int_pIdDepartamento, int_pIdProvincia, Kruma.Core.Business.Entity.Constante.Estado_Activo, null, null).Result;
    //}

    //#endregion
}