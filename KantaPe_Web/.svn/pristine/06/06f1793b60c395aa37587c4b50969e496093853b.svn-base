<%@ Page Title="" Language="C#" MasterPageFile="~/Master/Default.master" AutoEventWireup="true" CodeFile="RegistroEmpleado.aspx.cs" Inherits="Forms_Configuracion_RegistroEmpleado" %>

<%@ Register TagPrefix="cc" Namespace="Kruma.Core.Util.Web.Combine.Controls" Assembly="Kruma.Core.Util.Web" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphHeader" runat="Server">
    <cc:ScriptCombine ID="ScriptCombiner" runat="server" ScriptHandler="~/Ashx/Combine/ScriptHandler.ashx" Combine="false">
        <Scripts>
            <cc:ScriptReference Path="~/Script/Base/jquery.validate/jquery.validate.js" />
            <cc:ScriptReference Path="~/Script/Base/jquery.validate/additional-methods.js" />
            <cc:ScriptReference Path="~/Script/Base/jquery.datatables/jquery.dataTables.js" />
            <cc:ScriptReference Path="~/Script/Base/jquery.datatables/jquery.datatables.responsive.js" />
            <cc:ScriptReference Path="~/Script/Base/bootstrap.datatables/bootstrap.datatables.js" />
            <cc:ScriptReference Path="~/Script/Base/bootstrap.datatables/bootstrap.datatables.responsive.js" />
            <cc:ScriptReference Path="~/Script/Forms/Configuracion/RegistroEmpleado.js" />
        </Scripts>
    </cc:ScriptCombine>
    <cc:CSSCombine ID="CSSCombiner" runat="server" CSSHandler="~/Ashx/Combine/CSSHandler.ashx">
        <CSSReferences>
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
            <div class="box box-warning">
                <div class="box-body">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="form-group">
                                <label for="ddlTipoDocumento">Tipo Documento:</label>
                                <asp:DropDownList ID="ddlTipoDocumento" runat="server" CssClass="form-control" ClientIDMode="Static">
                                </asp:DropDownList>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="form-group">
                                <label for="txtNumeroDocumento">Número de Documento:</label>
                                <asp:TextBox ID="txtNumeroDocumento" runat="server" ClientIDMode="Static" CssClass="form-control" placeholder="Ingrese el número de documento" />
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="form-group">
                                <label for="txtNombre">Nombres:</label>
                                <asp:TextBox ID="txtNombre" runat="server" ClientIDMode="Static" CssClass="form-control" placeholder="Ingrese el nombre" />
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="form-group">
                                <label for="txtApellidoPaterno">Apellido Paterno:</label>
                                <asp:TextBox ID="txtApellidoPaterno" runat="server" ClientIDMode="Static" CssClass="form-control" placeholder="Ingrese el apellido paterno" />
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="form-group">
                                <label for="txtApellidoMaterno">Apellido Materno:</label>
                                <asp:TextBox ID="txtApellidoMaterno" runat="server" ClientIDMode="Static" CssClass="form-control" placeholder="Ingrese el apellido materno" />
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-6">
                            <div class="form-group">
                                <label for="txtEmail">Email:</label>
                                <asp:TextBox ID="txtEmail" runat="server" ClientIDMode="Static" CssClass="form-control" placeholder="Ingrese el email" />
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div class="form-group">
                                <label for="txtTelefono">Teléfono:</label>
                                <asp:TextBox ID="txtTelefono" runat="server" ClientIDMode="Static" CssClass="form-control" placeholder="Ingrese el teléfono" />
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="form-group">
                                <label for="ddlPais">Pais:</label>
                                <asp:DropDownList ID="ddlPais" runat="server" CssClass="form-control" ClientIDMode="Static" MaxLength="50">
                                </asp:DropDownList>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="form-group">
                                <label for="ddlDepartamento">Departamento:</label>
                                <asp:DropDownList ID="ddlDepartamento" runat="server" CssClass="form-control" ClientIDMode="Static" MaxLength="50">
                                </asp:DropDownList>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="form-group">
                                <label for="ddlProvincia">Provincia:</label>
                                <asp:DropDownList ID="ddlProvincia" runat="server" CssClass="form-control" ClientIDMode="Static" MaxLength="50">
                                </asp:DropDownList>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="form-group">
                                <label for="ddlDistrito">Distrito:</label>
                                <asp:DropDownList ID="ddlDistrito" runat="server" ClientIDMode="Static" CssClass="form-control" placeholder="Ingrese el Distrito" />
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="form-group">
                                <label for="txtDireccion">Direccion:</label>
                                <asp:TextBox ID="txtDireccion" runat="server" ClientIDMode="Static" CssClass="form-control" placeholder="Ingrese la direccion" />
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
    <asp:HiddenField ID="hdIdEmpleado" runat="server" ClientIDMode="Static" />
</asp:Content>


