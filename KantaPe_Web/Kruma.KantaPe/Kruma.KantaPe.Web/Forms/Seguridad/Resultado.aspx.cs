using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class Forms_Seguridad_Resultado : System.Web.UI.Page
{
    protected void Page_PreInit(object sender, EventArgs e)
    {
        string str_Titulo = "Confirmación";
        if (Kruma.Core.Security.SecurityManager.Usuario != null)
        {
            this.MasterPageFile = "~/Master/Default.master";
            Master_Default obj_MasterPage = (Master_Default)this.Master;
            obj_MasterPage.TituloPagina = str_Titulo;
        }
        else
        {
            this.MasterPageFile = "~/Master/Externo.master";
            Master_Externo obj_MasterPage = (Master_Externo)this.Master;
            obj_MasterPage.TituloPagina = str_Titulo;
        }
    }
}