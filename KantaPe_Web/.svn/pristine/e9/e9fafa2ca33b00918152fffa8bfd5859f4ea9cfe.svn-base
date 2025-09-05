using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Script.Serialization;
using System.Web.Services;
using System.Web.UI;
using System.Web.UI.WebControls;
using Kruma.Core.Security;

public partial class Forms_Gestion_Turno : System.Web.UI.Page
{
    #region Eventos

    /// <summary>
    /// Carga inicial de la pagina
    /// </summary>
    /// <param name="sender"></param>
    /// <param name="e"></param>
    protected void Page_Load(object sender, EventArgs e)
    {
        if (!IsPostBack)
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
        obj_MasterPage.TituloPagina = "Turno de Canciones";


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

        hdLimiteCanciones.Value = Kruma.Core.Business.Data.Parametro.Obtener(Kruma.KantaPe.Entidad.Constante.Parametro.Modulo, Kruma.KantaPe.Entidad.Constante.Parametro.CantidadCancionesPorTurno).Valor;
        hdTiempoSumar.Value = Kruma.Core.Business.Data.Parametro.Obtener(Kruma.KantaPe.Entidad.Constante.Parametro.Modulo, Kruma.KantaPe.Entidad.Constante.Parametro.CantidadSegundosTurno).Valor;
        hdTiempoVerificar.Value = Kruma.Core.Business.Data.Parametro.Obtener(Kruma.KantaPe.Entidad.Constante.Parametro.Modulo, Kruma.KantaPe.Entidad.Constante.Parametro.TiempoVerificacionTurno).Valor;

        //hdCancion.Value = false.ToString();

        Kruma.KantaPe.Entidad.Empleado obj_pEmpleado = Kruma.KantaPe.Negocio.Empleado.Listar(null, null, SecurityManager.Usuario.IdPersona.Value, null, null, null, null, null, null, null).Result[0];
        if (obj_pEmpleado != null)
            hdIdLocal.Value = obj_pEmpleado.IdLocal.ToString();

        //Id del almacen
        //Imagen por defecto
        string str_UrlImagen = string.Format("{0}{1}", Page.ResolveUrl("~"),
        Kruma.Core.Business.Logical.Parametro.Obtener(
        Kruma.KantaPe.Entidad.Constante.Parametro.Modulo,
        Kruma.KantaPe.Entidad.Constante.Parametro.Imagen_Microfono).Valor);
        hdAperturaImagen.Value = str_UrlImagen;
    }

    #endregion

    #region Metodos Publicos


    [WebMethod]
    public static object ListarAperturaTurno()
    {
        int? int_IdLocal = null;
        Kruma.KantaPe.Entidad.Empleado obj_pEmpleado = Kruma.KantaPe.Negocio.Empleado.Listar(null, null, SecurityManager.Usuario.IdPersona.Value, null, null, null, null, null, null, null).Result[0];
        if (obj_pEmpleado != null)
            int_IdLocal = obj_pEmpleado.IdLocal;

        return Kruma.KantaPe.Negocio.Apertura.ListarAperturaTurno(int_IdLocal, null, null);
    }


    [WebMethod]
    public static object GuardarTurno(string str_pTurno, int? int_pIdAperturaDrop, int? int_pIdUbicacionDrag, string str_pCancionTurno)
    {
        JavaScriptSerializer obj_JavaScriptSerializer = new JavaScriptSerializer();
        Kruma.KantaPe.Entidad.Turno obj_Turno = obj_JavaScriptSerializer.Deserialize<Kruma.KantaPe.Entidad.Turno>(str_pTurno);
        Kruma.KantaPe.Entidad.AperturaCancion obj_CancionTurno = obj_JavaScriptSerializer.Deserialize<Kruma.KantaPe.Entidad.AperturaCancion>(str_pCancionTurno);
        obj_Turno.FechaTurno = DateTime.Now;
        obj_Turno.UsuarioCreacion = SecurityManager.Usuario.IdUsuario;
        obj_Turno.UsuarioModificacion = obj_Turno.UsuarioCreacion;
        return Kruma.KantaPe.Negocio.Turno.Insertar(obj_Turno, int_pIdAperturaDrop, int_pIdUbicacionDrag, obj_CancionTurno);
    }

    [WebMethod]
    public static object AlertarTurno(int? int_pIdLocal, int? int_pIdUbicacion, int? int_pIdTipoAlerta)
    {
        Kruma.KantaPe.Entidad.Alerta obj_Alerta = new Kruma.KantaPe.Entidad.Alerta();
        obj_Alerta.IdLocal = int_pIdLocal;
        obj_Alerta.IdUbicacion = int_pIdUbicacion;
        obj_Alerta.FechaAlerta = DateTime.Now;
        obj_Alerta.IdAlertaTipo = int_pIdTipoAlerta;
        obj_Alerta.Estado = Kruma.KantaPe.Entidad.Constante.Estado_Activo;
        obj_Alerta.IdUsuario = SecurityManager.Usuario.IdUsuario;
        obj_Alerta.UsuarioCreacion = obj_Alerta.IdUsuario;
        obj_Alerta.UsuarioModificacion = obj_Alerta.IdUsuario;
        return Kruma.KantaPe.Negocio.Alerta.AlertarTurno(obj_Alerta);
    }

    [WebMethod]
    public static object QuitarCancion(int int_pIdLocal, int int_pIdApertura, int int_pIdAperturaCancion)
    {
        Kruma.KantaPe.Entidad.AperturaCancion obj_AperturaCancionAEliminar = Kruma.KantaPe.Data.AperturaCancion.Obtener(int_pIdLocal, int_pIdApertura, int_pIdAperturaCancion);
        obj_AperturaCancionAEliminar.IdAperturaCancionTipo = Kruma.KantaPe.Entidad.Constante.AperturaCancionTipo_Cantada;
        obj_AperturaCancionAEliminar.UsuarioModificacion = SecurityManager.Usuario.IdUsuario;
       return Kruma.KantaPe.Negocio.AperturaCancion.Modificar(obj_AperturaCancionAEliminar);
    }

    [WebMethod]
    public static List<Kruma.KantaPe.Entidad.AperturaUbicacion> ListarAperturaUbicacion(int int_pIdLocal, int int_pIdApertura)
    {
        return Kruma.KantaPe.Negocio.AperturaUbicacion.Listar(int_pIdLocal, int_pIdApertura, null, Kruma.Core.Business.Entity.Constante.Estado_Activo, null, null).Result;
    }

    #endregion
}