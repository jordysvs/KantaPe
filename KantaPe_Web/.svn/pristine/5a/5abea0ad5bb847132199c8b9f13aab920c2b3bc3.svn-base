using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Web.Services;

public partial class Forms_Portal_Ranking : System.Web.UI.Page
{
    #region Eventos

    protected void Page_Load(object sender, EventArgs e)
    {
        CargaInicial();
    }

    #endregion

    #region Metodos Privados

    private void CargaInicial()
    {
        //Master_Externo obj_MasterPage = (Master_Externo)this.Master;
        //obj_MasterPage.TituloPagina = "Ranking";
    }

    #endregion

    #region Metodos Publicos - Imagen

    /// <summary>
    /// Permite obtener la URL de la imagen
    /// </summary>
    /// <param name="int_pIdRegistro">Id del registro</param>
    /// <returns>URL de la imagen</returns>
    /// <remarks><list type="bullet">
    /// <item><CreadoPor>John Castillo</CreadoPor></item>
    /// <item><FecCrea>19/10/2016</FecCrea></item></list></remarks>
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

    #endregion

    #region Metodos Publicos

    [WebMethod]
    public static Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.AperturaCancion> ListarRankiados()
    {
        //Imagen por defecto
        string str_pImagenURLDefecto = string.Format("{0}{1}", ((Page)System.Web.HttpContext.Current.Handler).ResolveUrl("~"),
        Kruma.Core.Business.Logical.Parametro.Obtener(Kruma.Core.Business.Entity.Constante.Parametro.Modulo, "IMAGENMENU").Valor);

        //Id del almacen de imagenes de curso
        int? int_IdAlmacenAlbum = int.Parse(Kruma.Core.Business.Logical.Parametro.Obtener(
              Kruma.KantaPe.Entidad.Constante.Parametro.Modulo,
              Kruma.KantaPe.Entidad.Constante.Parametro.Almacen_Album).Valor);

        //Listado de apertura
        Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.AperturaCancion> lst_AperturaCancion = Kruma.KantaPe.Negocio.AperturaCancion.ListarRanking();
        foreach (Kruma.KantaPe.Entidad.AperturaCancion obj_AperturaCancion in lst_AperturaCancion.Result)
        {
            if (obj_AperturaCancion.LocalCancion.Album.IdAlbum.HasValue)
                obj_AperturaCancion.LocalCancion.Album.ImagenURL = ObtenerImagenURL(int_IdAlmacenAlbum.Value, obj_AperturaCancion.LocalCancion.Album.IdAlbum, str_pImagenURLDefecto);
        }

        return lst_AperturaCancion;
    }



    #endregion
}