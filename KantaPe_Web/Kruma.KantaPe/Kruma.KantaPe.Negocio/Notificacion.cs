using Kruma.Core.Util.Common;
using System;
using System.IO;
using System.Net;
using System.Text;
using System.Web.Script.Serialization;

namespace Kruma.KantaPe.Negocio
{
    /// <summary>Album</summary>
    /// <remarks><list type="bullet">
    /// <item><CreadoPor>Creado por John Castillo</CreadoPor></item>
    /// <item><FecCrea>03-07-2016</FecCrea></item></list></remarks>

    public class Notificacion
    {
        #region Metodos Públicos

        public static string Enviar(string str_pIdUsuario, string str_pTitulo, string str_pMensaje)
        {
            return Enviar(str_pIdUsuario, str_pTitulo, str_pMensaje, null);
        }

        public static string Enviar(string str_pIdUsuario, string str_pTitulo, string str_pMensaje, object obj_pData)
        {
            string str_Mensaje = string.Empty;
            try
            {
                //Obtener el token
                KantaPe.Entidad.Token obj_Token = KantaPe.Data.Token.Obtener(str_pIdUsuario);
                if (obj_Token != null)
                {
                    string str_ApplicationID = Kruma.Core.Business.Logical.Parametro.Obtener(
                        Kruma.KantaPe.Entidad.Constante.Parametro.Modulo,
                        Kruma.KantaPe.Entidad.Constante.Parametro.FireBaseAppID
                        ).Valor;

                    string str_SenderID = Kruma.Core.Business.Logical.Parametro.Obtener(
                        Kruma.KantaPe.Entidad.Constante.Parametro.Modulo,
                        Kruma.KantaPe.Entidad.Constante.Parametro.FireBaseSenderID
                        ).Valor;

                    string str_URL = Kruma.Core.Business.Logical.Parametro.Obtener(
                       Kruma.KantaPe.Entidad.Constante.Parametro.Modulo,
                       Kruma.KantaPe.Entidad.Constante.Parametro.FireBaseRestURL
                       ).Valor;

                    WebRequest obj_Request = WebRequest.Create(str_URL);
                    obj_Request.Method = "post";
                    obj_Request.ContentType = "application/json";

                    var obj_Data = new
                    {
                        to = obj_Token.IdToken,
                        notification = new
                        {
                            body = str_pMensaje,
                            title = str_pTitulo,
                            icon = "myicon"
                        },
                        data = obj_pData
                    };

                    JavaScriptSerializer obj_Serializer = new JavaScriptSerializer();
                    string str_JSON = obj_Serializer.Serialize(obj_Data);
                    Byte[] arr_Datos = Encoding.UTF8.GetBytes(str_JSON);
                    obj_Request.Headers.Add(string.Format("Authorization: key={0}", str_ApplicationID));
                    obj_Request.Headers.Add(string.Format("Sender: id={0}", str_SenderID));
                    obj_Request.ContentLength = arr_Datos.Length;

                    using (Stream dataStream = obj_Request.GetRequestStream())
                    {
                        dataStream.Write(arr_Datos, 0, arr_Datos.Length);
                        using (WebResponse tResponse = obj_Request.GetResponse())
                        {
                            using (Stream dataStreamResponse = tResponse.GetResponseStream())
                            {
                                using (StreamReader tReader = new StreamReader(dataStreamResponse))
                                {
                                    String sResponseFromServer = tReader.ReadToEnd();
                                    str_Mensaje = sResponseFromServer;

                                    //Insercion del seguimiento de notificaciones
                                    KantaPe.Data.TokenNotificacion.Insertar(
                                        new Entidad.TokenNotificacion()
                                        {
                                            IdToken = obj_Token.IdToken,
                                            IdUsuario = str_pIdUsuario,
                                            Titulo = str_pTitulo,
                                            Mensaje = str_pMensaje,
                                            Resultado = str_Mensaje,
                                            Estado = Kruma.KantaPe.Entidad.Constante.Estado_Activo,
                                            UsuarioCreacion = str_pIdUsuario
                                        });

                                }
                            }
                        }
                    }
                }
            }

            catch (Exception ex)
            {
                str_Mensaje = ex.Message;
            }
            return str_Mensaje;
        }

        #endregion
    }
}
