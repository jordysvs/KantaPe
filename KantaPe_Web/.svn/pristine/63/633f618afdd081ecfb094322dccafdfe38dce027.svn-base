//Atributos
var urlPrincipal = 'Album.aspx';
var urlEdicion = 'RegistroAlbum.aspx';

$(function () {
    CargarInicial();
    CargarControles();
    ObtenerAlbum();
});

function CargarInicial() {

    jQuery.validator.addMethod('selectArtista', function (value) {
        return ($("#hdIdArtista").val() != '');
    }, "Seleccione una artista");


    jQuery.validator.addMethod('selectEstado', function (value) {
        return (value != '');
    }, "Seleccione el estado");

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
        return GuardarAlbum();
    });

    $(".btnCancelar").click(function () {
        ConfirmJQ('¿Está seguro de regresar a la ventana anterior?', function () { document.location.href = urlPrincipal });
        return false;
    });

    //Eliminar Foto
    $("#lnkEliminarFoto").click(function () { ConfirmJQ('¿Está seguro de eliminar la foto?', EliminarFoto); });
    $("#lnkEliminarFoto").css('display', 'none');

    //Busqueda Artista
    $("#btnArtista_find").click(function () {
        var obj_modal = $("#mdBuscadorArtista").modal('show', {
            backdrop: true,
            keyboard: false,
        });

        $('#mdBuscadorArtista').on('shown.bs.modal', function () {
            $("#txtNombreBuscadorArtista").focus();
        });

        ListarBusquedaArtista(1);
    });

    $("#btnArtista_remove").click(function () {
        $("#hdIdArtista").val('');
        $("#txtArtista_input").val('');
    });

    $("#mdBuscadorArtista").find('.modal-footer .btn-aceptar').click(function () {
        var obj_Registro = ObtenerRegistroBuscadorArtista();
        if (obj_Registro != null) {
            $("#hdIdArtista").val(obj_Registro.id);
            $("#txtArtista_input").val(obj_Registro.descripcion);
            $("#mdBuscadorArtista").modal('hide');
        }
    });

    $("#mdBuscadorArtista").find('.modal-footer .btn-cancelar').click(function () {
        $("#mdBuscadorArtista").modal('hide');
    });

    //fin BuscadorArtista

    $("#txtTitulo").focus();
}

function ValidacionAlbum() {
    var settings = $('#frmContent').validate().settings;
    $('.form-group').removeClass('has-error').removeClass('has-success');
    $.extend(settings, {
        ignore: "",
        rules: {
            ctl00$cphBody$txtArtista_input: { selectArtista: true },
            ctl00$cphBody$txtTitulo: { required: true, },
            ctl00$cphBody$ddlEstado: { selectEstado: true }
        },
        messages: {
            ctl00$cphBody$txtTitulo: { required: 'Ingrese el titulo' },
        },
    });
}

function GuardarAlbum() {

    $("#txtArtista_input").prop('readonly', false);
    ValidacionAlbum();
    var blnValid = $('#frmContent').valid();
    $("#txtArtista_input").prop('readonly', true);

    if ($('#frmContent').valid()) {

        obj_Album = new Object();
        obj_Album.IdAlbum = $("#hdIdAlbum").val();
        obj_Album.IdArtista = $("#hdIdArtista").val();

        var str_Descripcion = $("#txtTitulo").val().toLowerCase();

        //Tener en una cadena separado por espacios
        var str_Separador = str_Descripcion.split(" ");
        var str_DescripcionValidado = "";
        for (var i in str_Separador) {
            str_DescripcionValidado += str_Separador[i].substr(0, 1).toUpperCase() + str_Separador[i].substr(1) + " ";
        }


        obj_Album.Titulo = str_DescripcionValidado;
        obj_Album.Estado = $("#ddlEstado").val();

        //Eliminacion de la imagen
        var str_Ruta = $('#hdAlbumImagen').val();
        if (str_Ruta == $("#imgAlbumImagen").attr('src')) {
            obj_Album.Foto = new Object();
            obj_Album.Foto.IdAlmacen = $("#hdIdAlmacen").val();
            obj_Album.Foto.IdRegistro = -1;
            obj_Album.Foto.IdDocumento = null;
        }

        //Anexar Imagen
        if ($("#hdIdDocumento").val() != '') {
            obj_Album.Foto = new Object();
            obj_Album.Foto.IdAlmacen = $("#hdIdAlmacen").val();
            obj_Album.Foto.IdRegistro = -1;
            obj_Album.Foto.IdDocumento = $("#hdIdDocumento").val();
        }

        Accion('RegistroAlbum.aspx/GuardarAlbum', { "str_pAlbum": JSON.stringify(obj_Album) },
            function () { document.location.href = urlPrincipal; });
    }
    return false;
}

function ObtenerAlbum() {
    var int_IdAlbum = $("#hdIdAlbum").val();
    if (int_IdAlbum != '') {
        var obj_Album = ObtenerData("RegistroAlbum.aspx/ObtenerAlbum", { "int_pIdAlbum": int_IdAlbum });
        if (obj_Album != null) {

            //Album
            $("#hdIdArtista").val(obj_Album.IdArtista);
            $("#txtArtista_input").val(obj_Album.Artista.Nombre);
            $("#txtTitulo").val(obj_Album.Titulo);
            $("#ddlEstado").val(obj_Album.Estado);

            //Auditoria
            $("#ddUsuarioCreacion").html(obj_Album.UsuarioCreacion);
            $("#ddUsuarioModificacion").html(obj_Album.UsuarioModificacion);
            $("#ddFechaCreacion").html(ToDateTimeString(obj_Album.FechaCreacion));
            $("#ddFechaModificacion").html(ToDateTimeString(obj_Album.FechaModificacion));

            //Foto
            AccionValor('RegistroAlbum.aspx/ObtenerImagenURL', { "int_pIdRegistro": obj_Album.IdAlbum },
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