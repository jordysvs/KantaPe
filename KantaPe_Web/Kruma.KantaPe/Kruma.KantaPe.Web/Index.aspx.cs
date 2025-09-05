using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;
using System.Web.UI;
using System.Web.UI.WebControls;
using Kruma.Core.Security;

public partial class Index : System.Web.UI.Page
{
    #region Eventos

    protected void Page_Load(object sender, EventArgs e)
    {
        CargaInicial();
    }

    #endregion

    #region Metodos Publicos

    //[WebMethod]
    //public static Ugel.TraDoc.Entidad.DashBoard ObtenerDashBoard()
    //{
    //    return Ugel.TraDoc.Negocio.DashBoard.ListarDashBoard(Kruma.Core.Security.SecurityManager.Usuario.IdEmpleado);
    //}

    private void CargaInicial()
    {
        Master_Default obj_MasterPage = (Master_Default)this.Master;
        obj_MasterPage.TituloPagina = "Inicio";

        int int_pIdPersona = SecurityManager.Usuario.IdPersona.Value;
        List<Kruma.KantaPe.Entidad.Empleado> lstEmpleado = Kruma.KantaPe.Data.Empleado.Listar(null, null, int_pIdPersona, null, null, null, null, null, null, null).Result;

        if (lstEmpleado.Count > 0)
            hdIdLocal.Value = lstEmpleado[0].IdLocal.Value.ToString();

    }
    [WebMethod]
    public static object ListarTotalUbicacion(
            int? int_pIdUbicacionTipo,
            int? int_pIdLocal)
    {
        return Kruma.KantaPe.Negocio.Ubicacion.ListarTotalUbicacion(int_pIdUbicacionTipo, int_pIdLocal);
    }

    [WebMethod]
    public static object ListarAperturaMesaInicio(
            int? int_pIdUbicacionTipo,
            int? int_pIdLocal)
    {
        return Kruma.KantaPe.Negocio.Apertura.ListarAperturaMesaInicio(int_pIdUbicacionTipo, int_pIdLocal);
    }

    [WebMethod]
    public static object ListarAperturaMesaCerradoInicio(
            int? int_pIdUbicacionTipo,
            int? int_pIdLocal)
    {
        return Kruma.KantaPe.Negocio.Apertura.ListarAperturaMesaCerradoInicio(int_pIdUbicacionTipo, int_pIdLocal);
    }
    #endregion
}