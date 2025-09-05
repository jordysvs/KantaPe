//Atributos
var int_NumPaginaArtista = 1;
var int_TamPaginaArtista = 5;
var int_PagMostrarArtista = 9;

$(function () {

    $(document).keypress(function (e) {
        var blnMdBuscadorArtista = ($("#mdBuscadorArtista").data('bs.modal') || {}).isShown;
        if (blnMdBuscadorArtista == undefined)
            blnMdBuscadorArtista = false;

        if (blnMdBuscadorArtista)
            if (e.which == 13) {
                $("#btnBuscarBuscadorArtista").click();
                return false;
            }
    });

    $("#btnBuscarBuscadorArtista").click(function () {
        ListarBusquedaArtista(1);
        return false;
    });
});

function ObtenerFiltrosBuscadorArtista() {
    var obj_Filtro = new Object();
    obj_Filtro.Nombre = $("#txtNombreBuscadorArtista").val();
    return obj_Filtro;
}

function ListarBusquedaArtista(int_pNumPagina) {
    int_NumPaginaArtista = int_pNumPagina;
    var obj_Filtro = ObtenerFiltrosBuscadorArtista();
    var obj_Data = {
        "str_pNombre": obj_Filtro.Nombre,
        "int_pNumPagina": int_pNumPagina,
        "int_pTamPagina": int_TamPaginaArtista
    };
    AccionDefault(true, UrlPath + "Comun.aspx/ListarArtista", obj_Data, CargarGrillaBuscadorArtista, null, null, null, 1);
}

function CargarGrillaBuscadorArtista(obj_pLista) {

    var obj_TablaPrincipal = $("<table id='tblBuscadorArtista' class='table table-bordered table-hover dt-responsive'></table>");
    var obj_THead = $("<thead></thead>");
    var obj_FilaPrincipal = $("<tr></tr>");
    obj_FilaPrincipal.append($("<th>Nombre</th>"));
    obj_THead.append(obj_FilaPrincipal);
    obj_TablaPrincipal.append(obj_THead);

    var obj_TBody = $("<tbody></tbody>");
    for (var i = 0; i < obj_pLista.Result.length; i++) {
        obj_FilaPrincipal = $("<tr value='" + obj_pLista.Result[i].IdArtista + "' descripcion='" + obj_pLista.Result[i].Nombre + "'></tr>");
        obj_FilaPrincipal.append($("<td>" + obj_pLista.Result[i].Nombre + "</td>"));
        obj_TBody.append(obj_FilaPrincipal);
    }
    obj_TablaPrincipal.append(obj_TBody);

    var int_TotalPaginas = Math.ceil(obj_pLista.Total / int_TamPaginaAlbum) == 0 ? 1 : Math.ceil(obj_pLista.Total / int_TamPaginaAlbum);
    $("#divPaginacionInfoBuscadorArtista").html("Página " + int_NumPaginaAlbum + " de " + int_TotalPaginas);

    $("#divPaginacionBuscadorArtista").unbind();
    $("#divPaginacionBuscadorArtista").bootpag({
        total: int_TotalPaginas,
        page: int_NumPaginaAlbum,
        maxVisible: obj_pLista.Total == 0 ? 1 : int_PagMostrar
    }).on('page', function (event, num) {
        ListarBusquedaArtista(num);
    });

    $("#divGrillaBuscadorArtista").html('');
    $("#divGrillaBuscadorArtista").append(obj_TablaPrincipal);

    var obj_Tabla = $('#tblBuscadorArtista').dataTable({
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

    $('#tblBuscadorArtista tbody').on('click', 'tr', function () {
        if ($(this).hasClass('selected')) {
            $(this).removeClass('selected');
        }
        else {
            obj_Tabla.$('tr.selected').removeClass('selected');
            $(this).addClass('selected');
        }
    });
}

function ObtenerRegistroBuscadorArtista() {
    var obj_Registro = null;
    var obj_Seleccion = $('#tblBuscadorArtista').find('.selected');
    if (obj_Seleccion.length > 0) {
        obj_Registro = new Object();
        obj_Registro.id = $(obj_Seleccion[0]).attr('value');
        obj_Registro.descripcion = $(obj_Seleccion[0]).attr('descripcion');
    }
    else
        AlertJQ(1, 'Seleccione un artista.');
    return obj_Registro;
}

