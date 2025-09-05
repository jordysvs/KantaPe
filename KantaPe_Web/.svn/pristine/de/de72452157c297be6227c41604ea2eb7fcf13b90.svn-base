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
    /// <summary>Empresa</summary>
    /// <remarks><list type="bullet">
    /// <item><CreadoPor>Creado por Kruma</CreadoPor></item>
    /// <item><FecCrea>13-07-2016</FecCrea></item></list></remarks>

    public class Empresa
    {
        #region Metodos Públicos

        /// <summary>Listado de Empresa</summary>
        /// <param name="int_pIdEmpresa">IdEmpresa</param>
        /// <param name="str_pEstado">Estado</param>
        /// <param name="int_pNumPagina" >Numero de pagina</param>
        /// <param name="int_pTamPagina" >Tamaño de pagina</param>
        /// <returns>Lista de Empresa</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por Kruma</CreadoPor></item>
        /// <item><FecCrea>13-07-2016</FecCrea></item></list></remarks>
        public static Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Empresa> Listar(
            int? int_pIdEmpresa,
            string str_pRUC,
            string str_pRUCFiltro,
            string str_pRazonSocial,
            string str_pNombreComercial,
            string str_pEstado,
            int? int_pNumPagina,
            int? int_pTamPagina)
        {
            Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Empresa> obj_Lista = new Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Empresa>();
            obj_Lista.PageNumber = int_pNumPagina;
            obj_Lista.Total = 0;

            DataOperation dop_Operacion = new DataOperation("ListarEmpresa");
            dop_Operacion.Parameters.Add(new Parameter("@pIdEmpresa", int_pIdEmpresa.HasValue ? int_pIdEmpresa.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pRUC", !string.IsNullOrEmpty(str_pRUC) ? str_pRUC : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pRUCFiltro", !string.IsNullOrEmpty(str_pRUCFiltro) ? str_pRUCFiltro : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pRazonSocial", !string.IsNullOrEmpty(str_pRazonSocial) ? str_pRazonSocial : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pNombreComercial", !string.IsNullOrEmpty(str_pNombreComercial) ? str_pNombreComercial : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pEstado", !string.IsNullOrEmpty(str_pEstado) ? str_pEstado : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pNumPagina", int_pNumPagina.HasValue ? int_pNumPagina.Value : (object)DBNull.Value));
            dop_Operacion.Parameters.Add(new Parameter("@pTamPagina", int_pTamPagina.HasValue ? int_pTamPagina.Value : (object)DBNull.Value));

            DataTable dt_Resultado = DataManager.ExecuteDataSet(Conexiones.CO_KantaPe, dop_Operacion).Tables[0];

            List<Kruma.KantaPe.Entidad.Empresa> lst_Empresa = new List<Kruma.KantaPe.Entidad.Empresa>();
            Kruma.KantaPe.Entidad.Empresa obj_Empresa = new Kruma.KantaPe.Entidad.Empresa();
            foreach (DataRow obj_Row in dt_Resultado.Rows)
            {
                if (lst_Empresa.Count == 0)
                    obj_Lista.Total = (int)obj_Row["Total_Filas"];

                obj_Empresa = new Kruma.KantaPe.Entidad.Empresa();
                //obj_Empresa.IdEmpresa = obj_Row["IdEmpresa"] is DBNull ? null : (int?)obj_Row["IdEmpresa"];
                obj_Empresa.Estado = obj_Row["Estado"] is DBNull ? null : obj_Row["Estado"].ToString();
                obj_Empresa.UsuarioCreacion = obj_Row["UsuarioCreacion"] is DBNull ? null : obj_Row["UsuarioCreacion"].ToString();
                obj_Empresa.FechaCreacion = obj_Row["FechaCreacion"] is DBNull ? null : (DateTime?)obj_Row["FechaCreacion"];
                obj_Empresa.UsuarioModificacion = obj_Row["UsuarioModificacion"] is DBNull ? null : obj_Row["UsuarioModificacion"].ToString();
                obj_Empresa.FechaModificacion = obj_Row["FechaModificacion"] is DBNull ? null : (DateTime?)obj_Row["FechaModificacion"];

                obj_Empresa.IdPersona = obj_Row["CorePersona_IdPersona"] is DBNull ? null : (int?)obj_Row["CorePersona_IdPersona"];
                obj_Empresa.IdTipoDocumento = obj_Row["CorePersona_IdTipoDocumento"] is DBNull ? null : (int?)obj_Row["CorePersona_IdTipoDocumento"];
                obj_Empresa.NumeroDocumento = obj_Row["CorePersona_NumeroDocumento"] is DBNull ? null : obj_Row["CorePersona_NumeroDocumento"].ToString();
                obj_Empresa.RazonSocial = obj_Row["CorePersona_RazonSocial"] is DBNull ? null : obj_Row["CorePersona_RazonSocial"].ToString();
                obj_Empresa.NombreComercial = obj_Row["CorePersona_NombreComercial"] is DBNull ? null : obj_Row["CorePersona_NombreComercial"].ToString();
                obj_Empresa.FechaNacimiento = obj_Row["CorePersona_FechaNacimiento"] is DBNull ? null : (DateTime?)obj_Row["CorePersona_FechaNacimiento"];

                obj_Empresa.TipoDocumento = new Core.Business.Entity.TipoDocumento();
                obj_Empresa.TipoDocumento.IdTipoDocumento = obj_Row["TipoDocumento_IdTipoDocumento"] is DBNull ? null : (int?)obj_Row["TipoDocumento_IdTipoDocumento"];
                obj_Empresa.TipoDocumento.Descripcion = obj_Row["TipoDocumento_Descripcion"] is DBNull ? null : obj_Row["TipoDocumento_Descripcion"].ToString();

                lst_Empresa.Add(obj_Empresa);
            }

            obj_Lista.Result = lst_Empresa;
            return obj_Lista;
        }

        /// <summary>Obtener Empresa</summary>
        /// <param name="int_pIdEmpresa">IdEmpresa</param>
        /// <returns>Objeto Empresa</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por Kruma</CreadoPor></item>
        /// <item><FecCrea>13-07-2016</FecCrea></item></list></remarks>
        public static Kruma.KantaPe.Entidad.Empresa Obtener(int int_pIdEmpresa)
        {
            Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Empresa> lst_Empresa = Listar(int_pIdEmpresa, null, null, null, null, null, null, null);
            return lst_Empresa.Result.Count > 0 ? lst_Empresa.Result[0] : null;
        }

        /// <summary>Insertar Empresa</summary>
        /// <param name="obj_pEmpresa">Empresa</param>
        /// <returns>Id de Empresa</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por Kruma</CreadoPor></item>
        /// <item><FecCrea>13-07-2016</FecCrea></item></list></remarks>
        public static void Insertar(Kruma.KantaPe.Entidad.Empresa obj_pEmpresa)
        {
            DataOperation dop_Operacion = new DataOperation("InsertarEmpresa");

            dop_Operacion.Parameters.Add(new Parameter("@pIdEmpresa", obj_pEmpresa.IdEmpresa));
            dop_Operacion.Parameters.Add(new Parameter("@pEstado", obj_pEmpresa.Estado));
            dop_Operacion.Parameters.Add(new Parameter("@pUsuarioCreacion", obj_pEmpresa.UsuarioCreacion));

            DataManager.ExecuteNonQuery(Conexiones.CO_KantaPe, dop_Operacion, false);
        }

        /// <summary>Modificar Empresa</summary>
        /// <param name="obj_pEmpresa">Empresa</param>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por Kruma</CreadoPor></item>
        /// <item><FecCrea>13-07-2016</FecCrea></item></list></remarks>
        public static void Modificar(Kruma.KantaPe.Entidad.Empresa obj_pEmpresa)
        {
            DataOperation dop_Operacion = new DataOperation("ActualizarEmpresa");

            dop_Operacion.Parameters.Add(new Parameter("@pIdEmpresa", obj_pEmpresa.IdEmpresa));
            dop_Operacion.Parameters.Add(new Parameter("@pEstado", obj_pEmpresa.Estado));
            dop_Operacion.Parameters.Add(new Parameter("@pUsuarioModificacion", obj_pEmpresa.UsuarioModificacion));

            DataManager.ExecuteNonQuery(Conexiones.CO_KantaPe, dop_Operacion, false);
        }

        #endregion
    }
}