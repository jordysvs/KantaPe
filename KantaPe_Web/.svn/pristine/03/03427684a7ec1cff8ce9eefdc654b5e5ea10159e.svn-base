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
	/// <summary>Mozo</summary>
	/// <remarks><list type="bullet">
	/// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
	/// <item><FecCrea>12-07-2016</FecCrea></item></list></remarks>

    public class Mozo
    {
        #region Metodos Públicos

        /// <summary>Listado de Mozo</summary>
        /// <param name="int_pIdLocal">IdLocal</param>
        /// <param name="int_pIdMozo">IdMozo</param>
        /// <param name="int_pIdPersona">IdPersona</param>
        /// <param name="str_pEstado">Estado</param>
        /// <param name="int_pNumPagina" >Numero de pagina</param>
        /// <param name="int_pTamPagina" >Tamaño de pagina</param>
        /// <returns>Lista de Mozo</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>12-07-2016</FecCrea></item></list></remarks>
        public static Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Mozo> Listar(
            int? int_pIdLocal, 
            int? int_pIdMozo, 
            int? int_pIdPersona, 
            string str_pEstado, 
            int? int_pNumPagina, 
            int? int_pTamPagina)
        {
            Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Mozo> obj_Lista = new Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Mozo>();
            obj_Lista.PageNumber = int_pNumPagina;
            obj_Lista.Total = 0;

            DataOperation dop_Operacion = new DataOperation("ListarMozo");
            dop_Operacion.Parameters.Add(new Parameter("@pIdLocal", int_pIdLocal.HasValue ? int_pIdLocal.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pIdMozo", int_pIdMozo.HasValue ? int_pIdMozo.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pIdPersona", int_pIdPersona.HasValue ? int_pIdPersona.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pEstado", !string.IsNullOrEmpty(str_pEstado) ? str_pEstado : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pNumPagina", int_pNumPagina.HasValue ? int_pNumPagina.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pTamPagina", int_pTamPagina.HasValue ? int_pTamPagina.Value : (object)DBNull.Value));

            DataTable dt_Resultado = DataManager.ExecuteDataSet(Conexiones.CO_KantaPe, dop_Operacion).Tables[0];

            List<Kruma.KantaPe.Entidad.Mozo> lst_Mozo = new List<Kruma.KantaPe.Entidad.Mozo>();
            Kruma.KantaPe.Entidad.Mozo obj_Mozo = new Kruma.KantaPe.Entidad.Mozo();
            foreach (DataRow obj_Row in dt_Resultado.Rows)
            {
                if (lst_Mozo.Count == 0)
                    obj_Lista.Total = (int)obj_Row["Total_Filas"];
                obj_Mozo = new Kruma.KantaPe.Entidad.Mozo();
                obj_Mozo.IdLocal = obj_Row["IdLocal"] is DBNull ? null : (int?)obj_Row["IdLocal"];
                obj_Mozo.IdMozo = obj_Row["IdMozo"] is DBNull ? null : (int?)obj_Row["IdMozo"];
                obj_Mozo.IdPersona = obj_Row["IdPersona"] is DBNull ? null : (int?)obj_Row["IdPersona"];
                obj_Mozo.Estado = obj_Row["Estado"] is DBNull ? null : obj_Row["Estado"].ToString();
                obj_Mozo.UsuarioCreacion = obj_Row["UsuarioCreacion"] is DBNull ? null : obj_Row["UsuarioCreacion"].ToString();
                obj_Mozo.FechaCreacion = obj_Row["FechaCreacion"] is DBNull ? null : (DateTime?)obj_Row["FechaCreacion"];
                obj_Mozo.UsuarioModificacion = obj_Row["UsuarioModificacion"] is DBNull ? null : obj_Row["UsuarioModificacion"].ToString();
                obj_Mozo.FechaModificacion = obj_Row["FechaModificacion"] is DBNull ? null : (DateTime?)obj_Row["FechaModificacion"];
                lst_Mozo.Add(obj_Mozo);
            }

            obj_Lista.Result = lst_Mozo;
            return obj_Lista;
        }

        /// <summary>Obtener Mozo</summary>
        /// <param name="int_pIdLocal">IdLocal</param>
        /// <param name="int_pIdMozo">IdMozo</param>
        /// <returns>Objeto Mozo</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>12-07-2016</FecCrea></item></list></remarks>
        public static Kruma.KantaPe.Entidad.Mozo Obtener(int int_pIdLocal, int int_pIdMozo)
        {
            Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Mozo> lst_Mozo = Listar(int_pIdLocal, int_pIdMozo, null, null, null, null);
            return lst_Mozo.Result.Count > 0 ? lst_Mozo.Result[0] : null;
        }

        /// <summary>Insertar Mozo</summary>
        /// <param name="obj_pMozo">Mozo</param>
        /// <returns>Id de Mozo</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>12-07-2016</FecCrea></item></list></remarks>
        public static int Insertar(Kruma.KantaPe.Entidad.Mozo obj_pMozo)
        {
            DataOperation dop_Operacion = new DataOperation("InsertarMozo");

            dop_Operacion.Parameters.Add(new Parameter("@pIdLocal", obj_pMozo.IdLocal));
            dop_Operacion.Parameters.Add(new Parameter("@pIdPersona", obj_pMozo.IdPersona));
            dop_Operacion.Parameters.Add(new Parameter("@pEstado", obj_pMozo.Estado));
            dop_Operacion.Parameters.Add(new Parameter("@pUsuarioCreacion", obj_pMozo.UsuarioCreacion));

            Parameter obj_IdMozo = new Parameter("@pIdMozo", DbType.Int32);
            obj_IdMozo.Direction = ParameterDirection.Output;
            dop_Operacion.Parameters.Add(obj_IdMozo);

            DataManager.ExecuteNonQuery(Conexiones.CO_KantaPe, dop_Operacion, false);
            int int_IdMozo = (int)obj_IdMozo.Value;
            return int_IdMozo;
        }

        /// <summary>Modificar Mozo</summary>
        /// <param name="obj_pMozo">Mozo</param>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>12-07-2016</FecCrea></item></list></remarks>
        public static void Modificar(Kruma.KantaPe.Entidad.Mozo obj_pMozo)
        {
            DataOperation dop_Operacion = new DataOperation("ActualizarMozo");

            dop_Operacion.Parameters.Add(new Parameter("@pIdLocal", obj_pMozo.IdLocal));
            dop_Operacion.Parameters.Add(new Parameter("@pIdMozo", obj_pMozo.IdMozo));
            dop_Operacion.Parameters.Add(new Parameter("@pIdPersona", obj_pMozo.IdPersona));
            dop_Operacion.Parameters.Add(new Parameter("@pEstado", obj_pMozo.Estado));
            dop_Operacion.Parameters.Add(new Parameter("@pUsuarioModificacion", obj_pMozo.UsuarioModificacion));

            DataManager.ExecuteNonQuery(Conexiones.CO_KantaPe, dop_Operacion, false);
        }

        #endregion
    }
}