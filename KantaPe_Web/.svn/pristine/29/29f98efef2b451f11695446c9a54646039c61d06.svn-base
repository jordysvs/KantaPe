//Atributos
var int_NumPagina = 1;
var int_TamPagina = 10;
var int_PagMostrar = 9;
var urlEdicion = 'RegistroUbicacion.aspx';
var urlPrincipal = 'Ubicacion.aspx';
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
        ListarUbicacion(1);
        return false;
    });

    KeyPressEnter("divFiltro",
        function () {
            $("#btnBuscar").click();
        });

    $("#btnBuscar").focus();

    $("#btnGenerarQR").click(function () {
        //$("#txtCode").prop('disabled', true);
        var int_IdEmpresa = "";
        var int_IdLocal = "";
        var int_Ubicacion = "";
        var str_pCodigo = "";
        var obj_Key = obtenerIdRegistro();
        if (obj_Key[0] != null) {


            int_IdLocal = obj_Key[0];
            int_Ubicacion = obj_Key[1];
            //int_IdEmpresa = obj_Key[2];
            str_pCodigo = int_IdLocal + "~" + int_Ubicacion;

            var str_CodigoQR = str_pCodigo;
            $("#imgCtrl").attr('src', UrlPath + 'Ashx/GenerarCodigoQR.ashx?str_CodigoQR=' + str_CodigoQR);

            //$("#txtCode").val(str_pCodigo);
            var obj_modal = $("#mdCodigoQR").modal('show', {
                backdrop: true,
                keyboard: false,
            });
        }
        return false;
    });

    //CANCELAR MODAL
    $("#mdCodigoQR").find('.modal-footer .btn-cancelar').click(function () {
        $("#mdCodigoQR").modal('hide');
    });
    //IMPRIMIR MODAL
    $("#mdCodigoQR").find('.modal-footer .btn-aceptar').click(function () {
        var obj_Key = obtenerIdRegistro();
        int_NumeroMesa = obj_Key[3];
        var str_Titulo = "";

        str_Titulo = "<h3>Mesa número </h3>" + int_NumeroMesa;
        str_Imagen = $("#imgCtrl").get(0).outerHTML;
        str_HTML = "";
        str_HTML += str_Titulo;
        str_HTML += "<br />";
        str_HTML += "<br />";
        str_HTML += str_Imagen;

        ExportarDocumento("PDF", str_HTML, null, true);
        return false;
    });

    //#mdialTamanio{
    //    width: 80% !important;
    //}
    ListarUbicacion(1);
});

function Imprimir() {
    //var obj_Registro = ObtenerReporte();
    //if (obj_Registro != null) {
    ImprimirActa("Ubicacion.aspx", null);
    //}
}

function ObtenerFiltros() {
    var obj_Filtro = new Object();

    obj_Filtro.IdEmpresa = null;
    if ($("#ddlEmpresa").val() != '')
        obj_Filtro.IdEmpresa = $("#ddlEmpresa").val();

    obj_Filtro.IdLocal = null;
    if ($("#ddlLocal").val() != '')
        obj_Filtro.IdLocal = $("#ddlLocal").val();

    obj_Filtro.IdUbicacionTipo = null;
    if ($("#ddlUbicacionTipo").val() != '')
        obj_Filtro.IdUbicacionTipo = $("#ddlUbicacionTipo").val();

    obj_Filtro.Numero = $("#txtNumero").val();

    obj_Filtro.Estado = null;
    if ($("#ddlEstado").val() != '')
        obj_Filtro.Estado = $("#ddlEstado").val();


    if ($("#hdEsAdministrador").val() == "N") {
        obj_Filtro.IdEmpresa = $("#hdIdEmpresa").val();
        obj_Filtro.IdLocal = $("#hdIdLocal").val();
    }


    return obj_Filtro;
}

function CargarLocal(bln_pAsync, int_pIdLocal) {

    var ddlLocal = $("#ddlLocal");
    ddlLocal.empty();
    ddlLocal.html('');
    ddlLocal.append($("<option value=''>--Seleccione--</option>"));

    var int_IdPersona = $("#ddlEmpresa").val();
    if (int_IdPersona != '') {
        var obj_Data = { "int_pIdPersona": int_IdPersona };
        AccionDefault(bln_pAsync, "Ubicacion.aspx/ListarLocal", obj_Data,
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

function ListarUbicacion(int_pNumPagina) {
    int_NumPagina = int_pNumPagina;
    var obj_Filtro = ObtenerFiltros();
    var obj_Data = {
        "int_pIdEmpresa": obj_Filtro.IdEmpresa,
        "int_pIdLocal": obj_Filtro.IdLocal,
        "int_pIdUbicacionTipo": obj_Filtro.IdUbicacionTipo,
        "str_pNumero": obj_Filtro.Numero,
        "str_pEstado": obj_Filtro.Estado,
        "int_pNumPagina": int_NumPagina,
        "int_pTamPagina": int_TamPagina
    };
    AccionDefault(true, "Ubicacion.aspx/ListarUbicacion", obj_Data, CargarGrilla, null, null, null, 1);
}

function CargarGrilla(obj_pLista) {

    var obj_TablaPrincipal = $("<table id='tblUbicacion' class='table table-bordered table-hover dt-responsive'></table>");
    var obj_THead = $("<thead></thead>");
    var obj_FilaPrincipal = $("<tr></tr>");
    obj_FilaPrincipal.append($("<th style='width:20%;'>Empresa</th>"));
    obj_FilaPrincipal.append($("<th style='width:20%;'>Local</th>"));
    obj_FilaPrincipal.append($("<th style='width:20%;'>Tipo</th>"));
    obj_FilaPrincipal.append($("<th style='width:30%;'>Número</th>"));
    obj_FilaPrincipal.append($("<th style='width:10%;'>Estado</th>"));
    obj_THead.append(obj_FilaPrincipal);
    obj_TablaPrincipal.append(obj_THead);

    var str_Estado = '';

    var obj_TBody = $("<tbody></tbody>");
    for (var i = 0; i < obj_pLista.Result.length; i++) {

        obj_FilaPrincipal = $("<tr idlocal='" + obj_pLista.Result[i].IdLocal + "' idubicacion='" + obj_pLista.Result[i].IdUbicacion + "' idempresa='" + obj_pLista.Result[i].Local.Empresa.IdEmpresa + "' nroMesa='" + obj_pLista.Result[i].Numero + "'></tr>");
        obj_FilaPrincipal.append($("<td>" + obj_pLista.Result[i].Local.Empresa.NombreComercial + "</td>"));
        obj_FilaPrincipal.append($("<td>" + obj_pLista.Result[i].Local.Nombre + "</td>"));
        obj_FilaPrincipal.append($("<td>" + obj_pLista.Result[i].UbicacionTipo.Descripcion + "</td>"));
        obj_FilaPrincipal.append($("<td>" + obj_pLista.Result[i].Numero + "</td>"));
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
        ListarUbicacion(num);
    });

    $("#divGrilla").html('');
    $("#divGrilla").append(obj_TablaPrincipal);

    var obj_Tabla = $('#tblUbicacion').dataTable({
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

    $('#tblUbicacion tbody').on('click', 'tr', function () {
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
    var obj_Key = [];
    var obj_Seleccion = $('#tblUbicacion').find('.selected');
    if (obj_Seleccion.length > 0) {
        obj_Key.push($(obj_Seleccion[0]).attr('idlocal'));
        obj_Key.push($(obj_Seleccion[0]).attr('idubicacion'));
        obj_Key.push($(obj_Seleccion[0]).attr('idempresa'));
        obj_Key.push($(obj_Seleccion[0]).attr('nroMesa'));

    }
    else
        AlertJQ(1, 'Seleccione una ubicación.');
    return obj_Key;
}

function Editar() {
    var obj_Key = obtenerIdRegistro();
    if (obj_Key.length > 0) {
        MostrarMensajeCargando();
        document.location.href = urlEdicion + "?id=" + obj_Key[0] + "&id2=" + obj_Key[1];
    }
}

function Activar() {
    var obj_Key = obtenerIdRegistro();
    if (obj_Key.length > 0) {
        ConfirmJQ('¿Está seguro de activar la ubicación?', ModificarEstado, [obj_Key, 'A']);
    }
}

function Inactivar() {
    var obj_Key = obtenerIdRegistro();
    if (obj_Key.length > 0) {
        ConfirmJQ('¿Está seguro de inactivar la ubicación?', ModificarEstado, [obj_Key, 'I']);
    }
}

function ModificarEstado(obj_pKey, str_pEstado) {
    Accion('Ubicacion.aspx/ModificarEstado', {
        "int_pIdLocal": obj_pKey[0],
        "int_pIdUbicacion": obj_pKey[1],
        "str_pEstado": str_pEstado
    }, function () { ListarUbicacion(1); });
}