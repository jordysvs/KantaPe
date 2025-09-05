<%@ Page Title="" Language="C#" MasterPageFile="~/Master/Externo.master" AutoEventWireup="true" CodeFile="Resultado.aspx.cs" Inherits="Forms_Seguridad_Resultado" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphHeader" runat="Server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphBody" runat="Server">
    <div class="row">
        <div class="col-xs-12">
            <div class="box box-warning" style="background-color: transparent!important; box-shadow: none!important;">
                <div class="box-body" style="text-align: center;">
                    <br />
                    <br />
                    <br />
                    <br />
                    <img src="<%= Page.ResolveClientUrl("~/Content/LogoCliente.png")%>" />
                </div>
            </div>
        </div>
    </div>
    <br />
    <br />
    <br />
    <div class="row">
        <div class="col-lg-12" style="text-align: center;">
            <span style="font-size: 14px;">Se realizó correctamente el cambio de contraseña.</span>
        </div>
    </div>
</asp:Content>

