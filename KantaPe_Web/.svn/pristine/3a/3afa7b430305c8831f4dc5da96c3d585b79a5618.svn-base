<%@ Page Title="" Language="C#" MasterPageFile="~/Master/Default.master" AutoEventWireup="true" CodeFile="RegistroLocalCancion.aspx.cs" Inherits="Forms_Configuracion_RegistroLocalCancion" %>

<%@ Register TagPrefix="cc" Namespace="Kruma.Core.Util.Web.Combine.Controls" Assembly="Kruma.Core.Util.Web" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphHeader" runat="Server">

    <cc:ScriptCombine ID="ScriptCombiner" runat="server" ScriptHandler="~/Ashx/Combine/ScriptHandler.ashx" Combine="false" Compress="false">
        <Scripts>
            <cc:ScriptReference Path="~/Script/Base/jquery.validate/jquery.validate.js" />
            <cc:ScriptReference Path="~/Script/Base/jquery.validate/jquery.validate.js" />
            <cc:ScriptReference Path="~/Script/Forms/FileServer/FileServer.js" />
            <cc:ScriptReference Path="~/Script/Forms/Configuracion/RegistroLocalCancion.js" />
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
                        <div class="col-lg-12">
                            <div class="form-group">
                                <label for="txtTitulo">Titulo:</label>
                                <input name="txtTitulo" id="txtTitulo" type="text" class="form-control" placeholder="Ingrese el título de la canción...">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-6">
                            <div class="form-group">
                                <label for="txtArtista">Artista:</label>
                                <asp:TextBox ID="txtArtista" runat="server" CssClass="form-control" ClientIDMode="Static" ReadOnly="true" />
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div class="form-group">
                                <label for="txtAlbum">Album:</label>
                                <asp:TextBox ID="txtAlbum" runat="server" CssClass="form-control" ClientIDMode="Static" ReadOnly="true" />
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-6">
                            <div class="form-group">
                                <label for="txtGenero">Género:</label>
                                <asp:TextBox ID="txtGenero" runat="server" CssClass="form-control" ClientIDMode="Static" ReadOnly="true" />
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div class="form-group">
                                <label for="txtIdioma">Idioma:</label>
                                <asp:TextBox ID="txtIdioma" runat="server" CssClass="form-control" ClientIDMode="Static" ReadOnly="true" />
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-6">
                            <div class="form-group">
                                <label for="txtDecada">Decada:</label>
                                <asp:TextBox ID="txtDecada" runat="server" CssClass="form-control" ClientIDMode="Static" ReadOnly="true" />
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div class="form-group">
                                <label for="txtVersion">Version:</label>
                                <asp:TextBox ID="txtVersion" runat="server" CssClass="form-control" ClientIDMode="Static" ReadOnly="true" />
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-6">
                            <div class="form-group">
                                <label for="txtNombreArchivo">Nombre archivo:</label>
                                <asp:TextBox ID="txtNombreArchivo" runat="server" CssClass="form-control" ClientIDMode="Static" ReadOnly="true" />
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div class="form-group">
                                <label for="txtAnio">Año:</label>
                                <asp:TextBox ID="txtAnio" runat="server" CssClass="form-control" ClientIDMode="Static" ReadOnly="true" />
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-6">
                            <div class="form-group">
                                <label for="txtDuracion">Duración:</label>
                                <asp:TextBox ID="txtDuracion" runat="server" CssClass="form-control" ClientIDMode="Static" ReadOnly="true" />
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div class="form-group">
                                <label for="txtYoutube">Enlace Youtube:</label>
                                <asp:TextBox ID="txtYoutube" runat="server" CssClass="form-control" ClientIDMode="Static" ReadOnly="true" />
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="form-group">
                                <label for="txtLetra">Letra:</label>
                                <asp:TextBox ID="txtLetra" runat="server" CssClass="form-control" ClientIDMode="Static" TextMode="MultiLine" Rows="6" ReadOnly="true" />
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
    <asp:HiddenField ID="hdIdCancion" runat="server" ClientIDMode="Static" />
</asp:Content>

