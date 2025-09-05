//Atributos
//MESAS
var obj_gAperturaTurno = null; // Primera Apertura que está de turno
var obj_gAperturaCancionTurno = null;//Primera Canción de la apertura de mesa que está de turno
var obj_gAperturaTurnoSiguiente = null;// Apertura de Mesa Siguiente a la de turno

//BOX
var obj_gAperturaBoxTurno = null;//Primera Apertura Box que está de turno
var obj_gAperturaBoxCancionTurno = null;// Primera Canción de la apertura  de box que está de turno

var obj_TimerTurno = null;
var obj_CuentaRegresiva = null;
var int_TiempoVerificar = null;

var int_gContadorCancionesCantadas = 0;

lstCancionesTurno = [];

$(function () {
    ListarTurno();
    int_TiempoVerificar = parseInt($("#hdTiempoVerificar").val());
});

function ListarTurno() {
    AccionDefault(true, "Turno.aspx/ListarAperturaTurno", {},
        function (obj_pLista) {
            CargarMesas(obj_pLista);
            obj_TimerTurno = setTimeout(ListarTurno, 2000);
        }, null, null, null, 1, false, false);
}

function CargarMesas(obj_pLista) {
    var int_LimiteCanciones = parseInt($("#hdLimiteCanciones").val());

    //Variables para el proceso
    lstCancionesTurno = [];
    var lstCanciones = [];

    var int_ContadorColumnasCancionesCantadas = 0;

    //Variables para Mesa
    var int_IndiceMesa = 0;
    var divContenido = $("#divContenido");
    var divSiguientesMesas = $("#divSiguientesMesas");
    divSiguientesMesas.html('');
    var divMesas = $("<div style='overflow-y: auto; overflow-x: hidden; height: 550px;'></div>");

    //Variables para Box
    var divBox = $('#divBox');
    divBox.html('');
    var divRow = null;
    var int_ContadorColumnas = 0;

    for (var i = 0; i < obj_pLista.Result.length; i++) {
        //IdUbicacionTipo = 1 --> Mesa
        //IdUbicacionTipo = 2 --> Box
        if (obj_pLista.Result[i].Ubicaciones[0].Ubicacion.IdUbicacionTipo == 1) {
            int_IndiceMesa++;
            if (obj_pLista.Result[i].FlagTurno == 'S') {

                if (obj_gAperturaTurno == null)
                    obj_gAperturaTurno = obj_pLista.Result[i];

                var tblAgrupacionMesa = $("#tblPrimeraMesa");
                tblAgrupacionMesa.html('');
                tblAgrupacionMesa.attr('idapertura', obj_pLista.Result[i].IdApertura);
                tblAgrupacionMesa.attr('idubicacion', obj_pLista.Result[i].Ubicaciones[0].IdUbicacion);

                //Asignando el número de ronda
                tblAgrupacionMesa.append($("<tr><td class='ubicacion' style='background-color: #0E1969; border-color: black; color: white; font-weight: bold;'></td><td colspan='2' class='ubicacion' style='background-color: #0E1969; border-color: black; color: white; font-weight: bold; text-align: center;'>RONDA " + obj_pLista.Result[i].Ronda + "</td></tr>"));

                //Validacion de la cancion
                if (obj_pLista.Result[i].Canciones.length > 0) {
                    for (var j = 0; j < obj_pLista.Result[i].Canciones.length; j++) {
                        if (int_gContadorCancionesCantadas < int_LimiteCanciones) {
                            if (j < int_LimiteCanciones) {
                                if (obj_pLista.Result[i].Canciones[j].IdAperturaCancionTipo == 1)
                                    lstCancionesTurno.push(obj_pLista.Result[i].Canciones[j]);

                                var obj_FilaCancion = $("<tr></tr>");
                                if (j == 0) {
                                    //Celda para indicar el número de mesa
                                    obj_FilaCancion.append($("<td rowspan='" + int_LimiteCanciones + "' style='vertical-align: middle; text-align: center; font-size: 16px; border-style: solid; width: 80px; border-width: 1px; border-color: black; background-color: #0E1969; color: white; font-weight: bold;'>MESA<br /><span style='font-size: 60px;'> " + obj_pLista.Result[i].Ubicaciones[0].Ubicacion.Numero + "</span></td>"));
                                }
                                var obj_CeldaTablaCancion = $("<td></td>");
                                var obj_TablaCancion = $("<table class='mesa'></table>");
                                var obj_TablaCancionBody = $("<tbody></tbody>");

                                //Imagen de Canción
                                var obj_CancionImagenTablaFila = $("<tr></tr>");
                                var str_Imagen = '';
                                if (obj_pLista.Result[i].Canciones[j].IdAperturaCancionSolicitud == null || obj_pLista.Result[i].Canciones[j].IdAperturaCancionSolicitud == 1)
                                    str_Imagen = 'url(&quot;' + UrlPath + 'Content/iconocantar.png&quot;);';
                                else
                                    str_Imagen = 'url(&quot;' + UrlPath + 'Content/iconoescuchar.png&quot;);';

                                obj_CancionImagenTablaFila.append($("<td class='imagen' style='border-style: solid; border-width: 1px; background-color: #0E1969; color: white; font-weight: bold; border-color: black; background-image: " + str_Imagen + "'></td>"));
                                obj_TablaCancionBody.append(obj_CancionImagenTablaFila);
                                obj_TablaCancion.append(obj_TablaCancionBody);

                                //Color de la canción
                                var str_Color = "white";
                                if (j == 0) {
                                    str_Color = "#78E91B";
                                    if (obj_gAperturaCancionTurno == null || (obj_gAperturaCancionTurno.IdAperturaCancion != obj_pLista.Result[i].Canciones[j].IdAperturaCancion)) {
                                        obj_gAperturaCancionTurno = obj_pLista.Result[i].Canciones[j];
                                        if (obj_gAperturaCancionTurno.IdAperturaCancionTipo == 1) {
                                            var int_TiempoASumarCancion = parseInt($("#hdTiempoSumar").val());
                                            var int_DuracionCancion = obj_gAperturaCancionTurno.LocalCancion.Duracion;

                                            if (obj_CuentaRegresiva == null)
                                                CuentaRegresiva(int_TiempoASumarCancion, int_DuracionCancion);
                                        }
                                    }
                                }
                                if (obj_pLista.Result[i].Canciones[j].IdAperturaCancionTipo == 3)
                                    str_Color = '#F9E502';

                                //Descripción de Canción
                                var obj_SegundaCeldaCancionTabla = $("<td class='apertura' style='border-style: solid; border-width: 1px; background-color:" + str_Color + "'>");
                                var obj_TablaCancionDescripcion = $("<table style='width: 100%;'></table>");
                                var obj_TablaCancionDescripcionBody = $("<tbody></tbody>");
                                obj_TablaCancionDescripcionBody.append($("<tr><td class='titulo'>Fecha:</td><td class='descripcion'>" + ToDateTimeString(obj_pLista.Result[i].Canciones[j].FechaCreacion) + "</td></tr>"));
                                obj_TablaCancionDescripcionBody.append($("<tr><td class='titulo'>Canción:</td><td class='descripcion'>" + obj_pLista.Result[i].Canciones[j].LocalCancion.Artista.Nombre + " - " + obj_pLista.Result[i].Canciones[j].LocalCancion.Cancion.Descripcion + "</td></tr>"));
                                obj_TablaCancionDescripcionBody.append($("<tr><td class='titulo'>Usuario:</td><td class='descripcion'>" + obj_pLista.Result[i].Canciones[j].Usuario.Persona.NombreCompleto + "</td></tr>"));
                                obj_TablaCancionDescripcion.append(obj_TablaCancionDescripcionBody);
                                obj_SegundaCeldaCancionTabla.append(obj_TablaCancionDescripcion);

                                obj_CancionImagenTablaFila.append(obj_SegundaCeldaCancionTabla);
                                obj_TablaCancionBody.append(obj_CancionImagenTablaFila);
                                obj_TablaCancion.append(obj_TablaCancionBody);
                                obj_CeldaTablaCancion.append(obj_TablaCancion);
                                obj_FilaCancion.append(obj_CeldaTablaCancion);
                                tblAgrupacionMesa.append(obj_FilaCancion);
                            }
                        } else {
                            if (obj_pLista.Result[i].Canciones[j].IdAperturaCancionTipo == 3) {
                                int_ContadorColumnasCancionesCantadas++;
                                if (int_ContadorColumnasCancionesCantadas <= int_LimiteCanciones) {
                                    //Color de la canción
                                    var str_Color = '#F9E502';

                                    var obj_FilaCancion = $("<tr></tr>");
                                    if (int_ContadorColumnasCancionesCantadas == 1) {
                                        //Celda para indicar el número de mesa
                                        obj_FilaCancion.append($("<td rowspan='" + int_LimiteCanciones + "' style='vertical-align: middle; text-align: center; font-size: 16px; border-style: solid; width: 80px; border-width: 1px; border-color: black; background-color: #0E1969; color: white; font-weight: bold;'>MESA<br /><span style='font-size: 60px;'> " + obj_pLista.Result[i].Ubicaciones[0].Ubicacion.Numero + "</span></td>"));
                                    }
                                    var obj_CeldaTablaCancion = $("<td></td>");
                                    var obj_TablaCancion = $("<table class='mesa'></table>");
                                    var obj_TablaCancionBody = $("<tbody></tbody>");

                                    //Imagen de Canción
                                    var obj_CancionImagenTablaFila = $("<tr></tr>");
                                    var str_Imagen = '';
                                    if (obj_pLista.Result[i].Canciones[j].IdAperturaCancionSolicitud == null || obj_pLista.Result[i].Canciones[j].IdAperturaCancionSolicitud == 1)
                                        str_Imagen = 'url(&quot;' + UrlPath + 'Content/iconocantar.png&quot;);';
                                    else
                                        str_Imagen = 'url(&quot;' + UrlPath + 'Content/iconoescuchar.png&quot;);';

                                    obj_CancionImagenTablaFila.append($("<td class='imagen' style='border-style: solid; border-width: 1px; background-color: #0E1969; color: white; font-weight: bold; border-color: black; background-image: " + str_Imagen + "'></td>"));
                                    //obj_CancionImagenTablaFila.append($("<td class='imagen' style='border-style: solid; border-width: 1px; background-color: #0E1969; color: white; font-weight: bold; border-color: black; background-image: url(&quot;/Content/iconocantar.png&quot;);'></td>"));
                                    obj_TablaCancionBody.append(obj_CancionImagenTablaFila);
                                    obj_TablaCancion.append(obj_TablaCancionBody);

                                    //Descripción de Canción
                                    var obj_SegundaCeldaCancionTabla = $("<td class='apertura' style='border-style: solid; border-width: 1px; background-color:" + str_Color + "'>");
                                    var obj_TablaCancionDescripcion = $("<table style='width: 100%;'></table>");
                                    var obj_TablaCancionDescripcionBody = $("<tbody></tbody>");
                                    obj_TablaCancionDescripcionBody.append($("<tr><td class='titulo'>Fecha:</td><td class='descripcion'>" + ToDateTimeString(obj_pLista.Result[i].Canciones[j].FechaCreacion) + "</td></tr>"));
                                    obj_TablaCancionDescripcionBody.append($("<tr><td class='titulo'>Canción:</td><td class='descripcion'>" + obj_pLista.Result[i].Canciones[j].LocalCancion.Artista.Nombre + " - " + obj_pLista.Result[i].Canciones[j].LocalCancion.Cancion.Descripcion + "</td></tr>"));
                                    obj_TablaCancionDescripcionBody.append($("<tr><td class='titulo'>Usuario:</td><td class='descripcion'>" + obj_pLista.Result[i].Canciones[j].Usuario.Persona.NombreCompleto + "</td></tr>"));
                                    obj_TablaCancionDescripcion.append(obj_TablaCancionDescripcionBody);
                                    obj_SegundaCeldaCancionTabla.append(obj_TablaCancionDescripcion);

                                    obj_CancionImagenTablaFila.append(obj_SegundaCeldaCancionTabla);
                                    obj_TablaCancionBody.append(obj_CancionImagenTablaFila);
                                    obj_TablaCancion.append(obj_TablaCancionBody);
                                    obj_CeldaTablaCancion.append(obj_TablaCancion);
                                    obj_FilaCancion.append(obj_CeldaTablaCancion);
                                    tblAgrupacionMesa.append(obj_FilaCancion);
                                }
                            }
                        }
                    }
                }
                else { // En el caso de que no haya canciones que reproducir
                    var obj_FilaCancion = $("<tr></tr>");
                    //Celda para indicar la Ronda
                    obj_FilaCancion.append($("<td rowspan='" + int_LimiteCanciones + "' style='vertical-align: middle; text-align: center; font-size: 16px; border-style: solid; width: 80px; border-width: 1px; border-color: black; background-color: #0E1969; color: white; font-weight: bold;'>MESA<br /><span style='font-size: 60px;'> " + obj_pLista.Result[i].Ubicaciones[0].Ubicacion.Numero + "</span></td>"));
                    var obj_CeldaTablaCancion = $("<td></td>");
                    var obj_TablaCancion = $("<table class='mesa'></table>");
                    var obj_TablaCancionBody = $("<tbody></tbody>");

                    //Imagen de Canción
                    var obj_CancionImagenTablaFila = $("<tr></tr>");
                    var str_Imagen = 'url(&quot;' + UrlPath + 'Content/iconocantar.png&quot;);';
                    obj_CancionImagenTablaFila.append($("<td class='imagen' style='border-style: solid; border-width: 1px; background-color: #0E1969; color: white; font-weight: bold; border-color: black; background-image: " + str_Imagen + "'></td>"));
                    obj_TablaCancionBody.append(obj_CancionImagenTablaFila);
                    obj_TablaCancion.append(obj_TablaCancionBody);

                    //Color de la canción
                    var str_Color = "white";

                    //Descripción de Canción
                    var obj_SegundaCeldaCancionTabla = $("<td class='apertura' style='border-style: solid; border-width: 1px; background-color:" + str_Color + "'>");
                    var obj_TablaCancionDescripcion = $("<table style='width: 100%;'></table>");
                    var obj_TablaCancionDescripcionBody = $("<tbody></tbody>");
                    obj_TablaCancionDescripcionBody.append($("<tr><td class='descripcion'><p>El usuario no ha pedido ninguna canción</p></td></tr>"));
                    obj_TablaCancionDescripcion.append(obj_TablaCancionDescripcionBody);
                    obj_SegundaCeldaCancionTabla.append(obj_TablaCancionDescripcion);

                    obj_CancionImagenTablaFila.append(obj_SegundaCeldaCancionTabla);
                    obj_TablaCancionBody.append(obj_CancionImagenTablaFila);
                    obj_TablaCancion.append(obj_TablaCancionBody);
                    obj_CeldaTablaCancion.append(obj_TablaCancion);
                    obj_FilaCancion.append(obj_CeldaTablaCancion);
                    tblAgrupacionMesa.append(obj_FilaCancion);

                    obj_gAperturaCancionTurno = null;
                }
            }
            else {
                //Guardando la mesa siguiente a la de turno
                if (obj_pLista.Result[1] != null)
                    obj_gAperturaTurnoSiguiente = obj_pLista.Result[1];

                var divColumnaMesa = $("<div class='row'></div>");
                var divColumnaMesaLg = $("<div class='col-lg-12 drag'></div>");
                var tblAgrupacionMesa = $("<table class='agrupador' style='width: 100%;'></table>");
                tblAgrupacionMesa.attr('idapertura', obj_pLista.Result[i].IdApertura);
                tblAgrupacionMesa.attr('idubicacion', obj_pLista.Result[i].Ubicaciones[0].IdUbicacion);
                //Asignando el número de mesa
                tblAgrupacionMesa.append($("<tr><td class='ubicacion' style='background-color: #0E1969; border-color: black; color: white; font-weight: bold;'></td><td colspan='2' class='ubicacion' style='background-color: #0E1969; border-color: black; color: white; font-weight: bold; text-align: center;'>RONDA " + obj_pLista.Result[i].Ronda + "</td></tr>"));

                //Asignando las canciones de cada mesa
                if (obj_pLista.Result[i].Canciones.length > 0) {
                    for (var j = 0; j < obj_pLista.Result[i].Canciones.length; j++) {
                        if (j < int_LimiteCanciones) {
                            lstCanciones.push(obj_pLista.Result[i].Canciones[j]);

                            var obj_FilaCancion = $("<tr></tr>");
                            if (j == 0) {
                                //Celda para indicar la Ronda
                                obj_FilaCancion.append($("<td rowspan='" + int_LimiteCanciones + "' style='vertical-align: middle; text-align: center; font-size: 16px; border-style: solid; width: 80px; border-width: 1px; border-color: black; background-color: #0E1969; color: white; font-weight: bold;'>Mesa<br /><span style='font-size: 60px;'>" + obj_pLista.Result[i].Ubicaciones[0].Ubicacion.Numero + "</span></td>"));
                            }

                            var obj_CeldaCancionTabla = $("<td></td>");
                            var obj_CancionTabla = $("<table class='mesa'></table>");
                            var obj_CancionTablaBody = $("<tbody></tbody>");

                            var obj_CancionTablaFila = $("<tr></tr>");
                            var str_Imagen = '';
                            if (obj_pLista.Result[i].Canciones[j].IdAperturaCancionSolicitud == null || obj_pLista.Result[i].Canciones[j].IdAperturaCancionSolicitud == 1)
                                str_Imagen = 'url(&quot;' + UrlPath + 'Content/iconocantar.png&quot;);';
                            else
                                str_Imagen = 'url(&quot;' + UrlPath + 'Content/iconoescuchar.png&quot;);';

                            obj_CancionTablaFila.append($("<td class='imagen' style='border-style: solid; border-width: 1px; background-color: #0E1969; color: white; font-weight: bold; border-color: black; background-image: " + str_Imagen + "'></td>"));
                            //obj_CancionTablaFila.append($("<td class='imagen' style='border-style: solid; border-width: 1px; background-color: #0E1969; color: white; font-weight: bold; border-color: black; background-image: url(&quot;/Content/iconocantar.png&quot;);'></td>"));

                            var obj_CeldaTablaDescripcionCancion = $("<td class='apertura' style='border-style: solid; border-width: 1px;'></td>");
                            var obj_TablaDescripcionCancion = $("<table style='width: 100%;'><tbody></tbody></table>");
                            var obj_TablaDescripcionCancionBody = $("<tbody></tbody>");

                            obj_TablaDescripcionCancion.append($("<tr><td class='titulo'>Fecha:</td><td class='descripcion'>" + ToDateTimeString(obj_pLista.Result[i].Canciones[j].FechaCreacion) + "</td></tr>"));
                            obj_TablaDescripcionCancion.append($("<tr><td class='titulo'>Canción:</td><td class='descripcion'>" + obj_pLista.Result[i].Canciones[j].LocalCancion.Artista.Nombre + " - " + obj_pLista.Result[i].Canciones[j].LocalCancion.Cancion.Descripcion + "</td></tr>"));
                            obj_TablaDescripcionCancion.append($("<tr><td class='titulo'>Usuario:</td><td class='descripcion'>" + obj_pLista.Result[i].Canciones[j].Usuario.Persona.NombreCompleto + "</td></tr>"));

                            obj_TablaDescripcionCancion.append(obj_TablaDescripcionCancionBody);
                            obj_CeldaTablaDescripcionCancion.append(obj_TablaDescripcionCancion);
                            obj_CancionTablaFila.append(obj_CeldaTablaDescripcionCancion);
                            obj_CancionTablaBody.append(obj_CancionTablaFila);
                            obj_CancionTabla.append(obj_CancionTablaBody);
                            obj_CeldaCancionTabla.append(obj_CancionTabla);
                            obj_FilaCancion.append(obj_CeldaCancionTabla);
                            tblAgrupacionMesa.append(obj_FilaCancion);
                        }
                    }
                } else {
                    var obj_FilaCancion = $("<tr></tr>");
                    //Celda para indicar la Ronda
                    obj_FilaCancion.append($("<td rowspan='" + int_LimiteCanciones + "' style='vertical-align: middle; text-align: center; font-size: 16px; border-style: solid; width: 80px; border-width: 1px; border-color: black; background-color: #0E1969; color: white; font-weight: bold;'>Mesa<br /><span style='font-size: 60px;'>" + obj_pLista.Result[i].Ubicaciones[0].Ubicacion.Numero + "</span></td>"));

                    var obj_CeldaCancionTabla = $("<td></td>");
                    var obj_CancionTabla = $("<table class='mesa'></table>");
                    var obj_CancionTablaBody = $("<tbody></tbody>");

                    var obj_CancionTablaFila = $("<tr></tr>");
                    var str_Imagen = 'url(&quot;' + UrlPath + 'Content/iconocantar.png&quot;);';

                    obj_CancionTablaFila.append($("<td class='imagen' style='border-style: solid; border-width: 1px; background-color: #0E1969; color: white; font-weight: bold; border-color: black; background-image: " + str_Imagen + "'></td>"));
                    //obj_CancionTablaFila.append($("<td class='imagen' style='border-style: solid; border-width: 1px; background-color: #0E1969; color: white; font-weight: bold; border-color: black; background-image: url(&quot;/Content/iconocantar.png&quot;);'></td>"));

                    var obj_CeldaTablaDescripcionCancion = $("<td class='apertura' style='border-style: solid; border-width: 1px;'></td>");
                    var obj_TablaDescripcionCancion = $("<table style='width: 100%;'><tbody></tbody></table>");
                    var obj_TablaDescripcionCancionBody = $("<tbody></tbody>");

                    obj_TablaDescripcionCancion.append($("<tr><td class='descripcion'><p>El usuario no ha pedido ninguna canción</p></td></tr>"));
                    obj_TablaDescripcionCancion.append(obj_TablaDescripcionCancionBody);
                    obj_CeldaTablaDescripcionCancion.append(obj_TablaDescripcionCancion);
                    obj_CancionTablaFila.append(obj_CeldaTablaDescripcionCancion);
                    obj_CancionTablaBody.append(obj_CancionTablaFila);
                    obj_CancionTabla.append(obj_CancionTablaBody);
                    obj_CeldaCancionTabla.append(obj_CancionTabla);
                    obj_FilaCancion.append(obj_CeldaCancionTabla);
                    tblAgrupacionMesa.append(obj_FilaCancion);
                }

                divColumnaMesaLg.append(tblAgrupacionMesa);
                divColumnaMesa.append(divColumnaMesaLg);
                divMesas.append(divColumnaMesa);
            }

            divSiguientesMesas.append(divMesas);
            divContenido.append(divSiguientesMesas);
        }
        else {
            int_ContadorColumnas++;
            if (int_ContadorColumnas == 1 || int_ContadorColumnas % 3 == 0) {
                divRow = $("<div class='row'></div>");
            }
            var divColumna = $("<div class='col-lg-4'></div>");
            var tblAgrupacionMesa = $("<table class='agrupador' style='width: 100%;'></table>");
            tblAgrupacionMesa.attr('idapertura', obj_pLista.Result[i].IdApertura);
            tblAgrupacionMesa.attr('idubicacion', obj_pLista.Result[i].Ubicaciones[0].IdUbicacion);
            //Asignando el número de box
            tblAgrupacionMesa.append($("<tr><td class='ubicacion' style='background-color: #0E1969; border-color: black; color: white; font-weight: bold;'></td><td colspan='2' class='ubicacion' style='background-color: #0E1969; border-color: black; color: white; font-weight: bold; text-align: center;'>RONDA " + obj_pLista.Result[i].Ronda + "</td></tr>"));

            if (obj_pLista.Result[i].Canciones.length > 0) {
                for (var j = 0; j < obj_pLista.Result[i].Canciones.length; j++) {

                    //lstCanciones.push(obj_pLista.Result[i].Canciones[j]);
                    var str_Color = "white";
                    var obj_FilaCancion = $("<tr></tr>");
                    if (j == 0) {
                        str_Color = "#78E91B";

                        //Celda para indicar la Ronda
                        obj_FilaCancion.append($("<td rowspan='" + obj_pLista.Result[i].Canciones.length + "' style='vertical-align: middle; text-align: center; font-size: 16px; border-style: solid; width: 80px; border-width: 1px; border-color: black; background-color: #0E1969; color: white; font-weight: bold;'>Box<br /><span style='font-size: 60px;'>" + obj_pLista.Result[i].Ubicaciones[0].Ubicacion.Numero + "</span></td>"));
                        if (obj_gAperturaBoxCancionTurno == null || (obj_gAperturaBoxCancionTurno.IdAperturaCancion != obj_pLista.Result[i].Canciones[j].IdAperturaCancion)) {
                            obj_gAperturaBoxCancionTurno = obj_pLista.Result[i].Canciones[j];
                            if (obj_gAperturaBoxCancionTurno.IdAperturaCancionTipo == 1) {
                                setTimeout(
                                    function () {
                                        QuitarCancion(obj_gAperturaBoxCancionTurno.IdApertura, obj_gAperturaBoxCancionTurno.IdAperturaCancion);
                                    }, (obj_gAperturaBoxCancionTurno.LocalCancion.Duracion * 1000));//Ya modificado
                            }
                        }
                    }

                    if (obj_pLista.Result[i].Canciones[j].IdAperturaCancionTipo == 3)
                        str_Color = '#F9E502';

                    var obj_CeldaCancionTabla = $("<td></td>");
                    var obj_CancionTabla = $("<table class='mesa'></table>");
                    var obj_CancionTablaBody = $("<tbody></tbody>");

                    var obj_CancionTablaFila = $("<tr></tr>");
                    var str_Imagen = '';
                    if (obj_pLista.Result[i].Canciones[j].IdAperturaCancionSolicitud == null || obj_pLista.Result[i].Canciones[j].IdAperturaCancionSolicitud == 1)
                        str_Imagen = 'url(&quot;' + UrlPath + 'Content/iconocantar.png&quot;);';
                    else
                        str_Imagen = 'url(&quot;' + UrlPath + 'Content/iconoescuchar.png&quot;);';

                    obj_CancionTablaFila.append($("<td class='imagen' style='border-style: solid; border-width: 1px; background-color: #0E1969; color: white; font-weight: bold; border-color: black; background-image: " + str_Imagen + "'></td>"));
                    //obj_CancionTablaFila.append($("<td class='imagen' style='border-style: solid; border-width: 1px; background-color: #0E1969; color: white; font-weight: bold; border-color: black; background-image: url(&quot;/Content/iconocantar.png&quot;);'></td>"));

                    var obj_CeldaTablaDescripcionCancion = $("<td class='apertura' style='border-style: solid; border-width: 1px;background-color:" + str_Color + "'></td>");
                    var obj_TablaDescripcionCancion = $("<table style='width: 100%;'><tbody></tbody></table>");
                    var obj_TablaDescripcionCancionBody = $("<tbody></tbody>");

                    obj_TablaDescripcionCancion.append($("<tr><td class='titulo'>Fecha:</td><td class='descripcion'>" + ToDateTimeString(obj_pLista.Result[i].Canciones[j].FechaCreacion) + "</td></tr>"));
                    obj_TablaDescripcionCancion.append($("<tr><td class='titulo'>Canción:</td><td class='descripcion'>" + obj_pLista.Result[i].Canciones[j].LocalCancion.Artista.Nombre + " - " + obj_pLista.Result[i].Canciones[j].LocalCancion.Cancion.Descripcion + "</td></tr>"));
                    obj_TablaDescripcionCancion.append($("<tr><td class='titulo'>Usuario:</td><td class='descripcion'>" + obj_pLista.Result[i].Canciones[j].Usuario.Persona.NombreCompleto + "</td></tr>"));

                    obj_TablaDescripcionCancion.append(obj_TablaDescripcionCancionBody);
                    obj_CeldaTablaDescripcionCancion.append(obj_TablaDescripcionCancion);
                    obj_CancionTablaFila.append(obj_CeldaTablaDescripcionCancion);
                    obj_CancionTablaBody.append(obj_CancionTablaFila);
                    obj_CancionTabla.append(obj_CancionTablaBody);
                    obj_CeldaCancionTabla.append(obj_CancionTabla);
                    obj_FilaCancion.append(obj_CeldaCancionTabla);
                    tblAgrupacionMesa.append(obj_FilaCancion);
                    divColumna.append(tblAgrupacionMesa);
                }
            } else {
                var obj_FilaCancion = $("<tr></tr>");
                //Celda para indicar la Ronda
                obj_FilaCancion.append($("<td rowspan='1' style='vertical-align: middle; text-align: center; font-size: 16px; border-style: solid; width: 80px; border-width: 1px; border-color: black; background-color: #0E1969; color: white; font-weight: bold;'>Box<br /><span style='font-size: 60px;'>" + obj_pLista.Result[i].Ubicaciones[0].Ubicacion.Numero + "</span></td>"));

                var obj_CeldaCancionTabla = $("<td></td>");
                var obj_CancionTabla = $("<table class='mesa'></table>");
                var obj_CancionTablaBody = $("<tbody></tbody>");

                var obj_CancionTablaFila = $("<tr></tr>");

                var str_Imagen = 'url(&quot;' + UrlPath + 'Content/iconocantar.png&quot;);';

                obj_CancionTablaFila.append($("<td class='imagen' style='border-style: solid; border-width: 1px; background-color: #0E1969; color: white; font-weight: bold; border-color: black; background-image: " + str_Imagen + "'></td>"));
                //obj_CancionTablaFila.append($("<td class='imagen' style='border-style: solid; border-width: 1px; background-color: #0E1969; color: white; font-weight: bold; border-color: black; background-image: url(&quot;/Content/iconocantar.png&quot;);'></td>"));

                var obj_CeldaTablaDescripcionCancion = $("<td class='apertura' style='border-style: solid; border-width: 1px;'></td>");
                var obj_TablaDescripcionCancion = $("<table style='width: 100%;'><tbody></tbody></table>");
                var obj_TablaDescripcionCancionBody = $("<tbody></tbody>");

                obj_TablaDescripcionCancion.append($("<tr><td class='descripcion'><p>El usuario no ha pedido ninguna canción</p></td></tr>"));
                obj_TablaDescripcionCancion.append(obj_TablaDescripcionCancionBody);
                obj_CeldaTablaDescripcionCancion.append(obj_TablaDescripcionCancion);
                obj_CancionTablaFila.append(obj_CeldaTablaDescripcionCancion);
                obj_CancionTablaBody.append(obj_CancionTablaFila);
                obj_CancionTabla.append(obj_CancionTablaBody);
                obj_CeldaCancionTabla.append(obj_CancionTabla);
                obj_FilaCancion.append(obj_CeldaCancionTabla);
                tblAgrupacionMesa.append(obj_FilaCancion);
                divColumna.append(tblAgrupacionMesa);
            }
            divRow.append(divColumna);
            divBox.append(divRow);
        }
    }

    //Mesa
    if (int_IndiceMesa == 0)
        divSiguientesMesas.append($("<div class='row'><div class='col-lg-12'><h4>No hay mesas aperturadas por el momento</h4></div></div>"))

    //Box
    if (int_ContadorColumnas == 0)
        divBox.append($("<div class='row'><div class='col-lg-12'><h4>No hay ningún box aperturado por el momento</h4></div></div>"));

    $(".drag").draggable({
        opacity: 0.7, helper: "clone", cursor: "move", scroll: true, scrollSensitivity: 100,
        start: function (e, ui) {
            $(ui.helper).addClass("ui-draggable-helper");
            $(this).data("origPosition", $(this).data("ui-draggable").originalPosition);
        },
        revert: "invalid"
    });
    $(".drop").droppable({
        accept: ".drag",
        activeClass: "ui-state-highlight",
        hoverClass: "ui-state-active",
        drop: function (event, ui) {
            var obj_Target = $(this).find('.agrupador');

            ConfirmJQ('¿Está seguro de iniciar el turno de la mesa seleccionada?',
                function () {
                    //Drag = Origen / Drop = Destino
                    var int_IdAperturaDrop = obj_Target.attr('idapertura') == undefined ? null : obj_Target.attr('idapertura');
                    var int_IdAperturaDrag = $(ui.draggable[0]).find('.agrupador').attr('idapertura');
                    var int_IdUbicacionDrag = $(ui.draggable[0]).find('.agrupador').attr('idubicacion') == undefined ? null : $(ui.draggable[0]).find('.agrupador').attr('idubicacion');

                    var obj_CancionTurno = null;
                    if (lstCancionesTurno.length > 0) {
                        obj_CancionTurno = lstCancionesTurno[0];
                        obj_CancionTurno.FechaCreacion = null;
                        obj_CancionTurno.FechaModificacion = null;
                    }

                    var obj_Turno = new Object();
                    obj_Turno.IdApertura = int_IdAperturaDrag;
                    obj_Turno.IdLocal = $('#hdIdLocal').val();
                    obj_Turno.Estado = 'A';
                    obj_Turno.Detalles = [];

                    if (lstCanciones.length > 0) {
                        for (var x = 0; x < lstCanciones.length; x++) {
                            if (lstCanciones[x].IdApertura == int_IdAperturaDrag) {
                                var obj_Detalle = new Object();
                                obj_Detalle.IdLocal = $('#hdIdLocal').val();
                                obj_Detalle.IdApertura = int_IdAperturaDrag;
                                obj_Detalle.IdAperturaCancion = lstCanciones[x].IdAperturaCancion;
                                obj_Detalle.Estado = 'A';
                                obj_Turno.Detalles.push(obj_Detalle);
                            }
                        }
                    }
                    clearTimeout(obj_TimerTurno);
                    AccionDefault(true, "Turno.aspx/GuardarTurno", {
                        "str_pTurno": JSON.stringify(obj_Turno),
                        "int_pIdAperturaDrop": int_IdAperturaDrop,
                        "int_pIdUbicacionDrag": int_IdUbicacionDrag,
                        "str_pCancionTurno": JSON.stringify(obj_CancionTurno)
                    }, function (obj_pResultado) {
                        if (obj_pResultado.OperationResult == 1) {
                            AlertJQ(2, obj_pResultado.Message, function () {
                                obj_gAperturaTurno = null;
                                obj_gAperturaCancionTurno = null;
                                obj_gAperturaTurnoSiguiente = null;
                                int_gContadorCancionesCantadas = 0;
                                if (obj_gAperturaTurno != null && lstCancionesTurno.length < 1) {
                                    AlertarTurno(int_IdUbicacionDrag, 4);
                                }
                                ListarTurno();
                            });
                        }
                    }, null, null, null, 1);
                }
            , null, function () {
                ui.draggable.animate(ui.draggable.data().origPosition, "slow");
            });
        }
    });
}

function QuitarCancion(int_pIdApertura, int_pIdAperturaCancion) {//Ya modificado
    clearTimeout(obj_TimerTurno);
    AccionDefault(true, "Turno.aspx/QuitarCancion",
        {
            "int_pIdLocal": $('#hdIdLocal').val(),
            "int_pIdApertura": int_pIdApertura,
            "int_pIdAperturaCancion": int_pIdAperturaCancion
        }, function (obj_pResultado) {
            obj_gAperturaCancionTurno = null;
            int_gContadorCancionesCantadas++;
            ListarTurno();
        }, null, null, null, 1, false, false)
}

function AlertarTurno(int_pIdUbicacion, int_pIdTipoAlerta) {
    AccionDefault(true, "Turno.aspx/AlertarTurno", {
        "int_pIdLocal": $('#hdIdLocal').val(),
        "int_pIdUbicacion": int_pIdUbicacion,
        "int_pIdTipoAlerta": int_pIdTipoAlerta
    }, function (obj_pResultado) {
        if (obj_pResultado != null) {

        }
    }, null, null, null, 1, false, false);
}

//Variables para la cuenta regresiva
var int_SegundosEspera = null;
var int_SegundosMesa = null;
var int_TiempoAPasar = null;
var int_TiempoTotalSegundos = null;

function CuentaRegresiva(int_DuracionEspera, int_Duracion) {
    if (int_SegundosMesa == null || int_SegundosMesa < 0) {
        int_SegundosEspera = int_DuracionEspera;
        int_SegundosMesa = int_Duracion;
        int_TiempoAPasar = int_SegundosEspera + int_SegundosMesa;
        int_TiempoTotalSegundos = int_SegundosEspera + int_SegundosMesa;
    }

    obj_CuentaRegresiva = setTimeout(
       function () {
           CuentaRegresiva(int_SegundosEspera, int_SegundosMesa);
       }, 1000);

    if (int_SegundosEspera != null && int_SegundosEspera == 0) {
        $("#spnTimerEspera").html("(Tiempo de espera terminado)");
        int_SegundosEspera = null;
    } else if (int_SegundosMesa == 0) {
        clearTimeout(obj_CuentaRegresiva);
        obj_CuentaRegresiva = null;
        int_SegundosMesa = null;
        int_TiempoAPasar = null;
        int_TiempoTotalSegundos = null;
        $("#spnTimer").html("(Tiempo terminado)");
        QuitarCancion(obj_gAperturaTurno.IdApertura, obj_gAperturaCancionTurno.IdAperturaCancion);//Ya modificado
    } else if (int_TiempoTotalSegundos == int_TiempoVerificar) {
        var int_LimiteCanciones = parseInt($('#hdLimiteCanciones').val());
        if (int_LimiteCanciones - int_gContadorCancionesCantadas == 1) {
            if (obj_gAperturaTurnoSiguiente != null) {
                if (obj_gAperturaTurnoSiguiente.Canciones.length >= 1) {
                    AlertarTurno(obj_gAperturaTurnoSiguiente.Ubicaciones[0].IdUbicacion, 3);
                } else {
                    AlertarTurno(obj_gAperturaTurnoSiguiente.Ubicaciones[0].IdUbicacion, 4);
                }
            }
        }
    } else if (int_SegundosEspera != null && int_SegundosEspera >= 0) {
        $("#spnTimerEspera").html("(Tiempo de espera: " + int_SegundosEspera + " seg.)");
        $("#spnTimer").html("(Tiempo de canción: " + int_SegundosMesa + " segundos)");
    } else if (int_SegundosMesa <= int_TiempoAPasar) {
        $("#spnTimer").html("(Tiempo de canción: " + int_SegundosMesa + " segundos)");
    }

    if (int_SegundosEspera == null)
        int_SegundosMesa--;
    else
        int_SegundosEspera--;

    int_TiempoTotalSegundos--;
}