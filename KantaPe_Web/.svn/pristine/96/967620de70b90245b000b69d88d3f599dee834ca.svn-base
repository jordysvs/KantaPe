using System;
using Kruma.KantaPe.Service.Interface;
using System.ServiceModel.Activation;
using Kruma.Core.Util.Common;
using Kruma.KantaPe.Entidad;
using Kruma.KantaPe.Service.Entity;

namespace Kruma.KantaPe.Service.Logical
{
    [AspNetCompatibilityRequirements(RequirementsMode = AspNetCompatibilityRequirementsMode.Allowed)]
    public class ProductoTipo : IProductoTipo
    {
        public ServiceResult<List<Entidad.ProductoTipo>> Listar()
        {
            Kruma.KantaPe.Service.Entity.ServiceResult<Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.ProductoTipo>> obj_Resultado = null;

            try
            {
                obj_Resultado = new Kruma.KantaPe.Service.Entity.ServiceResult<Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.ProductoTipo>>
                   (Kruma.KantaPe.Negocio.ProductoTipo.Listar(null, null, Kruma.KantaPe.Entidad.Constante.Estado_Activo, null, null));
            }

            catch (Exception obj_pExcepcion)
            {
                obj_Resultado = new Kruma.KantaPe.Service.Entity.ServiceResult<Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.ProductoTipo>>
                    (Kruma.Core.Configuration.ConfigurationManager.Default.ApplicationManager["MensajeError"].Value);

                Kruma.Core.Log.LogManager.Write("Exceptions", "Kruma.KantaPe.Service.Logical.ProductoTipo/Listar", obj_pExcepcion.Message);
            }

            return obj_Resultado;
        }
    }
}