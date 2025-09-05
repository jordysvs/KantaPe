using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Kruma.Core.Util.Common;
using System.Transactions;

namespace Kruma.KantaPe.Negocio
{
    /// <summary>Apertura</summary>
    /// <remarks><list type="bullet">
    /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
    /// <item><FecCrea>25-07-2016</FecCrea></item></list></remarks>

    public class Apertura
    {
        public static Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Apertura> lstReporteAperturaMesa;
        public static Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Apertura> lstReporteTiempoAtencion;

        #region Metodos Públicos

        /// <summary>Listado de Apertura</summary>
        /// <param name="int_pIdApertura">IdApertura</param>
        /// <param name="int_pIdCurso">IdCurso</param>
        /// <param name="dt_pFechaInicio">FechaInicio</param>
        /// <param name="dt_pFechaFin">FechaFin</param>
        /// <param name="str_pEstado">Estado</param>
        /// <param name="int_pIdLocal">IdLocal</param>
        /// <param name="int_pIdApertura">IdApertura</param>
        /// <param name="int_pIdMozo">IdMozo</param>
        /// <param name="dt_pFechaApertura">FechaApertura</param>
        /// <param name="dt_pFechaFinal">FechaFinal</param>
        /// <param name="dec_pTotal">Total</param>
        /// <param name="int_pIdAlerta">IdAlerta</param>
        /// <param name="str_pEstado">Estado</param>
        /// <param name="int_pNumPagina" >Numero de pagina</param>
        /// <param name="int_pTamPagina" >Tamaño de pagina</param>
        /// <returns>Lista de Apertura</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>25-07-2016</FecCrea></item></list></remarks>
        public static Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Apertura> Listar(
            int? int_pIdLocal,
            int? int_pIdApertura,
            int? int_pIdMozo,
            DateTime? dt_pFechaInicio,
            DateTime? dt_pFechaFinal,
            int? int_pIdAlerta,
            int? int_pIdUbicacion,
            bool? bln_pActual,
            string str_pEstado,
            int? int_pNumPagina,
            int? int_pTamPagina)
        {
            return Kruma.KantaPe.Data.Apertura.Listar(int_pIdLocal, int_pIdApertura, int_pIdMozo, dt_pFechaInicio, dt_pFechaFinal, int_pIdAlerta, int_pIdUbicacion, bln_pActual, str_pEstado, int_pNumPagina, int_pTamPagina);
        }

        /// <summary>Obtener Apertura</summary>
        /// <param name="int_pIdApertura">IdApertura</param>
        /// <param name="int_pIdLocal">IdLocal</param>
        /// <param name="int_pIdApertura">IdApertura</param>
        /// <returns>Objeto Apertura</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>25-07-2016</FecCrea></item></list></remarks>
        public static Kruma.KantaPe.Entidad.Apertura Obtener(int int_pIdLocal, int int_pIdApertura)
        {
            return Kruma.KantaPe.Data.Apertura.Obtener(int_pIdLocal, int_pIdApertura);
        }

        /// <summary>Obtener Apertura</summary>
        /// <param name="int_pIdApertura">IdApertura</param>
        /// <param name="int_pIdLocal">IdLocal</param>
        /// <param name="int_pIdApertura">IdApertura</param>
        /// <returns>Objeto Apertura</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>25-07-2016</FecCrea></item></list></remarks>
        public static Kruma.KantaPe.Entidad.Apertura ObtenerPorAlerta(int int_pIdLocal, int int_pIdAlerta)
        {
            return Kruma.KantaPe.Data.Apertura.ObtenerPorAlerta(int_pIdLocal, int_pIdAlerta);
        }


        /// <summary>Obtener Apertura</summary>
        /// <param name="int_pIdApertura">IdApertura</param>
        /// <param name="int_pIdLocal">IdLocal</param>
        /// <param name="int_pIdApertura">IdApertura</param>
        /// <returns>Objeto Apertura</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>25-07-2016</FecCrea></item></list></remarks>
        public static Kruma.KantaPe.Entidad.Apertura ObtenerActual(int int_pIdLocal, int int_pIdUbicacion)
        {
            return Kruma.KantaPe.Data.Apertura.ObtenerActual(int_pIdLocal, int_pIdUbicacion);
        }

        /// <summary>Aperturar</summary>
        /// <param name="int_pIdLocal">Id del local</param>
        /// <param name="int_pIdUbicacion">Id de la ubicación</param>
        /// <param name="int_pIdAlerta">Id de la alerta</param>
        /// <param name="str_pIdUsuario">Id del usuario</param>
        /// <returns>Id de Apertura</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>06-10-2016</FecCrea></item></list></remarks>
        public static ProcessResult Aperturar(
            int int_pIdLocal,
            int int_pIdUbicacion,
            int? int_pIdAlerta,
            string str_pIdUsuario
            )
        {
            ProcessResult obj_Resultado = null;
            try
            {
                using (TransactionScope obj_TransactionScope = new TransactionScope())
                {

                    string str_IdUsuarioAlerta = string.Empty;

                    //Atender la alerta 
                    if (int_pIdAlerta.HasValue)
                    {
                        Kruma.KantaPe.Entidad.Alerta obj_Alerta = Kruma.KantaPe.Data.Alerta.Obtener(int_pIdLocal, int_pIdUbicacion, int_pIdAlerta.Value);
                        if (obj_Alerta.Estado.Equals(KantaPe.Entidad.Constante.Estado_Cancelado))
                            return new ProcessResult(new Exception("La solicitud ya ha sido cancelada."));

                        //Obteniendo el ID del usuario de la alerta
                        str_IdUsuarioAlerta = obj_Alerta.IdUsuario;

                        obj_Alerta.FechaAtencion = DateTime.Now;
                        obj_Alerta.Estado = Kruma.KantaPe.Entidad.Constante.Estado_Activo;
                        Kruma.KantaPe.Negocio.Alerta.Modificar(obj_Alerta);

                        System.Collections.Generic.List<KantaPe.Entidad.Alerta> lstAlertasAEliminar = KantaPe.Data.Alerta.Listar(int_pIdLocal, int_pIdUbicacion, null, KantaPe.Entidad.Constante.AlertaTipo_Apertura, null, null, null, KantaPe.Entidad.Constante.Estado_Pendiente, null, null).Result;
                        foreach (KantaPe.Entidad.Alerta obj_AlertaAEliminar in lstAlertasAEliminar)
                        {
                            obj_AlertaAEliminar.Estado = KantaPe.Entidad.Constante.Estado_Rechazado;
                            obj_AlertaAEliminar.FechaAtencion = DateTime.Now;
                            obj_AlertaAEliminar.UsuarioModificacion = Kruma.Core.Security.SecurityManager.Usuario.IdUsuario;
                            Kruma.KantaPe.Negocio.Alerta.Modificar(obj_AlertaAEliminar);
                        }
                    }

                    int? int_IdEmpleado = KantaPe.Data.Empleado.Obtener(null, Kruma.Core.Security.SecurityManager.Usuario.IdPersona).IdEmpleado;

                    //Inserta la apertura
                    Kruma.KantaPe.Entidad.Apertura obj_Apertura = new Entidad.Apertura();
                    obj_Apertura.IdLocal = int_pIdLocal;
                    //obj_Apertura.IdMozo = int.Parse(str_pIdUsuario);
                    obj_Apertura.IdMozo = int_IdEmpleado;
                    obj_Apertura.FechaApertura = DateTime.Now;
                    obj_Apertura.Total = 0;
                    obj_Apertura.IdAlerta = int_pIdAlerta;
                    obj_Apertura.Estado = Kruma.KantaPe.Entidad.Constante.Estado_Activo;
                    obj_Apertura.UsuarioCreacion = str_pIdUsuario;
                    obj_Apertura.IdApertura = Kruma.KantaPe.Data.Apertura.Insertar(obj_Apertura);

                    //insertar usuario
                    Kruma.KantaPe.Entidad.AperturaUsuario obj_AperturaUsuario = new Entidad.AperturaUsuario();
                    obj_AperturaUsuario.IdLocal = int_pIdLocal;
                    obj_AperturaUsuario.IdApertura = obj_Apertura.IdApertura;
                    obj_AperturaUsuario.IdUsuario = !string.IsNullOrEmpty(str_IdUsuarioAlerta) ? str_IdUsuarioAlerta : str_pIdUsuario;
                    obj_AperturaUsuario.Administrador = Kruma.KantaPe.Entidad.Constante.Condicion_Positivo;
                    obj_AperturaUsuario.FechaIngreso = DateTime.Now;
                    obj_AperturaUsuario.Estado = Kruma.KantaPe.Entidad.Constante.Estado_Activo;
                    obj_AperturaUsuario.UsuarioCreacion = str_pIdUsuario;
                    Kruma.KantaPe.Data.AperturaUsuario.Insertar(obj_AperturaUsuario);

                    //insertar ubicacion
                    Kruma.KantaPe.Entidad.AperturaUbicacion obj_AperturaUbicacion = new Entidad.AperturaUbicacion();
                    obj_AperturaUbicacion.IdLocal = int_pIdLocal;
                    obj_AperturaUbicacion.IdApertura = obj_Apertura.IdApertura;
                    obj_AperturaUbicacion.IdUbicacion = int_pIdUbicacion;
                    obj_AperturaUbicacion.Estado = Kruma.KantaPe.Entidad.Constante.Estado_Activo;
                    obj_AperturaUbicacion.UsuarioCreacion = str_pIdUsuario;
                    Kruma.KantaPe.Data.AperturaUbicacion.Insertar(obj_AperturaUbicacion);

                    obj_Resultado = new ProcessResult(obj_Apertura.IdApertura);
                    obj_TransactionScope.Complete();
                }
            }
            catch (Exception obj_pExcepcion)
            {
                obj_Resultado = new ProcessResult(obj_pExcepcion);
            }
            return obj_Resultado;
        }

        /// <summary>Insertar Apertura</summary>
        /// <param name="obj_pApertura">Apertura</param>
        /// <returns>Id de Apertura</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>25-07-2016</FecCrea></item></list></remarks>
        public static ProcessResult Insertar(Kruma.KantaPe.Entidad.Apertura obj_pApertura)
        {
            ProcessResult obj_Resultado = null;
            try
            {
                int int_IdApertura = Kruma.KantaPe.Data.Apertura.Insertar(obj_pApertura);
                obj_Resultado = new ProcessResult(int_IdApertura);
            }
            catch (Exception obj_pExcepcion)
            {
                obj_Resultado = new ProcessResult(obj_pExcepcion);
            }
            return obj_Resultado;
        }

        /// <summary>Modificar Apertura</summary>
        /// <param name="obj_pApertura">Apertura</param>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>25-07-2016</FecCrea></item></list></remarks>
        public static ProcessResult Modificar(Kruma.KantaPe.Entidad.Apertura obj_pApertura)
        {
            ProcessResult obj_Resultado = null;
            try
            {
                Kruma.KantaPe.Data.Apertura.Modificar(obj_pApertura);
                obj_Resultado = new ProcessResult(obj_pApertura.IdApertura);
            }
            catch (Exception obj_pExcepcion)
            {
                obj_Resultado = new ProcessResult(obj_pExcepcion);
            }
            return obj_Resultado;
        }

        /// <summary>Cerrar Apertura</summary>
        /// <param name="obj_pApertura">Apertura</param>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>25-07-2016</FecCrea></item></list></remarks>
        public static ProcessResult Cerrar(Kruma.KantaPe.Entidad.Apertura obj_Apertura)
        {
            ProcessResult obj_Resultado = null;
            try
            {
                Kruma.KantaPe.Entidad.Apertura obj_AperturaAModificar = Kruma.KantaPe.Data.Apertura.Obtener(obj_Apertura.IdLocal.Value, obj_Apertura.IdApertura.Value);
                obj_AperturaAModificar.FechaFinal = DateTime.Now;
                obj_AperturaAModificar.UsuarioModificacion = obj_Apertura.UsuarioModificacion;
                Kruma.KantaPe.Data.Apertura.Modificar(obj_AperturaAModificar);
                obj_Resultado = new ProcessResult(obj_Apertura.IdApertura);
            }
            catch (Exception obj_pExcepcion)
            {
                obj_Resultado = new ProcessResult(obj_pExcepcion);
            }
            return obj_Resultado;
        }
        
        /// <summary>Listado del dashboard de apertura</summary>
        /// <param name="int_pIdLocal">Id del local</param>
        /// <param name="int_pIdApertura">Id de la apertura</param>
        /// <param name="int_pIdMozo">Id del mozo</param>
        /// <param name="int_pIdUbicacionTipo">Id del tipo de ubicacion</param>
        /// <param name="int_pNumPagina" >Numero de pagina</param>
        /// <param name="int_pTamPagina" >Tamaño de pagina</param>
        /// <returns>Lista de Apertura</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>25-07-2016</FecCrea></item></list></remarks>
        public static Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Ubicacion> ListarDashBoard(
            int? int_pIdLocal,
            int? int_pIdApertura,
            int? int_pIdMozo,
            int? int_pIdUbicacionTipo,
            int? int_pNumPagina,
            int? int_pTamPagina)
        {
            return Kruma.KantaPe.Data.Apertura.ListarDashBoard(int_pIdLocal, int_pIdApertura, int_pIdMozo, int_pIdUbicacionTipo, int_pNumPagina, int_pTamPagina);
        }

        /// <summary>REPORTE APERTURA MESA</summary>
        /// <param name="int_pNumPagina" >Numero de pagina</param>
        /// <param name="int_pTamPagina" >Tamaño de pagina</param>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Vicente Gonzales Osorio</CreadoPor></item>
        /// <item><FecCrea>09-03-2017</FecCrea></item></list></remarks>

        public static Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Apertura> ReporteAperturaMesa(
            string str_pNombreCompleto,
            int? int_pIdEmpresa,
            int? int_pIdLocal,
            DateTime? dt_pFechaInicio,
            DateTime? dt_pFechaFin,
            int? int_pIdUbicacionTipo,
            int? int_pNroUbicacion,
            int? int_pNumPagina,
            int? int_pTamPagina)
        {
            lstReporteAperturaMesa = Kruma.KantaPe.Data.Apertura.ReporteAperturaMesa(str_pNombreCompleto, int_pIdEmpresa, int_pIdLocal, dt_pFechaInicio, dt_pFechaFin, int_pIdUbicacionTipo, int_pNroUbicacion, int_pNumPagina, int_pTamPagina);
            return lstReporteAperturaMesa;
        }


        /// <summary>REPORTE TIEMPO DE ATENCION</summary>
        /// <param name="int_pNumPagina" >Numero de pagina</param>
        /// <param name="int_pTamPagina" >Tamaño de pagina</param>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Vicente Gonzales Osorio</CreadoPor></item>
        /// <item><FecCrea>09-03-2017</FecCrea></item></list></remarks>

        public static Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Apertura> ReporteTiempoAtencion(
            string str_pNombreCompleto,
            int? int_pIdEmpresa,
            int? int_pIdLocal,
            DateTime? dt_pFechaInicio,
            DateTime? dt_pFechaFin,
            int? int_pIdUbicacionTipo,
            int? int_pNroUbicacion,
            int? int_pNumPagina,
            int? int_pTamPagina)
        {
            lstReporteTiempoAtencion = Kruma.KantaPe.Data.Apertura.ReporteTiempoAtencion(str_pNombreCompleto, int_pIdEmpresa, int_pIdLocal, dt_pFechaInicio, dt_pFechaFin, int_pIdUbicacionTipo, int_pNroUbicacion, int_pNumPagina, int_pTamPagina);
            return lstReporteTiempoAtencion;
        }
        /// <summary>LISTAR TOP 5 PARA REPORTE</summary>
        /// <param name="int_pNumPagina" >Numero de pagina</param>
        /// <param name="int_pTamPagina" >Tamaño de pagina</param>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Vicente Gonzales Osorio</CreadoPor></item>
        /// <item><FecCrea>09-03-2017</FecCrea></item></list></remarks>

        public static Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Apertura> ListarAperturaMesaTop(
            string str_pNombreCompleto,
            int? int_pIdEmpresa,
            int? int_pIdLocal,
            DateTime? dt_pFechaInicio,
            DateTime? dt_pFechaFin,
            int? int_pIdUbicacionTipo,
            int? int_pNroUbicacion)
        {
            return Kruma.KantaPe.Data.Apertura.ListarAperturaMesaTop(str_pNombreCompleto, int_pIdEmpresa, int_pIdLocal, dt_pFechaInicio, dt_pFechaFin, int_pIdUbicacionTipo, int_pNroUbicacion);
        }
        /// <summary>REPORTE APERTURA MESA MOZO TOP</summary>
        /// <param name="int_pNumPagina" >Numero de pagina</param>
        /// <param name="int_pTamPagina" >Tamaño de pagina</param>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Vicente Gonzales Osorio</CreadoPor></item>
        /// <item><FecCrea>09-03-2017</FecCrea></item></list></remarks>
        public static Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Apertura> ListarAperturaMesaMozoTop(
            string str_pNombreCompleto,
            int? int_pIdEmpresa,
            int? int_pIdLocal,
            DateTime? dt_pFechaInicio,
            DateTime? dt_pFechaFin)
        {
            return Kruma.KantaPe.Data.Apertura.ListarAperturaMesaMozoTop(str_pNombreCompleto, int_pIdEmpresa, int_pIdLocal, dt_pFechaInicio, dt_pFechaFin); ;
        }
        /// <summary>Listado de Apertura</summary>
        /// <param name="int_pIdApertura">IdApertura</param>
        /// <param name="int_pIdUbicacionTipo">IdUbicacionTipo</param>
        /// <param name="int_pNumPagina" >Numero de pagina</param>
        /// <param name="int_pTamPagina" >Tamaño de pagina</param>
        /// <returns>Lista de Apertura</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
        /// <item><FecCrea>25-07-2016</FecCrea></item></list></remarks>
        public static Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Apertura> ListarAperturaTurno(
            int? int_pIdLocal,
            //int? int_pCantidadCanciones,
            int? int_pNumPagina,
            int? int_pTamPagina)
        {
            return KantaPe.Data.Apertura.ListarAperturaTurno(int_pIdLocal, int_pNumPagina, int_pTamPagina);
        }

        /// <summary>REPORTE TIEMPO ATENCION - MOZOS MAS RAPIDOS Y LENTOS</summary>
        /// <param name="int_pNumPagina" >Numero de pagina</param>
        /// <param name="int_pTamPagina" >Tamaño de pagina</param>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Vicente Gonzales Osorio</CreadoPor></item>
        /// <item><FecCrea>09-03-2017</FecCrea></item></list></remarks>
        public static Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Apertura> ListarTiempoAtencionMozoTop(
                string str_pNombreCompleto,
                int? int_pIdEmpresa,
                int? int_pIdLocal,
                DateTime? dt_pFechaInicio,
                DateTime? dt_pFechaFin)
        {
            return Kruma.KantaPe.Data.Apertura.ListarTiempoAtencionMozoTop(str_pNombreCompleto, int_pIdEmpresa, int_pIdLocal, dt_pFechaInicio, dt_pFechaFin); ;
        }

        /// <summary>LISTAR MESAS PARA INDICADORES</summary>
        /// <param name="int_pNumPagina" >Numero de pagina</param>
        /// <param name="int_pTamPagina" >Tamaño de pagina</param>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Vicente Gonzales Osorio</CreadoPor></item>
        /// <item><FecCrea>09-03-2017</FecCrea></item></list></remarks>
        public static Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Apertura> ListarAperturaMesaInicio(
                int? int_pIdUbicacionTipo,
                int? int_pIdLocal)
        {
            return Kruma.KantaPe.Data.Apertura.ListarAperturaMesaInicio(int_pIdUbicacionTipo, int_pIdLocal); ;
        }

        /// <summary>LISTAR MESAS  CERRADO PARA INDICADORES</summary>
        /// <param name="int_pNumPagina" >Numero de pagina</param>
        /// <param name="int_pTamPagina" >Tamaño de pagina</param>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Vicente Gonzales Osorio</CreadoPor></item>
        /// <item><FecCrea>09-03-2017</FecCrea></item></list></remarks>
        public static Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Apertura> ListarAperturaMesaCerradoInicio(
                int? int_pIdUbicacionTipo,
                int? int_pIdLocal)
        {
            return Kruma.KantaPe.Data.Apertura.ListarAperturaMesaCerradoInicio(int_pIdUbicacionTipo, int_pIdLocal); ;
        }
    }

    #endregion
}