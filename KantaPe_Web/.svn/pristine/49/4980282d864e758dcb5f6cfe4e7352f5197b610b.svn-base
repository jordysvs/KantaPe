//Atributos
var int_NumPagina = 1;
var int_TamPagina = 10;
var int_PagMostrar = 9;
var urlEdicion = 'RegistroAlbum.aspx';

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
        ListarAlbum(1);
        return false;
    });

    KeyPressEnter("divFiltro",
        function () {
            $("#btnBuscar").click();
        });

    $("#btnBuscar").focus();

    ListarAlbum(1);
});

function ObtenerFiltros() {
    var obj_Filtro = new Object();
    obj_Filtro.IdArtista = null;
    obj_Filtro.ArtistaNombre = $("#txtArtista").val();
    obj_Filtro.Titulo = $("#txtTitulo").val();
    obj_Filtro.Estado = $("#ddlEstado").val();
    return obj_Filtro;
}

function ListarAlbumResultado(obj_pResultado, int_pNumPagina) {
    ListarAlbum(int_pNumPagina);
}

function ListarAlbum(int_pNumPagina) {
    int_NumPagina = int_pNumPagina;
    var obj_Filtro = ObtenerFiltros();
    var obj_Data = { "int_pIdArtista": obj_Filtro.IdArtista, "str_pArtistaNombre": obj_Filtro.ArtistaNombre, "str_pTitulo": obj_Filtro.Titulo, "str_pEstado": obj_Filtro.Estado, "int_pNumPagina": int_pNumPagina, "int_pTamPagina": int_TamPagina };
    AccionDefault(true, "Album.aspx/ListarAlbum", obj_Data, CargarGrilla, null, null, null, 1);
}

function CargarGrilla(obj_pLista) {

    var obj_TablaPrincipal = $("<table id='tblAlbum' class='table table-bordered table-hover dt-responsive'></table>");
    var obj_THead = $("<thead></thead>");
    var obj_FilaPrincipal = $("<tr></tr>");
    obj_FilaPrincipal.append($("<th style='width:35%;'>Artista</th>"));
    obj_FilaPrincipal.append($("<th style='width:50%;'>Titulo</th>"));
    obj_FilaPrincipal.append($("<th style='width:15%;'>Estado</th>"));
    obj_THead.append(obj_FilaPrincipal);
    obj_TablaPrincipal.append(obj_THead);

    var str_Artista = '';
    var str_Estado = '';
    var obj_TBody = $("<tbody></tbody>");
    for (var i = 0; i < obj_pLista.Result.length; i++) {

        obj_FilaPrincipal = $("<tr value='" + obj_pLista.Result[i].IdAlbum + "'></tr>");

        if (obj_pLista.Result[i].Artista != null)
            str_Artista = obj_pLista.Result[i].Artista.Nombre;
        obj_FilaPrincipal.append($("<td>" + str_Artista + "</td>"));

        obj_FilaPrincipal.append($("<td>" + obj_pLista.Result[i].Titulo + "</td>"));

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
        ListarAlbum(num);
    });

    $("#divGrilla").html('');
    $("#divGrilla").append(obj_TablaPrincipal);

    var obj_Tabla = $('#tblAlbum').dataTable({
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

    $('#tblAlbum tbody').on('click', 'tr', function () {
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
    var obj_Seleccion = $('#tblAlbum').find('.selected');
    if (obj_Seleccion.length > 0)
        str_Id = $(obj_Seleccion[0]).attr('value');
    else
        AlertJQ(1, 'Seleccione un álbum.');
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
        ConfirmJQ('¿Está seguro de activar el álbum?', ModificarEstado, [str_Id, 'A']);
    }
}

function Inactivar(int_pId) {
    var str_Id = obtenerIdRegistro();
    if (str_Id != null) {
        ConfirmJQ('¿Está seguro de inactivar el álbum?', ModificarEstado, [str_Id, 'I']);
    }
}

function ModificarEstado(str_pId, str_pEstado) {
    Accion('Album.aspx/ModificarEstado', { "int_pIdAlbum": str_pId, "str_pEstado": str_pEstado }, ListarAlbumResultado, [1]);
}