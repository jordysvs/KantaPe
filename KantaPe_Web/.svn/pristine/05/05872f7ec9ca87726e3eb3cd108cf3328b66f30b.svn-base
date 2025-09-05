using System;
using Kruma.KantaPe.Service.Interface;
using System.ServiceModel.Activation;
using Kruma.Core.Util.Common;
using Kruma.KantaPe.Entidad;
using Kruma.KantaPe.Service.Entity;

namespace Kruma.KantaPe.Service.Logical
{
    [AspNetCompatibilityRequirements(RequirementsMode = AspNetCompatibilityRequirementsMode.Allowed)]
    public class Genero : IGenero
    {

        public Kruma.KantaPe.Service.Entity.ServiceResult<Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Genero>> Listar()
        {
            Kruma.KantaPe.Service.Entity.ServiceResult<Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Genero>> obj_Resultado = null;

            try
            {
                obj_Resultado = new Kruma.KantaPe.Service.Entity.ServiceResult<Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Genero>>
                   (Kruma.KantaPe.Negocio.Genero.Listar(null, Kruma.KantaPe.Entidad.Constante.Estado_Activo, null, null));
            }

            catch (Exception obj_pExcepcion)
            {
                obj_Resultado = new Kruma.KantaPe.Service.Entity.ServiceResult<Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Genero>>                  
                    (Kruma.Core.Configuration.ConfigurationManager.Default.ApplicationManager["MensajeError"].Value);

                Kruma.Core.Log.LogManager.Write("Exceptions", "Kruma.KantaPe.Service.Logical.Genero/ListarGeneroPorLocal", obj_pExcepcion.Message);
            }

            return obj_Resultado;

        }

        //public Kruma.KantaPe.Service.Entity.ServiceResult<Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Genero>> Listar(
        //    string IdGenero, 
        //    string Codigo, 
        //    string Descripcion, 
        //    string Estado, 
        //    string NumPagina, 
        //    string TamPagina)
        //{
        //    Kruma.KantaPe.Service.Entity.ServiceResult<Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Genero>> obj_Resultado = null;

        //    int? int_IdGenero = IdGenero == Constante.NULLTYPE ? null : (int?)int.Parse(IdGenero);
        //    string str_Codigo = Codigo == Constante.NULLTYPE ? null : Codigo;
        //    string str_Descripcion = Descripcion == Constante.NULLTYPE ? null : Descripcion;
        //    string str_Estado = Estado == Constante.NULLTYPE ? null : Estado;
        //    int? int_NumPagina = NumPagina == Constante.NULLTYPE ? null : (int?)int.Parse(NumPagina);
        //    int? int_TamPagina = TamPagina == Constante.NULLTYPE ? null : (int?)int.Parse(TamPagina);
        //    try
        //    {
        //        obj_Resultado = new Kruma.KantaPe.Service.Entity.ServiceResult<
        //            Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Genero>>
        //            (Kruma.KantaPe.Negocio.Genero.Listar
        //            (
        //            //int_IdGenero,
        //            str_Descripcion,
        //            str_Estado,
        //            int_NumPagina,
        //            int_TamPagina)
        //            );
        //    }
        //    catch (Exception obj_pExcepcion)
        //    {
        //        obj_Resultado = new Kruma.KantaPe.Service.Entity.ServiceResult<Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Genero>>
        //            (Kruma.Core.Configuration.ConfigurationManager.Default.ApplicationManager["MensajeError"].Value);
        //        Kruma.Core.Log.LogManager.Write("Exceptions", "Kruma.KantaPe.Service.Logical.Genero/Listar", obj_pExcepcion.Message);
        //    }
        //    return obj_Resultado;
        //}

        public Entity.ServiceResult<Kruma.Core.Util.Common.ProcessResult> Insertar(Kruma.KantaPe.Entidad.Genero Genero)
        {
            Kruma.KantaPe.Service.Entity.ServiceResult<Kruma.Core.Util.Common.ProcessResult> obj_Resultado = null;
            try
            {
                obj_Resultado = new Kruma.KantaPe.Service.Entity.ServiceResult<Kruma.Core.Util.Common.ProcessResult>
                    (Kruma.KantaPe.Negocio.Genero.Insertar(Genero));
            }
            catch (Exception obj_pExcepcion)
            {
                obj_Resultado = new Kruma.KantaPe.Service.Entity.ServiceResult<Kruma.Core.Util.Common.ProcessResult>
                    (Kruma.Core.Configuration.ConfigurationManager.Default.ApplicationManager["MensajeError"].Value);
                Kruma.Core.Log.LogManager.Write("Exceptions", "Kruma.KantaPe.Service.Logical.Genero/Insertar", obj_pExcepcion.Message);
            }
            return obj_Resultado;
        }

        
        public Kruma.KantaPe.Service.Entity.ServiceResult<Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Genero>> ListarGeneroMusicalPorLocal(string IdLocal)
        {
            Kruma.KantaPe.Service.Entity.ServiceResult<Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Genero>> obj_Resultado = null;

            int? int_IdLocal = IdLocal == Constante.NULLTYPE ? null : (int?)int.Parse(IdLocal);

            try
            {
                obj_Resultado = new Kruma.KantaPe.Service.Entity.ServiceResult<Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Genero>>
                   (Kruma.KantaPe.Negocio.Genero.ListarGeneroPorLocal(int_IdLocal));
            }

            catch (Exception obj_pExcepcion)
            {
                obj_Resultado = new Kruma.KantaPe.Service.Entity.ServiceResult<Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Genero>>
                    (Kruma.Core.Configuration.ConfigurationManager.Default.ApplicationManager["MensajeError"].Value);

                Kruma.Core.Log.LogManager.Write("Exceptions", "Kruma.KantaPe.Service.Logical.Genero/Listar", obj_pExcepcion.Message);
            }

            return obj_Resultado;

        }
    }
}