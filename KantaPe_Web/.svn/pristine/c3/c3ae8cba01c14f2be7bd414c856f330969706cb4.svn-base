<%@ WebHandler Language="C#" Class="ExportarExcelHandler" %>

using System;
using System.Web;
using System.IO;
using System.Data;
using System.Collections.Generic;
using System.Web.Script.Serialization;
using System.Linq;

public class ExportarExcelHandler : IHttpHandler
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
        List<Kruma.Core.Util.Common.Entity> lst_Lista = Listar();

        System.Text.StringBuilder stb_Reporte = new System.Text.StringBuilder();
        stb_Reporte.Append("<table>");
        stb_Reporte.Append("<tr><td colspan='2' style='font-size:18px; font-weight:bold;'>Exportar Excel - Listado</td><td></td></tr>");
        stb_Reporte.Append("<tr><td></td></tr>");
        stb_Reporte.Append(string.Format("<tr><td>Fecha:</td><td style='text-align:left;'>{0}</td></tr>", DateTime.Now.ToString("dd/MM/yyyy HH:mm")));
        stb_Reporte.Append("<tr><td></td></tr>");
        stb_Reporte.Append("</table>");
        stb_Reporte.Append("<table style='width:100%' border='1' rules='all' cellspacing='0'>");
        stb_Reporte.Append("<tr style='background-color:#205484; color:white;'>");
        stb_Reporte.Append("<th>CODIGO</th>");
        stb_Reporte.Append("<th>DESCRIPCION</th>");
        stb_Reporte.Append("</tr>");

        foreach (Kruma.Core.Util.Common.Entity obj_Item in lst_Lista)
        {
            stb_Reporte.Append("<tr>");
            stb_Reporte.AppendFormat("<td>{0}</td>", obj_Item.Code);
            stb_Reporte.AppendFormat("<td>{0}</td>", obj_Item.Description);
            stb_Reporte.Append("</tr>");
        }
        stb_Reporte.Append("</table>");

        string date = DateTime.Now.ToFileTime().ToString();
        obj_pContext.Response.Clear();
        obj_pContext.Response.Buffer = true;
        obj_pContext.Response.AddHeader("content-disposition", "attachment; filename=ExportarExcel_" + date + ".xls");
        obj_pContext.Response.ContentType = "application/msexcel";
        obj_pContext.Response.ContentEncoding = System.Text.Encoding.Default;

        System.IO.StringWriter objSW = new System.IO.StringWriter();
        System.Web.UI.HtmlTextWriter objHTW = new System.Web.UI.HtmlTextWriter(objSW);

        obj_pContext.Response.Write(stb_Reporte.ToString());
        obj_pContext.Response.Flush();
        obj_pContext.Response.End();
    }

    private List<Kruma.Core.Util.Common.Entity> Listar()
    {
        List<Kruma.Core.Util.Common.Entity> lst_Entidad = new List<Kruma.Core.Util.Common.Entity>();
        Kruma.Core.Util.Common.Entity obj_Entidad = new Kruma.Core.Util.Common.Entity();
        obj_Entidad.Code = "Codigo 1";
        obj_Entidad.Description = "Descripción 1";
        lst_Entidad.Add(obj_Entidad);

        obj_Entidad = new Kruma.Core.Util.Common.Entity();
        obj_Entidad.Code = "Codigo 2";
        obj_Entidad.Description = "Descripción 2";
        lst_Entidad.Add(obj_Entidad);

        obj_Entidad = new Kruma.Core.Util.Common.Entity();
        obj_Entidad.Code = "Codigo 3";
        obj_Entidad.Description = "Descripción 3";
        lst_Entidad.Add(obj_Entidad);

        obj_Entidad = new Kruma.Core.Util.Common.Entity();
        obj_Entidad.Code = "Codigo 4";
        obj_Entidad.Description = "Descripción 4";
        lst_Entidad.Add(obj_Entidad);

        return lst_Entidad;
    }

    #endregion
}