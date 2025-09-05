//Atributos
var urlPrincipal = 'NuevasCanciones.aspx';
var urlEdicion = 'AprobarSolicitud.aspx';
var int_NumPagina = 1;
var int_TamPagina = 10;
var int_PagMostrar = 9;

$(function () {
    CargarInicial();
    CargarControles();
    ObtenerCancion();
});

function CargarInicial() {

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
    jQuery.validator.addMethod('Album', function (value) {
        if ($("#txtDescripcionAlbum").is(":disabled"))
            return true;
        else if (value != "")
            return true;
    }, "Ingrese el album");
    //jQuery.validator.addMethod('SelectAlbumModal', function (value) {
    //    if ($("#ddlArtistaAlbum").is(":disabled"))
    //        return true;
    //    else if (value != "")
    //        return true;
    //}, "Ingrese el album");
    jQuery.validator.addMethod('SelectAlbumModal', function (value) {
        return (value != null);
    }, "Seleccione un artista");

    var settings = $('#frmContent').validate().settings;
    $.extend(settings, {
        highlight: function (element) {
            $(element).closest('.form-group').removeClass('has-success').addClass('has-error');
        },
        success: function (element) {
            $(element).closest('.form-group').removeClass('has-error').addClass('has-success');
        }
    });
}

function CargarControles() {
    //controles
    $("#fileUpload").fileserver(
    {
        idAlmacen: $("#hdIdAlmacen").val(),
        idRegistro: -1,
        autoUpload: true,
        replace: true,
        successMessage: false,
        success: function (obj_pResultado) {
            $("#lnkEliminarFoto").css('display', '');
            $("#hdIdDocumento").val(obj_pResultado.ReturnId);
            VerArchivoElemento('imgAlbumImagen', $("#hdIdAlmacen").val(), -1, obj_pResultado.ReturnId);
        }
    });

    
    

    $(".btnGrabar").click(function () {
        return GuardarCancion();
    });

    $(".btnCancelar").click(function () {
        ConfirmJQ('¿Está seguro de regresar a la ventana anterior?', function () { document.location.href = urlPrincipal });
        return false;
    });

    //Eliminar Foto
    $("#lnkEliminarFoto").click(function () { ConfirmJQ('¿Está seguro de eliminar la foto?', EliminarFoto); });
    $("#lnkEliminarFoto").css('display', 'none');

    //Busqueda Album    
    $("#btnAlbum_find").click(function () {
        var obj_modal = $("#mdBuscadorAlbum").modal('show', {
            backdrop: true,
            keyboard: false,
        });

        $('#mdBuscadorAlbum').on('shown.bs.modal', function () {
            $("#txtNombreBuscadorAlbum").focus();
        });

        ListarBusquedaAlbum(1);
    });

    $("#btnAlbum_remove").click(function () {
        $("#hdIdArtista").val('');
        $("#hdIdAlbum").val('');
        $("#txtAlbum_input").val('');
    });

    $("#mdBuscadorAlbum").find('.modal-footer .btn-aceptar').click(function () {
        var obj_Registro = ObtenerRegistroBuscadorAlbum();
        if (obj_Registro != null) {
            $("#hdIdArtista").val(obj_Registro.idArtista);
            $("#hdIdAlbum").val(obj_Registro.idAlbum);
            $("#txtAlbum_input").val(obj_Registro.artistaAlbum);
            $("#mdBuscadorAlbum").modal('hide');
        }
    });

    $("#mdBuscadorAlbum").find('.modal-footer .btn-cancelar').click(function () {
        $("#mdBuscadorAlbum").modal('hide');
    });
    //fin BuscadorAlbum

    $("#txtTitulo").focus();

    $('#ddlEmpresa').change(function () {
        CargarLocal(true, null);
    });

    //---------------CANCIÓN-------------------
    $("#btnCancion_add").click(function () {
        $("#txtDescripcionCancion").val('');
        var obj_modal = $("#mdCancion").modal('show', {
            backdrop: true,
            keyboard: false,
        });
        $('#mdCancion').on('shown.bs.modal', function () {
            $("#txtDescripcionCancion").focus();
        });
        return false;
    });

    $("#mdCancion").find('.modal-footer .btn-aceptar').click(function () {
        GuardarCancionSimple();
    });

    $("#mdCancion").find('.modal-footer .btn-cancelar').click(function () {
        $("#mdCancion").modal('hide');
    });

    //------------Genero--------------
    $("#btnGenero_add").click(function () {
        $("#txtDescripcionGenero").val('');
        var obj_modal = $("#mdGenero").modal('show', {
            backdrop: true,
            keyboard: false,
        });
        $('#mdGenero').on('shown.bs.modal', function () {
            $("#txtDescripcionGenero").focus();
        });
        return false;
    });

    $("#mdGenero").find('.modal-footer .btn-aceptar').click(function () {
        GuardarGenero();
    });

    $("#mdGenero").find('.modal-footer .btn-cancelar').click(function () {
        $("#mdGenero").modal('hide');
    });

    //---------------IDIOMA-------------------
    $("#btnIdioma_add").click(function () {
        $("#txtDescripcionIdioma").val('');
        var obj_modal = $("#mdIdioma").modal('show', {
            backdrop: true,
            keyboard: false,
        });
        $('#mdIdioma').on('shown.bs.modal', function () {
            $("#txtDescripcionIdioma").focus();
        });
        return false;
    });

    $("#mdIdioma").find('.modal-footer .btn-aceptar').click(function () {
        GuardarIdioma();
    });

    $("#mdIdioma").find('.modal-footer .btn-cancelar').click(function () {
        $("#mdIdioma").modal('hide');
    });

    //---------------ARTISTA-------------------
    $("#btnArtista_add").click(function () {
        $("#txtDescripcionArtista").val('');
        var obj_modal = $("#mdArtista").modal('show', {
            backdrop: true,
            keyboard: false,
        });
        $('#mdArtista').on('shown.bs.modal', function () {
            $("#txtDescripcionArtista").focus();
        });
        return false;
    });

    $("#mdArtista").find('.modal-footer .btn-aceptar').click(function () {
        GuardarArtista();
    });

    $("#mdArtista").find('.modal-footer .btn-cancelar').click(function () {
        $("#mdArtista").modal('hide');
    });

    //---------------ALBUM-------------------
    $("#btnAlbum_add").click(function () {
        $("#txtDescripcionAlbum").val('');
        var obj_modal = $("#mdAlbum").modal('show', {
            backdrop: true,
            keyboard: false,
        });
        $('#mdAlbum').on('shown.bs.modal', function () {
            $("#txtDescripcionAlbum").focus();
        });
        return false;
    });

    $("#mdAlbum").find('.modal-footer .btn-aceptar').click(function () {
        GuardarAlbum();
    });

    $("#mdAlbum").find('.modal-footer .btn-cancelar').click(function () {
        $("#mdAlbum").modal('hide');
    });
    ListarNuevasCanciones(1);
    InicializarCancionBuscador(null);
    InicializarGeneroBuscador(null);
    InicializarIdiomaBuscador(null);
    InicializarArtistaBuscador(null);
    InicializarAlbumBuscador(null);
    InicializarArtistaAlbumBuscador(null);

}

function ValidacionCancion() {
    var settings = $('#frmContent').validate().settings;
    $('.form-group').removeClass('has-error').removeClass('has-success');
    $.extend(settings, {
        ignore: "",
        rules: {

            ddlCancion: { selectCancion: true },
            ddlGenero: { selectGenero: true },
            ddlIdioma: { selectIdioma: true },
            ddlArtista: { selectArtista: true },

            //ctl00$cphBody$ddlEstado: { selectEstado: true },

        },
        messages: {
            ctl00$cphBody$txtTitulo: { required: 'Ingrese la cancion' }
        },
    });


}


function GuardarCancion() {

    $("#txtAlbum_input").prop('readonly', false);
    ValidacionCancion();
    var blnValid = $('#frmContent').valid();
    $("#txtAlbum_input").prop('readonly', true);

    if ($('#frmContent').valid()) {

        obj_Cancion = new Object();
        obj_Cancion.IdCancion = null;
        if ($("#hdIdCancion").val() != '')
            obj_Cancion.IdCancion = $("#hdIdCancion").val();

        obj_Cancion.IdCancion = $("#ddlCancion").val();
        obj_Cancion.IdArtista = $("#ddlArtista").val();
        obj_Cancion.IdAlbum = $("#ddlAlbum").val();
        obj_Cancion.IdGenero = $("#ddlGenero").val();
        obj_Cancion.IdIdioma = $("#ddlIdioma").val();
        obj_Cancion.IdEmpresa = $("#ddlEmpresa").val();
        obj_Cancion.IdLocal = $("#ddlLocal").val();
        var IdSolicitudCancion = $("#hdIdSolicitudCancion").val();
        //obj_Cancion.IdCancionSolicitud = IdSolicitudCancion;


        obj_Cancion.Decada = null;
        if ($("#txtDecada").val() != '')
            obj_Cancion.Decada = $("#txtDecada").val();

        obj_Cancion.Version = null;
        if ($("#txtVersion").val() != '')
            obj_Cancion.Version = $("#txtVersion").val();

        obj_Cancion.NombreArchivo = null;
        if ($("#txtNombreArchivo").val() != '')
            obj_Cancion.NombreArchivo = $("#txtNombreArchivo").val();

        obj_Cancion.Anio = null;
        if ($("#txtAnio").val() != '')
            obj_Cancion.Anio = $("#txtAnio").val();

        obj_Cancion.Letra = null;
        if ($("#txtLetra").val() != '')
            obj_Cancion.Letra = $("#txtLetra").val();

        obj_Cancion.Duracion = null;
        if ($("#txtDuracion").val() != '')
            obj_Cancion.Duracion = $("#txtDuracion").val();

        obj_Cancion.Youtube = null;
        if ($("#txtYoutube").val() != '')
            obj_Cancion.Youtube = $("#txtYoutube").val();

        obj_Cancion.Estado = $("#ddlEstado").val();

        //Eliminacion de la imagen
        var str_Ruta = $('#hdAlbumImagen').val();
        if (str_Ruta == $("#imgAlbumImagen").attr('src')) {
            obj_Cancion.Foto = new Object();
            obj_Cancion.Foto.IdAlmacen = $("#hdIdAlmacen").val();
            obj_Cancion.Foto.IdRegistro = -1;
            obj_Cancion.Foto.IdDocumento = null;
        }

        //Anexar Imagen
        if ($("#hdIdDocumento").val() != '') {
            obj_Cancion.Foto = new Object();
            obj_Cancion.Foto.IdAlmacen = $("#hdIdAlmacen").val();
            obj_Cancion.Foto.IdRegistro = -1;
            obj_Cancion.Foto.IdDocumento = $("#hdIdDocumento").val();
        }

        Accion('AprobarSolicitud.aspx/GuardarCancion', { "str_pCancion": JSON.stringify(obj_Cancion), "int_pIdSolicitudCancion": IdSolicitudCancion },
            function () { document.location.href = urlPrincipal; });
    }
    return false;
}

function ObtenerCancion() {
    var int_IdCancion = $("#hdIdCancion").val();
    if (int_IdCancion != '') {
        var obj_Cancion = ObtenerData("AprobarSolicitud.aspx/ObtenerCancion", { "int_pIdCancion": int_IdCancion });
        if (obj_Cancion != null) {
            $("#txtTitulo").val(obj_Cancion.Titulo);
            $("#hdIdArtista").val(obj_Cancion.IdArtista);
            $("#hdIdAlbum").val(obj_Cancion.IdAlbum);
            $("#txtAlbum_input").val(obj_Cancion.Artista.Nombre + " - " + obj_Cancion.Album.Titulo);
            $("#ddlGenero").val(obj_Cancion.IdGenero);
            $("#ddlIdioma").val(obj_Cancion.IdIdioma);
            $("#txtDecada").val(obj_Cancion.Decada);
            $("#txtVersion").val(obj_Cancion.Version);
            $("#txtNombreArchivo").val(obj_Cancion.NombreArchivo);
            $("#txtAnio").val(obj_Cancion.Anio);
            $("#txtLetra").val(obj_Cancion.Letra);
            $("#txtDuracion").val(obj_Cancion.Duracion);
            $("#txtYoutube").val(obj_Cancion.Youtube);
            $("#hdIdCancionSolicitud").val(obj_Cancion.IdCancionSolicitud);
            $("#txtCancionSolicitud").val(obj_Cancion.CancionSolicitud.Descripcion);
            $("#ddlEstado").val(obj_Cancion.Estado);
            $("#ddlEmpresa").val(obj_Cancion.IdEmpresa);
            $("#ddlLocal").val(obj_Cancion.IdLocal);

            //Auditoria
            $("#ddUsuarioCreacion").html(obj_Cancion.UsuarioCreacion);
            $("#ddUsuarioModificacion").html(obj_Cancion.UsuarioModificacion);
            $("#ddFechaCreacion").html(ToDateTimeString(obj_Cancion.FechaCreacion));
            $("#ddFechaModificacion").html(ToDateTimeString(obj_Cancion.FechaModificacion));

            //Foto
            AccionValor('RegistroCancion.aspx/ObtenerImagenURL', { "int_pIdRegistro": obj_Cancion.IdAlbum },
            function (str_pUrl) {
                $("#lnkEliminarFoto").css('display', '');

                if (str_pUrl == '') {
                    str_pUrl = $("#hdAlbumImagen").val();
                    $("#lnkEliminarFoto").css('display', 'none');
                }
                $("#imgAlbumImagen").attr("src", str_pUrl);
            });
        }
    }
}
function EliminarFoto() {
    $("#hdIdDocumento").val('');
    var str_Ruta = $('#hdAlbumImagen').val();
    $("#imgAlbumImagen").attr('src', str_Ruta);
    $("#lnkEliminarFoto").css('display', 'none');
}


function CargarLocal(bln_pAsync, int_pIdDireccion) {

    var ddlLocal = $("#ddlLocal");
    ddlLocal.empty();
    ddlLocal.html('');
    ddlLocal.append($("<option value=''>--Seleccione--</option>"));

    var int_IdPersona = $("#ddlEmpresa").val();
    if (int_IdPersona != '') {
        var obj_Data = { "int_pIdPersona": int_IdPersona };
        AccionDefault(bln_pAsync, "AprobarSolicitud.aspx/ListarLocal", obj_Data,
             function (obj_pLista) {
                 //ddlNivel.prop("disabled", false);
                 var str_Selected = '';
                 for (var i = 0; i < obj_pLista.Result.length; i++) {
                     if (int_pIdDireccion != null)
                         str_Selected = (obj_pLista.Result[i].IdDireccion == IdDireccion) ? 'selected' : '';
                     ddlLocal.append($("<option value='" + obj_pLista.Result[i].IdDireccion + "' " + str_Selected + ">" + obj_pLista.Result[i].Direccion + "</option>"));
                 }
                 // ddlLocal.prop("disabled", true);
             }, null, null, null, 1);
    }
}

//-----------------------------AUTOCOMPLETAR-----------------------------
function InicializarCancionBuscador(obj_pData) {
    //Buscador de genero
    $ddlCancion =
        $("#ddlCancion").select2({
            data: obj_pData,
            language: "es",
            multiple: false,
            width: '85%',
            allowClear: true,
            minimumInputLength: 3,
            placeholder: "Ingrese la cancion",
            escapeMarkup: function (markup) { return markup; },
            ajax: {
                url: "AprobarSolicitud.aspx/ListarCancion",
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
function InicializarGeneroBuscador(obj_pData) {
    //Buscador de genero
    $ddlGenero =
        $("#ddlGenero").select2({
            data: obj_pData,
            language: "es",
            multiple: false,
            width: '85%',
            allowClear: true,
            minimumInputLength: 3,
            placeholder: "Ingrese el genero",
            escapeMarkup: function (markup) { return markup; },
            ajax: {
                url: "AprobarSolicitud.aspx/ListarGenero",
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
    $ddlIdioma =
        $("#ddlIdioma").select2({
            data: obj_pData,
            language: "es",
            multiple: false,
            width: '85%',
            allowClear: true,
            minimumInputLength: 3,
            placeholder: "Ingrese el idioma",
            escapeMarkup: function (markup) { return markup; },
            ajax: {
                url: "AprobarSolicitud.aspx/ListarIdioma",
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

function InicializarArtistaBuscador(obj_pData) {
    //Buscador de genero
    $ddlArtista =
        $("#ddlArtista").select2({
            data: obj_pData,
            language: "es",
            multiple: false,
            width: '85%',
            allowClear: true,
            minimumInputLength: 3,
            placeholder: "Ingrese el artista",
            escapeMarkup: function (markup) { return markup; },
            ajax: {
                url: "AprobarSolicitud.aspx/ListarArtista",
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

function InicializarAlbumBuscador(obj_pData) {
    //Buscador de idioma
    $ddlAlbum =
        $("#ddlAlbum").select2({
            data: obj_pData,
            language: "es",
            multiple: false,
            width: '85%',
            allowClear: true,
            minimumInputLength: 3,
            placeholder: "Ingrese el album",
            escapeMarkup: function (markup) { return markup; },
            ajax: {
                url: "AprobarSolicitud.aspx/ListarAlbum",
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                delay: 250,
                type: "POST",
                data: function (params) {
                    return JSON.stringify({
                        str_pDescripcion: (params.term || '').trim(),
                        int_pNumPagina: params.page || 1,
                        int_pTamPagina: 10,
                        int_IdArtista: ($("#ddlArtista").val() == null ? -1 : $("#ddlArtista").val()),

                    });
                },
                processResults: function (data, params) {
                    var lst_Results = [];
                    $.each(data.d.Result, function (i, v) {
                        var obj_Resultado = {};
                        obj_Resultado.id = v.IdAlbum;
                        obj_Resultado.descripcion = v.Titulo;
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
    $('#ddlArtista').on('select2:select', function (evt) {
        $ddlAlbum.val(null).trigger("change");

    });
}
function InicializarArtistaAlbumBuscador(obj_pData) {
    //Buscador de idioma
    $ddlArtistaAlbum =
        $("#ddlArtistaAlbum").select2({
            data: obj_pData,
            language: "es",
            multiple: false,
            width: '85%',
            allowClear: true,
            minimumInputLength: 3,
            placeholder: "Ingrese el artista",
            escapeMarkup: function (markup) { return markup; },
            ajax: {
                url: "AprobarSolicitud.aspx/ListarArtista",
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
function ValidacionAlbum() {
    var settings = $('#frmContent').validate().settings;
    $('.form-group').removeClass('has-error').removeClass('has-success');
    $.extend(settings, {
        ignore: "",
        rules: {
            ctl00$cphBody$txtDescripcionAlbum: { Album: true },
            ddlArtistaAlbum: { selectAlbumModal: true }
        },
        messages: {
        },
    });
}
//---------------------AGREGAR------------------
function GuardarCancionSimple() {
    ValidacionCancionSimple();
    if ($('#frmContent').valid()) {

        var str_Descripcion = $("#txtDescripcionCancion").val().toLowerCase();


        //Tener en una cadena separado por espacios
        var str_Separador = str_Descripcion.split(" ");
        var str_DescripcionValidado = "";
        for (var i in str_Separador) {
            str_DescripcionValidado += str_Separador[i].substr(0, 1).toUpperCase() + str_Separador[i].substr(1) + " ";
        }
        AccionDefault(true, "AprobarSolicitud.aspx/AgregarCancion", { "str_pDescripcion": str_DescripcionValidado },
            function (obj_pResultado) {
                var lst_Centro = [];
                var obj_Centro = new Object();
                obj_Centro.id = obj_pResultado.ReturnId;
                obj_Centro.descripcion = str_DescripcionValidado;
                lst_Centro.push(obj_Centro);

                $("#ddlCancion").select2('destroy');
                InicializarCancionBuscador(lst_Centro);
                $ddlCancion.val(obj_Centro.id).trigger('change');
                $("#mdCancion").modal('hide');
            }
            , null, null, null, 0);
    }
    return false;
}
function GuardarGenero() {
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
        var str_Descripcion = $("#txtDescripcionGenero").val().toLowerCase();
        //Tener en una cadena separado por espacios
        var str_Separador = str_Descripcion.split(" ");
        var str_DescripcionValidado = "";
        for (var i in str_Separador) {
            str_DescripcionValidado += str_Separador[i].substr(0, 1).toUpperCase() + str_Separador[i].substr(1) + " ";
        }

        AccionDefault(true, "AprobarSolicitud.aspx/AgregarGenero", { "str_pDescripcion": str_DescripcionValidado },
            function (obj_pResultado) {
                var lst_Centro = [];
                var obj_Centro = new Object();
                obj_Centro.id = obj_pResultado.ReturnId;
                obj_Centro.descripcion = str_DescripcionValidado;
                lst_Centro.push(obj_Centro);

                $("#ddlGenero").select2('destroy');
                InicializarGeneroBuscador(lst_Centro);
                $ddlGenero.val(obj_Centro.id).trigger('change');
                $("#mdGenero").modal('hide');
            }
            , null, null, null, 0);
    }
    return false;
}
function GuardarIdioma() {
    ValidacionIdioma();
    if ($('#frmContent').valid()) {
        var str_Descripcion = $("#txtDescripcionIdioma").val().toLowerCase();

        //Tener en una cadena separado por espacios
        var str_Separador = str_Descripcion.split(" ");
        var str_DescripcionValidado = "";
        for (var i in str_Separador) {
            str_DescripcionValidado += str_Separador[i].substr(0, 1).toUpperCase() + str_Separador[i].substr(1) + " ";
        }
        AccionDefault(true, "AprobarSolicitud.aspx/AgregarIdioma", { "str_pDescripcion": str_DescripcionValidado },
            function (obj_pResultado) {
                var lst_Centro = [];
                var obj_Centro = new Object();
                obj_Centro.id = obj_pResultado.ReturnId;
                obj_Centro.descripcion = str_DescripcionValidado;
                lst_Centro.push(obj_Centro);

                $("#ddlIdioma").select2('destroy');
                InicializarIdiomaBuscador(lst_Centro);
                $ddlIdioma.val(obj_Centro.id).trigger('change');
                $("#mdIdioma").modal('hide');
            }
            , null, null, null, 0);
    }
    return false;
}
function GuardarArtista() {
    ValidacionArtista();
    if ($('#frmContent').valid()) {
        var str_Descripcion = $("#txtDescripcionArtista").val().toUpperCase();
        AccionDefault(true, "AprobarSolicitud.aspx/AgregarArtista", { "str_pDescripcion": str_Descripcion },
            function (obj_pResultado) {
                var lst_Centro = [];
                var obj_Centro = new Object();
                obj_Centro.id = obj_pResultado.ReturnId;
                obj_Centro.descripcion = str_Descripcion;
                lst_Centro.push(obj_Centro);

                $("#ddlArtista").select2('destroy');
                InicializarArtistaBuscador(lst_Centro);
                $("#mdArtista").modal('hide');
                $ddlArtista.val(obj_Centro.id).trigger('change');
            }
            , null, null, null, 0);
    }
    return false;
}

function GuardarAlbum() {
    ValidacionAlbum();
    if ($('#frmContent').valid()) {
        var str_Descripcion = $("#txtDescripcionAlbum").val().toLowerCase();
        var int_Artista = $("#ddlArtista").val();

        //Tener en una cadena separado por espacios
        var str_Separador = str_Descripcion.split(" ");
        var str_DescripcionValidado = "";
        for (var i in str_Separador) {
            str_DescripcionValidado += str_Separador[i].substr(0, 1).toUpperCase() + str_Separador[i].substr(1) + " ";
        }

        AccionDefault(true, "AprobarSolicitud.aspx/AgregarAlbum", {
            "str_pDescripcion": str_DescripcionValidado,
            "int_pIdArtista": int_Artista
        },
            function (obj_pResultado) {
                var lst_Centro = [];
                var obj_Centro = new Object();
                obj_Centro.id = obj_pResultado.ReturnId;
                obj_Centro.descripcion = str_DescripcionValidado;
                obj_Centro.idartista = int_Artista;
                lst_Centro.push(obj_Centro);

                $("#ddlAlbum").select2('destroy');
                InicializarAlbumBuscador(lst_Centro);
                $ddlAlbum.val(obj_Centro.id).trigger('change');
                $("#mdAlbum").modal('hide');
            }
            , null, null, null, 0);
    }
    return false;
}


function ListarNuevasCanciones(int_pNumPagina) {
    int_NumPagina = int_pNumPagina;
    //var obj_Filtro = ObtenerFiltros();
    var obj_Data = {

        "int_pIdSolicitudCancion": $("#hdIdSolicitudCancion").val()
    };
    AccionDefault(true, "AprobarSolicitud.aspx/ListarCancionesNuevas", obj_Data, CargarGrilla, null, null, null, 1);
}

function CargarGrilla(obj_pLista) {

    var obj_TablaPrincipal = $("<table id='tblCancion' class='table table-bordered table-hover dt-responsive'></table>");
    var obj_THead = $("<thead></thead>");
    var obj_FilaPrincipal = $("<tr></tr>");
    obj_FilaPrincipal.append($("<th style='width:10%;'>Cancion</th>"));
    obj_FilaPrincipal.append($("<th style='width:10%;'>Artista</th>"));
    obj_FilaPrincipal.append($("<th style='width:10%;'>Album</th>"));
    obj_FilaPrincipal.append($("<th style='width:10%;'>Idioma</th>"));
    obj_FilaPrincipal.append($("<th style='width:10%;'>Genero</th>"));
    obj_FilaPrincipal.append($("<th style='width:10%;'>Youtube</th>"));
    obj_FilaPrincipal.append($("<th style='width:10%;'>Estado</th>"));
    obj_THead.append(obj_FilaPrincipal);
    obj_TablaPrincipal.append(obj_THead);

    var str_Cancion = '';
    var str_Artista = '';
    var str_Album = '';
    var str_Idioma = '';
    var str_Genero = '';
    var str_Youtube = '';
    var str_Estado = '';

    var obj_TBody = $("<tbody></tbody>");
    for (var i = 0; i < obj_pLista.Result.length; i++) {

        str_Cancion = '';
        str_Artista = '';
        str_Album = '';
        str_Idioma = '';
        str_Genero = '';
        str_Youtube = '';
        str_Estado = '';

        obj_FilaPrincipal = $("<tr value='" + obj_pLista.Result[i].IdSolicitudCancion + "'></tr>");

        if (obj_pLista.Result[i].Cancion != null)
            str_Cancion = obj_pLista.Result[i].Cancion;
        obj_FilaPrincipal.append($("<td>" + str_Cancion + "</td>"));

        if (obj_pLista.Result[i].Artista != null)
            str_Artista = obj_pLista.Result[i].Artista;
        obj_FilaPrincipal.append($("<td>" + str_Artista + "</td>"));

        if (obj_pLista.Result[i].Album != null)
            str_Album = obj_pLista.Result[i].Album;
        obj_FilaPrincipal.append($("<td>" + str_Album + "</td>"));

        if (obj_pLista.Result[i].Idioma != null)
            str_Idioma = obj_pLista.Result[i].Idioma;
        obj_FilaPrincipal.append($("<td>" + str_Idioma + "</td>"));

        if (obj_pLista.Result[i].Genero != null)
            str_Genero = obj_pLista.Result[i].Genero;
        obj_FilaPrincipal.append($("<td>" + str_Genero + "</td>"));

        if (obj_pLista.Result[i].Youtube != null)
            str_Youtube = obj_pLista.Result[i].Youtube;
        obj_FilaPrincipal.append($("<td>" + str_Youtube + "</td>"));

        if (obj_pLista.Result[i].Estado == 'R')
            str_Estado = "Rechazado";
        if (obj_pLista.Result[i].Estado == 'A')
            str_Estado = "Aprobado";
        if (obj_pLista.Result[i].Estado == 'P')
            str_Estado = "Pendiente";

        obj_FilaPrincipal.append($("<td style='text-align:center'>" + str_Estado + "</td>"));

        obj_TBody.append(obj_FilaPrincipal);

    }
    obj_TablaPrincipal.append(obj_TBody);


    $("#divGrilla").html('');
    $("#divGrilla").append(obj_TablaPrincipal);

    var obj_Tabla = $('#tblCancion').dataTable({
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

    $('#tblCancion tbody').on('click', 'tr', function () {
        if ($(this).hasClass('selected')) {
            $(this).removeClass('selected');
        }
        else {
            obj_Tabla.$('tr.selected').removeClass('selected');
            $(this).addClass('selected');
        }
    });
}
