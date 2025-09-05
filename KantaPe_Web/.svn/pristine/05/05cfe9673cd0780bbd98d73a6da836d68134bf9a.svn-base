//Atributos
var int_NumPagina = 1;
var int_TamPagina = 10;
var int_PagMostrar = 9;
var urlEdicion = 'RegistroCancion.aspx';

$(function () {

    if ($("#hdEsAdministrador").val() == "N") {
        $("#ddlEmpresa").prop('disabled', true);
        $("#ddlLocal").prop('disabled', true);
        CargarLocal(true, $("#hdIdLocal").val());
    }

    $('#ddlEmpresa').change(function () {
        CargarLocal(true, null);
    });

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
    obj_Filtro.Titulo = $("#txtTitulo").val();
    obj_Filtro.Artista = $("#txtArtista").val();
    obj_Filtro.Album = $("#txtAlbum").val();

    obj_Filtro.IdGenero = null;
    if ($("#ddlGenero").val() != '')
        obj_Filtro.IdGenero = $("#ddlGenero").val();

    obj_Filtro.IdIdioma = null;
    if ($("#ddlIdioma").val() != '')
        obj_Filtro.IdIdioma = $("#ddlIdioma").val();

    obj_Filtro.Decada = $("#txtDecada").val();
    obj_Filtro.Anio = $("#txtAnio").val();

    obj_Filtro.IdCancionSolicitud = null;
    if ($("#ddlCancionSolicitud").val() != '')
        obj_Filtro.IdCancionSolicitud = $("#ddlCancionSolicitud").val();

    obj_Filtro.Estado = null;
    if ($("#ddlEstado").val() != '')
        obj_Filtro.Estado = $("#ddlEstado").val();

    obj_Filtro.IdEmpresa = null;
    if ($("#ddlEmpresa").val() != '')
        obj_Filtro.IdEmpresa = $("#ddlEmpresa").val();

    obj_Filtro.IdLocal = null;
    if ($("#ddlLocal").val() != '')
        obj_Filtro.IdLocal = $("#ddlLocal").val();

    if ($("#hdEsAdministrador").val() == "N") {
        obj_Filtro.IdEmpresa = $("#hdIdEmpresa").val();
        obj_Filtro.IdLocal = $("#hdIdLocal").val();
    }
    return obj_Filtro;
}

function ListarCancion(int_pNumPagina) {
    int_NumPagina = int_pNumPagina;
    var obj_Filtro = ObtenerFiltros();
    var obj_Data = {
        "str_pTitulo": obj_Filtro.Titulo,
        "str_pArtista": obj_Filtro.Artista,
        "str_pAlbum": obj_Filtro.Album,
        "int_pIdGenero": obj_Filtro.IdGenero,
        "int_pIdIdioma": obj_Filtro.IdIdioma,
        "str_pDecada": obj_Filtro.Decada,
        "str_pAnio": obj_Filtro.Anio,
        "int_pIdCancionSolicitud": obj_Filtro.IdCancionSolicitud,
        "str_pEstado": obj_Filtro.Estado,
        "int_pIdEmpresa": obj_Filtro.IdEmpresa,
        "int_pIdLocal": obj_Filtro.IdLocal,
        "int_pNumPagina": int_pNumPagina,
        "int_pTamPagina": int_TamPagina
    };
    AccionDefault(true, "Cancion.aspx/ListarCancion", obj_Data, CargarGrilla, null, null, null, 1);
}

function CargarGrilla(obj_pLista) {

    var obj_TablaPrincipal = $("<table id='tblCancion' class='table table-bordered table-hover dt-responsive'></table>");
    var obj_THead = $("<thead></thead>");
    var obj_FilaPrincipal = $("<tr></tr>");
    obj_FilaPrincipal.append($("<th style='width:10%;'>Artista</th>"));
    obj_FilaPrincipal.append($("<th style='width:10%;'>Album</th>"));
    obj_FilaPrincipal.append($("<th style='width:10%;'>Título</th>"));
    obj_FilaPrincipal.append($("<th style='width:10%;'>Género</th>"));
    obj_FilaPrincipal.append($("<th style='width:10%;'>Idioma</th>"));
    obj_FilaPrincipal.append($("<th style='width:5%;'>Década</th>"));
    obj_FilaPrincipal.append($("<th style='width:5%;'>Año</th>"));
    obj_FilaPrincipal.append($("<th style='width:10%;'>Solicitud</th>"));
    obj_FilaPrincipal.append($("<th style='width:10%;'>Estado</th>"));
    obj_FilaPrincipal.append($("<th style='width:10%;'>Empresa</th>"));
    obj_FilaPrincipal.append($("<th style='width:10%;'>Local</th>"));
    obj_THead.append(obj_FilaPrincipal);
    obj_TablaPrincipal.append(obj_THead);

    var str_Artista = '';
    var str_Album = '';
    var str_Genero = '';
    var str_Idioma = '';
    var str_Decada = '';
    var str_Anio = '';
    var str_CancionSolicitud = '';
    var str_Estado = '';
    var str_DesEmpresa = '';
    var str_DesLocal = '';

    var obj_TBody = $("<tbody></tbody>");
    for (var i = 0; i < obj_pLista.Result.length; i++) {

        str_Artista = '';
        str_Album = '';
        str_Genero = '';
        str_Idioma = '';
        str_Decada = '';
        str_Anio = '';
        str_CancionSolicitud = '';
        str_Estado = '';
        str_DesEmpresa = '';
        str_DesLocal = '';

        obj_FilaPrincipal = $("<tr value='" + obj_pLista.Result[i].IdLocalCancion + "'></tr>");

        if (obj_pLista.Result[i].Artista != null)
            str_Artista = obj_pLista.Result[i].Artista.Nombre;
        obj_FilaPrincipal.append($("<td>" + str_Artista + "</td>"));

        if (obj_pLista.Result[i].Album != null)
            str_Album = obj_pLista.Result[i].Album.Titulo;
        obj_FilaPrincipal.append($("<td>" + str_Album + "</td>"));

        obj_FilaPrincipal.append($("<td>" + obj_pLista.Result[i].Cancion.Descripcion + "</td>"));

        if (obj_pLista.Result[i].Genero != null)
            str_Genero = obj_pLista.Result[i].Genero.Descripcion;
        obj_FilaPrincipal.append($("<td>" + str_Genero + "</td>"));

        if (obj_pLista.Result[i].Idioma != null)
            str_Idioma = obj_pLista.Result[i].Idioma.Descripcion;
        obj_FilaPrincipal.append($("<td>" + str_Idioma + "</td>"));

        if (obj_pLista.Result[i].Decada != null)
            str_Decada = obj_pLista.Result[i].Decada;
        obj_FilaPrincipal.append($("<td>" + str_Decada + "</td>"));

        if (obj_pLista.Result[i].Anio != null)
            str_Anio = obj_pLista.Result[i].Anio;
        obj_FilaPrincipal.append($("<td>" + str_Anio + "</td>"));

        if (obj_pLista.Result[i].CancionSolicitud != null)
            str_CancionSolicitud = obj_pLista.Result[i].CancionSolicitud.Descripcion;
        obj_FilaPrincipal.append($("<td>" + str_CancionSolicitud + "</td>"));

        str_Estado = obj_pLista.Result[i].Estado == 'A' ? "Activo" : "Inactivo";
        obj_FilaPrincipal.append($("<td style='text-align:center'>" + str_Estado + "</td>"));

        if (obj_pLista.Result[i].DesEmpresa != null)
            str_DesEmpresa = obj_pLista.Result[i].DesEmpresa;
        obj_FilaPrincipal.append($("<td>" + str_DesEmpresa + "</td>"));

        if (obj_pLista.Result[i].DesLocal != null)
            str_DesLocal = obj_pLista.Result[i].DesLocal;
        obj_FilaPrincipal.append($("<td>" + str_DesLocal + "</td>"));


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
        AlertJQ(1, 'Seleccione un canción.');
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
    Accion('Cancion.aspx/ModificarEstado', { "int_pIdCancion": str_pId, "str_pEstado": str_pEstado }, function () { ListarCancion(1); });
}

function CargarLocal(bln_pAsync, int_pIdLocal) {

    var ddlLocal = $("#ddlLocal");
    ddlLocal.empty();
    ddlLocal.html('');
    ddlLocal.append($("<option value=''>--Seleccione--</option>"));

    var int_IdPersona = $("#ddlEmpresa").val();
    if (int_IdPersona != '') {
        var obj_Data = { "int_pIdPersona": int_IdPersona };
        AccionDefault(bln_pAsync, "Cancion.aspx/ListarLocal", obj_Data,
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