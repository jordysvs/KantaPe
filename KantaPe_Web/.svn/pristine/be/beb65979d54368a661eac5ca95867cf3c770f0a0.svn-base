//Atributos
var urlPrincipal = 'Artista.aspx';
var urlEdicion = 'RegistroArtista.aspx';

$(function () {
    cargarInicial();
    cargarControles();
    obtenerArtista();
});

function cargarInicial() {

    jQuery.validator.addMethod('selectEstado', function (value) {
        return (value != '');
    }, "Seleccione el estado");

    $('#frmContent').validate({
        rules: {
            ctl00$cphBody$txtNombre: { required: true, },
            ctl00$cphBody$ddlEstado: { selectEstado: true }
        },
        messages: {
            ctl00$cphBody$txtNombre: { required: 'Ingrese el nombre' },
        },
        highlight: function (element) {
            $(element).closest('.form-group').removeClass('has-success').addClass('has-error');
        },
        success: function (element) {
            $(element).closest('.form-group').removeClass('has-error').addClass('has-success');
        }
    });
}

function cargarControles() {

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
            VerArchivoElemento('imgArtistaImagen', $("#hdIdAlmacen").val(), -1, obj_pResultado.ReturnId);
        }
    });

    $(".btnGrabar").click(function () {
        return guardarArtista();
    });

    $(".btnCancelar").click(function () {
        ConfirmJQ('¿Está seguro de regresar a la ventana anterior?', function () { document.location.href = urlPrincipal });
        return false;
    });

    //Eliminar Foto
    $("#lnkEliminarFoto").click(function () { ConfirmJQ('¿Está seguro de eliminar la foto?', EliminarFoto); });
    $("#lnkEliminarFoto").css('display', 'none');

    $("#txtNombre").focus();
}

function guardarArtista() {

    if ($('#frmContent').valid()) {

        obj_Artista = new Object();
        obj_Artista.IdArtista = $("#hdIdArtista").val();
        obj_Artista.Nombre = $("#txtNombre").val().toUpperCase();
        obj_Artista.Estado = $("#ddlEstado").val();

        //Eliminacion de la imagen
        var str_Ruta = $('#hdArtistaImagen').val();
        if (str_Ruta == $("#imgArtistaImagen").attr('src')) {
            obj_Artista.Foto = new Object();
            obj_Artista.Foto.IdAlmacen = $("#hdIdAlmacen").val();
            obj_Artista.Foto.IdRegistro = -1;
            obj_Artista.Foto.IdDocumento = null;
        }

        //Anexar Imagen
        if ($("#hdIdDocumento").val() != '') {
            obj_Artista.Foto = new Object();
            obj_Artista.Foto.IdAlmacen = $("#hdIdAlmacen").val();
            obj_Artista.Foto.IdRegistro = -1;
            obj_Artista.Foto.IdDocumento = $("#hdIdDocumento").val();
        }

        Accion('RegistroArtista.aspx/GuardarArtista', { "str_pArtista": JSON.stringify(obj_Artista) },
            function () { document.location.href = urlPrincipal; });
    }
    return false;
}

function obtenerArtista() {
    var int_IdArtista = $("#hdIdArtista").val();
    if (int_IdArtista != '') {
        var obj_Artista = ObtenerData("RegistroArtista.aspx/ObtenerArtista", { "int_pIdArtista": int_IdArtista });
        if (obj_Artista != null) {
            $("#txtNombre").val(obj_Artista.Nombre);
            $("#ddlEstado").val(obj_Artista.Estado);

            //Auditoria
            $("#ddUsuarioCreacion").html(obj_Artista.UsuarioCreacion);
            $("#ddUsuarioModificacion").html(obj_Artista.UsuarioModificacion);
            $("#ddFechaCreacion").html(ToDateTimeString(obj_Artista.FechaCreacion));
            $("#ddFechaModificacion").html(ToDateTimeString(obj_Artista.FechaModificacion));

            //Foto
            AccionValor('RegistroArtista.aspx/ObtenerImagenURL', { "int_pIdRegistro": obj_Artista.IdArtista },
            function (str_pUrl) {
                $("#lnkEliminarFoto").css('display', '');

                if (str_pUrl == '') {
                    str_pUrl = $("#hdArtistaImagen").val();
                    $("#lnkEliminarFoto").css('display', 'none');
                }
                $("#imgArtistaImagen").attr("src", str_pUrl);
            });
        }
    }
}

function EliminarFoto() {
    $("#hdIdDocumento").val('');
    var str_Ruta = $('#hdArtistaImagen').val();
    $("#imgArtistaImagen").attr('src', str_Ruta);
    $("#lnkEliminarFoto").css('display', 'none');
}