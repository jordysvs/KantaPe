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
    /// <summary>Tipo de ubicación</summary>
    /// <remarks><list type="bullet">
    /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
    /// <item><FecCrea>25-07-2016</FecCrea></item></list></remarks>

    public class UbicacionTipo
    {
        #region Metodos Públicos

        /// <summary>Listado de tipo de ubicación</summary>
        /// <param name="int_pIdUbicacionTipo">Id de tipo de ubicación</param>
        /// <param name="str_pDescripcion">Descripcion</param>
        /// <param name="str_pEstado">Estado</param>
        /// <param name="int_pNumPagina" >Numero de pagina</param>
        /// <param name="int_pTamPagina" >Tamaño de pagina</param>
        /// <returns>Lista de tipo de ubicación</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>25-07-2016</FecCrea></item></list></remarks>
        public static Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.UbicacionTipo> Listar(
            int? int_pIdUbicacionTipo,
            string str_pDescripcion,
            string str_pEstado,
            int? int_pNumPagina,
            int? int_pTamPagina)
        {
            Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.UbicacionTipo> obj_Lista = 
                new Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.UbicacionTipo>();
            obj_Lista.PageNumber = int_pNumPagina;
            obj_Lista.Total = 0;

            DataOperation dop_Operacion = new DataOperation("ListarUbicacionTipo");
            dop_Operacion.Parameters.Add(new Parameter("@pIdUbicacionTipo", int_pIdUbicacionTipo.HasValue ? int_pIdUbicacionTipo.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pDescripcion", !string.IsNullOrEmpty(str_pDescripcion) ? str_pDescripcion : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pEstado", !string.IsNullOrEmpty(str_pEstado) ? str_pEstado : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pNumPagina", int_pNumPagina.HasValue ? int_pNumPagina.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pTamPagina", int_pTamPagina.HasValue ? int_pTamPagina.Value : (object)DBNull.Value));

            DataTable dt_Resultado = DataManager.ExecuteDataSet(Conexiones.CO_KantaPe, dop_Operacion).Tables[0];

            List<Kruma.KantaPe.Entidad.UbicacionTipo> lst_UbicacionTipo = new List<Kruma.KantaPe.Entidad.UbicacionTipo>();
            Kruma.KantaPe.Entidad.UbicacionTipo obj_UbicacionTipo = new Kruma.KantaPe.Entidad.UbicacionTipo();
            foreach (DataRow obj_Row in dt_Resultado.Rows)
            {
                if (lst_UbicacionTipo.Count == 0)
                    obj_Lista.Total = (int)obj_Row["Total_Filas"];
                obj_UbicacionTipo = new Kruma.KantaPe.Entidad.UbicacionTipo();
                obj_UbicacionTipo.IdUbicacionTipo = obj_Row["IdUbicacionTipo"] is DBNull ? null : (int?)obj_Row["IdUbicacionTipo"];
                obj_UbicacionTipo.Descripcion = obj_Row["Descripcion"] is DBNull ? null : obj_Row["Descripcion"].ToString();
                obj_UbicacionTipo.Estado = obj_Row["Estado"] is DBNull ? null : obj_Row["Estado"].ToString();
                obj_UbicacionTipo.UsuarioCreacion = obj_Row["UsuarioCreacion"] is DBNull ? null : obj_Row["UsuarioCreacion"].ToString();
                obj_UbicacionTipo.FechaCreacion = obj_Row["FechaCreacion"] is DBNull ? null : (DateTime?)obj_Row["FechaCreacion"];
                obj_UbicacionTipo.UsuarioModificacion = obj_Row["UsuarioModificacion"] is DBNull ? null : obj_Row["UsuarioModificacion"].ToString();
                obj_UbicacionTipo.FechaModificacion = obj_Row["FechaModificacion"] is DBNull ? null : (DateTime?)obj_Row["FechaModificacion"];
                lst_UbicacionTipo.Add(obj_UbicacionTipo);
            }

            obj_Lista.Result = lst_UbicacionTipo;
            return obj_Lista;
        }

        /// <summary>Obtener tipo de ubicación</summary>
        /// <param name="int_pIdUbicacionTipo">Id del tipo de ubicación</param>
        /// <returns>Objeto UbicacionTipo</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>25-07-2016</FecCrea></item></list></remarks>
        public static Kruma.KantaPe.Entidad.UbicacionTipo Obtener(int int_pIdUbicacionTipo)
        {
            Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.UbicacionTipo> lst_UbicacionTipo = Listar(int_pIdUbicacionTipo, null, null, null, null);
            return lst_UbicacionTipo.Result.Count > 0 ? lst_UbicacionTipo.Result[0] : null;
        }

        ///// <summary>Insertar tipo de cancion de apertura</summary>
        ///// <param name="obj_pAperturaCancionTipo">AperturaCancionTipo</param>
        ///// <returns>Id de AperturaCancionTipo</returns>
        ///// <remarks><list type="bullet">
        ///// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        ///// <item><FecCrea>25-07-2016</FecCrea></item></list></remarks>
        //public static int Insertar(Kruma.KantaPe.Entidad.AperturaCancionTipo obj_pAperturaCancionTipo)
        //{
        //    DataOperation dop_Operacion = new DataOperation("InsertarAperturaCancionTipo");

        //    dop_Operacion.Parameters.Add(new Parameter("@pDescripcion", obj_pAperturaCancionTipo.Descripcion));
        //    dop_Operacion.Parameters.Add(new Parameter("@pEstado", obj_pAperturaCancionTipo.Estado));
        //    dop_Operacion.Parameters.Add(new Parameter("@pUsuarioCreacion", obj_pAperturaCancionTipo.UsuarioCreacion));

        //    Parameter obj_IdAperturaCancionTipo = new Parameter("@pIdAperturaCancionTipo", DbType.Int32);
        //    obj_IdAperturaCancionTipo.Direction = ParameterDirection.Output;
        //    dop_Operacion.Parameters.Add(obj_IdAperturaCancionTipo);

        //    DataManager.ExecuteNonQuery(Conexiones.CO_KantaPe, dop_Operacion, false);
        //    int int_IdAperturaCancionTipo = (int)obj_IdAperturaCancionTipo.Value;
        //    return int_IdAperturaCancionTipo;
        //}

        ///// <summary>Modificar AperturaCancionTipo</summary>
        ///// <param name="obj_pAperturaCancionTipo">AperturaCancionTipo</param>
        ///// <remarks><list type="bullet">
        ///// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        ///// <item><FecCrea>25-07-2016</FecCrea></item></list></remarks>
        //public static void Modificar(Kruma.KantaPe.Entidad.AperturaCancionTipo obj_pAperturaCancionTipo)
        //{
        //    DataOperation dop_Operacion = new DataOperation("ActualizarAperturaCancionTipo");

        //    dop_Operacion.Parameters.Add(new Parameter("@pIdAperturaCancionTipo", obj_pAperturaCancionTipo.IdAperturaCancionTipo));
        //    dop_Operacion.Parameters.Add(new Parameter("@pDescripcion", obj_pAperturaCancionTipo.Descripcion));
        //    dop_Operacion.Parameters.Add(new Parameter("@pEstado", obj_pAperturaCancionTipo.Estado));
        //    dop_Operacion.Parameters.Add(new Parameter("@pUsuarioModificacion", obj_pAperturaCancionTipo.UsuarioModificacion));

        //    DataManager.ExecuteNonQuery(Conexiones.CO_KantaPe, dop_Operacion, false);
        //}

        #endregion
    }
}