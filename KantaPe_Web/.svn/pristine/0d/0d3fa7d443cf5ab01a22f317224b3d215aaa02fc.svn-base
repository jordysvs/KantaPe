var urlHome = 'Home.aspx';
var urlRanking = '/Forms/Portal/Ranking.aspx';
var urlKaraoke = 'Karaoke.aspx';
var urlEventos = 'Eventos.aspx';

$(function () {
    CargarCabecera();
});


function CargarCabecera() {
    var divRowCategorias = $("#divBotones");

    divRowCategorias.append("<button onclick= 'IrHome();return false;' style='border-style: solid;border-width:0px; color: white; padding: 10px 20px 10px 20px;' class='btn btn-sm btn-info'>" + "HOME" + "</button></div>");
    divRowCategorias.append("<button onclick= 'IrRanking();return false;' style='border-style: solid;border-width:0px; color: white; padding: 10px 20px 10px 20px;' class='btn btn-sm btn-info'>" + "RANKING" + "</button></div>");
    divRowCategorias.append("<button onclick= 'ListarCurso(" + "" + ");return false;' style='border-style: solid;border-width:0px; color: white; padding: 10px 20px 10px 20px;' class='btn btn-sm btn-info'>" + "KARAOKE" + "</button></div>");
    divRowCategorias.append("<button onclick= 'ListarCurso(" + "" + ");return false;' style='border-style: solid;border-width:0px; color: white; padding: 10px 20px 10px 20px;' class='btn btn-sm btn-info'>" + "EVENTOS" + "</button></div>");
    divRowCategorias.append("<button onclick= 'ListarCurso(" + "" + ");return false;' style='border-style: solid;border-width:0px; color: white; padding: 10px 20px 10px 20px;' class='btn btn-sm btn-info'>" + "PROMOCIONES" + "</button></div>");
    divRowCategorias.append("<button onclick= 'ListarCurso(" + "" + ");return false;' style='border-style: solid;border-width:0px; color: white; padding: 10px 20px 10px 20px;' class='btn btn-sm btn-info'>" + "AFILIATE" + "</button></div>");


}


function IrHome() {    
        MostrarMensajeCargando();
        document.location.href = urlHome;
}


function IrRanking() {
    MostrarMensajeCargando();
    document.location.href = urlRanking;
}