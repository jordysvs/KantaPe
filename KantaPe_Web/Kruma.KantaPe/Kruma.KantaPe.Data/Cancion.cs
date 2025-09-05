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
    /// <summary>CancionSimple</summary>
    /// <remarks><list type="bullet">
    /// <item><CreadoPor>Creado por Vicente Gonzales Osorio</CreadoPor></item>
    /// <item><FecCrea>10-03-2017</FecCrea></item></list></remarks>

    public class Cancion
    {
        #region Metodos Públicos

        /// <summary>Listado de CancionSimple</summary>
        /// <param name="int_pIdCancionSimple">Id del CancionSimple</param>
        /// <param name="str_pDescripcion">Descripción del CancionSimple</param>
        /// <param name="str_pEstado">Estado del CancionSimple</param>
        /// <param name="int_pNumPagina" >Numero de pagina</param>
        /// <param name="int_pTamPagina" >Tamaño de pagina</param>
        /// <returns>Lista de CancionSimple</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por Vicente Gonzales Osorio</CreadoPor></item>
        /// <item><FecCrea>10-03-2017</FecCrea></item></list></remarks>
        public static Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Cancion> Listar(
            int? int_pIdCancion,
            string str_pDescripcion,
            string str_pEstado,
            int? int_pNumPagina,
            int? int_pTamPagina)
        {

            Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Cancion> obj_Lista = new Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Cancion>();
            obj_Lista.PageNumber = int_pNumPagina;
            obj_Lista.Total = 0;

            DataOperation dop_Operacion = new DataOperation("ListarCancion");
            
            dop_Operacion.Parameters.Add(new Parameter("@pIdCancion", int_pIdCancion.HasValue ? int_pIdCancion.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pDescripcion", !string.IsNullOrEmpty(str_pDescripcion) ? str_pDescripcion : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pEstado", !string.IsNullOrEmpty(str_pEstado) ? str_pEstado : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pNumPagina", int_pNumPagina.HasValue ? int_pNumPagina.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pTamPagina", int_pTamPagina.HasValue ? int_pTamPagina.Value : (object)DBNull.Value));

            DataTable dt_Resultado = DataManager.ExecuteDataSet(Conexiones.CO_KantaPe, dop_Operacion).Tables[0];

            List<Kruma.KantaPe.Entidad.Cancion> lst_CancionSimple = new List<Kruma.KantaPe.Entidad.Cancion>();

            Kruma.KantaPe.Entidad.Cancion obj_CancionSimple = new Kruma.KantaPe.Entidad.Cancion();

            foreach (DataRow obj_Row in dt_Resultado.Rows)
            {
                if (lst_CancionSimple.Count == 0)
                    obj_Lista.Total = (int)obj_Row["Total_Filas"];

                obj_CancionSimple = new Kruma.KantaPe.Entidad.Cancion();
                obj_CancionSimple.IdCancion = obj_Row["IdCancion"] is DBNull ? null : (int?)obj_Row["IdCancion"];
                obj_CancionSimple.Descripcion = obj_Row["Descripcion"] is DBNull ? null : obj_Row["Descripcion"].ToString();
                obj_CancionSimple.Estado = obj_Row["Estado"] is DBNull ? null : obj_Row["Estado"].ToString();
                obj_CancionSimple.UsuarioCreacion = obj_Row["UsuarioCreacion"] is DBNull ? null : obj_Row["UsuarioCreacion"].ToString();
                obj_CancionSimple.FechaCreacion = obj_Row["FechaCreacion"] is DBNull ? null : (DateTime?)obj_Row["FechaCreacion"];
                obj_CancionSimple.UsuarioModificacion = obj_Row["UsuarioModificacion"] is DBNull ? null : obj_Row["UsuarioModificacion"].ToString();
                obj_CancionSimple.FechaModificacion = obj_Row["FechaModificacion"] is DBNull ? null : (DateTime?)obj_Row["FechaModificacion"];

                lst_CancionSimple.Add(obj_CancionSimple);
            }

            obj_Lista.Result = lst_CancionSimple;

            return obj_Lista;
        }

        /// <summary>Obtener CancionSimple</summary>
        /// <param name="int_pIdCancionSimple">Id del CancionSimple</param>
        /// <returns>Objeto CancionSimple</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por Vicente Gonzales Osorio</CreadoPor></item>
        /// <item><FecCrea>10-03-2017</FecCrea></item></list></remarks>
        public static Kruma.KantaPe.Entidad.Cancion Obtener(int int_pIdCancion)
        {
            Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Cancion> lst_Cancion = Listar(int_pIdCancion, null, null, null, null);
            return lst_Cancion.Result.Count > 0 ? lst_Cancion.Result[0] : null;
        }

        /// <summary>Insertar CancionSimple</summary>
        /// <param name="obj_pCancionSimple">CancionSimple</param>
        /// <returns>Id de CancionSimple</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por Vicente Gonzales Osorio</CreadoPor></item>
        /// <item><FecCrea>10-03-2017</FecCrea></item></list></remarks>
        public static int Insertar(Kruma.KantaPe.Entidad.Cancion obj_pCancion)
        {
            DataOperation dop_Operacion = new DataOperation("InsertarCancion");

            dop_Operacion.Parameters.Add(new Parameter("@pDescripcion", obj_pCancion.Descripcion));
            dop_Operacion.Parameters.Add(new Parameter("@pEstado", obj_pCancion.Estado));
            dop_Operacion.Parameters.Add(new Parameter("@pUsuarioCreacion", obj_pCancion.UsuarioCreacion));

            Parameter obj_IdCancionSimple = new Parameter("@pIdCancion", DbType.Int32);
            obj_IdCancionSimple.Direction = ParameterDirection.Output;
            dop_Operacion.Parameters.Add(obj_IdCancionSimple);

            DataManager.ExecuteNonQuery(Conexiones.CO_KantaPe, dop_Operacion, false);
            int int_IdCancionSimple = (int)obj_IdCancionSimple.Value;
            return int_IdCancionSimple;
        }

        /// <summary>Modificar CancionSimple</summary>
        /// <param name="obj_pCancionSimple">CancionSimple</param>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por Vicente Gonzales Osorio</CreadoPor></item>
        /// <item><FecCrea>10-03-2017</FecCrea></item></list></remarks>
        public static void Modificar(Kruma.KantaPe.Entidad.Cancion obj_pCancion)
        {
            DataOperation dop_Operacion = new DataOperation("ActualizarCancion");

            dop_Operacion.Parameters.Add(new Parameter("@pIdCancion", obj_pCancion.IdCancion));
            dop_Operacion.Parameters.Add(new Parameter("@pDescripcion", obj_pCancion.Descripcion));
            dop_Operacion.Parameters.Add(new Parameter("@pEstado", obj_pCancion.Estado));
            dop_Operacion.Parameters.Add(new Parameter("@pUsuarioModificacion", obj_pCancion.UsuarioModificacion));

            DataManager.ExecuteNonQuery(Conexiones.CO_KantaPe, dop_Operacion, false);
        }

        #endregion
    }
}