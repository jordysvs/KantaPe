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
    /// <summary>Horario</summary>
    /// <remarks><list type="bullet">
    /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
    /// <item><FecCrea>12-07-2016</FecCrea></item></list></remarks>

    public class Horario
    {
        #region Metodos Públicos

        /// <summary>Listado de Horario</summary>
        /// <param name="int_pIdLocal">IdLocal</param>
        /// <param name="int_pIdUbicacion">IdUbicacion</param>
        /// <param name="int_pIdHorario">IdHorario</param>
        /// <param name="int_pIdMozo">IdMozo</param>
        /// <param name="int_pDia">Dia</param>
        /// <param name="str_pEstado">Estado</param>
        /// <param name="int_pNumPagina" >Numero de pagina</param>
        /// <param name="int_pTamPagina" >Tamaño de pagina</param>
        /// <returns>Lista de Horario</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>12-07-2016</FecCrea></item></list></remarks>
        public static Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Horario> Listar(
            int? int_pIdLocal,
            int? int_pIdUbicacion,
            int? int_pIdHorario,
            int? int_pIdMozo,
            int? int_pDia,
            string str_pEstado,
            int? int_pNumPagina,
            int? int_pTamPagina)
        {
            Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Horario> obj_Lista = new Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Horario>();
            obj_Lista.PageNumber = int_pNumPagina;
            obj_Lista.Total = 0;

            DataOperation dop_Operacion = new DataOperation("ListarHorario");
            dop_Operacion.Parameters.Add(new Parameter("@pIdLocal", int_pIdLocal.HasValue ? int_pIdLocal.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pIdUbicacion", int_pIdUbicacion.HasValue ? int_pIdUbicacion.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pIdHorario", int_pIdHorario.HasValue ? int_pIdHorario.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pIdMozo", int_pIdMozo.HasValue ? int_pIdMozo.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pDia", int_pDia.HasValue ? int_pDia.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pEstado", !string.IsNullOrEmpty(str_pEstado) ? str_pEstado : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pNumPagina", int_pNumPagina.HasValue ? int_pNumPagina.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pTamPagina", int_pTamPagina.HasValue ? int_pTamPagina.Value : (object)DBNull.Value));

            DataTable dt_Resultado = DataManager.ExecuteDataSet(Conexiones.CO_KantaPe, dop_Operacion).Tables[0];

            List<Kruma.KantaPe.Entidad.Horario> lst_Horario = new List<Kruma.KantaPe.Entidad.Horario>();
            Kruma.KantaPe.Entidad.Horario obj_Horario = new Kruma.KantaPe.Entidad.Horario();
            foreach (DataRow obj_Row in dt_Resultado.Rows)
            {
                if (lst_Horario.Count == 0)
                    obj_Lista.Total = (int)obj_Row["Total_Filas"];
                obj_Horario = new Kruma.KantaPe.Entidad.Horario();
                obj_Horario.IdLocal = obj_Row["IdLocal"] is DBNull ? null : (int?)obj_Row["IdLocal"];
                obj_Horario.IdUbicacion = obj_Row["IdUbicacion"] is DBNull ? null : (int?)obj_Row["IdUbicacion"];
                obj_Horario.IdHorario = obj_Row["IdHorario"] is DBNull ? null : (int?)obj_Row["IdHorario"];
                obj_Horario.IdMozo = obj_Row["IdMozo"] is DBNull ? null : (int?)obj_Row["IdMozo"];
                obj_Horario.Dia = obj_Row["Dia"] is DBNull ? null : (DayOfWeek?)((int)obj_Row["Dia"]);
                obj_Horario.Estado = obj_Row["Estado"] is DBNull ? null : obj_Row["Estado"].ToString();
                obj_Horario.UsuarioCreacion = obj_Row["UsuarioCreacion"] is DBNull ? null : obj_Row["UsuarioCreacion"].ToString();
                obj_Horario.FechaCreacion = obj_Row["FechaCreacion"] is DBNull ? null : (DateTime?)obj_Row["FechaCreacion"];
                obj_Horario.UsuarioModificacion = obj_Row["UsuarioModificacion"] is DBNull ? null : obj_Row["UsuarioModificacion"].ToString();
                obj_Horario.FechaModificacion = obj_Row["FechaModificacion"] is DBNull ? null : (DateTime?)obj_Row["FechaModificacion"];

                obj_Horario.Empleado = new KantaPe.Entidad.Empleado();
                obj_Horario.Empleado.IdEmpleado = obj_Row["Empleado_IdEmpleado"] is DBNull ? null : (int?)obj_Row["Empleado_IdEmpleado"];
                obj_Horario.Empleado.IdPersona = obj_Row["Empleado_IdPersona"] is DBNull ? null : (int?)obj_Row["Empleado_IdPersona"];
                
                obj_Horario.Empleado.Persona = new Core.Business.Entity.Persona();
                obj_Horario.Empleado.Persona.IdPersona = obj_Row["CorePersona_IdPersona"] is DBNull ? null : (int?)obj_Row["CorePersona_IdPersona"];
                obj_Horario.Empleado.Persona.Nombres = obj_Row["CorePersona_Nombres"] is DBNull ? null : obj_Row["CorePersona_Nombres"].ToString();
                obj_Horario.Empleado.Persona.ApellidoPaterno = obj_Row["CorePersona_ApellidoPaterno"] is DBNull ? null : obj_Row["CorePersona_ApellidoPaterno"].ToString();
                obj_Horario.Empleado.Persona.ApellidoMaterno = obj_Row["CorePersona_ApellidoMaterno"] is DBNull ? null : obj_Row["CorePersona_ApellidoMaterno"].ToString();

                lst_Horario.Add(obj_Horario);
            }

            obj_Lista.Result = lst_Horario;
            return obj_Lista;
        }

        /// <summary>Obtener Horario</summary>
        /// <param name="int_pIdLocal">IdLocal</param>
        /// <param name="int_pIdUbicacion">IdUbicacion</param>
        /// <param name="int_pIdHorario">IdHorario</param>
        /// <returns>Objeto Horario</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>12-07-2016</FecCrea></item></list></remarks>
        public static Kruma.KantaPe.Entidad.Horario Obtener(
            int int_pIdLocal,
            int int_pIdUbicacion,
            int int_pIdHorario)
        {
            Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Horario> lst_Horario = 
                Listar(int_pIdLocal, int_pIdUbicacion, int_pIdHorario, null, null, null, null, null);
            return lst_Horario.Result.Count > 0 ? lst_Horario.Result[0] : null;
        }

        /// <summary>Insertar Horario</summary>
        /// <param name="obj_pHorario">Horario</param>
        /// <returns>Id de Horario</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>12-07-2016</FecCrea></item></list></remarks>
        public static int Insertar(Kruma.KantaPe.Entidad.Horario obj_pHorario)
        {
            DataOperation dop_Operacion = new DataOperation("InsertarHorario");

            dop_Operacion.Parameters.Add(new Parameter("@pIdLocal", obj_pHorario.IdLocal));
            dop_Operacion.Parameters.Add(new Parameter("@pIdUbicacion", obj_pHorario.IdUbicacion));
            dop_Operacion.Parameters.Add(new Parameter("@pIdMozo", obj_pHorario.IdMozo));
            dop_Operacion.Parameters.Add(new Parameter("@pDia", obj_pHorario.Dia.Value.GetHashCode()));
            dop_Operacion.Parameters.Add(new Parameter("@pEstado", obj_pHorario.Estado));
            dop_Operacion.Parameters.Add(new Parameter("@pUsuarioCreacion", obj_pHorario.UsuarioCreacion));

            Parameter obj_IdHorario = new Parameter("@pIdHorario", DbType.Int32);
            obj_IdHorario.Direction = ParameterDirection.Output;
            dop_Operacion.Parameters.Add(obj_IdHorario);

            DataManager.ExecuteNonQuery(Conexiones.CO_KantaPe, dop_Operacion, false);
            int int_IdHorario = (int)obj_IdHorario.Value;
            return int_IdHorario;
        }

        /// <summary>Modificar Horario</summary>
        /// <param name="obj_pHorario">Horario</param>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>12-07-2016</FecCrea></item></list></remarks>
        public static void Modificar(Kruma.KantaPe.Entidad.Horario obj_pHorario)
        {
            DataOperation dop_Operacion = new DataOperation("ActualizarHorario");

            dop_Operacion.Parameters.Add(new Parameter("@pIdLocal", obj_pHorario.IdLocal));
            dop_Operacion.Parameters.Add(new Parameter("@pIdUbicacion", obj_pHorario.IdUbicacion));
            dop_Operacion.Parameters.Add(new Parameter("@pIdHorario", obj_pHorario.IdHorario));
            dop_Operacion.Parameters.Add(new Parameter("@pIdMozo", obj_pHorario.IdMozo));
            dop_Operacion.Parameters.Add(new Parameter("@pDia", obj_pHorario.Dia.Value.GetHashCode()));
            dop_Operacion.Parameters.Add(new Parameter("@pEstado", obj_pHorario.Estado));
            dop_Operacion.Parameters.Add(new Parameter("@pUsuarioModificacion", obj_pHorario.UsuarioModificacion));

            DataManager.ExecuteNonQuery(Conexiones.CO_KantaPe, dop_Operacion, false);
        }

        #endregion
    }
}