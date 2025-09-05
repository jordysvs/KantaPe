using System;
using Kruma.KantaPe.Service.Interface;
using System.ServiceModel.Activation;
using Kruma.Core.Util.Common;
using Kruma.KantaPe.Entidad;
using Kruma.KantaPe.Service.Entity;

namespace Kruma.KantaPe.Service.Logical
{
    [AspNetCompatibilityRequirements(RequirementsMode = AspNetCompatibilityRequirementsMode.Allowed)]
    public class Idioma : IIdioma
    {
        public Kruma.KantaPe.Service.Entity.ServiceResult<Kruma.Core.Util.Common.List<Entidad.Idioma>> Listar()
        {
            Kruma.KantaPe.Service.Entity.ServiceResult<Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Idioma>> obj_Resultado = null;

            try
            {
                obj_Resultado = new Kruma.KantaPe.Service.Entity.ServiceResult<Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Idioma>>
                   (Kruma.KantaPe.Negocio.Idioma.Listar(null, Kruma.KantaPe.Entidad.Constante.Estado_Activo, null, null));
            }

            catch (Exception obj_pExcepcion)
            {
                obj_Resultado = new Kruma.KantaPe.Service.Entity.ServiceResult<Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Idioma>>
                    (Kruma.Core.Configuration.ConfigurationManager.Default.ApplicationManager["MensajeError"].Value);

                Kruma.Core.Log.LogManager.Write("Exceptions", "Kruma.KantaPe.Service.Logical.Idioma/Listar", obj_pExcepcion.Message);
            }

            return obj_Resultado;
        }

        public Kruma.KantaPe.Service.Entity.ServiceResult<Kruma.Core.Util.Common.List<Entidad.Idioma>> ListarIdiomaPorLocal(string IdLocal)
        {
            Kruma.KantaPe.Service.Entity.ServiceResult<Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Idioma>> obj_Resultado = null;

            int? int_IdLocal = IdLocal == Constante.NULLTYPE ? null : (int?)int.Parse(IdLocal);
            try
            {
                obj_Resultado = new Kruma.KantaPe.Service.Entity.ServiceResult<Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Idioma>>
                   (Kruma.KantaPe.Negocio.Idioma.ListarIdiomaPorLocal(int_IdLocal));
            }

            catch (Exception obj_pExcepcion)
            {
                obj_Resultado = new Kruma.KantaPe.Service.Entity.ServiceResult<Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Idioma>>
                    (Kruma.Core.Configuration.ConfigurationManager.Default.ApplicationManager["MensajeError"].Value);

                Kruma.Core.Log.LogManager.Write("Exceptions", "Kruma.KantaPe.Service.Logical.Idioma/ListarIdiomaPorLocal", obj_pExcepcion.Message);
            }

            return obj_Resultado;
        }
    }
}