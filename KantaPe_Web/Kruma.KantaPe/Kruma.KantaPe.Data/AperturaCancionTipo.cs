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
    /// <summary>Tipo de apertura de cancion</summary>
    /// <remarks><list type="bullet">
    /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
    /// <item><FecCrea>25-07-2016</FecCrea></item></list></remarks>

    public class AperturaCancionTipo
    {
        #region Metodos Públicos

        /// <summary>Listado de AperturaCancionTipo</summary>
        /// <param name="int_pIdAperturaCancionTipo">IdAperturaCancionTipo</param>
        /// <param name="str_pDescripcion">Descripcion</param>
        /// <param name="str_pEstado">Estado</param>
        /// <param name="int_pNumPagina" >Numero de pagina</param>
        /// <param name="int_pTamPagina" >Tamaño de pagina</param>
        /// <returns>Lista de AperturaCancionTipo</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>25-07-2016</FecCrea></item></list></remarks>
        public static Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.AperturaCancionTipo> Listar(
            int? int_pIdAperturaCancionTipo,
            string str_pDescripcion,
            string str_pEstado,
            int? int_pNumPagina,
            int? int_pTamPagina)
        {
            Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.AperturaCancionTipo> obj_Lista = new Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.AperturaCancionTipo>();
            obj_Lista.PageNumber = int_pNumPagina;
            obj_Lista.Total = 0;

            DataOperation dop_Operacion = new DataOperation("ListarAperturaCancionTipo");
            dop_Operacion.Parameters.Add(new Parameter("@pIdAperturaCancionTipo", int_pIdAperturaCancionTipo.HasValue ? int_pIdAperturaCancionTipo.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pDescripcion", !string.IsNullOrEmpty(str_pDescripcion) ? str_pDescripcion : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pEstado", !string.IsNullOrEmpty(str_pEstado) ? str_pEstado : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pNumPagina", int_pNumPagina.HasValue ? int_pNumPagina.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pTamPagina", int_pTamPagina.HasValue ? int_pTamPagina.Value : (object)DBNull.Value));

            DataTable dt_Resultado = DataManager.ExecuteDataSet(Conexiones.CO_KantaPe, dop_Operacion).Tables[0];

            List<Kruma.KantaPe.Entidad.AperturaCancionTipo> lst_AperturaCancionTipo = new List<Kruma.KantaPe.Entidad.AperturaCancionTipo>();
            Kruma.KantaPe.Entidad.AperturaCancionTipo obj_AperturaCancionTipo = new Kruma.KantaPe.Entidad.AperturaCancionTipo();
            foreach (DataRow obj_Row in dt_Resultado.Rows)
            {
                if (lst_AperturaCancionTipo.Count == 0)
                    obj_Lista.Total = (int)obj_Row["Total_Filas"];
                obj_AperturaCancionTipo = new Kruma.KantaPe.Entidad.AperturaCancionTipo();
                obj_AperturaCancionTipo.IdAperturaCancionTipo = obj_Row["IdAperturaCancionTipo"] is DBNull ? null : (int?)obj_Row["IdAperturaCancionTipo"];
                obj_AperturaCancionTipo.Descripcion = obj_Row["Descripcion"] is DBNull ? null : obj_Row["Descripcion"].ToString();
                obj_AperturaCancionTipo.Estado = obj_Row["Estado"] is DBNull ? null : obj_Row["Estado"].ToString();
                obj_AperturaCancionTipo.UsuarioCreacion = obj_Row["UsuarioCreacion"] is DBNull ? null : obj_Row["UsuarioCreacion"].ToString();
                obj_AperturaCancionTipo.FechaCreacion = obj_Row["FechaCreacion"] is DBNull ? null : (DateTime?)obj_Row["FechaCreacion"];
                obj_AperturaCancionTipo.UsuarioModificacion = obj_Row["UsuarioModificacion"] is DBNull ? null : obj_Row["UsuarioModificacion"].ToString();
                obj_AperturaCancionTipo.FechaModificacion = obj_Row["FechaModificacion"] is DBNull ? null : (DateTime?)obj_Row["FechaModificacion"];
                lst_AperturaCancionTipo.Add(obj_AperturaCancionTipo);
            }

            obj_Lista.Result = lst_AperturaCancionTipo;
            return obj_Lista;
        }

        /// <summary>Obtener tipo de cancion de apertura</summary>
        /// <param name="int_pIdAperturaCancionTipo">IdAperturaCancionTipo</param>
        /// <returns>Objeto AperturaCancionTipo</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>25-07-2016</FecCrea></item></list></remarks>
        public static Kruma.KantaPe.Entidad.AperturaCancionTipo Obtener(int int_pIdAperturaCancionTipo)
        {
            Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.AperturaCancionTipo> lst_AperturaCancionTipo = Listar(int_pIdAperturaCancionTipo, null, null, null, null);
            return lst_AperturaCancionTipo.Result.Count > 0 ? lst_AperturaCancionTipo.Result[0] : null;
        }

        /// <summary>Insertar tipo de cancion de apertura</summary>
        /// <param name="obj_pAperturaCancionTipo">AperturaCancionTipo</param>
        /// <returns>Id de AperturaCancionTipo</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>25-07-2016</FecCrea></item></list></remarks>
        public static int Insertar(Kruma.KantaPe.Entidad.AperturaCancionTipo obj_pAperturaCancionTipo)
        {
            DataOperation dop_Operacion = new DataOperation("InsertarAperturaCancionTipo");

            dop_Operacion.Parameters.Add(new Parameter("@pDescripcion", obj_pAperturaCancionTipo.Descripcion));
            dop_Operacion.Parameters.Add(new Parameter("@pEstado", obj_pAperturaCancionTipo.Estado));
            dop_Operacion.Parameters.Add(new Parameter("@pUsuarioCreacion", obj_pAperturaCancionTipo.UsuarioCreacion));

            Parameter obj_IdAperturaCancionTipo = new Parameter("@pIdAperturaCancionTipo", DbType.Int32);
            obj_IdAperturaCancionTipo.Direction = ParameterDirection.Output;
            dop_Operacion.Parameters.Add(obj_IdAperturaCancionTipo);

            DataManager.ExecuteNonQuery(Conexiones.CO_KantaPe, dop_Operacion, false);
            int int_IdAperturaCancionTipo = (int)obj_IdAperturaCancionTipo.Value;
            return int_IdAperturaCancionTipo;
        }

        /// <summary>Modificar AperturaCancionTipo</summary>
        /// <param name="obj_pAperturaCancionTipo">AperturaCancionTipo</param>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>25-07-2016</FecCrea></item></list></remarks>
        public static void Modificar(Kruma.KantaPe.Entidad.AperturaCancionTipo obj_pAperturaCancionTipo)
        {
            DataOperation dop_Operacion = new DataOperation("ActualizarAperturaCancionTipo");

            dop_Operacion.Parameters.Add(new Parameter("@pIdAperturaCancionTipo", obj_pAperturaCancionTipo.IdAperturaCancionTipo));
            dop_Operacion.Parameters.Add(new Parameter("@pDescripcion", obj_pAperturaCancionTipo.Descripcion));
            dop_Operacion.Parameters.Add(new Parameter("@pEstado", obj_pAperturaCancionTipo.Estado));
            dop_Operacion.Parameters.Add(new Parameter("@pUsuarioModificacion", obj_pAperturaCancionTipo.UsuarioModificacion));

            DataManager.ExecuteNonQuery(Conexiones.CO_KantaPe, dop_Operacion, false);
        }

        #endregion
    }
}