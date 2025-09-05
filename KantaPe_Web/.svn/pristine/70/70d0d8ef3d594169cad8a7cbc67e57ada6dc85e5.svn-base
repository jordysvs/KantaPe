//Atributos
var urlPrincipal = 'LocalCancion.aspx';
var urlEdicion = 'RegistroLocalCancion.aspx';

$(function () {
    CargarInicial();
    CargarControles();
    ObtenerCancion();
});

var substringMatcher = function (strs) {
    return function findMatches(q, cb) {
        var matches, substringRegex;

        // an array that will be populated with substring matches
        matches = [];

        // regex used to determine if a string contains the substring `q`
        substrRegex = new RegExp(q, 'i');

        // iterate through the pool of strings and for any string that
        // contains the substring `q`, add it to the `matches` array
        $.each(strs, function (i, str) {
            if (substrRegex.test(str)) {
                matches.push(str);
            }
        });

        cb(matches);
    };
};


function CargarInicial() {

    var states = ['Alabama', 'Alaska', 'Arizona', 'Arkansas', 'California',
  'Colorado', 'Connecticut', 'Delaware', 'Florida', 'Georgia', 'Hawaii',
  'Idaho', 'Illinois', 'Indiana', 'Iowa', 'Kansas', 'Kentucky', 'Louisiana',
  'Maine', 'Maryland', 'Massachusetts', 'Michigan', 'Minnesota',
  'Mississippi', 'Missouri', 'Montana', 'Nebraska', 'Nevada', 'New Hampshire',
  'New Jersey', 'New Mexico', 'New York', 'North Carolina', 'North Dakota',
  'Ohio', 'Oklahoma', 'Oregon', 'Pennsylvania', 'Rhode Island',
  'South Carolina', 'South Dakota', 'Tennessee', 'Texas', 'Utah', 'Vermont',
  'Virginia', 'Washington', 'West Virginia', 'Wisconsin', 'Wyoming'
    ];

    $('#txtTitulo').typeahead({
        hint: true,
        highlight: true,
        minLength: 1
    },
    {
        name: 'states',
        source: substringMatcher(states)
    });


    $("#ddlEmpresa").change(function () {
        CargarLocal();
        return false;
    });

  //  var typeaheadSource = [{ id: 1, name: 'John' }, { id: 2, name: 'Alex' }, { id: 3, name: 'Terry' }];

  //  $('#txtTitulo').typeahead({
  //      source: typeaheadSource,
  //      template: [
  //'<p class="repo-language">{{id}}</p>',
  //'<p class="repo-name">{{name}}</p>',
  //'<p class="repo-description">{{name}}</p>'
  //      ].join(''),
  //  });

    //$('#txtTitulo').typeahead({
    //    hint: true,
    //    highlight: true,
    //    minLength: 1,
    //    local: ['alpha', 'allpha2', 'alpha3', 'bravo', 'charlie', 'delta', 'epsilon', 'gamma', 'zulu']
    //});

    //$('.tt-query').css('background-color', '#fff');

    //jQuery.validator.addMethod('selectArtista', function (value) {
    //    return (value != '');
    //}, "Seleccione el artista");

    //jQuery.validator.addMethod('selectAlbum', function (value) {
    //    return (value != '');
    //}, "Seleccione el álbum");

    //jQuery.validator.addMethod('selectGenero', function (value) {
    //    return (value != '');
    //}, "Seleccione el género");

    //jQuery.validator.addMethod('selectIdioma', function (value) {
    //    return (value != '');
    //}, "Seleccione el idioma");

    //jQuery.validator.addMethod('selectCancionSolicitud', function (value) {
    //    return (value != '');
    //}, "Seleccione la canción solicitud");

    //jQuery.validator.addMethod('selectEstado', function (value) {
    //    return (value != '');
    //}, "Seleccione el estado");

    //$('#frmContent').validate({
    //    rules: {
    //        ctl00$cphBody$ddlArtista: { selectArtista: true },
    //        ctl00$cphBody$ddlAlbum: { selectAlbum: true },
    //        ctl00$cphBody$ddlGenero: { selectGenero: true },
    //        ctl00$cphBody$ddlIdioma: { selectIdioma: true },
    //        ctl00$cphBody$txtTitulo: { required: true, },
    //        ctl00$cphBody$txtDecada: { required: true, },
    //        ctl00$cphBody$txtVersion: { required: true, },
    //        ctl00$cphBody$txtNombreArchivo: { required: true, },
    //        ctl00$cphBody$txtAnio: { required: true, },
    //        ctl00$cphBody$txtLetra: { required: true, },
    //        ctl00$cphBody$txtDuracion: { required: true, },
    //        ctl00$cphBody$txtYoutube: { required: true, },
    //        ctl00$cphBody$ddlCancionSolicitud: { selectCancionSolicitud: true },
    //        ctl00$cphBody$ddlEstado: { selectEstado: true }
    //    },
    //    messages: {
    //        ctl00$cphBody$txtTitulo: { required: 'Ingrese el titulo' },
    //        ctl00$cphBody$txtDecada: { required: 'Ingrese la decada' },
    //        ctl00$cphBody$txtVersion: { required: 'Ingrese la versión' },
    //        ctl00$cphBody$txtNombreArchivo: { required: 'Ingrese el nombre del archivo' },
    //        ctl00$cphBody$txtAnio: { required: 'Ingrese el año' },
    //        ctl00$cphBody$txtLetra: { required: 'Ingrese la letra' },
    //        ctl00$cphBody$txtDuracion: { required: 'Ingrese la duración' },
    //        ctl00$cphBody$txtYoutube: { required: 'Ingrese el enlace' },
    //    },
    //    highlight: function (element) {
    //        $(element).closest('.form-group').removeClass('has-success').addClass('has-error');
    //    },
    //    success: function (element) {
    //        $(element).closest('.form-group').removeClass('has-error').addClass('has-success');
    //    }
    //});
}

function CargarControles() {

    //$(".btnGrabar").click(function () {
    //    return guardarCancion();
    //});

    //$(".btnCancelar").click(function () {
    //    ConfirmJQ('¿Está seguro de regresar a la ventana anterior?', function () { document.location.href = urlPrincipal });
    //    return false;
    //});

    //$("#txtTitulo").focus();
}

function GuardarCancion() {

    //if ($('#frmContent').valid()) {

    //    obj_Cancion = new Object();
    //    obj_Cancion.IdAlbum = $("#hdIdAlbum").val();
    //    obj_Cancion.Titulo = $("#txtTitulo").val();
    //    obj_Cancion.IdArtista = $("#ddlArtista").val();
    //    obj_Cancion.IdAlbum = $("#ddlAlbum").val();
    //    obj_Cancion.IdGenero = $("#ddlGenero").val();
    //    obj_Cancion.IdIdioma = $("#ddlIdioma").val();
    //    obj_Cancion.Decada = $("#txtDecada").val();
    //    obj_Cancion.Version = $("#txtVersion").val();
    //    obj_Cancion.NombreArchivo = $("#txtNombreArchivo").val();
    //    obj_Cancion.Anio = $("#txtAnio").val();
    //    obj_Cancion.Letra = $("#txtLetra").val();
    //    obj_Cancion.Duracion = $("#txtDuracion").val();
    //    obj_Cancion.Youtube = $("#txtYoutube").val();
    //    obj_Cancion.IdCancionSolicitud = $("#hdIdCancionSolicitud").val();
    //    obj_Cancion.Estado = $("#ddlEstado").val();

    //    Accion('RegistroCancion.aspx/GuardarCancion', { "str_pCancion": JSON.stringify(obj_Cancion) },
    //        function () { document.location.href = urlPrincipal; });
    //}
    //return false;
}

function ObtenerCancion() {
    //var int_IdCancion = $("#hdIdCancion").val();
    //if (int_IdCancion != '') {
    //    var obj_Cancion = ObtenerData("RegistroCancion.aspx/ObtenerCancion", { "int_pIdCancion": int_IdCancion });
    //    if (obj_Cancion != null) {
    //        $("#txtTitulo").val(obj_Cancion.Titulo);
    //        $("#ddlArtista").val(obj_Cancion.IdArtista);
    //        $("#ddlAlbum").val(obj_Cancion.IdArtista);
    //        $("#ddlGenero").val(obj_Cancion.IdGenero);
    //        $("#ddlIdioma").val(obj_Cancion.IdIdioma);
    //        $("#txtDecada").val(obj_Cancion.Decada);
    //        $("#txtVersion").val(obj_Cancion.Version);
    //        $("#txtNombreArchivo").val(obj_Cancion.NombreArchivo);
    //        $("#txtAnio").val(obj_Cancion.Anio);
    //        $("#txtLetra").val(obj_Cancion.Letra);
    //        $("#txtDuracion").val(obj_Cancion.Duracion);
    //        $("#txtYoutube").val(obj_Cancion.Youtube);
    //        $("#hdIdCancionSolicitud").val(obj_Cancion.IdCancionSolicitud);
    //        $("#txtCancionSolicitud").val(obj_Cancion.CancionSolicitud.Descripcion);
    //        $("#ddlEstado").val(obj_Cancion.Estado);

    //        //Auditoria
    //        $("#ddUsuarioCreacion").html(obj_Cancion.UsuarioCreacion);
    //        $("#ddUsuarioModificacion").html(obj_Cancion.UsuarioModificacion);
    //        $("#ddFechaCreacion").html(ToDateTimeString(obj_Cancion.FechaCreacion));
    //        $("#ddFechaModificacion").html(ToDateTimeString(obj_Cancion.FechaModificacion));
    //    }
    //}
}

function CargarLocal() {
    var ddlLocal = $("#ddlLocal");
    ddlLocal.html('');
    ddlLocal.append($("<option value='-1'>--Seleccione--</option>"));

    if ($("#ddlEmpresa").val() != '-1') {
        var obj_Data = { "int_pIdEmpresa": $("#ddlEmpresa").val() };
        AccionDefault(true, "RegistroLocalCancion.aspx/ListarLocal", obj_Data,
        function (obj_pLista) {
            for (var i = 0; i < obj_pLista.length; i++) {
                ddlLocal.append($("<option value='" + obj_pLista[i].IdLocal + "'>" + obj_pLista[i].Nombre + "</option>"));
            }
        }, null, null, null, 1);
    }
}