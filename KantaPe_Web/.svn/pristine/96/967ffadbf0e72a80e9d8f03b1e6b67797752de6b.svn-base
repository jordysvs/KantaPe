<%@ Control Language="C#" AutoEventWireup="true" CodeFile="BuscadorAlbum.ascx.cs" Inherits="Ascx_Forms_Maestro_BuscadorAlbum" %>
<div class="form-group">
    <label for="txtAlbum">Álbum:</label>
    <div id="txtAlbum" class="input-group">
        <input id="txtAlbum_input" name="ctl00$cphBody$txtAlbum_input" type="text" class="form-control" readonly="readonly" placeholder="Seleccione un álbum">
        <span id="btnAlbum_remove" class="btn btn-default input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
        <span id="btnAlbum_find" class="btn btn-default input-group-addon"><span class="fa fa-search"></span></span>
    </div>
</div>
<div class="modal fade colored-header danger" id="mdBuscadorAlbum" tabindex="-1" style="display: none;">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <h3>Álbum</h3>
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div id="divFiltroAlbum" class="col-xs-12">
                        <div class="box box-warning">
                            <div class="box-header">
                                <h3 class="box-title">Criterios de Búsqueda</h3>
                                <div class="box-tools pull-right">
                                    <button class="btn btn-default btn-sm" data-widget="collapse"><i class="fa fa-minus"></i></button>
                                </div>
                            </div>
                            <div class="box-body">
                                <div class="row">
                                    <div class="col-lg-6">
                                        <div class="form-group">
                                            <label for="txtNombreBuscadorAlbum">Artista:</label>
                                            <input type="text" id="txtNombreBuscadorAlbum" class="form-control" maxlength="100" placeholder="Ingrese el nombre del artista" />
                                        </div>
                                    </div>
                                    <div class="col-lg-6">
                                        <div class="form-group">
                                            <label for="txtTituloBuscadorAlbum">Álbum:</label>
                                            <input type="text" id="txtTituloBuscadorAlbum" class="form-control" maxlength="100" placeholder="Ingrese el título del álbum" />
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
                                <button id="btnBuscarBuscadorAlbum" title="Buscar" class="btn btn-default btn-sm"><i class="fa fa-search"></i></button>
                            </div>
                            <div class="box-body">
                                <div id="divGrillaBuscadorAlbum" style="width: 100%">
                                </div>
                                <div class="row">
                                    <div class="col-sm-5">
                                        <div id="divPaginacionInfoBuscadorAlbum" class="dataTables_info"></div>
                                    </div>
                                    <div class="col-sm-7">
                                        <div id="divPaginacionBuscadorAlbum" class="dataTables_paginate paging_simple_numbers"></div>
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
