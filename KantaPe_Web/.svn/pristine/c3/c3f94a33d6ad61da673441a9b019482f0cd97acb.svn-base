var guid = (function () {
    function s4() {
        return Math.floor((1 + Math.random()) * 0x10000)
                   .toString(16)
                   .substring(1);
    }
    return function () {
        return s4() + s4() + '-' + s4() + '-' + s4() + '-' +
               s4() + '-' + s4() + s4() + s4();
    };
})();

var parseDate = function (str_pFecha) {
    var str_Slash = '/';
    var reg_Slash = new RegExp(str_Slash, 'g');
    str_pFecha = str_pFecha.replace(reg_Slash, '-');

    var reg_Fecha = /^(\d\d)-(\d\d)-(\d{4}) (\d\d):(\d\d)$/;
    var dtm_Fecha = reg_Fecha.exec(str_pFecha);
    return dtm_Fecha ? new Date(dtm_Fecha[3], dtm_Fecha[2] - 1, dtm_Fecha[1], dtm_Fecha[4], dtm_Fecha[5], 0) : null;
    //return dtm_Fecha ? new Date(dtm_Fecha[3], dtm_Fecha[2] - 1, dtm_Fecha[1], dtm_Fecha[4], dtm_Fecha[5], dtm_Fecha[6]) : null;
};


$(function () {

    document.oncontextmenu = function () { return false; }

    $(".soloNumerosGuion").keyup(function () {
        if ((event.which > 36 && event.which < 41)) {
            event.preventDefault();
        }
        else if (this.value.match(/[^0-9\-]/g)) {
            this.value = this.value.replace(/[^0-9\-]/g, '');
        }
    });


    $(".soloNumeros").keyup(function () {
        if ((event.which > 36 && event.which < 41)) {
            event.preventDefault();
        }
        else if (this.value.match(/[^0-9]/g)) {
            this.value = this.value.replace(/[^0-9]/g, '');
        }
    });

    $(".soloNumerosDecimalNegativo").on("keypress keyup blur", function (event) {
        if ((event.which > 36 && event.which < 41)) {
            event.preventDefault();
        }
        else if (this.value.match(/[^0-9\.\-]/g)) {
            this.value = this.value.replace(/[^0-9\.\-]/g, '');
        }
        if ((event.which != 45 || $(this).val().indexOf('-') != -1) && (event.which != 46 || $(this).val().indexOf('.') != -1) && (event.which < 48 || event.which > 57)) {
            event.preventDefault();
        }
    });


    $(".soloNumerosDecimal").on("keypress keyup blur", function (event) {
        if ((event.which > 36 && event.which < 41)) {
            event.preventDefault();
        }
        else if (this.value.match(/[^0-9\.]/g)) {
            this.value = this.value.replace(/[^0-9\.]/g, '');
        }
        if ((event.which != 46 || $(this).val().indexOf('.') != -1) && (event.which < 48 || event.which > 57)) {
            event.preventDefault();
        }
    });

    $('textarea[maxlength]').keyup(function () {
        var limit = parseInt($(this).attr('maxlength'));
        var text = $(this).val();
        var chars = text.length;
        if (chars > limit) {
            var new_text = text.substr(0, limit);
            $(this).val(new_text);
        }
    });
});

//Mensaje de Alerta
function AlertJQ(int_pIcono, str_pMensaje, obj_pSucess, obj_pSucessArgs, bln_pCerrar) {
    //Clonacion del modal
    var str_Id = guid();
    var obj_modal_template = $("#md-template").get(0);
    var obj_modal = $(obj_modal_template.cloneNode(true));
    obj_modal.attr('id', str_Id);
    //Titulo
    obj_modal.find('.modal-header h3').append('Mensaje del Sistema');
    //Mensaje de la alerta
    obj_modal.find('.modal-body .text-center').append('<p>' + str_pMensaje + '</p>');

    if (int_pIcono == null)
        int_pIcono = 1;

    if (int_pIcono == 1) {
        obj_modal.addClass('info');
        obj_modal.find('.modal-body .text-center .i-circle.info').css('display', '');
        obj_modal.find('.modal-footer .btn-aceptar').addClass('btn-info');
    } else if (int_pIcono == 2) {
        obj_modal.addClass('success');
        obj_modal.find('.modal-body .text-center .i-circle.success').css('display', '');
        obj_modal.find('.modal-footer .btn-aceptar').addClass('btn-success');
    } else if (int_pIcono == 3) {
        obj_modal.addClass('warning');
        obj_modal.find('.modal-body .text-center .i-circle.warning').css('display', '');
        obj_modal.find('.modal-footer .btn-aceptar').addClass('btn-warning');
    } else if (int_pIcono == 4) {
        obj_modal.addClass('danger');
        obj_modal.find('.modal-body .text-center .i-circle.danger').css('display', '');
        obj_modal.find('.modal-footer .btn-aceptar').addClass('btn-danger');
    }
    //agregar al formulario
    //obj_modal.appendTo('body');
    //Boton aceptar
    obj_modal.find('.modal-footer .btn-aceptar').click(function () {
        if (obj_pSucess != null)
            obj_pSucess.apply(this, obj_pSucessArgs);
        //obj_modal.modal('hide');
    });

    if (bln_pCerrar == null)
        bln_pCerrar = false;

    if (bln_pCerrar) {
        obj_modal.find('.modal-header .btn-cerrar').click(function () {
            if (obj_pSucess != null)
                obj_pSucess.apply(this, obj_pSucessArgs);
        });
    }
    //Evento Cerrar
    obj_modal.on('hidden.bs.modal', function () {
        obj_modal.remove();
    });
    obj_modal.modal('show');

    obj_modal.on('shown.bs.modal', function () {
        obj_modal.find('.modal-footer .btn-aceptar').focus();
    });

    return obj_modal;
}

function ConfirmJQ(str_pMensaje, obj_pSucess, obj_pSucessArgs, obj_pNoSucess, obj_pNoSucessArgs) {
    //Clonacion del modal
    var str_Id = guid();
    var obj_modal_template = $("#md-confirm-template").get(0);
    var obj_modal = $(obj_modal_template.cloneNode(true));
    obj_modal.attr('id', str_Id);
    //Titulo
    obj_modal.find('.modal-header h3').append('Mensaje del Sistema');
    //Mensaje de la alerta
    obj_modal.find('.modal-body .text-center').append('<p>' + str_pMensaje + '</p>');
    //Agregar al formulario
    // obj_modal.appendTo('body');
    //Boton aceptar
    obj_modal.find('.modal-footer .btn-aceptar').click(function () {
        if (obj_pSucess != null)
            obj_pSucess.apply(this, obj_pSucessArgs);
        //obj_modal.modal('hide');
    });
    //Boton cancelar
    obj_modal.find('.modal-footer .btn-cancelar').click(function () {
        if (obj_pNoSucess != null)
            obj_pNoSucess.apply(this, obj_pNoSucessArgs);
        obj_modal.modal('hide');
    });
    //Evento Cerrar
    obj_modal.on('hidden.bs.modal', function () {
        obj_modal.remove();
    });

    obj_modal.on('shown.bs.modal', function () {
        obj_modal.find('.modal-footer .btn-aceptar').focus();
    });

    obj_modal.modal('show');
}

//Proceso de Data - AJAX
function ObtenerData(str_pUrl, obj_pData) {
    return AccionDefault(false, str_pUrl, obj_pData);
}

//Accion de resultado de proceso
function Accion(str_pUrl, obj_pData, obj_pSucess, obj_pSucessArgs, obj_pNoSucess, obj_pNoSucessArgs) {
    AccionDefault(true, str_pUrl, obj_pData, obj_pSucess, obj_pSucessArgs, obj_pNoSucess, obj_pNoSucessArgs, 0, true);
}

//Accion para resultado de valores
function AccionValor(str_pUrl, obj_pData, obj_pSucess, obj_pSucessArgs, obj_pNoSucess, obj_pNoSucessArgs) {
    AccionDefault(true, str_pUrl, obj_pData, obj_pSucess, obj_pSucessArgs, obj_pNoSucess, obj_pNoSucessArgs, 1, true);
}

function AccionDefault(obj_pAsync, str_pUrl, obj_pData, obj_pSucess, obj_pSucessArgs, obj_pNoSucess, obj_pNoSucessArgs, obj_pTipoAccion, bln_pLoading, bln_pMessage) {
    if (bln_pLoading == undefined)
        bln_pLoading = true;
    if (bln_pMessage == undefined)
        bln_pMessage = true;
    var obj_vDataReturn = null;
    $.ajax({
        type: "POST",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        async: obj_pAsync,
        beforeSend: function (objeto) {
            if (bln_pLoading)
                MostrarMensajeCargando();
        },
        complete: function (objeto, exito) {
            if (bln_pLoading)
                CerrarMensajeCargando();
        },
        url: str_pUrl,
        data: JSON.stringify(obj_pData),
        success: function (data) {
            obj_vDataReturn = data;
            if (obj_vDataReturn.hasOwnProperty('d'))
                obj_vDataReturn = data.d;

            if (obj_pTipoAccion != null) {
                switch (obj_pTipoAccion) {
                    case 0:
                        var blnMensaje = true;
                        var str_Mensaje = '';
                        //Operacion
                        if (obj_vDataReturn.hasOwnProperty('OperationResult')) {
                            if (obj_vDataReturn.OperationResult == 1) {
                                if (obj_pSucess != null || obj_pSucess != undefined) {
                                    if (obj_pSucessArgs == null)
                                        obj_pSucessArgs = [];
                                    obj_pSucessArgs.splice(0, 0, obj_vDataReturn);

                                    if (obj_vDataReturn.hasOwnProperty('Message')) {
                                        blnMensaje = false;
                                        str_Mensaje = obj_vDataReturn.Detail == null ? obj_vDataReturn.Message : obj_vDataReturn.Detail;
                                        if (str_Mensaje != '') {
                                            if (bln_pMessage)
                                                AlertJQ(2, str_Mensaje, obj_pSucess, obj_pSucessArgs, true);
                                        }
                                        else
                                            obj_pSucess.apply(this, obj_pSucessArgs);
                                    }
                                    else
                                        obj_pSucess.apply(this, obj_pSucessArgs);
                                }
                            }
                        }
                        if (obj_vDataReturn.hasOwnProperty('Message') && blnMensaje) {
                            var int_Mensaje = 2;
                            if (obj_vDataReturn.hasOwnProperty('OperationResult'))
                                int_Mensaje = (obj_vDataReturn.OperationResult == 1) ? 2 : 4;
                            str_Mensaje = obj_vDataReturn.Detail == null ? obj_vDataReturn.Message : obj_vDataReturn.Detail;
                            if (str_Mensaje != '') {
                                if (bln_pMessage)
                                    AlertJQ(int_Mensaje, str_Mensaje);
                            }
                        }
                        break;
                    case 1:
                        //Grilla
                        if (obj_pSucess != null || obj_pSucess != undefined) {
                            if (obj_pSucessArgs == null)
                                obj_pSucessArgs = [];
                            obj_pSucessArgs.splice(0, 0, obj_vDataReturn);
                            obj_pSucess.apply(this, obj_pSucessArgs);
                        }
                        break;
                    default:
                }
            }
        },
        error: function (jqXHR, textStatus, errorThrown) {
            if (obj_pNoSucess != null)
                obj_pNoSucess.apply(this, obj_pNoSucessArgs);
            if (bln_pMessage)
                AlertJQ(4, errorThrown);
        },
    });
    return obj_vDataReturn;
}


//Mensaje de Cargando
function MostrarMensajeCargando() {
    $('#divLoading').css('display', '');
    $('#imgLoading').css('display', '');
}

function CerrarMensajeCargando() {
    $('#imgLoading').css('display', 'none');
    $('#divLoading').css('display', 'none');

}

//KeyBoard
//Enter
function KeyPressEnter(str_pId, obj_pFuncion) {
    $("#" + str_pId + " input, select, textarea").keypress(function (event) {
        if (event.which == 13) {
            event.preventDefault();
            if (obj_pFuncion != null)
                obj_pFuncion.apply(this, []);
        }
    });
}

//FileServer
function VerArchivoVentana(int_pIdAlmacen, int_pIdRegistro, int_pIdDocumento) {

    $('body').prepend("<form id='verFileServerForm' target='_blank' method='post' action='" + UrlPath + "Ashx/FileServerViewHandler.ashx'>" +
        "<input type='hidden' name='int_pIdAlmacen' value='" + int_pIdAlmacen + "' >" +
        "<input type='hidden' name='int_pIdRegistro' value='" + int_pIdRegistro + "' >" +
        "<input type='hidden' name='int_pIdDocumento' value='" + int_pIdDocumento + "' >" +
        "</form>");

    $('#verFileServerForm').submit();
    $("verFileServerForm").remove();
    return false;
};

function VerArchivoElemento(str_pElemento, int_pIdAlmacen, int_pIdRegistro, int_pIdDocumento) {
    $("#" + str_pElemento).attr('src', UrlPath +
        'Ashx/FileServerViewHandler.ashx?idAlm=' + int_pIdAlmacen +
        '&idReg=' + int_pIdRegistro +
        '&idDoc=' + int_pIdDocumento +
        '&r=' + new Date().getTime());
};

//Exportar
function ExportarDocumento(str_pTipo, str_pHTML, str_pNombre, bln_pWorker) {

    var str_HTMLEncode = $('<div/>').text(str_pHTML).html();
    if (str_pNombre == undefined || str_pNombre == null) {
        str_pNombre = '';
    }
    if (bln_pWorker == undefined)
        bln_pWorker = false;

    $('body').prepend("<form id='exportDocumentForm' target='_blank' method='post' action='" + UrlPath + "Ashx/ExportDocumentHandler.ashx'>" +
        "<input type='hidden' name='str_HTML' value='" + str_HTMLEncode + "' >" +
        "<input type='hidden' name='str_Nombre' value='" + str_pNombre + "' >" +
        "<input type='hidden' name='str_Tipo' value='" + str_pTipo + "' >" +
        "<input type='hidden' name='bln_Worker' value='" + bln_pWorker.toString() + "' >" +
        "</form>");
    $('#exportDocumentForm').submit();
    $("exportDocumentForm").remove();
    return false;
};

//Fechas
function ToDateString(obj_pDate) {
    var date = "";
    if (obj_pDate != null) {
        var dateString = obj_pDate.substr(6);
        var currentTime = new Date(parseInt(dateString));
        var month = currentTime.getMonth() + 1;
        var day = currentTime.getDate();
        var year = currentTime.getFullYear();
        date = day + "/" + month + "/" + year;
    }
    return date;
}

function ToDateTimeString(obj_pDate) {
    var date = "";
    if (obj_pDate != null) {
        var dateString = obj_pDate.substr(6);
        var currentTime = new Date(parseInt(dateString));
        var month = currentTime.getMonth() + 1;
        var day = currentTime.getDate();
        var year = currentTime.getFullYear();
        var hour = currentTime.getHours();
        var minute = currentTime.getMinutes();
        minute = (minute < 10 ? "0" : "") + minute;
        var timeOfDay = (hour < 12) ? "AM" : "PM";
        hour = (hour > 12) ? hour - 12 : hour;
        hour = (hour == 0) ? 12 : hour;
        date = day + "/" + month + "/" + year + " " + hour + ":" + minute + " " + timeOfDay;
    }
    return date;
}

//URL
function GetUrlParameter(sParam) {
    var str_Valor = null;
    var sPageURL = decodeURIComponent(window.location.search.substring(1));
    var sURLVariables = sPageURL.split('&');
    var sParameterName;
    var i;
    for (i = 0; i < sURLVariables.length; i++) {
        sParameterName = sURLVariables[i].split('=');

        if (sParameterName[0] === sParam) {
            if (sParameterName[1] != undefined)
                str_Valor = sParameterName[1];
        }
    }
    return str_Valor;
}

//Select Modulo
function CargarModuloSelect(str_pId, bln_pDefaultOption, str_pDefaultText) {

    var str_Path = window.location.href;
    str_Path = "/" + str_Path.replace(/^(?:\/\/|[^\/]+)*\//, "");

    var obj_Lista = ObtenerData(UrlPath + "Redireccionar.aspx/ListarModuloPagina",
        {
            "str_pIdModulo": window.sessionStorage.IdModulo,
            "str_pPath": str_Path
        });

    var ddlControl = $("#" + str_pId).html('');
    if (bln_pDefaultOption)
        if (obj_Lista.length > 1)
            ddlControl.append($("<option value=''>" + str_pDefaultText + "</option>"));
    for (var i = 0; i < obj_Lista.length; i++) {
        ddlControl.append($("<option value='" + obj_Lista[i].IdModulo + "'>" + obj_Lista[i].Descripcion + "</option>"));
    }
}
