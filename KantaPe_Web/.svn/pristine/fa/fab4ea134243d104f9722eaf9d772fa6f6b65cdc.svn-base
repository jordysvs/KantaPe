<%@ Control Language="C#" AutoEventWireup="true" CodeFile="BuscadorArtista.ascx.cs" Inherits="Ascx_Forms_Maestro_BuscadorArtista" %>
<div class="form-group">
    <label for="txtArtista">Artista:</label>
    <div id="txtArtista" class="input-group">
        <input id="txtArtista_input" name="ctl00$cphBody$txtArtista_input" type="text" class="form-control" readonly="readonly" placeholder="Seleccione una artista">
        <span id="btnArtista_remove" class="btn btn-default input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
        <span id="btnArtista_find" class="btn btn-default input-group-addon"><span class="fa fa-search"></span></span>
    </div>
</div>
<div class="modal fade colored-header danger" id="mdBuscadorArtista" tabindex="-1" style="display: none;">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <h3>Artista</h3>
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div id="divFiltroArtista" class="col-xs-12">
                        <div class="box box-warning">
                            <div class="box-header">
                                <h3 class="box-title">Criterios de Búsqueda</h3>
                                <div class="box-tools pull-right">
                                    <button class="btn btn-default btn-sm" data-widget="collapse"><i class="fa fa-minus"></i></button>
                                </div>
                            </div>
                            <div class="box-body">
                                <div class="row">
                                    <div class="col-lg-12">
                                        <div class="form-group">
                                            <label for="txtNombreBuscadorArtista">Nombre:</label>
                                            <input type="text" id="txtNombreBuscadorArtista" class="form-control" maxlength="100" placeholder="Ingrese el nombre del artista" />
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
                                <button id="btnBuscarBuscadorArtista" title="Buscar" class="btn btn-default btn-sm"><i class="fa fa-search"></i></button>
                            </div>
                            <div class="box-body">
                                <div id="divGrillaBuscadorArtista" style="width: 100%">
                                </div>
                                <div class="row">
                                    <div class="col-sm-5">
                                        <div id="divPaginacionInfoBuscadorArtista" class="dataTables_info"></div>
                                    </div>
                                    <div class="col-sm-7">
                                        <div id="divPaginacionBuscadorArtista" class="dataTables_paginate paging_simple_numbers"></div>
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
