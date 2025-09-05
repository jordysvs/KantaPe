using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class Forms_Reporte_ReporteCancionPedida : System.Web.UI.Page
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
        obj_MasterPage.TituloPagina = "Reporte - Canciones más pedidas";

        //Empresa
        ddlEmpresa.DataSource = Kruma.Core.Business.Logical.Persona.Listar(null, 2, null, null, null, null, null, null).Result;
        ddlEmpresa.DataValueField = "IdPersona";
        ddlEmpresa.DataTextField = "NombreComercial";
        ddlEmpresa.DataBind();
        ddlEmpresa.Items.Insert(0, new ListItem("--Todos--", string.Empty));

        ddlLocal.Items.Insert(0, new ListItem("--Todos--", string.Empty));

        ddlGenero.DataSource = Kruma.KantaPe.Negocio.Genero.Listar(null, Kruma.KantaPe.Entidad.Constante.Estado_Activo, null, null).Result;
        ddlGenero.DataValueField = "IdGenero";
        ddlGenero.DataTextField = "Descripcion";
        ddlGenero.DataBind();
        ddlGenero.Items.Insert(0, new ListItem("--Todos--", string.Empty));

        ddlIdioma.DataSource = Kruma.KantaPe.Negocio.Idioma.Listar(null, Kruma.KantaPe.Entidad.Constante.Estado_Activo, null, null).Result;
        ddlIdioma.DataValueField = "IdIdioma";
        ddlIdioma.DataTextField = "Descripcion";
        ddlIdioma.DataBind();
        ddlIdioma.Items.Insert(0, new ListItem("--Todos--", string.Empty));
    }
    #endregion

    #region Metodos Publicos

    /// <summary>
    /// Reiniciar contransenia
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
    /// Listar Docentes Adjudicados
    /// </summary>
    /// <remarks><list type="bullet">
    /// <item><CreadoPor>Vicente Gonzales Osorio</CreadoPor></item>
    /// <item><FecCrea>30/01/2017</FecCrea></item></list></remarks>
    [WebMethod]
    public static object ReporteCancionPedida(
            int? int_pIdEmpresa,
            int? int_pIdLocal,
            DateTime? dt_pFechaInicio,
            DateTime? dt_pFechaFin,
            string str_pDesArtista,
            string str_pDesAlbum,
            int? int_pIdGenero,
            int? int_pIdIdioma,
            int? int_pNumPagina,
            int? int_pTamPagina)
    {
        return Kruma.KantaPe.Negocio.AperturaCancion.ReporteCancionPedida(int_pIdEmpresa, int_pIdLocal, dt_pFechaInicio, dt_pFechaFin, str_pDesArtista, str_pDesAlbum, int_pIdGenero, int_pIdIdioma, int_pNumPagina, int_pTamPagina);
    }
    [WebMethod]
    public static object ListarArtistaTop(
           DateTime? dt_pFechaInicio,
           DateTime? dt_pFechaFin,
           int? int_pIdEmpresa,
           int? int_pIdLocal,
           string str_pDesArtista,
           string str_pDesAlbum,
           int? int_pIdGenero,
           int? int_pIdIdioma)
    {
        return Kruma.KantaPe.Negocio.AperturaCancion.ListarArtistaTop(dt_pFechaInicio, dt_pFechaFin, int_pIdEmpresa, int_pIdLocal, str_pDesArtista, str_pDesAlbum, int_pIdGenero, int_pIdIdioma);
    }
    [WebMethod]
    public static object ListarGeneroTop(
           DateTime? dt_pFechaInicio,
           DateTime? dt_pFechaFin,
           int? int_pIdEmpresa,
           int? int_pIdLocal,
           string str_pDesArtista,
           string str_pDesAlbum,
           int? int_pIdGenero,
           int? int_pIdIdioma)
    {
        return Kruma.KantaPe.Negocio.AperturaCancion.ListarGeneroTop(dt_pFechaInicio, dt_pFechaFin, int_pIdEmpresa, int_pIdLocal, str_pDesArtista, str_pDesAlbum, int_pIdGenero, int_pIdIdioma);
    }
    [WebMethod]
    public static object ListarIdiomaTop(
           DateTime? dt_pFechaInicio,
           DateTime? dt_pFechaFin,
           int? int_pIdEmpresa,
           int? int_pIdLocal,
           string str_pDesArtista,
           string str_pDesAlbum,
           int? int_pIdGenero,
           int? int_pIdIdioma)
    {
        return Kruma.KantaPe.Negocio.AperturaCancion.ListarIdiomaTop(dt_pFechaInicio, dt_pFechaFin, int_pIdEmpresa, int_pIdLocal, str_pDesArtista, str_pDesAlbum, int_pIdGenero, int_pIdIdioma);
    }
    #endregion
}