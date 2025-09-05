
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
    /// <summary>Empleado</summary>
    /// <remarks><list type="bullet">
    /// <item><CreadoPor>Creado por Kruma</CreadoPor></item>
    /// <item><FecCrea>13-07-2016</FecCrea></item></list></remarks>

    public class Empleado
    {
        #region Metodos Públicos

        /// <summary>Listado de Empleado</summary>
        /// <param name="int_pIdEmpleado">IdEmpleado</param>
        /// <param name="int_pIdPersona">IdPersona</param>
        /// <param name="int_pIdEmpresa">IdEmpresa</param>
        /// <param name="int_pIdArea">IdArea</param>
        /// <param name="int_pIdPuesto">IdPuesto</param>
        /// <param name="dt_pFechaIngreso">FechaIngreso</param>
        /// <param name="str_pEstado">Estado</param>
        /// <param name="int_pNumPagina" >Numero de pagina</param>
        /// <param name="int_pTamPagina" >Tamaño de pagina</param>
        /// <returns>Lista de Empleado</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por Kruma</CreadoPor></item>
        /// <item><FecCrea>13-07-2016</FecCrea></item></list></remarks>
        public static Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Empleado> Listar(
            int? int_pIdEmpleado,
            int? int_pIdEmpresa,
            int? int_pIdPersona,
            int? int_pIdLocal,
            int? int_pIdTipoDocumento,
            string str_pNumeroDocumento,
            string str_pNombreCompleto,
            string str_pEstado,
            int? int_pNumPagina,
            int? int_pTamPagina)
        {
            Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Empleado> obj_Lista = new Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Empleado>();
            obj_Lista.PageNumber = int_pNumPagina;
            obj_Lista.Total = 0;

            DataOperation dop_Operacion = new DataOperation("ListarEmpleado");
            dop_Operacion.Parameters.Add(new Parameter("@pIdEmpleado", int_pIdEmpleado.HasValue ? int_pIdEmpleado.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pIdEmpresa", int_pIdEmpresa.HasValue ? int_pIdEmpresa.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pIdPersona", int_pIdPersona.HasValue ? int_pIdPersona.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pIdLocal", int_pIdLocal.HasValue ? int_pIdLocal.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pIdTipoDocumento", int_pIdTipoDocumento.HasValue ? int_pIdTipoDocumento.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pNumeroDocumento", !string.IsNullOrEmpty(str_pNombreCompleto) ? str_pNombreCompleto : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pNombreCompleto", !string.IsNullOrEmpty(str_pNombreCompleto) ? str_pNombreCompleto : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pEstado", !string.IsNullOrEmpty(str_pEstado) ? str_pEstado : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pNumPagina", int_pNumPagina.HasValue ? int_pNumPagina.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pTamPagina", int_pTamPagina.HasValue ? int_pTamPagina.Value : (object)DBNull.Value));

            DataTable dt_Resultado = DataManager.ExecuteDataSet(Conexiones.CO_KantaPe, dop_Operacion).Tables[0];

            List<Kruma.KantaPe.Entidad.Empleado> lst_Empleado = new List<Kruma.KantaPe.Entidad.Empleado>();
            Kruma.KantaPe.Entidad.Empleado obj_Empleado = new Kruma.KantaPe.Entidad.Empleado();
            foreach (DataRow obj_Row in dt_Resultado.Rows)
            {
                if (lst_Empleado.Count == 0)
                    obj_Lista.Total = (int)obj_Row["Total_Filas"];
                obj_Empleado = new Kruma.KantaPe.Entidad.Empleado();
                obj_Empleado.IdEmpleado = obj_Row["IdEmpleado"] is DBNull ? null : (int?)obj_Row["IdEmpleado"];
                obj_Empleado.IdPersona = obj_Row["IdPersona"] is DBNull ? null : (int?)obj_Row["IdPersona"];
                obj_Empleado.IdEmpresa = obj_Row["IdEmpresa"] is DBNull ? null : (int?)obj_Row["IdEmpresa"];
                obj_Empleado.IdLocal = obj_Row["IdLocal"] is DBNull ? null : (int?)obj_Row["IdLocal"];
                obj_Empleado.IdArea = obj_Row["IdArea"] is DBNull ? null : (int?)obj_Row["IdArea"];
                obj_Empleado.IdPuesto = obj_Row["IdPuesto"] is DBNull ? null : (int?)obj_Row["IdPuesto"];
                obj_Empleado.FechaIngreso = obj_Row["FechaIngreso"] is DBNull ? null : (DateTime?)obj_Row["FechaIngreso"];
                obj_Empleado.Estado = obj_Row["Estado"] is DBNull ? null : obj_Row["Estado"].ToString();
                obj_Empleado.UsuarioCreacion = obj_Row["UsuarioCreacion"] is DBNull ? null : obj_Row["UsuarioCreacion"].ToString();
                obj_Empleado.FechaCreacion = obj_Row["FechaCreacion"] is DBNull ? null : (DateTime?)obj_Row["FechaCreacion"];
                obj_Empleado.UsuarioModificacion = obj_Row["UsuarioModificacion"] is DBNull ? null : obj_Row["UsuarioModificacion"].ToString();
                obj_Empleado.FechaModificacion = obj_Row["FechaModificacion"] is DBNull ? null : (DateTime?)obj_Row["FechaModificacion"];

                //Empleado
                obj_Empleado.Persona = new Core.Business.Entity.Persona();
                obj_Empleado.Persona.IdPersona = obj_Row["CorePersona_IdPersona"] is DBNull ? null : (int?)obj_Row["CorePersona_IdPersona"];
                obj_Empleado.Persona.IdTipoDocumento = obj_Row["CorePersona_IdTipoDocumento"] is DBNull ? null : (int?)obj_Row["CorePersona_IdTipoDocumento"];
                obj_Empleado.Persona.NumeroDocumento = obj_Row["CorePersona_NumeroDocumento"] is DBNull ? null : obj_Row["CorePersona_NumeroDocumento"].ToString();
                obj_Empleado.Persona.Nombres = obj_Row["CorePersona_Nombres"] is DBNull ? null : obj_Row["CorePersona_NumeroDocumento"].ToString();
                obj_Empleado.Persona.ApellidoPaterno = obj_Row["CorePersona_ApellidoPaterno"] is DBNull ? null : obj_Row["CorePersona_ApellidoPaterno"].ToString();
                obj_Empleado.Persona.ApellidoMaterno = obj_Row["CorePersona_ApellidoMaterno"] is DBNull ? null : obj_Row["CorePersona_ApellidoMaterno"].ToString();

                obj_Empleado.Persona.TipoDocumento = new Core.Business.Entity.TipoDocumento();
                obj_Empleado.Persona.TipoDocumento.IdTipoDocumento = obj_Row["CoreTipoDocumento_IdTipoDocumento"] is DBNull ? null : (int?)obj_Row["CoreTipoDocumento_IdTipoDocumento"];
                obj_Empleado.Persona.TipoDocumento.Descripcion = obj_Row["CoreTipoDocumento_Descripcion"] is DBNull ? null : obj_Row["CoreTipoDocumento_Descripcion"].ToString();

                //Empresa
                obj_Empleado.Empresa = new Entidad.Empresa();
                obj_Empleado.Empresa.IdEmpresa = obj_Row["Empresa_IdEmpresa"] is DBNull ? null : (int?)obj_Row["Empresa_IdEmpresa"];
                obj_Empleado.Empresa.IdPersona = obj_Row["Empresa_IdPersona"] is DBNull ? null : (int?)obj_Row["Empresa_IdPersona"];
                obj_Empleado.Empresa.IdTipoDocumento = obj_Row["Empresa_IdTipoDocumento"] is DBNull ? null : (int?)obj_Row["Empresa_IdTipoDocumento"];
                obj_Empleado.Empresa.NumeroDocumento = obj_Row["Empresa_NumeroDocumento"] is DBNull ? null : obj_Row["Empresa_NumeroDocumento"].ToString();
                obj_Empleado.Empresa.RazonSocial = obj_Row["Empresa_RazonSocial"] is DBNull ? null : obj_Row["Empresa_RazonSocial"].ToString();
                obj_Empleado.Empresa.NombreComercial = obj_Row["Empresa_NombreComercial"] is DBNull ? null : obj_Row["Empresa_NombreComercial"].ToString();

                obj_Empleado.Empresa.TipoDocumento = new Core.Business.Entity.TipoDocumento();
                obj_Empleado.Empresa.TipoDocumento.IdTipoDocumento = obj_Row["Empresa_CoreTipoDocumento_IdTipoDocumento"] is DBNull ? null : (int?)obj_Row["Empresa_CoreTipoDocumento_IdTipoDocumento"];
                obj_Empleado.Empresa.TipoDocumento.Descripcion = obj_Row["Empresa_CoreTipoDocumento_Descripcion"] is DBNull ? null : obj_Row["Empresa_CoreTipoDocumento_Descripcion"].ToString();

                //Local
                obj_Empleado.Local = new Entidad.Local();
                obj_Empleado.Local.IdLocal = obj_Row["Local_IdLocal"] is DBNull ? null : (int?)obj_Row["Local_IdLocal"];
                obj_Empleado.Local.IdEmpresa = obj_Row["Local_IdEmpresa"] is DBNull ? null : (int?)obj_Row["Local_IdEmpresa"];
                obj_Empleado.Local.IdDireccion = obj_Row["Local_IdDireccion"] is DBNull ? null : (int?)obj_Row["Local_IdDireccion"];
                obj_Empleado.Local.Nombre = obj_Row["Local_CorePersonaDireccion_Nombre"] is DBNull ? null : obj_Row["Local_CorePersonaDireccion_Nombre"].ToString();
                obj_Empleado.Local.Direccion = obj_Row["Local_CorePersonaDireccion_Direccion"] is DBNull ? null : obj_Row["Local_CorePersonaDireccion_Direccion"].ToString();

                lst_Empleado.Add(obj_Empleado);
            }

            obj_Lista.Result = lst_Empleado;
            return obj_Lista;
        }

        /// <summary>Obtener Empleado</summary>
        /// <param name="int_pIdEmpleado">IdEmpleado</param>
        /// <returns>Objeto Empleado</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por Kruma</CreadoPor></item>
        /// <item><FecCrea>13-07-2016</FecCrea></item></list></remarks>
        public static Kruma.KantaPe.Entidad.Empleado Obtener(int? int_pIdEmpleado, int? int_pIdPersona)
        {
            Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Empleado> lst_Empleado = Listar(int_pIdEmpleado, null, int_pIdPersona, null, null, null, null, null, null, null);
            return lst_Empleado.Result.Count > 0 ? lst_Empleado.Result[0] : null;
        }

        /// <summary>Insertar Empleado</summary>
        /// <param name="obj_pEmpleado">Empleado</param>
        /// <returns>Id de Empleado</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por Kruma</CreadoPor></item>
        /// <item><FecCrea>13-07-2016</FecCrea></item></list></remarks>
        public static int Insertar(Kruma.KantaPe.Entidad.Empleado obj_pEmpleado)
        {
            DataOperation dop_Operacion = new DataOperation("InsertarEmpleado");

            dop_Operacion.Parameters.Add(new Parameter("@pIdPersona", obj_pEmpleado.IdPersona));
            dop_Operacion.Parameters.Add(new Parameter("@pIdEmpresa", obj_pEmpleado.IdEmpresa));
            dop_Operacion.Parameters.Add(new Parameter("@pIdLocal", obj_pEmpleado.IdLocal));
            dop_Operacion.Parameters.Add(new Parameter("@pIdArea", obj_pEmpleado.IdArea));
            dop_Operacion.Parameters.Add(new Parameter("@pIdPuesto", obj_pEmpleado.IdPuesto));
            dop_Operacion.Parameters.Add(new Parameter("@pFechaIngreso", obj_pEmpleado.FechaIngreso));
            dop_Operacion.Parameters.Add(new Parameter("@pEstado", obj_pEmpleado.Estado));
            dop_Operacion.Parameters.Add(new Parameter("@pUsuarioCreacion", obj_pEmpleado.UsuarioCreacion));

            Parameter obj_IdEmpleado = new Parameter("@pIdEmpleado", DbType.Int32);
            obj_IdEmpleado.Direction = ParameterDirection.Output;
            dop_Operacion.Parameters.Add(obj_IdEmpleado);

            DataManager.ExecuteNonQuery(Conexiones.CO_KantaPe, dop_Operacion, false);
            int int_IdEmpleado = (int)obj_IdEmpleado.Value;
            return int_IdEmpleado;
        }

        /// <summary>Modificar Empleado</summary>
        /// <param name="obj_pEmpleado">Empleado</param>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por Kruma</CreadoPor></item>
        /// <item><FecCrea>13-07-2016</FecCrea></item></list></remarks>
        public static void Modificar(Kruma.KantaPe.Entidad.Empleado obj_pEmpleado)
        {
            DataOperation dop_Operacion = new DataOperation("ActualizarEmpleado");

            dop_Operacion.Parameters.Add(new Parameter("@pIdEmpleado", obj_pEmpleado.IdEmpleado));
            dop_Operacion.Parameters.Add(new Parameter("@pIdPersona", obj_pEmpleado.IdPersona));
            dop_Operacion.Parameters.Add(new Parameter("@pIdEmpresa", obj_pEmpleado.IdEmpresa));
            dop_Operacion.Parameters.Add(new Parameter("@pIdLocal", obj_pEmpleado.IdLocal));
            dop_Operacion.Parameters.Add(new Parameter("@pIdArea", obj_pEmpleado.IdArea));
            dop_Operacion.Parameters.Add(new Parameter("@pIdPuesto", obj_pEmpleado.IdPuesto));
            dop_Operacion.Parameters.Add(new Parameter("@pFechaIngreso", obj_pEmpleado.FechaIngreso));
            dop_Operacion.Parameters.Add(new Parameter("@pEstado", obj_pEmpleado.Estado));
            dop_Operacion.Parameters.Add(new Parameter("@pUsuarioModificacion", obj_pEmpleado.UsuarioModificacion));

            DataManager.ExecuteNonQuery(Conexiones.CO_KantaPe, dop_Operacion, false);
        }

        #endregion
    }
}