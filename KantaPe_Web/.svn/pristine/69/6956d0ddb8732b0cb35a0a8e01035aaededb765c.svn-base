<%@ Page Title="" Language="C#" MasterPageFile="~/Master/Portal.master" AutoEventWireup="true" CodeFile="Ranking.aspx.cs" Inherits="Forms_Portal_Ranking" %>

<%@ Register TagPrefix="cc" Namespace="Kruma.Core.Util.Web.Combine.Controls" Assembly="Kruma.Core.Util.Web" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphHeader" runat="Server">
    <cc:ScriptCombine ID="ScriptCombiner" runat="server" ScriptHandler="~/Ashx/Combine/ScriptHandler.ashx">
        <Scripts>
            <cc:ScriptReference Path="~/Script/Forms/Portal/Ranking.js" />
        </Scripts>
    </cc:ScriptCombine>
    <cc:CssCombine ID="StyleCombiner" runat="server" CSSHandler="~/Ashx/Combine/CssHandler.ashx">
        <CSSReferences>
            <cc:CssReference Path="~/Style/Forms/Ranking.css" />
        </CSSReferences>
    </cc:CssCombine>
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphBody" runat="Server">
    <div class="cabecera row">
        <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
            <img alt="" src="./Images/Textos/Ranking-Texto.png" style="max-width: 100%;" />
        </div>
        <div class="col-lg-4 col-md-4 col-sm-4">
        </div>
    </div>
    <br />
    <div class="row">
        <div class="col-xs-12">
            <div id="divRankiados" class="box-body">
                <div id="listarRankiados">
                </div>
            </div>
        </div>
    </div>
</asp:Content>
