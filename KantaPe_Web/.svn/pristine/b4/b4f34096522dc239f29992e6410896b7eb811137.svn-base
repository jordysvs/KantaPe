//Atributos
var int_NumPagina = 1;
var int_TamPagina = 10;
var int_PagMostrar = 9;
var urlEdicion = 'RegistroUsuario.aspx';

$(function () {

    if ($("#hdEsAdministrador").val() == "N") {
        $("#ddlEmpresa").prop('disabled', true);
        $("#ddlLocal").prop('disabled', true);
        CargarLocal(true, $("#hdIdLocal").val());
    }

    $('#ddlEmpresa').change(function () {
        CargarLocal(true, null);
    });

    CargarModuloSelect("ddlModulo", true, "--Todos--");

    $("#btnAgregar").click(function () {
        MostrarMensajeCargando();
        document.location.href = urlEdicion;
        return false;
    });

    $("#btnModificar").click(function () {
        Editar();
        return false;
    });

    $("#btnActivar").click(function () {
        Activar();
        return false;
    });

    $("#btnInactivar").click(function () {
        Inactivar();
        return false;
    });

    $("#btnBuscar").click(function () {
        ListarUsuario(1);
        return false;
    });

    $("#ddlModulo").change(function () {
        CargarPerfilSelect();
    });
    CargarPerfilSelect();

    KeyPressEnter("divFiltro",
        function () {
            $("#btnBuscar").click();
        });

    $("#btnBuscar").focus();



    ListarUsuario(1);
});

function CargarPerfilSelect() {
    var ddlPerfil = $("#ddlPerfil");
    ddlPerfil.html('');
    ddlPerfil.append($("<option value=''>--Todos--</option>"));

    if ($("#ddlModulo").val() != '') {
        var obj_Data = { "str_pIdModulo": $("#ddlModulo").val() };
        AccionDefault(true, "Usuario.aspx/ListarPerfil", obj_Data,
            function (obj_pLista) {
                for (var i = 0; i < obj_pLista.length; i++) {
                    ddlPerfil.append($("<option value='" + obj_pLista[i].IdPerfil + "'>" + obj_pLista[i].Descripcion + "</option>"));
                }
            }
       , null, null, null, 1);
    }
}

function ObtenerFiltros() {
    var obj_Filtro = new Object();
    obj_Filtro.IdUsuario = $("#txtCodigo").val();
    obj_Filtro.NombreCompleto = $("#txtNombre").val();
    obj_Filtro.IdPerfil = $("#ddlPerfil").val();
    obj_Filtro.Estado = $("#ddlEstado").val();
    obj_Filtro.IdEmpresa = $("#ddlEmpresa").val();
    obj_Filtro.IdLocal = $("#ddlLocal").val();

    if ($("#hdEsAdministrador").val() == "N") {
        obj_Filtro.IdEmpresa = $("#hdIdEmpresa").val();
        obj_Filtro.IdLocal = $("#hdIdLocal").val();
    }

    return obj_Filtro;
}

function ListarUsuarioResultado(obj_pResultado, int_pNumPagina) {
    ListarUsuario(int_pNumPagina);
}

function ListarUsuario(int_pNumPagina) {
    int_NumPagina = int_pNumPagina;
    var obj_Filtro = ObtenerFiltros();
    var obj_Data = { "int_pIdEmpresa": obj_Filtro.IdEmpresa, "int_pIdLocal": obj_Filtro.IdLocal, "str_pIdUsuario": obj_Filtro.IdUsuario, "str_pNombreCompleto": obj_Filtro.NombreCompleto, "str_pIdPerfil": obj_Filtro.IdPerfil, "str_pEstado": obj_Filtro.Estado, "int_pNumPagina": int_pNumPagina, "int_pTamPagina": int_TamPagina };
    AccionDefault(true, "Usuario.aspx/ListarUsuario", obj_Data, CargarGrilla, null, null, null, 1);
}

function CargarGrilla(obj_pLista) {

    var obj_TablaPrincipal = $("<table id='tblUsuario' class='table table-bordered table-hover dt-responsive nowrap'></table>");
    var obj_THead = $("<thead></thead>");
    var obj_FilaPrincipal = $("<tr></tr>");
    obj_FilaPrincipal.append($("<th>Código</th>"));
    obj_FilaPrincipal.append($("<th>Nombre</th>"));
    obj_FilaPrincipal.append($("<th>Contraseña</th>"));
    obj_FilaPrincipal.append($("<th>Correo</th>"));
    obj_FilaPrincipal.append($("<th>Estado</th>"));
    obj_FilaPrincipal.append($("<th>Empresa</th>"));
    obj_FilaPrincipal.append($("<th>Local</th>"));
    obj_THead.append(obj_FilaPrincipal);
    obj_TablaPrincipal.append(obj_THead);

    var str_NombreCompleto = '';
    var str_Mail = '';
    var str_Estado = '';
    var str_DesEmpresa = '';
    var str_DesLocal = '';
    var obj_TBody = $("<tbody></tbody>");
    for (var i = 0; i < obj_pLista.Result.length; i++) {
        obj_FilaPrincipal = $("<tr value='" + obj_pLista.Result[i].IdUsuario + "'></tr>");
        obj_FilaPrincipal.append($("<td style='width:15%'>" + obj_pLista.Result[i].IdUsuario + "</td>"));

        if (obj_pLista.Result[i].Persona != null) {
            str_NombreCompleto = obj_pLista.Result[i].Persona.NombreCompleto;
            str_Mail = obj_pLista.Result[i].Persona.Mail;
        }
        if (obj_pLista.Result[i].DesEmpresa != null) {
            str_DesEmpresa = obj_pLista.Result[i].DesEmpresa;
        }
        if (obj_pLista.Result[i].DesLocal != null) {
            str_DesLocal = obj_pLista.Result[i].DesLocal;
        }
        obj_FilaPrincipal.append($("<td style='width:45%'>" + str_NombreCompleto + "</td>"));
        obj_FilaPrincipal.append($("<td style='width:15%'>" + obj_pLista.Result[i].Clave + "</td>"));
        obj_FilaPrincipal.append($("<td style='width:15%'>" + str_Mail + "</td>"));
        str_Estado = obj_pLista.Result[i].Estado == 'A' ? "Activo" : "Inactivo";
        obj_FilaPrincipal.append($("<td style='width:10%; text-align:center'>" + str_Estado + "</td>"));
        obj_FilaPrincipal.append($("<td style='width:10%'>" + str_DesEmpresa + "</td>"));
        obj_FilaPrincipal.append($("<td style='width:10%'>" + str_DesLocal + "</td>"));

        obj_TBody.append(obj_FilaPrincipal);
    }
    obj_TablaPrincipal.append(obj_TBody);

    var int_TotalPaginas = Math.ceil(obj_pLista.Total / int_TamPagina) == 0 ? 1 : Math.ceil(obj_pLista.Total / int_TamPagina);
    $("#divPaginacionInfo").html("Página " + int_NumPagina + " de " + int_TotalPaginas);

    $("#divPaginacion").unbind();
    $("#divPaginacion").bootpag({
        total: int_TotalPaginas,
        page: int_NumPagina,
        maxVisible: obj_pLista.Total == 0 ? 1 : int_PagMostrar
    }).on('page', function (event, num) {
        ListarUsuario(num);
    });

    $("#divGrilla").html('');
    $("#divGrilla").append(obj_TablaPrincipal);

    var obj_Tabla = $('#tblUsuario').dataTable({
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
        "bSort": false,
        "bInfo": false,
        "bAutoWidth": false
    });

    $('#tblUsuario tbody').on('click', 'tr', function () {
        if ($(this).hasClass('selected')) {
            $(this).removeClass('selected');
        }
        else {
            obj_Tabla.$('tr.selected').removeClass('selected');
            $(this).addClass('selected');
        }
    });
}

function obtenerIdRegistro() {
    var str_Id = null;
    var obj_Seleccion = $('#tblUsuario').find('.selected');
    if (obj_Seleccion.length > 0)
        str_Id = $(obj_Seleccion[0]).attr('value');
    else
        AlertJQ(1, 'Seleccione un usuario.');
    return str_Id;
}

function Editar() {
    var str_Id = obtenerIdRegistro();
    if (str_Id != null) {
        MostrarMensajeCargando();
        document.location.href = urlEdicion + "?id=" + str_Id;
    }
}

function Activar() {
    var str_Id = obtenerIdRegistro();
    if (str_Id != null) {
        ConfirmJQ('¿Está seguro de activar el usuario?', ModificarEstado, [str_Id, 'A']);
    }
}

function Inactivar(int_pId) {
    var str_Id = obtenerIdRegistro();
    if (str_Id != null) {
        ConfirmJQ('¿Está seguro de inactivar el usuario?', ModificarEstado, [str_Id, 'I']);
    }
}

function ModificarEstado(str_pId, str_pEstado) {
    var obj_Data = { "str_pIdUsuario": str_pId, "str_pEstado": str_pEstado };
    Accion('Usuario.aspx/ModificarEstado', { "str_pIdUsuario": str_pId, "str_pEstado": str_pEstado }, ListarUsuarioResultado, [1]);
}


function CargarLocal(bln_pAsync, int_pIdDireccion) {

    var ddlLocal = $("#ddlLocal");
    ddlLocal.empty();
    ddlLocal.html('');
    ddlLocal.append($("<option value=''>--Seleccione--</option>"));

    var int_IdPersona = $("#ddlEmpresa").val();
    if (int_IdPersona != '') {
        var obj_Data = { "int_pIdPersona": int_IdPersona };
        AccionDefault(bln_pAsync, "Usuario.aspx/ListarLocal", obj_Data,
             function (obj_pLista) {
                 //ddlNivel.prop("disabled", false);
                 var str_Selected = '';
                 for (var i = 0; i < obj_pLista.Result.length; i++) {
                     if (int_pIdDireccion != null)
                         str_Selected = (obj_pLista.Result[i].IdDireccion == int_pIdDireccion) ? 'selected' : '';
                     ddlLocal.append($("<option value='" + obj_pLista.Result[i].IdLocal + "' " + str_Selected + ">" + obj_pLista.Result[i].Nombre + "</option>"));
                 }
                 // ddlLocal.prop("disabled", true);
             }, null, null, null, 1);
    }
}