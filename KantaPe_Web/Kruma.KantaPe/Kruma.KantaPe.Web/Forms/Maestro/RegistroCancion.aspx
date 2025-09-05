<%@ Page Title="" Language="C#" MasterPageFile="~/Master/Default.master" AutoEventWireup="true" CodeFile="RegistroCancion.aspx.cs" Inherits="Forms_Maestro_RegistroCancion" %>

<%@ Register TagPrefix="cc" Namespace="Kruma.Core.Util.Web.Combine.Controls" Assembly="Kruma.Core.Util.Web" %>
<%@ Register Src="../../Ascx/Forms/Maestro/BuscadorAlbum.ascx" TagName="BuscadorAlbum" TagPrefix="uc1" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphHeader" runat="Server">
    <cc:ScriptCombine ID="ScriptCombiner" runat="server" ScriptHandler="~/Ashx/Combine/ScriptHandler.ashx" Combine="false">
        <Scripts>
            <cc:ScriptReference Path="~/Script/Plugins/jquery.select2/jquery.select2.min.js" />
            <cc:ScriptReference Path="~/Script/Plugins/jquery.select2/i18n/es.js" />
            <cc:ScriptReference Path="~/Script/Base/jquery.validate/jquery.validate.js" />
            <cc:ScriptReference Path="~/Script/Base/jquery.validate/additional-methods.js" />
            <cc:ScriptReference Path="~/Script/Base/jquery.datatables/jquery.dataTables.js" />
            <cc:ScriptReference Path="~/Script/Base/jquery.datatables/jquery.datatables.responsive.js" />
            <cc:ScriptReference Path="~/Script/Base/bootstrap.datatables/bootstrap.datatables.js" />
            <cc:ScriptReference Path="~/Script/Base/bootstrap.datatables/bootstrap.datatables.responsive.js" />
            <cc:ScriptReference Path="~/Script/Forms/FileServer/FileServer.js" />
            <cc:ScriptReference Path="~/Script/Forms/Maestro/BuscadorAlbum.js" />
            <cc:ScriptReference Path="~/Script/Forms/Maestro/RegistroCancion.js" />
        </Scripts>
    </cc:ScriptCombine>
    <cc:CSSCombine ID="CSSCombiner" runat="server" CSSHandler="~/Ashx/Combine/CSSHandler.ashx">
        <CSSReferences>
            <cc:CssReference Path="~/Style/Plugins/jquery.select2/jquery.select2.min.css" />
            <cc:CSSReference Path="~/Style/Base/jquery.datatables/jquery.datatables.css" />
            <cc:CSSReference Path="~/Style/Base/jquery.datatables/jquery.datatables.responsive.css" />
            <cc:CSSReference Path="~/Style/Base/bootstrap.datatables/bootstrap.datatables.css" />
        </CSSReferences>
    </cc:CSSCombine>
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
                            <div class="col-lg-12">
                                <div class="form-group">
                                    <label for="ddlCancion">Cancion:</label>
                                    <div class="input-append">
                                        <select id="ddlCancion" name="ddlCancion" class="form-control"></select>
                                        <button id="btnCancion_add" class="btn btn-default btn-sm checkbox-toggle"><i class="fa fa-plus" aria-hidden="true"></i></button>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-12">
                                <div class="form-group">
                                    <label for="ddlArtista">Artista:</label>
                                    <div class="input-append">
                                        <select id="ddlArtista" name="ddlArtista" class="form-control"></select>
                                        <button id="btnArtista_add" class="btn btn-default btn-sm checkbox-toggle"><i class="fa fa-plus" aria-hidden="true"></i></button>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-12">
                                <div class="form-group">
                                    <label for="ddlAlbum">Album:</label>
                                    <div class="input-append">
                                        <select id="ddlAlbum" name="ddlAlbum" class="form-control"></select>
                                        <button id="btnAlbum_add" class="btn btn-default btn-sm checkbox-toggle"><i class="fa fa-plus" aria-hidden="true"></i></button>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-12">
                                <div class="form-group">
                                    <label for="ddlGenero">Genero:</label>
                                    <div class="input-append">
                                        <select id="ddlGenero" name="ddlGenero" class="form-control"></select>
                                        <button id="btnGenero_add" class="btn btn-default btn-sm checkbox-toggle"><i class="fa fa-plus" aria-hidden="true"></i></button>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-12">
                                <div class="form-group">
                                    <label for="ddlIdioma">Idioma:</label>
                                    <div class="input-append">
                                        <select id="ddlIdioma" name="ddlIdioma" class="form-control"></select>
                                        <button id="btnIdioma_add" class="btn btn-default btn-sm checkbox-toggle"><i class="fa fa-plus" aria-hidden="true"></i></button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div class="col-lg-12">
                                <div class="form-group">
                                    <label for="fileUpload">Foto:</label>
                                    <div class="user-header" style="text-align: center;">
                                        <asp:Image CssClass="user-image" Style="max-height: 200px;" alt="" ID="imgAlbumImagen" runat="server" ClientIDMode="Static" />
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-12">
                                <div class="form-group">
                                    <label></label>
                                    <input id="fileUpload" name="fileUpload" type="file" />
                                    <a id="lnkEliminarFoto" runat="server" href="#">Eliminar Foto</a>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-lg-3">
                            <div class="form-group">
                                <label for="txtNombreArchivo">Nombre archivo:</label>
                                <asp:TextBox ID="txtNombreArchivo" runat="server" CssClass="form-control" ClientIDMode="Static" MaxLength="100" placeholder="Ingrese el nombre del archivo" />
                            </div>
                        </div>
                        <div class="col-lg-3">
                            <div class="form-group">
                                <label for="txtDuracion">Duración:</label>
                                <asp:TextBox ID="txtDuracion" runat="server" CssClass="form-control" ClientIDMode="Static" MaxLength="100" placeholder="Ingrese la duración de la canción" />
                            </div>
                        </div>
                        <div class="col-lg-3">
                            <div class="form-group">
                                <label for="ddlEmpresa">Empresa:</label>
                                <asp:DropDownList ID="ddlEmpresa" runat="server" ClientIDMode="Static" CssClass="form-control" />
                            </div>
                        </div>
                        <div class="col-lg-3">
                            <div class="form-group">
                                <label for="ddlLocal">Local:</label>
                                <asp:DropDownList ID="ddlLocal" runat="server" ClientIDMode="Static" CssClass="form-control" />
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-3">
                            <div class="form-group">
                                <label for="txtDecada">Decada:</label>
                                <asp:TextBox ID="txtDecada" runat="server" CssClass="form-control" ClientIDMode="Static" MaxLength="100" placeholder="Ingrese la década" />
                            </div>
                        </div>
                        <div class="col-lg-3">
                            <div class="form-group">
                                <label for="txtVersion">Version:</label>
                                <asp:TextBox ID="txtVersion" runat="server" CssClass="form-control" ClientIDMode="Static" MaxLength="100" placeholder="Ingrese la versión" />
                            </div>
                        </div>
                        <div class="col-lg-3">
                            <div class="form-group">
                                <label for="txtAnio">Año:</label>
                                <asp:TextBox ID="txtAnio" runat="server" CssClass="form-control" ClientIDMode="Static" MaxLength="100" placeholder="Ingrese el año" />
                            </div>
                        </div>
                        <div class="col-lg-3">
                            <div class="form-group">
                                <label for="txtYoutube">Enlace Youtube:</label>
                                <asp:TextBox ID="txtYoutube" runat="server" CssClass="form-control" ClientIDMode="Static" MaxLength="100" placeholder="Ingrese el enlace a youtube" />
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="form-group">
                                <label for="txtLetra">Letra:</label>
                                <asp:TextBox ID="txtLetra" runat="server" CssClass="form-control" ClientIDMode="Static" TextMode="MultiLine" Rows="6" placeholder="Ingrese la letra de la canción" />
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-6">
                            <div class="form-group">
                                <label for="txtCancionSolicitud">Solicitud:</label>
                                <asp:TextBox ID="txtCancionSolicitud" runat="server" CssClass="form-control" ClientIDMode="Static" ReadOnly="true"></asp:TextBox>
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div class="form-group">
                                <label for="ddlEstado">Estado:</label>
                                <asp:DropDownList ID="ddlEstado" runat="server" CssClass="form-control" ClientIDMode="Static"></asp:DropDownList>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
        <div class="modal fade colored-header danger" id="mdCancion" tabindex="2" style="display: none;">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <h3>Agregar Cancion</h3>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                </div>
                <div class="modal-body">
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="box box box-warning">
                                <div class="box-body">
                                    <div class="row">
                                        <div class="col-lg-12">
                                            <div class="form-group">
                                                <label for="txtDescripcionCancion">Canción:</label>
                                                <asp:TextBox ID="txtDescripcionCancion" runat="server" ClientIDMode="Static" CssClass="form-control" placeholder="Ingrese la cancion">
                                                </asp:TextBox>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-danger btn-flat btn-aceptar">Aceptar</button>
                    <button type="button" class="btn btn-default btn-flat btn-cancelar">Cancelar</button>
                </div>
            </div>
        </div>
    </div>
    <div class="modal fade colored-header danger" id="mdGenero" tabindex="2" style="display: none;">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <h3>Agregar Genero</h3>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                </div>
                <div class="modal-body">
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="box box box-warning">
                                <div class="box-body">
                                    <div class="row">
                                        <div class="col-lg-12">
                                            <div class="form-group">
                                                <label for="txtDescripcionGenero">Genero:</label>
                                                <asp:TextBox ID="txtDescripcionGenero" runat="server" ClientIDMode="Static" CssClass="form-control" placeholder="Ingrese la descripción del genero">
                                                </asp:TextBox>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-danger btn-flat btn-aceptar">Aceptar</button>
                    <button type="button" class="btn btn-default btn-flat btn-cancelar">Cancelar</button>
                </div>
            </div>
        </div>
    </div>
        <div class="modal fade colored-header danger" id="mdIdioma" tabindex="2" style="display: none;">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <h3>Agregar Idioma</h3>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                </div>
                <div class="modal-body">
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="box box box-warning">
                                <div class="box-body">
                                    <div class="row">
                                        <div class="col-lg-12">
                                            <div class="form-group">
                                                <label for="txtDescripcionIdioma">Idioma:</label>
                                                <asp:TextBox ID="txtDescripcionIdioma" runat="server" ClientIDMode="Static" CssClass="form-control" placeholder="Ingrese la descripción del idioma">
                                                </asp:TextBox>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-danger btn-flat btn-aceptar">Aceptar</button>
                    <button type="button" class="btn btn-default btn-flat btn-cancelar">Cancelar</button>
                </div>
            </div>
        </div>
    </div>
     <div class="modal fade colored-header danger" id="mdArtista" tabindex="2" style="display: none;">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <h3>Agregar Artista</h3>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                </div>
                <div class="modal-body">
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="box box box-warning">
                                <div class="box-body">
                                    <div class="row">
                                        <div class="col-lg-12">
                                            <div class="form-group">
                                                <label for="txtDescripcionArtista">Artista:</label>
                                                <asp:TextBox ID="txtDescripcionArtista" runat="server" ClientIDMode="Static" CssClass="form-control" placeholder="Ingrese el nombre del artista">
                                                </asp:TextBox>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-danger btn-flat btn-aceptar">Aceptar</button>
                    <button type="button" class="btn btn-default btn-flat btn-cancelar">Cancelar</button>
                </div>
            </div>
        </div>
    </div>
      <div class="modal fade colored-header danger" id="mdAlbum" tabindex="2" style="display: none;">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <h3>Agregar Album</h3>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                </div>
                <div class="modal-body">
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="box box box-warning">
                                <div class="box-body">
                                  <%--  <div class="row">
                                        <div class="col-lg-12">
                            <div class="form-group">
                                <label for="ddlArtistaAlbum">Artista:</label>
                                <div class="input-append">
                                    <select id="ddlArtistaAlbum" name="ddlArtistaAlbum" class="form-control"></select>
                                </div>
                            </div>
                        </div>
                                        </div>--%>
                                        <%--<div class="col-lg-12">
                                            <div class="form-group">
                                                <label for="ddlArtistaAlbum">Artista:</label>
                                                <asp:DropDownList ID="ddlArtistaAlbum" runat="server" ClientIDMode="Static" CssClass="form-control" />
                                            </div>
                                        </div>--%>
                                        <div class="row">
                                        <div class="col-lg-12">
                                            <div class="form-group">
                                                <label for="txtDescripcionArtistaAlbum">Titulo:</label>
                                                <asp:TextBox ID="txtDescripcionArtistaAlbum" runat="server" ClientIDMode="Static" CssClass="form-control" placeholder="Ingrese el titulo del album">
                                                </asp:TextBox>
                                            </div>
                                        </div>                         
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-danger btn-flat btn-aceptar">Aceptar</button>
                    <button type="button" class="btn btn-default btn-flat btn-cancelar">Cancelar</button>
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
    <asp:HiddenField ID="hdIdCancionSolicitud" runat="server" ClientIDMode="Static" />
    <asp:HiddenField ID="hdIdArtista" runat="server" ClientIDMode="Static" />
    <asp:HiddenField ID="hdIdAlbum" runat="server" ClientIDMode="Static" />

    <asp:HiddenField ID="hdIdAlmacen" runat="server" ClientIDMode="Static" />
    <asp:HiddenField ID="hdIdDocumento" runat="server" ClientIDMode="Static" />
    <asp:HiddenField ID="hdAlbumImagen" runat="server" ClientIDMode="Static" />

    <asp:HiddenField ID="hdEsAdministrador" runat="server" ClientIDMode="Static" />
    <asp:HiddenField ID="hdIdEmpresa" runat="server" ClientIDMode="Static" />
    <asp:HiddenField ID="hdIdLocalValidar" runat="server" ClientIDMode="Static" />
</asp:Content>

