$(function () {
    ListarRankiados();
});

//Lista de Rankiados
function ListarRankiados() {
    AccionDefault(true, "Ranking.aspx/ListarRankiados", {}, CargarGrilla, null, null, null, 1);
}

//Carga la grilla de cursos
function CargarGrilla(obj_pLista) {
    var urlContador = 1;
    var contador = 1;

    var int_Indice = 0;
    var int_Columnas = 3;
    var str_HTML = "";
    var div_Eventos = $("#divRankiados");
    div_Eventos.html('');

    if (obj_pLista.Result.length <= 0) {
        str_HTML += "<div class='col-lg-12' align='center' style='margin-top: 25px;'>No tiene eventos.</div>";
        $("#divRankiados").append(str_HTML);
    }
    else {
        var str_Titulo = '';
        var str_Descripcion = '';
        var str_ImagenURL = '';
        for (var i = 0; i < obj_pLista.Result.length; i++) {

            str_Titulo = '';
            str_Descripcion = '';
            str_URL = '';

            //Ranking 1
            if (i == 0)
                div_Row = $(".cabecera");
            else {
                //Rankgin mayor a 1
                if (int_Indice == 0) {
                    div_Row = $("<div class='row'></div>");
                    div_Eventos.append(div_Row);
                }
            }

            if (obj_pLista.Result[i].LocalCancion.Album.IdAlbum != null) {
                str_Titulo = obj_pLista.Result[i].LocalCancion.Cancion.Descripcion;
                str_ImagenURL = obj_pLista.Result[i].LocalCancion.Album.ImagenURL;
            }

            var url_Numero = "./Images/Numero/Numero" + urlContador + ".png";
            str_HTML = '';
            str_HTML += "<div class='col-lg-4 col-md-4 col-sm-4 col-xs-12'>";
            str_HTML += "<table class='celdaRanking'>";
            str_HTML += "<tbody>";
            str_HTML += "<tr>";
            str_HTML += "<td align='center' style='position:relative;'>";
            str_HTML += "<img alt='' src='" + url_Numero + "'/>"
            str_HTML += "</td>";
            str_HTML += "<td align='center' style='position:relative;'>";
            str_HTML += "<img alt='' src='" + str_ImagenURL + "'/>"
            str_HTML += "<div style='background-color:#28309B;bottom:0px;position:absolute;width:100%;opacity:0.8;'>";
            str_HTML += "<button class='btn btn-info' Onclick='return false' style='width:100%;text-overflow:ellipsis;white-space:nowrap;overflow:hidden;'>" + str_Titulo + "</button>";
            str_HTML += "</div>";
            str_HTML += "</td>";
            str_HTML += "</tr>";
            str_HTML += "</tbody>";
            str_HTML += "</table>";
            div_Row.append($(str_HTML));

            urlContador++;
            if (i > 0) {
                if (contador == 4) {
                    contador = 1;
                }
                contador++;
                int_Indice += 1;
                if (int_Indice == int_Columnas)
                    int_Indice = 0;
            }
        }
    }
}