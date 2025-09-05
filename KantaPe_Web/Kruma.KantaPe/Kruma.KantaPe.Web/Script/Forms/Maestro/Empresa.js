var int_NumPagina = 1;
var int_TamPagina = 10;
var int_PagMostrar = 9;
var urlEdicion = 'RegistroEmpresa.aspx';

$(function () {

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
        ListarEmpresa(1);
        return false;
    });

    KeyPressEnter("divFiltro",
        function () {
            $("#btnBuscar").click();
        });

    $("#btnBuscar").focus();

    ListarEmpresa(1);
});

function ObtenerFiltros() {
    var obj_Filtro = new Object();
    obj_Filtro.RUC = $("#txtRUC").val();
    obj_Filtro.RazonSocial = $("#txtRazonSocial").val();
    obj_Filtro.NombreComercial = $("#txtNombreComercial").val();

    obj_Filtro.Estado = null;
    if ($("#ddlEstado").val() != '')
        obj_Filtro.Estado = $("#ddlEstado").val();

    return obj_Filtro;
}

function ListarEmpresa(int_pNumPagina) {
    int_NumPagina = int_pNumPagina;
    var obj_Filtro = ObtenerFiltros();
    var obj_Data = {
        "str_pRUC": obj_Filtro.RUC,
        "str_pRazonSocial": obj_Filtro.RazonSocial,
        "str_pNombreComercial": obj_Filtro.NombreComercial,
        "str_pEstado": obj_Filtro.Estado,
        "int_pNumPagina": int_pNumPagina,
        "int_pTamPagina": int_TamPagina
    };
    AccionDefault(true, "Empresa.aspx/ListarEmpresa", obj_Data, CargarGrilla, null, null, null, 1);
}

function CargarGrilla(obj_pLista) {

    var obj_TablaPrincipal = $("<table id='tblEmpresa' class='table table-bordered table-hover dt-responsive'></table>");
    var obj_THead = $("<thead></thead>");
    var obj_FilaPrincipal = $("<tr></tr>");
    obj_FilaPrincipal.append($("<th style='width:20%;'>RUC</th>"));
    obj_FilaPrincipal.append($("<th style='width:30%;'>Razón Social</th>"));
    obj_FilaPrincipal.append($("<th style='width:30%;'>Nombre Comercial</th>"));
    obj_FilaPrincipal.append($("<th style='width:20%;'>Estado</th>"));
    obj_THead.append(obj_FilaPrincipal);
    obj_TablaPrincipal.append(obj_THead);

    var str_Estado = '';
    var obj_TBody = $("<tbody></tbody>");
    for (var i = 0; i < obj_pLista.Result.length; i++) {

        obj_FilaPrincipal = $("<tr value='" + obj_pLista.Result[i].IdEmpresa + "'></tr>");
        obj_FilaPrincipal.append($("<td>" + obj_pLista.Result[i].NumeroDocumento + "</td>"));
        obj_FilaPrincipal.append($("<td>" + obj_pLista.Result[i].RazonSocial + "</td>"));
        obj_FilaPrincipal.append($("<td>" + obj_pLista.Result[i].NombreComercial + "</td>"));
        str_Estado = obj_pLista.Result[i].Estado == 'A' ? "Activo" : "Inactivo";
        obj_FilaPrincipal.append($("<td style='text-align:center'>" + str_Estado + "</td>"));
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
        ListarEmpresa(num);
    });

    $("#divGrilla").html('');
    $("#divGrilla").append(obj_TablaPrincipal);

    var obj_Tabla = $('#tblEmpresa').dataTable({
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

    $('#tblEmpresa tbody').on('click', 'tr', function () {
        if ($(this).hasClass('selected')) {
            $(this).removeClass('selected');
        }
        else {
            obj_Tabla.$('tr.selected').removeClass('selected');
            $(this).addClass('selected');
        }
    });
}

function CrearNumeroPagina(int_pNumPagina, str_pTexto) {
    var obj_AnchorPag = $("<a></a>");
    $(obj_AnchorPag).attr('href', '#');
    $(obj_AnchorPag).attr('onclick', 'ListarEmpresa(' + (int_pNumPagina) + ');');
    $(obj_AnchorPag).text(str_pTexto);
    return obj_AnchorPag;
}

function obtenerIdRegistro() {
    var str_Id = null;
    var obj_Seleccion = $('#tblEmpresa').find('.selected');
    if (obj_Seleccion.length > 0)
        str_Id = $(obj_Seleccion[0]).attr('value');
    else
        AlertJQ(1, 'Seleccione una empresa.');
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
        ConfirmJQ('¿Está seguro de activar la empresa?', ModificarEstado, [str_Id, 'A']);
    }
}

function Inactivar(int_pId) {
    var str_Id = obtenerIdRegistro();
    if (str_Id != null) {
        ConfirmJQ('¿Está seguro de inactivar la empresa?', ModificarEstado, [str_Id, 'I']);
    }
}

function ModificarEstado(str_pId, str_pEstado) {
    Accion('Empresa.aspx/ModificarEstado', {
        "int_pIdEmpresa": str_pId,
        "str_pEstado": str_pEstado
    }, function () {
        ListarEmpresa(1);
    });
}