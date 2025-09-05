<%@ WebHandler Language="C#" Class="ReporteCancionPedidaExcel" %>

using System;
using System.Web;
using System.IO;
using System.Data;
using System.Collections.Generic;
using System.Web.Script.Serialization;
using System.Linq;

public class ReporteCancionPedidaExcel : IHttpHandler
{
    #region Propiedades

    public bool IsReusable
    {
        get
        {
            return false;
        }
    }

    #endregion

    #region Metodos Publicos

    public void ProcessRequest(HttpContext obj_pContext)
    {
        System.Collections.Generic.List<Kruma.KantaPe.Entidad.AperturaCancion> lst_Lista = ReporteCancionPedido().Result;

        System.Text.StringBuilder stb_Reporte = new System.Text.StringBuilder();
        stb_Reporte.Append("<table>");
        stb_Reporte.Append("<tr><td colspan='2' style='font-size:18px; font-weight:bold;'>Reporte de canciones más pedidas</td><td></td></tr>");
        stb_Reporte.Append("<tr><td></td></tr>");
        stb_Reporte.Append(string.Format("<tr><td>Fecha:</td><td style='text-align:left;'>{0}</td></tr>", DateTime.Now.ToString("dd/MM/yyyy HH:mm")));
        stb_Reporte.Append("<tr><td></td></tr>");
        stb_Reporte.Append("</table>");
        stb_Reporte.Append("<table style='width:100%' border='1' rules='all' cellspacing='0'>");
        stb_Reporte.Append("<tr style='background-color:#205484; color:white;'>");
        stb_Reporte.Append("<th>Empresa</th>");
        stb_Reporte.Append("<th>Local</th>");
        stb_Reporte.Append("<th>Artista</th>");
        stb_Reporte.Append("<th>Titulo</th>");
        stb_Reporte.Append("<th>Album</th>");
        stb_Reporte.Append("<th>Género</th>");
        stb_Reporte.Append("<th>Idioma</th>");
        stb_Reporte.Append("<th>Pedidos</th>");
        stb_Reporte.Append("</tr>");

        if (lst_Lista.Count > 0)
        {
            for (int i = 0; i < lst_Lista.Count; i++)
            {
                //var str_FechaApertura = lst_Lista[i].FechaApertura.ToString() == null ? "" : lst_Lista[i].FechaApertura.ToString();
                //var str_UbicacionTipo = lst_Lista[i].Alerta.Ubicacion.UbicacionTipo.Descripcion == null ? "" : lst_Lista[i].Alerta.Ubicacion.UbicacionTipo.Descripcion;
                //var str_Numero = lst_Lista[i].Alerta.Ubicacion.Numero.ToString() == null ? "" : lst_Lista[i].Alerta.Ubicacion.Numero.ToString();
                //var str_DiferenciaFechas = lst_Lista[i].DiferenciaFechas == null ? "" : lst_Lista[i].DiferenciaFechas;

                stb_Reporte.Append("<tr>");
                stb_Reporte.AppendFormat("<td>{0}</td>", lst_Lista[i].LocalCancion.DesEmpresa+ "</td>");
                stb_Reporte.AppendFormat("<td>{0}</td>", lst_Lista[i].LocalCancion.DesLocal+ "</td>");
                stb_Reporte.AppendFormat("<td>{0}</td>", lst_Lista[i].LocalCancion.Artista.Nombre+ "</td>");
                stb_Reporte.AppendFormat("<td>{0}</td>", lst_Lista[i].LocalCancion.Cancion.Descripcion+ "</td>");
                stb_Reporte.AppendFormat("<td>{0}</td>", lst_Lista[i].LocalCancion.Album.Titulo+ "</td>");
                stb_Reporte.AppendFormat("<td>{0}</td>", lst_Lista[i].LocalCancion.Genero.Descripcion+ "</td>");
                stb_Reporte.AppendFormat("<td>{0}</td>", lst_Lista[i].LocalCancion.Idioma.Descripcion+ "</td>");
                stb_Reporte.AppendFormat("<td>{0}</td>", lst_Lista[i].CantidadPedido+ "</td>");

                stb_Reporte.Append("</tr>");
            }
        }
        stb_Reporte.Append("</table>");
        string date = DateTime.Now.ToFileTime().ToString();
        obj_pContext.Response.Clear();
        obj_pContext.Response.Buffer = true;
        obj_pContext.Response.AddHeader("content-disposition", "attachment; filename=ReporteCancionPedida_" + date + ".xls");
        obj_pContext.Response.ContentType = "application/msexcel";
        obj_pContext.Response.ContentEncoding = System.Text.Encoding.Default;

        System.IO.StringWriter objSW = new System.IO.StringWriter();
        System.Web.UI.HtmlTextWriter objHTW = new System.Web.UI.HtmlTextWriter(objSW);

        obj_pContext.Response.Write(stb_Reporte.ToString());
        obj_pContext.Response.Flush();
        obj_pContext.Response.End();
    }


    private Kruma.Core.Util.Common.List<Kruma.KantaPe.Entidad.AperturaCancion> ReporteCancionPedido()
    {
        return Kruma.KantaPe.Negocio.AperturaCancion.lstReporteCancionPedido;
    }

    #endregion
}