//Atributos
var urlPrincipal = 'Evento.aspx';
var urlEdicion = 'RegistroEvento.aspx';

$(function () {
    CargarInicial();
    CargarControles();
    ObtenerEvento();
});

function CargarInicial() {

    if ($("#hdEsAdministrador").val() == "N") {
        $("#ddlEmpresa").prop('disabled', true);
        $("#ddlLocal").prop('disabled', true);
        CargarLocal(true, $("#hdIdLocalValidar").val());
    }

    $('#ddlEmpresa').change(function () {
        CargarLocal(true, null);
    });

    jQuery.validator.addMethod('selectEmpresa', function (value) {
        return (value != '');
    }, "Seleccione la empresa");

    jQuery.validator.addMethod('selectLocal', function (value) {
        return (value != '');
    }, "Seleccione el local");

    jQuery.validator.addMethod('selectEstado', function (value) {
        return (value != '');
    }, "Seleccione el estado");

    $('#frmContent').validate({
        rules: {
            ctl00$cphBody$ddlEmpresa: { selectEmpresa: true },
            ctl00$cphBody$ddlLocal: { selectLocal: true },
            ctl00$cphBody$txtNombre: { required: true },
            ctl00$cphBody$txtDescripcion: { required: true },
            txtFechaEvento_input: { required: true },
            ctl00$cphBody$ddlEstado: { selectEstado: true }
        },
        messages: {
            ctl00$cphBody$txtNombre: { required: 'Ingrese el nombre' },
            ctl00$cphBody$txtDescripcion: { required: 'Ingrese la descripción' },
            txtFechaEvento_input: { required: 'Ingrese la fecha del evento' },
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
            VerArchivoElemento('imgEventoImagen', $("#hdIdAlmacen").val(), -1, obj_pResultado.ReturnId);
        }
    });

    $("#txtFechaEvento").datetimepicker({
        language: 'es',
        format: 'dd/mm/yyyy',
        pickerPosition: "bottom-left",
        autoclose: true,
        minView: 0,
        maxView: 4
    });

    $("#txtFechaEvento").data("datetimepicker").setDate(new Date());
    $("#txtDescripcion").attr("maxlength", 500);

    $(".btnGrabar").click(function () { return GuardarEvento(); });

    $(".btnCancelar").click(function () {
        ConfirmJQ('¿Está seguro de regresar a la ventana anterior?',
            function () {
                document.location.href = urlPrincipal;
            });
        return false;
    });

    //Eliminar Foto
    $("#lnkEliminarFoto").click(function () { ConfirmJQ('¿Está seguro de eliminar la foto?', EliminarFoto); });
    $("#lnkEliminarFoto").css('display', 'none');

    //Focus Inicial
    $("#ddlEmpresa").focus();
}
function CargarLocal(bln_pAsync, int_pIdLocal) {

    var ddlLocal = $("#ddlLocal");
    ddlLocal.empty();
    ddlLocal.html('');
    ddlLocal.append($("<option value=''>--Seleccione--</option>"));

    var int_IdPersona = $("#ddlEmpresa").val();
    if (int_IdPersona != '') {
        var obj_Data = { "int_pIdPersona": int_IdPersona };
        AccionDefault(bln_pAsync, "RegistroEvento.aspx/ListarLocal", obj_Data,
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

function GuardarEvento() {

    //validacion del formulario
    if ($('#frmContent').valid()) {

        //Obtiene los valores de la entidad
        obj_Evento = new Object();
        obj_Evento.IdEvento = $("#hdIdEvento").val();
        obj_Evento.IdLocal = $("#ddlLocal").val();
        obj_Evento.Nombre = $("#txtNombre").val();
        obj_Evento.Descripcion = $("#txtDescripcion").val();
        obj_Evento.FechaEvento = $("#txtFechaEvento").data("datetimepicker").getDate();
        obj_Evento.Estado = $("#ddlEstado").val();

        //Eliminacion de la imagen
        var str_Ruta = $('#hdEventoImagen').val();
        if (str_Ruta == $("#imgEventoImagen").attr('src')) {
            obj_Evento.Foto = new Object();
            obj_Evento.Foto.IdAlmacen = $("#hdIdAlmacen").val();
            obj_Evento.Foto.IdRegistro = -1;
            obj_Evento.Foto.IdDocumento = null;
        }

        //Anexar Imagen
        if ($("#hdIdDocumento").val() != '') {
            obj_Evento.Foto = new Object();
            obj_Evento.Foto.IdAlmacen = $("#hdIdAlmacen").val();
            obj_Evento.Foto.IdRegistro = -1;
            obj_Evento.Foto.IdDocumento = $("#hdIdDocumento").val();
        }

        //Registro del evento
        Accion('RegistroEvento.aspx/GuardarEvento',
            {
                "str_pEvento": JSON.stringify(obj_Evento)
            },
            function () {
                document.location.href = urlPrincipal;
            });
    }
    return false;
}

function ObtenerEvento() {

    //Se obtiene los valores key de la entidad
    var int_IdLocal = $("#hdIdLocal").val();
    var int_IdEvento = $("#hdIdEvento").val();

    if (int_IdEvento != '') {

        //Se obtiene la información de la entidad
        var obj_Evento = ObtenerData("RegistroEvento.aspx/ObtenerEvento", {
            "int_pIdLocal": int_IdLocal,
            "int_pIdEvento": int_IdEvento
        });

        if (obj_Evento != null) {
            $("#ddlEmpresa").val(obj_Evento.Local.IdEmpresa);
            CargarLocal(true, obj_Evento.IdLocal);

            $("#txtNombre").val(obj_Evento.Nombre);
            $("#txtDescripcion").val(obj_Evento.Descripcion);

            var obj_ParsedDate = null;
            if (obj_Evento.FechaEvento != null) {
                obj_ParsedDate = new Date(parseInt(obj_Evento.FechaEvento.substr(6)));
                $("#txtFechaEvento").data("datetimepicker").setDate(new Date(obj_ParsedDate.getFullYear(), obj_ParsedDate.getMonth(), obj_ParsedDate.getDate(), obj_ParsedDate.getHours(), obj_ParsedDate.getMinutes()));
            }

            $("#ddlEstado").val(obj_Evento.Estado);

            //Auditoria
            $("#ddUsuarioCreacion").html(obj_Evento.UsuarioCreacion);
            $("#ddUsuarioModificacion").html(obj_Evento.UsuarioModificacion);
            $("#ddFechaCreacion").html(ToDateTimeString(obj_Evento.FechaCreacion));
            $("#ddFechaModificacion").html(ToDateTimeString(obj_Evento.FechaModificacion));

            $("#ddlEmpresa").prop('disabled', true);
            $("#ddlLocal").prop('disabled', true);

            //Foto
            $("#lnkEliminarFoto").css('display', '');
            if (obj_Evento.ImagenURL == '') {
                obj_Evento.ImagenURL = $("#hdEventoImagen").val();
                $("#lnkEliminarFoto").css('display', 'none');
            }
            $("#imgEventoImagen").attr("src", obj_Evento.ImagenURL);
        }
    }
}

function EliminarFoto() {
    $("#hdIdDocumento").val('');
    var str_Ruta = $('#hdEventoImagen').val();
    $("#imgEventoImagen").attr('src', str_Ruta);
    $("#lnkEliminarFoto").css('display', 'none');
}
