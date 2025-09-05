using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class Forms_Portal_Afiliate : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {

    }

    #region Metodos Publicos

    [WebMethod]
    public static Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Local> ListarKaraokes()
    {
        //Imagen por defecto
        string str_pImagenURLDefecto = string.Format("{0}{1}", ((Page)System.Web.HttpContext.Current.Handler).ResolveUrl("~"),
        Kruma.Core.Business.Logical.Parametro.Obtener(Kruma.Core.Business.Entity.Constante.Parametro.Modulo, "IMAGENMENU").Valor);

        //Id del almacen de imagenes del local
        int? int_IdAlmacenLocal = int.Parse(Kruma.Core.Business.Logical.Parametro.Obtener(
              Kruma.KantaPe.Entidad.Constante.Parametro.Modulo,
              Kruma.KantaPe.Entidad.Constante.Parametro.Almacen_Local).Valor);

        //Listado de local
        Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Local> lst_Local = Kruma.KantaPe.Negocio.Local.Listar(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
        foreach (Kruma.KantaPe.Entidad.Local obj_Local in lst_Local.Result)
        {
            if (obj_Local.IdLocal.HasValue)
                obj_Local.ImagenURL = ObtenerImagenURL(int_IdAlmacenLocal.Value, obj_Local.IdLocal, str_pImagenURLDefecto);
        }

        return lst_Local;
    }

    [WebMethod]
    public static string ObtenerImagenURL(int? int_pIdAlmacen, int? int_pIdRegistro, string str_pImagenURLDefecto)
    {
        string str_UrlImagen = str_pImagenURLDefecto;
        if (int_pIdAlmacen.HasValue && int_pIdRegistro.HasValue)
        {
            Kruma.Core.FileServer.FileServerManager obj_FileServerManager = new Kruma.Core.FileServer.FileServerManager();
            System.Collections.Generic.List<Kruma.Core.FileServer.Entity.FileUpload> lst_Fotos = obj_FileServerManager.getFiles(int_pIdAlmacen.Value, int_pIdRegistro.Value);
            if (lst_Fotos.Count > 0)
            {
                str_UrlImagen = string.Format("./Ashx/FileServerViewHandler.ashx?ref={0}",
                    new Kruma.Core.Criptography.CriptographyManager().Encrypt(
                    string.Format("{0}|{1}|{2}", lst_Fotos[0].IdAlmacen, lst_Fotos[0].IdRegistro, lst_Fotos[0].IdDocumento)
                    ));
            }
        }
        return str_UrlImagen;
    }

    [WebMethod]
    public static Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.LocalCancion> ListarRanking(int int_pIdLocal)
    {
        //Imagen por defecto
        string str_pImagenURLDefecto = string.Format("{0}{1}", ((Page)System.Web.HttpContext.Current.Handler).ResolveUrl("~"),
        Kruma.Core.Business.Logical.Parametro.Obtener(Kruma.Core.Business.Entity.Constante.Parametro.Modulo, "IMAGENMENU").Valor);

        //Id del almacen de imagenes de curso
        int? int_IdAlmacenAlbum = int.Parse(Kruma.Core.Business.Logical.Parametro.Obtener(
              Kruma.KantaPe.Entidad.Constante.Parametro.Modulo,
              Kruma.KantaPe.Entidad.Constante.Parametro.Almacen_Album).Valor);

        //Listado de apertura
        Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.LocalCancion> lst_LocalCancion = Kruma.KantaPe.Negocio.LocalCancion.ListarRanking(
            int_pIdLocal, null, null, null, null, null, null, null, null, null, null, null, null);
        foreach (Kruma.KantaPe.Entidad.LocalCancion obj_LocalCancion in lst_LocalCancion.Result)
        {
            if (string.IsNullOrEmpty(obj_LocalCancion.Album.ImagenURL))
                obj_LocalCancion.Album.ImagenURL = str_pImagenURLDefecto;
        }

        return lst_LocalCancion;
    }

    [WebMethod]
    public static Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Oferta> ListarOfertas(int? int_pIdLocal)
    {
        //Imagen por defecto
        string str_pImagenURLDefecto = string.Format("{0}{1}", ((Page)System.Web.HttpContext.Current.Handler).ResolveUrl("~"),
        Kruma.Core.Business.Logical.Parametro.Obtener(Kruma.Core.Business.Entity.Constante.Parametro.Modulo, "IMAGENMENU").Valor);

        //Id del almacen de imagenes del local
        int? int_IdAlmacenLocal = int.Parse(Kruma.Core.Business.Logical.Parametro.Obtener(
              Kruma.KantaPe.Entidad.Constante.Parametro.Modulo,
              Kruma.KantaPe.Entidad.Constante.Parametro.Almacen_Oferta).Valor);

        //Listado de local
        Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Oferta> lst_Oferta = Kruma.KantaPe.Negocio.Oferta.ListarOfertaSinVencer(null, int_pIdLocal, null, null, null, null, null, Kruma.KantaPe.Entidad.Constante.Estado_Activo, null, null);
        foreach (Kruma.KantaPe.Entidad.Oferta obj_Oferta in lst_Oferta.Result)
        {
            if (string.IsNullOrEmpty(obj_Oferta.ImagenURL))
                obj_Oferta.ImagenURL = str_pImagenURLDefecto;
        }
        return lst_Oferta;
    }

    [WebMethod]
    public static Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Evento> ListarEventos(int? int_pIdLocal)
    {
        //Imagen por defecto
        string str_pImagenURLDefecto = string.Format("{0}{1}", ((Page)System.Web.HttpContext.Current.Handler).ResolveUrl("~"),
        Kruma.Core.Business.Logical.Parametro.Obtener(Kruma.Core.Business.Entity.Constante.Parametro.Modulo, "IMAGENMENU").Valor);

        //Id del almacen de imagenes del local
        int? int_IdAlmacenLocal = int.Parse(Kruma.Core.Business.Logical.Parametro.Obtener(
              Kruma.KantaPe.Entidad.Constante.Parametro.Modulo,
              Kruma.KantaPe.Entidad.Constante.Parametro.Almacen_Evento).Valor);

        //Listado de local
        Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Evento> lst_Evento = Kruma.KantaPe.Negocio.Evento.Listar(null, int_pIdLocal, null, null, null, null, null, Kruma.KantaPe.Entidad.Constante.Estado_Activo, null, null);
        foreach (Kruma.KantaPe.Entidad.Evento obj_Evento in lst_Evento.Result)
        {
            if (string.IsNullOrEmpty(obj_Evento.ImagenURL))
                obj_Evento.ImagenURL = str_pImagenURLDefecto;
        }
        return lst_Evento;
    }

    #endregion
}