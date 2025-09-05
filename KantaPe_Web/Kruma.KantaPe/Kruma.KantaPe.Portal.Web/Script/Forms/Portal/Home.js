$(function () {
    ListarKaraokes();
    $("#mdKaraoke").find('.modal-footer .btn-cancelar').click(function () {
        $("#mdKaraoke").modal('hide');
    });
});

function ListarKaraokes() {
    AccionDefault(true, "Home.aspx/ListarKaraokes", {}, CargarGrillaKaraokes, null, null, null, 1);
}

//Carga la grilla de cursos
function CargarGrillaKaraokes(obj_pLista) {

    var int_Indice = 0;
    var int_Columnas = 2;
    var str_HTML = "";

    var div_Karaokes = $("#divKaraokes");
    div_Karaokes.html('');

    if (obj_pLista.Result.length <= 0) {
        str_HTML += "<div class='col-lg-12' align='center' style='margin-top: 25px;'>No tiene locales registrados en el sistema.</div>";
        div_Karaokes.append(str_HTML);
    }
    else {
        var str_Titulo = '';
        var str_ImagenURL = '';
        var str_Direccion = '';
        var str_Telefono = '';
        var str_Mail = '';

        for (var i = 0; i < obj_pLista.Result.length; i++) {

            str_Titulo = '';
            str_ImagenURL = '';
            str_Direccion = '';
            str_Telefono = '';
            str_Mail = '';

            if (int_Indice == 0) {
                div_Row = $("<div class='row'></div>");
                div_Karaokes.append(div_Row);
            }

            if (obj_pLista.Result[i].IdLocal != null) {
                str_Titulo = obj_pLista.Result[i].Nombre.toUpperCase();
                str_ImagenURL = obj_pLista.Result[i].ImagenURL;
                str_Direccion = obj_pLista.Result[i].Direccion;
                str_Telefono = obj_pLista.Result[i].Telefono;
                str_Mail = obj_pLista.Result[i].Mail;
            }

            if (str_Telefono != '' && str_Telefono != null)
                str_Direccion += ' - ' + str_Telefono;
            if (str_Mail != '' && str_Mail != null)
                str_Direccion += ' - ' + str_Mail;

            str_HTML = '';
            str_HTML += "<div class='col-lg-6 col-md-6 col-sm-6 col-xs-12'>";
            str_HTML += "<table class='celdaKaraoke'>";
            str_HTML += "<tbody>";
            str_HTML += "<tr>";
            str_HTML += "<td align='center' style='position:relative; background-color:black;'>";
            str_HTML += "<img alt='' src='" + str_ImagenURL + "'  />"
            str_HTML += "<div style='background-color:transparent;padding:10px;top:0px;position:absolute;width:100%;color:white;'>" + str_Titulo + "</div>";
            str_HTML += "<div style='background-color:#28309B;bottom:0px;position:absolute;width:100%;padding:10px;opacity:0.8;color:white;'>";
            str_HTML += "<div style='width:100%;text-overflow:ellipsis;white-space:nowrap;overflow:hidden;'>";
            str_HTML += "<div class='row'>";
            str_HTML += "<div class='col-lg-12 col-md-12 col-sm-12 col-xs-12'>" + str_Direccion + "</div>";
            str_HTML += "<br>";
            str_HTML += "<br>";
            str_HTML += "<div class='col-lg-4 col-md-2 col-sm-2 col-xs-4'><a href='#' Onclick='MostrarRanking(" + obj_pLista.Result[i].IdLocal + ");return false;' style='color:white;'>RANKING</a></div>";
            str_HTML += "<div class='col-lg-4 col-md-2 col-sm-2 col-xs-4'><a href='#' Onclick='MostrarOfertas(" + obj_pLista.Result[i].IdLocal + ");return false;' style='color:white;'>OFERTAS</a></div>";
            str_HTML += "<div class='col-lg-4 col-md-2 col-sm-2 col-xs-4'><a href='#' Onclick='MostrarEventos(" + obj_pLista.Result[i].IdLocal + ");return false;' style='color:white;'>EVENTOS</a></div></div>";
            str_HTML += "</div>";
            str_HTML += "</div>";
            str_HTML += "</td>";
            str_HTML += "</tr>";
            str_HTML += "</tbody>";
            str_HTML += "</table>";
            str_HTML += "</div>";
            div_Row.append($(str_HTML));

            int_Indice += 1;
            if (int_Indice == int_Columnas)
                int_Indice = 0;
        }
    }
}

function MostrarRanking(int_pIdLocal) {
    AccionDefault(true, "Home.aspx/ListarRanking", { "int_pIdLocal": int_pIdLocal }, CargarGrillaRanking, ['RANKING'], null, null, 1);
}

function MostrarOfertas(int_pIdLocal) {
    AccionDefault(true, "Home.aspx/ListarOfertas", { "int_pIdLocal": int_pIdLocal }, CargarGrilla, ['OFERTAS'], null, null, 1);
}

//Lista de Rankiados
function MostrarEventos(int_pIdLocal) {
    AccionDefault(true, "Home.aspx/ListarEventos", { "int_pIdLocal": int_pIdLocal }, CargarGrilla, ['EVENTOS'], null, null, 1);
}

//Carga la grilla de cursos
function CargarGrilla(obj_pLista, str_pTitulo) {

    var int_IndiceColumna = 0;
    var int_IndiceItem = 0;
    var obj_circulo = null;
    var obj_item = null;
    var obj_row = null;
    var obj_imagen = null;

    var div_Lista = $("#Carrousel");
    div_Lista.html('');

    var int_Columna = 3;
    var str_Id = 'Detalle';
    var obj_carousel = $("<div></div>");
    obj_carousel.attr('id', str_Id);
    obj_carousel.attr('data-ride', 'carousel');
    obj_carousel.addClass('carousel slide');
    //circulos
    var obj_indicador = $("<ol></ol>");
    obj_indicador.addClass('carousel-indicators')
    obj_indicador.css('display', 'none');
    obj_carousel.append(obj_indicador);
    //items
    var obj_coleccion = $("<div></div>");
    obj_coleccion.addClass('carousel-inner')
    obj_carousel.append(obj_coleccion);
    //controles
    var obj_controlIzquierdo =
    $("<a class='left carousel-control' data-slide='prev'></a>")
        .attr('href', '#' + str_Id)
        .append("<span class='glyphicon glyphicon-chevron-left'></span>")
        .append("<span class='sr-only'>Previous</span>");
    obj_carousel.append(obj_controlIzquierdo);

    var obj_controlDerecho =
    $(" <a class='right carousel-control' data-slide='next'>")
        .attr('href', '#' + str_Id)
        .append("<span class='glyphicon glyphicon-chevron-right'></span>")
        .append("<span class='sr-only'>Next</span>");
    obj_carousel.append(obj_controlDerecho);

    if (obj_pLista.Result.length <= int_Columna) {
        obj_controlIzquierdo.css('display', 'none');
        obj_controlDerecho.css('display', 'none');
    }

    for (var i = 0; i < obj_pLista.Result.length; i++) {

        if (int_IndiceColumna == 0 || (int_IndiceColumna >= int_Columna)) {
            //circulo
            obj_circulo = $("<li></li>");
            obj_circulo.attr('data-target', '#' + str_Id);
            obj_circulo.attr('data-slide-to', int_IndiceItem);
            if (int_IndiceItem == 0)
                obj_circulo.addClass('active');
            obj_indicador.append(obj_circulo);

            obj_item = $("<div class='item'></div>");
            obj_item.addClass('item');
            if (int_IndiceItem == 0)
                obj_item.addClass('active');

            obj_row = $("<div class='row'></div>");
            obj_item.append(obj_row);
            obj_coleccion.append(obj_item);
            int_IndiceItem++;
            int_IndiceColumna = 0;
        }

        obj_imagen = $("<div class='col-lg-4 col-md-4 col-sm-4 col-xs-12'></div>")
            .css('display', 'table')
            .append($('<div></div>')
            .css('display', 'table-cell')
            .css('text-align', 'center')
            .css('vertical-align', 'middle')
            .css('height', '300px')
            .css('width', '100%')
            .css('background', 'rgba(0, 0, 0, 0.7)')
            .css('position', 'relative')
            .append($("<img></img>")
            .css('background-color', 'transparent')
            .css('max-height', '300px')
            .css('max-width', '100%')
            .attr('src', obj_pLista.Result[i].ImagenURL))
            .append($('<div style="background-color:#28309B;bottom:0px;position:absolute;width:100%;padding:10px;opacity:0.8;color:white;"></div>')
                .append($('<div style="width:100%;text-overflow:ellipsis;white-space:nowrap;overflow:hidden;"></div>')
                .html(obj_pLista.Result[i].Nombre.toUpperCase()))
            ));

        obj_row.append(obj_imagen);

        int_IndiceColumna++;
    }

    div_Lista.append(obj_carousel);
    $("#" + str_Id).carousel();

    var obj_modal = $("#mdKaraoke").modal('show', {
        backdrop: true,
        keyboard: false,
    });
    $("#mdKaraoke").find('h3').html(str_pTitulo)
}


//Carga la grilla de cursos
function CargarGrillaRanking(obj_pLista, str_pTitulo) {

    var int_IndiceColumna = 0;
    var int_IndiceItem = 0;
    var obj_circulo = null;
    var obj_item = null;
    var obj_row = null;
    var obj_imagen = null;

    var div_Lista = $("#Carrousel");
    div_Lista.html('');

    var int_Columna = 3;
    var str_Id = 'Detalle';
    var obj_carousel = $("<div></div>");
    obj_carousel.attr('id', str_Id);
    obj_carousel.attr('data-ride', 'carousel');
    obj_carousel.addClass('carousel slide');
    //circulos
    var obj_indicador = $("<ol></ol>");
    obj_indicador.addClass('carousel-indicators')
    obj_indicador.css('display', 'none');
    obj_carousel.append(obj_indicador);
    //items
    var obj_coleccion = $("<div></div>");
    obj_coleccion.addClass('carousel-inner')
    obj_carousel.append(obj_coleccion);
    //controles
    var obj_controlIzquierdo =
    $("<a class='left carousel-control' data-slide='prev'></a>")
        .attr('href', '#' + str_Id)
        .append("<span class='glyphicon glyphicon-chevron-left'></span>")
        .append("<span class='sr-only'>Previous</span>");
    obj_carousel.append(obj_controlIzquierdo);

    var obj_controlDerecho =
    $(" <a class='right carousel-control' data-slide='next'>")
        .attr('href', '#' + str_Id)
        .append("<span class='glyphicon glyphicon-chevron-right'></span>")
        .append("<span class='sr-only'>Next</span>");
    obj_carousel.append(obj_controlDerecho);

    if (obj_pLista.Result.length <= int_Columna) {
        obj_controlIzquierdo.css('display', 'none');
        obj_controlDerecho.css('display', 'none');
    }

    for (var i = 0; i < obj_pLista.Result.length; i++) {

        if (int_IndiceColumna == 0 || (int_IndiceColumna >= int_Columna)) {
            //circulo
            obj_circulo = $("<li></li>");
            obj_circulo.attr('data-target', '#' + str_Id);
            obj_circulo.attr('data-slide-to', int_IndiceItem);
            if (int_IndiceItem == 0)
                obj_circulo.addClass('active');
            obj_indicador.append(obj_circulo);

            obj_item = $("<div class='item'></div>");
            obj_item.addClass('item');
            if (int_IndiceItem == 0)
                obj_item.addClass('active');

            obj_row = $("<div class='row'></div>");
            obj_item.append(obj_row);
            obj_coleccion.append(obj_item);
            int_IndiceItem++;
            int_IndiceColumna = 0;
        }

        var url_Numero = "./Images/Numero/Numero" + (i + 1) + ".png";
        obj_imagen = $("<div class='col-lg-4 col-md-4 col-sm-4 col-xs-12'></div>")
        .append($("<table class='celdaRanking'></table>")
        .append($("<tbody></tbody>")
            .append($("<tr></tr>")
                .append($("<td align='center' style='position:relative;'></td>")
                    .css('width', '20%')
                    .css('background', 'rgba(0, 0, 0, 0.7)')
                    .append($("<img alt='' src='" + url_Numero + "'/>")))
                .append($("<td align='center' style='position:relative;'></td>")
                    .css('width', '80%')
                    .css('background', 'rgba(0, 0, 0, 0.8)')
                    .append($("<img alt='' src='" + obj_pLista.Result[i].Album.ImagenURL + "'/>")
                            .css('background-color', 'transparent')
                            .css('max-height', '200px')
                            .css('max-width', '100%'))
                    .append($("<div style='background-color:#28309B;bottom:0px;position:absolute;width:100%;opacity:0.8;'></div>")
                    .append($("<button class='btn btn-info' Onclick='return false' style='width:100%;text-overflow:ellipsis;white-space:nowrap;overflow:hidden;'>" + obj_pLista.Result[i].Cancion.Descripcion + "</button>")
                    ))))));

        obj_row.append(obj_imagen);

        int_IndiceColumna++;
    }

    div_Lista.append(obj_carousel);
    $("#" + str_Id).carousel();

    var obj_modal = $("#mdKaraoke").modal('show', {
        backdrop: true,
        keyboard: false,
    });
    $("#mdKaraoke").find('h3').html(str_pTitulo)
}