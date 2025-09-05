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
    /// <summary>Ubicacion</summary>
    /// <remarks><list type="bullet">
    /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
    /// <item><FecCrea>12-07-2016</FecCrea></item></list></remarks>

    public class Ubicacion
    {
        #region Metodos Públicos

        /// <summary>Listado de Ubicacion</summary>
        /// <param name="int_pIdLocal">Id del local</param>
        /// <param name="int_pIdUbicacion">Id de la ubicación</param>
        /// <param name="int_pIdUbicacionTipo">Id del tipo de la ubicación</param>
        /// <param name="int_pNumero">Numero</param>
        /// <param name="int_pCapacidad">Capacidad</param>
        /// <param name="str_pEstado">Estado</param>
        /// <param name="int_pNumPagina" >Numero de pagina</param>
        /// <param name="int_pTamPagina" >Tamaño de pagina</param>
        /// <returns>Lista de Ubicacion</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>12-07-2016</FecCrea></item></list></remarks>
        public static Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Ubicacion> Listar(
            int? int_pIdEmpresa,
            int? int_pIdLocal,
            int? int_pIdUbicacion,
            int? int_pIdUbicacionTipo,
            string str_pNumero,
            string str_pCapacidad,
            string str_pEstado,
            int? int_pNumPagina,
            int? int_pTamPagina)
        {
            Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Ubicacion> obj_Lista = new Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Ubicacion>();
            obj_Lista.PageNumber = int_pNumPagina;
            obj_Lista.Total = 0;

            DataOperation dop_Operacion = new DataOperation("ListarUbicacion");
            dop_Operacion.Parameters.Add(new Parameter("@pIdEmpresa", int_pIdEmpresa.HasValue ? int_pIdEmpresa.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pIdLocal", int_pIdLocal.HasValue ? int_pIdLocal.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pIdUbicacion", int_pIdUbicacion.HasValue ? int_pIdUbicacion.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pIdUbicacionTipo", int_pIdUbicacionTipo.HasValue ? int_pIdUbicacionTipo.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pNumero", !string.IsNullOrEmpty(str_pNumero) ? str_pNumero : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pCapacidad", !string.IsNullOrEmpty(str_pCapacidad) ? str_pCapacidad : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pEstado", !string.IsNullOrEmpty(str_pEstado) ? str_pEstado : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pNumPagina", int_pNumPagina.HasValue ? int_pNumPagina.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pTamPagina", int_pTamPagina.HasValue ? int_pTamPagina.Value : (object)DBNull.Value));

            DataTable dt_Resultado = DataManager.ExecuteDataSet(Conexiones.CO_KantaPe, dop_Operacion).Tables[0];

            List<Kruma.KantaPe.Entidad.Ubicacion> lst_Ubicacion = new List<Kruma.KantaPe.Entidad.Ubicacion>();
            Kruma.KantaPe.Entidad.Ubicacion obj_Ubicacion = new Kruma.KantaPe.Entidad.Ubicacion();
            foreach (DataRow obj_Row in dt_Resultado.Rows)
            {
                if (lst_Ubicacion.Count == 0)
                    obj_Lista.Total = (int)obj_Row["Total_Filas"];
                obj_Ubicacion = new Kruma.KantaPe.Entidad.Ubicacion();
                obj_Ubicacion.IdLocal = obj_Row["IdLocal"] is DBNull ? null : (int?)obj_Row["IdLocal"];
                obj_Ubicacion.IdUbicacion = obj_Row["IdUbicacion"] is DBNull ? null : (int?)obj_Row["IdUbicacion"];
                obj_Ubicacion.IdUbicacionTipo = obj_Row["IdUbicacionTipo"] is DBNull ? null : (int?)obj_Row["IdUbicacionTipo"];
                obj_Ubicacion.Numero = obj_Row["Numero"] is DBNull ? null : (int?)obj_Row["Numero"];
                obj_Ubicacion.Capacidad = obj_Row["Capacidad"] is DBNull ? null : (int?)obj_Row["Capacidad"];
                obj_Ubicacion.Estado = obj_Row["Estado"] is DBNull ? null : obj_Row["Estado"].ToString();
                obj_Ubicacion.UsuarioCreacion = obj_Row["UsuarioCreacion"] is DBNull ? null : obj_Row["UsuarioCreacion"].ToString();
                obj_Ubicacion.FechaCreacion = obj_Row["FechaCreacion"] is DBNull ? null : (DateTime?)obj_Row["FechaCreacion"];
                obj_Ubicacion.UsuarioModificacion = obj_Row["UsuarioModificacion"] is DBNull ? null : obj_Row["UsuarioModificacion"].ToString();
                obj_Ubicacion.FechaModificacion = obj_Row["FechaModificacion"] is DBNull ? null : (DateTime?)obj_Row["FechaModificacion"];

                obj_Ubicacion.Local = new Kruma.KantaPe.Entidad.Local();
                
                obj_Ubicacion.Local.IdLocal = obj_Row["Local_IdLocal"] is DBNull ? null : (int?)obj_Row["Local_IdLocal"];
                obj_Ubicacion.Local.IdEmpresa = obj_Row["Local_IdEmpresa"] is DBNull ? null : (int?)obj_Row["Local_IdEmpresa"];
                obj_Ubicacion.Local.IdDireccion = obj_Row["Local_IdDireccion"] is DBNull ? null : (int?)obj_Row["Local_IdDireccion"];
                obj_Ubicacion.Local.Radio = obj_Row["Local_Radio"] is DBNull ? null : (decimal?)obj_Row["Local_Radio"];
                obj_Ubicacion.Local.FlagLocalizacion = obj_Row["Local_FlagLocalizacion"] is DBNull ? null : obj_Row["Local_FlagLocalizacion"].ToString();

                obj_Ubicacion.Local.Nombre = obj_Row["CorePersonaDireccion_Nombre"] is DBNull ? null : obj_Row["CorePersonaDireccion_Nombre"].ToString();
                obj_Ubicacion.Local.Direccion = obj_Row["CorePersonaDireccion_Direccion"] is DBNull ? null : obj_Row["CorePersonaDireccion_Direccion"].ToString();

                obj_Ubicacion.Local.Longitud = obj_Row["CorePersonaDireccion_Longitud"] is DBNull ? null : obj_Row["CorePersonaDireccion_Longitud"].ToString();
                obj_Ubicacion.Local.Latitud = obj_Row["CorePersonaDireccion_Latitud"] is DBNull ? null : obj_Row["CorePersonaDireccion_Latitud"].ToString();

                obj_Ubicacion.Local.Empresa = new Kruma.KantaPe.Entidad.Empresa();
                obj_Ubicacion.Local.Empresa.IdEmpresa = obj_Row["Empresa_IdEmpresa"] is DBNull ? null : (int?)obj_Row["Empresa_IdEmpresa"];
                obj_Ubicacion.Local.Empresa.IdPersona = obj_Row["CorePersona_IdPersona"] is DBNull ? null : (int?)obj_Row["CorePersona_IdPersona"];
                obj_Ubicacion.Local.Empresa.RazonSocial = obj_Row["CorePersona_RazonSocial"] is DBNull ? null : obj_Row["CorePersona_RazonSocial"].ToString();
                obj_Ubicacion.Local.Empresa.NombreComercial = obj_Row["CorePersona_NombreComercial"] is DBNull ? null : obj_Row["CorePersona_NombreComercial"].ToString();
                obj_Ubicacion.Local.Empresa.IdTipoDocumento = obj_Row["CorePersona_IdTipoDocumento"] is DBNull ? null : (int?)obj_Row["CorePersona_IdTipoDocumento"];
                obj_Ubicacion.Local.Empresa.NumeroDocumento = obj_Row["CorePersona_NumeroDocumento"] is DBNull ? null : obj_Row["CorePersona_NumeroDocumento"].ToString();

                //obj_Ubicacion.Local.Empresa.TipoDocumento = new Kruma.Core.Business.Entity.TipoDocumento();
                //obj_Ubicacion.Local.Empresa.TipoDocumento.IdTipoDocumento = obj_Row["TipoDocumento_IdTipoDocumento"] is DBNull ? null : (int?)obj_Row["TipoDocumento_IdTipoDocumento"];
                //obj_Ubicacion.Local.Empresa.TipoDocumento.Descripcion = obj_Row["TipoDocumento_Descripcion"] is DBNull ? null : obj_Row["TipoDocumento_Descripcion"].ToString();

                obj_Ubicacion.UbicacionTipo = new Kruma.KantaPe.Entidad.UbicacionTipo();
                obj_Ubicacion.UbicacionTipo.IdUbicacionTipo = obj_Row["UbicacionTipo_IdUbicacionTipo"] is DBNull ? null : (int?)obj_Row["UbicacionTipo_IdUbicacionTipo"];
                obj_Ubicacion.UbicacionTipo.Descripcion = obj_Row["UbicacionTipo_Descripcion"] is DBNull ? null : obj_Row["UbicacionTipo_Descripcion"].ToString();

                lst_Ubicacion.Add(obj_Ubicacion);
            }

            obj_Lista.Result = lst_Ubicacion;
            return obj_Lista;
        }

        /// <summary>Obtener Ubicación</summary>
        /// <param name="int_pIdLocal">Id del local</param>
        /// <param name="int_pIdUbicacion">Id de la ubicación</param>
        /// <returns>Objeto Ubicación</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>12-07-2016</FecCrea></item></list></remarks>
        public static Kruma.KantaPe.Entidad.Ubicacion Obtener(
            int int_pIdLocal,
            int int_pIdUbicacion)
        {
            Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Ubicacion> lst_Ubicacion = Listar(null, int_pIdLocal, int_pIdUbicacion, null, null, null, null, null, null);
            return lst_Ubicacion.Result.Count > 0 ? lst_Ubicacion.Result[0] : null;
        }

        /// <summary>Insertar ubicación</summary>
        /// <param name="obj_pUbicacion">Ubicación</param>
        /// <returns>Id de la ubicación</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>12-07-2016</FecCrea></item></list></remarks>
        public static int Insertar(Kruma.KantaPe.Entidad.Ubicacion obj_pUbicacion)
        {
            DataOperation dop_Operacion = new DataOperation("InsertarUbicacion");

            dop_Operacion.Parameters.Add(new Parameter("@pIdLocal", obj_pUbicacion.IdLocal));
            dop_Operacion.Parameters.Add(new Parameter("@pIdUbicacionTipo", obj_pUbicacion.IdUbicacionTipo));
            dop_Operacion.Parameters.Add(new Parameter("@pNumero", obj_pUbicacion.Numero));
            dop_Operacion.Parameters.Add(new Parameter("@pCapacidad", obj_pUbicacion.Capacidad));
            dop_Operacion.Parameters.Add(new Parameter("@pEstado", obj_pUbicacion.Estado));
            dop_Operacion.Parameters.Add(new Parameter("@pUsuarioCreacion", obj_pUbicacion.UsuarioCreacion));

            Parameter obj_IdUbicacion = new Parameter("@pIdUbicacion", DbType.Int32);
            obj_IdUbicacion.Direction = ParameterDirection.Output;
            dop_Operacion.Parameters.Add(obj_IdUbicacion);

            DataManager.ExecuteNonQuery(Conexiones.CO_KantaPe, dop_Operacion, false);
            int int_IdUbicacion = (int)obj_IdUbicacion.Value;
            return int_IdUbicacion;
        }

        /// <summary>Modificar Ubicación</summary>
        /// <param name="obj_pUbicacion">Ubicacion</param>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>12-07-2016</FecCrea></item></list></remarks>
        public static void Modificar(Kruma.KantaPe.Entidad.Ubicacion obj_pUbicacion)
        {
            DataOperation dop_Operacion = new DataOperation("ActualizarUbicacion");

            dop_Operacion.Parameters.Add(new Parameter("@pIdLocal", obj_pUbicacion.IdLocal));
            dop_Operacion.Parameters.Add(new Parameter("@pIdUbicacion", obj_pUbicacion.IdUbicacion));
            dop_Operacion.Parameters.Add(new Parameter("@pIdUbicacionTipo", obj_pUbicacion.IdUbicacionTipo));
            dop_Operacion.Parameters.Add(new Parameter("@pNumero", obj_pUbicacion.Numero));
            dop_Operacion.Parameters.Add(new Parameter("@pCapacidad", obj_pUbicacion.Capacidad));
            dop_Operacion.Parameters.Add(new Parameter("@pEstado", obj_pUbicacion.Estado));
            dop_Operacion.Parameters.Add(new Parameter("@pUsuarioModificacion", obj_pUbicacion.UsuarioModificacion));

            DataManager.ExecuteNonQuery(Conexiones.CO_KantaPe, dop_Operacion, false);
        }

        /// <summary>Listado de Total por tipo de ubicacion</summary>
        /// <param name="int_pIdLocal">Id del local</param>
        /// <param name="int_pIdUbicacionTipo">Id del tipo de la ubicación</param>
      
        /// <returns>Lista de total por tipo Ubicacion</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Vicente Gonzales Osorio</CreadoPor></item>
        /// <item><FecCrea>30-03-2017</FecCrea></item></list></remarks>
        public static Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Ubicacion> ListarTotalUbicacion(
            int? int_pIdUbicacionTipo,
            int? int_pIdLocal)
        {
            Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Ubicacion> obj_Lista = new Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Ubicacion>();
            obj_Lista.Total = 0;

            DataOperation dop_Operacion = new DataOperation("ListarTotalUbicacion");
            dop_Operacion.Parameters.Add(new Parameter("@pIdUbicacionTipo", int_pIdUbicacionTipo.HasValue ? int_pIdUbicacionTipo.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pIdLocal", int_pIdLocal.HasValue ? int_pIdLocal.Value : (object)DBNull.Value));

            DataTable dt_Resultado = DataManager.ExecuteDataSet(Conexiones.CO_KantaPe, dop_Operacion).Tables[0];

            List<Kruma.KantaPe.Entidad.Ubicacion> lst_Ubicacion = new List<Kruma.KantaPe.Entidad.Ubicacion>();
            Kruma.KantaPe.Entidad.Ubicacion obj_Ubicacion = new Kruma.KantaPe.Entidad.Ubicacion();
            foreach (DataRow obj_Row in dt_Resultado.Rows)
            {
                obj_Ubicacion = new Kruma.KantaPe.Entidad.Ubicacion();
                obj_Ubicacion.Cantidad = obj_Row["Cantidad"] is DBNull ? null : (int?)obj_Row["Cantidad"];

                lst_Ubicacion.Add(obj_Ubicacion);
            }

            obj_Lista.Result = lst_Ubicacion;
            return obj_Lista;
        }
        #endregion
    }
}