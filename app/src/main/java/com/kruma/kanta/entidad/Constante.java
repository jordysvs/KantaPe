package com.kruma.kanta.entidad;

/**
 * Created by Enrique on 21/07/2016.
 */
public class Constante {

    public static final String ESTADO_ACTIVO = "A";
    public static final String ESTADO_PENDIENTE = "P";
    public static final String ESTADO_RECHAZADO = "R";
    public static final String ESTADO_CANCELADO = "C";
    public static final String ESTADO_INACTIVO = "I";

    public static final String CONDICION_POSITIVO = "S";
    public static final String CONDICION_NEGATIVO = "N";

    public static final String NULL_TYPE = "null";
    public static final String SERVICE_USUARIO = "Usuario";
    public static final String SERVICE_LOCAL = "Local";
    public static final String SERVICE_CANCION = "Cancion";
    public static final String SERVICE_LOCALCANCION = "LocalCancion";
    public static final String SERVICE_CARTA = "Carta";
    public static final String SERVICE_GENEROMUSICAL = "Genero";
    public static final String SERVICE_APERTURACANCIONSOLICITUD = "AperturaCancionSolicitud";
    public static final String SERVICE_PRODUCTOTIPO = "ProductoTipo";
    public static final String SERVICE_IDIOMA = "Idioma";
    public static final String SERVICE_OFERTA = "Oferta";
    public static final String SERVICE_EVENTO = "Evento";
    public static final String SERVICE_APERTURA = "Apertura";
    public static final String SERVICE_UBICACION = "Ubicacion";
    public static final String SERVICE_APERTURAUSUARIO = "AperturaUsuario";
    public static final String SERVICE_APERTURACANCION = "AperturaCancion";
    public static final String SERVICE_SOLICITUDCANCION = "SolicitudCancion";

    public static int TXT_FILTRO_BEBIDA_PIQUEO;

    //Constantes para Abrir Fragment desde la Notificacion
    public static int ID_FIREBASE_MESSAGING;

    //Constantes para fragments de NavigationView
    public static final int FRAGMENT_INICIO = 0;
    public static final int FRAGMENT_CANCIONES = 1;
    public static final int FRAGMENT_NUEVA_CANCION = 2;
    public static final int FRAGMENT_CARTA = 3;
    public static final int FRAGMENT_TURNOS_NAV = 4;
    public static final int FRAGMENT_MESAS_NAV = 5;
    public static final int FRAGMENT_MI_PERFIL = 6;
    public static final int FRAGMENT_MI_MESA = 7;
    public static final int FRAGMENT_TUTORIAL = 40;

    public static final int FRAGMENT_KARAOKES = 41;
    public static final int FRAGMENT_BUSCAR_CANCION = 42;
    //Agregando


    public static final int FRAGMENT_CERRAR_SESSION = 22;

    public static final int FRAGMENT_APERTURA_MI_MESA = 23;


    //Para enviar la cancion
    public static int ID_LOCALCANCION;


    public static int ID_LOCAL;
    public static int ID_CANCION;
    //Constantes
    public static  String TXT_FILTRAR_IDIOMA;
    public static  String TXT_FILTRAR_GENERO;

    public static  String TXT_FILTRAR_PAIS;

    public static  String ID_IDIOMA;
    public static  String ID_GENERO;
    public static  String ID_PAIS;

    public static String ID_PRODUCTO_TIPO;


    //Para Login con Facebook
    //public static  String USUARIO_FACEBOOK;
    public static  String TXT_NOMBRE_FACEBOOK;
    public static  String TXT_APELLIDO_PATERNO_FACEBOOK;
    public static  String TXT_APELLIDO_MATERNO_FACEBOOK;
    public static  String TXT_CORREO_FACEBOOK;
    public static  String TXT_FECHANACIMIENTO_FACEBOOK;
    public static  String TXT_SEXO_FACEBOOK;
    public static  String TXT_DNI_FACEBOOK;



    //Constante para La Apertura de mesas
    //public static  String ID_LOCAL;
    //public static  String ID_UBICACION;
    //public static  String ID_ALERTA;
    //public static  int ID_APERTURA;
    //public static  int ID_APERTURA_USUARIO;

    //Datos de Perfil
    //public static  String TXT_USUARIO_DATOSPERFIL_FRAGMENT;

    //FlagMozo
    //public  static  String FLAG_MOZO;


    //Constante para Login Normal
    //public  static String TXT_USUARIO_LOGEADO ;

    //Constante de Session
    public static final String SESSION_FLAGMOZO = "FLAGMOZO";
    public static final String SESSION_IDLOCAL = "IDLOCAL";
    public static final String SESSION_IDUBICACION = "IDUBICACION";
    public static final String SESSION_IDALERTA = "IDALERTA";
    public static final String SESSION_IDAPERTURA = "IDAPERTURA";
    public static final String SESSION_IDAPERTURAUSUARIO = "IDAPERTURAUSUARIO";

    public static final String SESSION_NOMBREKARAOKE = "NOMBREKARAOKE";
    public static final String SESSION_IDKARAOKE = "IDKARAOKE";
    public static final String SESSION_IDLOCAL_CANCION = "IDLOCALCANCION";

    //Constante servicios de Ubicacion
    public static final String SESSION_LONGITUD ="LONGITUD";
    public static final String SESSION_LATITUD ="LATITUD";
    public static final String SESSION_RADIO ="RADIO";

    public static final String SESSION_FLAGLOCALIZACION ="FLAGLOCALIZACION";

    //Constante Servicos de la Ubicacion de el Celular
    public static final String SESSION_MI_LONGITUD ="LONGITUD_CELULAR";
    public static final String SESSION_MI_LATITUD ="LATITUD_CELULAR";

    //

    // Contantes para fragments de Activity

    public static final int FRAGMENT_TUTORIAL_F = 90;
    public static final int FRAGMENT_OFERTAS = 87;
    public static final int FRAGMENT_EVENTOS = 88;

    public static final int FRAGMENT_RANKING = 8;
    public static final int FRAGMENT_INGRESOS = 91;
    public static final int FRAGMENT_LISTA = 9;

    public static final int FRAGMENT_TRAGOS = 10;
    public static final int FRAGMENT_PIQUEOS = 11;
    public static final int FRAGMENT_MESAS_ACT = 12;
    public static final int FRAGMENT_CONSUMO = 13;
    public static final int FRAGMENT_TURNOS_ACT = 14;
    public static final int FRAGMENT_PLANO = 15;
    public static final int FRAGMENT_DATOS_PERFIL = 16;
    public static final int FRAGMENT_CANCIONES_PERFIL = 17;
    public static final int FRAGMENT_CONSUMO_PERFIL = 18;
    public static final int FRAGMENT_USUARIOS_MESA = 19;
    public static final int FRAGMENT_MI_LISTA_MESA = 20;
    public static final int FRAGMENT_MI_LISTA_CANTADAS_MESA = 30;
    public static final int FRAGMENT_CONSUMO_MESA = 21;

    public static final int FRAGMENT_OFERTAS_KARAOKES =  24;
    public static final int FRAGMENT_EVENTOS_KARAOKES =  25;
    public static final int FRAGMENT_LISTACANCIONES_KARAOKES =  26;

    public static final int FRAGMENT_CARTA_KARAOKES =  29;

    public static final int FRAGMENT_BUSCAR_CANCION_F =  27;
    public static final int FRAGMENT_KARAOES_F =  28;

    // Estado activo e inactivo para mostrar u ocultar SearchView
    public static final int SEARCHVIEW_ACTIVO = 100;
    public static final int SEARCHVIEW_INACTIVO = 200;

    // Valor inicial de fragment para SearchResultsActivity
    public static final int SEARCHRESULTS_RANKING = 101;
    public static final int SEARCHRESULTS_INGRESOS = 102;
    public static final int SEARCHRESULTS_LISTA = 103;
    public static final int SEARCHRESULTS_CARTA = 104;

    public static final int SEARCHRESULTS_KARAOKES = 105;
    public static final int SEARCHRESULTS_BUSCARCANCION = 106;
    // Valor inicial de la inicializacion de EL CANCIONERO

    public static final int SEARCHRESULTS_LISTAR_CANCION_KARAOKES = 107;

    public static int CANCIONERO ;
}
