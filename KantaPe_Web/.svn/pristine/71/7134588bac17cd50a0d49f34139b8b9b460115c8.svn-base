using System;
using Kruma.KantaPe.Service.Interface;
using System.ServiceModel.Activation;
using Kruma.Core.Util.Common;
using Kruma.KantaPe.Entidad;
using Kruma.KantaPe.Service.Entity;

namespace Kruma.KantaPe.Service.Logical
{
    [AspNetCompatibilityRequirements(RequirementsMode = AspNetCompatibilityRequirementsMode.Allowed)]
    public class Evento : IEvento
    {
        public Entity.ServiceResult<Kruma.Core.Util.Common.List<Entidad.Evento>> Listar()
        {
            Kruma.KantaPe.Service.Entity.ServiceResult<Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Evento>> obj_Resultado = null;

            try
            {
                obj_Resultado = new Kruma.KantaPe.Service.Entity.ServiceResult<Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Evento>>
                   (Kruma.KantaPe.Negocio.Evento.Listar(null, 1, null, null, null, null, null, null, null, null));
            }

            catch (Exception obj_pExcepcion)
            {
                obj_Resultado = new Kruma.KantaPe.Service.Entity.ServiceResult<Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Evento>>
                    (Kruma.Core.Configuration.ConfigurationManager.Default.ApplicationManager["MensajeError"].Value);

                Kruma.Core.Log.LogManager.Write("Exceptions", "Kruma.KantaPe.Service.Logical.Evento/Listar", obj_pExcepcion.Message);
            }

            return obj_Resultado;
        }

        public Entity.ServiceResult<Kruma.Core.Util.Common.List<Entidad.Evento>> ListarEventoPorLocal(string IdLocal)
        {
            Kruma.KantaPe.Service.Entity.ServiceResult<Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Evento>> obj_Resultado = null;

            int? int_IdLocal = IdLocal == Constante.NULLTYPE ? null : (int?)int.Parse(IdLocal);

            try
            {
                obj_Resultado = new Kruma.KantaPe.Service.Entity.ServiceResult<Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Evento>>
                   (Kruma.KantaPe.Negocio.Evento.Listar(null, int_IdLocal, null, null, null, null, null, null, null, null));
            }

            catch (Exception obj_pExcepcion)
            {
                obj_Resultado = new Kruma.KantaPe.Service.Entity.ServiceResult<Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Evento>>
                    (Kruma.Core.Configuration.ConfigurationManager.Default.ApplicationManager["MensajeError"].Value);

                Kruma.Core.Log.LogManager.Write("Exceptions", "Kruma.KantaPe.Service.Logical.Evento/Listar", obj_pExcepcion.Message);
            }

            return obj_Resultado;
        }
    }
}