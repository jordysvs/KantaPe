<%@ Page Title="" Language="C#" MasterPageFile="~/Master/Default.master" AutoEventWireup="true" CodeFile="ReporteMesaUnificada.aspx.cs" Inherits="Forms_Reporte_ReporteMesaUnificada" %>

<%@ Register TagPrefix="cc" Namespace="Kruma.Core.Util.Web.Combine.Controls" Assembly="Kruma.Core.Util.Web" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphHeader" runat="Server">
    <cc:ScriptCombine ID="ScriptCombiner" runat="server" ScriptHandler="~/Ashx/Combine/ScriptHandler.ashx" Combine="false" Compress="false" Minify="false">
        <Scripts>
            <cc:ScriptReference Path="~/Script/Base/jquery.datatables/jquery.dataTables.js" />
            <cc:ScriptReference Path="~/Script/Base/jquery.datatables/jquery.datatables.responsive.js" />
            <cc:ScriptReference Path="~/Script/Base/bootstrap.datatables/bootstrap.datatables.js" />
            <cc:ScriptReference Path="~/Script/Base/bootstrap.datatables/bootstrap.datatables.responsive.js" />
            <cc:ScriptReference Path="~/Script/Base/jquery.bootpag/jquery.bootpag.min.js" />
            <cc:ScriptReference Path="~/Script/Base/jquery.flot/jquery.flot.js" />
            <cc:ScriptReference Path="~/Script/Base/jquery.flot/jquery.flot.resize.js" />
            <cc:ScriptReference Path="~/Script/Base/jquery.flot/jquery.flot.pie.js" />
            <cc:ScriptReference Path="~/Script/Base/jquery.flot/jquery.flot.categories.js" />
        </Scripts>
    </cc:ScriptCombine>
    <cc:ScriptCombine ID="ScriptCombine" runat="server" ScriptHandler="~/Ashx/Combine/ScriptHandler.ashx" Combine="false" Minify="false">
        <Scripts>
            <cc:ScriptReference Path="~/Script/Forms/Reporte/ReporteMesaUnificada.js" />
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
                        <div class="col-lg-3">
                            <div class="form-group">
                                <label for="ddlEmpresa">Empresa:</label>
                                <asp:DropDownList ID="ddlEmpresa" runat="server" CssClass="form-control" ClientIDMode="Static">
                                    <asp:ListItem Text="-- Todos --"></asp:ListItem>
                                    <asp:ListItem Text="Norkys"></asp:ListItem>
                                </asp:DropDownList>
                            </div>
                        </div>
                        <div class="col-lg-3">
                            <div class="form-group">
                                <label for="ddlLocal">Local:</label>
                                <asp:DropDownList ID="ddlLocal" runat="server" CssClass="form-control" ClientIDMode="Static">
                                    <asp:ListItem Text="-- Todos --"></asp:ListItem>
                                    <asp:ListItem Text="Soprano Av. Arequipa"></asp:ListItem>
                                    <asp:ListItem Text="Soprano Av. La Molina"></asp:ListItem>
                                </asp:DropDownList>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-3">
                            <div class="form-group">
                                <label for="txtFechaInicio">Fecha Del:</label>
                                <div id="txtFechaInicio" class="input-group date datetime">
                                    <input id="txtFechaInicio_input" name="txtFechaInicio_input" class="form-control" size="16" type="text" value="" placeholder="Ingrese la fecha inicial" />
                                    <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                    <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-3">
                            <div class="form-group">
                                <label for="txtFechaFin">Al:</label>
                                <div id="txtFechaFin" class="input-group date datetime">
                                    <input id="txtFechaFin_input" name="txtFechaFin_input" class="form-control" size="16" type="text" value="" placeholder="Ingrese la fecha final" />
                                    <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                    <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-3">
                            <div class="form-group">
                                <label for="ddlTipoUbicacion">Tipo de Ubicación:</label>
                                <asp:DropDownList ID="ddlUbicacion" runat="server" CssClass="form-control" ClientIDMode="Static">
                                    <asp:ListItem Text="-- Todos --"></asp:ListItem>
                                    <asp:ListItem Text="Box"></asp:ListItem>
                                    <asp:ListItem Text="Mesa"></asp:ListItem>
                                </asp:DropDownList>
                            </div>
                        </div>
                        <div class="col-lg-3">
                            <div class="form-group">
                                <label for="txtUbicación">Nro. Ubicación:</label>
                                <asp:TextBox ID="txtUbicacion" runat="server" CssClass="form-control" ClientIDMode="Static" MaxLength="50" placeholder="Ingrese el número de ubicación" />

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




















