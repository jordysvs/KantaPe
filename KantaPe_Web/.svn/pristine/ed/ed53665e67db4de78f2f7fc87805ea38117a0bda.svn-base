using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.ServiceModel.Web;
using System.Text;
using Kruma.KantaPe.Service.Interface;
using System.ServiceModel.Activation;
using Kruma.Core.Util.Common;
using Kruma.KantaPe.Entidad;
using Kruma.KantaPe.Service.Entity;

namespace Kruma.KantaPe.Service.Logical
{
    [AspNetCompatibilityRequirements(RequirementsMode = AspNetCompatibilityRequirementsMode.Allowed)]
    public class SolicitudCancion : ISolicitudCancion
    {
        public Entity.ServiceResult<Kruma.Core.Util.Common.ProcessResult> Insertar(Kruma.KantaPe.Entidad.SolicitudCancion SolicitudCancion)
        {
            Kruma.KantaPe.Service.Entity.ServiceResult<Kruma.Core.Util.Common.ProcessResult> obj_Resultado = null;
            try
            {
                obj_Resultado = new Kruma.KantaPe.Service.Entity.ServiceResult<Kruma.Core.Util.Common.ProcessResult>
                    (Kruma.KantaPe.Negocio.SolicitudCancion.Insertar(SolicitudCancion));
            }
            catch (Exception obj_pExcepcion)
            {
                obj_Resultado = new Kruma.KantaPe.Service.Entity.ServiceResult<Kruma.Core.Util.Common.ProcessResult>
                    (Kruma.Core.Configuration.ConfigurationManager.Default.ApplicationManager["MensajeError"].Value);
                Kruma.Core.Log.LogManager.Write("Exceptions", "Kruma.KantaPe.Service.Logical.SolicitudCancion/Insertar", obj_pExcepcion.Message);
            }
            return obj_Resultado;
        }

       
    }
}