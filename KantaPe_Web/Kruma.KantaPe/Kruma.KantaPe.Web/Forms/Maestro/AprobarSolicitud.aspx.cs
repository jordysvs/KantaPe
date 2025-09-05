using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Script.Serialization;
using System.Web.Services;
using System.Web.UI;
using System.Web.UI.WebControls;
using Kruma.Core.Security;

public partial class Forms_Maestro_AprobarSolicitud : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        CargaInicial();
    }

    #region Metodos Privados

    /// <summary>
    /// Carga inicial del formulario
    /// </summary>
    private void CargaInicial()
    {
        Master_Default obj_MasterPage = (Master_Default)this.Master;
        obj_MasterPage.TituloPagina = "Aprobar Solicitud";

        hdIdSolicitudCancion.Value = Request.QueryString["id"];


        ddlEstado.DataSource = Kruma.Core.Util.CommonUtil.ListarEstado();
        ddlEstado.DataValueField = "Code";
        ddlEstado.DataTextField = "Description";
        ddlEstado.DataBind();
        ddlEstado.Items.Insert(0, new ListItem("--Seleccione--", string.Empty));

        //Empresa
        ddlEmpresa.DataSource = Kruma.Core.Business.Logical.Persona.Listar(null, 2, null, null, null, null, null, null).Result;
        ddlEmpresa.DataValueField = "IdPersona";
        ddlEmpresa.DataTextField = "NombreComercial";
        ddlEmpresa.DataBind();
        ddlEmpresa.Items.Insert(0, new ListItem("--Seleccione--", string.Empty));

        ddlLocal.Items.Insert(0, new ListItem("--Seleccione--", string.Empty));

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
        hdAlbumImagen.Value = str_UrlImagen;
        imgAlbumImagen.ImageUrl = str_UrlImagen;
    }

    #endregion

    #region Metodos Publicos

    /// <summary>
    /// Obtiene los datos de canción
    /// </summary>
    /// <param name="int_pIdCancion">Id de canción</param>
    /// <remarks><list type="bullet">
    /// <item><CreadoPor>Carlos Gómez</CreadoPor></item>
    /// <item><FecCrea>12/07/2016</FecCrea></item></list></remarks>
    [WebMethod]
    public static Kruma.KantaPe.Entidad.Cancion ObtenerCancion(int int_pIdCancion)
    {
        return Kruma.KantaPe.Negocio.Cancion.Obtener(int_pIdCancion);
    }



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

    //-----------------LISTAR---------------
    [WebMethod]
    public static Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Cancion> ListarCancion(string str_pDescripcion, int? int_pNumPagina, int? int_pTamPagina)
    {
        return Kruma.KantaPe.Negocio.Cancion.Listar(str_pDescripcion, Kruma.KantaPe.Entidad.Constante.Estado_Activo, int_pNumPagina, int_pTamPagina);
    }

    [WebMethod]
    public static Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Genero> ListarGenero(string str_pDescripcion, int? int_pNumPagina, int? int_pTamPagina)
    {
        return Kruma.KantaPe.Negocio.Genero.Listar(str_pDescripcion, Kruma.KantaPe.Entidad.Constante.Estado_Activo, int_pNumPagina, int_pTamPagina);
    }

    [WebMethod]
    public static Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Idioma> ListarIdioma(string str_pDescripcion, int? int_pNumPagina, int? int_pTamPagina)
    {
        return Kruma.KantaPe.Negocio.Idioma.Listar(str_pDescripcion, Kruma.KantaPe.Entidad.Constante.Estado_Activo, int_pNumPagina, int_pTamPagina);
    }
    [WebMethod]
    public static Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Artista> ListarArtista(string str_pDescripcion, int? int_pNumPagina, int? int_pTamPagina)
    {
        return Kruma.KantaPe.Negocio.Artista.Listar(str_pDescripcion, Kruma.KantaPe.Entidad.Constante.Estado_Activo, int_pNumPagina, int_pTamPagina);
    }
    [WebMethod]
    public static Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Album> ListarAlbum(int? int_IdArtista, string str_pDescripcion, int? int_pNumPagina, int? int_pTamPagina)
    {
        return Kruma.KantaPe.Negocio.Album.Listar(int_IdArtista, null, str_pDescripcion, Kruma.KantaPe.Entidad.Constante.Estado_Activo, int_pNumPagina, int_pTamPagina);
    }


    //-------------------------------------------------AGREGAR-----------------------------------------------
    [WebMethod]
    public static Kruma.Core.Util.Common.ProcessResult AgregarCancion(string str_pDescripcion)
    {
        Kruma.KantaPe.Entidad.Cancion obj_Cancion = new Kruma.KantaPe.Entidad.Cancion();
        obj_Cancion.Descripcion = str_pDescripcion;
        obj_Cancion.Estado = Kruma.KantaPe.Entidad.Constante.Estado_Activo;
        obj_Cancion.UsuarioCreacion = SecurityManager.Usuario.IdUsuario;
        obj_Cancion.UsuarioModificacion = obj_Cancion.UsuarioCreacion;
        return Kruma.KantaPe.Negocio.Cancion.Insertar(obj_Cancion);
    }

    [WebMethod]
    public static Kruma.Core.Util.Common.ProcessResult AgregarGenero(string str_pDescripcion)
    {
        Kruma.KantaPe.Entidad.Genero obj_Genero = new Kruma.KantaPe.Entidad.Genero();
        obj_Genero.Descripcion = str_pDescripcion;
        obj_Genero.Estado = Kruma.KantaPe.Entidad.Constante.Estado_Activo;
        obj_Genero.UsuarioCreacion = SecurityManager.Usuario.IdUsuario;
        obj_Genero.UsuarioModificacion = obj_Genero.UsuarioCreacion;
        return Kruma.KantaPe.Negocio.Genero.Insertar(obj_Genero);
    }

    [WebMethod]
    public static Kruma.Core.Util.Common.ProcessResult AgregarIdioma(string str_pDescripcion)
    {
        Kruma.KantaPe.Entidad.Idioma obj_Idioma = new Kruma.KantaPe.Entidad.Idioma();
        obj_Idioma.Descripcion = str_pDescripcion;
        obj_Idioma.Estado = Kruma.KantaPe.Entidad.Constante.Estado_Activo;
        obj_Idioma.UsuarioCreacion = SecurityManager.Usuario.IdUsuario;
        obj_Idioma.UsuarioModificacion = obj_Idioma.UsuarioCreacion;
        return Kruma.KantaPe.Negocio.Idioma.Insertar(obj_Idioma);
    }

    [WebMethod]
    public static Kruma.Core.Util.Common.ProcessResult AgregarArtista(string str_pDescripcion)
    {
        Kruma.KantaPe.Entidad.Artista obj_Artista = new Kruma.KantaPe.Entidad.Artista();
        obj_Artista.Nombre = str_pDescripcion;
        obj_Artista.Estado = Kruma.KantaPe.Entidad.Constante.Estado_Activo;
        obj_Artista.UsuarioCreacion = SecurityManager.Usuario.IdUsuario;
        obj_Artista.UsuarioModificacion = obj_Artista.UsuarioCreacion;
        return Kruma.KantaPe.Negocio.Artista.Insertar(obj_Artista);
    }

    [WebMethod]
    public static Kruma.Core.Util.Common.ProcessResult AgregarAlbum(string str_pDescripcion, int? int_pIdArtista)
    {
        Kruma.KantaPe.Entidad.Album obj_Album = new Kruma.KantaPe.Entidad.Album();
        obj_Album.IdArtista = int_pIdArtista;
        obj_Album.Titulo = str_pDescripcion;
        obj_Album.Estado = Kruma.KantaPe.Entidad.Constante.Estado_Activo;
        obj_Album.UsuarioCreacion = SecurityManager.Usuario.IdUsuario;
        obj_Album.UsuarioModificacion = obj_Album.UsuarioCreacion;
        return Kruma.KantaPe.Negocio.Album.Insertar(obj_Album);
    }
    /// <summary>
    /// Guarda la informacion de canción
    /// </summary>
    /// <param name="str_pCancion">Json Cancion</param>
    /// <returns>Resultado del proceso</returns>
    /// <remarks><list type="bullet">
    /// <item><CreadoPor>Carlos Gómez</CreadoPor></item>
    /// <item><FecCrea>12/07/2016</FecCrea></item></list></remarks>
    [WebMethod]
    public static Kruma.Core.Util.Common.ProcessResult GuardarCancion(string str_pCancion, int? int_pIdSolicitudCancion)
    {
        JavaScriptSerializer obj_JsSerializer = new JavaScriptSerializer();
        Kruma.KantaPe.Entidad.LocalCancion obj_Cancion = obj_JsSerializer.Deserialize<Kruma.KantaPe.Entidad.LocalCancion>(str_pCancion);
        obj_Cancion.UsuarioCreacion = Kruma.Core.Security.SecurityManager.Usuario.IdUsuario;
        obj_Cancion.UsuarioModificacion = obj_Cancion.UsuarioCreacion;

        Kruma.Core.Util.Common.ProcessResult obj_Resultado = null;
        obj_Resultado = Kruma.KantaPe.Negocio.LocalCancion.AprobarSolicitud(obj_Cancion, int_pIdSolicitudCancion);

        return obj_Resultado;
    }


    [WebMethod]
    public static Kruma.Core.Util.Common.ProcessResult RechazarSolicitud(int? int_pIdSolicitudCancion, string str_pMotivo)
    {

        Kruma.Core.Util.Common.ProcessResult obj_Resultado = null;
        obj_Resultado = Kruma.KantaPe.Negocio.LocalCancion.RechazarSolicitud(int_pIdSolicitudCancion, str_pMotivo);

        return obj_Resultado;
    }

    [WebMethod]
    public static Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.SolicitudCancion> ListarCancionesNuevas(
        int? int_pIdSolicitudCancion)
    {
        return Kruma.KantaPe.Negocio.SolicitudCancion.Listar(int_pIdSolicitudCancion, null, null, null, null, null, null, null, null, null);
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
                Kruma.KantaPe.Entidad.Constante.Parametro.Almacen_Album).Valor);

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