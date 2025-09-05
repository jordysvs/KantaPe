using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Kruma.KantaPe.Data
{
    /// <summary>Artista</summary>
    /// <remarks><list type="bullet">
    /// <item><CreadoPor>Creado por Carlos Gómez</CreadoPor></item>
    /// <item><FecCrea>01-07-2016</FecCrea></item></list></remarks>
    
    public class Album
    {
        #region Metodos Públicos

        /// <summary>Listado de Álbumes</summary>
        /// <param name="int_pIdAlbum">Id del álbum</param>
        /// <param name="int_pIdArtista">Id del artista</param>
        /// <param name="str_pTitulo">Título del álbum</param>
        /// <param name="str_pEstado">Estado del álbum</param>
        /// <param name="int_pNumPagina" >Número de página</param>
        /// <param name="int_pTamPagina" >Tamaño de página</param>
        /// <returns>Lista del Álbumes</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por Carlos Gómez</CreadoPor></item>
        /// <item><FecCrea>03-07-2016</FecCrea></item></list></remarks>
        public static Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Album> Listar(
            int? int_pIdAlbum,
            int? int_pIdArtista,
            string str_pArtistaNombre,
            string str_pTitulo,
            string str_pEstado,
            int? int_pNumPagina,
            int? int_pTamPagina)
        {
            Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Album> obj_Lista = new Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Album>();
            obj_Lista.PageNumber = int_pNumPagina;
            obj_Lista.Total = 0;


            Kruma.Core.Data.Entity.DataOperation dop_Operacion = new Kruma.Core.Data.Entity.DataOperation("ListarAlbum");

            dop_Operacion.Parameters.Add(new Kruma.Core.Data.Entity.Parameter("@pIdAlbum", int_pIdAlbum.HasValue ? int_pIdAlbum.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Kruma.Core.Data.Entity.Parameter("@pIdArtista", int_pIdArtista.HasValue ? int_pIdArtista.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Kruma.Core.Data.Entity.Parameter("@pArtistaNombre", !string.IsNullOrEmpty(str_pArtistaNombre) ? str_pArtistaNombre : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Kruma.Core.Data.Entity.Parameter("@pTitulo", !string.IsNullOrEmpty(str_pTitulo) ? str_pTitulo : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Kruma.Core.Data.Entity.Parameter("@pEstado", !string.IsNullOrEmpty(str_pEstado) ? str_pEstado : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Kruma.Core.Data.Entity.Parameter("@pNumPagina", int_pNumPagina.HasValue ? int_pNumPagina.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Kruma.Core.Data.Entity.Parameter("@pTamPagina", int_pTamPagina.HasValue ? int_pTamPagina.Value : (object)DBNull.Value));

            DataTable dt_Resultado = Kruma.Core.Data.DataManager.ExecuteDataSet(Conexiones.CO_KantaPe, dop_Operacion).Tables[0];

            List<Kruma.KantaPe.Entidad.Album> lst_Album = new List<Kruma.KantaPe.Entidad.Album>();
            Kruma.KantaPe.Entidad.Album obj_Album = new Kruma.KantaPe.Entidad.Album();
            foreach (DataRow obj_Row in dt_Resultado.Rows)
            {
                if (lst_Album.Count == 0)
                    obj_Lista.Total = (int)obj_Row["Total_Filas"];
                obj_Album = new Kruma.KantaPe.Entidad.Album();
                obj_Album.IdAlbum = obj_Row["IdAlbum"] is DBNull ? null : (int?)obj_Row["IdAlbum"];
                obj_Album.IdArtista = obj_Row["IdArtista"] is DBNull ? null : (int?)obj_Row["IdArtista"];
                obj_Album.Titulo = obj_Row["Titulo"] is DBNull ? null : obj_Row["Titulo"].ToString();
                obj_Album.Estado = obj_Row["Estado"] is DBNull ? null : obj_Row["Estado"].ToString();
                obj_Album.UsuarioCreacion = obj_Row["UsuarioCreacion"] is DBNull ? null : obj_Row["UsuarioCreacion"].ToString();
                obj_Album.FechaCreacion = obj_Row["FechaCreacion"] is DBNull ? null : (DateTime?)obj_Row["FechaCreacion"];
                obj_Album.UsuarioModificacion = obj_Row["UsuarioModificacion"] is DBNull ? null : obj_Row["UsuarioModificacion"].ToString();
                obj_Album.FechaModificacion = obj_Row["FechaModificacion"] is DBNull ? null : (DateTime?)obj_Row["FechaModificacion"];

                if (!(obj_Row["IdArtista"] is DBNull))
                {
                    obj_Album.Artista = new Kruma.KantaPe.Entidad.Artista();
                    obj_Album.Artista.IdArtista = obj_Row["IdArtista"] == DBNull.Value ? null : (int?)obj_Row["IdArtista"];
                    obj_Album.Artista.Nombre = obj_Row["Artista_Descripcion"].ToString();
                }

                lst_Album.Add(obj_Album);
            }

            obj_Lista.Result = lst_Album;
            return obj_Lista;
        }

        /// <summary>Obtener Album</summary>
        /// /// <param name="int_pIdAlbum">Id del album</param>
        /// <returns>Objeto Album</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por Carlos Gómez</CreadoPor></item>
        /// <item><FecCrea>03-07-2016</FecCrea></item></list></remarks>
        public static Kruma.KantaPe.Entidad.Album Obtener(int int_pIdAlbum)
        {
            Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Album> lst_Album = Listar(int_pIdAlbum,null, null, null, null, null, null);
            return lst_Album.Result.Count > 0 ? lst_Album.Result[0] : null;
        }

        /// <summary>Insertar Album</summary>
        /// <param name="obj_pAlbum">Album</param>
        /// <returns>Id del album</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por Carlos Gómez</CreadoPor></item>
        /// <item><FecCrea>03-07-2016</FecCrea></item></list></remarks>
        public static int Insertar(Kruma.KantaPe.Entidad.Album obj_pAlbum)
        {
            Kruma.Core.Data.Entity.DataOperation dop_Operacion = new Kruma.Core.Data.Entity.DataOperation("InsertarAlbum");

            dop_Operacion.Parameters.Add(new Kruma.Core.Data.Entity.Parameter("@pIdArtista", obj_pAlbum.IdArtista));
            dop_Operacion.Parameters.Add(new Kruma.Core.Data.Entity.Parameter("@pTitulo", obj_pAlbum.Titulo));
            dop_Operacion.Parameters.Add(new Kruma.Core.Data.Entity.Parameter("@pEstado", obj_pAlbum.Estado));
            dop_Operacion.Parameters.Add(new Kruma.Core.Data.Entity.Parameter("@pUsuarioCreacion", obj_pAlbum.UsuarioCreacion));

            Kruma.Core.Data.Entity.Parameter obj_IdAlbum = new Kruma.Core.Data.Entity.Parameter("@pIdAlbum", DbType.Int32);
            obj_IdAlbum.Direction = ParameterDirection.Output;
            dop_Operacion.Parameters.Add(obj_IdAlbum);

            Kruma.Core.Data.DataManager.ExecuteNonQuery(Conexiones.CO_KantaPe, dop_Operacion, false);
            int int_IdAlbum = (int)obj_IdAlbum.Value;
            return int_IdAlbum;
        }

        /// <summary>Modificar Album</summary>
        /// <param name="obj_pAlbum">Album</param>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por Carlos Gómez</CreadoPor></item>
        /// <item><FecCrea>03-07-2016</FecCrea></item></list></remarks>
        public static void Modificar(Kruma.KantaPe.Entidad.Album obj_pAlbum)
        {
            Kruma.Core.Data.Entity.DataOperation dop_Operacion = new Kruma.Core.Data.Entity.DataOperation("ActualizarAlbum");

            dop_Operacion.Parameters.Add(new Kruma.Core.Data.Entity.Parameter("@pIdAlbum", obj_pAlbum.IdAlbum));
            dop_Operacion.Parameters.Add(new Kruma.Core.Data.Entity.Parameter("@pIdArtista", obj_pAlbum.IdArtista));
            dop_Operacion.Parameters.Add(new Kruma.Core.Data.Entity.Parameter("@pTitulo", obj_pAlbum.Titulo));
            dop_Operacion.Parameters.Add(new Kruma.Core.Data.Entity.Parameter("@pEstado", obj_pAlbum.Estado));
            dop_Operacion.Parameters.Add(new Kruma.Core.Data.Entity.Parameter("@pUsuarioModificacion", obj_pAlbum.UsuarioModificacion));

            Kruma.Core.Data.DataManager.ExecuteNonQuery(Conexiones.CO_KantaPe, dop_Operacion, false);
        }

        #endregion
    }
}
