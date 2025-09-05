<%@ Page Title="" Language="C#" MasterPageFile="~/Master/Default.master" AutoEventWireup="true" CodeFile="Ubicacion.aspx.cs" Inherits="Forms_Configuracion_Ubicacion" %>

<%@ Register TagPrefix="cc" Namespace="Kruma.Core.Util.Web.Combine.Controls" Assembly="Kruma.Core.Util.Web" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphHeader" runat="Server">

    <cc:ScriptCombine ID="ScriptCombiner" runat="server" ScriptHandler="~/Ashx/Combine/ScriptHandler.ashx" Combine="false">
        <Scripts>
            <cc:ScriptReference Path="~/Script/Base/jquery.datatables/jquery.dataTables.js" />
            <cc:ScriptReference Path="~/Script/Base/jquery.datatables/jquery.datatables.responsive.js" />
            <cc:ScriptReference Path="~/Script/Base/bootstrap.datatables/bootstrap.datatables.js" />
            <cc:ScriptReference Path="~/Script/Base/bootstrap.datatables/bootstrap.datatables.responsive.js" />
            <cc:ScriptReference Path="~/Script/Base/jquery.bootpag/jquery.bootpag.min.js" />
            <cc:ScriptReference Path="~/Script/Forms/Configuracion/Ubicacion.js" />
        </Scripts>
    </cc:ScriptCombine>

    <cc:CssCombine ID="CSSCombiner" runat="server" CSSHandler="~/Ashx/Combine/CSSHandler.ashx">
        <CSSReferences>
            <cc:CssReference Path="~/Style/Base/jquery.datatables/jquery.datatables.css" />
            <cc:CssReference Path="~/Style/Base/jquery.datatables/jquery.datatables.responsive.css" />
            <cc:CssReference Path="~/Style/Base/bootstrap.datatables/bootstrap.datatables.css" />
        </CSSReferences>
    </cc:CssCombine>

</asp:Content>

<asp:Content ID="Content2" ContentPlaceHolderID="cphBody" runat="Server">

    <div class="row">
        <div id="divFiltro" class="col-xs-12">
            <div class="box box-warning collapsed-box">

                <div class="box-header">
                    <h3 class="box-title">Criterios de Búsqueda</h3>
                    <div class="box-tools pull-right">
                        <button class="btn btn-default btn-sm" data-widget="collapse"><i class="fa fa-plus"></i></button>
                    </div>
                </div>
                <div class="box-body">
                    <div class="row">
                        <div class="col-lg-4">
                            <div class="form-group">
                                <label for="ddlEmpresa">Empresa:</label>
                                <asp:DropDownList ID="ddlEmpresa" runat="server" CssClass="form-control" ClientIDMode="Static"></asp:DropDownList>
                            </div>
                        </div>
                        <div class="col-lg-4">
                            <div class="form-group">
                                <label for="ddlLocal">Local:</label>
                                <asp:DropDownList ID="ddlLocal" runat="server" CssClass="form-control" ClientIDMode="Static"></asp:DropDownList>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-4">
                            <div class="form-group">
                                <label for="ddlUbicacionTipo">Tipo:</label>
                                <asp:DropDownList ID="ddlUbicacionTipo" runat="server" CssClass="form-control" ClientIDMode="Static"></asp:DropDownList>
                            </div>
                        </div>
                        <div class="col-lg-4">
                            <div class="form-group">
                                <label for="txtNumero">Número:</label>
                                <asp:TextBox ID="txtNumero" runat="server" CssClass="form-control soloNumeros" ClientIDMode="Static" MaxLength="100" placeholder="Ingrese el número" />
                            </div>
                        </div>
                        <div class="col-lg-4">
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
    <div class="row">
        <div class="col-xs-12">
            <div class="box box-warning">
                <div class="box-header">
                    <div class="btn-group">
                        <button id="btnAgregar" title="Agregar" class="btn btn-default btn-sm checkbox-toggle"><i class="fa fa-file-o"></i></button>
                        <button id="btnModificar" title="Modificar" class="btn btn-default btn-sm"><i class="fa fa-edit"></i></button>
                        <button id="btnActivar" title="Activar" class="btn btn-default btn-sm"><i class="glyphicon glyphicon-floppy-saved"></i></button>
                        <button id="btnInactivar" title="Inactivar" class="btn btn-default btn-sm"><i class="glyphicon glyphicon-floppy-remove"></i></button>
                    </div>
                    <div class="btn-group">
                        <button id="btnGenerarQR" title="Generar QR" class="btn btn-default btn-sm"><i class="fa fa-cog"></i></button>
                    </div>
                    <button id="btnBuscar" title="Buscar" class="btn btn-default btn-sm"><i class="fa fa-search"></i></button>
                </div>
                <div class="box-body">
                    <div id="divGrilla" style="width: 100%">
                    </div>
                    <div class="row">
                        <div class="col-sm-5">
                            <div id="divPaginacionInfo" class="dataTables_info"></div>
                        </div>
                        <div class="col-sm-7">
                            <div id="divPaginacion" class="dataTables_paginate paging_simple_numbers"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="modal fade colored-header danger" id="mdCodigoQR" tabindex="-1" style="display: none;">
        <div class="modal-dialog modal-sm">
            <div class="modal-content">
                <div class="modal-header">
                    <h3>Generar Codigo QR</h3>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                </div>
                <div class="modal-body">
                    <br />
                    <div class="row">
                        <div class="col-lg-12" style="vertical-align: middle; text-align: center;">
                            <img src='..' id='imgCtrl' style='width: 200px;' />
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-danger btn-flat btn-aceptar">Imprimir</button>
                    <button type="button" class="btn btn-default btn-flat btn-cancelar">Cancelar</button>
                </div>
            </div>
        </div>
    </div>
        <asp:HiddenField ID="hdEsAdministrador" runat="server" ClientIDMode="Static" />
                <asp:HiddenField ID="hdIdEmpresa" runat="server" ClientIDMode="Static" />

            <asp:HiddenField ID="hdIdLocal" runat="server" ClientIDMode="Static" />

</asp:Content>

