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
using Kruma.KantaPe.Service.Entity;
using Kruma.KantaPe.Entidad;

namespace Kruma.KantaPe.Service.Logical
{
    [AspNetCompatibilityRequirements(RequirementsMode = AspNetCompatibilityRequirementsMode.Allowed)]
    public class Ubicacion : IUbicacion
    {

        public ServiceResult<Entidad.Ubicacion> Obtener(string IdLocal, string IdUbicacion)
        {
            Kruma.KantaPe.Service.Entity.ServiceResult<Kruma.KantaPe.Entidad.Ubicacion> obj_Resultado = null;
            try
            {
                int int_IdLocal = int.Parse(IdLocal);
                int int_IdUbicacion = int.Parse(IdUbicacion);
                obj_Resultado = new Kruma.KantaPe.Service.Entity.ServiceResult<Kruma.KantaPe.Entidad.Ubicacion>
                    (Kruma.KantaPe.Negocio.Ubicacion.Obtener(int_IdLocal, int_IdUbicacion));
            }
            catch (Exception obj_pExcepcion)
            {
                obj_Resultado = new Kruma.KantaPe.Service.Entity.ServiceResult<Kruma.KantaPe.Entidad.Ubicacion>
                    (Kruma.Core.Configuration.ConfigurationManager.Default.ApplicationManager["MensajeError"].Value);
                Kruma.Core.Log.LogManager.Write("Exceptions", "Kruma.KantaPe.Service.Logical.Ubicacion/Obtener", obj_pExcepcion.Message);
            }
            return obj_Resultado;
        }

        public ServiceResult<Entidad.Ubicacion> ObtenerQR(string QR)
        {
            Kruma.KantaPe.Service.Entity.ServiceResult<Kruma.KantaPe.Entidad.Ubicacion> obj_Resultado = null;
            try
            {
                string str_CadenaQR = new Kruma.Core.Criptography.CriptographyManager().Dencrypt(QR);
                string[] str_Split = str_CadenaQR.Split('~');

                int int_IdLocal = int.Parse(str_Split[0]);
                int int_IdUbicacion = int.Parse(str_Split[1]);
                obj_Resultado = new Kruma.KantaPe.Service.Entity.ServiceResult<Kruma.KantaPe.Entidad.Ubicacion>
                    (Kruma.KantaPe.Negocio.Ubicacion.Obtener(int_IdLocal, int_IdUbicacion));
            }
            catch (Exception obj_pExcepcion)
            {
                obj_Resultado = new Kruma.KantaPe.Service.Entity.ServiceResult<Kruma.KantaPe.Entidad.Ubicacion>
                    (Kruma.Core.Configuration.ConfigurationManager.Default.ApplicationManager["MensajeError"].Value);
                Kruma.Core.Log.LogManager.Write("Exceptions", "Kruma.KantaPe.Service.Logical.Ubicacion/ObtenerQR", obj_pExcepcion.Message);
            }
            return obj_Resultado;
        }
    }
}