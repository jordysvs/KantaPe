var urlPrincipal = 'Empresa.aspx';
var urlEdicion = 'RegistroEmpresa.aspx';

$(function () {
    CargarInicial();
    CargarControles();
    ObtenerEmpresa();
});

function CargarInicial() {

    jQuery.validator.addMethod('selectEstado', function (value) {
        return (value != '');
    }, "Seleccione el estado");

    $('#frmContent').validate({
        rules: {
            ctl00$cphBody$txtRUC: { required: true, },
            ctl00$cphBody$txtRazonSocial: { required: true, },
            ctl00$cphBody$txtNombreComercial: { required: true, },
            ctl00$cphBody$ddlEstado: { selectEstado: true }
        },
        messages: {
            ctl00$cphBody$txtRUC: { required: 'Ingrese el RUC' },
            ctl00$cphBody$txtRazonSocial: { required: 'Ingrese la razón social' },
            ctl00$cphBody$txtNombreComercial: { required: 'Ingrese el nombre comercial' }
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
        GuardarEmpresa();
        return false;
    });

    $(".btnCancelar").click(function () {
        ConfirmJQ('¿Está seguro de regresar a la ventana anterior?', function () { document.location.href = urlPrincipal });
        return false;
    });

    $("#txtRUC").focus();
}

function GuardarEmpresa() {

    if ($('#frmContent').valid()) {
        obj_Empresa = new Object();
        obj_Empresa.IdEmpresa = $("#hdIdEmpresa").val();
        obj_Empresa.RUC = $("#txtRUC").val();
        obj_Empresa.RazonSocial = $("#txtRazonSocial").val();
        obj_Empresa.NombreComercial = $("#txtNombreComercial").val();
        obj_Empresa.Estado = $("#ddlEstado").val();

        Accion('RegistroEmpresa.aspx/GuardarEmpresa', { "str_pEmpresa": JSON.stringify(obj_Empresa) },
            function () { document.location.href = urlPrincipal; });
    }
}

function ObtenerEmpresa() {
    var int_IdEmpresa = $("#hdIdEmpresa").val();
    if (int_IdEmpresa != '') {
        var obj_Empresa = ObtenerData("RegistroEmpresa.aspx/ObtenerEmpresa", { "int_pIdEmpresa": int_IdEmpresa });
        if (obj_Empresa != null) {

            $("#txtRUC").val(obj_Empresa.RUC);
            $("#txtRazonSocial").val(obj_Empresa.RazonSocial);
            $("#txtNombreComercial").val(obj_Empresa.NombreComercial);
            $("#ddlEstado").val(obj_Empresa.Estado);

            //Auditoria
            $("#ddUsuarioCreacion").html(obj_Empresa.UsuarioCreacion);
            $("#ddUsuarioModificacion").html(obj_Empresa.UsuarioModificacion);
            $("#ddFechaCreacion").html(ToDateTimeString(obj_Empresa.FechaCreacion));
            $("#ddFechaModificacion").html(ToDateTimeString(obj_Empresa.FechaModificacion));
        }
    }
}