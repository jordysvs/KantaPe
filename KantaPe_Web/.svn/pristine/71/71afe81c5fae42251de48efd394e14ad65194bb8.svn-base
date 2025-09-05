//Atributos
var urlPrincipal = 'Genero.aspx';
var urlEdicion = 'RegistroGenero.aspx';

$(function () {
    cargarInicial();
    cargarControles();
    obtenerGenero();
});

function cargarInicial() {

    jQuery.validator.addMethod('selectEstado', function (value) {
        return (value != '');
    }, "Seleccione el estado");

    $('#frmContent').validate({
        rules: {
            ctl00$cphBody$txtDescripcion: { required: true, },
            ctl00$cphBody$ddlEstado: { selectEstado: true }
        },
        messages: {
            ctl00$cphBody$txtDescripcion: { required: 'Ingrese la descripción' },
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

    $(".btnGrabar").click(function () {
        return guardarGenero();
    });

    $(".btnCancelar").click(function () {
        ConfirmJQ('¿Está seguro de regresar a la ventana anterior?', function () { document.location.href = urlPrincipal });
        return false;
    });

    $("#txtDescripcion").focus();
}

function guardarGenero() {

    if ($('#frmContent').valid()) {

        obj_Genero = new Object();
        obj_Genero.IdGenero = $("#hdIdGenero").val();

        var str_Descripcion = $("#txtDescripcion").val().toLowerCase();

        //Tener en una cadena separado por espacios
        var str_Separador = str_Descripcion.split(" ");
        var str_DescripcionValidado = "";
        for (var i in str_Separador) {
            str_DescripcionValidado += str_Separador[i].substr(0, 1).toUpperCase() + str_Separador[i].substr(1) + " ";
        }
        obj_Genero.Descripcion = str_DescripcionValidado;
        obj_Genero.Estado = $("#ddlEstado").val();

        Accion('RegistroGenero.aspx/GuardarGenero', { "str_pGenero": JSON.stringify(obj_Genero) },
            function () { document.location.href = urlPrincipal; });
    }

    return false;
}

function obtenerGenero() {
    var int_IdGenero = $("#hdIdGenero").val();
    if (int_IdGenero != '') {
        var obj_Genero = ObtenerData("RegistroGenero.aspx/ObtenerGenero", { "int_pIdGenero": int_IdGenero });
        if (obj_Genero != null) {
            $("#txtDescripcion").val(obj_Genero.Descripcion);
            $("#ddlEstado").val(obj_Genero.Estado);

            //Auditoria
            $("#ddUsuarioCreacion").html(obj_Genero.UsuarioCreacion);
            $("#ddUsuarioModificacion").html(obj_Genero.UsuarioModificacion);
            $("#ddFechaCreacion").html(ToDateTimeString(obj_Genero.FechaCreacion));
            $("#ddFechaModificacion").html(ToDateTimeString(obj_Genero.FechaModificacion));
        }
    }
}