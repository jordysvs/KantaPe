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
    /// <summary>Token</summary>
    /// <remarks><list type="bullet">
    /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
    /// <item><FecCrea>13-04-2017</FecCrea></item></list></remarks>

    public class Token
    {
        #region Metodos Públicos

        /// <summary>Listado de Token</summary>
        /// <param name="str_pIdUsuario">IdUsuario</param>
        /// <param name="str_pIdToken">IdToken</param>
        /// <param name="str_pEstado">Estado</param>
        /// <param name="int_pNumPagina" >Numero de pagina</param>
        /// <param name="int_pTamPagina" >Tamaño de pagina</param>
        /// <returns>Lista de Token</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>13-04-2017</FecCrea></item></list></remarks>
        public static Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Token> Listar(
            string str_pIdUsuario,
            string str_pIdToken,
            string str_pEstado,
            int? int_pNumPagina,
            int? int_pTamPagina)
        {
            Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Token> obj_Lista = new Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Token>();
            obj_Lista.PageNumber = int_pNumPagina;
            obj_Lista.Total = 0;

            DataOperation dop_Operacion = new DataOperation("ListarToken");
            dop_Operacion.Parameters.Add(new Parameter("@pIdUsuario", !string.IsNullOrEmpty(str_pIdUsuario) ? str_pIdUsuario : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pIdToken", !string.IsNullOrEmpty(str_pIdToken) ? str_pIdToken : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pEstado", !string.IsNullOrEmpty(str_pEstado) ? str_pEstado : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pNumPagina", int_pNumPagina.HasValue ? int_pNumPagina.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pTamPagina", int_pTamPagina.HasValue ? int_pTamPagina.Value : (object)DBNull.Value));

            DataTable dt_Resultado = DataManager.ExecuteDataSet(Conexiones.CO_KantaPe, dop_Operacion).Tables[0];

            List<Kruma.KantaPe.Entidad.Token> lst_Token = new List<Kruma.KantaPe.Entidad.Token>();
            Kruma.KantaPe.Entidad.Token obj_Token = new Kruma.KantaPe.Entidad.Token();
            foreach (DataRow obj_Row in dt_Resultado.Rows)
            {
                if (lst_Token.Count == 0)
                    obj_Lista.Total = (int)obj_Row["Total_Filas"];
                obj_Token = new Kruma.KantaPe.Entidad.Token();
                obj_Token.IdUsuario = obj_Row["IdUsuario"] is DBNull ? null : obj_Row["IdUsuario"].ToString();
                obj_Token.IdToken = obj_Row["IdToken"] is DBNull ? null : obj_Row["IdToken"].ToString();
                obj_Token.Estado = obj_Row["Estado"] is DBNull ? null : obj_Row["Estado"].ToString();
                obj_Token.UsuarioCreacion = obj_Row["UsuarioCreacion"] is DBNull ? null : obj_Row["UsuarioCreacion"].ToString();
                obj_Token.FechaCreacion = obj_Row["FechaCreacion"] is DBNull ? null : (DateTime?)obj_Row["FechaCreacion"];
                obj_Token.UsuarioModificacion = obj_Row["UsuarioModificacion"] is DBNull ? null : obj_Row["UsuarioModificacion"].ToString();
                obj_Token.FechaModificacion = obj_Row["FechaModificacion"] is DBNull ? null : (DateTime?)obj_Row["FechaModificacion"];
                lst_Token.Add(obj_Token);
            }

            obj_Lista.Result = lst_Token;
            return obj_Lista;
        }

        /// <summary>Obtener Token</summary>
        /// <param name="str_pIdUsuario">IdUsuario</param>
        /// <returns>Objeto Token</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>13-04-2017</FecCrea></item></list></remarks>
        public static Kruma.KantaPe.Entidad.Token Obtener(string str_pIdUsuario)
        {
            Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Token> lst_Token = Listar(str_pIdUsuario, null, null, null, null);
            return lst_Token.Result.Count > 0 ? lst_Token.Result[0] : null;
        }

        /// <summary>Insertar Token</summary>
        /// <param name="obj_pToken">Token</param>
        /// <returns>Id de Token</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>13-04-2017</FecCrea></item></list></remarks>
        public static void Insertar(Kruma.KantaPe.Entidad.Token obj_pToken)
        {
            DataOperation dop_Operacion = new DataOperation("InsertarToken");
            dop_Operacion.Parameters.Add(new Parameter("@pIdUsuario", obj_pToken.IdUsuario));
            dop_Operacion.Parameters.Add(new Parameter("@pIdToken", obj_pToken.IdToken));
            dop_Operacion.Parameters.Add(new Parameter("@pEstado", obj_pToken.Estado));
            dop_Operacion.Parameters.Add(new Parameter("@pUsuarioCreacion", obj_pToken.UsuarioCreacion));

            DataManager.ExecuteNonQuery(Conexiones.CO_KantaPe, dop_Operacion, false);
        }

        /// <summary>Actualizar Token</summary>
        /// <param name="obj_pToken">Token</param>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>13-04-2017</FecCrea></item></list></remarks>
        public static void Modificar(Kruma.KantaPe.Entidad.Token obj_pToken)
        {
            DataOperation dop_Operacion = new DataOperation("ActualizarToken");

            dop_Operacion.Parameters.Add(new Parameter("@pIdUsuario", obj_pToken.IdUsuario));
            dop_Operacion.Parameters.Add(new Parameter("@pIdToken", obj_pToken.IdToken));
            dop_Operacion.Parameters.Add(new Parameter("@pEstado", obj_pToken.Estado));
            dop_Operacion.Parameters.Add(new Parameter("@pUsuarioModificacion", obj_pToken.UsuarioModificacion));

            DataManager.ExecuteNonQuery(Conexiones.CO_KantaPe, dop_Operacion, false);
        }

        #endregion
    }
}