<%@ Page Title="" Language="C#" MasterPageFile="~/Master/Portal.master" AutoEventWireup="true" CodeFile="Karaoke.aspx.cs" Inherits="Forms_Portal_Karaoke" %>

<%@ Register TagPrefix="cc" Namespace="Kruma.Core.Util.Web.Combine.Controls" Assembly="Kruma.Core.Util.Web" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphHeader" runat="Server">
    <cc:ScriptCombine ID="ScriptCombiner" runat="server" ScriptHandler="~/Ashx/Combine/ScriptHandler.ashx">
        <Scripts>
            <cc:ScriptReference Path="~/Script/Forms/Portal/Karaoke.js" />
        </Scripts>
    </cc:ScriptCombine>
    <cc:CssCombine ID="StyleCombiner" runat="server" CSSHandler="~/Ashx/Combine/CssHandler.ashx">
        <CSSReferences>
            <cc:CssReference Path="~/Style/Forms/Karaoke.css" />
        </CSSReferences>
    </cc:CssCombine>
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphBody" runat="Server">
    <div class="cabecera row">
        <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
            <img alt="" src="./Images/Textos/Karaokes-Texto.png" style="max-width: 100%;" />
        </div>
        <div class="col-lg-4 col-md-4 col-sm-4">
        </div>
    </div>
    <br />
    <div class="row">
        <div class="col-xs-12">
            <div id="divKaraokes" class="box-body">
                <div id="listarKaraokes">
                </div>
            </div>
        </div>
    </div>
    <div class="modal fade full-color success" id="mdKaraoke" style="display: none;">
        <div class="modal-dialog modal-md">
            <div class="modal-content">
                <div class="modal-header">
                    <h3>INFORMACION DEL KARAOKE</h3>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                </div>
                <div class="modal-body">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="row">
                                <div class="col-lg-8 col-md-8 col-sm-8">
                                    <div class="form-group" style="text-align: center;">
                                        <img style="max-height: 350px; max-width: 100%;" alt="" id="imgLocalImagen" />
                                    </div>
                                </div>
                                <div class="col-lg-4 col-md-4 col-sm-4" style="background-color: rgba(0, 0, 0, 0.1);">
                                    <div class="row" style="padding-top: 10px;">
                                        <div class="col-lg-12">
                                            <div class="form-group">
                                                <label for="txtLocal">KARAOKE:</label>
                                                <span id="txtLocal"></span>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-lg-12">
                                            <div class="form-group">
                                                <label for="txtDireccion">DIRECCIÓN:</label>
                                                <span id="txtDireccion"></span>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-lg-12">
                                            <div class="form-group">
                                                <label for="txtContacto">CONTACTO:</label>
                                                <span id="txtContacto"></span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-12">
                            <h3 style="letter-spacing: 3px; border-bottom-style: solid; font-weight: 400;">OFERTAS</h3>
                        </div>
                        <div class="col-lg-12">
                            <div id="divOfertas" style="background-color: rgba(0, 0, 0, 0.1);">
                            </div>
                        </div>
                    </div>
                    <br />
                    <div class="row">
                        <div class="col-lg-12">
                            <h3 style="letter-spacing: 3px; border-bottom-style: solid; font-weight: 400;">EVENTOS</h3>
                        </div>
                        <div class="col-lg-12">
                            <div id="divEventos" style="background-color: rgba(0, 0, 0, 0.1);">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <asp:HiddenField ID="hdIdLocal" runat="server" ClientIDMode="Static" />
</asp:Content>
