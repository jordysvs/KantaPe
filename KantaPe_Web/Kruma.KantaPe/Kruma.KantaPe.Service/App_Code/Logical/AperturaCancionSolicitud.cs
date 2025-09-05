using System;
using Kruma.KantaPe.Service.Interface;
using System.ServiceModel.Activation;
using Kruma.Core.Util.Common;
using Kruma.KantaPe.Entidad;
using Kruma.KantaPe.Service.Entity;

namespace Kruma.KantaPe.Service.Logical
{
    [AspNetCompatibilityRequirements(RequirementsMode = AspNetCompatibilityRequirementsMode.Allowed)]
    public class AperturaCancionSolicitud : IAperturaCancionSolicitud
    {
        public ServiceResult<List<Entidad.AperturaCancionSolicitud>> Listar()
        {
            Kruma.KantaPe.Service.Entity.ServiceResult<Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.AperturaCancionSolicitud>> obj_Resultado = null;

            try
            {
                obj_Resultado = new Kruma.KantaPe.Service.Entity.ServiceResult<Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.AperturaCancionSolicitud>>
                   (Kruma.KantaPe.Negocio.AperturaCancionSolicitud.Listar(null, Kruma.KantaPe.Entidad.Constante.Estado_Activo, null, null));
            }

            catch (Exception obj_pExcepcion)
            {
                obj_Resultado = new Kruma.KantaPe.Service.Entity.ServiceResult<Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.AperturaCancionSolicitud>>
                    (Kruma.Core.Configuration.ConfigurationManager.Default.ApplicationManager["MensajeError"].Value);

                Kruma.Core.Log.LogManager.Write("Exceptions", "Kruma.KantaPe.Service.Logical.AperturaCancionSolicitud/Listar", obj_pExcepcion.Message);
            }

            return obj_Resultado;
        }
    }
}