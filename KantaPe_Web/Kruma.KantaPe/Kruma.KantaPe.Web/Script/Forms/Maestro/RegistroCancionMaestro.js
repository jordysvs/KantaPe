//Atributos
var urlPrincipal = 'CancionMaestro.aspx';
var urlEdicion = 'RegistroCancionMaestro.aspx';

$(function () {
    cargarInicial();
    cargarControles();
    obtenerCancion();
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
        return guardarCancion();
    });

    $(".btnCancelar").click(function () {
        ConfirmJQ('¿Está seguro de regresar a la ventana anterior?', function () { document.location.href = urlPrincipal });
        return false;
    });

    $("#txtDescripcion").focus();
}

function guardarCancion() {

    if ($('#frmContent').valid()) {

        obj_Cancion = new Object();
        obj_Cancion.IdCancion = $("#hdIdCancion").val();

        var str_Descripcion = $("#txtDescripcion").val().toLowerCase();

        //Tener en una cadena separado por espacios
        var str_Separador = str_Descripcion.split(" ");
        var str_DescripcionValidado = "";
        for (var i in str_Separador) {
            str_DescripcionValidado += str_Separador[i].substr(0, 1).toUpperCase() + str_Separador[i].substr(1) + " ";
        }
        obj_Cancion.Descripcion = str_DescripcionValidado;
        obj_Cancion.Estado = $("#ddlEstado").val();

        Accion('RegistroCancionMaestro.aspx/GuardarCancion', { "str_pCancion": JSON.stringify(obj_Cancion) },
            function () { document.location.href = urlPrincipal; });
    }

    return false;
}

function obtenerCancion() {
    var int_IdCancion = $("#hdIdCancion").val();
    if (int_IdCancion != '') {
        var obj_Cancion = ObtenerData("RegistroCancionMaestro.aspx/ObtenerCancion", { "int_pIdCancion": int_IdCancion });
        if (obj_Cancion != null) {
            $("#txtDescripcion").val(obj_Cancion.Descripcion);
            $("#ddlEstado").val(obj_Cancion.Estado);

            //Auditoria
            $("#ddUsuarioCreacion").html(obj_Cancion.UsuarioCreacion);
            $("#ddUsuarioModificacion").html(obj_Cancion.UsuarioModificacion);
            $("#ddFechaCreacion").html(ToDateTimeString(obj_Cancion.FechaCreacion));
            $("#ddFechaModificacion").html(ToDateTimeString(obj_Cancion.FechaModificacion));
        }
    }
}