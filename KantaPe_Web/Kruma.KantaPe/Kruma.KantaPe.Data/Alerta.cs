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
    /// <summary>Alerta</summary>
    /// <remarks><list type="bullet">
    /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
    /// <item><FecCrea>25-07-2016</FecCrea></item></list></remarks>

    public class Alerta
    {
        #region Metodos Públicos

        /// <summary>Listado de Alerta</summary>
        /// <param name="int_pIdLocal">IdLocal</param>
        /// <param name="int_pIdAlerta">IdAlerta</param>
        /// <param name="int_pIdAlertaTipo">IdAlertaTipo</param>
        /// <param name="dt_pFechaInicio">Fecha de inicio</param>
        /// <param name="dt_pFechaFin">Fecha fin</param>
        /// <param name="str_pIdUsuario">IdUsuario</param>
        /// <param name="str_pEstado">Estado</param>
        /// <param name="int_pNumPagina" >Numero de pagina</param>
        /// <param name="int_pTamPagina" >Tamaño de pagina</param>
        /// <returns>Lista de Alerta</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>25-07-2016</FecCrea></item></list></remarks>
        public static Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Alerta> Listar(
            int? int_pIdLocal,
            int? int_pIdUbicacion,
            int? int_pIdAlerta,
            int? int_pIdAlertaTipo,
            DateTime? dt_pFechaInicio,
            DateTime? dt_pFechaFin,
            string str_pIdUsuario,
            string str_pEstado,
            int? int_pNumPagina,
            int? int_pTamPagina)
        {
            Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Alerta> obj_Lista = new Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Alerta>();
            obj_Lista.PageNumber = int_pNumPagina;
            obj_Lista.Total = 0;

            DataOperation dop_Operacion = new DataOperation("ListarAlerta");
            dop_Operacion.Parameters.Add(new Parameter("@pIdLocal", int_pIdLocal.HasValue ? int_pIdLocal.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pIdUbicacion", int_pIdUbicacion.HasValue ? int_pIdUbicacion.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pIdAlerta", int_pIdAlerta.HasValue ? int_pIdAlerta.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pIdAlertaTipo", int_pIdAlertaTipo.HasValue ? int_pIdAlertaTipo.Value : (object)DBNull.Value));

            Parameter obj_FechaInicio = new Parameter("@pFechaInicio", DbType.DateTime);
            obj_FechaInicio.Direction = ParameterDirection.Input;
            obj_FechaInicio.Value = dt_pFechaInicio.HasValue ? dt_pFechaFin.Value : (object)DBNull.Value;
            dop_Operacion.Parameters.Add(obj_FechaInicio);

            Parameter obj_FechaFin = new Parameter("@pFechaFin", DbType.DateTime);
            obj_FechaFin.Direction = ParameterDirection.Input;
            obj_FechaFin.Value = dt_pFechaFin.HasValue ? dt_pFechaFin.Value : (object)DBNull.Value;
            dop_Operacion.Parameters.Add(obj_FechaFin);

            dop_Operacion.Parameters.Add(new Parameter("@pIdUsuario", !string.IsNullOrEmpty(str_pIdUsuario) ? str_pIdUsuario : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pEstado", !string.IsNullOrEmpty(str_pEstado) ? str_pEstado : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pNumPagina", int_pNumPagina.HasValue ? int_pNumPagina.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pTamPagina", int_pTamPagina.HasValue ? int_pTamPagina.Value : (object)DBNull.Value));

            DataTable dt_Resultado = DataManager.ExecuteDataSet(Conexiones.CO_KantaPe, dop_Operacion).Tables[0];

            List<Kruma.KantaPe.Entidad.Alerta> lst_Alerta = new List<Kruma.KantaPe.Entidad.Alerta>();
            Kruma.KantaPe.Entidad.Alerta obj_Alerta = new Kruma.KantaPe.Entidad.Alerta();
            foreach (DataRow obj_Row in dt_Resultado.Rows)
            {
                if (lst_Alerta.Count == 0)
                    obj_Lista.Total = (int)obj_Row["Total_Filas"];
                obj_Alerta = new Kruma.KantaPe.Entidad.Alerta();
                obj_Alerta.IdLocal = obj_Row["IdLocal"] is DBNull ? null : (int?)obj_Row["IdLocal"];
                obj_Alerta.IdUbicacion = obj_Row["IdUbicacion"] is DBNull ? null : (int?)obj_Row["IdUbicacion"];
                obj_Alerta.IdAlerta = obj_Row["IdAlerta"] is DBNull ? null : (int?)obj_Row["IdAlerta"];
                obj_Alerta.IdAlertaTipo = obj_Row["IdAlertaTipo"] is DBNull ? null : (int?)obj_Row["IdAlertaTipo"];
                obj_Alerta.FechaAlerta = obj_Row["FechaAlerta"] is DBNull ? null : (DateTime?)obj_Row["FechaAlerta"];
                obj_Alerta.FechaAtencion = obj_Row["FechaAtencion"] is DBNull ? null : (DateTime?)obj_Row["FechaAtencion"];
                obj_Alerta.IdUsuario = obj_Row["IdUsuario"] is DBNull ? null : obj_Row["IdUsuario"].ToString();
                obj_Alerta.Estado = obj_Row["Estado"] is DBNull ? null : obj_Row["Estado"].ToString();
                obj_Alerta.UsuarioCreacion = obj_Row["UsuarioCreacion"] is DBNull ? null : obj_Row["UsuarioCreacion"].ToString();
                obj_Alerta.FechaCreacion = obj_Row["FechaCreacion"] is DBNull ? null : (DateTime?)obj_Row["FechaCreacion"];
                obj_Alerta.UsuarioModificacion = obj_Row["UsuarioModificacion"] is DBNull ? null : obj_Row["UsuarioModificacion"].ToString();
                obj_Alerta.FechaModificacion = obj_Row["FechaModificacion"] is DBNull ? null : (DateTime?)obj_Row["FechaModificacion"];

                obj_Alerta.Local = new Kruma.KantaPe.Entidad.Local();
                obj_Alerta.Local.IdLocal = obj_Row["Local_IdLocal"] is DBNull ? null : (int?)obj_Row["Local_IdLocal"];
                obj_Alerta.Local.IdEmpresa = obj_Row["Local_IdEmpresa"] is DBNull ? null : (int?)obj_Row["Local_IdEmpresa"];
                obj_Alerta.Local.IdDireccion = obj_Row["Local_IdDireccion"] is DBNull ? null : (int?)obj_Row["Local_IdDireccion"];
                obj_Alerta.Local.Nombre = obj_Row["PersonaDireccion_Nombre"] is DBNull ? null : obj_Row["PersonaDireccion_Nombre"].ToString();
                obj_Alerta.Local.Direccion = obj_Row["PersonaDireccion_Direccion"] is DBNull ? null : obj_Row["PersonaDireccion_Direccion"].ToString();

                obj_Alerta.Local.Empresa = new Kruma.KantaPe.Entidad.Empresa();
                obj_Alerta.Local.Empresa.IdPersona = obj_Row["Persona_IdPersona"] is DBNull ? null : (int?)obj_Row["Persona_IdPersona"];
                obj_Alerta.Local.Empresa.IdTipoDocumento = obj_Row["Persona_IdTipoDocumento"] is DBNull ? null : (int?)obj_Row["Persona_IdTipoDocumento"];
                obj_Alerta.Local.Empresa.NumeroDocumento = obj_Row["Persona_NumeroDocumento"] is DBNull ? null : obj_Row["Persona_NumeroDocumento"].ToString();
                obj_Alerta.Local.Empresa.RazonSocial = obj_Row["Persona_RazonSocial"] is DBNull ? null : obj_Row["Persona_RazonSocial"].ToString();
                obj_Alerta.Local.Empresa.NombreComercial = obj_Row["Persona_NombreComercial"] is DBNull ? null : obj_Row["Persona_NombreComercial"].ToString();

                obj_Alerta.Ubicacion = new Entidad.Ubicacion();
                obj_Alerta.Ubicacion.IdLocal = obj_Row["Ubicacion_IdLocal"] is DBNull ? null : (int?)obj_Row["Ubicacion_IdLocal"];
                obj_Alerta.Ubicacion.IdUbicacion = obj_Row["Ubicacion_IdUbicacion"] is DBNull ? null : (int?)obj_Row["Ubicacion_IdUbicacion"];
                obj_Alerta.Ubicacion.IdUbicacionTipo = obj_Row["Ubicacion_IdUbicacionTipo"] is DBNull ? null : (int?)obj_Row["Ubicacion_IdUbicacionTipo"];
                obj_Alerta.Ubicacion.Numero = obj_Row["Ubicacion_Numero"] is DBNull ? null : (int?)obj_Row["Ubicacion_Numero"];
                obj_Alerta.Ubicacion.Capacidad = obj_Row["Ubicacion_Capacidad"] is DBNull ? null : (int?)obj_Row["Ubicacion_Capacidad"];

                obj_Alerta.Ubicacion.UbicacionTipo = new Entidad.UbicacionTipo();
                obj_Alerta.Ubicacion.UbicacionTipo.IdUbicacionTipo = obj_Row["UbicacionTipo_IdUbicacionTipo"] is DBNull ? null : (int?)obj_Row["UbicacionTipo_IdUbicacionTipo"];
                obj_Alerta.Ubicacion.UbicacionTipo.Descripcion = obj_Row["UbicacionTipo_Descripcion"] is DBNull ? null : obj_Row["UbicacionTipo_Descripcion"].ToString();

                obj_Alerta.AlertaTipo = new Entidad.AlertaTipo();
                obj_Alerta.AlertaTipo.IdAlertaTipo = obj_Row["AlertaTipo_IdAlertaTipo"] is DBNull ? null : (int?)obj_Row["AlertaTipo_IdAlertaTipo"];
                obj_Alerta.AlertaTipo.Descripcion = obj_Row["AlertaTipo_Descripcion"] is DBNull ? null : obj_Row["AlertaTipo_Descripcion"].ToString();

                obj_Alerta.Usuario = new Core.Security.Entity.Usuario();
                obj_Alerta.Usuario.IdUsuario = obj_Row["Usuario_IdUsuario"] is DBNull ? null : obj_Row["Usuario_IdUsuario"].ToString();
                obj_Alerta.Usuario.IdPersona = obj_Row["Usuario_IdPersona"] is DBNull ? null : (int?)obj_Row["Usuario_IdPersona"];
                obj_Alerta.Usuario.Persona = new Core.Business.Entity.Persona();
                obj_Alerta.Usuario.Persona.IdPersona = obj_Row["Usuario_Persona_IdPersona"] is DBNull ? null : (int?)obj_Row["Usuario_Persona_IdPersona"];
                obj_Alerta.Usuario.Persona.Nombres = obj_Row["Usuario_Persona_Nombres"] is DBNull ? null : obj_Row["Usuario_Persona_Nombres"].ToString();
                obj_Alerta.Usuario.Persona.ApellidoPaterno = obj_Row["Usuario_Persona_ApellidoPaterno"] is DBNull ? null : obj_Row["Usuario_Persona_ApellidoPaterno"].ToString();
                obj_Alerta.Usuario.Persona.ApellidoMaterno = obj_Row["Usuario_Persona_ApellidoMaterno"] is DBNull ? null : obj_Row["Usuario_Persona_ApellidoMaterno"].ToString();

                lst_Alerta.Add(obj_Alerta);
            }

            obj_Lista.Result = lst_Alerta;
            return obj_Lista;
        }

        /// <summary>Obtener Alerta</summary>
        /// <param name="int_pIdLocal">IdLocal</param>
        /// <param name="int_pIdAlerta">IdAlerta</param>
        /// <returns>Objeto Alerta</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>25-07-2016</FecCrea></item></list></remarks>
        public static Kruma.KantaPe.Entidad.Alerta Obtener(int int_pIdLocal, int int_pIdUbicacion, int int_pIdAlerta)
        {
            Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Alerta> lst_Alerta = Listar(int_pIdLocal, int_pIdUbicacion, int_pIdAlerta, null, null, null, null, null, null, null);
            return lst_Alerta.Result.Count > 0 ? lst_Alerta.Result[0] : null;
        }

        /// <summary>Obtener Alerta Pedidos</summary>
        /// <param name="int_pIdLocal">IdLocal</param>
        /// <param name="int_pIdAlerta">IdAlerta</param>
        /// <param name="str_pIdUsuario">IdUsuario</param>
        /// <param name="str_pEstado">Estado</param>
        /// <returns>Objeto Alerta</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por Jordy Vilchez</CreadoPor></item>
        /// <item><FecCrea>25-07-2016</FecCrea></item></list></remarks>
        public static Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Alerta> ObtenerAltertaPedidos(int int_pIdLocal, int int_pIdUbicacion, int int_pIdAlertaTipo, string str_pIdUsuario, string str_pEstado)
        {
            return Listar(int_pIdLocal, int_pIdUbicacion, null, int_pIdAlertaTipo, null, null, str_pIdUsuario, str_pEstado, null, null);
        }

        /// <summary>Insertar Alerta</summary>
        /// <param name="obj_pAlerta">Alerta</param>
        /// <returns>Id de Alerta</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>25-07-2016</FecCrea></item></list></remarks>
        public static int Insertar(Kruma.KantaPe.Entidad.Alerta obj_pAlerta)
        {
            DataOperation dop_Operacion = new DataOperation("InsertarAlerta");

            dop_Operacion.Parameters.Add(new Parameter("@pIdLocal", obj_pAlerta.IdLocal));
            dop_Operacion.Parameters.Add(new Parameter("@pIdUbicacion", obj_pAlerta.IdUbicacion));
            dop_Operacion.Parameters.Add(new Parameter("@pIdAlertaTipo", obj_pAlerta.IdAlertaTipo));

            Parameter obj_FechaAlerta = new Parameter("@pFechaAlerta", DbType.DateTime);
            obj_FechaAlerta.Direction = ParameterDirection.Input;
            obj_FechaAlerta.Value = obj_pAlerta.FechaAlerta;
            dop_Operacion.Parameters.Add(obj_FechaAlerta);

            dop_Operacion.Parameters.Add(new Parameter("@pIdUsuario", obj_pAlerta.IdUsuario));
            dop_Operacion.Parameters.Add(new Parameter("@pEstado", obj_pAlerta.Estado));
            dop_Operacion.Parameters.Add(new Parameter("@pUsuarioCreacion", obj_pAlerta.UsuarioCreacion));

            Parameter obj_IdAlerta = new Parameter("@pIdAlerta", DbType.Int32);
            obj_IdAlerta.Direction = ParameterDirection.Output;
            dop_Operacion.Parameters.Add(obj_IdAlerta);

            DataManager.ExecuteNonQuery(Conexiones.CO_KantaPe, dop_Operacion, false);
            int int_IdAlerta = (int)obj_IdAlerta.Value;
            return int_IdAlerta;
        }

        /// <summary>Modificar Alerta</summary>
        /// <param name="obj_pAlerta">Alerta</param>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>25-07-2016</FecCrea></item></list></remarks>
        public static void Modificar(Kruma.KantaPe.Entidad.Alerta obj_pAlerta)
        {
            DataOperation dop_Operacion = new DataOperation("ActualizarAlerta");

            dop_Operacion.Parameters.Add(new Parameter("@pIdLocal", obj_pAlerta.IdLocal));
            dop_Operacion.Parameters.Add(new Parameter("@pIdUbicacion", obj_pAlerta.IdUbicacion));
            dop_Operacion.Parameters.Add(new Parameter("@pIdAlerta", obj_pAlerta.IdAlerta));
            dop_Operacion.Parameters.Add(new Parameter("@pIdAlertaTipo", obj_pAlerta.IdAlertaTipo));

            Parameter obj_FechaAlerta = new Parameter("@pFechaAlerta", DbType.DateTime);
            obj_FechaAlerta.Direction = ParameterDirection.Input;
            obj_FechaAlerta.Value = obj_pAlerta.FechaAlerta;
            dop_Operacion.Parameters.Add(obj_FechaAlerta);

            Parameter obj_FechaAtencion = new Parameter("@pFechaAtencion", DbType.DateTime);
            obj_FechaAtencion.Direction = ParameterDirection.Input;
            obj_FechaAtencion.Value = obj_pAlerta.FechaAtencion;
            dop_Operacion.Parameters.Add(obj_FechaAtencion);

            dop_Operacion.Parameters.Add(new Parameter("@pIdUsuario", obj_pAlerta.IdUsuario));
            dop_Operacion.Parameters.Add(new Parameter("@pEstado", obj_pAlerta.Estado));
            dop_Operacion.Parameters.Add(new Parameter("@pUsuarioModificacion", obj_pAlerta.UsuarioModificacion));

            DataManager.ExecuteNonQuery(Conexiones.CO_KantaPe, dop_Operacion, false);
        }

        /// <summary>CerrarAlertas</summary>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por Diego Mendoza</CreadoPor></item>
        /// <item><FecCrea>29-03-2017</FecCrea></item></list></remarks>
        public static void CerrarAlertas(int? int_pIdLocal)
        {
            DataOperation dop_Operacion = new DataOperation("CerrarAlertas");
            dop_Operacion.Parameters.Add(new Parameter("@pIdLocal", int_pIdLocal.HasValue ? int_pIdLocal.Value : (object)DBNull.Value));
            DataManager.ExecuteNonQuery(Conexiones.CO_KantaPe, dop_Operacion, false);
        }

        #endregion
    }
}