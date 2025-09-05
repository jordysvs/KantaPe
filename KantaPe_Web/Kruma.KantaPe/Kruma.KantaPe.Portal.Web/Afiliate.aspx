<%@ Page Title="" Language="C#" MasterPageFile="~/Master/Portal.master" AutoEventWireup="true" CodeFile="Afiliate.aspx.cs" Inherits="Forms_Portal_Afiliate" %>

<%@ Register TagPrefix="cc" Namespace="Kruma.Core.Util.Web.Combine.Controls" Assembly="Kruma.Core.Util.Web" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphHeader" runat="Server">
    <cc:CssCombine ID="StyleCombiner" runat="server" CSSHandler="~/Ashx/Combine/CssHandler.ashx" Compress="false" AppCacheDuration="0" BrowserCacheDuration="0">
        <CSSReferences>
            <cc:CssReference Path="~/Style/Forms/Afiliate.css" />
        </CSSReferences>
    </cc:CssCombine>
    <script>
        $(function () {
            $(".imgHome").attr('src', './Images/Iconos/Icono-Blanco.png');
            $(".imgAfiliate").attr('src', './Images/Iconos/Icono-Verde.png');
        });

    </script>
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphBody" runat="Server">
    <div class="row">
        <br />
        <div class="col-xl-4 col-lg-4 col-sm-4"></div>
        <div class="col-xl-8 col-lg-8 col-sm-8 col-xs-12" style="border-bottom-color: #283093; border-bottom-style: solid; border-bottom-width: 2px;">
            <img src="./Images/Forms/Afiliate/Funcionalidades.png" />
        </div>
    </div>
    <div class="row">
        <br />
        <div class="col-xl-1 col-lg-1 col-md-1">
        </div>
        <div class="col-xl-10 col-lg-10 col-md-10 col-sm-12">
            <div class="row">
                <div class="col-lg-3 col-md-3 col-sm-3" style="text-align: center; padding-top: 10px;">
                    <img src="./Images/Forms/Afiliate/Afiliate-Administrador.png" style="max-width: 100%;" />
                </div>
                <div class="col-lg-3 col-md-3 col-sm-3" style="text-align: center; padding-top: 10px;">
                    <img src="./Images/Forms/Afiliate/Afiliate-Cliente.png" style="max-width: 100%;" />
                </div>
                <div class="col-lg-3 col-md-3 col-sm-3" style="text-align: center; padding-top: 10px;">
                    <img src="./Images/Forms/Afiliate/Afiliate-DJ.png" style="max-width: 100%;" />
                </div>
                <div class="col-lg-3 col-md-3 col-sm-3" style="text-align: center; padding-top: 10px;">
                    <img src="./Images/Forms/Afiliate/Afiliate-Mozo.png" style="max-width: 100%;" />
                </div>
            </div>
        </div>
        <div class="col-xl-1 col-lg-1 col-md-1">
        </div>
    </div>

    <div class="row">
        <br />
        <br />
        <div class="col-xl-4 col-lg-4 col-sm-4 col-xs-12" style="border-bottom-color: #63B722; border-bottom-style: solid; border-bottom-width: 2px; text-align: right;">
            <img src="./Images/Forms/Afiliate/Planes.png" />
        </div>
    </div>
    <div class="row">
        <br />
        <div class="col-xl-1 col-lg-1 col-md-1">
        </div>
        <div class="col-xl-10 col-lg-10 col-md-10 col-sm-12">
            <div class="row">
                <div class="col-lg-4 col-md-4 col-sm-4" style="text-align: center;">
                    <img src="./Images/Forms/Afiliate/Afiliate-Apertura.png" style="max-width: 100%;" />
                </div>
                <div class="col-lg-4 col-md-4 col-sm-4" style="text-align: center;">
                    <img src="./Images/Forms/Afiliate/Afiliate-PorUbicacion.png" style="max-width: 100%;" />
                </div>
                <div class="col-lg-4 col-md-4 col-sm-4" style="text-align: center;">
                    <img src="./Images/Forms/Afiliate/Afiliate-PorLocal.png" style="max-width: 100%;" />
                </div>
            </div>
        </div>
        <div class="col-xl-1 col-lg-1 col-md-1">
        </div>
    </div>
</asp:Content>

