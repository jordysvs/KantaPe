using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Security;
using System.Web.Services;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class Redireccionar : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        if (!IsPostBack)
        {
            string str_Url = FormsAuthentication.LoginUrl;
            if (HttpContext.Current.Request.QueryString.Count > 0)
            {
                if (HttpContext.Current.Request.QueryString["ref"] != null)
                {
                    str_Url = new Kruma.Core.Criptography.CriptographyManager().Dencrypt(HttpUtility.UrlDecode(Request.QueryString["ref"]).Replace(" ", "+"));
                    str_Url = Server.UrlDecode(str_Url);
                }
            }
            Response.Redirect(str_Url);
        }
    }
}