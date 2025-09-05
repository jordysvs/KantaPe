<%@ Page Title="" Language="C#" MasterPageFile="~/Master/Default.master" AutoEventWireup="true" CodeFile="RegistroApertura.aspx.cs" Inherits="Forms_Gestion_RegistroApertura" %>

<%@ Register TagPrefix="cc" Namespace="Kruma.Core.Util.Web.Combine.Controls" Assembly="Kruma.Core.Util.Web" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphHeader" runat="Server">
    <cc:ScriptCombine ID="ScriptCombiner" runat="server" ScriptHandler="~/Ashx/Combine/ScriptHandler.ashx" Combine="false" Compress="false">
        <Scripts>
            <cc:ScriptReference Path="~/Script/Base/jquery.validate/jquery.validate.js" />
            <cc:ScriptReference Path="~/Script/Base/jquery.validate/additional-methods.js" />
            <cc:ScriptReference Path="~/Script/Forms/FileServer/FileServer.js" />
            <cc:ScriptReference Path="~/Script/Forms/Configuracion/RegistroProducto.js" />
        </Scripts>
    </cc:ScriptCombine>
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphBody" runat="Server">
    <div class="row">
        <div class="col-xs-12">
            <div class="box box-warning">
                <div class="box-header">
                    <div class="btn-group">
                        <button title="Grabar" class="btnGrabar btn btn-default btn-sm checkbox-toggle"><i class="fa fa-floppy-o"></i></button>
                        <button title="Cancelar" class="btnCancelar btn btn-default btn-sm"><i class="fa fa-arrow-left"></i></button>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-xs-12">
            <div class="box box box-warning">
                <div class="box-body">
                    <div class="row">
                        <div class="col-lg-6">
                            <div class="form-group">
                                <label for="ddlEmpresa">Empresa:</label>
                                <asp:DropDownList ID="ddlEmpresa" runat="server" CssClass="form-control" ClientIDMode="Static"></asp:DropDownList>
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div class="form-group">
                                <label for="ddlLocal">Local:</label>
                                <asp:DropDownList ID="ddlLocal" runat="server" CssClass="form-control" ClientIDMode="Static"></asp:DropDownList>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-6">
                            <div class="form-group">
                                <label for="txtNombre">Nombre:</label>
                                <asp:TextBox ID="txtNombre" runat="server" CssClass="form-control" ClientIDMode="Static" MaxLength="100" placeholder="Ingrese el nombre" />
                            </div>
                        </div>
                        <div class="col-lg-6">
                             <div class="form-group">
                                <label for="ddlProductoTipo">Tipo:</label>
                                <asp:DropDownList ID="ddlProductoTipo" runat="server" ClientIDMode="Static" CssClass="form-control" />
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-6">
                            <div class="form-group">
                                <label for="txtCosto">Costo:</label>
                                <asp:TextBox ID="txtCosto" runat="server" CssClass="form-control soloNumerosDecimal" MaxLength="10" ClientIDMode="Static" placeholder="Ingrese el costo" />
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div class="form-group">
                                <label for="txtPrecio">Precio:</label>
                                <asp:TextBox ID="txtPrecio" runat="server" CssClass="form-control soloNumerosDecimal" MaxLength="10" ClientIDMode="Static" placeholder="Ingrese el precio" />
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-6">
                            <div class="form-group">
                                <label for="fileUpload">Foto:</label>
                                <div class="user-header" style="text-align: center;">
                                    <asp:Image CssClass="user-image" Style="max-height: 200px;" alt="" ID="imgProductoImagen" runat="server" ClientIDMode="Static" />
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div class="form-group">
                                <label></label>
                                <input id="fileUpload" name="fileUpload" type="file" />
                                <a id="lnkEliminarFoto" runat="server" href="#">Eliminar Foto</a>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-12">
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
                        <button title="Grabar" class="btnGrabar btn btn-default btn-sm checkbox-toggle"><i class="fa fa-floppy-o"></i></button>
                        <button title="Cancelar" class="btnCancelar btn btn-default btn-sm"><i class="fa fa-arrow-left"></i></button>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <asp:HiddenField ID="hdIdLocal" runat="server" ClientIDMode="Static" />
    <asp:HiddenField ID="hdIdProducto" runat="server" ClientIDMode="Static" />
    <asp:HiddenField ID="hdIdAlmacen" runat="server" ClientIDMode="Static" />
    <asp:HiddenField ID="hdIdDocumento" runat="server" ClientIDMode="Static" />
    <asp:HiddenField ID="hdProductoImagen" runat="server" ClientIDMode="Static" />
</asp:Content>

