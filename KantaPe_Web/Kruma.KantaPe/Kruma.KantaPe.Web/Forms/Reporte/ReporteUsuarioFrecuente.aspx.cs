using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class Forms_Reporte_ReporteUsuarioFrecuente : System.Web.UI.Page
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
        obj_MasterPage.TituloPagina = "Reporte - Usuario Frecuente";

        //Empresa
        ddlEmpresa.DataSource = Kruma.Core.Business.Logical.Persona.Listar(null, 2, null, null, null, null, null, null).Result;
        ddlEmpresa.DataValueField = "IdPersona";
        ddlEmpresa.DataTextField = "NombreComercial";
        ddlEmpresa.DataBind();
        ddlEmpresa.Items.Insert(0, new ListItem("--Todos--", string.Empty));

        ddlLocal.Items.Insert(0, new ListItem("--Todos--", string.Empty));

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
    public static object ReporteUsuarioFrecuente(
            int? int_pIdEmpresa,
            int? int_pIdLocal,
            DateTime? dt_pFechaInicio,
            DateTime? dt_pFechaFin,
            string str_pNombreCompleto,
            int? int_pNumPagina,
            int? int_pTamPagina)
    {
        return Kruma.KantaPe.Negocio.AperturaUsuario.ReporteUsuarioFrecuente(int_pIdEmpresa, int_pIdLocal, dt_pFechaInicio, dt_pFechaFin, str_pNombreCompleto, int_pNumPagina, int_pTamPagina);
    }

    /// <summary>
    /// ReporteCancionPedidaComparacion
    /// </summary>
    /// <remarks><list type="bullet">
    /// <item><CreadoPor>Vicente Gonzales Osorio</CreadoPor></item>
    /// <item><FecCrea>09/03/2017</FecCrea></item></list></remarks>
    [WebMethod]
    public static object ReporteUsuarioFrecuenteComparacion(
            int? int_pIdEmpresa,
            int? int_pIdLocal,
            DateTime? dt_pFechaInicio,
            DateTime? dt_pFechaFin,
            string str_pNombreCompleto,
            int? int_pNumPagina,
            int? int_pTamPagina)
    {
        return Kruma.KantaPe.Negocio.AperturaUsuario.ReporteUsuarioFrecuenteComparacion(int_pIdEmpresa, int_pIdLocal, dt_pFechaInicio, dt_pFechaFin, str_pNombreCompleto, int_pNumPagina, int_pTamPagina);
    }

    /// <summary>
    /// Listar Usuarios que mas canciones piden
    /// </summary>
    /// <remarks><list type="bullet">
    /// <item><CreadoPor>Vicente Gonzales Osorio</CreadoPor></item>
    /// <item><FecCrea>09/03/2017</FecCrea></item></list></remarks>
    [WebMethod]
    public static object ListarUsuarioPideCancionesTop(
            string str_pNombreCompleto,
            DateTime? dt_pFechaInicio,
            DateTime? dt_pFechaFin
        )
    {
        return Kruma.KantaPe.Negocio.SolicitudCancion.ListarUsuarioPideCancionesTop(str_pNombreCompleto,dt_pFechaInicio, dt_pFechaFin);
    }

    #endregion
}