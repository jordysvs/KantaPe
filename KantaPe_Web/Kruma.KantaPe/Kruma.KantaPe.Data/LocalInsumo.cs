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
    /// <summary>LocalInsumo</summary>
    /// <remarks><list type="bullet">
    /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
    /// <item><FecCrea>12-07-2016</FecCrea></item></list></remarks>

    public class LocalInsumo
    {
        #region Metodos Públicos

        /// <summary>Listado de LocalInsumo</summary>
        /// <param name="int_pIdLocal">IdLocal</param>
        /// <param name="int_pIdInsumo">IdInsumo</param>
        /// <param name="int_pCantidad">Cantidad</param>
        /// <param name="int_pMinimo">Minimo</param>
        /// <param name="str_pEstado">Estado</param>
        /// <param name="int_pNumPagina" >Numero de pagina</param>
        /// <param name="int_pTamPagina" >Tamaño de pagina</param>
        /// <returns>Lista de LocalInsumo</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>12-07-2016</FecCrea></item></list></remarks>
        public static Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.LocalInsumo> Listar(
            int? int_pIdLocal,
            int? int_pIdInsumo,
            string str_pEstado,
            int? int_pNumPagina,
            int? int_pTamPagina)
        {
            Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.LocalInsumo> obj_Lista = new Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.LocalInsumo>();
            obj_Lista.PageNumber = int_pNumPagina;
            obj_Lista.Total = 0;

            DataOperation dop_Operacion = new DataOperation("ListarLocalInsumo");
            dop_Operacion.Parameters.Add(new Parameter("@pIdLocal", int_pIdLocal.HasValue ? int_pIdLocal.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pIdInsumo", int_pIdInsumo.HasValue ? int_pIdInsumo.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pEstado", !string.IsNullOrEmpty(str_pEstado) ? str_pEstado : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pNumPagina", int_pNumPagina.HasValue ? int_pNumPagina.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pTamPagina", int_pTamPagina.HasValue ? int_pTamPagina.Value : (object)DBNull.Value));

            DataTable dt_Resultado = DataManager.ExecuteDataSet(Conexiones.CO_KantaPe, dop_Operacion).Tables[0];

            List<Kruma.KantaPe.Entidad.LocalInsumo> lst_LocalInsumo = new List<Kruma.KantaPe.Entidad.LocalInsumo>();
            Kruma.KantaPe.Entidad.LocalInsumo obj_LocalInsumo = new Kruma.KantaPe.Entidad.LocalInsumo();
            foreach (DataRow obj_Row in dt_Resultado.Rows)
            {
                if (lst_LocalInsumo.Count == 0)
                    obj_Lista.Total = (int)obj_Row["Total_Filas"];
                obj_LocalInsumo = new Kruma.KantaPe.Entidad.LocalInsumo();
                obj_LocalInsumo.IdLocal = obj_Row["IdLocal"] is DBNull ? null : (int?)obj_Row["IdLocal"];
                obj_LocalInsumo.IdInsumo = obj_Row["IdInsumo"] is DBNull ? null : (int?)obj_Row["IdInsumo"];
                obj_LocalInsumo.Cantidad = obj_Row["Cantidad"] is DBNull ? null : (int?)obj_Row["Cantidad"];
                obj_LocalInsumo.Minimo = obj_Row["Minimo"] is DBNull ? null : (int?)obj_Row["Minimo"];
                obj_LocalInsumo.Estado = obj_Row["Estado"] is DBNull ? null : obj_Row["Estado"].ToString();
                obj_LocalInsumo.UsuarioCreacion = obj_Row["UsuarioCreacion"] is DBNull ? null : obj_Row["UsuarioCreacion"].ToString();
                obj_LocalInsumo.FechaCreacion = obj_Row["FechaCreacion"] is DBNull ? null : (DateTime?)obj_Row["FechaCreacion"];
                obj_LocalInsumo.UsuarioModificacion = obj_Row["UsuarioModificacion"] is DBNull ? null : obj_Row["UsuarioModificacion"].ToString();
                obj_LocalInsumo.FechaModificacion = obj_Row["FechaModificacion"] is DBNull ? null : (DateTime?)obj_Row["FechaModificacion"];
                lst_LocalInsumo.Add(obj_LocalInsumo);
            }

            obj_Lista.Result = lst_LocalInsumo;
            return obj_Lista;
        }

        /// <summary>Obtener LocalInsumo</summary>
        /// <param name="int_pIdLocal">IdLocal</param>
        /// <param name="int_pIdInsumo">IdInsumo</param>
        /// <returns>Objeto LocalInsumo</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>12-07-2016</FecCrea></item></list></remarks>
        public static Kruma.KantaPe.Entidad.LocalInsumo Obtener(int int_pIdLocal, int int_pIdInsumo)
        {
            Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.LocalInsumo> lst_LocalInsumo = Listar(int_pIdLocal, int_pIdInsumo, null, null, null);
            return lst_LocalInsumo.Result.Count > 0 ? lst_LocalInsumo.Result[0] : null;
        }

        /// <summary>Insertar LocalInsumo</summary>
        /// <param name="obj_pLocalInsumo">LocalInsumo</param>
        /// <returns>Id de LocalInsumo</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>12-07-2016</FecCrea></item></list></remarks>
        public static void Insertar(Kruma.KantaPe.Entidad.LocalInsumo obj_pLocalInsumo)
        {
            DataOperation dop_Operacion = new DataOperation("InsertarLocalInsumo");

            dop_Operacion.Parameters.Add(new Parameter("@pIdLocal", obj_pLocalInsumo.IdLocal));
            dop_Operacion.Parameters.Add(new Parameter("@pIdInsumo", obj_pLocalInsumo.IdInsumo));
            dop_Operacion.Parameters.Add(new Parameter("@pCantidad", obj_pLocalInsumo.Cantidad));
            dop_Operacion.Parameters.Add(new Parameter("@pMinimo", obj_pLocalInsumo.Minimo));
            dop_Operacion.Parameters.Add(new Parameter("@pUsuarioCreacion", obj_pLocalInsumo.UsuarioCreacion));

            DataManager.ExecuteNonQuery(Conexiones.CO_KantaPe, dop_Operacion, false);
        }

        /// <summary>Modificar LocalInsumo</summary>
        /// <param name="obj_pLocalInsumo">LocalInsumo</param>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>12-07-2016</FecCrea></item></list></remarks>
        public static void Modificar(Kruma.KantaPe.Entidad.LocalInsumo obj_pLocalInsumo)
        {
            DataOperation dop_Operacion = new DataOperation("ActualizarLocalInsumo");

            dop_Operacion.Parameters.Add(new Parameter("@pIdLocal", obj_pLocalInsumo.IdLocal));
            dop_Operacion.Parameters.Add(new Parameter("@pIdInsumo", obj_pLocalInsumo.IdInsumo));
            dop_Operacion.Parameters.Add(new Parameter("@pCantidad", obj_pLocalInsumo.Cantidad));
            dop_Operacion.Parameters.Add(new Parameter("@pMinimo", obj_pLocalInsumo.Minimo));
            dop_Operacion.Parameters.Add(new Parameter("@pEstado", obj_pLocalInsumo.Estado));
            dop_Operacion.Parameters.Add(new Parameter("@pUsuarioModificacion", obj_pLocalInsumo.UsuarioModificacion));

            DataManager.ExecuteNonQuery(Conexiones.CO_KantaPe, dop_Operacion, false);
        }

        #endregion
    }
}