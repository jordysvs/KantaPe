//Atributos
var int_NumPagina = 1;
var int_TamPagina = 10;
var int_PagMostrar = 9;
//CARGA MASIVA TOTAL
var lst_LocalCancionMemoria = [];

$(function () {
    CargarInicial();
    CargarControles();
});

function CargarInicial() {

    jQuery.validator.addMethod('selectEmpresa', function (value) {
        return (value != '');
    }, "Seleccione la empresa");
    jQuery.validator.addMethod('selectLocal', function (value) {
        return (value != '');
    }, "Seleccione el local");


    jQuery.validator.addMethod('selectCancion', function (value) {
        return (value != null);
    }, "Seleccione la cancion");

    jQuery.validator.addMethod('selectGenero', function (value) {
        return (value != null);
    }, "Seleccione el género");

    jQuery.validator.addMethod('selectIdioma', function (value) {
        return (value != null);
    }, "Seleccione el idioma");

    jQuery.validator.addMethod('selectArtista', function (value) {
        return (value != null);
    }, "Seleccione el artista");


    jQuery.validator.addMethod('CancionSimple', function (value) {
        if ($("#txtDescripcionCancion").is(":disabled"))
            return true;
        else if (value != "")
            return true;
    }, "Ingrese la canción");
    jQuery.validator.addMethod('Genero', function (value) {
        if ($("#txtDescripcionGenero").is(":disabled"))
            return true;
        else if (value != "")
            return true;
    }, "Ingrese el genero");
    jQuery.validator.addMethod('Idioma', function (value) {
        if ($("#txtDescripcionIdioma").is(":disabled"))
            return true;
        else if (value != "")
            return true;
    }, "Ingrese el idioma");
    jQuery.validator.addMethod('Artista', function (value) {
        if ($("#txtDescripcionArtista").is(":disabled"))
            return true;
        else if (value != "")
            return true;
    }, "Ingrese el artista");
    
}
function CargarControles() {

    if ($("#hdEsAdministrador").val() == "N") {
        $("#ddlEmpresa").prop('disabled', true);
        $("#ddlLocal").prop('disabled', true);
        CargarLocal(true, $("#hdIdLocalValidar").val());
    }

    $('#ddlEmpresa').change(function () {
        CargarLocal(true, null);
    });

    $('#ddlLocal').change(function () {
        ListarMusicas(1);
    });

    var settings = $('#frmContent').validate().settings;
    $.extend(settings, {
        highlight: function (element) {
            $(element).closest('.form-group').removeClass('has-success').addClass('has-error');
        },
        success: function (element) {
            $(element).closest('.form-group').removeClass('has-error').addClass('has-success');
        }
    });


    //GUARDAR CANCION
    $("#mdCancion").find('.modal-footer .btn-aceptar').click(function () {
        var str_ID = $("#hdIdCancion").val();
        GuardarCancionSimple(str_ID);
    });

    $("#mdCancion").find('.modal-footer .btn-cancelar').click(function () {
        $("#mdCancion").modal('hide');
    });
    //GUARDAR Artista
    $("#mdArtista").find('.modal-footer .btn-aceptar').click(function () {
        var str_ID = $("#hdIdArtista").val();
        GuardarArtista(str_ID);
    });

    $("#mdArtista").find('.modal-footer .btn-cancelar').click(function () {
        $("#mdArtista").modal('hide');
    });
    //GUARDAR GENERO
    $("#mdGenero").find('.modal-footer .btn-aceptar').click(function () {
        var str_ID = $("#hdIdGenero").val();
        GuardarGenero(str_ID);
    });

    $("#mdGenero").find('.modal-footer .btn-cancelar').click(function () {
        $("#mdGenero").modal('hide');
    });
    //GUARDAR IDIOMA
    $("#mdIdioma").find('.modal-footer .btn-aceptar').click(function () {
        var str_ID = $("#hdIdIdioma").val();
        GuardarIdioma(str_ID);
    });

    $("#mdIdioma").find('.modal-footer .btn-cancelar').click(function () {
        $("#mdIdioma").modal('hide');
    });

    $("#btnBuscar").click(function () {
        ListarMusicas(1);
        return false;
    });

    $(".btnGrabar").click(function () {
        return GuardarCargaMasivaTotal();
    });
    
    InicializarCancionBuscador(null);
    ListarMusicas(1);
}
//GUARDAR CARGA MASIVA
function GuardarCargaMasiva(IdLocalCancionTemporal,NombreArchivo, Cancion, Artista, Genero, Idioma) {

    ValidacionLocalCancion();
    if ($('#frmContent').valid()) {
        var lst_LocalCancion = [];

            var str_IdCancion = $("#"+ Cancion.name +"").val();
            var str_IdArtista = $("#" + Artista.name +"").val();
            var str_IdGenero = $("#" + Genero.name +"").val();
            var str_IdIdioma = $("#" + Idioma.name +"").val();
            var str_IdEmpresa = $("#ddlEmpresa").val();
            var str_IdLocal = $("#ddlLocal").val();
            var str_NombreArchivo = $("#" + NombreArchivo.id + "").val();

            if (str_IdCancion != null && str_IdArtista != null && str_IdGenero != null && str_IdIdioma != null) {
                obj_LocalCancion = new Object();
                obj_LocalCancion.IdCancion = str_IdCancion;
                obj_LocalCancion.IdArtista = str_IdArtista;
                obj_LocalCancion.IdGenero = str_IdGenero;
                obj_LocalCancion.IdIdioma = str_IdIdioma;
                obj_LocalCancion.IdEmpresa = str_IdEmpresa;
                obj_LocalCancion.IdLocal = str_IdLocal;
                obj_LocalCancion.NombreArchivo = str_NombreArchivo;

                obj_LocalCancion.LocalCancionTemporal = new Object();
                obj_LocalCancion.LocalCancionTemporal.IdLocalCancionTemporal = IdLocalCancionTemporal;
                obj_LocalCancion.LocalCancionTemporal.IdEmpresa = str_IdEmpresa;
                obj_LocalCancion.LocalCancionTemporal.IdLocal = str_IdLocal;
                obj_LocalCancion.LocalCancionTemporal.NombreArchivo = str_NombreArchivo;
                obj_LocalCancion.LocalCancionTemporal.Estado = "A";
                obj_LocalCancion.LocalCancionTemporal.FlagVisible = "N";

                lst_LocalCancion.push(obj_LocalCancion);


            } else {
                AlertJQ(4, "Seleccionar todos los campos de la fila.");
                return false;
            }

            Accion('RegistroLocalCancion.aspx/GuardarCargaMasiva', { "str_pLocalCacion": JSON.stringify(lst_LocalCancion) },
                    function () {
                        $("#hdIdCancion").val('');
                        $("#hdIdArtista").val('');
                        $("#hdIdGenero").val('');
                        $("#hdIdIdioma").val('');

                        ListarMusicas(1);
                    });
    }
    return false;
}

function ListarMusicas(int_pNumPagina) {
    int_NumPagina = int_pNumPagina;
    var int_IdEmpresa = $("#ddlEmpresa").val();
    var int_IdLocal = $("#ddlLocal").val();

    if ($("#hdEsAdministrador").val() == "N") {
        int_IdEmpresa = $("#hdIdEmpresa").val();
        int_IdLocal = $("#hdIdLocalValidar").val();
    }
    var obj_Data = {
        "int_pIdEmpresa": int_IdEmpresa,
        "int_pIdLocal": int_IdLocal,
        "int_pNumPagina": int_NumPagina,
        "int_pTamPagina": int_TamPagina
    };
    if ($("#ddlLocal").val() != '')
        AccionDefault(true, "RegistroLocalCancion.aspx/ListarLocalCancionTemporal", obj_Data, CargarMusicas, null, null, null, 1);
}
function CargarMusicas(lst_pLocalCancionTemporal) {

    var obj_TablaPrincipal = $("<table id='tblLocalCancion' class='table table-bordered table-hover dt-responsive'></table>");
    var obj_THead = $("<thead></thead>");
    var obj_FilaPrincipal = $("<tr></tr>");
    obj_FilaPrincipal.append($("<th style='width:17%'>Cancion Local</th>"));
    obj_FilaPrincipal.append($("<th style='width:20%;'>Titulo</th>"));
    obj_FilaPrincipal.append($("<th style='width:20%;'>Artista</th>"));
    obj_FilaPrincipal.append($("<th style='width:20%;'>Genero</th>"));
    obj_FilaPrincipal.append($("<th style='width:20%;'>Idioma</th>"));
    obj_FilaPrincipal.append($("<th style='width:2%;'></th>"));


    obj_THead.append(obj_FilaPrincipal);
    obj_TablaPrincipal.append(obj_THead);

    var str_Estado = '';
    var obj_TBody = $("<tbody></tbody>");
    var str_Diferenciar = 1;
    lst_LocalCancionMemoria = [];
        for (let i = 0; i < lst_pLocalCancionTemporal.Result.length; i++) {
            var int_pIdLocalCancionTemporal = lst_pLocalCancionTemporal.Result[i].IdLocalCancionTemporal;
            var str_CancionLocal = lst_pLocalCancionTemporal.Result[i].NombreArchivo;
            var str_NombreArchivo = "hdNombreArchivo_" + str_Diferenciar;        
            var str_IdCancion = "ddlCancion_" + str_Diferenciar;
            var str_IdArtista = "ddlArtista_" + str_Diferenciar;
            var str_IdGenero = "ddlGenero_" + str_Diferenciar;
            var str_IdIdioma = "ddlIdioma_" + str_Diferenciar;

            var obj_LocalCancion = new Object();
            obj_LocalCancion.IdLocalCancionTemporal = int_pIdLocalCancionTemporal;
            obj_LocalCancion.NombreArchivo = str_NombreArchivo;
            obj_LocalCancion.IdCancion = str_IdCancion;
            obj_LocalCancion.IdArtista = str_IdArtista;
            obj_LocalCancion.IdGenero = str_IdGenero;
            obj_LocalCancion.IdIdioma = str_IdIdioma;
            lst_LocalCancionMemoria.push(obj_LocalCancion);


            obj_FilaPrincipal = $("<tr value='" + str_CancionLocal + "'></tr>");
            obj_FilaPrincipal.append($("<td>" + str_CancionLocal + "<input type='hidden' id='" + str_NombreArchivo + "' value='" + str_CancionLocal + "' /></td>"));
            obj_FilaPrincipal.append($("<td><div class='input-append'><select id='" + str_IdCancion + "' name='" + str_IdCancion + "' class='form-control cancion'></select><button id='btnCancion_add_" + str_Diferenciar + "' class='btn btn-default btn-sm checkbox-toggle agregarCancion' onclick='javascript:return AbrirModalCancion(" + str_IdCancion + ");'><i class='fa fa-plus' aria-hidden='true'></i></button></td>"));
            obj_FilaPrincipal.append($("<td><div class='input-append'><select id='" + str_IdArtista + "' name='" + str_IdArtista + "' class='form-control artista'></select><button id='btnArtista_add_" + str_Diferenciar + "' class='btn btn-default btn-sm checkbox-toggle agregarArtista' onclick='javascript:return AbrirModalArtista(" + str_IdArtista + ");'><i class='fa fa-plus' aria-hidden='true'></i></button></td>"));
            obj_FilaPrincipal.append($("<td><div class='input-append'><select id='" + str_IdGenero + "' name='" + str_IdGenero + "' class='form-control genero'></select><button id='btnGenero_add_" + str_Diferenciar + "' class='btn btn-default btn-sm checkbox-toggle agregarGenero' onclick='javascript:return AbrirModalGenero(" + str_IdGenero + ");'><i class='fa fa-plus' aria-hidden='true'></i></button></td>"));
            obj_FilaPrincipal.append($("<td><div class='input-append'><select id='" + str_IdIdioma + "' name='" + str_IdIdioma + "' class='form-control idioma'></select><button id='btnIdioma_add_" + str_Diferenciar + "' class='btn btn-default btn-sm checkbox-toggle agregarIdioma' onclick='javascript:return AbrirModalIdioma(" + str_IdIdioma + ");'><i class='fa fa-plus' aria-hidden='true'></i></button></td>"));
            
            obj_FilaPrincipal.append($("<td style='width:10%; text-align:center'><div class='btn-group'><button title='Guardar' class='btn btn-default btn-sm' onclick='javascript:return GuardarCargaMasiva("+int_pIdLocalCancionTemporal+","+str_NombreArchivo+"," + str_IdCancion + "," + str_IdArtista + "," + str_IdGenero + "," + str_IdIdioma + ");'><i class='fa fa-floppy-o'></i></button></div></td>"));

            obj_TBody.append(obj_FilaPrincipal);
            str_Diferenciar++;
        };

        obj_TablaPrincipal.append(obj_TBody);

        $("#divPaginacion").html('');
        $("#divPaginacion").append(CargarPaginacion(lst_pLocalCancionTemporal));

        $("#divGrilla").html('');
        $("#divGrilla").append(obj_TablaPrincipal);

        var obj_Tabla = $('#tblLocalCancion').dataTable({
            "language": {
                "lengthMenu": "Mostrar _MENU_ registros por página",
                "zeroRecords": "No se encontraron registros",
                "info": "Página _PAGE_ de _PAGES_",
                "infoEmpty": "",
                "infoFiltered": "(Filtrado hasta _MAX_ total registros)"
            },
            "processing": false,
            "bPaginate": false,
            "bLengthChange": false,
            "bFilter": false,
            "bSort": true,
            "bInfo": false,
            "bAutoWidth": false
        });

        //Obtener Observaciones 
        if ($('#frmContent').valid()) {
            var lst_SolicitudRevision = [];
            var lst_LocalCancion = $('#tblLocalCancion').find('.LocalCancion');
            var escape = false;

        }

        InicializarCancionBuscador(null);
        InicializarArtistaBuscador(null);
        InicializarGeneroBuscador(null);
        InicializarIdiomaBuscador(null);
 
}

function CargarPaginacion(obj_pLista) {
    var int_vNumPagina = int_NumPagina;
    var int_vPagMostrar = int_PagMostrar;
    var int_TotalRegistros = obj_pLista.Total;

    var obj_Ul = $("<ul class='pagination'></ul>");
    var obj_Li = $("<li class='paginate_button'></li>");
    obj_Ul.append(obj_Li);
    obj_Li.append(CrearNumeroPagina(int_vNumPagina, int_vNumPagina));

    while ((int_TotalRegistros - ((int_NumPagina - 1) * int_TamPagina) - int_TamPagina) > 0) {
        int_TotalRegistros = (int_TotalRegistros - int_TamPagina);
        int_vNumPagina++;
        int_vPagMostrar--;
        if (int_vPagMostrar > 0)
            obj_Li.append(CrearNumeroPagina(int_vNumPagina, int_vNumPagina));
        else {
            if (int_TotalRegistros > 0) {
                obj_Li.append(CrearNumeroPagina(int_vNumPagina, ">"));
                break;
            }
        }
    }

    int_vNumPagina = int_NumPagina;
    while ((int_TotalRegistros - int_TamPagina) > 0) {
        int_TotalRegistros = (int_TotalRegistros - int_TamPagina);
        int_vNumPagina--;
        int_vPagMostrar--;
        if (int_vPagMostrar > 0)
            obj_Li.prepend(CrearNumeroPagina(int_vNumPagina, int_vNumPagina));
    }
    if (int_vNumPagina > 1)
        obj_Li.prepend(CrearNumeroPagina(int_vNumPagina, "<"));

    var int_TotalPaginas = Math.ceil(obj_pLista.Total / int_TamPagina);
    int_TotalPaginas = int_TotalPaginas == 0 ? 1 : int_TotalPaginas;
    $("#divPaginacionInfo").html("Página " + int_NumPagina + " de " + int_TotalPaginas);

    return obj_Ul;
}

function CrearNumeroPagina(int_pNumPagina, str_pTexto) {
    var obj_AnchorPag = $("<a></a>");
    $(obj_AnchorPag).attr('href', '#');
    $(obj_AnchorPag).attr('onclick', 'ListarMusicas(' + (int_pNumPagina) + ');');
    $(obj_AnchorPag).text(str_pTexto);
    return obj_AnchorPag;
}

//---------------ABRIL LOS MODAL-------------------
function AbrirModalCancion(str_IdCancion) {

        $("#hdIdCancion").val(str_IdCancion.id);

        $("#txtDescripcionCancion").val('');
        var obj_modal = $("#mdCancion").modal('show', {
            backdrop: true,
            keyboard: false,
        });
        $('#mdCancion').on('shown.bs.modal', function () {
            $("#txtDescripcionCancion").focus();
        });
        return false;
}
function AbrirModalArtista(str_IdArtista) {
    $("#hdIdArtista").val(str_IdArtista.id);

        $("#txtDescripcionArtista").val('');
        var obj_modal = $("#mdArtista").modal('show', {
            backdrop: true,
            keyboard: false,
        });
        $('#mdArtista').on('shown.bs.modal', function () {
            $("#txtDescripcionArtista").focus();
        });
        return false;
}
function AbrirModalGenero(str_IdGenero) {
    $("#hdIdGenero").val(str_IdGenero.id);
        $("#txtDescripcionGenero").val('');
        var obj_modal = $("#mdGenero").modal('show', {
            backdrop: true,
            keyboard: false,
        });
        $('#mdGenero').on('shown.bs.modal', function () {
            $("#txtDescripcionGenero").focus();
        });
        return false;
}
function AbrirModalIdioma(str_IdIdioma) {
    $("#hdIdIdioma").val(str_IdIdioma.id);

        $("#txtDescripcionIdioma").val('');
        var obj_modal = $("#mdIdioma").modal('show', {
            backdrop: true,
            keyboard: false,
        });
        $('#mdIdioma').on('shown.bs.modal', function () {
            $("#txtDescripcionIdioma").focus();
        });
        return false;
}
//-----------------------------AUTOCOMPLETAR-----------------------------
function InicializarCancionBuscador(obj_pData) {
    var str_ID = '.cancion';
    if ($("#hdIdCancion").val() != '') {
        str_ID = "#"+$("#hdIdCancion").val();
    }
        
    //$("#" + str_ID + "").select2({
         $(str_ID).select2({
            data: obj_pData,
            language: "es",
            multiple: false,
            width: '85%',
            allowClear: true,
            minimumInputLength: 3,
            placeholder: "Ingrese la cancion",
            escapeMarkup: function (markup) { return markup; },
            ajax: {
                url: "RegistroLocalCancion.aspx/ListarCancion",
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                delay: 250,
                type: "POST",
                data: function (params) {
                    return JSON.stringify({
                        str_pDescripcion: (params.term || '').trim(),
                        int_pNumPagina: params.page || 1,
                        int_pTamPagina: 10
                    });
                },
                processResults: function (data, params) {
                    var lst_Results = [];
                    $.each(data.d.Result, function (i, v) {
                        var obj_Resultado = {};
                        obj_Resultado.id = v.IdCancion;
                        obj_Resultado.descripcion = v.Descripcion;
                        lst_Results.push(obj_Resultado);
                    })
                    params.page = params.page || 1;
                    return {
                        results: lst_Results,
                        pagination: {
                            more: (params.page * 10) < data.d.Total
                        }
                    };
                },
                cache: true
            },
            templateResult: function (option) {
                if (option.loading) { return option.text; }
                return $("<span>" + option.descripcion + "</span>");

            },
            templateSelection: function (option) {
                if (option.id == '') { return option.text; }
                return option.descripcion;
            }
        });
}

function InicializarArtistaBuscador(obj_pData) {
    //Buscador de genero
    //$ddlArtista =
    var str_ID = '.artista';
    if ($("#hdIdArtista").val() != '') {
        str_ID = "#" + $("#hdIdArtista").val();
    }
    $(str_ID).select2({
            data: obj_pData,
            language: "es",
            multiple: false,
            width: '85%',
            allowClear: true,
            minimumInputLength: 3,
            placeholder: "Ingrese el artista",
            escapeMarkup: function (markup) { return markup; },
            ajax: {
                url: "RegistroLocalCancion.aspx/ListarArtista",
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                delay: 250,
                type: "POST",
                data: function (params) {
                    return JSON.stringify({
                        str_pDescripcion: (params.term || '').trim(),
                        int_pNumPagina: params.page || 1,
                        int_pTamPagina: 10
                    });
                },
                processResults: function (data, params) {
                    var lst_Results = [];
                    $.each(data.d.Result, function (i, v) {
                        var obj_Resultado = {};
                        obj_Resultado.id = v.IdArtista;
                        obj_Resultado.descripcion = v.Nombre;
                        lst_Results.push(obj_Resultado);
                    })
                    params.page = params.page || 1;
                    return {
                        results: lst_Results,
                        pagination: {
                            more: (params.page * 10) < data.d.Total
                        }
                    };
                },
                cache: true
            },
            templateResult: function (option) {
                if (option.loading) { return option.text; }
                return $("<span>" + option.descripcion + "</span>");

            },
            templateSelection: function (option) {
                if (option.id == '') { return option.text; }
                return option.descripcion;
            }
        });
}
function InicializarGeneroBuscador(obj_pData) {
    //Buscador de genero
    //$ddlGenero =
    var str_ID = '.genero';
    if ($("#hdIdGenero").val() != '') {
        str_ID = "#" + $("#hdIdGenero").val();
    }
    $(str_ID).select2({
            data: obj_pData,
            language: "es",
            multiple: false,
            width: '85%',
            allowClear: true,
            minimumInputLength: 3,
            placeholder: "Ingrese el genero",
            escapeMarkup: function (markup) { return markup; },
            ajax: {
                url: "RegistroLocalCancion.aspx/ListarGenero",
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                delay: 250,
                type: "POST",
                data: function (params) {
                    return JSON.stringify({
                        str_pDescripcion: (params.term || '').trim(),
                        int_pNumPagina: params.page || 1,
                        int_pTamPagina: 10
                    });
                },
                processResults: function (data, params) {
                    var lst_Results = [];
                    $.each(data.d.Result, function (i, v) {
                        var obj_Resultado = {};
                        obj_Resultado.id = v.IdGenero;
                        obj_Resultado.descripcion = v.Descripcion;
                        lst_Results.push(obj_Resultado);
                    })
                    params.page = params.page || 1;
                    return {
                        results: lst_Results,
                        pagination: {
                            more: (params.page * 10) < data.d.Total
                        }
                    };
                },
                cache: true
            },
            templateResult: function (option) {
                if (option.loading) { return option.text; }
                return $("<span>" + option.descripcion + "</span>");

            },
            templateSelection: function (option) {
                if (option.id == '') { return option.text; }
                return option.descripcion;
            }
        });
}

function InicializarIdiomaBuscador(obj_pData) {
    //Buscador de idioma
    //$ddlIdioma =
    var str_ID = '.idioma';
    if ($("#hdIdIdioma").val() != '') {
        str_ID = "#" + $("#hdIdIdioma").val();
    }
    $(str_ID).select2({
            data: obj_pData,
            language: "es",
            multiple: false,
            width: '85%',
            allowClear: true,
            minimumInputLength: 3,
            placeholder: "Ingrese el idioma",
            escapeMarkup: function (markup) { return markup; },
            ajax: {
                url: "RegistroLocalCancion.aspx/ListarIdioma",
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                delay: 250,
                type: "POST",
                data: function (params) {
                    return JSON.stringify({
                        str_pDescripcion: (params.term || '').trim(),
                        int_pNumPagina: params.page || 1,
                        int_pTamPagina: 10
                    });
                },
                processResults: function (data, params) {
                    var lst_Results = [];
                    $.each(data.d.Result, function (i, v) {
                        var obj_Resultado = {};
                        obj_Resultado.id = v.IdIdioma;
                        obj_Resultado.descripcion = v.Descripcion;
                        lst_Results.push(obj_Resultado);
                    })
                    params.page = params.page || 1;
                    return {
                        results: lst_Results,
                        pagination: {
                            more: (params.page * 10) < data.d.Total
                        }
                    };
                },
                cache: true
            },
            templateResult: function (option) {
                if (option.loading) { return option.text; }
                return $("<span>" + option.descripcion + "</span>");

            },
            templateSelection: function (option) {
                if (option.id == '') { return option.text; }
                return option.descripcion;
            }
        });
}


//---------------------AGREGAR------------------
function GuardarCancionSimple(str_ID) {
    ValidacionCancionSimple();
    if ($('#frmContent').valid()) {

        var str_Descripcion = $("#txtDescripcionCancion").val();
        AccionDefault(true, "RegistroLocalCancion.aspx/AgregarCancion", { "str_pDescripcion": str_Descripcion },
            function (obj_pResultado) {
                var lst_Centro = [];
                var obj_Centro = new Object();
                obj_Centro.id = obj_pResultado.ReturnId;
                obj_Centro.descripcion = str_Descripcion;
                lst_Centro.push(obj_Centro);
                $("#mdCancion").modal('hide');
                $("#ddlCancion").val(str_ID);
                $("#"+str_ID + "").select2('destroy');
                InicializarCancionBuscador(lst_Centro);
                //$ddlCancion.val(obj_Centro.id).trigger('change');
                
            }
            , null, null, null, 0);
    }
    return false;
}
function GuardarArtista(str_ID) {
    ValidacionArtista();
    if ($('#frmContent').valid()) {
        var str_Descripcion = $("#txtDescripcionArtista").val();
        AccionDefault(true, "RegistroLocalCancion.aspx/AgregarArtista", { "str_pDescripcion": str_Descripcion },
            function (obj_pResultado) {
                var lst_Centro = [];
                var obj_Centro = new Object();
                obj_Centro.id = obj_pResultado.ReturnId;
                obj_Centro.descripcion = str_Descripcion;
                lst_Centro.push(obj_Centro);

                $("#mdArtista").modal('hide');

                $("#" + str_ID + "").select2('destroy');
                InicializarArtistaBuscador(lst_Centro);
                //$ddlArtista.val(obj_Centro.id).trigger('change');
            }
            , null, null, null, 0);
    }
    return false;
}
function GuardarGenero(str_ID) {
    ValidacionGenero();
    if ($('#frmContent').valid()) {
        var settings = $('#frmContent').validate().settings;
        $('.form-group').removeClass('has-error').removeClass('has-success');
        $.extend(settings, {
            ignore: "",

            messages: {
                ctl00$cphBody$txtDescripcionCancion: { required: 'Ingrese la cancion' }
            },
        });
        var str_Descripcion = $("#txtDescripcionGenero").val();
        AccionDefault(true, "RegistroLocalCancion.aspx/AgregarGenero", { "str_pDescripcion": str_Descripcion },
            function (obj_pResultado) {
                var lst_Centro = [];
                var obj_Centro = new Object();
                obj_Centro.id = obj_pResultado.ReturnId;
                obj_Centro.descripcion = str_Descripcion;
                lst_Centro.push(obj_Centro);
                $("#mdGenero").modal('hide');

                $("#" + str_ID + "").select2('destroy');
                InicializarGeneroBuscador(lst_Centro);
                //$ddlGenero.val(obj_Centro.id).trigger('change');
            }
            , null, null, null, 0);
    }
    return false;
}
function GuardarIdioma(str_ID) {
    ValidacionIdioma();
    if ($('#frmContent').valid()) {
        var str_Descripcion = $("#txtDescripcionIdioma").val();
        AccionDefault(true, "RegistroLocalCancion.aspx/AgregarIdioma", { "str_pDescripcion": str_Descripcion },
            function (obj_pResultado) {
                var lst_Centro = [];
                var obj_Centro = new Object();
                obj_Centro.id = obj_pResultado.ReturnId;
                obj_Centro.descripcion = str_Descripcion;
                lst_Centro.push(obj_Centro);
                $("#mdIdioma").modal('hide');

                $("#" + str_ID + "").select2('destroy');
                InicializarIdiomaBuscador(lst_Centro);
                //$ddlIdioma.val(obj_Centro.id).trigger('change');
                
            }
            , null, null, null, 0);
    }
    return false;
}

//--------------------------------------------VALIDACIONES-------------------------------------
function ValidacionCancionSimple() {
    var settings = $('#frmContent').validate().settings;
    $('.form-group').removeClass('has-error').removeClass('has-success');
    $.extend(settings, {
        ignore: "",
        rules: {
            ctl00$cphBody$txtDescripcionCancion: { CancionSimple: true }
        },
        messages: {
        },
    });
}
function ValidacionGenero() {
    var settings = $('#frmContent').validate().settings;
    $('.form-group').removeClass('has-error').removeClass('has-success');
    $.extend(settings, {
        ignore: "",
        rules: {
            ctl00$cphBody$txtDescripcionGenero: { Genero: true }
        },
        messages: {
        },
    });
}
function ValidacionIdioma() {
    var settings = $('#frmContent').validate().settings;
    $('.form-group').removeClass('has-error').removeClass('has-success');
    $.extend(settings, {
        ignore: "",
        rules: {
            ctl00$cphBody$txtDescripcionIdioma: { Idioma: true }
        },
        messages: {
        },
    });
}
function ValidacionArtista() {
    var settings = $('#frmContent').validate().settings;
    $('.form-group').removeClass('has-error').removeClass('has-success');
    $.extend(settings, {
        ignore: "",
        rules: {
            ctl00$cphBody$txtDescripcionArtista: { Artista: true }
        },
        messages: {
        },
    });
}
function ValidacionLocalCancion() {
    var settings = $('#frmContent').validate().settings;
    $('.form-group').removeClass('has-error').removeClass('has-success');
    $.extend(settings, {
        ignore: "",
        rules: {
            ctl00$cphBody$ddlEmpresa: { selectEmpresa: true },
            ctl00$cphBody$ddlLocal: { selectLocal: true }
        },
        messages: {
        },
    });
}
function GuardarCargaMasivaTotal() {

    ValidacionLocalCancion();
    if ($('#frmContent').valid()) {
        var lst_LocalCancion = [];

        for (var x = 0; x < lst_LocalCancionMemoria.length; x++) {
            var IdLocalCancionTemporal = lst_LocalCancionMemoria[x].IdLocalCancionTemporal;
            var str_IdCancion = $("#" + lst_LocalCancionMemoria[x].IdCancion + "").val();
            var str_IdArtista = $("#" + lst_LocalCancionMemoria[x].IdArtista + "").val();
            var str_IdGenero = $("#" + lst_LocalCancionMemoria[x].IdGenero + "").val();
            var str_IdIdioma = $("#" + lst_LocalCancionMemoria[x].IdIdioma + "").val();
            var str_IdEmpresa = $("#ddlEmpresa").val();
            var str_IdLocal = $("#ddlLocal").val();
            var str_NombreArchivo = $("#" + lst_LocalCancionMemoria[x].NombreArchivo + "").val();

            if (str_IdCancion != null && str_IdArtista != null && str_IdGenero != null && str_IdIdioma != null) {
                obj_LocalCancion = new Object();
                obj_LocalCancion.IdCancion = str_IdCancion;
                obj_LocalCancion.IdArtista = str_IdArtista;
                obj_LocalCancion.IdGenero = str_IdGenero;
                obj_LocalCancion.IdIdioma = str_IdIdioma;
                obj_LocalCancion.IdEmpresa = str_IdEmpresa;
                obj_LocalCancion.IdLocal = str_IdLocal;
                obj_LocalCancion.NombreArchivo = str_NombreArchivo;

                obj_LocalCancion.LocalCancionTemporal = new Object();
                obj_LocalCancion.LocalCancionTemporal.IdLocalCancionTemporal = IdLocalCancionTemporal;
                obj_LocalCancion.LocalCancionTemporal.IdEmpresa = str_IdEmpresa;
                obj_LocalCancion.LocalCancionTemporal.IdLocal = str_IdLocal;
                obj_LocalCancion.LocalCancionTemporal.NombreArchivo = str_NombreArchivo;
                obj_LocalCancion.LocalCancionTemporal.Estado = "A";
                obj_LocalCancion.LocalCancionTemporal.FlagVisible = "N";

                lst_LocalCancion.push(obj_LocalCancion);
            }
        
    }

    Accion('RegistroLocalCancion.aspx/GuardarCargaMasiva', { "str_pLocalCacion": JSON.stringify(lst_LocalCancion) },
                function () {
                    ListarMusicas(1);
                });
}
return false;
}
function CargarLocal(bln_pAsync, int_pIdLocal) {

    var ddlLocal = $("#ddlLocal");
    ddlLocal.empty();
    ddlLocal.html('');
    ddlLocal.append($("<option value=''>--Seleccione--</option>"));

    var int_IdPersona = $("#ddlEmpresa").val();
    if (int_IdPersona != '') {
        var obj_Data = { "int_pIdPersona": int_IdPersona };
        AccionDefault(bln_pAsync, "RegistroLocalCancion.aspx/ListarLocal", obj_Data,
             function (obj_pLista) {
                 //ddlNivel.prop("disabled", false);
                 var str_Selected = '';
                 for (var i = 0; i < obj_pLista.Result.length; i++) {
                     if (int_pIdLocal != null)
                         str_Selected = (obj_pLista.Result[i].IdLocal == int_pIdLocal) ? 'selected' : '';
                     ddlLocal.append($("<option value='" + obj_pLista.Result[i].IdLocal + "' " + str_Selected + ">" + obj_pLista.Result[i].Nombre + "</option>"));
                 }
                 // ddlLocal.prop("disabled", true);
             }, null, null, null, 1);
    }
}



