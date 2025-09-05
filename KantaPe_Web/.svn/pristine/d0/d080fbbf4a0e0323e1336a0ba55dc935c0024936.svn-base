var urlPrincipal = 'Empleado.aspx';
var urlEdicion = 'RegistroEmpleado.aspx';

$(function () {
    CargarInicial();
    CargarControles();
    ObtenerEmpleado();
});

function CargarInicial() {

    jQuery.validator.addMethod('selectTipoDocumento', function (value) {
        return (value != '');
    }, "Seleccione el tipo de documento");

    jQuery.validator.addMethod('selectPais', function (value) {
        return (value != '');
    }, "Seleccione el país");

    jQuery.validator.addMethod('selectDepartamento', function (value) {
        return (value != '');
    }, "Seleccione el departamento");

    jQuery.validator.addMethod('selectProvincia', function (value) {
        return (value != '');
    }, "Seleccione la provincia");

    jQuery.validator.addMethod('selectDistrito', function (value) {
        return (value != '');
    }, "Seleccione el distrito");

    jQuery.validator.addMethod('selectEstado', function (value) {
        return (value != '');
    }, "Seleccione el estado");

    $('#frmContent').validate({
        rules: {
            ctl00$cphBody$ddlTipoDocumento: { selectTipoDocumento: true },
            ctl00$cphBody$txtNumeroDocumento: { required: true },
            ctl00$cphBody$txtNombre: { required: true },
            ctl00$cphBody$txtApellidoPaterno: { required: true },
            ctl00$cphBody$txtApellidoMaterno: { required: true },
            ctl00$cphBody$ddlPais: { selectPais: true },
            ctl00$cphBody$ddlDepartamento: { selectDepartamento: true },
            ctl00$cphBody$ddlProvincia: { selectProvincia: true },
            ctl00$cphBody$ddlDistrito: { selectDistrito: true },
            ctl00$cphBody$txtDireccion: { required: true, },
            ctl00$cphBody$txtEmail: { required: true, },
            ctl00$cphBody$txtTelefono: { required: true, },
            ctl00$cphBody$ddlEstado: { selectEstado: true }
        },
        messages: {
            ctl00$cphBody$txtNumeroDocumento: { required: 'Ingrese el nro. de documento' },
            ctl00$cphBody$txtNombre: { required: 'Ingrese el nombre' },
            ctl00$cphBody$txtApellidoPaterno: { required: 'Ingrese el apellido paterno' },
            ctl00$cphBody$txtApellidoMaterno: { required: 'Ingrese el apellido materno' },
            ctl00$cphBody$txtDireccion: { required: 'Ingrese la dirección' },
            ctl00$cphBody$txtEmail: { required: 'Ingrese el email' },
            ctl00$cphBody$txtTelefono: { required: 'Ingrese el teléfono' },
            ctl00$cphBody$txtEmpresa: { required: 'Ingrese la empresa' }
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
        GuardarEmpleado();
        return false;
    });

    $(".btnCancelar").click(function () {
        ConfirmJQ('¿Está seguro de regresar a la ventana anterior?', function () { document.location.href = urlPrincipal });
        return false;
    });

    //Configuracion del ubigeo
    $("#ddlPais").change(function () {
        CargarDepartamento(null);
        CargarProvincia(null);
        CargarDistrito(null);
        return false;
    });

    $("#ddlDepartamento").change(function () {
        CargarProvincia(null);
        CargarDistrito(null);
        return false;
    });

    $("#ddlProvincia").change(function () {
        CargarDistrito(null);
        return false;
    });

    $("#ddlTipoDocumento").change(function () {
        SeleccionarTipoDocumento();
        return false;
    });

    CargarPais(null);

    $("#ddlTipoDocumento").focus();
}

function GuardarEmpleado() {

    if ($('#frmContent').valid()) {
        obj_Empleado = new Object();
        obj_Empleado.IdEmpleado = $("#hdIdEmpleado").val();
        obj_Empleado.Persona = new Object();
        obj_Empleado.Persona.IdTipoDocumento = $("#ddlTipoDocumento").val();
        obj_Empleado.Persona.NumeroDocumento = $("#txtDocumento").val();
        obj_Empleado.Persona.Nombres = $("#txtNombre").val();
        obj_Empleado.Persona.ApellidoPaterno = $("#txtApellidoPaterno").val();
        obj_Empleado.Persona.ApellidoMaterno = $("#txtApellidoMaterno").val();

        //Direccion del empleado
        obj_Direccion = new Object();
        obj_Direccion.IdDireccion = null;
        if ($("#hdIdDireccion").val() != '')
            obj_Direccion.IdDireccion = $("#hdIdDireccion").val();
        obj_Direccion.Direccion = $("#txtDireccion").val();
        obj_Direccion.Ubigeo = new Object();
        obj_Direccion.Ubigeo.IdPais = null;
        if ($("#ddlPais").val() != '-1')
            obj_Direccion.Ubigeo.IdPais = $("#ddlPais").val();
        obj_Direccion.Ubigeo.IdDepartamento = null;
        if ($("#ddlDepartamento").val() != '-1')
            obj_Direccion.Ubigeo.IdDepartamento = $("#ddlDepartamento").val();
        obj_Direccion.Ubigeo.IdProvincia = null;
        if ($("#ddlProvincia").val() != '-1')
            obj_Direccion.Ubigeo.IdProvincia = $("#ddlProvincia").val();
        obj_Direccion.Ubigeo.IdDistrito = null;
        if ($("#ddlDistrito").val() != '-1')
            obj_Direccion.Ubigeo.IdDistrito = $("#ddlDistrito").val();
        obj_Empleado.Persona.Direcciones.push(obj_Direccion);

        //Telefono del empleado
        obj_Telefono = new Object();
        obj_Telefono.IdTelefono = null;
        if ($("#hdIdTelefono").val() != '')
            obj_Telefono.IdTelefono = $("#hdIdTelefono").val();
        obj_Telefono.Numero = $("#txtTelefono").val();
        obj_Empleado.Persona.Telefonos.push(obj_Telefono);

        //Mail del empleado
        obj_Mail = new Object();
        obj_Mail.IdMail = $("#txtMail").val()
        obj_Empleado.Persona.Direcciones.push(obj_Direccion);
        obj_Cliente.Estado = $("#ddlEstado").val();

        Accion('RegistroCliente.aspx/GuardarCliente', { "str_pCliente": JSON.stringify(obj_Cliente) },
            function () { document.location.href = urlPrincipal; });
    }
}

function ObtenerCliente() {
    var int_IdCliente = $("#hdIdCliente").val();
    if (int_IdCliente != '') {
        var obj_Cliente = ObtenerData("RegistroCliente.aspx/ObtenerCliente", { "int_pIdCliente": int_IdCliente });
        if (obj_CLiente != null) {

            $("#ddlTipoDocumento").val(obj_Cliente.IdCliente);
            $("#txtNumeroDocumento").val(obj_Cliente.NumeroDocumento);
            $("#txtRazonSocial").val(obj_Cliente.RazonSocial);
            $("#txtNombreComercial").val(obj_Cliente.NombreComercial);
            $("#txtDireccion").val(obj_Cliente.Direccion);
            $("#ddlEstado").val(obj_Cliente.Estado);

            //Ubigeo
            if (obj_Cliente.Ubigeo != null) {
                CargarPais(obj_Cliente.Ubigeo.IdPais);
                CargarDepartamento(obj_Cliente.Ubigeo.IdDepartamento);
                CargarProvincia(obj_Cliente.Ubigeo.IdProvincia);
                CargarDistrito(obj_Cliente.Ubigeo.IdDistrito);
            }
            //Auditoria
            $("#ddUsuarioCreacion").html(obj_Cliente.UsuarioCreacion);
            $("#ddUsuarioModificacion").html(obj_Cliente.UsuarioModificacion);
            $("#ddFechaCreacion").html(ToDateTimeString(obj_Cliente.FechaCreacion));
            $("#ddFechaModificacion").html(ToDateTimeString(obj_Cliente.FechaModificacion));

            $("#ddlTipoDocumento").prop('disabled', true);
        }
    }
}

function CargarPais(int_pIdPais) {
    var ddlPais = $("#ddlPais");
    ddlPais.html('');
    ddlPais.append($("<option value='-1'>--Seleccione--</option>"));
    AccionDefault((int_pIdPais == null), "RegistroCliente.aspx/ListarPais", {},
    function (obj_pLista) {
        var str_Selected = '';
        for (var i = 0; i < obj_pLista.length; i++) {
            str_Selected = (obj_pLista[i].Pais.IdPais == int_pIdPais) ? 'selected' : '';
            ddlPais.append($("<option value='" + obj_pLista[i].Pais.IdPais + "' " + str_Selected + " >" + obj_pLista[i].Pais.Descripcion + "</option>"));
        }
    }, null, null, null, 1);
}

function CargarDepartamento(int_pIdDepartamento) {
    var ddlDepartamento = $("#ddlDepartamento");
    ddlDepartamento.html('');
    ddlDepartamento.append($("<option value='-1'>--Seleccione--</option>"));

    if ($("#ddlPais").val() != '-1') {
        var obj_Data = { "int_pIdPais": $("#ddlPais").val() };
        AccionDefault((int_pIdDepartamento == null), "RegistroCliente.aspx/ListarDepartamento", obj_Data,
        function (obj_pLista) {
            var str_Selected = '';
            for (var i = 0; i < obj_pLista.length; i++) {
                str_Selected = (obj_pLista[i].Departamento.IdDepartamento == int_pIdDepartamento) ? 'selected' : '';
                ddlDepartamento.append($("<option value='" + obj_pLista[i].Departamento.IdDepartamento + "' " + str_Selected + " >" + obj_pLista[i].Departamento.Descripcion + "</option>"));
            }
        }, null, null, null, 1);
    }
}

function CargarProvincia(int_pIdProvincia) {
    var ddlProvincia = $("#ddlProvincia");
    ddlProvincia.html('');
    ddlProvincia.append($("<option value='-1'>--Seleccione--</option>"));

    if ($("#ddlDepartamento").val() != '-1') {
        var obj_Data = {
            "int_pIdPais": $("#ddlPais").val(),
            "int_pIdDepartamento": $("#ddlDepartamento").val()
        };
        AccionDefault((int_pIdProvincia == null), "RegistroCliente.aspx/ListarProvincia", obj_Data,
        function (obj_pLista) {
            var str_Selected = '';
            for (var i = 0; i < obj_pLista.length; i++) {
                str_Selected = (obj_pLista[i].Provincia.IdProvincia == int_pIdProvincia) ? 'selected' : '';
                ddlProvincia.append($("<option value='" + obj_pLista[i].Provincia.IdProvincia + "' " + str_Selected + " >" + obj_pLista[i].Provincia.Descripcion + "</option>"));
            }
        }, null, null, null, 1);
    }
}


function CargarDistrito(int_pIdDistrito) {
    var ddlDistrito = $("#ddlDistrito");
    ddlDistrito.html('');
    ddlDistrito.append($("<option value='-1'>--Seleccione--</option>"));

    if ($("#ddlProvincia").val() != '-1') {
        var obj_Data = {
            "int_pIdPais": $("#ddlPais").val(),
            "int_pIdDepartamento": $("#ddlDepartamento").val(),
            "int_pIdProvincia": $("#ddlProvincia").val()
        };
        AccionDefault((int_pIdDistrito == null), "RegistroCliente.aspx/ListarDistrito", obj_Data,
        function (obj_pLista) {
            var str_Selected = '';
            for (var i = 0; i < obj_pLista.length; i++) {
                str_Selected = (obj_pLista[i].Distrito.IdDistrito == int_pIdDistrito) ? 'selected' : '';
                ddlDistrito.append($("<option value='" + obj_pLista[i].Distrito.IdDistrito + "' " + str_Selected + " >" + obj_pLista[i].Distrito.Descripcion + "</option>"));
            }
        }, null, null, null, 1);
    }
}