<%@ WebHandler Language="C#" Class="GenerarCodigoQR" %>

using System.Web;

public class GenerarCodigoQR : IHttpHandler
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
        string str_CodigoQR = obj_pContext.Request["str_CodigoQR"];
        string str_Encriptado = new Kruma.Core.Criptography.CriptographyManager().Encrypt(str_CodigoQR);

        obj_pContext.Response.ContentType = "image";
        MessagingToolkit.QRCode.Codec.QRCodeEncoder encoder = new MessagingToolkit.QRCode.Codec.QRCodeEncoder();

        System.Drawing.Bitmap img = encoder.Encode(str_Encriptado);
        System.Drawing.Image QR = (System.Drawing.Image)img;
        using (System.IO.MemoryStream ms = new System.IO.MemoryStream())
        {
            QR.Save(ms, System.Drawing.Imaging.ImageFormat.Jpeg);
            byte[] imageBytes = ms.ToArray();
            obj_pContext.Response.BinaryWrite(imageBytes);
        }
        obj_pContext.Response.End();
    }
    #endregion
}


