using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Security;
using System.Web.Services;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class Comun : System.Web.UI.Page
{
    #region Metodos Publicos

    #region Buscadores

    /// <summary>
    /// Lista de artistas
    /// </summary>
    /// <param name="str_pNombre">Nombre del artista</param>
    /// <param name="int_pNumPagina">Número de la página</param>
    /// <param name="int_pTamPagina">Tamaño de la página</param>
    /// <returns>Lista de artistas</returns>
    /// <item><CreadoPor>John Castillo</CreadoPor></item>
    /// <item><FecCrea>17/08/2016</FecCrea></item></list></remarks>
    [WebMethod]
    public static Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Artista> ListarArtista(
         string str_pNombre, int? int_pNumPagina, int? int_pTamPagina)
    {
        return Kruma.KantaPe.Negocio.Artista.Listar(str_pNombre, Kruma.KantaPe.Entidad.Constante.Estado_Activo, int_pNumPagina, int_pTamPagina);
    }

    /// <summary>
    /// Lista de artistas
    /// </summary>
    /// <param name="str_pNombre">Nombre del artista</param>
    /// <param name="str_pTitulo">Titulo del album</param>
    /// <param name="int_pNumPagina">Número de la página</param>
    /// <param name="int_pTamPagina">Tamaño de la página</param>
    /// <returns>Lista de artistas</returns>
    /// <item><CreadoPor>John Castillo</CreadoPor></item>
    /// <item><FecCrea>17/08/2016</FecCrea></item></list></remarks>
    [WebMethod]
    public static Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Album> ListarAlbum(
         string str_pNombre, string str_pTitulo, int? int_pNumPagina, int? int_pTamPagina)
    {
        return Kruma.KantaPe.Negocio.Album.Listar(null, str_pNombre, str_pTitulo, Kruma.KantaPe.Entidad.Constante.Estado_Activo, int_pNumPagina, int_pTamPagina);
    }

    #endregion

    #endregion
}