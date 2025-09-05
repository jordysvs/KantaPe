using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Script.Serialization;
using System.Web.Services;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class Forms_Maestro_RegistroAlbum : System.Web.UI.Page
{
    #region Eventos

    /// <summary>
    /// Evento de carga de la pagina
    /// </summary>
    /// <remarks><list type="bullet">
    /// <item><CreadoPor>Carlos Gómez</CreadoPor></item>
    /// <item><FecCrea>03/07/2016</FecCrea></item></list></remarks>
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
            obj_MasterPage.TituloPagina = "Agregar Álbum";
        else
        {
            obj_MasterPage.TituloPagina = "Modificar Álbum";
            hdIdAlbum.Value = Request.QueryString["id"];
        }

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
        hdAlbumImagen.Value = str_UrlImagen;
        imgAlbumImagen.ImageUrl = str_UrlImagen;
    }

    #endregion

    #region Metodos Publicos

    /// <summary>
    /// Obtiene los datos del album
    /// </summary>
    /// <param name="int_pIdAlbum">Id del album</param>
    /// <remarks><list type="bullet">
    /// <item><CreadoPor>Carlos Gómez</CreadoPor></item>
    /// <item><FecCrea>03/07/2016</FecCrea></item></list></remarks>
    [WebMethod]
    public static Kruma.KantaPe.Entidad.Album ObtenerAlbum(int int_pIdAlbum)
    {
        return Kruma.KantaPe.Negocio.Album.Obtener(int_pIdAlbum);
    }

    /// <summary>
    /// Guarda la informacion del Álbum
    /// </summary>
    /// <param name="str_pAlbum">Json Álbum</param>
    /// <returns>Resultado del proceso</returns>
    /// <remarks><list type="bullet">
    /// <item><CreadoPor>Carlos Gómez</CreadoPor></item>
    /// <item><FecCrea>03/07/2016</FecCrea></item></list></remarks>
    [WebMethod]
    public static Kruma.Core.Util.Common.ProcessResult GuardarAlbum(string str_pAlbum)
    {
        JavaScriptSerializer obj_JsSerializer = new JavaScriptSerializer();
        Kruma.KantaPe.Entidad.Album obj_Album = obj_JsSerializer.Deserialize<Kruma.KantaPe.Entidad.Album>(str_pAlbum);
        obj_Album.UsuarioCreacion = Kruma.Core.Security.SecurityManager.Usuario.IdUsuario;
        obj_Album.UsuarioModificacion = obj_Album.UsuarioCreacion;

        Kruma.Core.Util.Common.ProcessResult obj_Resultado = null;
        if (!obj_Album.IdAlbum.HasValue)
            obj_Resultado = Kruma.KantaPe.Negocio.Album.Insertar(obj_Album);
        else
            obj_Resultado = Kruma.KantaPe.Negocio.Album.Modificar(obj_Album);
        return obj_Resultado;
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