<%@ Page Title="" Language="C#" MasterPageFile="~/Master/Default.master" AutoEventWireup="true" CodeFile="RegistroOferta.aspx.cs" Inherits="Forms_Configuracion_RegistroOferta" %>

<%@ Register TagPrefix="cc" Namespace="Kruma.Core.Util.Web.Combine.Controls" Assembly="Kruma.Core.Util.Web" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphHeader" runat="Server">
    <cc:ScriptCombine ID="ScriptCombiner" runat="server" ScriptHandler="~/Ashx/Combine/ScriptHandler.ashx" Combine="false" Compress="false">
        <Scripts>
            <cc:ScriptReference Path="~/Script/Base/jquery.validate/jquery.validate.js" />
            <cc:ScriptReference Path="~/Script/Base/jquery.validate/additional-methods.js" />
            <cc:ScriptReference Path="~/Script/Base/bootstrap.datetimepicker/bootstrap.datetimepicker.js" />
            <cc:ScriptReference Path="~/Script/Forms/FileServer/FileServer.js" />
            <cc:ScriptReference Path="~/Script/Forms/Configuracion/RegistroOferta.js" />
        </Scripts>
    </cc:ScriptCombine>
    <cc:CssCombine ID="CSSCombiner" runat="server" CSSHandler="~/Ashx/Combine/CSSHandler.ashx">
        <CSSReferences>
            <cc:CssReference Path="~/Style/Base/bootstrap.datetimepicker/bootstrap.datetimepicker.css" />
        </CSSReferences>
    </cc:CssCombine>
</asp:Content>

<asp:Content ID="Content2" ContentPlaceHolderID="cphBody" runat="Server">

    <div class="row">
        <div class="col-xs-12">
            <div class="box box-warning">
                <div class="box-header">
                    <div class="btn-group">
                        <button title="Grabar" class="btnGrabar btn btn-default btn-sm"><i class="fa fa-floppy-o"></i></button>
                        <button title="Cancelar" class="btnCancelar btn btn-default btn-sm"><i class="fa fa-arrow-left"></i></button>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-12">
            <div class="box box box-warning">
                <div class="box-body">
                    <div class="row">
                        <div class="col-lg-6 col-sm-6">
                            <div class="form-group">
                                <label for="ddlEmpresa">Empresa:</label>
                                <asp:DropDownList ID="ddlEmpresa" runat="server" CssClass="form-control" ClientIDMode="Static"></asp:DropDownList>
                            </div>
                        </div>
                        <div class="col-lg-6 col-sm-6">
                            <div class="form-group">
                                <label for="ddlLocal">Local:</label>
                                <asp:DropDownList ID="ddlLocal" runat="server" CssClass="form-control" ClientIDMode="Static"></asp:DropDownList>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="form-group">
                                <label for="txtNombre">Nombre:</label>
                                <asp:TextBox ID="txtNombre" runat="server" CssClass="form-control" ClientIDMode="Static" MaxLength="100" placeholder="Ingrese el nombre" />
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="form-group">
                                <label for="txtDescripcion">Descripción:</label>
                                <asp:TextBox ID="txtDescripcion" runat="server" CssClass="form-control" MaxLength="500" TextMode="MultiLine" Rows="4" ClientIDMode="Static" placeholder="Ingrese la descripción" />
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-6 col-sm-6">
                            <div class="form-group">
                                <label for="txtFechaOferta">Fecha de la oferta:</label>
                                <div id="txtFechaOferta" class="input-group date datetime">
                                    <input id="txtFechaOferta_input" name="txtFechaOferta_input" class="form-control" size="16" type="text" value="" placeholder="Ingrese la fecha de la oferta" />
                                    <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                    <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-6 col-sm-6">
                            <div class="form-group">
                                <label for="txtFechaVencimiento">Fecha de vencimiento:</label>
                                <div id="txtFechaVencimiento" class="input-group date datetime">
                                    <input id="txtFechaVencimiento_input" name="txtFechaVencimiento_input" class="form-control" size="16" type="text" value="" placeholder="Ingrese la fecha del vencimiento" />
                                    <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                    <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-6 col-sm-6">
                            <div class="form-group">
                                <label for="fileUpload">Foto:</label>
                                <div class="user-header" style="text-align: center;">
                                    <asp:Image CssClass="user-image" Style="max-height: 200px;" alt="" ID="imgOfertaImagen" runat="server" ClientIDMode="Static" />
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-6 col-sm-6">
                            <div class="form-group">
                                <label></label>
                                <input id="fileUpload" name="fileUpload" type="file" />
                                <a id="lnkEliminarFoto" runat="server" href="#">Eliminar Foto</a>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-6 col-sm-6" style="background-color: lightgray;">
                            <div class="form-group">
                                <div class="col-lg-6 col-sm-6">
                                    <div class="form-group">
                                        <label for="txtFechaPromoción">Activar Promoción:</label>
                                        <div class="checkbox">
                                            <label>
                                                <input type="checkbox" id="chkPromocionar" /><span id="lblPromocionar" style="font-weight: bold; font-size: 14px;"></span>
                                            </label>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-6 col-sm-6">
                                    <div class="form-group">
                                        <label for="txtFechaPromocion">Fecha Promoción:</label>
                                        <input type="text" id="txtFechaPromocion" class="form-control" placeholder="fecha de activación de la promoción" disabled="disabled" />
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-6 col-sm-6">
                            <div class="form-group">
                                <label for="ddlEstado">Estado:</label>
                                <asp:DropDownList ID="ddlEstado" runat="server" ClientIDMode="Static" CssClass="form-control" />
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="row auditoria">
        <div class="col-xs-12">
            <div class="box box box-warning">
                <div class="box-body">
                    <div class="row">
                        <div class="col-lg-3">
                            <div class="dl-horizontal">
                                <span class="label">Usuario de Creación:</span>
                                <span class="field" id="ddUsuarioCreacion"></span>
                            </div>
                        </div>
                        <div class="col-lg-3">
                            <div class="dl-horizontal">
                                <span class="label">Fecha de Creación:</span>
                                <span class="field" id="ddFechaCreacion"></span>
                            </div>
                        </div>
                        <div class="col-lg-3">
                            <div class="dl-horizontal">
                                <span class="label">Usuario de Modificación:</span>
                                <span class="field" id="ddUsuarioModificacion"></span>
                            </div>
                        </div>
                        <div class="col-lg-3">
                            <div class="dl-horizontal">
                                <span class="label">Fecha de Modificación:</span>
                                <span class="field" id="ddFechaModificacion"></span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-xs-12">
            <div class="box box-warning">
                <div class="box-header">
                    <div class="btn-group">
                        <button title="Grabar" class="btnGrabar btn btn-default btn-sm "><i class="fa fa-floppy-o"></i></button>
                        <button title="Cancelar" class="btnCancelar btn btn-default btn-sm"><i class="fa fa-arrow-left"></i></button>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <asp:HiddenField ID="hdIdLocal" runat="server" ClientIDMode="Static" />
    <asp:HiddenField ID="hdIdOferta" runat="server" ClientIDMode="Static" />
    <asp:HiddenField ID="hdIdAlmacen" runat="server" ClientIDMode="Static" />
    <asp:HiddenField ID="hdIdDocumento" runat="server" ClientIDMode="Static" />
    <asp:HiddenField ID="hdOfertaImagen" runat="server" ClientIDMode="Static" />

    <asp:HiddenField ID="hdEsAdministrador" runat="server" ClientIDMode="Static" />
    <asp:HiddenField ID="hdIdEmpresa" runat="server" ClientIDMode="Static" />
    <asp:HiddenField ID="hdIdLocalValidar" runat="server" ClientIDMode="Static" />
</asp:Content>

