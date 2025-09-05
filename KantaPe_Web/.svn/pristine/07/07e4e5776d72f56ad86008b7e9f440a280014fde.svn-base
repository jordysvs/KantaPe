using System;
using Kruma.Core.Util.Common;
using System.Transactions;

namespace Kruma.KantaPe.Negocio
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
            return Kruma.KantaPe.Data.Empresa.Listar(
                int_pIdEmpresa,
                str_pRUC,
                str_pRUCFiltro,
                str_pRazonSocial,
                str_pNombreComercial,
                str_pEstado,
                int_pNumPagina,
                int_pTamPagina);
        }

        /// <summary>Obtener Empresa</summary>
        /// <param name="int_pIdEmpresa">IdEmpresa</param>
        /// <returns>Objeto Empresa</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por Kruma</CreadoPor></item>
        /// <item><FecCrea>13-07-2016</FecCrea></item></list></remarks>
        public static Kruma.KantaPe.Entidad.Empresa Obtener(int int_pIdEmpresa)
        {
            return Kruma.KantaPe.Data.Empresa.Obtener(int_pIdEmpresa);
        }

        /// <summary>Insertar Empresa</summary>
        /// <param name="obj_pEmpresa">Empresa</param>
        /// <returns>Id de Empresa</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por Kruma</CreadoPor></item>
        /// <item><FecCrea>13-07-2016</FecCrea></item></list></remarks>
        public static ProcessResult Insertar(Kruma.KantaPe.Entidad.Empresa obj_pEmpresa)
        {
            ProcessResult obj_Resultado = null;
            try
            {
                using (TransactionScope obj_TransactionScope = new TransactionScope())
                {
                    //Datos de la empresa
                    obj_pEmpresa.IdTipoDocumento = int.Parse(Kruma.Core.Business.Logical.Parametro.Obtener(
                        Kruma.Core.Business.Entity.Constante.Parametro.Modulo,
                        Kruma.Core.Business.Entity.Constante.Parametro.TipoDocumento_Ruc).Valor);

                    //Insertar persona
                    obj_Resultado = Kruma.Core.Business.Logical.Persona.Insertar(obj_pEmpresa);
                    if (obj_Resultado.OperationResult == Core.Util.Common.Enum.OperationResult.Success)
                    {
                        //Insertar empresa
                        obj_pEmpresa.IdEmpresa = (int)obj_Resultado.ReturnId;
                        Kruma.KantaPe.Data.Empresa.Insertar(obj_pEmpresa);
                        obj_Resultado = new ProcessResult(obj_pEmpresa.IdEmpresa);

                        obj_TransactionScope.Complete();
                    }
                }
            }
            catch (Exception obj_pExcepcion)
            {
                obj_Resultado = new ProcessResult(obj_pExcepcion);
            }
            return obj_Resultado;
        }

        /// <summary>Modificar Empresa</summary>
        /// <param name="obj_pEmpresa">Empresa</param>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por Kruma</CreadoPor></item>
        /// <item><FecCrea>13-07-2016</FecCrea></item></list></remarks>
        public static ProcessResult Modificar(Kruma.KantaPe.Entidad.Empresa obj_pEmpresa)
        {
            ProcessResult obj_Resultado = null;
            try
            {
                using (TransactionScope obj_TransactionScope = new TransactionScope())
                {
                    Kruma.KantaPe.Entidad.Empresa obj_EmpresaAModificar = Obtener(obj_pEmpresa.IdEmpresa.Value);
                    obj_EmpresaAModificar.NumeroDocumento = obj_pEmpresa.NumeroDocumento;
                    obj_EmpresaAModificar.RazonSocial = obj_pEmpresa.RazonSocial;
                    obj_EmpresaAModificar.NombreComercial = obj_pEmpresa.NombreComercial;
                    obj_EmpresaAModificar.FechaNacimiento = obj_pEmpresa.FechaNacimiento;
                    obj_EmpresaAModificar.Estado = obj_pEmpresa.Estado;
                    obj_EmpresaAModificar.UsuarioModificacion = obj_pEmpresa.UsuarioModificacion;

                    //Modificar persona
                    obj_Resultado = Kruma.Core.Business.Logical.Persona.Modificar(obj_EmpresaAModificar);

                    if (obj_Resultado.OperationResult == Core.Util.Common.Enum.OperationResult.Success)
                    {
                        //Modificar empresa
                        Kruma.KantaPe.Data.Empresa.Modificar(obj_EmpresaAModificar);
                        obj_Resultado = new ProcessResult(obj_EmpresaAModificar.IdEmpresa);

                        //Transaccion completa
                        obj_TransactionScope.Complete();
                    }
                }
            }
            catch (Exception obj_pExcepcion)
            {
                obj_Resultado = new ProcessResult(obj_pExcepcion);
            }
            return obj_Resultado;
        }

        /// <summary>Modificar Estado Empresa</summary>
        /// <param name="obj_pEmpresa">Empresa</param>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por Kruma</CreadoPor></item>
        /// <item><FecCrea>13-07-2016</FecCrea></item></list></remarks>
        public static Kruma.Core.Util.Common.ProcessResult ModificarEstado(
            Kruma.KantaPe.Entidad.Empresa obj_pEmpresa)
        {
            Kruma.Core.Util.Common.ProcessResult obj_Resultado = null;
            try
            {
                Kruma.KantaPe.Entidad.Empresa obj_Empresa = Kruma.KantaPe.Data.Empresa.Obtener(obj_pEmpresa.IdEmpresa.Value);
                if (obj_Empresa.Estado == obj_pEmpresa.Estado)
                {
                    string str_Mensaje = obj_pEmpresa.Estado ==
                        Kruma.KantaPe.Entidad.Constante.Estado_Activo ?
                        "La empresa ya se encuentra activa." :
                        "La empresa ya se encuentra inactiva.";
                    return new Kruma.Core.Util.Common.ProcessResult(new Exception(str_Mensaje), str_Mensaje);
                }
                obj_Empresa.Estado = obj_pEmpresa.Estado;
                obj_Empresa.UsuarioModificacion = obj_pEmpresa.UsuarioModificacion;
                Kruma.KantaPe.Data.Empresa.Modificar(obj_Empresa);

                obj_Resultado = new Kruma.Core.Util.Common.ProcessResult(obj_pEmpresa.IdEmpresa);
            }
            catch (Exception obj_pExcepcion)
            {
                obj_Resultado = new Kruma.Core.Util.Common.ProcessResult(obj_pExcepcion);
            }

            return obj_Resultado;
        }

        #endregion
    }
}