using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data;
using Kruma.Core.Data;
using Kruma.Core.Data.Entity;

namespace Kruma.KantaPe.Data
{
    /// <summary>LocalCancion</summary>
    /// <remarks><list type="bullet">
    /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
    /// <item><FecCrea>12-07-2016</FecCrea></item></list></remarks>

    public class LocalCancion
    {
        #region Metodos Públicos

        /// <summary>Listado de LocalCancion</summary>
        /// <param name="int_pIdLocal">IdLocal</param>
        /// <param name="int_pIdCancion">IdCancion</param>
        /// <param name="str_pEstado">Estado</param>
        /// <param name="int_pNumPagina" >Numero de pagina</param>
        /// <param name="int_pTamPagina" >Tamaño de pagina</param>
        /// <returns>Lista de LocalCancion</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>12-07-2016</FecCrea></item></list></remarks>
        public static Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.LocalCancion> Listar(
            int? int_pIdLocal,
            int? int_pIdCancion,

            int? int_pIdEmpresa,
            string str_pPalabraClave,
            string str_pTitulo,
            string str_pArtista,
            string str_pAlbum,
            int? int_pIdGenero,
            int? int_pIdIdioma,

            string str_pEstado,
            int? int_pNumPagina,
            int? int_pTamPagina)
        {
            Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.LocalCancion> obj_Lista = new Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.LocalCancion>();
            obj_Lista.PageNumber = int_pNumPagina;
            obj_Lista.Total = 0;

            DataOperation dop_Operacion = new DataOperation("ListarLocalCancion");
            dop_Operacion.Parameters.Add(new Parameter("@pIdLocal", int_pIdLocal.HasValue ? int_pIdLocal.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pIdCancion", int_pIdCancion.HasValue ? int_pIdCancion.Value : (object)DBNull.Value));

            dop_Operacion.Parameters.Add(new Parameter("@pIdEmpresa", int_pIdEmpresa.HasValue ? int_pIdEmpresa.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pPalabraClave", !string.IsNullOrEmpty(str_pPalabraClave) ? str_pPalabraClave : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pTitulo", !string.IsNullOrEmpty(str_pTitulo) ? str_pTitulo : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pArtista", !string.IsNullOrEmpty(str_pArtista) ? str_pArtista : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pAlbum", !string.IsNullOrEmpty(str_pAlbum) ? str_pAlbum : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pIdGenero", int_pIdGenero.HasValue ? int_pIdGenero.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pIdIdioma", int_pIdIdioma.HasValue ? int_pIdIdioma.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pEstado", !string.IsNullOrEmpty(str_pEstado) ? str_pEstado : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pNumPagina", int_pNumPagina.HasValue ? int_pNumPagina.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pTamPagina", int_pTamPagina.HasValue ? int_pTamPagina.Value : (object)DBNull.Value));

            DataTable dt_Resultado = DataManager.ExecuteDataSet(Conexiones.CO_KantaPe, dop_Operacion).Tables[0];

            List<Kruma.KantaPe.Entidad.LocalCancion> lst_LocalCancion = new List<Kruma.KantaPe.Entidad.LocalCancion>();
            Kruma.KantaPe.Entidad.LocalCancion obj_LocalCancion = new Kruma.KantaPe.Entidad.LocalCancion();
            foreach (DataRow obj_Row in dt_Resultado.Rows)
            {
                if (lst_LocalCancion.Count == 0)
                    obj_Lista.Total = (int)obj_Row["Total_Filas"];
                obj_LocalCancion = new Kruma.KantaPe.Entidad.LocalCancion();
                obj_LocalCancion.IdLocal = obj_Row["IdLocal"] is DBNull ? null : (int?)obj_Row["IdLocal"];
                obj_LocalCancion.IdCancion = obj_Row["IdCancion"] is DBNull ? null : (int?)obj_Row["IdCancion"];
                obj_LocalCancion.Estado = obj_Row["Estado"] is DBNull ? null : obj_Row["Estado"].ToString();
                obj_LocalCancion.UsuarioCreacion = obj_Row["UsuarioCreacion"] is DBNull ? null : obj_Row["UsuarioCreacion"].ToString();
                obj_LocalCancion.FechaCreacion = obj_Row["FechaCreacion"] is DBNull ? null : (DateTime?)obj_Row["FechaCreacion"];
                obj_LocalCancion.UsuarioModificacion = obj_Row["UsuarioModificacion"] is DBNull ? null : obj_Row["UsuarioModificacion"].ToString();
                obj_LocalCancion.FechaModificacion = obj_Row["FechaModificacion"] is DBNull ? null : (DateTime?)obj_Row["FechaModificacion"];

                obj_LocalCancion.Local = new Kruma.KantaPe.Entidad.Local();
                obj_LocalCancion.Local.IdLocal = obj_Row["Local_IdLocal"] is DBNull ? null : (int?)obj_Row["Local_IdLocal"];
                obj_LocalCancion.Local.IdEmpresa = obj_Row["Local_IdEmpresa"] is DBNull ? null : (int?)obj_Row["Local_IdEmpresa"];
                obj_LocalCancion.Local.IdDireccion = obj_Row["Local_IdDireccion"] is DBNull ? null : (int?)obj_Row["Local_IdDireccion"];
                obj_LocalCancion.Local.Nombre = obj_Row["CorePersonaDireccion_Nombre"] is DBNull ? null : obj_Row["CorePersonaDireccion_Nombre"].ToString();
                obj_LocalCancion.Local.Direccion = obj_Row["CorePersonaDireccion_Direccion"] is DBNull ? null : obj_Row["CorePersonaDireccion_Direccion"].ToString();

                obj_LocalCancion.Local.Empresa = new Kruma.KantaPe.Entidad.Empresa();
                obj_LocalCancion.Local.Empresa.IdEmpresa = obj_Row["Empresa_IdEmpresa"] is DBNull ? null : (int?)obj_Row["Empresa_IdEmpresa"];
                obj_LocalCancion.Local.Empresa.IdPersona = obj_Row["CorePersona_IdPersona"] is DBNull ? null : (int?)obj_Row["CorePersona_IdPersona"];
                obj_LocalCancion.Local.Empresa.RazonSocial = obj_Row["CorePersona_RazonSocial"] is DBNull ? null : obj_Row["CorePersona_RazonSocial"].ToString();
                obj_LocalCancion.Local.Empresa.NombreComercial = obj_Row["CorePersona_NombreComercial"] is DBNull ? null : obj_Row["CorePersona_NombreComercial"].ToString();
                obj_LocalCancion.Local.Empresa.IdTipoDocumento = obj_Row["CorePersona_IdTipoDocumento"] is DBNull ? null : (int?)obj_Row["CorePersona_IdTipoDocumento"];
                obj_LocalCancion.Local.Empresa.NumeroDocumento = obj_Row["CorePersona_NumeroDocumento"] is DBNull ? null : obj_Row["CorePersona_NumeroDocumento"].ToString();

                //obj_LocalCancion.Local.Empresa.TipoDocumento = new Kruma.Core.Business.Entity.TipoDocumento();
                //obj_LocalCancion.Local.Empresa.TipoDocumento.IdTipoDocumento = obj_Row["TipoDocumento_IdTipoDocumento"] is DBNull ? null : (int?)obj_Row["TipoDocumento_IdTipoDocumento"];
                //obj_LocalCancion.Local.Empresa.TipoDocumento.Descripcion = obj_Row["TipoDocumento_Descripcion"] is DBNull ? null : obj_Row["TipoDocumento_Descripcion"].ToString();

                obj_LocalCancion.Cancion = new Kruma.KantaPe.Entidad.LocalCancion();
                obj_LocalCancion.Cancion.IdCancion = obj_Row["Cancion_IdCancion"] is DBNull ? null : (int?)obj_Row["Cancion_IdCancion"];
                //obj_LocalCancion.Cancion.Titulo = obj_Row["Cancion_Titulo"] is DBNull ? null : obj_Row["Cancion_Titulo"].ToString();
                obj_LocalCancion.Cancion.IdArtista = obj_Row["Cancion_IdArtista"] is DBNull ? null : (int?)obj_Row["Cancion_IdArtista"];
                obj_LocalCancion.Cancion.IdAlbum = obj_Row["Cancion_IdAlbum"] is DBNull ? null : (int?)obj_Row["Cancion_IdAlbum"];
                obj_LocalCancion.Cancion.IdGenero = obj_Row["Cancion_IdGenero"] is DBNull ? null : (int?)obj_Row["Cancion_IdGenero"];
                obj_LocalCancion.Cancion.IdIdioma = obj_Row["Cancion_IdIdioma"] is DBNull ? null : (int?)obj_Row["Cancion_IdIdioma"];
                obj_LocalCancion.Cancion.Decada = obj_Row["Cancion_Decada"] is DBNull ? null : obj_Row["Cancion_Decada"].ToString();
                obj_LocalCancion.Cancion.Version = obj_Row["Cancion_Version"] is DBNull ? null : obj_Row["Cancion_Version"].ToString();
                obj_LocalCancion.Cancion.NombreArchivo = obj_Row["Cancion_NombreArchivo"] is DBNull ? null : obj_Row["Cancion_NombreArchivo"].ToString();
                obj_LocalCancion.Cancion.FechaRegistro = obj_Row["Cancion_FechaRegistro"] == DBNull.Value ? null : ((DateTime?)obj_Row["Cancion_FechaRegistro"]);
                obj_LocalCancion.Cancion.Anio = obj_Row["Cancion_Anio"] is DBNull ? null : (int?)obj_Row["Cancion_Anio"];
                obj_LocalCancion.Cancion.Letra = obj_Row["Cancion_Letra"] is DBNull ? null : obj_Row["Cancion_Letra"].ToString();
                obj_LocalCancion.Cancion.Duracion = obj_Row["Cancion_Duracion"] is DBNull ? null : (int?)obj_Row["Cancion_Duracion"];
                obj_LocalCancion.Cancion.Youtube = obj_Row["Cancion_Youtube"] is DBNull ? null : obj_Row["Cancion_Youtube"].ToString();

                //Canción Simple
                obj_LocalCancion.CancionSimple = new Entidad.Cancion();
                obj_LocalCancion.CancionSimple.IdCancionSimple = obj_Row["CancionSimple_IdCancionSimple"] is DBNull ? null : (int?)obj_Row["CancionSimple_IdCancionSimple"];
                obj_LocalCancion.CancionSimple.Descripcion = obj_Row["CancionSimple_Descripcion"] is DBNull ? null : obj_Row["CancionSimple_Descripcion"].ToString();

                if (!(obj_Row["Artista_IdArtista"] is DBNull))
                {
                    obj_LocalCancion.Cancion.Artista = new Kruma.KantaPe.Entidad.Artista();
                    obj_LocalCancion.Cancion.Artista.IdArtista = obj_Row["Artista_IdArtista"] == DBNull.Value ? null : (int?)obj_Row["Artista_IdArtista"];
                    obj_LocalCancion.Cancion.Artista.Nombre = obj_Row["Artista_Nombre"] is DBNull ? null : obj_Row["Artista_Nombre"].ToString();
                }

                if (!(obj_Row["Album_IdAlbum"] is DBNull))
                {
                    obj_LocalCancion.Cancion.Album = new Kruma.KantaPe.Entidad.Album();
                    obj_LocalCancion.Cancion.Album.IdAlbum = obj_Row["Album_IdAlbum"] == DBNull.Value ? null : (int?)obj_Row["Album_IdAlbum"];
                    obj_LocalCancion.Cancion.Album.Titulo = obj_Row["Album_Titulo"] is DBNull ? null : obj_Row["Album_Titulo"].ToString();
                }

                if (!(obj_Row["Genero_IdGenero"] is DBNull))
                {
                    obj_LocalCancion.Cancion.Genero = new Kruma.KantaPe.Entidad.Genero();
                    obj_LocalCancion.Cancion.Genero.IdGenero = obj_Row["Genero_IdGenero"] == DBNull.Value ? null : (int?)obj_Row["Genero_IdGenero"];
                    obj_LocalCancion.Cancion.Genero.Descripcion = obj_Row["Genero_Descripcion"] is DBNull ? null : obj_Row["Genero_Descripcion"].ToString();
                }

                if (!(obj_Row["Idioma_IdIdioma"] is DBNull))
                {
                    obj_LocalCancion.Cancion.Idioma = new Kruma.KantaPe.Entidad.Idioma();
                    obj_LocalCancion.Cancion.Idioma.IdIdioma = obj_Row["Idioma_IdIdioma"] == DBNull.Value ? null : (int?)obj_Row["Idioma_IdIdioma"];
                    obj_LocalCancion.Cancion.Idioma.Descripcion = obj_Row["Idioma_Descripcion"] is DBNull ? null : obj_Row["Idioma_Descripcion"].ToString();
                }

                lst_LocalCancion.Add(obj_LocalCancion);
            }

            obj_Lista.Result = lst_LocalCancion;
            return obj_Lista;
        }


        public static Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.LocalCancion> ListarCancionesUsuarioLogeado(
      int? int_pIdLocal,
      int? int_pIdCancion,

      int? int_pIdEmpresa,
      string str_pUsuarioLogeado,
      string str_pTitulo,
      string str_pArtista,
      string str_pAlbum,
      int? int_pIdGenero,
      int? int_pIdIdioma,

      string str_pEstado,
      int? int_pNumPagina,
      int? int_pTamPagina)
        {
            Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.LocalCancion> obj_Lista = new Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.LocalCancion>();
            obj_Lista.PageNumber = int_pNumPagina;
            obj_Lista.Total = 0;

            DataOperation dop_Operacion = new DataOperation("ListarLocalCancionPorUsuarioLogeado");
            dop_Operacion.Parameters.Add(new Parameter("@pIdLocal", int_pIdLocal.HasValue ? int_pIdLocal.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pIdCancion", int_pIdCancion.HasValue ? int_pIdCancion.Value : (object)DBNull.Value));

            dop_Operacion.Parameters.Add(new Parameter("@pIdEmpresa", int_pIdEmpresa.HasValue ? int_pIdEmpresa.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pUsuarioLogeado", !string.IsNullOrEmpty(str_pUsuarioLogeado) ? str_pUsuarioLogeado : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pTitulo", !string.IsNullOrEmpty(str_pTitulo) ? str_pTitulo : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pArtista", !string.IsNullOrEmpty(str_pArtista) ? str_pArtista : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pAlbum", !string.IsNullOrEmpty(str_pAlbum) ? str_pAlbum : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pIdGenero", int_pIdGenero.HasValue ? int_pIdGenero.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pIdIdioma", int_pIdIdioma.HasValue ? int_pIdIdioma.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pEstado", !string.IsNullOrEmpty(str_pEstado) ? str_pEstado : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pNumPagina", int_pNumPagina.HasValue ? int_pNumPagina.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pTamPagina", int_pTamPagina.HasValue ? int_pTamPagina.Value : (object)DBNull.Value));

            DataTable dt_Resultado = DataManager.ExecuteDataSet(Conexiones.CO_KantaPe, dop_Operacion).Tables[0];

            List<Kruma.KantaPe.Entidad.LocalCancion> lst_LocalCancion = new List<Kruma.KantaPe.Entidad.LocalCancion>();
            Kruma.KantaPe.Entidad.LocalCancion obj_LocalCancion = new Kruma.KantaPe.Entidad.LocalCancion();
            foreach (DataRow obj_Row in dt_Resultado.Rows)
            {
                if (lst_LocalCancion.Count == 0)
                    obj_Lista.Total = (int)obj_Row["Total_Filas"];
                obj_LocalCancion = new Kruma.KantaPe.Entidad.LocalCancion();
                obj_LocalCancion.IdLocal = obj_Row["IdLocal"] is DBNull ? null : (int?)obj_Row["IdLocal"];
                obj_LocalCancion.IdCancion = obj_Row["IdCancion"] is DBNull ? null : (int?)obj_Row["IdCancion"];
                obj_LocalCancion.Estado = obj_Row["Estado"] is DBNull ? null : obj_Row["Estado"].ToString();
                obj_LocalCancion.UsuarioCreacion = obj_Row["UsuarioCreacion"] is DBNull ? null : obj_Row["UsuarioCreacion"].ToString();
                obj_LocalCancion.FechaCreacion = obj_Row["FechaCreacion"] is DBNull ? null : (DateTime?)obj_Row["FechaCreacion"];
                obj_LocalCancion.UsuarioModificacion = obj_Row["UsuarioModificacion"] is DBNull ? null : obj_Row["UsuarioModificacion"].ToString();
                obj_LocalCancion.FechaModificacion = obj_Row["FechaModificacion"] is DBNull ? null : (DateTime?)obj_Row["FechaModificacion"];

                obj_LocalCancion.Local = new Kruma.KantaPe.Entidad.Local();
                obj_LocalCancion.Local.IdLocal = obj_Row["Local_IdLocal"] is DBNull ? null : (int?)obj_Row["Local_IdLocal"];
                obj_LocalCancion.Local.IdEmpresa = obj_Row["Local_IdEmpresa"] is DBNull ? null : (int?)obj_Row["Local_IdEmpresa"];
                obj_LocalCancion.Local.IdDireccion = obj_Row["Local_IdDireccion"] is DBNull ? null : (int?)obj_Row["Local_IdDireccion"];
                obj_LocalCancion.Local.Nombre = obj_Row["CorePersonaDireccion_Nombre"] is DBNull ? null : obj_Row["CorePersonaDireccion_Nombre"].ToString();
                obj_LocalCancion.Local.Direccion = obj_Row["CorePersonaDireccion_Direccion"] is DBNull ? null : obj_Row["CorePersonaDireccion_Direccion"].ToString();

                obj_LocalCancion.Local.Empresa = new Kruma.KantaPe.Entidad.Empresa();
                obj_LocalCancion.Local.Empresa.IdEmpresa = obj_Row["Empresa_IdEmpresa"] is DBNull ? null : (int?)obj_Row["Empresa_IdEmpresa"];
                obj_LocalCancion.Local.Empresa.IdPersona = obj_Row["CorePersona_IdPersona"] is DBNull ? null : (int?)obj_Row["CorePersona_IdPersona"];
                obj_LocalCancion.Local.Empresa.RazonSocial = obj_Row["CorePersona_RazonSocial"] is DBNull ? null : obj_Row["CorePersona_RazonSocial"].ToString();
                obj_LocalCancion.Local.Empresa.NombreComercial = obj_Row["CorePersona_NombreComercial"] is DBNull ? null : obj_Row["CorePersona_NombreComercial"].ToString();
                obj_LocalCancion.Local.Empresa.IdTipoDocumento = obj_Row["CorePersona_IdTipoDocumento"] is DBNull ? null : (int?)obj_Row["CorePersona_IdTipoDocumento"];
                obj_LocalCancion.Local.Empresa.NumeroDocumento = obj_Row["CorePersona_NumeroDocumento"] is DBNull ? null : obj_Row["CorePersona_NumeroDocumento"].ToString();

                //obj_LocalCancion.Local.Empresa.TipoDocumento = new Kruma.Core.Business.Entity.TipoDocumento();
                //obj_LocalCancion.Local.Empresa.TipoDocumento.IdTipoDocumento = obj_Row["TipoDocumento_IdTipoDocumento"] is DBNull ? null : (int?)obj_Row["TipoDocumento_IdTipoDocumento"];
                //obj_LocalCancion.Local.Empresa.TipoDocumento.Descripcion = obj_Row["TipoDocumento_Descripcion"] is DBNull ? null : obj_Row["TipoDocumento_Descripcion"].ToString();

                obj_LocalCancion.Cancion = new Kruma.KantaPe.Entidad.LocalCancion();
                obj_LocalCancion.Cancion.IdCancion = obj_Row["Cancion_IdCancion"] is DBNull ? null : (int?)obj_Row["Cancion_IdCancion"];
                //obj_LocalCancion.Cancion.Titulo = obj_Row["Cancion_Titulo"] is DBNull ? null : obj_Row["Cancion_Titulo"].ToString();
                obj_LocalCancion.Cancion.IdArtista = obj_Row["Cancion_IdArtista"] is DBNull ? null : (int?)obj_Row["Cancion_IdArtista"];
                obj_LocalCancion.Cancion.IdAlbum = obj_Row["Cancion_IdAlbum"] is DBNull ? null : (int?)obj_Row["Cancion_IdAlbum"];
                obj_LocalCancion.Cancion.IdGenero = obj_Row["Cancion_IdGenero"] is DBNull ? null : (int?)obj_Row["Cancion_IdGenero"];
                obj_LocalCancion.Cancion.IdIdioma = obj_Row["Cancion_IdIdioma"] is DBNull ? null : (int?)obj_Row["Cancion_IdIdioma"];
                obj_LocalCancion.Cancion.Decada = obj_Row["Cancion_Decada"] is DBNull ? null : obj_Row["Cancion_Decada"].ToString();
                obj_LocalCancion.Cancion.Version = obj_Row["Cancion_Version"] is DBNull ? null : obj_Row["Cancion_Version"].ToString();
                obj_LocalCancion.Cancion.NombreArchivo = obj_Row["Cancion_NombreArchivo"] is DBNull ? null : obj_Row["Cancion_NombreArchivo"].ToString();
                obj_LocalCancion.Cancion.FechaRegistro = obj_Row["Cancion_FechaRegistro"] == DBNull.Value ? null : ((DateTime?)obj_Row["Cancion_FechaRegistro"]);
                obj_LocalCancion.Cancion.Anio = obj_Row["Cancion_Anio"] is DBNull ? null : (int?)obj_Row["Cancion_Anio"];
                obj_LocalCancion.Cancion.Letra = obj_Row["Cancion_Letra"] is DBNull ? null : obj_Row["Cancion_Letra"].ToString();
                obj_LocalCancion.Cancion.Duracion = obj_Row["Cancion_Duracion"] is DBNull ? null : (int?)obj_Row["Cancion_Duracion"];
                obj_LocalCancion.Cancion.Youtube = obj_Row["Cancion_Youtube"] is DBNull ? null : obj_Row["Cancion_Youtube"].ToString();

                if (!(obj_Row["Artista_IdArtista"] is DBNull))
                {
                    obj_LocalCancion.Cancion.Artista = new Kruma.KantaPe.Entidad.Artista();
                    obj_LocalCancion.Cancion.Artista.IdArtista = obj_Row["Artista_IdArtista"] == DBNull.Value ? null : (int?)obj_Row["Artista_IdArtista"];
                    obj_LocalCancion.Cancion.Artista.Nombre = obj_Row["Artista_Nombre"] is DBNull ? null : obj_Row["Artista_Nombre"].ToString();
                }

                if (!(obj_Row["Album_IdAlbum"] is DBNull))
                {
                    obj_LocalCancion.Cancion.Album = new Kruma.KantaPe.Entidad.Album();
                    obj_LocalCancion.Cancion.Album.IdAlbum = obj_Row["Album_IdAlbum"] == DBNull.Value ? null : (int?)obj_Row["Album_IdAlbum"];
                    obj_LocalCancion.Cancion.Album.Titulo = obj_Row["Album_Titulo"] is DBNull ? null : obj_Row["Album_Titulo"].ToString();
                }

                if (!(obj_Row["Genero_IdGenero"] is DBNull))
                {
                    obj_LocalCancion.Cancion.Genero = new Kruma.KantaPe.Entidad.Genero();
                    obj_LocalCancion.Cancion.Genero.IdGenero = obj_Row["Genero_IdGenero"] == DBNull.Value ? null : (int?)obj_Row["Genero_IdGenero"];
                    obj_LocalCancion.Cancion.Genero.Descripcion = obj_Row["Genero_Descripcion"] is DBNull ? null : obj_Row["Genero_Descripcion"].ToString();
                }

                if (!(obj_Row["Idioma_IdIdioma"] is DBNull))
                {
                    obj_LocalCancion.Cancion.Idioma = new Kruma.KantaPe.Entidad.Idioma();
                    obj_LocalCancion.Cancion.Idioma.IdIdioma = obj_Row["Idioma_IdIdioma"] == DBNull.Value ? null : (int?)obj_Row["Idioma_IdIdioma"];
                    obj_LocalCancion.Cancion.Idioma.Descripcion = obj_Row["Idioma_Descripcion"] is DBNull ? null : obj_Row["Idioma_Descripcion"].ToString();
                }

                lst_LocalCancion.Add(obj_LocalCancion);
            }

            obj_Lista.Result = lst_LocalCancion;
            return obj_Lista;
        }
        public static Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.LocalCancion> ListarDoble(
           int? int_pIdLocal,
           int? int_pIdCancion,

           int? int_pIdEmpresa,
           string str_pPalabraClave1,
           string str_pPalabraClave2,
           string str_pTitulo,
           string str_pArtista,
           string str_pAlbum,
           int? int_pIdGenero,
           int? int_pIdIdioma,

           string str_pEstado,
           int? int_pNumPagina,
           int? int_pTamPagina)
        {
            Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.LocalCancion> obj_Lista = new Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.LocalCancion>();
            obj_Lista.PageNumber = int_pNumPagina;
            obj_Lista.Total = 0;

            DataOperation dop_Operacion = new DataOperation("ListarLocalCancionDoble");
            dop_Operacion.Parameters.Add(new Parameter("@pIdLocal", int_pIdLocal.HasValue ? int_pIdLocal.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pIdCancion", int_pIdCancion.HasValue ? int_pIdCancion.Value : (object)DBNull.Value));

            dop_Operacion.Parameters.Add(new Parameter("@pIdEmpresa", int_pIdEmpresa.HasValue ? int_pIdEmpresa.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pPalabraClave1", !string.IsNullOrEmpty(str_pPalabraClave1) ? str_pPalabraClave1 : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pPalabraClave2", !string.IsNullOrEmpty(str_pPalabraClave2) ? str_pPalabraClave2 : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pTitulo", !string.IsNullOrEmpty(str_pTitulo) ? str_pTitulo : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pArtista", !string.IsNullOrEmpty(str_pArtista) ? str_pArtista : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pAlbum", !string.IsNullOrEmpty(str_pAlbum) ? str_pAlbum : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pIdGenero", int_pIdGenero.HasValue ? int_pIdGenero.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pIdIdioma", int_pIdIdioma.HasValue ? int_pIdIdioma.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pEstado", !string.IsNullOrEmpty(str_pEstado) ? str_pEstado : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pNumPagina", int_pNumPagina.HasValue ? int_pNumPagina.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pTamPagina", int_pTamPagina.HasValue ? int_pTamPagina.Value : (object)DBNull.Value));

            DataTable dt_Resultado = DataManager.ExecuteDataSet(Conexiones.CO_KantaPe, dop_Operacion).Tables[0];

            List<Kruma.KantaPe.Entidad.LocalCancion> lst_LocalCancion = new List<Kruma.KantaPe.Entidad.LocalCancion>();
            Kruma.KantaPe.Entidad.LocalCancion obj_LocalCancion = new Kruma.KantaPe.Entidad.LocalCancion();
            foreach (DataRow obj_Row in dt_Resultado.Rows)
            {
                if (lst_LocalCancion.Count == 0)
                    obj_Lista.Total = (int)obj_Row["Total_Filas"];
                obj_LocalCancion = new Kruma.KantaPe.Entidad.LocalCancion();
                obj_LocalCancion.IdLocal = obj_Row["IdLocal"] is DBNull ? null : (int?)obj_Row["IdLocal"];
                obj_LocalCancion.IdCancion = obj_Row["IdCancion"] is DBNull ? null : (int?)obj_Row["IdCancion"];
                obj_LocalCancion.Estado = obj_Row["Estado"] is DBNull ? null : obj_Row["Estado"].ToString();
                obj_LocalCancion.UsuarioCreacion = obj_Row["UsuarioCreacion"] is DBNull ? null : obj_Row["UsuarioCreacion"].ToString();
                obj_LocalCancion.FechaCreacion = obj_Row["FechaCreacion"] is DBNull ? null : (DateTime?)obj_Row["FechaCreacion"];
                obj_LocalCancion.UsuarioModificacion = obj_Row["UsuarioModificacion"] is DBNull ? null : obj_Row["UsuarioModificacion"].ToString();
                obj_LocalCancion.FechaModificacion = obj_Row["FechaModificacion"] is DBNull ? null : (DateTime?)obj_Row["FechaModificacion"];

                obj_LocalCancion.Local = new Kruma.KantaPe.Entidad.Local();
                obj_LocalCancion.Local.IdLocal = obj_Row["Local_IdLocal"] is DBNull ? null : (int?)obj_Row["Local_IdLocal"];
                obj_LocalCancion.Local.IdEmpresa = obj_Row["Local_IdEmpresa"] is DBNull ? null : (int?)obj_Row["Local_IdEmpresa"];
                obj_LocalCancion.Local.IdDireccion = obj_Row["Local_IdDireccion"] is DBNull ? null : (int?)obj_Row["Local_IdDireccion"];
                obj_LocalCancion.Local.Nombre = obj_Row["CorePersonaDireccion_Nombre"] is DBNull ? null : obj_Row["CorePersonaDireccion_Nombre"].ToString();
                obj_LocalCancion.Local.Direccion = obj_Row["CorePersonaDireccion_Direccion"] is DBNull ? null : obj_Row["CorePersonaDireccion_Direccion"].ToString();

                obj_LocalCancion.Local.Empresa = new Kruma.KantaPe.Entidad.Empresa();
                obj_LocalCancion.Local.Empresa.IdEmpresa = obj_Row["Empresa_IdEmpresa"] is DBNull ? null : (int?)obj_Row["Empresa_IdEmpresa"];
                obj_LocalCancion.Local.Empresa.IdPersona = obj_Row["CorePersona_IdPersona"] is DBNull ? null : (int?)obj_Row["CorePersona_IdPersona"];
                obj_LocalCancion.Local.Empresa.RazonSocial = obj_Row["CorePersona_RazonSocial"] is DBNull ? null : obj_Row["CorePersona_RazonSocial"].ToString();
                obj_LocalCancion.Local.Empresa.NombreComercial = obj_Row["CorePersona_NombreComercial"] is DBNull ? null : obj_Row["CorePersona_NombreComercial"].ToString();
                obj_LocalCancion.Local.Empresa.IdTipoDocumento = obj_Row["CorePersona_IdTipoDocumento"] is DBNull ? null : (int?)obj_Row["CorePersona_IdTipoDocumento"];
                obj_LocalCancion.Local.Empresa.NumeroDocumento = obj_Row["CorePersona_NumeroDocumento"] is DBNull ? null : obj_Row["CorePersona_NumeroDocumento"].ToString();

                //obj_LocalCancion.Local.Empresa.TipoDocumento = new Kruma.Core.Business.Entity.TipoDocumento();
                //obj_LocalCancion.Local.Empresa.TipoDocumento.IdTipoDocumento = obj_Row["TipoDocumento_IdTipoDocumento"] is DBNull ? null : (int?)obj_Row["TipoDocumento_IdTipoDocumento"];
                //obj_LocalCancion.Local.Empresa.TipoDocumento.Descripcion = obj_Row["TipoDocumento_Descripcion"] is DBNull ? null : obj_Row["TipoDocumento_Descripcion"].ToString();

                obj_LocalCancion.Cancion = new Kruma.KantaPe.Entidad.LocalCancion();
                obj_LocalCancion.Cancion.IdCancion = obj_Row["Cancion_IdCancion"] is DBNull ? null : (int?)obj_Row["Cancion_IdCancion"];
                //obj_LocalCancion.Cancion.Titulo = obj_Row["Cancion_Titulo"] is DBNull ? null : obj_Row["Cancion_Titulo"].ToString();
                obj_LocalCancion.Cancion.IdArtista = obj_Row["Cancion_IdArtista"] is DBNull ? null : (int?)obj_Row["Cancion_IdArtista"];
                obj_LocalCancion.Cancion.IdAlbum = obj_Row["Cancion_IdAlbum"] is DBNull ? null : (int?)obj_Row["Cancion_IdAlbum"];
                obj_LocalCancion.Cancion.IdGenero = obj_Row["Cancion_IdGenero"] is DBNull ? null : (int?)obj_Row["Cancion_IdGenero"];
                obj_LocalCancion.Cancion.IdIdioma = obj_Row["Cancion_IdIdioma"] is DBNull ? null : (int?)obj_Row["Cancion_IdIdioma"];
                obj_LocalCancion.Cancion.Decada = obj_Row["Cancion_Decada"] is DBNull ? null : obj_Row["Cancion_Decada"].ToString();
                obj_LocalCancion.Cancion.Version = obj_Row["Cancion_Version"] is DBNull ? null : obj_Row["Cancion_Version"].ToString();
                obj_LocalCancion.Cancion.NombreArchivo = obj_Row["Cancion_NombreArchivo"] is DBNull ? null : obj_Row["Cancion_NombreArchivo"].ToString();
                obj_LocalCancion.Cancion.FechaRegistro = obj_Row["Cancion_FechaRegistro"] == DBNull.Value ? null : ((DateTime?)obj_Row["Cancion_FechaRegistro"]);
                obj_LocalCancion.Cancion.Anio = obj_Row["Cancion_Anio"] is DBNull ? null : (int?)obj_Row["Cancion_Anio"];
                obj_LocalCancion.Cancion.Letra = obj_Row["Cancion_Letra"] is DBNull ? null : obj_Row["Cancion_Letra"].ToString();
                obj_LocalCancion.Cancion.Duracion = obj_Row["Cancion_Duracion"] is DBNull ? null : (int?)obj_Row["Cancion_Duracion"];
                obj_LocalCancion.Cancion.Youtube = obj_Row["Cancion_Youtube"] is DBNull ? null : obj_Row["Cancion_Youtube"].ToString();

                if (!(obj_Row["Artista_IdArtista"] is DBNull))
                {
                    obj_LocalCancion.Cancion.Artista = new Kruma.KantaPe.Entidad.Artista();
                    obj_LocalCancion.Cancion.Artista.IdArtista = obj_Row["Artista_IdArtista"] == DBNull.Value ? null : (int?)obj_Row["Artista_IdArtista"];
                    obj_LocalCancion.Cancion.Artista.Nombre = obj_Row["Artista_Nombre"] is DBNull ? null : obj_Row["Artista_Nombre"].ToString();
                }

                if (!(obj_Row["Album_IdAlbum"] is DBNull))
                {
                    obj_LocalCancion.Cancion.Album = new Kruma.KantaPe.Entidad.Album();
                    obj_LocalCancion.Cancion.Album.IdAlbum = obj_Row["Album_IdAlbum"] == DBNull.Value ? null : (int?)obj_Row["Album_IdAlbum"];
                    obj_LocalCancion.Cancion.Album.Titulo = obj_Row["Album_Titulo"] is DBNull ? null : obj_Row["Album_Titulo"].ToString();
                }

                if (!(obj_Row["Genero_IdGenero"] is DBNull))
                {
                    obj_LocalCancion.Cancion.Genero = new Kruma.KantaPe.Entidad.Genero();
                    obj_LocalCancion.Cancion.Genero.IdGenero = obj_Row["Genero_IdGenero"] == DBNull.Value ? null : (int?)obj_Row["Genero_IdGenero"];
                    obj_LocalCancion.Cancion.Genero.Descripcion = obj_Row["Genero_Descripcion"] is DBNull ? null : obj_Row["Genero_Descripcion"].ToString();
                }

                if (!(obj_Row["Idioma_IdIdioma"] is DBNull))
                {
                    obj_LocalCancion.Cancion.Idioma = new Kruma.KantaPe.Entidad.Idioma();
                    obj_LocalCancion.Cancion.Idioma.IdIdioma = obj_Row["Idioma_IdIdioma"] == DBNull.Value ? null : (int?)obj_Row["Idioma_IdIdioma"];
                    obj_LocalCancion.Cancion.Idioma.Descripcion = obj_Row["Idioma_Descripcion"] is DBNull ? null : obj_Row["Idioma_Descripcion"].ToString();
                }

                lst_LocalCancion.Add(obj_LocalCancion);
            }

            obj_Lista.Result = lst_LocalCancion;
            return obj_Lista;
        }

        /// <summary>Obtener LocalCancion</summary>
        /// <param name="int_pIdLocal">IdLocal</param>
        /// <param name="int_pIdCancion">IdCancion</param>
        /// <returns>Objeto LocalCancion</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>12-07-2016</FecCrea></item></list></remarks>
        public static Kruma.KantaPe.Entidad.LocalCancion Obtener(int int_pIdLocal, int int_pIdCancion)
        {
            Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.LocalCancion> lst_LocalCancion = Listar(int_pIdLocal, int_pIdCancion, null, null, null, null, null, null, null, null, null, null);
            return lst_LocalCancion.Result.Count > 0 ? lst_LocalCancion.Result[0] : null;
        }

        /// <summary>Insertar LocalCancion</summary>
        /// <param name="obj_pLocalCancion">LocalCancion</param>
        /// <returns>Id de LocalCancion</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>12-07-2016</FecCrea></item></list></remarks>
        public static void Insertar(Kruma.KantaPe.Entidad.LocalCancion obj_pLocalCancion)
        {
            DataOperation dop_Operacion = new DataOperation("InsertarLocalCancion");

            dop_Operacion.Parameters.Add(new Parameter("@pIdLocal", obj_pLocalCancion.IdLocal));
            dop_Operacion.Parameters.Add(new Parameter("@pIdCancion", obj_pLocalCancion.IdCancion));
            dop_Operacion.Parameters.Add(new Parameter("@pEstado", obj_pLocalCancion.Estado));
            dop_Operacion.Parameters.Add(new Parameter("@pUsuarioCreacion", obj_pLocalCancion.UsuarioCreacion));

            DataManager.ExecuteNonQuery(Conexiones.CO_KantaPe, dop_Operacion, false);
        }

        /// <summary>Modificar LocalCancion</summary>
        /// <param name="obj_pLocalCancion">LocalCancion</param>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>12-07-2016</FecCrea></item></list></remarks>
        public static void Modificar(Kruma.KantaPe.Entidad.LocalCancion obj_pLocalCancion)
        {
            DataOperation dop_Operacion = new DataOperation("ActualizarLocalCancion");

            dop_Operacion.Parameters.Add(new Parameter("@pIdLocal", obj_pLocalCancion.IdLocal));
            dop_Operacion.Parameters.Add(new Parameter("@pIdCancion", obj_pLocalCancion.IdCancion));
            dop_Operacion.Parameters.Add(new Parameter("@pEstado", obj_pLocalCancion.Estado));
            dop_Operacion.Parameters.Add(new Parameter("@pUsuarioModificacion", obj_pLocalCancion.UsuarioModificacion));

            DataManager.ExecuteNonQuery(Conexiones.CO_KantaPe, dop_Operacion, false);
        }

        #endregion
    }
}