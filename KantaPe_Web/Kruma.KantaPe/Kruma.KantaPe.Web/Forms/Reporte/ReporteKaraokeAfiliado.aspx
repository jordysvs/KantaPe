<%@ Page Title="" Language="C#" MasterPageFile="~/Master/Default.master" AutoEventWireup="true" CodeFile="ReporteKaraokeAfiliado.aspx.cs" Inherits="Forms_Reporte_ReporteKaraokeAfiliado" %>

<%@ Register TagPrefix="cc" Namespace="Kruma.Core.Util.Web.Combine.Controls" Assembly="Kruma.Core.Util.Web" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphHeader" runat="Server">
    <cc:ScriptCombine ID="ScriptCombiner" runat="server" ScriptHandler="~/Ashx/Combine/ScriptHandler.ashx">
        <Scripts>
            <cc:ScriptReference Path="~/Script/Base/jquery.datatables/jquery.dataTables.js" />
            <cc:ScriptReference Path="~/Script/Base/jquery.datatables/jquery.datatables.responsive.js" />
            <cc:ScriptReference Path="~/Script/Base/bootstrap.datatables/bootstrap.datatables.js" />
            <cc:ScriptReference Path="~/Script/Base/bootstrap.datatables/bootstrap.datatables.responsive.js" />
            <cc:ScriptReference Path="~/Script/Base/jquery.bootpag/jquery.bootpag.min.js" />
        </Scripts>
    </cc:ScriptCombine>
    <cc:ScriptCombine ID="ScriptCombineDate" runat="server" ScriptHandler="~/Ashx/Combine/ScriptHandler.ashx" Minify="false">
        <Scripts>
            <cc:ScriptReference Path="~/Script/Base/bootstrap.datetimepicker/bootstrap.datetimepicker.js" />
        </Scripts>
    </cc:ScriptCombine>
    <cc:ScriptCombine ID="ScriptCombine" runat="server" ScriptHandler="~/Ashx/Combine/ScriptHandler.ashx" Combine="false" Minify="false">
        <Scripts>
            <cc:ScriptReference Path="~/Script/Forms/Reporte/ReporteKaraokeAfiliado.js" />
        </Scripts>
    </cc:ScriptCombine>
    <cc:CssCombine ID="CSSCombiner" runat="server" CSSHandler="~/Ashx/Combine/CSSHandler.ashx">
        <CSSReferences>
            <cc:CssReference Path="~/Style/Base/jquery.datatables/jquery.datatables.css" />
            <cc:CssReference Path="~/Style/Base/jquery.datatables/jquery.datatables.responsive.css" />
            <cc:CssReference Path="~/Style/Base/bootstrap.datatables/bootstrap.datatables.css" />
            <cc:CssReference Path="~/Style/Base/bootstrap.datetimepicker/bootstrap.datetimepicker.css" />
        </CSSReferences>
    </cc:CssCombine>
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphBody" runat="Server">
    <div class="row">
        <div class="col-xs-12">
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
                                <asp:DropDownList ID="ddlEmpresa" runat="server" CssClass="form-control" ClientIDMode="Static">
                                    <asp:ListItem Text="-- Todos --"></asp:ListItem>
                                    <asp:ListItem Text="Norkys"></asp:ListItem>
                                </asp:DropDownList>
                            </div>
                        </div>
                        <div class="col-lg-4">
                            <div class="form-group">
                                <label for="txtLocal">Local:</label>
                                <asp:TextBox ID="txtLocal" runat="server" CssClass="form-control" ClientIDMode="Static" MaxLength="50" placeholder="Ingrese el local" />
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-12">
            <div class="box box-warning">
                <div class="box-header">
                    <button id="btnBuscar" title="Generar" class="btn btn-default btn-sm"><i class="fa fa-cog"></i></button>
                    <!-- Check all button -->
                    <div class="btn-group">
                        <button id="btnExportar" title="Exportar" class="btn btn-default btn-sm checkbox-toggle"><i class="fa fa-file-excel-o"></i></button>
                    </div>
                </div>
                <!-- /.box-header -->
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
</asp:Content>













