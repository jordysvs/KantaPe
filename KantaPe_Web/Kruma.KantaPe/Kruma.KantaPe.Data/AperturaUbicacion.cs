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
    /// <summary>Ubicación de la apertura</summary>
    /// <remarks><list type="bullet">
    /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
    /// <item><FecCrea>25-07-2016</FecCrea></item></list></remarks>

    public class AperturaUbicacion
    {
        #region Metodos Públicos

        /// <summary>Listado de AperturaUbicacion</summary>
        /// <param name="int_pIdLocal">IdLocal</param>
        /// <param name="int_pIdApertura">IdApertura</param>
        /// <param name="int_pIdUbicacion">IdUbicacion</param>
        /// <param name="str_pEstado">Estado</param>
        /// <param name="int_pNumPagina" >Numero de pagina</param>
        /// <param name="int_pTamPagina" >Tamaño de pagina</param>
        /// <returns>Lista de AperturaUbicacion</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>25-07-2016</FecCrea></item></list></remarks>
        public static Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.AperturaUbicacion> Listar(
            int? int_pIdLocal,
            int? int_pIdApertura,
            int? int_pIdUbicacion,
            string str_pEstado,
            int? int_pNumPagina,
            int? int_pTamPagina)
        {
            Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.AperturaUbicacion> obj_Lista = new Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.AperturaUbicacion>();
            obj_Lista.PageNumber = int_pNumPagina;
            obj_Lista.Total = 0;

            DataOperation dop_Operacion = new DataOperation("ListarAperturaUbicacion");
            dop_Operacion.Parameters.Add(new Parameter("@pIdLocal", int_pIdLocal.HasValue ? int_pIdLocal.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pIdApertura", int_pIdApertura.HasValue ? int_pIdApertura.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pIdUbicacion", int_pIdUbicacion.HasValue ? int_pIdUbicacion.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pEstado", !string.IsNullOrEmpty(str_pEstado) ? str_pEstado : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pNumPagina", int_pNumPagina.HasValue ? int_pNumPagina.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pTamPagina", int_pTamPagina.HasValue ? int_pTamPagina.Value : (object)DBNull.Value));

            DataTable dt_Resultado = DataManager.ExecuteDataSet(Conexiones.CO_KantaPe, dop_Operacion).Tables[0];

            List<Kruma.KantaPe.Entidad.AperturaUbicacion> lst_AperturaUbicacion = new List<Kruma.KantaPe.Entidad.AperturaUbicacion>();
            Kruma.KantaPe.Entidad.AperturaUbicacion obj_AperturaUbicacion = new Kruma.KantaPe.Entidad.AperturaUbicacion();
            foreach (DataRow obj_Row in dt_Resultado.Rows)
            {
                if (lst_AperturaUbicacion.Count == 0)
                    obj_Lista.Total = (int)obj_Row["Total_Filas"];
                obj_AperturaUbicacion = new Kruma.KantaPe.Entidad.AperturaUbicacion();
                obj_AperturaUbicacion.IdLocal = obj_Row["IdLocal"] is DBNull ? null : (int?)obj_Row["IdLocal"];
                obj_AperturaUbicacion.IdApertura = obj_Row["IdApertura"] is DBNull ? null : (int?)obj_Row["IdApertura"];
                obj_AperturaUbicacion.IdUbicacion = obj_Row["IdUbicacion"] is DBNull ? null : (int?)obj_Row["IdUbicacion"];
                obj_AperturaUbicacion.Estado = obj_Row["Estado"] is DBNull ? null : obj_Row["Estado"].ToString();
                obj_AperturaUbicacion.UsuarioCreacion = obj_Row["UsuarioCreacion"] is DBNull ? null : obj_Row["UsuarioCreacion"].ToString();
                obj_AperturaUbicacion.FechaCreacion = obj_Row["FechaCreacion"] is DBNull ? null : (DateTime?)obj_Row["FechaCreacion"];
                obj_AperturaUbicacion.UsuarioModificacion = obj_Row["UsuarioModificacion"] is DBNull ? null : obj_Row["UsuarioModificacion"].ToString();
                obj_AperturaUbicacion.FechaModificacion = obj_Row["FechaModificacion"] is DBNull ? null : (DateTime?)obj_Row["FechaModificacion"];

                obj_AperturaUbicacion.Ubicacion = new Kruma.KantaPe.Entidad.Ubicacion();
                obj_AperturaUbicacion.Ubicacion.IdLocal = obj_Row["Ubicacion_IdLocal"] is DBNull ? null : (int?)obj_Row["Ubicacion_IdLocal"];
                obj_AperturaUbicacion.Ubicacion.IdUbicacion = obj_Row["Ubicacion_IdUbicacion"] is DBNull ? null : (int?)obj_Row["Ubicacion_IdUbicacion"];
                obj_AperturaUbicacion.Ubicacion.IdUbicacionTipo = obj_Row["Ubicacion_IdUbicacionTipo"] is DBNull ? null : (int?)obj_Row["Ubicacion_IdUbicacionTipo"];
                obj_AperturaUbicacion.Ubicacion.Numero = obj_Row["Ubicacion_Numero"] is DBNull ? null : (int?)obj_Row["Ubicacion_Numero"];
                obj_AperturaUbicacion.Ubicacion.Capacidad = obj_Row["Ubicacion_Capacidad"] is DBNull ? null : (int?)obj_Row["Ubicacion_Capacidad"];

                obj_AperturaUbicacion.Ubicacion.UbicacionTipo = new Kruma.KantaPe.Entidad.UbicacionTipo();
                obj_AperturaUbicacion.Ubicacion.UbicacionTipo.IdUbicacionTipo = obj_Row["UbicacionTipo_IdUbicacionTipo"] is DBNull ? null : (int?)obj_Row["UbicacionTipo_IdUbicacionTipo"];
                obj_AperturaUbicacion.Ubicacion.UbicacionTipo.Descripcion = obj_Row["UbicacionTipo_Descripcion"] is DBNull ? null : obj_Row["UbicacionTipo_Descripcion"].ToString();


                lst_AperturaUbicacion.Add(obj_AperturaUbicacion);
            }

            obj_Lista.Result = lst_AperturaUbicacion;
            return obj_Lista;
        }

        /// <summary>Obtener ubicacíón de la apertura</summary>
        /// <param name="int_pIdLocal">IdLocal</param>
        /// <param name="int_pIdApertura">IdApertura</param>
        /// <param name="int_pIdUbicacion">IdUbicacion</param>
        /// <returns>Objeto AperturaUbicacion</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>25-07-2016</FecCrea></item></list></remarks>
        public static Kruma.KantaPe.Entidad.AperturaUbicacion Obtener(
            int int_pIdLocal,
            int int_pIdApertura,
            int int_pIdUbicacion)
        {
            Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.AperturaUbicacion> lst_AperturaUbicacion = Listar(int_pIdLocal, int_pIdApertura, int_pIdUbicacion, null, null, null);
            return lst_AperturaUbicacion.Result.Count > 0 ? lst_AperturaUbicacion.Result[0] : null;
        }

        /// <summary>Insertar ubicación de la apertura</summary>
        /// <param name="obj_pAperturaUbicacion">AperturaUbicacion</param>
        /// <returns>Id de AperturaUbicacion</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>25-07-2016</FecCrea></item></list></remarks>
        public static void Insertar(Kruma.KantaPe.Entidad.AperturaUbicacion obj_pAperturaUbicacion)
        {
            DataOperation dop_Operacion = new DataOperation("InsertarAperturaUbicacion");

            dop_Operacion.Parameters.Add(new Parameter("@pIdLocal", obj_pAperturaUbicacion.IdLocal));
            dop_Operacion.Parameters.Add(new Parameter("@pIdApertura", obj_pAperturaUbicacion.IdApertura));
            dop_Operacion.Parameters.Add(new Parameter("@pIdUbicacion", obj_pAperturaUbicacion.IdUbicacion));
            dop_Operacion.Parameters.Add(new Parameter("@pEstado", obj_pAperturaUbicacion.Estado));
            dop_Operacion.Parameters.Add(new Parameter("@pUsuarioCreacion", obj_pAperturaUbicacion.UsuarioCreacion));

            DataManager.ExecuteNonQuery(Conexiones.CO_KantaPe, dop_Operacion, false);
        }

        /// <summary>Modificar ubicación de la apertura</summary>
        /// <param name="obj_pAperturaUbicacion">AperturaUbicacion</param>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>25-07-2016</FecCrea></item></list></remarks>
        public static void Modificar(Kruma.KantaPe.Entidad.AperturaUbicacion obj_pAperturaUbicacion)
        {
            DataOperation dop_Operacion = new DataOperation("ActualizarAperturaUbicacion");

            dop_Operacion.Parameters.Add(new Parameter("@pIdLocal", obj_pAperturaUbicacion.IdLocal));
            dop_Operacion.Parameters.Add(new Parameter("@pIdApertura", obj_pAperturaUbicacion.IdApertura));
            dop_Operacion.Parameters.Add(new Parameter("@pIdUbicacion", obj_pAperturaUbicacion.IdUbicacion));
            dop_Operacion.Parameters.Add(new Parameter("@pEstado", obj_pAperturaUbicacion.Estado));
            dop_Operacion.Parameters.Add(new Parameter("@pUsuarioModificacion", obj_pAperturaUbicacion.UsuarioModificacion));

            DataManager.ExecuteNonQuery(Conexiones.CO_KantaPe, dop_Operacion, false);
        }

        /// <summary>Listado de ReporteUbicacionAperturaHora</summary>
        /// <param name="int_pIdLocal">IdLocal</param>
        /// <param name="int_pIdApertura">IdApertura</param>
        /// <param name="int_pIdUbicacion">IdUbicacion</param>
        /// <param name="str_pEstado">Estado</param>
        /// <returns>Lista de AperturaUbicacion</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Vicente Gonzales Osorio</CreadoPor></item>
        /// <item><FecCrea>20-03-2017</FecCrea></item></list></remarks>
        public static Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.AperturaUbicacion> ReporteUbicacionAperturaHora(
            int? int_pIdEmpresa,
            int? int_pIdLocal,
            DateTime? dt_pFecha,
            int? int_pHoraInicio,
            int? int_pHoraFin,
            int? int_pIdUbicacionTipo,
            int? int_pNroUbicacion)
        {
            Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.AperturaUbicacion> obj_Lista = new Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.AperturaUbicacion>();
            obj_Lista.Total = 0;

            DataOperation dop_Operacion = new DataOperation("ReporteUbicacionAperturaHora");
            dop_Operacion.Parameters.Add(new Parameter("@pIdEmpresa", int_pIdEmpresa.HasValue ? int_pIdEmpresa.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pIdLocal", int_pIdLocal.HasValue ? int_pIdLocal.Value : (object)DBNull.Value));
            Parameter obj_Fecha = new Parameter("@pFecha", DbType.DateTime);
            obj_Fecha.Direction = ParameterDirection.Input;
            obj_Fecha.Value = dt_pFecha.HasValue ? dt_pFecha.Value : (object)DBNull.Value;
            dop_Operacion.Parameters.Add(obj_Fecha);
            dop_Operacion.Parameters.Add(new Parameter("@pHoraInicio", int_pHoraInicio.HasValue ? int_pHoraInicio.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pHoraFin", int_pHoraFin.HasValue ? int_pHoraFin.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pIdUbicacionTipo", int_pIdUbicacionTipo.HasValue ? int_pIdUbicacionTipo.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pNroUbicacion", int_pNroUbicacion.HasValue ? int_pNroUbicacion.Value : (object)DBNull.Value));

            DataTable dt_Resultado = DataManager.ExecuteDataSet(Conexiones.CO_KantaPe, dop_Operacion).Tables[0];

            List<Kruma.KantaPe.Entidad.AperturaUbicacion> lst_AperturaUbicacion = new List<Kruma.KantaPe.Entidad.AperturaUbicacion>();
            Kruma.KantaPe.Entidad.AperturaUbicacion obj_AperturaUbicacion = new Kruma.KantaPe.Entidad.AperturaUbicacion();
            foreach (DataRow obj_Row in dt_Resultado.Rows)
            {
                obj_AperturaUbicacion = new Kruma.KantaPe.Entidad.AperturaUbicacion();
                obj_AperturaUbicacion.Fecha = obj_Row["Fecha"] is DBNull ? null : (DateTime?)obj_Row["Fecha"];
                obj_AperturaUbicacion.Hora = obj_Row["Hora"] is DBNull ? null : (int?)obj_Row["Hora"];
                obj_AperturaUbicacion.HoraFinal = obj_Row["HoraFinal"] is DBNull ? null : (int?)obj_Row["HoraFinal"];

                obj_AperturaUbicacion.Ubicacion = new Kruma.KantaPe.Entidad.Ubicacion();
                obj_AperturaUbicacion.Ubicacion.IdUbicacion = obj_Row["Ubicacion_IdUbicacion"] is DBNull ? null : (int?)obj_Row["Ubicacion_IdUbicacion"];
                obj_AperturaUbicacion.Ubicacion.Numero = obj_Row["Ubicacion_Numero"] is DBNull ? null : (int?)obj_Row["Ubicacion_Numero"];

                obj_AperturaUbicacion.Ubicacion.UbicacionTipo = new Kruma.KantaPe.Entidad.UbicacionTipo();
                obj_AperturaUbicacion.Ubicacion.UbicacionTipo.IdUbicacionTipo = obj_Row["UbicacionTipo_IdUbicacionTipo"] is DBNull ? null : (int?)obj_Row["UbicacionTipo_IdUbicacionTipo"];
                obj_AperturaUbicacion.Ubicacion.UbicacionTipo.Descripcion = obj_Row["UbicacionTipo_Descripcion"] is DBNull ? null : obj_Row["UbicacionTipo_Descripcion"].ToString();

                //obj_AperturaUbicacion.ListaHoras = ListarHoraReporte(int_pIdEmpresa, int_pIdLocal, dt_pFecha, int_pHoraInicio, int_pHoraFin, int_pIdUbicacionTipo, int_pNroUbicacion).Result;
                lst_AperturaUbicacion.Add(obj_AperturaUbicacion);

            }

            obj_Lista.Result = lst_AperturaUbicacion;
            return obj_Lista;
        }
        /// <summary>Listado de Hora para el Reporte</summary>
        /// <param name="int_pIdLocal">IdLocal</param>
        /// <param name="int_pIdApertura">IdApertura</param>
        /// <param name="int_pIdUbicacion">IdUbicacion</param>
        /// <param name="str_pEstado">Estado</param>
        /// <returns>Lista de AperturaUbicacion</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Vicente Gonzales Osorio</CreadoPor></item>
        /// <item><FecCrea>20-03-2017</FecCrea></item></list></remarks>
        public static Kruma.Core.Util.Common.List<Entidad.AperturaUbicacion> ListarHoraReporte(
            int? int_pIdEmpresa,
            int? int_pIdLocal,
            DateTime? dt_pFecha,
            int? int_pHoraInicio,
            int? int_pHoraFin,
            int? int_pIdUbicacionTipo,
            int? int_pNroUbicacion)
        {
            Kruma.Core.Util.Common.List<Entidad.AperturaUbicacion> obj_Lista = new Kruma.Core.Util.Common.List<Entidad.AperturaUbicacion>();
            obj_Lista.Total = 0;

            DataOperation dop_Operacion = new DataOperation("ListarHoraReporte");
            dop_Operacion.Parameters.Add(new Parameter("@pIdEmpresa", int_pIdEmpresa.HasValue ? int_pIdEmpresa.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pIdLocal", int_pIdLocal.HasValue ? int_pIdLocal.Value : (object)DBNull.Value));
            Parameter obj_Fecha = new Parameter("@pFecha", DbType.DateTime);
            obj_Fecha.Direction = ParameterDirection.Input;
            obj_Fecha.Value = dt_pFecha.HasValue ? dt_pFecha.Value : (object)DBNull.Value;
            dop_Operacion.Parameters.Add(obj_Fecha);
            dop_Operacion.Parameters.Add(new Parameter("@pHoraInicio", int_pHoraInicio.HasValue ? int_pHoraInicio.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pHoraFin", int_pHoraFin.HasValue ? int_pHoraFin.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pIdUbicacionTipo", int_pIdUbicacionTipo.HasValue ? int_pIdUbicacionTipo.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pNroUbicacion", int_pNroUbicacion.HasValue ? int_pNroUbicacion.Value : (object)DBNull.Value));

            DataTable dt_Resultado = DataManager.ExecuteDataSet(Conexiones.CO_KantaPe, dop_Operacion).Tables[0];

            List<Entidad.AperturaUbicacion> lst_AperturaUbicacion = new List<Entidad.AperturaUbicacion>();
            Entidad.AperturaUbicacion obj_AperturaUbicacion = null;

            foreach (DataRow obj_Row in dt_Resultado.Rows)
            {
                obj_AperturaUbicacion = new Entidad.AperturaUbicacion();
                obj_AperturaUbicacion.Fecha = obj_Row["Fecha"] is DBNull ? null : (DateTime?)obj_Row["Fecha"];
                obj_AperturaUbicacion.Hora = obj_Row["Hora"] is DBNull ? null : (int?)obj_Row["Hora"];
                obj_AperturaUbicacion.HoraFinal = obj_Row["HoraFinal"] is DBNull ? null : (int?)obj_Row["HoraFinal"];

                lst_AperturaUbicacion.Add(obj_AperturaUbicacion);
            }

            obj_Lista.Result = lst_AperturaUbicacion;
            return obj_Lista;
        }

        /// <summary>Listado de ListaUbicacionReporte</summary>
        /// <param name="int_pIdLocal">IdLocal</param>
        /// <param name="int_pIdApertura">IdApertura</param>
        /// <param name="int_pIdUbicacion">IdUbicacion</param>
        /// <param name="str_pEstado">Estado</param>
        /// <returns>Lista de AperturaUbicacion</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Vicente Gonzales Osorio</CreadoPor></item>
        /// <item><FecCrea>20-03-2017</FecCrea></item></list></remarks>
        public static Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.AperturaUbicacion> ListaUbicacionReporte(
            int? int_pIdEmpresa,
            int? int_pIdLocal)
        {
            Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.AperturaUbicacion> obj_Lista = new Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.AperturaUbicacion>();
            obj_Lista.Total = 0;

            DataOperation dop_Operacion = new DataOperation("ListaUbicacionReporte");
            dop_Operacion.Parameters.Add(new Parameter("@pIdEmpresa", int_pIdEmpresa.HasValue ? int_pIdEmpresa.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pIdLocal", int_pIdLocal.HasValue ? int_pIdLocal.Value : (object)DBNull.Value));

            DataTable dt_Resultado = DataManager.ExecuteDataSet(Conexiones.CO_KantaPe, dop_Operacion).Tables[0];

            List<Kruma.KantaPe.Entidad.AperturaUbicacion> lst_AperturaUbicacion = new List<Kruma.KantaPe.Entidad.AperturaUbicacion>();
            Kruma.KantaPe.Entidad.AperturaUbicacion obj_AperturaUbicacion = new Kruma.KantaPe.Entidad.AperturaUbicacion();
            foreach (DataRow obj_Row in dt_Resultado.Rows)
            {
                obj_AperturaUbicacion = new Kruma.KantaPe.Entidad.AperturaUbicacion();
                obj_AperturaUbicacion.Ubicacion = new Kruma.KantaPe.Entidad.Ubicacion();
                obj_AperturaUbicacion.Ubicacion.IdUbicacion = obj_Row["Ubicacion_IdUbicacion"] is DBNull ? null : (int?)obj_Row["Ubicacion_IdUbicacion"];
                obj_AperturaUbicacion.Ubicacion.Numero = obj_Row["Ubicacion_Numero"] is DBNull ? null : (int?)obj_Row["Ubicacion_Numero"];

                obj_AperturaUbicacion.Ubicacion.UbicacionTipo = new Kruma.KantaPe.Entidad.UbicacionTipo();
                obj_AperturaUbicacion.Ubicacion.UbicacionTipo.IdUbicacionTipo = obj_Row["UbicacionTipo_IdUbicacionTipo"] is DBNull ? null : (int?)obj_Row["UbicacionTipo_IdUbicacionTipo"];
                obj_AperturaUbicacion.Ubicacion.UbicacionTipo.Descripcion = obj_Row["UbicacionTipo_Descripcion"] is DBNull ? null : obj_Row["UbicacionTipo_Descripcion"].ToString();

                lst_AperturaUbicacion.Add(obj_AperturaUbicacion);

            }

            obj_Lista.Result = lst_AperturaUbicacion;
            return obj_Lista;
        }
        /// <summary>Listado de ListarUbicacionAperturaMesaGrafico</summary>
        /// <param name="int_pIdLocal">IdLocal</param>
        /// <param name="int_pIdApertura">IdApertura</param>
        /// <param name="int_pIdUbicacion">IdUbicacion</param>
        /// <param name="str_pEstado">Estado</param>
        /// <returns>Lista de AperturaUbicacion</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Vicente Gonzales Osorio</CreadoPor></item>
        /// <item><FecCrea>20-03-2017</FecCrea></item></list></remarks>
        public static Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.AperturaUbicacion> ListarUbicacionAperturaMesaGrafico(
            int? int_pIdEmpresa,
            int? int_pIdLocal,
            DateTime? dt_pFecha,
            int? int_pHoraInicio,
            int? int_pHoraFin,
            int? int_pIdUbicacionTipo,
            int? int_pNroUbicacion)
        {
            Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.AperturaUbicacion> obj_Lista = new Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.AperturaUbicacion>();
            obj_Lista.Total = 0;

            DataOperation dop_Operacion = new DataOperation("ListarUbicacionAperturaMesaGrafico");
            dop_Operacion.Parameters.Add(new Parameter("@pIdEmpresa", int_pIdEmpresa.HasValue ? int_pIdEmpresa.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pIdLocal", int_pIdLocal.HasValue ? int_pIdLocal.Value : (object)DBNull.Value));
            Parameter obj_Fecha = new Parameter("@pFecha", DbType.DateTime);
            obj_Fecha.Direction = ParameterDirection.Input;
            obj_Fecha.Value = dt_pFecha.HasValue ? dt_pFecha.Value : (object)DBNull.Value;
            dop_Operacion.Parameters.Add(obj_Fecha);
            //dop_Operacion.Parameters.Add(new Parameter("@pFecha", dt_pFecha.HasValue ? dt_pFecha.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pHoraInicio", int_pHoraInicio.HasValue ? int_pHoraInicio.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pHoraFin", int_pHoraFin.HasValue ? int_pHoraFin.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pIdUbicacionTipo", int_pIdUbicacionTipo.HasValue ? int_pIdUbicacionTipo.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pNroUbicacion", int_pNroUbicacion.HasValue ? int_pNroUbicacion.Value : (object)DBNull.Value));

            DataTable dt_Resultado = DataManager.ExecuteDataSet(Conexiones.CO_KantaPe, dop_Operacion).Tables[0];

            List<Kruma.KantaPe.Entidad.AperturaUbicacion> lst_AperturaUbicacion = new List<Kruma.KantaPe.Entidad.AperturaUbicacion>();
            Kruma.KantaPe.Entidad.AperturaUbicacion obj_AperturaUbicacion = new Kruma.KantaPe.Entidad.AperturaUbicacion();
            foreach (DataRow obj_Row in dt_Resultado.Rows)
            {
                obj_AperturaUbicacion = new Kruma.KantaPe.Entidad.AperturaUbicacion();
                obj_AperturaUbicacion.DesUbicacionTipo = obj_Row["UbicacionTipo_Descripcion"] is DBNull ? null : obj_Row["UbicacionTipo_Descripcion"].ToString();
                obj_AperturaUbicacion.Hora = obj_Row["Hora"] is DBNull ? null : (int?)obj_Row["Hora"];
                obj_AperturaUbicacion.HoraFinal = obj_Row["HoraFinal"] is DBNull ? null : (int?)obj_Row["HoraFinal"];
                obj_AperturaUbicacion.Cantidad = obj_Row["Cantidad"] is DBNull ? null : (int?)obj_Row["Cantidad"];

                lst_AperturaUbicacion.Add(obj_AperturaUbicacion);
            }

            obj_Lista.Result = lst_AperturaUbicacion;
            return obj_Lista;
        }

        /// <summary>Listado de ListarUbicacionAperturaMesaGrafico</summary>
        /// <param name="int_pIdLocal">IdLocal</param>
        /// <param name="int_pIdApertura">IdApertura</param>
        /// <param name="int_pIdUbicacion">IdUbicacion</param>
        /// <param name="str_pEstado">Estado</param>
        /// <returns>Lista de AperturaUbicacion</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Vicente Gonzales Osorio</CreadoPor></item>
        /// <item><FecCrea>20-03-2017</FecCrea></item></list></remarks>
        public static Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.AperturaUbicacion> ListarUbicacionAperturaBoxGrafico(
            int? int_pIdEmpresa,
            int? int_pIdLocal,
            DateTime? dt_pFecha,
            int? int_pHoraInicio,
            int? int_pHoraFin,
            int? int_pIdUbicacionTipo,
            int? int_pNroUbicacion)
        {
            Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.AperturaUbicacion> obj_Lista = new Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.AperturaUbicacion>();
            obj_Lista.Total = 0;

            DataOperation dop_Operacion = new DataOperation("ListarUbicacionAperturaBoxGrafico");
            dop_Operacion.Parameters.Add(new Parameter("@pIdEmpresa", int_pIdEmpresa.HasValue ? int_pIdEmpresa.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pIdLocal", int_pIdLocal.HasValue ? int_pIdLocal.Value : (object)DBNull.Value));
            Parameter obj_Fecha = new Parameter("@pFecha", DbType.DateTime);
            obj_Fecha.Direction = ParameterDirection.Input;
            obj_Fecha.Value = dt_pFecha.HasValue ? dt_pFecha.Value : (object)DBNull.Value;
            dop_Operacion.Parameters.Add(obj_Fecha);
            //dop_Operacion.Parameters.Add(new Parameter("@pFecha", dt_pFecha.HasValue ? dt_pFecha.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pHoraInicio", int_pHoraInicio.HasValue ? int_pHoraInicio.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pHoraFin", int_pHoraFin.HasValue ? int_pHoraFin.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pIdUbicacionTipo", int_pIdUbicacionTipo.HasValue ? int_pIdUbicacionTipo.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pNroUbicacion", int_pNroUbicacion.HasValue ? int_pNroUbicacion.Value : (object)DBNull.Value));

            DataTable dt_Resultado = DataManager.ExecuteDataSet(Conexiones.CO_KantaPe, dop_Operacion).Tables[0];

            List<Kruma.KantaPe.Entidad.AperturaUbicacion> lst_AperturaUbicacion = new List<Kruma.KantaPe.Entidad.AperturaUbicacion>();
            Kruma.KantaPe.Entidad.AperturaUbicacion obj_AperturaUbicacion = new Kruma.KantaPe.Entidad.AperturaUbicacion();
            foreach (DataRow obj_Row in dt_Resultado.Rows)
            {
                obj_AperturaUbicacion = new Kruma.KantaPe.Entidad.AperturaUbicacion();
                obj_AperturaUbicacion.DesUbicacionTipo = obj_Row["UbicacionTipo_Descripcion"] is DBNull ? null : obj_Row["UbicacionTipo_Descripcion"].ToString();
                obj_AperturaUbicacion.Hora = obj_Row["Hora"] is DBNull ? null : (int?)obj_Row["Hora"];
                obj_AperturaUbicacion.HoraFinal = obj_Row["HoraFinal"] is DBNull ? null : (int?)obj_Row["HoraFinal"];
                obj_AperturaUbicacion.Cantidad = obj_Row["Cantidad"] is DBNull ? null : (int?)obj_Row["Cantidad"];

                lst_AperturaUbicacion.Add(obj_AperturaUbicacion);
            }

            obj_Lista.Result = lst_AperturaUbicacion;
            return obj_Lista;
        }
        #endregion
    }
}