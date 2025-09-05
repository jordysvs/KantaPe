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
    
    public class Artista
    {

        #region Metodos Públicos

        /// <summary>Listado de Artista</summary>
        /// <param name="int_pIdArtista">Id del artista</param>
        /// <param name="str_pNombre">Nombre del artista</param>
        /// <param name="str_pEstado">Estado del artista</param>
        /// <param name="int_pNumPagina" >Numero de pagina</param>
        /// <param name="int_pTamPagina" >Tamaño de pagina</param>
        /// <returns>Lista de Artista</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por Carlos Gómez</CreadoPor></item>
        /// <item><FecCrea>02-07-2016</FecCrea></item></list></remarks>
        public static Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Artista> Listar(
            int? int_pIdArtista,
            string str_pNombre,
            string str_pEstado,
            int? int_pNumPagina,
            int? int_pTamPagina)
        {
            Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Artista> obj_Lista = new Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Artista>();
            obj_Lista.PageNumber = int_pNumPagina;
            obj_Lista.Total = 0;


            Kruma.Core.Data.Entity.DataOperation dop_Operacion = new Kruma.Core.Data.Entity.DataOperation("ListarArtista");
            dop_Operacion.Parameters.Add(new Kruma.Core.Data.Entity.Parameter("@pIdArtista", int_pIdArtista.HasValue ? int_pIdArtista.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Kruma.Core.Data.Entity.Parameter("@pNombre", !string.IsNullOrEmpty(str_pNombre) ? str_pNombre : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Kruma.Core.Data.Entity.Parameter("@pEstado", !string.IsNullOrEmpty(str_pEstado) ? str_pEstado : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Kruma.Core.Data.Entity.Parameter("@pNumPagina", int_pNumPagina.HasValue ? int_pNumPagina.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Kruma.Core.Data.Entity.Parameter("@pTamPagina", int_pTamPagina.HasValue ? int_pTamPagina.Value : (object)DBNull.Value));

            DataTable dt_Resultado = Kruma.Core.Data.DataManager.ExecuteDataSet(Conexiones.CO_KantaPe, dop_Operacion).Tables[0];

            List<Kruma.KantaPe.Entidad.Artista> lst_Artista = new List<Kruma.KantaPe.Entidad.Artista>();
            Kruma.KantaPe.Entidad.Artista obj_Artista = new Kruma.KantaPe.Entidad.Artista();
            foreach (DataRow obj_Row in dt_Resultado.Rows)
            {
                if (lst_Artista.Count == 0)
                    obj_Lista.Total = (int)obj_Row["Total_Filas"];
                obj_Artista = new Kruma.KantaPe.Entidad.Artista();
                obj_Artista.IdArtista = obj_Row["IdArtista"] is DBNull ? null : (int?)obj_Row["IdArtista"];
                obj_Artista.Nombre = obj_Row["Nombre"] is DBNull ? null : obj_Row["Nombre"].ToString();
                obj_Artista.Estado = obj_Row["Estado"] is DBNull ? null : obj_Row["Estado"].ToString();
                obj_Artista.UsuarioCreacion = obj_Row["UsuarioCreacion"] is DBNull ? null : obj_Row["UsuarioCreacion"].ToString();
                obj_Artista.FechaCreacion = obj_Row["FechaCreacion"] is DBNull ? null : (DateTime?)obj_Row["FechaCreacion"];
                obj_Artista.UsuarioModificacion = obj_Row["UsuarioModificacion"] is DBNull ? null : obj_Row["UsuarioModificacion"].ToString();
                obj_Artista.FechaModificacion = obj_Row["FechaModificacion"] is DBNull ? null : (DateTime?)obj_Row["FechaModificacion"];
                lst_Artista.Add(obj_Artista);
            }

            obj_Lista.Result = lst_Artista;
            return obj_Lista;
        }

        /// <summary>Obtener Artista</summary>
        /// <param name="int_pIdArtista">Id del artista</param>
        /// <returns>Objeto Artista</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por Carlos Gómez</CreadoPor></item>
        /// <item><FecCrea>02-07-2016</FecCrea></item></list></remarks>
        public static Kruma.KantaPe.Entidad.Artista Obtener(int int_pIdArtista)
        {
            Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Artista> lst_Artista = Listar(int_pIdArtista, null, null, null, null);
            return lst_Artista.Result.Count > 0 ? lst_Artista.Result[0] : null;
        }

        /// <summary>Insertar Artista</summary>
        /// <param name="obj_pArtista">Artista</param>
        /// <returns>Id del artista</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por Carlos Gómez</CreadoPor></item>
        /// <item><FecCrea>02-07-2016</FecCrea></item></list></remarks>
        public static int Insertar(Kruma.KantaPe.Entidad.Artista obj_pArtista)
        {
            Kruma.Core.Data.Entity.DataOperation dop_Operacion = new Kruma.Core.Data.Entity.DataOperation("InsertarArtista");

            dop_Operacion.Parameters.Add(new Kruma.Core.Data.Entity.Parameter("@pNombre", obj_pArtista.Nombre));
            dop_Operacion.Parameters.Add(new Kruma.Core.Data.Entity.Parameter("@pEstado", obj_pArtista.Estado));
            dop_Operacion.Parameters.Add(new Kruma.Core.Data.Entity.Parameter("@pUsuarioCreacion", obj_pArtista.UsuarioCreacion));

            Kruma.Core.Data.Entity.Parameter obj_IdArtista = new Kruma.Core.Data.Entity.Parameter("@pIdArtista", DbType.Int32);
            obj_IdArtista.Direction = ParameterDirection.Output;
            dop_Operacion.Parameters.Add(obj_IdArtista);

            Kruma.Core.Data.DataManager.ExecuteNonQuery(Conexiones.CO_KantaPe, dop_Operacion, false);
            int int_IdArtista = (int)obj_IdArtista.Value;

            return int_IdArtista;
        }

        /// <summary>Modificar Artista</summary>
        /// <param name="obj_pArtista">Artista</param>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por Carlos Gómez</CreadoPor></item>
        /// <item><FecCrea>02-07-2016</FecCrea></item></list></remarks>
        public static void Modificar(Kruma.KantaPe.Entidad.Artista obj_pArtista)
        {
            Kruma.Core.Data.Entity.DataOperation dop_Operacion = new Kruma.Core.Data.Entity.DataOperation("ActualizarArtista");

            dop_Operacion.Parameters.Add(new Kruma.Core.Data.Entity.Parameter("@pIdArtista", obj_pArtista.IdArtista));
            dop_Operacion.Parameters.Add(new Kruma.Core.Data.Entity.Parameter("@pNombre", obj_pArtista.Nombre));
            dop_Operacion.Parameters.Add(new Kruma.Core.Data.Entity.Parameter("@pEstado", obj_pArtista.Estado));
            dop_Operacion.Parameters.Add(new Kruma.Core.Data.Entity.Parameter("@pUsuarioModificacion", obj_pArtista.UsuarioModificacion));

            Kruma.Core.Data.DataManager.ExecuteNonQuery(Conexiones.CO_KantaPe, dop_Operacion, false);
        }

        #endregion

    }
}
