//Atributos
var int_NumPaginaAlbum = 1;
var int_TamPaginaAlbum = 5;
var int_PagMostrarAlbum = 9;

$(function () {

    $(document).keypress(function (e) {
        var blnMdBuscadorAlbum = ($("#mdBuscadorAlbum").data('bs.modal') || {}).isShown;
        if (blnMdBuscadorAlbum == undefined)
            blnMdBuscadorAlbum = false;

        if (blnMdBuscadorAlbum)
            if (e.which == 13) {
                $("#btnBuscarBuscadorAlbum").click();
                return false;
            }
    });

    $("#btnBuscarBuscadorAlbum").click(function () {
        ListarBusquedaAlbum(1);
        return false;
    });
});

function ObtenerFiltrosBuscadorAlbum() {
    var obj_Filtro = new Object();
    obj_Filtro.Nombre = $("#txtNombreBuscadorAlbum").val();
    obj_Filtro.Titulo = $("#txtTituloBuscadorAlbum").val();
    return obj_Filtro;
}

function ListarBusquedaAlbum(int_pNumPagina) {
    int_NumPaginaAlbum = int_pNumPagina;
    var obj_Filtro = ObtenerFiltrosBuscadorAlbum();
    var obj_Data = {
        "str_pNombre": obj_Filtro.Nombre,
        "str_pTitulo": obj_Filtro.Titulo,
        "int_pNumPagina": int_pNumPagina,
        "int_pTamPagina": int_TamPaginaAlbum
    };
    AccionDefault(true, UrlPath + "Comun.aspx/ListarAlbum", obj_Data, CargarGrillaBuscadorAlbum, null, null, null, 1);
}

function CargarGrillaBuscadorAlbum(obj_pLista) {

    var obj_TablaPrincipal = $("<table id='tblBuscadorAlbum' class='table table-bordered table-hover dt-responsive'></table>");
    var obj_THead = $("<thead></thead>");
    var obj_FilaPrincipal = $("<tr></tr>");
    obj_FilaPrincipal.append($("<th style='width:40%;'>Artista</th>"));
    obj_FilaPrincipal.append($("<th style='width:60%;'>Álbum</th>"));
    obj_THead.append(obj_FilaPrincipal);
    obj_TablaPrincipal.append(obj_THead);

    var obj_TBody = $("<tbody></tbody>");
    for (var i = 0; i < obj_pLista.Result.length; i++) {
        obj_FilaPrincipal = $("<tr idalbum='" + obj_pLista.Result[i].IdAlbum + "' idartista='" + obj_pLista.Result[i].IdArtista + "' nombre='" + obj_pLista.Result[i].Artista.Nombre + "' titulo='" + obj_pLista.Result[i].Titulo + "'></tr>");
        obj_FilaPrincipal.append($("<td>" + obj_pLista.Result[i].Artista.Nombre + "</td>"));
        obj_FilaPrincipal.append($("<td>" + obj_pLista.Result[i].Titulo + "</td>"));
        obj_TBody.append(obj_FilaPrincipal);
    }
    obj_TablaPrincipal.append(obj_TBody);

    var int_TotalPaginas = Math.ceil(obj_pLista.Total / int_TamPaginaAlbum) == 0 ? 1 : Math.ceil(obj_pLista.Total / int_TamPaginaAlbum);
    $("#divPaginacionInfoBuscadorAlbum").html("Página " + int_NumPaginaAlbum + " de " + int_TotalPaginas);

    $("#divPaginacionBuscadorAlbum").unbind();
    $("#divPaginacionBuscadorAlbum").bootpag({
        total: int_TotalPaginas,
        page: int_NumPaginaAlbum,
        maxVisible: obj_pLista.Total == 0 ? 1 : int_PagMostrar
    }).on('page', function (event, num) {
        ListarBusquedaAlbum(num);
    });

    $("#divGrillaBuscadorAlbum").html('');
    $("#divGrillaBuscadorAlbum").append(obj_TablaPrincipal);

    var obj_Tabla = $('#tblBuscadorAlbum').dataTable({
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

    $('#tblBuscadorAlbum tbody').on('click', 'tr', function () {
        if ($(this).hasClass('selected')) {
            $(this).removeClass('selected');
        }
        else {
            obj_Tabla.$('tr.selected').removeClass('selected');
            $(this).addClass('selected');
        }
    });
}

function ObtenerRegistroBuscadorAlbum() {
    var obj_Registro = null;
    var obj_Seleccion = $('#tblBuscadorAlbum').find('.selected');
    if (obj_Seleccion.length > 0) {
        obj_Registro = new Object();
        obj_Registro.idArtista = $(obj_Seleccion[0]).attr('idartista');
        obj_Registro.idAlbum = $(obj_Seleccion[0]).attr('idalbum');
        obj_Registro.artista = $(obj_Seleccion[0]).attr('nombre');
        obj_Registro.album = $(obj_Seleccion[0]).attr('titulo');
        obj_Registro.artistaAlbum = obj_Registro.artista + ' - ' + obj_Registro.album;
    }
    else
        AlertJQ(1, 'Seleccione un álbum.');
    return obj_Registro;
}

