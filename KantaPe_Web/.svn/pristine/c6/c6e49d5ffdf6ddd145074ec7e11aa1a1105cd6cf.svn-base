using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Kruma.Core.Util.Common;


namespace Kruma.KantaPe.Negocio
{
    /// <summary>Artista</summary>
    /// <remarks><list type="bullet">
    /// <item><CreadoPor>Creado por Carlos Gómez</CreadoPor></item>
    /// <item><FecCrea>02-07-2016</FecCrea></item></list></remarks>

    public class Artista
    {

        #region Metodos Públicos

        /// <summary>Listado de Artista</summary>
        /// <param name="int_pIdArtista">Id del artista</param>
        /// <param name="str_pNombre">Nombre del Artista</param>
        /// <param name="str_pEstado">Estado del Artista</param>
        /// <param name="int_pNumPagina" >Numero de pagina</param>
        /// <param name="int_pTamPagina" >Tamaño de pagina</param>
        /// <returns>Lista de artistas</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por Carlos Gómez</CreadoPor></item>
        /// <item><FecCrea>02-07-2016</FecCrea></item></list></remarks>
        public static Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.Artista> Listar(

            string str_pNombre,
            string str_pEstado,
            int? int_pNumPagina,
            int? int_pTamPagina)
        {
            return Kruma.KantaPe.Data.Artista.Listar(

                null,
                str_pNombre,
                str_pEstado,
                int_pNumPagina,
                int_pTamPagina);
        }

        /// <summary>Obtener Artista</summary>
        /// <param name="int_pIdArtista">Id del artista</param>
        /// <returns>Objeto Artista</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por Carlos Gómez</CreadoPor></item>
        /// <item><FecCrea>02-07-2016</FecCrea></item></list></remarks>
        public static Kruma.KantaPe.Entidad.Artista Obtener(int int_pIdArtista)
        {
            return Kruma.KantaPe.Data.Artista.Obtener(int_pIdArtista);
        }

        /// <summary>Insertar artista</summary>
        /// <param name="obj_pArtista">Artista</param>
        /// <returns>Id de artista</returns>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por Carlos Gómez</CreadoPor></item>
        /// <item><FecCrea>02-07-2016</FecCrea></item></list></remarks>
        public static Kruma.Core.Util.Common.ProcessResult Insertar(Kruma.KantaPe.Entidad.Artista obj_pArtista)
        {
            Kruma.Core.Util.Common.ProcessResult obj_Resultado = null;
            try
            {
                System.Collections.Generic.List<Kruma.KantaPe.Entidad.Artista> lst_Registros = Kruma.KantaPe.Data.Artista.Listar(null, null, null, null, null).Result;
                if (lst_Registros.Where(x => x.Nombre.Trim().ToLower().Equals(obj_pArtista.Nombre.Trim().ToLower())
                                                || x.Nombre.Trim().ToUpper().Equals(obj_pArtista.Nombre.Trim().ToUpper()))
                                                                .ToList().Count > 0)
                    return new ProcessResult(new Exception("Ya existe un artista con el mismo nombre."));
                else
                {
                    obj_pArtista.IdArtista = Kruma.KantaPe.Data.Artista.Insertar(obj_pArtista);

                    //Actualización de la imagen
                    if (obj_pArtista.Foto != null)
                    {
                        if (obj_pArtista.Foto.IdDocumento.HasValue)
                        {
                            int int_IdAlmacenDestino = int.Parse(Kruma.Core.Business.Logical.Parametro.Obtener(
                                Kruma.KantaPe.Entidad.Constante.Parametro.Modulo,
                                Kruma.KantaPe.Entidad.Constante.Parametro.Almacen_Artista).Valor);

                            new Kruma.Core.FileServer.FileServerManager().copyFile(
                                obj_pArtista.Foto.IdAlmacen.Value,
                                obj_pArtista.Foto.IdRegistro.Value,
                                obj_pArtista.Foto.IdDocumento.Value,
                                int_IdAlmacenDestino,
                                obj_pArtista.IdArtista.Value,
                                obj_pArtista.UsuarioCreacion);
                        }
                    }

                    obj_Resultado = new Kruma.Core.Util.Common.ProcessResult(obj_pArtista.IdArtista);
                }
            }
            catch (Exception obj_pExcepcion)
            {
                obj_Resultado = new Kruma.Core.Util.Common.ProcessResult(obj_pExcepcion);
            }
            return obj_Resultado;
        }

        /// <summary>Modificar artista</summary>
        /// <param name="obj_pArtista">Artista</param>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por Carlos Gómez</CreadoPor></item>
        /// <item><FecCrea>02-07-2016</FecCrea></item></list></remarks>
        public static Kruma.Core.Util.Common.ProcessResult Modificar(Kruma.KantaPe.Entidad.Artista obj_pArtista)
        {
            Kruma.Core.Util.Common.ProcessResult obj_Resultado = null;
            try
            {
                Kruma.KantaPe.Data.Artista.Modificar(obj_pArtista);

                //Actualización de la imagen
                if (obj_pArtista.Foto != null)
                {
                    int int_IdAlmacenDestino = int.Parse(Kruma.Core.Business.Logical.Parametro.Obtener(
                            Kruma.KantaPe.Entidad.Constante.Parametro.Modulo,
                            Kruma.KantaPe.Entidad.Constante.Parametro.Almacen_Artista).Valor);

                    Kruma.Core.FileServer.FileServerManager obj_FileServerManager = new Kruma.Core.FileServer.FileServerManager();
                    System.Collections.Generic.List<Kruma.Core.FileServer.Entity.FileUpload> lstFotos = obj_FileServerManager.getFiles(int_IdAlmacenDestino, obj_pArtista.IdArtista.Value);
                    foreach (Kruma.Core.FileServer.Entity.FileUpload obj_Foto in lstFotos)
                        obj_FileServerManager.deleteFile(
                            obj_Foto.IdDocumento.Value, obj_Foto.IdAlmacen.Value, obj_Foto.IdRegistro.Value, obj_pArtista.UsuarioModificacion);

                    if (obj_pArtista.Foto.IdDocumento.HasValue)
                        obj_FileServerManager.copyFile(
                            obj_pArtista.Foto.IdAlmacen.Value,
                            obj_pArtista.Foto.IdRegistro.Value,
                            obj_pArtista.Foto.IdDocumento.Value,
                            int_IdAlmacenDestino,
                            obj_pArtista.IdArtista.Value,
                            obj_pArtista.UsuarioModificacion);
                }

                obj_Resultado = new Kruma.Core.Util.Common.ProcessResult(obj_pArtista.IdArtista);
            }
            catch (Exception obj_pExcepcion)
            {
                obj_Resultado = new Kruma.Core.Util.Common.ProcessResult(obj_pExcepcion);
            }
            return obj_Resultado;
        }

        /// <summary>Modificar Estado Artista</summary>
        /// <param name="obj_pArtista">Artista</param>
        /// <remarks><list type="bullet">
        /// <item><CreadoPor>Creado por Carlos Gómez</CreadoPor></item>
        /// <item><FecCrea>02-07-2016</FecCrea></item></list></remarks>
        public static Kruma.Core.Util.Common.ProcessResult ModificarEstado(Kruma.KantaPe.Entidad.Artista obj_pArtista)
        {
            Kruma.Core.Util.Common.ProcessResult obj_Resultado = null;
            try
            {
                Kruma.KantaPe.Entidad.Artista obj_Artista = Kruma.KantaPe.Data.Artista.Obtener(obj_pArtista.IdArtista.Value);
                if (obj_Artista.Estado == obj_pArtista.Estado)
                {
                    string str_Mensaje = obj_pArtista.Estado ==
                        Kruma.KantaPe.Entidad.Constante.Estado_Activo ?
                        "El artista ya se encuentra activa." :
                        "El artista ya se encuentra inactiva.";
                    return new Kruma.Core.Util.Common.ProcessResult(new Exception(str_Mensaje), str_Mensaje);
                }
                obj_Artista.Estado = obj_pArtista.Estado;
                obj_Artista.UsuarioModificacion = obj_pArtista.UsuarioModificacion;
                Kruma.KantaPe.Data.Artista.Modificar(obj_Artista);

                obj_Resultado = new Kruma.Core.Util.Common.ProcessResult(obj_pArtista.IdArtista);
            }
            catch (Exception obj_pExcepcion)
            {
                obj_Resultado = new Kruma.Core.Util.Common.ProcessResult(obj_pExcepcion);
            }

            return obj_Resultado;
        }
        #endregion

    }
}
