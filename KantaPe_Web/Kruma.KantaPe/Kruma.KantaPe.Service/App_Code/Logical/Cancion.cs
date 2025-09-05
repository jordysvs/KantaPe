using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.ServiceModel.Web;
using System.Text;
using Kruma.KantaPe.Service.Interface;
using System.ServiceModel.Activation;

namespace Kruma.KantaPe.Service.Logical
{
    [AspNetCompatibilityRequirements(RequirementsMode = AspNetCompatibilityRequirementsMode.Allowed)]
    public class Cancion : ICancion
    {
        //public Entity.ServiceResult<List<Entidad.Cancion>> Listar(
        //    string IdGenero,
        //    string IdIdioma,
        //    string PalabraClave,
        //    string NumPagina,
        //    string TamPagina)
        //{
        //    Kruma.KantaPe.Service.Entity.ServiceResult<
        //        Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.LocalCancion>> obj_Resultado = null;

        //    int? int_IdGenero = IdGenero == Constante.NULLTYPE ? null : (int?)int.Parse(IdGenero);
        //    int? int_IdIdioma = IdIdioma == Constante.NULLTYPE ? null : (int?)int.Parse(IdIdioma);
        //    string str_PalabraClave = PalabraClave == Constante.NULLTYPE ? null : PalabraClave;
        //    int? int_NumPagina = NumPagina == Constante.NULLTYPE ? null : (int?)int.Parse(NumPagina);
        //    int? int_TamPagina = TamPagina == Constante.NULLTYPE ? null : (int?)int.Parse(TamPagina);

        //    try
        //    {
        //        obj_Resultado = new Kruma.KantaPe.Service.Entity.ServiceResult<
        //            Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.LocalCancion>>
        //            (Kruma.KantaPe.Negocio.Cancion.Listar
        //            (
        //            null, null, null, null, null, int_IdGenero, int_IdIdioma, null, null, null, null, str_PalabraClave,
        //            Kruma.KantaPe.Entidad.Constante.Estado_Activo, null, int_IdLocal,
        //            int_NumPagina,
        //            int_TamPagina)
        //            );
        //    }
        //    catch (Exception obj_pExcepcion)
        //    {
        //        obj_Resultado = new Kruma.KantaPe.Service.Entity.ServiceResult<Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.LocalCancion>>
        //                           (Kruma.Core.Configuration.ConfigurationManager.Default.ApplicationManager["MensajeError"].Value);
        //        Kruma.Core.Log.LogManager.Write("Exceptions", "Kruma.KantaPe.Service.Logical.LocalCancion/ListarListaFiltro", obj_pExcepcion.Message);
        //    }

        //    return obj_Resultado;
        //}
    }
}