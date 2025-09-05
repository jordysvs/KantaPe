using System;
using Kruma.KantaPe.Service.Interface;
using System.ServiceModel.Activation;
using Kruma.Core.Util.Common;
using Kruma.KantaPe.Entidad;
using Kruma.KantaPe.Service.Entity;

namespace Kruma.KantaPe.Service.Logical
{
    [AspNetCompatibilityRequirements(RequirementsMode = AspNetCompatibilityRequirementsMode.Allowed)]
    public class Producto : IProducto
    {
        public Kruma.KantaPe.Service.Entity.ServiceResult<Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Producto>> Listar(
            string IdEmpresa,
            string IdLocal,
            string IdProducto,
            string Nombre,
            string IdProductoTipo,
            string NumPagina,
            string TamPagina)
        {

            Kruma.KantaPe.Service.Entity.ServiceResult<
                Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Producto>> obj_Resultado = null;

            int? int_IdEmpresa = IdEmpresa == Constante.NULLTYPE ? null : (int?)int.Parse(IdEmpresa);
            int? int_IdLocal = IdLocal == Constante.NULLTYPE ? null : (int?)int.Parse(IdLocal);
            int? int_IdProducto = IdProducto == Constante.NULLTYPE ? null : (int?)int.Parse(IdProducto);
            string str_Nombre = Nombre == Constante.NULLTYPE ? null : Nombre;
            int? int_IdProductoTipo = IdProductoTipo == Constante.NULLTYPE ? null : (int?)int.Parse(IdProductoTipo);
            int? int_NumPagina = NumPagina == Constante.NULLTYPE ? null : (int?)int.Parse(NumPagina);
            int? int_TamPagina = TamPagina == Constante.NULLTYPE ? null : (int?)int.Parse(TamPagina);

            try
            {
                obj_Resultado = new Entity.ServiceResult<Core.Util.Common.List<Entidad.Producto>>
                    (Kruma.KantaPe.Negocio.Producto.Listar(
                        int_IdEmpresa,
                        int_IdLocal,
                        int_IdProducto,
                        str_Nombre,
                        int_IdProductoTipo,
                        Kruma.KantaPe.Entidad.Constante.Estado_Activo,
                        int_NumPagina,
                        int_TamPagina)
                        );
            }
            catch (Exception obj_pExcepcion)
            {
                obj_Resultado = new Kruma.KantaPe.Service.Entity.ServiceResult<Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Producto>>
                    (Kruma.Core.Configuration.ConfigurationManager.Default.ApplicationManager["MensajeError"].Value);
                Kruma.Core.Log.LogManager.Write("Exceptions", "Kruma.KantaPe.Service.Logical.Producto/Listar", obj_pExcepcion.Message);
            }

            return obj_Resultado;
        }

    

        public Entity.ServiceResult<Core.Util.Common.ProcessResult> SolicitarPedido(KantaPe.Entidad.Alerta Alerta)
        {
            Kruma.KantaPe.Service.Entity.ServiceResult<Kruma.Core.Util.Common.ProcessResult> obj_Resultado = null;
            try
            {
                //Alerta tipo apertura
                int int_IdAlertaTipo_Producto = int.Parse(Kruma.Core.Business.Logical.Parametro.Obtener(
                    Kruma.KantaPe.Entidad.Constante.Parametro.Modulo,
                    Kruma.KantaPe.Entidad.Constante.Parametro.AlertaTipo_Producto).Valor);

                Alerta.IdAlertaTipo = int_IdAlertaTipo_Producto;
                Alerta.UsuarioCreacion = Alerta.IdUsuario;

                obj_Resultado = new Kruma.KantaPe.Service.Entity.ServiceResult<
                    Kruma.Core.Util.Common.ProcessResult>
                    (Kruma.KantaPe.Negocio.Producto.SolicitarPedido(Alerta));
            }
            catch (Exception obj_pExcepcion)
            {
                obj_Resultado = new Kruma.KantaPe.Service.Entity.ServiceResult<Kruma.Core.Util.Common.ProcessResult>
                    (Kruma.Core.Configuration.ConfigurationManager.Default.ApplicationManager["MensajeError"].Value);
                Kruma.Core.Log.LogManager.Write("Exceptions", "Kruma.KantaPe.Service.Logical.Producto/SolicitarPedido", obj_pExcepcion.Message);
            }
            return obj_Resultado;
        }



    }

    
}