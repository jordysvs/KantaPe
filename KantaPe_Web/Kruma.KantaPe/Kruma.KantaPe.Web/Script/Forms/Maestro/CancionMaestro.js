//Atributos
var int_NumPagina = 1;
var int_TamPagina = 10;
var int_PagMostrar = 9;
var urlEdicion = 'RegistroCancionMaestro.aspx';

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
        ListarCancion(1);
        return false;
    });

    KeyPressEnter("divFiltro",
        function () {
            $("#btnBuscar").click();
        });

    $("#btnBuscar").focus();

    ListarCancion(1);
});

function ObtenerFiltros() {
    var obj_Filtro = new Object();
    obj_Filtro.IdCancion = null;
    obj_Filtro.Descripcion = $("#txtDescripcion").val();
    obj_Filtro.Estado = $("#ddlEstado").val();
    return obj_Filtro;
}


function ListarCancion(int_pNumPagina) {
    int_NumPagina = int_pNumPagina;
    var obj_Filtro = ObtenerFiltros();
    var obj_Data = {
        "int_pIdCancion": obj_Filtro.IdCancion,
        "str_pDescripcion": obj_Filtro.Descripcion,
        "str_pEstado": obj_Filtro.Estado,
        "int_pNumPagina": int_pNumPagina,
        "int_pTamPagina": int_TamPagina
    };
    AccionDefault(true, "CancionMaestro.aspx/ListarCancion", obj_Data, CargarGrilla, null, null, null, 1);
}

function ListarCancionResultado(obj_pResultado, int_pNumPagina) {
    ListarCancion(int_pNumPagina);
}

function CargarGrilla(obj_pLista) {
    var obj_TablaPrincipal = $("<table id='tblCancion' class='table table-bordered table-hover dt-responsive'></table>");
    var obj_THead = $("<thead></thead>");
    var obj_FilaPrincipal = $("<tr></tr>");
    obj_FilaPrincipal.append($("<th style='width:85%'>Descripcion</th>"));
    obj_FilaPrincipal.append($("<th style='width:15%;'>Estado</th>"));
    obj_THead.append(obj_FilaPrincipal);
    obj_TablaPrincipal.append(obj_THead);

    var str_Estado = '';
    var obj_TBody = $("<tbody></tbody>");
    for (var i = 0; i < obj_pLista.Result.length; i++) {
        obj_FilaPrincipal = $("<tr value='" + obj_pLista.Result[i].IdCancion + "'></tr>");
        obj_FilaPrincipal.append($("<td>" + obj_pLista.Result[i].Descripcion + "</td>"));

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
        ListarCancion(num);
    });

    $("#divGrilla").html('');
    $("#divGrilla").append(obj_TablaPrincipal);

    var obj_Tabla = $('#tblCancion').dataTable({
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

    $('#tblCancion tbody').on('click', 'tr', function () {
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
    var obj_Seleccion = $('#tblCancion').find('.selected');
    if (obj_Seleccion.length > 0)
        str_Id = $(obj_Seleccion[0]).attr('value');
    else
        AlertJQ(1, 'Seleccione un género.');
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
        ConfirmJQ('¿Está seguro de activar la canción?', ModificarEstado, [str_Id, 'A']);
    }
}

function Inactivar(int_pId) {
    var str_Id = obtenerIdRegistro();
    if (str_Id != null) {
        ConfirmJQ('¿Está seguro de inactivar la canción?', ModificarEstado, [str_Id, 'I']);
    }
}

function ModificarEstado(str_pId, str_pEstado) {
    Accion('CancionMaestro.aspx/ModificarEstado', { "int_pIdCancion": str_pId, "str_pEstado": str_pEstado }, ListarCancionResultado, [1]);
}