var urlPrincipal = 'Insumo.aspx';
var urlEdicion = 'RegistroInsumo.aspx';

$(function () {
    CargarInicial();
    CargarControles();
    ObtenerInsumo();
});

function CargarInicial() {

    jQuery.validator.addMethod('selectUnidadMedida', function (value) {
        return (value != '');
    }, "Seleccione la unidad de medida");

    jQuery.validator.addMethod('selectEstado', function (value) {
        return (value != '');
    }, "Seleccione el estado");

    $('#frmContent').validate({
        rules: {
            ctl00$cphBody$txtCodigo: { required: true, },
            ctl00$cphBody$txtDescripcion: { required: true, },
            ctl00$cphBody$ddlUnidadMedida: { selectUnidadMedida: true },
            ctl00$cphBody$ddlEstado: { selectEstado: true }
        },
        messages: {
            ctl00$cphBody$txtCodigo: { required: 'Ingrese el código' },
            ctl00$cphBody$txtDescripcion: { required: 'Ingrese la descripción' }
        },
        highlight: function (element) {
            $(element).closest('.form-group').removeClass('has-success').addClass('has-error');
        },
        success: function (element) {
            $(element).closest('.form-group').removeClass('has-error').addClass('has-success');
        }
    });
}

function CargarControles() {

    $(".btnGrabar").click(function () {
        GuardarInsumo();
        return false;
    });

    $(".btnCancelar").click(function () {
        ConfirmJQ('¿Está seguro de regresar a la ventana anterior?', function () { document.location.href = urlPrincipal });
        return false;
    });

    $("#txtCodigo").focus();
}

function GuardarInsumo() {

    if ($('#frmContent').valid()) {
        obj_Insumo = new Object();
        obj_Insumo.IdInsumo = $("#hdIdInsumo").val();
        obj_Insumo.Codigo = $("#txtCodigo").val();
        obj_Insumo.Descripcion = $("#txtDescripcion").val();
        obj_Insumo.IdUnidadMedida = $("#ddlUnidadMedida").val();
        obj_Insumo.Estado = $("#ddlEstado").val();

        Accion('RegistroInsumo.aspx/GuardarInsumo', { "str_pInsumo": JSON.stringify(obj_Insumo) },
            function () { document.location.href = urlPrincipal; });
    }
}

function ObtenerInsumo() {
    var int_IdInsumo = $("#hdIdInsumo").val();
    if (int_IdInsumo != '') {
        var obj_Insumo = ObtenerData("RegistroInsumo.aspx/ObtenerInsumo", { "int_pIdInsumo": int_IdInsumo });
        if (obj_Insumo != null) {

            $("#txtCodigo").val(obj_Insumo.Codigo);
            $("#txtDescripcion").val(obj_Insumo.Descripcion);
            $("#ddlUnidadMedida").val(obj_Insumo.IdUnidadMedida);
            $("#ddlEstado").val(obj_Insumo.Estado);

            //Auditoria
            $("#ddUsuarioCreacion").html(obj_Insumo.UsuarioCreacion);
            $("#ddUsuarioModificacion").html(obj_Insumo.UsuarioModificacion);
            $("#ddFechaCreacion").html(ToDateTimeString(obj_Insumo.FechaCreacion));
            $("#ddFechaModificacion").html(ToDateTimeString(obj_Insumo.FechaModificacion));
        }
    }
}