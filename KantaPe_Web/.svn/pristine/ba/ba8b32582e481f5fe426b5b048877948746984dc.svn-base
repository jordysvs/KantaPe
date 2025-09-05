$(function () {
    CargarInicial();
    CargarControles();
});

function CargarInicial() {
}

function CargarControles() {

    $("#btnExportar").click(function () {
        //var obj_Filtro = ObtenerFiltros();
        //$('body').prepend("<form id='excelForm' method='post' action='../../Ashx/ReporteVehiculoExcelHandler.ashx'>" +
        //    "<input type='hidden' name='str_pPlaca' value='" + obj_Filtro.Placa + "' >" +
        //    "<input type='hidden' name='str_pCodigoLlanta' value='" + obj_Filtro.CodigoLlanta + "' >" +
        //    "<input type='hidden' name='str_pIdVehiculoTipo' value='" + obj_Filtro.IdVehiculoTipoToString + "' >" +
        //    "<input type='hidden' name='str_pIncompleto' value='" + obj_Filtro.Incompleto + "' >" +
        //    "</form>");
        //$('#excelForm').submit();
        //$("excelForm").remove();
        //return false;
    });

    $("#btnBuscar").click(function () {
        ListarReporte();
        return false;
    });

    //CargarGrilla(null);
    ListarReporte();
}

function ObtenerFiltros() {
    var obj_Filtro = new Object();

    //obj_Filtro.Placa = $("#txtPlaca").val();
    //obj_Filtro.CodigoLlanta = $("#txtCodigoLlanta").val();
    //obj_Filtro.Incompleto = $("#ddlLlantas").val();;

    //obj_Filtro.IdVehiculoTipo = null;
    //obj_Filtro.IdVehiculoTipoToString = '';
    //if ($("#ddlVehiculoTipo").val() != '') {
    //    obj_Filtro.IdVehiculoTipo = $("#ddlVehiculoTipo").val();
    //    obj_Filtro.IdVehiculoTipoToString = $("#ddlVehiculoTipo").val();
    //}

    return obj_Filtro;
}

function ListarReporte() {
    var obj_Filtro = ObtenerFiltros();
    //var obj_Data = {
    //    "str_pPlaca": obj_Filtro.Placa,
    //    "str_pCodigoLlanta": obj_Filtro.CodigoLlanta,
    //    "int_pIdVehiculoTipo": obj_Filtro.IdVehiculoTipo,
    //    "str_pIncompleto": obj_Filtro.Incompleto
    //};
    //AccionDefault(true, "ReporteVehiculo.aspx/ListarReporte", obj_Data, CargarGrilla, null, null, null, 1);

    var lst_Lista = [];
    var obj_Item = new Object();
    obj_Item.Item1 = "Norkys";
    obj_Item.Item2 = "Soprano Av. Arequipa";
    obj_Item.Item3 = "01/07/2016";
    obj_Item.Item4 = "Juan Perez";
    obj_Item.Item5 = "Mesa";
    obj_Item.Item6 = "01";
    obj_Item.Item7 = "Marlon Rivera";
    obj_Item.Item8 = "Mesa";
    obj_Item.Item9 = "02";
    obj_Item.Item10 = "Mana";
    obj_Item.Item11 = "La cama incendiada";
    obj_Item.Item12 = "Cama Incendiada";
    obj_Item.Item13 = "Rock";
    obj_Item.Item14 = "Español Latino";
    lst_Lista.push(obj_Item);

    obj_Item = new Object();
    obj_Item.Item1 = "Norkys";
    obj_Item.Item2 = "Soprano Av. La Molina";
    obj_Item.Item3 = "01/07/2016";
    obj_Item.Item4 = "Carlos Rojas";
    obj_Item.Item5 = "Mesa";
    obj_Item.Item6 = "03";
    obj_Item.Item7 = "Miguel Cabrera";
    obj_Item.Item8 = "Mesa";
    obj_Item.Item9 = "05";
    obj_Item.Item10 = "Mana";
    obj_Item.Item11 = "En el muelle de san blas";
    obj_Item.Item12 = "Cama Incendiada";
    obj_Item.Item13 = "Rock";
    obj_Item.Item14 = "Español Latino";
    lst_Lista.push(obj_Item);

    CargarGrilla(lst_Lista)
}

function CargarGrilla(obj_pLista) {

    var btn_Excel = $('#btnExportar');
    btn_Excel.css('display', 'none');

    var obj_TablaPrincipal = $("<table id='tblReporte' class='table table-bordered' style='width:99%;'></table>");
    var obj_THead = $("<thead></thead>");
    var obj_FilaPrincipal = $("<tr></tr>");
    obj_FilaPrincipal.append($("<th style='width:15%'>Empresa</th>"));
    obj_FilaPrincipal.append($("<th style='width:15%'>Local</th>"));
    obj_FilaPrincipal.append($("<th style='width:15%'>Fecha</th>"));
    obj_FilaPrincipal.append($("<th style='width:15%'>Usuario 1</th>"));
    obj_FilaPrincipal.append($("<th style='width:15%'>Tipo de Ubicación</th>"));
    obj_FilaPrincipal.append($("<th style='width:15%'>Ubicación</th>"));
    obj_FilaPrincipal.append($("<th style='width:15%'>Usuario 2</th>"));
    obj_FilaPrincipal.append($("<th style='width:15%'>Tipo de Ubicación</th>"));
    obj_FilaPrincipal.append($("<th style='width:15%'>Ubicación</th>"));
    obj_FilaPrincipal.append($("<th style='width:15%'>Artista</th>"));
    obj_FilaPrincipal.append($("<th style='width:15%'>Titulo</th>"));
    obj_FilaPrincipal.append($("<th style='width:15%'>Album</th>"));
    obj_FilaPrincipal.append($("<th style='width:15%'>Género</th>"));
    obj_FilaPrincipal.append($("<th style='width:15%'>Idioma</th>"));
    obj_THead.append(obj_FilaPrincipal);
    obj_TablaPrincipal.append(obj_THead);

    if (obj_pLista != null) {
        var obj_TBody = $("<tbody></tbody>");
        for (var i = 0; i < obj_pLista.length; i++) {
            obj_FilaPrincipal = $("<tr></tr>");
            obj_FilaPrincipal.append($("<td>" + obj_pLista[i].Item1 + "</td>"));
            obj_FilaPrincipal.append($("<td>" + obj_pLista[i].Item2 + "</td>"));
            obj_FilaPrincipal.append($("<td>" + obj_pLista[i].Item3 + "</td>"));
            obj_FilaPrincipal.append($("<td>" + obj_pLista[i].Item4 + "</td>"));
            obj_FilaPrincipal.append($("<td>" + obj_pLista[i].Item5 + "</td>"));
            obj_FilaPrincipal.append($("<td>" + obj_pLista[i].Item6 + "</td>"));
            obj_FilaPrincipal.append($("<td>" + obj_pLista[i].Item7 + "</td>"));
            obj_FilaPrincipal.append($("<td>" + obj_pLista[i].Item8 + "</td>"));
            obj_FilaPrincipal.append($("<td>" + obj_pLista[i].Item9 + "</td>"));
            obj_FilaPrincipal.append($("<td>" + obj_pLista[i].Item10 + "</td>"));
            obj_FilaPrincipal.append($("<td>" + obj_pLista[i].Item11 + "</td>"));
            obj_FilaPrincipal.append($("<td>" + obj_pLista[i].Item12 + "</td>"));
            obj_FilaPrincipal.append($("<td>" + obj_pLista[i].Item13 + "</td>"));
            obj_FilaPrincipal.append($("<td>" + obj_pLista[i].Item14 + "</td>"));
            obj_TBody.append(obj_FilaPrincipal);
        }
        obj_TablaPrincipal.append(obj_TBody);

        ListarGraficoVersus(obj_pLista);
        //ListarGraficoDuracion(obj_pLista);

        if (obj_pLista.length > 0)
            btn_Excel.css('display', '');
    }

    $("#divGrilla").html('');
    $("#divGrilla").append(obj_TablaPrincipal);

    var obj_Tabla = $('#tblReporte').dataTable({
        "scrollX": true,
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
}

function ListarGraficoVersus(obj_pLista) {
    var obj_data = [];
    var obj_tick = [];

    obj_data.push([0, 8]);
    obj_data.push([1, 7]);
    obj_data.push([2, 6]);
    obj_data.push([3, 5]);
    obj_data.push([4, 5]);
    obj_data.push([5, 5]);
    obj_data.push([6, 4]);
    obj_data.push([7, 4]);
    obj_data.push([8, 3]);
    obj_data.push([9, 3]);
    obj_data.push([10, 2]);

    obj_tick.push([0, "En el muelle de san blas<br>Mana<br>(Soprano Av. Arequipa)"]);
    obj_tick.push([1, "La cama incendiada<br>Mana<br>(Soprano Av. Arequipa)"]);
    obj_tick.push([2, "La sirena<br>Mana<br>(Soprano Av. La Marina)"]);
    obj_tick.push([3, "Me voy a convertir en un ave<br>Mana<br>(Soprano Av. La Molina)"]);
    obj_tick.push([4, "Tú tienes lo que quiero<br>Mana<br>(Soprano Av. Miraflores)"]);
    obj_tick.push([5, "Un lobo por tu amor<br>Mana<br>(Soprano Av. Molina)"]);
    obj_tick.push([6, "Como dueles en los labios<br>Mana<br>(Soprano Av. Arequipa)"]);
    obj_tick.push([7, "Chamán<br>Mana<br>(Soprano Av. Miraflores)"]);
    obj_tick.push([8, "Tú tienes lo que quiero<br>Mana<br>(Soprano Av. Arequipa)"]);
    obj_tick.push([9, "Clavado en un bar<br>Mana<br>(Soprano Av. Marina)"]);
    obj_tick.push([10, "Me voy a convertir en un ave<br>Mana<br>(Soprano Av. Molina)"]);

    var series = {
        color: "#3c8dbc",
        data: obj_data,
        lines: { show: false },
        bars: { show: true, barWidth: 0.5, align: 'center' }
    }

    somePlot = $.plot("#divGrafico1", [series], {
        grid: {
            hoverable: true,
            borderWidth: 1,
            borderColor: "#f3f3f3",
            tickColor: "#f3f3f3"
        },
        series: {
            bars: {
                show: true,
                barWidth: 0.5,
                align: "center"
            }
        },
        xaxis: {
            mode: "categories",
            ticks: obj_tick
        },
        tooltip: true,
        tooltipOpts: {
            content: "%y"
        }
    });

    var ctx = somePlot.getCanvas().getContext("2d");
    var data = somePlot.getData()[0].data;
    var xaxis = somePlot.getXAxes()[0];
    var yaxis = somePlot.getYAxes()[0];
    var offset = somePlot.getPlotOffset();
    ctx.font = "12px 'Segoe UI'";
    ctx.fillStyle = "black";
    for (var i = 0; i < data.length; i++) {
        var text = data[i][1] + '';
        var metrics = ctx.measureText(text);
        var xPos = (xaxis.p2c(data[i][0]) + offset.left) - metrics.width / 2;
        var yPos = yaxis.p2c(data[i][1]) + offset.top - 5;
        ctx.fillText(text, xPos, yPos);
    }
}

function ListarGraficoDuracion(obj_pLista) {
    var obj_data = [];
    var obj_tick = [];

    obj_data.push([0, 360]);
    obj_data.push([1, 240]);
    obj_data.push([2, 120]);
    obj_data.push([3, 110]);
    obj_data.push([4, 100]);

    obj_tick.push([0, "01<br>(Soprano Av. Arequipa)"]);
    obj_tick.push([1, "02<br>(Soprano Av. Arequipa)"]);
    obj_tick.push([2, "01<br>(Soprano Av. La Marina)"]);
    obj_tick.push([3, "02<br>(Soprano Av. La Molina)"]);
    obj_tick.push([4, "03<br>(Soprano Av. Miraflores)"]);

    var series = {
        color: "#3c8dbc",
        data: obj_data,
        lines: { show: false },
        bars: { show: true, barWidth: 0.5, align: 'center' }
    }

    somePlot = $.plot("#divGrafico2", [series], {
        grid: {
            hoverable: true,
            borderWidth: 1,
            borderColor: "#f3f3f3",
            tickColor: "#f3f3f3"
        },
        series: {
            bars: {
                show: true,
                barWidth: 0.5,
                align: "center"
            }
        },
        xaxis: {
            mode: "categories",
            ticks: obj_tick
        },
        tooltip: true,
        tooltipOpts: {
            content: "%y"
        }
    });

    var ctx = somePlot.getCanvas().getContext("2d");
    var data = somePlot.getData()[0].data;
    var xaxis = somePlot.getXAxes()[0];
    var yaxis = somePlot.getYAxes()[0];
    var offset = somePlot.getPlotOffset();
    ctx.font = "12px 'Segoe UI'";
    ctx.fillStyle = "black";
    for (var i = 0; i < data.length; i++) {
        var text = data[i][1] + '';
        var metrics = ctx.measureText(text);
        var xPos = (xaxis.p2c(data[i][0]) + offset.left) - metrics.width / 2;
        var yPos = yaxis.p2c(data[i][1]) + offset.top - 5;
        ctx.fillText(text, xPos, yPos);
    }
}

//function ListarGraficoVehiculosIncompletos(obj_pLista) {
//    var obj_data = [];
//    var obj_tick = [];

//    var bln_Existe = false;
//    var lst_Vehiculos = [];
//    var obj_Vehiculo = null;

//    //Obtener Vehiculo
//    for (var i = 0; i < obj_pLista.length; i++) {
//        bln_Existe = false;
//        for (var j = 0; j < lst_Vehiculos.length; j++) {
//            if (lst_Vehiculos[j].IdVehiculo == obj_pLista[i].IdVehiculo) {
//                bln_Existe = true;
//                break;
//            }
//        }
//        if (!bln_Existe) {
//            obj_Vehiculo = new Object();
//            obj_Vehiculo.IdVehiculo = obj_pLista[i].IdVehiculo;
//            obj_Vehiculo.LlantaTotal = 0;
//            obj_Vehiculo.Total = 0;
//            lst_Vehiculos.push(obj_Vehiculo);
//        }
//    }

//    for (var i = 0; i < obj_pLista.length; i++) {
//        for (var j = 0; j < lst_Vehiculos.length; j++) {
//            if (lst_Vehiculos[j].IdVehiculo == obj_pLista[i].IdVehiculo) {
//                if (obj_pLista[i].IdLlanta != null)
//                    lst_Vehiculos[j].LlantaTotal += 1;
//                lst_Vehiculos[j].Total += 1;
//            }
//        }
//    }

//    var lst_VehiculoReporte = [];

//    var obj_VehiculoReporte = new Object();
//    obj_VehiculoReporte.Descripcion = 'Vehiculos Bloqueados';
//    obj_VehiculoReporte.Total = 0;
//    lst_VehiculoReporte.push(obj_VehiculoReporte);

//    var obj_VehiculoReporteCompleto = new Object();
//    obj_VehiculoReporteCompleto.Descripcion = 'Vehiculos Habilitados';
//    obj_VehiculoReporteCompleto.Total = 0;
//    lst_VehiculoReporte.push(obj_VehiculoReporteCompleto);


//    for (var j = 0; j < lst_Vehiculos.length; j++) {
//        if (lst_Vehiculos[j].Total == lst_Vehiculos[j].LlantaTotal)
//            obj_VehiculoReporteCompleto.Total += 1;
//        else
//            obj_VehiculoReporte.Total += 1;
//    }

//    for (var j = 0; j < lst_VehiculoReporte.length; j++) {
//        obj_data.push([j, lst_VehiculoReporte[j].Total]);
//        obj_tick.push([j, lst_VehiculoReporte[j].Descripcion]);
//    }

//    var series = {
//        color: "#3c8dbc",
//        data: obj_data,
//        lines: { show: false },
//        bars: { show: true, barWidth: 0.5, align: 'center' }
//    }

//    somePlot = $.plot("#divLlantasIncompletas", [series], {
//        grid: {
//            hoverable: true,
//            borderWidth: 1,
//            borderColor: "#f3f3f3",
//            tickColor: "#f3f3f3"
//        },
//        series: {
//            bars: {
//                show: true,
//                barWidth: 0.5,
//                align: "center"
//            }
//        },
//        xaxis: {
//            mode: "categories",
//            ticks: obj_tick
//        },
//        tooltip: true,
//        tooltipOpts: {
//            content: "%y"
//        }
//    });

//    var ctx = somePlot.getCanvas().getContext("2d");
//    var data = somePlot.getData()[0].data;
//    var xaxis = somePlot.getXAxes()[0];
//    var yaxis = somePlot.getYAxes()[0];
//    var offset = somePlot.getPlotOffset();
//    ctx.font = "12px 'Segoe UI'";
//    ctx.fillStyle = "black";
//    for (var i = 0; i < data.length; i++) {
//        var text = data[i][1] + '';
//        var metrics = ctx.measureText(text);
//        var xPos = (xaxis.p2c(data[i][0]) + offset.left) - metrics.width / 2;
//        var yPos = yaxis.p2c(data[i][1]) + offset.top - 5;
//        ctx.fillText(text, xPos, yPos);
//    }
//}


//function ListarGraficoTipoIncompletos(obj_pLista) {
//    var obj_tick = [];
//    var obj_data = [];
//    var bln_Existe = false;

//    //Obtener Vehiculo
//    var lst_Vehiculos = [];
//    var obj_Vehiculo = null;

//    for (var i = 0; i < obj_pLista.length; i++) {
//        bln_Existe = false;
//        for (var j = 0; j < lst_Vehiculos.length; j++) {
//            if (lst_Vehiculos[j].IdVehiculo == obj_pLista[i].IdVehiculo) {
//                bln_Existe = true;
//                break;
//            }
//        }
//        if (!bln_Existe) {
//            obj_Vehiculo = new Object();
//            obj_Vehiculo.IdVehiculo = obj_pLista[i].IdVehiculo;
//            obj_Vehiculo.IdVehiculoTipo = obj_pLista[i].Vehiculo.IdVehiculoTipo;
//            obj_Vehiculo.VehiculoTipo = obj_pLista[i].Vehiculo.Tipo.Descripcion;
//            obj_Vehiculo.LlantaTotal = 0;
//            obj_Vehiculo.Total = 0;
//            lst_Vehiculos.push(obj_Vehiculo);
//        }
//    }

//    for (var i = 0; i < obj_pLista.length; i++) {
//        for (var j = 0; j < lst_Vehiculos.length; j++) {
//            if (lst_Vehiculos[j].IdVehiculo == obj_pLista[i].IdVehiculo) {
//                if (obj_pLista[i].IdLlanta != null)
//                    lst_Vehiculos[j].LlantaTotal += 1;
//                lst_Vehiculos[j].Total += 1;
//            }
//        }
//    }


//    var lst_Tipo = [];
//    var obj_TIpo = null;

//    var lst_Tipo = ObtenerData("ReporteVehiculo.aspx/ListarVehiculoTipo", {});
//    for (var j = 0; j < lst_Tipo.length; j++) {
//        lst_Tipo[j].Total = 0;
//    }

//    for (var i = 0; i < lst_Vehiculos.length; i++) {
//        for (var j = 0; j < lst_Tipo.length; j++) {
//            if (lst_Tipo[j].IdVehiculoTipo == lst_Vehiculos[i].IdVehiculoTipo) {
//                if (!(lst_Vehiculos[i].Total == lst_Vehiculos[i].LlantaTotal))
//                    lst_Tipo[j].Total += 1;
//            }
//        }
//    }

//    for (var j = 0; j < lst_Tipo.length; j++) {
//        obj_data.push([j, lst_Tipo[j].Total]);
//        obj_tick.push([j, lst_Tipo[j].Descripcion]);
//    }

//    var series = {
//        color: "#3c8dbc",
//        data: obj_data,
//        lines: { show: false },
//        bars: { show: true, barWidth: 0.5, align: 'center' }
//    }

//    somePlot = $.plot("#divTipoIncompletas", [series], {
//        grid: {
//            hoverable: true,
//            borderWidth: 1,
//            borderColor: "#f3f3f3",
//            tickColor: "#f3f3f3"
//        },
//        series: {
//            bars: {
//                show: true,
//                barWidth: 0.5,
//                align: "center"
//            }
//        },
//        xaxis: {
//            mode: "categories",
//            ticks: obj_tick
//        },
//        tooltip: true,
//        tooltipOpts: {
//            content: "%y"
//        }
//    });

//    var ctx = somePlot.getCanvas().getContext("2d");
//    var data = somePlot.getData()[0].data;
//    var xaxis = somePlot.getXAxes()[0];
//    var yaxis = somePlot.getYAxes()[0];
//    var offset = somePlot.getPlotOffset();
//    ctx.font = "12px 'Segoe UI'";
//    ctx.fillStyle = "black";
//    for (var i = 0; i < data.length; i++) {
//        var text = data[i][1] + '';
//        var metrics = ctx.measureText(text);
//        var xPos = (xaxis.p2c(data[i][0]) + offset.left) - metrics.width / 2;
//        var yPos = yaxis.p2c(data[i][1]) + offset.top - 5;
//        ctx.fillText(text, xPos, yPos);
//    }
//}
