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
    /// <summary>TokenNotificacion</summary>
    /// <remarks><list type="bullet">
    /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
    /// <item><FecCrea>13-04-2017</FecCrea></item></list></remarks>

    public class TokenNotificacion
    {
        #region Metodos Públicos

        /// <summary>Listado de TokenNotificacion</summary>
        /// <param name="str_pIdToken">IdToken</param>
        /// <param name="dt_pFecha">Fecha</param>
        /// <param name="str_pIdUsuario">IdUsuario</param>
        /// <param name="str_pTitulo">Titulo</param>
        /// <param name="str_pMensaje">Mensaje</param>
        /// <param name="str_pEstado">Estado</param>
        /// <param name="int_pNumPagina" >Numero de pagina</param>
        /// <param name="int_pTamPagina" >Tamaño de pagina</param>
        /// <returns>Lista de TokenNotificacion</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>13-04-2017</FecCrea></item></list></remarks>
        public static Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.TokenNotificacion> Listar(
            string str_pIdToken,
            DateTime? dt_pFecha,
            string str_pIdUsuario,
            string str_pTitulo,
            string str_pMensaje,
            string str_pEstado,
            int? int_pNumPagina,
            int? int_pTamPagina)
        {
            Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.TokenNotificacion> obj_Lista = new Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.TokenNotificacion>();
            obj_Lista.PageNumber = int_pNumPagina;
            obj_Lista.Total = 0;

            DataOperation dop_Operacion = new DataOperation("ListarTokenNotificacion");
            dop_Operacion.Parameters.Add(new Parameter("@pIdToken", !string.IsNullOrEmpty(str_pIdToken) ? str_pIdToken : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pFecha", dt_pFecha.HasValue ? dt_pFecha.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pIdUsuario", !string.IsNullOrEmpty(str_pIdUsuario) ? str_pIdUsuario : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pTitulo", !string.IsNullOrEmpty(str_pTitulo) ? str_pTitulo : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pMensaje", !string.IsNullOrEmpty(str_pMensaje) ? str_pMensaje : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pEstado", !string.IsNullOrEmpty(str_pEstado) ? str_pEstado : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pNumPagina", int_pNumPagina.HasValue ? int_pNumPagina.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pTamPagina", int_pTamPagina.HasValue ? int_pTamPagina.Value : (object)DBNull.Value));

            DataTable dt_Resultado = DataManager.ExecuteDataSet(Conexiones.CO_KantaPe, dop_Operacion).Tables[0];

            List<Kruma.KantaPe.Entidad.TokenNotificacion> lst_TokenNotificacion = new List<Kruma.KantaPe.Entidad.TokenNotificacion>();
            Kruma.KantaPe.Entidad.TokenNotificacion obj_TokenNotificacion = new Kruma.KantaPe.Entidad.TokenNotificacion();
            foreach (DataRow obj_Row in dt_Resultado.Rows)
            {
                if (lst_TokenNotificacion.Count == 0)
                    obj_Lista.Total = (int)obj_Row["Total_Filas"];
                obj_TokenNotificacion = new Kruma.KantaPe.Entidad.TokenNotificacion();
                obj_TokenNotificacion.IdToken = obj_Row["IdToken"] is DBNull ? null : obj_Row["IdToken"].ToString();
                obj_TokenNotificacion.Fecha = obj_Row["Fecha"] is DBNull ? null : (DateTime?)obj_Row["Fecha"];
                obj_TokenNotificacion.IdUsuario = obj_Row["IdUsuario"] is DBNull ? null : obj_Row["IdUsuario"].ToString();
                obj_TokenNotificacion.Titulo = obj_Row["Titulo"] is DBNull ? null : obj_Row["Titulo"].ToString();
                obj_TokenNotificacion.Mensaje = obj_Row["Mensaje"] is DBNull ? null : obj_Row["Mensaje"].ToString();
                obj_TokenNotificacion.Resultado = obj_Row["Resultado"] is DBNull ? null : obj_Row["Resultado"].ToString();
                obj_TokenNotificacion.Estado = obj_Row["Estado"] is DBNull ? null : obj_Row["Estado"].ToString();
                obj_TokenNotificacion.UsuarioCreacion = obj_Row["UsuarioCreacion"] is DBNull ? null : obj_Row["UsuarioCreacion"].ToString();
                obj_TokenNotificacion.FechaCreacion = obj_Row["FechaCreacion"] is DBNull ? null : (DateTime?)obj_Row["FechaCreacion"];
                obj_TokenNotificacion.UsuarioModificacion = obj_Row["UsuarioModificacion"] is DBNull ? null : obj_Row["UsuarioModificacion"].ToString();
                obj_TokenNotificacion.FechaModificacion = obj_Row["FechaModificacion"] is DBNull ? null : (DateTime?)obj_Row["FechaModificacion"];
                lst_TokenNotificacion.Add(obj_TokenNotificacion);
            }

            obj_Lista.Result = lst_TokenNotificacion;
            return obj_Lista;
        }

        /// <summary>Obtener TokenNotificacion</summary>
        /// <param name="str_pIdToken">IdToken</param>
        /// <param name="dt_pFecha">Fecha</param>
        /// <returns>Objeto TokenNotificacion</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>13-04-2017</FecCrea></item></list></remarks>
        public static Kruma.KantaPe.Entidad.TokenNotificacion Obtener(string str_pIdToken, DateTime dt_pFecha)
        {
            Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.TokenNotificacion> lst_TokenNotificacion = Listar(str_pIdToken, dt_pFecha, null, null, null, null, null, null);
            return lst_TokenNotificacion.Result.Count > 0 ? lst_TokenNotificacion.Result[0] : null;
        }

        /// <summary>Insertar TokenNotificacion</summary>
        /// <param name="obj_pTokenNotificacion">TokenNotificacion</param>
        /// <returns>Id de TokenNotificacion</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>13-04-2017</FecCrea></item></list></remarks>
        public static DateTime? Insertar(Kruma.KantaPe.Entidad.TokenNotificacion obj_pTokenNotificacion)
        {
            DataOperation dop_Operacion = new DataOperation("InsertarTokenNotificacion");
            dop_Operacion.Parameters.Add(new Parameter("@pIdToken", obj_pTokenNotificacion.IdToken));
            dop_Operacion.Parameters.Add(new Parameter("@pIdUsuario", obj_pTokenNotificacion.IdUsuario));
            dop_Operacion.Parameters.Add(new Parameter("@pTitulo", obj_pTokenNotificacion.Titulo));
            dop_Operacion.Parameters.Add(new Parameter("@pMensaje", obj_pTokenNotificacion.Mensaje));
            dop_Operacion.Parameters.Add(new Parameter("@pResultado", obj_pTokenNotificacion.Resultado));
            dop_Operacion.Parameters.Add(new Parameter("@pEstado", obj_pTokenNotificacion.Estado));
            dop_Operacion.Parameters.Add(new Parameter("@pUsuarioCreacion", obj_pTokenNotificacion.UsuarioCreacion));

            Parameter obj_Fecha = new Parameter("@pFecha", DbType.DateTime);
            obj_Fecha.Direction = ParameterDirection.Output;
            dop_Operacion.Parameters.Add(obj_Fecha);

            DataManager.ExecuteNonQuery(Conexiones.CO_KantaPe, dop_Operacion, false);
            DateTime? dtm_Fecha = (DateTime?)obj_Fecha.Value;
            return dtm_Fecha;
        }

        /// <summary>Actualizar TokenNotificacion</summary>
        /// <param name="obj_pTokenNotificacion">TokenNotificacion</param>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>13-04-2017</FecCrea></item></list></remarks>
        public static void Modificar(Kruma.KantaPe.Entidad.TokenNotificacion obj_pTokenNotificacion)
        {
            DataOperation dop_Operacion = new DataOperation("ActualizarTokenNotificacion");

            dop_Operacion.Parameters.Add(new Parameter("@pIdToken", obj_pTokenNotificacion.IdToken));
            dop_Operacion.Parameters.Add(new Parameter("@pFecha", obj_pTokenNotificacion.Fecha));
            dop_Operacion.Parameters.Add(new Parameter("@pIdUsuario", obj_pTokenNotificacion.IdUsuario));
            dop_Operacion.Parameters.Add(new Parameter("@pTitulo", obj_pTokenNotificacion.Titulo));
            dop_Operacion.Parameters.Add(new Parameter("@pMensaje", obj_pTokenNotificacion.Mensaje));
            dop_Operacion.Parameters.Add(new Parameter("@pResultado", obj_pTokenNotificacion.Resultado));
            dop_Operacion.Parameters.Add(new Parameter("@pEstado", obj_pTokenNotificacion.Estado));
            dop_Operacion.Parameters.Add(new Parameter("@pUsuarioModificacion", obj_pTokenNotificacion.UsuarioModificacion));

            DataManager.ExecuteNonQuery(Conexiones.CO_KantaPe, dop_Operacion, false);
        }

        #endregion
    }
}