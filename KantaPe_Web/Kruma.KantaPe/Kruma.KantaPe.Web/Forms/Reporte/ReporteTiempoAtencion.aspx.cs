using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class Forms_Reporte_ReporteTiempoAtencion : System.Web.UI.Page
{
    #region Eventos

    protected void Page_Load(object sender, EventArgs e)
    {
        if (!IsPostBack)
            CargaInicial();
    }

    #endregion

    #region Metodos Privados

    private void CargaInicial()
    {
        Master_Default obj_MasterPage = (Master_Default)this.Master;
        obj_MasterPage.TituloPagina = "Reporte - Tiempo de atención";

        //Empresa
        ddlEmpresa.DataSource = Kruma.Core.Business.Logical.Persona.Listar(null, 2, null, null, null, null, null, null).Result;
        ddlEmpresa.DataValueField = "IdPersona";
        ddlEmpresa.DataTextField = "NombreComercial";
        ddlEmpresa.DataBind();
        ddlEmpresa.Items.Insert(0, new ListItem("--Todos--", string.Empty));

        ddlLocal.Items.Insert(0, new ListItem("--Todos--", string.Empty));

        ddlUbicacionTipo.DataSource = Kruma.KantaPe.Negocio.UbicacionTipo.Listar(null, null, Kruma.KantaPe.Entidad.Constante.Estado_Activo, null, null).Result;
        ddlUbicacionTipo.DataValueField = "IdUbicacionTipo";
        ddlUbicacionTipo.DataTextField = "Descripcion";
        ddlUbicacionTipo.DataBind();
        ddlUbicacionTipo.Items.Insert(0, new ListItem("--Todos--", string.Empty));

    }

    #endregion

    #region Metodos Publicos

    /// <summary>
    /// Listar Local
    /// </summary>
    /// <param name="str_pIdUsuario">Id del usuario</param>
    /// <returns>Resultado del proceso</returns>
    /// <remarks><list type="bullet">
    /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
    /// <item><FecCrea>06/08/2015</FecCrea></item></list></remarks>
    [WebMethod]
    public static object ListarLocal(int? int_pIdPersona)
    {
        return Kruma.Core.Business.Data.PersonaDireccion.Listar(int_pIdPersona, null, null, null, null, null, null, null, null, null, null);
    }

    /// <summary>
    /// ReporteCancionPedida
    /// </summary>
    /// <remarks><list type="bullet">
    /// <item><CreadoPor>Vicente Gonzales Osorio</CreadoPor></item>
    /// <item><FecCrea>09/03/2017</FecCrea></item></list></remarks>
    [WebMethod]
    public static object ReporteTiempoAtencion(
            string str_pNombreCompleto,
            int? int_pIdEmpresa,
            int? int_pIdLocal,
            DateTime? dt_pFechaInicio,
            DateTime? dt_pFechaFin,
            int? int_pIdUbicacionTipo,
            int? int_pNroUbicacion,
            int? int_pNumPagina,
            int? int_pTamPagina)
    {
        return Kruma.KantaPe.Negocio.Apertura.ReporteTiempoAtencion(str_pNombreCompleto, int_pIdEmpresa, int_pIdLocal, dt_pFechaInicio, dt_pFechaFin, int_pIdUbicacionTipo, int_pNroUbicacion, int_pNumPagina, int_pTamPagina);
    }
    [WebMethod]
    public static object ListarTiempoAtencionMozoTop(
           string str_pNombreCompleto,
            int? int_pIdEmpresa,
            int? int_pIdLocal,
            DateTime? dt_pFechaInicio,
            DateTime? dt_pFechaFin)
    {
        return Kruma.KantaPe.Negocio.Apertura.ListarTiempoAtencionMozoTop(str_pNombreCompleto, int_pIdEmpresa, int_pIdLocal,dt_pFechaInicio, dt_pFechaFin);
    }
    #endregion
}