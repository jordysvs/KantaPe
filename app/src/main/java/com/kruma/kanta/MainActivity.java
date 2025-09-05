package com.kruma.kanta;

import android.app.AlertDialog;
import android.app.SearchManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.widget.Button;
import android.widget.LinearLayout;

import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.Profile;
import com.facebook.login.LoginManager;
import com.kruma.core.configuration.App;
import com.kruma.core.util.common.ProcessCallback;
import com.kruma.core.util.common.ProcessResult;
import com.kruma.kanta.entidad.Constante;

import com.kruma.kanta.view.fragments.BuscarCancionFragment;
import com.kruma.kanta.view.fragments.CancionesGeneroDialogFragment;
import com.kruma.kanta.view.fragments.CancionesIdiomaDialogFragment;
import com.kruma.kanta.view.fragments.CancionesPerfilFragment;
import com.kruma.kanta.view.fragments.CartaTipoDialogFragment;
import com.kruma.kanta.view.fragments.ConsumoFragment;
import com.kruma.kanta.view.fragments.ConsumoMesaFragment;
import com.kruma.kanta.view.fragments.ConsumoPerfilFragment;
import com.kruma.kanta.view.fragments.DatosPerfilFragment;
import com.kruma.kanta.view.fragments.EventoKaraokeFragment;
import com.kruma.kanta.view.fragments.EventosFragment;
import com.kruma.kanta.view.fragments.KaraokesFragment;
import com.kruma.kanta.view.fragments.KaraokesPaisDialogFragment;
import com.kruma.kanta.view.fragments.ListaFragment;
import com.kruma.kanta.view.fragments.ListarCancionKaraokeFragment;
import com.kruma.kanta.view.fragments.MesasFragment;
import com.kruma.kanta.view.fragments.MiListaMesaCantadasFragment;
import com.kruma.kanta.view.fragments.MiListaMesaFragment;
import com.kruma.kanta.view.fragments.IngresosFragment;
import com.kruma.kanta.view.fragments.OfertasFragment;
import com.kruma.kanta.view.fragments.OfertasKaraokeFragment;
import com.kruma.kanta.view.fragments.PlanoFragment;
import com.kruma.kanta.view.fragments.RankingFragment;
import com.kruma.kanta.view.fragments.TragosFragment;
import com.kruma.kanta.view.fragments.NuevaCancionFragment;
import com.kruma.kanta.view.fragments.TurnosFragment;
import com.kruma.kanta.view.fragments.TutorialFragment;
import com.kruma.kanta.view.fragments.UsuariosMesaFragment;

public class MainActivity extends AppCompatActivity implements OnNavigationListener, SearchView.OnQueryTextListener {

    // ----- INICIO
    SearchView searchView;
    public Button btnOfertas;
    public Button btnEventos;
    //-------TUTORIAL
    public Button btnTutorial;
    // ----- CANCIONES
    public Button btnRanking;
    public Button btnIngresos;
    public Button btnLista;

    // ----- NUEVA CANCION
    // ----- CARTA
    //public Button btnTragos;
    //public Button btnPiqueos;
    // ----- TURNOS
    public Button btnTurnos;
    public Button btnPlano;
    // ----- MESAS
    public Button btnMesas;
    public Button btnConsumo;
    // ----- KARAOKES
    public Button btnOfertasKaraokes;
    public Button btnEventosKaraokes;
    public Button btnListaCancionesKaraokes;
    // ----- BUSCAR CANCION
    public Button btnBuscarCancion;
    // ----- MI PERFIL
    public Button btnDatosPerfil;
    public Button btnCancionesPerfil;
    //public Button btnConsumoPerfil;
    // ----- MI MESA
    public Button btnUsuariosMesa;
    public Button btnMiListaMesa;
    public Button btnMiListaCantadasMesa;
    public Button btnCerrarSession;
    public TextView txtMiUsuarioLogin;
    //public String Flag_Mozo;
    //region "Variables globales"
    android.support.v7.app.ActionBarDrawerToggle toggle;
    NavigationView navigationView;
    MenuItem searchItem;
    MenuItem optionGenero;
    Boolean bln_gSession = false;
    //--Cerrar session
    MenuItem optionIdioma;
    MenuItem optionTipo;
    MenuItem optionPais;
    LinearLayout linearLayoutBotones;
    //ASIGNAR EL ID
    String ID_FIREBASE_MESSAGING;

    //SessionManager session;
    //region "Eventos Click de los botones"
    // ----- INICIO
    private View.OnClickListener btnOfertasLlamarFragmentOfertas = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            setFragment(Constante.FRAGMENT_OFERTAS);
            colorActivadoButton(btnOfertas);
            colorDesactivadoButton(btnEventos);
        }
    };
    private View.OnClickListener btnEventosLlamarFragmentEventos = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            setFragment(Constante.FRAGMENT_EVENTOS);
            colorActivadoButton(btnEventos);
            colorDesactivadoButton(btnOfertas);
        }
    };
    //-----TUTORIAL
    private View.OnClickListener btnTutorialLlamarFragmentTutorial = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            setFragment(Constante.FRAGMENT_TUTORIAL_F);
            colorActivadoButton(btnTutorial);
        }
    };
    // ----- CANCIONES
    private View.OnClickListener btnListaLlamarFragmentLista = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            setFragment(Constante.FRAGMENT_LISTA);
            colorActivadoButton(btnLista);
            colorDesactivadoButton(btnRanking);
            colorDesactivadoButton(btnIngresos);
        }
    };
    private View.OnClickListener btnRankingLlamarFragmentRanking = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            setFragment(Constante.FRAGMENT_RANKING);
            colorActivadoButton(btnRanking);
            colorDesactivadoButton(btnIngresos);
            colorDesactivadoButton(btnLista);
        }
    };
    private View.OnClickListener btnIngresosLlamarFragmentIngresos = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            setFragment(Constante.FRAGMENT_INGRESOS);
            colorActivadoButton(btnIngresos);
            colorDesactivadoButton(btnRanking);
            colorDesactivadoButton(btnLista);
        }
    };
    // ----- TURNOS
    private View.OnClickListener btnTurnosLlamarFragmentTurnos = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            setFragment(Constante.FRAGMENT_TURNOS_ACT);
            colorActivadoButton(btnTurnos);
            colorDesactivadoButton(btnPlano);
        }
    };
    private View.OnClickListener btnPlanoLlamarFragmentPlano = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            setFragment(Constante.FRAGMENT_PLANO);
            colorActivadoButton(btnPlano);
            colorDesactivadoButton(btnTurnos);
        }
    };
    // ----- MESAS
    private View.OnClickListener btnMesasLlamarFragmentMesas = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            setFragment(Constante.FRAGMENT_MESAS_ACT);
            colorActivadoButton(btnMesas);
            colorDesactivadoButton(btnConsumo);
        }
    };
    private View.OnClickListener btnConsumoLlamarFragmentConsumo = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            setFragment(Constante.FRAGMENT_CONSUMO);
            colorActivadoButton(btnConsumo);
            colorDesactivadoButton(btnMesas);
        }
    };


    //private View.OnClickListener btnAperturaMiMesafragment  = new View.OnClickListener() {
    //  @Override
    //public void onClick(View v) {
    //      setFragment(Constante.FRAGMENT_APERTURA_MI_MESA);
    //    colorActivadoButton(btnAperturaMiMesa);
    //    }
    // };


// ----- NUEVA CANCION


    // ----- CARTA
    /*
    private View.OnClickListener btnTragosLlamarFragmentTragos = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            setFragment(Constante.FRAGMENT_TRAGOS);
            colorActivadoButton(btnTragos);
            colorDesactivadoButton(btnPiqueos);
        }
    };

    private View.OnClickListener btnPiqueosLlamarFragmentPiqueos = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            setFragment(Constante.FRAGMENT_PIQUEOS);
            colorActivadoButton(btnPiqueos);
            colorDesactivadoButton(btnTragos);
        }
    };
    */
// ----- KARAOKES
    private View.OnClickListener btnOfertasKaraokesLlamarFragmentOfertasKaraokes = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            setFragment(Constante.FRAGMENT_OFERTAS_KARAOKES);
            colorActivadoButton(btnOfertasKaraokes);
            colorDesactivadoButton(btnEventosKaraokes);
            colorDesactivadoButton(btnListaCancionesKaraokes);
        }
    };
    private View.OnClickListener btnEventosKaraokesLlamarFragmentEventosKaraokes = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            setFragment(Constante.FRAGMENT_EVENTOS_KARAOKES);

            colorActivadoButton(btnEventosKaraokes);
            colorDesactivadoButton(btnOfertasKaraokes);
            colorDesactivadoButton(btnListaCancionesKaraokes);
        }
    };

    private View.OnClickListener btnListaCancionesKaraokesLlamarFragmentLitaCancionesKaraokes = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            setFragment(Constante.FRAGMENT_LISTACANCIONES_KARAOKES);
            colorActivadoButton(btnListaCancionesKaraokes);
            colorDesactivadoButton(btnOfertasKaraokes);
            colorDesactivadoButton(btnEventosKaraokes);

        }
    };

    // ----- BUSCAR CANCION
    private View.OnClickListener btnBuscarCancionLlamarFragmentBuscarCancion = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            setFragment(Constante.FRAGMENT_BUSCAR_CANCION_F);
            colorActivadoButton(btnBuscarCancion);
            //colorDesactivadoButton(btnMiListaMesa);
            //colorDesactivadoButton(btnMiListaCantadasMesa);
            //colorDesactivadoButton(btnConsumoMesa);
        }
    };


    // ----- MI PERFIL
    private View.OnClickListener btnDatosPerfilLlamarFragmentDatosPerfil = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            setFragment(Constante.FRAGMENT_DATOS_PERFIL);
            colorActivadoButton(btnDatosPerfil);
            colorDesactivadoButton(btnCancionesPerfil);
            //colorDesactivadoButton(btnConsumoPerfil);
        }
    };
    private View.OnClickListener btnCancionesPerfilLlamarFragmentCancionesPerfil = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            setFragment(Constante.FRAGMENT_CANCIONES_PERFIL);
            colorActivadoButton(btnCancionesPerfil);
            colorDesactivadoButton(btnDatosPerfil);
            //colorDesactivadoButton(btnConsumoPerfil);
        }
    };
    // ----- MI MESA
    private View.OnClickListener btnUsuariosMesaLlamarFragmentUsuarioMesa = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            setFragment(Constante.FRAGMENT_USUARIOS_MESA);
            colorActivadoButton(btnUsuariosMesa);
            colorDesactivadoButton(btnMiListaMesa);
            colorDesactivadoButton(btnMiListaCantadasMesa);
            //colorDesactivadoButton(btnConsumoMesa);
        }
    };
    private View.OnClickListener btnMiListaMesaLlamarFragmentMiListaMesa = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            setFragment(Constante.FRAGMENT_MI_LISTA_MESA);
            colorActivadoButton(btnMiListaMesa);
            colorDesactivadoButton(btnUsuariosMesa);
            colorDesactivadoButton(btnMiListaCantadasMesa);
            //colorDesactivadoButton(btnConsumoMesa);
        }
    };
    private View.OnClickListener btnMiListaMesaCantadasLlamarFragmentMiListaCantadasMesa = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            setFragment(Constante.FRAGMENT_MI_LISTA_CANTADAS_MESA);
            colorActivadoButton(btnMiListaCantadasMesa);
            colorDesactivadoButton(btnUsuariosMesa);
            colorDesactivadoButton(btnMiListaMesa);
            //colorDesactivadoButton(btnConsumoMesa);
        }
    };
    // Ahora el NavigationView esta habilitado para que escuche los clicks del menu
    private NavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener = new NavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(MenuItem item) {

            // Obtiene el id de cada item seleccionado del NavigationView
            switch (item.getItemId()) {
                case R.id.nav_menu_inicio:
                    //estado = Constante.SEARCHVIEW_INACTIVO;
                    //invalidateOptionsMenu();
                    if (searchItem != null)
                        searchItem.setVisible(false);
                    if (optionGenero != null)
                        optionGenero.setVisible(false);
                    if (optionIdioma != null)
                        optionIdioma.setVisible(false);
                    if (optionTipo != null)
                        optionTipo.setVisible(false);
                    if (optionPais != null)
                        optionPais.setVisible(false);
                    ocultarBotones();

                    //if(Constante.ID_LOCAL != null){
                    //  mostrarBoton(btnOfertas);
                    //colorActivadoButton(btnOfertas);}

                    mostrarBoton(btnEventos);
                    colorDesactivadoButton(btnEventos);
                    setFragmentMenu(Constante.FRAGMENT_INICIO);
                    break;
                case R.id.nav_menu_tutorial:
                    //estado = Constante.SEARCHVIEW_INACTIVO;
                    //invalidateOptionsMenu();
                    if (searchItem != null)
                        searchItem.setVisible(false);
                    if (optionGenero != null)
                        optionGenero.setVisible(false);
                    if (optionIdioma != null)
                        optionIdioma.setVisible(false);
                    if (optionTipo != null)
                        optionTipo.setVisible(false);
                    if (optionPais != null)
                        optionPais.setVisible(false);
                    ocultarBotones();
                    // mostrarBoton(btnTutorial);
                    setFragmentMenu(Constante.FRAGMENT_TUTORIAL);
                    break;
                case R.id.nav_menu_canciones:
                    //estado = Constante.SEARCHVIEW_ACTIVO;
                    //invalidateOptionsMenu();
                    if (searchItem != null)
                        searchItem.setVisible(true);
                    if (optionGenero != null)
                        optionGenero.setVisible(true);
                    if (optionIdioma != null)
                        optionIdioma.setVisible(true);
                    if (optionTipo != null)
                        optionTipo.setVisible(false);
                    if (optionPais != null)
                        optionPais.setVisible(false);
                    ocultarBotones();
                    mostrarBoton(btnLista);
                    mostrarBoton(btnRanking);
                    mostrarBoton(btnIngresos);
                    colorActivadoButton(btnLista);
                    colorDesactivadoButton(btnRanking);
                    colorDesactivadoButton(btnIngresos);
                    setFragmentMenu(Constante.FRAGMENT_CANCIONES);
                    break;

                case R.id.nav_menu_nueva_cancion:
                    if (searchItem != null)
                        searchItem.setVisible(false);
                    if (optionGenero != null)
                        optionGenero.setVisible(false);
                    if (optionIdioma != null)
                        optionIdioma.setVisible(false);
                    if (optionTipo != null)
                        optionTipo.setVisible(false);
                    if (optionPais != null)
                        optionPais.setVisible(false);
                    ocultarBotones();
                    setFragmentMenu(Constante.FRAGMENT_NUEVA_CANCION);
                    break;

                case R.id.nav_menu_karaokes:
                    if (searchItem != null)
                        searchItem.setVisible(true);
                    if (optionGenero != null)
                        optionGenero.setVisible(false);
                    if (optionIdioma != null)
                        optionIdioma.setVisible(false);
                    if (optionTipo != null)
                        optionTipo.setVisible(false);
                    if (optionPais != null)
                        optionPais.setVisible(true);
                    ocultarBotones();
                    //mostrarBoton(btnOfertasKaraokes);
                    //mostrarBoton(btnEventosKaraokes);
                    //mostrarBoton(btnListaCancionesKaraokes);
                    //colorActivadoButton(btnOfertasKaraokes);
                    //colorDesactivadoButton(btnEventosKaraokes);
                    //colorDesactivadoButton(btnListaCancionesKaraokes);
                    setFragmentMenu(Constante.FRAGMENT_KARAOKES);
                    break;

                case R.id.nav_menu_buscar_cancion:
                    if (searchItem != null)
                        searchItem.setVisible(true);
                    if (optionGenero != null)
                        optionGenero.setVisible(true);
                    if (optionIdioma != null)
                        optionIdioma.setVisible(true);
                    if (optionTipo != null)
                        optionTipo.setVisible(false);
                    if (optionPais != null)
                        optionPais.setVisible(false);
                    ocultarBotones();
                    setFragmentMenu(Constante.FRAGMENT_BUSCAR_CANCION);
                    break;
                case R.id.nav_menu_carta:
                    if (searchItem != null)
                        searchItem.setVisible(true);
                    if (optionGenero != null)
                        optionGenero.setVisible(false);
                    if (optionIdioma != null)
                        optionIdioma.setVisible(false);
                    if (optionTipo != null)
                        optionTipo.setVisible(true);
                    if (optionPais != null)
                        optionPais.setVisible(false);
                    ocultarBotones();
                    //mostrarBoton(btnTragos);
                    //mostrarBoton(btnPiqueos);
                    //colorActivadoButton(btnTragos);
                    //colorDesactivadoButton(btnPiqueos);
                    setFragmentMenu(Constante.FRAGMENT_CARTA);
                    break;


                case R.id.nav_menu_turnos:
                    if (searchItem != null)
                        searchItem.setVisible(false);
                    if (optionGenero != null)
                        optionGenero.setVisible(false);
                    if (optionIdioma != null)
                        optionIdioma.setVisible(false);
                    if (optionTipo != null)
                        optionTipo.setVisible(false);
                    if (optionPais != null)
                        optionPais.setVisible(false);
                    ocultarBotones();
                    mostrarBoton(btnTurnos);
                    mostrarBoton(btnPlano);
                    colorActivadoButton(btnTurnos);
                    colorDesactivadoButton(btnPlano);
                    setFragmentMenu(Constante.FRAGMENT_TURNOS_NAV);
                    break;

                /*
                case R.id.nav_menu_mesas:
                    if (searchItem != null)
                        searchItem.setVisible(false);
                    ocultarBotones();
                    mostrarBoton(btnMesas);
                    mostrarBoton(btnConsumo);
                    colorActivadoButton(btnMesas);
                    colorDesactivadoButton(btnConsumo);
                    setFragmentMenu(Constante.FRAGMENT_MESAS_NAV);
                    break;
                */

                case R.id.nav_menu_mi_perfil:
                    if (searchItem != null)
                        searchItem.setVisible(false);
                    if (optionGenero != null)
                        optionGenero.setVisible(false);
                    if (optionIdioma != null)
                        optionIdioma.setVisible(false);
                    if (optionTipo != null)
                        optionTipo.setVisible(false);
                    if (optionPais != null)
                        optionPais.setVisible(false);
                    ocultarBotones();
                    // mostrarBoton(btnDatosPerfil);
                    // mostrarBoton(btnCancionesPerfil);
                    //mostrarBoton(btnConsumoPerfil);
                    //colorActivadoButton(btnDatosPerfil);
                    //colorDesactivadoButton(btnCancionesPerfil);
                    //colorDesactivadoButton(btnConsumoPerfil);
                    setFragmentMenu(Constante.FRAGMENT_MI_PERFIL);
                    break;

                case R.id.nav_menu_mi_mesa:
                    if (searchItem != null)
                        searchItem.setVisible(false);
                    if (optionGenero != null)
                        optionGenero.setVisible(false);
                    if (optionIdioma != null)
                        optionIdioma.setVisible(false);
                    if (optionTipo != null)
                        optionTipo.setVisible(false);
                    if (optionPais != null)
                        optionPais.setVisible(false);
                    ocultarBotones();
                    mostrarBoton(btnUsuariosMesa);
                    mostrarBoton(btnMiListaMesa);
                    mostrarBoton(btnMiListaCantadasMesa);
                    //mostrarBoton(btnConsumoMesa);
                    colorActivadoButton(btnUsuariosMesa);
                    colorDesactivadoButton(btnMiListaMesa);
                    colorDesactivadoButton(btnMiListaCantadasMesa);
                    //colorDesactivadoButton(btnConsumoMesa);
                    setFragmentMenu(Constante.FRAGMENT_MI_MESA);
                    break;

                case R.id.nav_menu_cerrar_session:
                    ocultarBotones();
                    // mostrarBoton(btnCerrarSession);
                    //mostrarBoton(btnCancionesPerfil);
                    //mostrarBoton(btnConsumoPerfil);
                    colorActivadoButton(btnCerrarSession);
                    //colorDesactivadoButton(btnCancionesPerfil);
                    //colorDesactivadoButton(btnConsumoPerfil);
                    setFragmentMenu(Constante.FRAGMENT_CERRAR_SESSION);

                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                    builder.setMessage("¿Desea cerrar sesión?")
                            .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    // FIRE ZE MISSILES!
                                    //if (Constante.ID_LOCAL != null) {
                                    if (com.kruma.core.security.SecurityManager.getKey(Constante.SESSION_IDLOCAL) != null &&
                                            com.kruma.core.security.SecurityManager.getKey(Constante.SESSION_IDAPERTURAUSUARIO) != null) {

                                        com.kruma.kanta.logical.AperturaUsuario.Obtener(
                                                //Integer.parseInt(Constante.ID_LOCAL),
                                                com.kruma.core.security.SecurityManager.getKeyInteger(Constante.SESSION_IDLOCAL),
                                                //Constante.ID_APERTURA,
                                                com.kruma.core.security.SecurityManager.getKeyInteger(Constante.SESSION_IDAPERTURA),
                                                //Constante.ID_APERTURA_USUARIO,
                                                com.kruma.core.security.SecurityManager.getKeyInteger(Constante.SESSION_IDAPERTURAUSUARIO),
                                                //Constante.TXT_USUARIO_LOGEADO,
                                                com.kruma.core.security.SecurityManager.getUsuario(),
                                                new ProcessCallback<com.kruma.kanta.entidad.AperturaUsuario>() {
                                                    @Override
                                                    public void success(com.kruma.kanta.entidad.AperturaUsuario obj_pResultado) {

                                                        if (obj_pResultado != null) {
                                                            if (obj_pResultado.getAdministrador().equals(Constante.CONDICION_POSITIVO)) {

                                                                AdministradorAbandonar();


                                                            } else
                                                                UsuarioAbandonar();
                                                            //ModificarCancionesUsuario();
                                                        } else {
                                                            //session.logoutUser();
                                                            com.kruma.core.security.SecurityManager.CerrarSesion();
                                                            CerrarFacebook();
                                                            finish();
                                                            //Constante.ID_LOCAL = null;
                                                        }
                                                    }

                                                    @Override
                                                    public void failure(ProcessResult obj_pResultado) {
                                                        Toast.makeText(App.getContext(), "No puedes hacer ninguna acción", Toast.LENGTH_SHORT).show();
                                                    }
                                                });
                                    } else {
                                        //session.logoutUser();
                                        com.kruma.core.security.SecurityManager.CerrarSesion();
                                        CerrarFacebook();
                                        finish();
                                    }

                                    dialog.cancel();
                                }
                            })
                            .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    // User cancelled the dialog
                                    dialog.cancel();

                                }
                            });
                    // Create the AlertDialog object and return it
                    //return builder.create();
                    AlertDialog dialog = builder.create();
                    dialog.show();

                    break;
                //case R.id.nav_menu_apertura_mesa:
                //  ocultarBotones();
                //colorActivadoButton(btnAperturaMiMesa);
                //setFragmentMenu(Constante.FRAGMENT_APERTURA_MI_MESA);
                //break;
            }

            // Agregamos estas lineas para que el NavigationView se cierre después de que se eligió un item de su menu.
            DrawerLayout dl = (DrawerLayout) findViewById(R.id.drawerLayout);
            if (dl.isDrawerOpen(GravityCompat.START))
                dl.closeDrawer(GravityCompat.START);

            return false;
        }
    };


    /*
    private View.OnClickListener btnConsumoPerfilLlamarFragmentConsumoPerfil = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            setFragment(Constante.FRAGMENT_CONSUMO_PERFIL);
            colorActivadoButton(btnConsumoPerfil);
            colorDesactivadoButton(btnDatosPerfil);
            colorDesactivadoButton(btnCancionesPerfil);
        }
    };
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Pedir permisos para Geolocalizacion
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION,}, 1000);
        }

        //Validacion de la session
        bln_gSession = com.kruma.core.security.SecurityManager.ValidarSession();
        if (!bln_gSession) {
            finish();
            return;
        }

        Intent i = getIntent();
        ID_FIREBASE_MESSAGING = i.getStringExtra("ID_FIREBASE_MESSAGING");

        init();

    }

    private void init() {

        // Verificar si existe una sesion con FACEBOOK
        /*
        if (AccessToken.getCurrentAccessToken() == null) {
            goLoginScreen();
        }
        */

        //Revision de la sesión
        //session = new SessionManager(getApplicationContext());
        //session.checkLogin();

        // Reconocer el DrawerLayout del xml
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);

        // El ActionBarDrawerToggle toggle sirve para darle funcionalidad al Drawerlayout
        toggle = new android.support.v7.app.ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);

        // Adds the specified listener to the list of listeners that will be notified of drawer events.
        // Agrega el receptor especificado a la lista de oyentes que será notificada de los acontecimientos del cajón.
        drawerLayout.addDrawerListener(toggle);

        toggle.syncState();

        // Para hacer aparecer la opcion de tres lineas en la barra
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Reconocer el NavigationView del xml
        navigationView = (NavigationView) findViewById(R.id.navigationView);

        // Activamos el evento click del NavigationView
        navigationView.setNavigationItemSelectedListener(navigationItemSelectedListener);

        // Reconocer LinearLayout del xml
        linearLayoutBotones = (LinearLayout) findViewById(R.id.linearLayoutBotones);

        // Agregar propiedades al Layout
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        linearLayoutBotones.setOrientation(LinearLayout.HORIZONTAL);

        // Con esta linea lo que hacemos en que los botones tengan pesos o weight
        TableLayout.LayoutParams paramsButton = new TableLayout.LayoutParams(0, TableLayout.LayoutParams.WRAP_CONTENT, 1f);


        // ---------- Opcion INICIO ----------
        // Agregar Boton Ofertas
        btnOfertas = new Button(this);
        setButtons(btnOfertas, "OFERTAS", paramsButton);
        btnOfertas.setId(R.id.btnOfertas);

        // Agregar Boton Eventos
        btnEventos = new Button(this);
        setButtons(btnEventos, "EVENTOS", paramsButton);
        btnEventos.setId(R.id.btnEventos);

        // Agregar Boton tutorial
        btnTutorial = new Button(this);
        setButtons(btnTutorial, "TUTORIAL", paramsButton);
        btnTutorial.setId(R.id.btnTutorial);

        // ---------- Opcion CANCIONES ----------

        // Agregar Boton Ranking
        btnRanking = new Button(this);
        setButtons(btnRanking, "RANKING", paramsButton);
        btnRanking.setId(R.id.btnRanking);

        // Agregar Boton Novedades
        btnIngresos = new Button(this);
        setButtons(btnIngresos, "INGRESOS", paramsButton);
        btnIngresos.setId(R.id.btnIngresos);

        // Agregar Boton Novedades
        btnLista = new Button(this);
        setButtons(btnLista, "LISTA", paramsButton);
        btnLista.setId(R.id.btnLista);

        // ---------- Opcion NUEVA CANCION ----------

        // ---------- Opcion CARTA ----------
        /*
        // Agregar Boton Tragos
        btnTragos = new Button(this);
        setButtons(btnTragos, "TRAGOS", paramsButton);
        btnTragos.setId(R.id.btnTragos);

        // Agregar Boton Piqueos
        btnPiqueos = new Button(this);
        setButtons(btnPiqueos, "PIQUEOS", paramsButton);
        btnPiqueos.setId(R.id.btnPiqueos);
        */
        // ---------- Opcion TURNOS ----------

        // Agregar Boton Turno
        btnTurnos = new Button(this);
        setButtons(btnTurnos, "TURNOS", paramsButton);
        btnTurnos.setId(R.id.btnTurnos);

        // Agregar Boton Plano
        btnPlano = new Button(this);
        setButtons(btnPlano, "PLANO", paramsButton);
        btnPlano.setId(R.id.btnPlano);

        // ---------- Opcion MESAS ----------

        // Agregar Boton Mesas
        btnMesas = new Button(this);
        setButtons(btnMesas, "MESAS", paramsButton);
        btnMesas.setId(R.id.btnMesas);

        // Agregar Boton Consumo
        btnConsumo = new Button(this);
        setButtons(btnConsumo, "CONSUMO", paramsButton);
        btnConsumo.setId(R.id.btnConsumo);

        // ---------- Opcion MI PERFIL ----------
        // Agregar Boton DatosPerfil
        btnDatosPerfil = new Button(this);
        setButtons(btnDatosPerfil, "MIS DATOS", paramsButton);
        btnDatosPerfil.setId(R.id.btnDatosPerfil);

        // Agregar Boton CancionesPerfil
        btnCancionesPerfil = new Button(this);
        setButtons(btnCancionesPerfil, "MIS CANCIONES", paramsButton);
        btnCancionesPerfil.setId(R.id.btnCancionesPerfil);

        // Agregar Boton ConsumoPerfil
        /*
        btnConsumoPerfil = new Button(this);
        setButtons(btnConsumoPerfil, "CONSUMO", paramsButton);
        btnConsumoPerfil.setId(R.id.btnConsumoPerfil);
        */

        // ---------- Opcion MI MESA ----------

        // Agregar Boton UsuariosMesa
        btnUsuariosMesa = new Button(this);
        setButtons(btnUsuariosMesa, "USUARIOS", paramsButton);
        btnUsuariosMesa.setId(R.id.btnUsuariosMesa);

        // Agregar Boton MiListaCantadasMesa
        btnMiListaMesa = new Button(this);
        setButtons(btnMiListaMesa, "MI LISTA", paramsButton);
        btnMiListaMesa.setId(R.id.btnMiListaMesa);

        // Agregar Boton MiListaMesa
        btnMiListaCantadasMesa = new Button(this);
        setButtons(btnMiListaCantadasMesa, "CANTADAS", paramsButton);
        btnMiListaCantadasMesa.setId(R.id.btnMiListaCantadasMesa);

        //btnCerrarSession = (Button) findViewById(R.id.btnCerrarSession);

        btnCerrarSession = new Button(this);
        setButtons(btnCerrarSession, "CERRAR SESIÓN", paramsButton);
        btnCerrarSession.setId(R.id.btnCerrarSession);

        // ---------- Opcion KARAOKES ----------

        // Agregar Boton Ofertas Karaoke
        btnOfertasKaraokes = new Button(this);
        setButtons(btnOfertasKaraokes, "OFERTAS", paramsButton);
        btnOfertasKaraokes.setId(R.id.btnOfertasKaraoke);

        // Agregar Boton Eventos Karaoke
        btnEventosKaraokes = new Button(this);
        setButtons(btnEventosKaraokes, "EVENTOS", paramsButton);
        btnEventosKaraokes.setId(R.id.btnEventosKaraoke);

        // Agregar Boton Listar Canccion Karaoke
        btnListaCancionesKaraokes = new Button(this);
        setButtons(btnListaCancionesKaraokes, "CANCIONERO", paramsButton);
        btnListaCancionesKaraokes.setId(R.id.btnListarCancionKaraoke);


        // ---------- Opcion BUSCAR CANCION ----------

        // Agregar Boton Ofertas Karaoke
        btnBuscarCancion = new Button(this);
        setButtons(btnBuscarCancion, "OFERTAS", paramsButton);
        btnBuscarCancion.setId(R.id.btnBuscarCancion);
        //Apertura de mi mesa

        //btnAperturaMiMesa = new Button(this);
        //setButtons(btnAperturaMiMesa, "APERTURA DE MI MESA", paramsButton);
        //btnAperturaMiMesa.setId(R.id.btnAperturaMiMesa);


        // Agregar Boton ConsumoMesa
        /*
        btnConsumoMesa = new Button(this);
        setButtons(btnConsumoMesa, "CONSUMO", paramsButton);
        btnConsumoMesa.setId(R.id.btnConsumoMesa);
        */

        // Agregar el Button al LinearLayout
        // INICIO
        linearLayoutBotones.addView(btnOfertas);
        //linearLayoutBotones.addView(btnEventos);

        // Tutorial
        linearLayoutBotones.addView(btnTutorial);
        // CANCIONES
        linearLayoutBotones.addView(btnLista);
        linearLayoutBotones.addView(btnRanking);
        linearLayoutBotones.addView(btnIngresos);
        // NUEVA CANCION
        // CARTA
        //linearLayoutBotones.addView(btnTragos);
        //linearLayoutBotones.addView(btnPiqueos);
        //TURNOS
        linearLayoutBotones.addView(btnTurnos);
        linearLayoutBotones.addView(btnPlano);
        // MESAS
        linearLayoutBotones.addView(btnMesas);
        linearLayoutBotones.addView(btnConsumo);
        // MI PERFIL
        linearLayoutBotones.addView(btnDatosPerfil);
        linearLayoutBotones.addView(btnCancionesPerfil);
        //linearLayoutBotones.addView(btnConsumoPerfil);
        // MI MESA
        linearLayoutBotones.addView(btnUsuariosMesa);
        linearLayoutBotones.addView(btnMiListaMesa);
        linearLayoutBotones.addView(btnMiListaCantadasMesa);
        //linearLayoutBotones.addView(btnConsumoMesa);

        // KARAOKES
        linearLayoutBotones.addView(btnOfertasKaraokes);
        linearLayoutBotones.addView(btnEventosKaraokes);
        linearLayoutBotones.addView(btnListaCancionesKaraokes);

        // BUSCAR CANCION
        linearLayoutBotones.addView(btnBuscarCancion);


        // Activamos el fragment de inicio por defecto en la app
        // Y ponemos el Button Novedades en modo activo
        // Y ponemos el Button Ranking en modo inactivo
        if (ID_FIREBASE_MESSAGING != null) {
            if (ID_FIREBASE_MESSAGING.equals("1")) {
                setFragmentMenu(Constante.FRAGMENT_MI_MESA);
                ocultarBotones();

                mostrarBoton(btnUsuariosMesa);
                mostrarBoton(btnMiListaMesa);
                mostrarBoton(btnMiListaCantadasMesa);

                colorActivadoButton(btnUsuariosMesa);
                colorDesactivadoButton(btnMiListaMesa);
                colorDesactivadoButton(btnMiListaCantadasMesa);

            } else if (ID_FIREBASE_MESSAGING.equals("2")) {
                setFragmentMenu(Constante.FRAGMENT_CANCIONES);

                ocultarBotones();
                mostrarBoton(btnLista);
                mostrarBoton(btnRanking);
                mostrarBoton(btnIngresos);

                colorActivadoButton(btnLista);
                colorDesactivadoButton(btnRanking);
                colorDesactivadoButton(btnIngresos);


            } else if (ID_FIREBASE_MESSAGING.equals("3")) {
                setFragmentMenu(Constante.FRAGMENT_CANCIONES);

                ocultarBotones();
                mostrarBoton(btnLista);
                mostrarBoton(btnRanking);
                mostrarBoton(btnIngresos);

                colorActivadoButton(btnLista);
                colorDesactivadoButton(btnRanking);
                colorDesactivadoButton(btnIngresos);

            } else if (ID_FIREBASE_MESSAGING.equals("4")) {
                setFragment(Constante.FRAGMENT_MI_LISTA_MESA);
                ocultarBotones();

                mostrarBoton(btnUsuariosMesa);
                mostrarBoton(btnMiListaMesa);
                mostrarBoton(btnMiListaCantadasMesa);

                colorDesactivadoButton(btnUsuariosMesa);
                colorActivadoButton(btnMiListaMesa);
                colorDesactivadoButton(btnMiListaCantadasMesa);

            } else {
                setFragmentMenu(Constante.FRAGMENT_INICIO);
                ocultarBotones();
                mostrarBoton(btnEventos);
                colorDesactivadoButton(btnEventos);
            }
        } else {
            setFragmentMenu(Constante.FRAGMENT_INICIO);
            ocultarBotones();
            mostrarBoton(btnEventos);
            colorDesactivadoButton(btnEventos);
        }

        // ----- INICIO -----
        // Activamos el evento click del Button Ofertas para llamar al Fragment Ofertas
        btnOfertas.setOnClickListener(btnOfertasLlamarFragmentOfertas);
        // Activamos el evento click del Button Eventos para llamar al Fragment Eventos
        btnEventos.setOnClickListener(btnEventosLlamarFragmentEventos);

        // ----- TUTORIAL -----
        // Activamos el evento click del Button Ofertas para llamar al Fragment Ofertas

        btnTutorial.setOnClickListener(btnTutorialLlamarFragmentTutorial);

        // ----- CANCIONES -----
        // Activamos el evento click del Button Novedades para llamar al Fragment Lista
        btnLista.setOnClickListener(btnListaLlamarFragmentLista);
        // Activamos el evento click del Button Novedades para llamar al Fragment Ranking
        btnRanking.setOnClickListener(btnRankingLlamarFragmentRanking);
        // Activamos el evento click del Button Novedades para llamar al Fragment Novedades
        btnIngresos.setOnClickListener(btnIngresosLlamarFragmentIngresos);


        // ----- NUEVA CANCION -----

        // ----- CARTA -----
        // Activamos el evento click del Button Tragos para llamar al Fragment Tragos
        //btnTragos.setOnClickListener(btnTragosLlamarFragmentTragos);
        // Activamos el evento click del Button Piqueos para llamar al Fragment Piqueos
        //btnPiqueos.setOnClickListener(btnPiqueosLlamarFragmentPiqueos);

        // ----- TURNOS -----
        // Activamos el evento click del Button Turno para llamar al Fragment Turno
        btnTurnos.setOnClickListener(btnTurnosLlamarFragmentTurnos);
        // Activamos el evento click del Button Plano para llamar al Fragment Plano
        btnPlano.setOnClickListener(btnPlanoLlamarFragmentPlano);

        // ----- MESAS -----
        // Activamos el evento click del Button Mesas para llamar al Fragment Mesas
        btnMesas.setOnClickListener(btnMesasLlamarFragmentMesas);
        // Activamos el evento click del Button Consumo para llamar al Fragment Consumo
        btnConsumo.setOnClickListener(btnConsumoLlamarFragmentConsumo);


        // ----- KARAOKES -----
        // Activamos el evento click del Button Ofertas para llamar al Fragment Lista
        btnOfertasKaraokes.setOnClickListener(btnOfertasKaraokesLlamarFragmentOfertasKaraokes);
        // Activamos el evento click del Button Eventos para llamar al Fragment Ranking
        btnEventosKaraokes.setOnClickListener(btnEventosKaraokesLlamarFragmentEventosKaraokes);
        // Activamos el evento click del Button Novedades para llamar al Fragment Novedades
        btnListaCancionesKaraokes.setOnClickListener(btnListaCancionesKaraokesLlamarFragmentLitaCancionesKaraokes);

        // ----- MI PERFIL -----
        // Activamos el evento click del Button Datos para llamar al Fragment Datos
        btnBuscarCancion.setOnClickListener(btnBuscarCancionLlamarFragmentBuscarCancion);


        // ----- MI PERFIL -----
        // Activamos el evento click del Button Datos para llamar al Fragment Datos
        btnDatosPerfil.setOnClickListener(btnDatosPerfilLlamarFragmentDatosPerfil);
        // Activamos el evento click del Button Canciones para llamar al Fragment Canciones
        btnCancionesPerfil.setOnClickListener(btnCancionesPerfilLlamarFragmentCancionesPerfil);
        // Activamos el evento click del Button Consumo para llamar al Fragment Consumo
        //btnConsumoPerfil.setOnClickListener(btnConsumoPerfilLlamarFragmentConsumoPerfil);

        // ----- MI MESA -----
        // Activamos el evento click del Button Datos para llamar al Fragment Datos
        btnUsuariosMesa.setOnClickListener(btnUsuariosMesaLlamarFragmentUsuarioMesa);
        // Activamos el evento click del Button Canciones para llamar al Fragment Canciones
        btnMiListaMesa.setOnClickListener(btnMiListaMesaLlamarFragmentMiListaMesa);
        // Activamos el evento click del Button Canciones para llamar al Fragment Canciones
        btnMiListaCantadasMesa.setOnClickListener(btnMiListaMesaCantadasLlamarFragmentMiListaCantadasMesa);
        // Activamos el evento click del Button Consumo para llamar al Fragment Consumo
        //btnConsumoMesa.setOnClickListener(btnConsumoMesaLlamarFragmentConsumoMesa);

        //Cerrar Session
        btnCerrarSession.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // Clear the session data
                // This will clear all session data and
                // redirect user to LoginActivity
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                builder.setMessage("¿Desea cerrar sesión?")
                        .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // FIRE ZE MISSILES!
                                //if (Constante.ID_LOCAL != null) {
                                if (com.kruma.core.security.SecurityManager.getKey(Constante.SESSION_IDLOCAL) != null) {
                                    com.kruma.kanta.logical.AperturaUsuario.Obtener(
                                            //Integer.parseInt(Constante.ID_LOCAL),
                                            com.kruma.core.security.SecurityManager.getKeyInteger(Constante.SESSION_IDLOCAL),
                                            //Constante.ID_APERTURA,
                                            com.kruma.core.security.SecurityManager.getKeyInteger(Constante.SESSION_IDAPERTURA),
                                            //Constante.ID_APERTURA_USUARIO,
                                            com.kruma.core.security.SecurityManager.getKeyInteger(Constante.SESSION_IDAPERTURAUSUARIO),
                                            //Constante.TXT_USUARIO_LOGEADO,
                                            com.kruma.core.security.SecurityManager.getUsuario(),
                                            new ProcessCallback<com.kruma.kanta.entidad.AperturaUsuario>() {
                                                @Override
                                                public void success(com.kruma.kanta.entidad.AperturaUsuario obj_pResultado) {

                                                    if (obj_pResultado != null) {
                                                        if (obj_pResultado.getAdministrador().equals(Constante.CONDICION_POSITIVO)) {
                                                            AdministradorAbandonar();
                                                            //CantidadUsuarios();
                                                        } else
                                                            UsuarioAbandonar();
                                                        //ModificarCancionesUsuario();
                                                    } else {
                                                        //session.logoutUser();
                                                        com.kruma.core.security.SecurityManager.CerrarSesion();
                                                        CerrarFacebook();
                                                        finish();
                                                    }
                                                }

                                                @Override
                                                public void failure(ProcessResult obj_pResultado) {
                                                    Toast.makeText(App.getContext(), "No puedes hacer ninguna acción", Toast.LENGTH_SHORT).show();
                                                }
                                            });
                                } else {
                                    //session.logoutUser();
                                    com.kruma.core.security.SecurityManager.CerrarSesion();
                                    CerrarFacebook();
                                    finish();
                                }

                                dialog.cancel();
                            }
                        })
                        .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // User cancelled the dialog
                                dialog.cancel();

                            }
                        });
                // Create the AlertDialog object and return it
                //return builder.create();

                AlertDialog dialog = builder.create();
                dialog.show();


            }
        });


    }

    // Método de FACEBOOK
    private void goLoginScreen() {

        Intent intent = new Intent(this, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    public void CerrarFacebook() {
        if (AccessToken.getCurrentAccessToken() != null) {
            LoginManager.getInstance().logOut();
        }
    }
    /*
    private View.OnClickListener btnConsumoMesaLlamarFragmentConsumoMesa = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            setFragment(Constante.FRAGMENT_CONSUMO_MESA);
            colorActivadoButton(btnConsumoMesa);
            colorDesactivadoButton(btnMiListaMesa);
            colorDesactivadoButton(btnUsuariosMesa);
        }
    };
    */

    //endregion

    // Método de FACEBOOK
    public void logout(View view) {
        LoginManager.getInstance().logOut();
        goLoginScreen();
    }

    // Método para ocultar botones
    public void ocultarBotones() {
        // INICIO
        btnOfertas.setVisibility(View.GONE);
        //btnEventos.setVisibility(View.GONE);
        //TUTORIAL

        btnTutorial.setVisibility(View.GONE);

        // CANCIONES
        btnLista.setVisibility(View.GONE);
        btnRanking.setVisibility(View.GONE);
        btnIngresos.setVisibility(View.GONE);
        // NUEVA CANCION
        // CARTA
        //btnTragos.setVisibility(View.GONE);
        //btnPiqueos.setVisibility(View.GONE);
        // TURNOS
        btnTurnos.setVisibility(View.GONE);
        btnPlano.setVisibility(View.GONE);
        // MESAS
        btnMesas.setVisibility(View.GONE);
        btnConsumo.setVisibility(View.GONE);
        // KARAOKES
        btnOfertasKaraokes.setVisibility(View.GONE);
        btnEventosKaraokes.setVisibility(View.GONE);
        btnListaCancionesKaraokes.setVisibility(View.GONE);
        // BUSCAR CANCION
        btnBuscarCancion.setVisibility(View.GONE);
        // MI PERFIL
        btnDatosPerfil.setVisibility(View.GONE);
        btnCancionesPerfil.setVisibility(View.GONE);
        //btnConsumoPerfil.setVisibility(View.GONE);
        // MI MESA
        btnUsuariosMesa.setVisibility(View.GONE);
        btnMiListaMesa.setVisibility(View.GONE);
        btnMiListaCantadasMesa.setVisibility(View.GONE);
        //btnConsumoMesa.setVisibility(View.GONE);

    }

    // Método para mostrar boton
    public void mostrarBoton(Button btnButton) {
        btnButton.setVisibility(View.VISIBLE);
    }

    // Método para setear valores del los botonoes
    public void setButtons(Button btnButton, String nameButton, TableLayout.LayoutParams paramsButton) {
        btnButton.setText(nameButton);
        btnButton.setLayoutParams(paramsButton);
        //btnButton.setTextAppearance(R.style.ButtonFontStyleMedium);
        btnButton.setTypeface(null, Typeface.BOLD);
        btnButton.setBackgroundResource(R.drawable.mybuttonregister);
    }

    public void colorActivadoButton(Button button) {
        button.setTextColor(getApplication().getResources().getColor(R.color.selectedState));
    }

    public void colorDesactivadoButton(Button button) {
        button.setTextColor(getApplication().getResources().getColor(R.color.unselectedState));
    }

    // Para que las tres barras tengan funcionalidad
    // Si le da click a las tres lineas entonces el NavigationView se mostrará
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.canciones_genero:
                FragmentManager fmGenero = getSupportFragmentManager();
                CancionesGeneroDialogFragment cancionesGeneroDialogFragment = CancionesGeneroDialogFragment.newInstance("Elegir género");
                cancionesGeneroDialogFragment.show(fmGenero, "dialog_fragment_canciones_genero");
                break;

            case R.id.canciones_idioma:
                FragmentManager fmIdioma = getSupportFragmentManager();
                CancionesIdiomaDialogFragment cancionesIdiomaDialogFragment = CancionesIdiomaDialogFragment.newInstance("Elegir idioma");
                cancionesIdiomaDialogFragment.show(fmIdioma, "dialog_fragment_canciones_idioma");
                break;

            case R.id.carta_tipo:
                FragmentManager fmTipo = getSupportFragmentManager();
                CartaTipoDialogFragment cartaTipoDialogFragment = CartaTipoDialogFragment.newInstance("Elegir tipo");
                cartaTipoDialogFragment.show(fmTipo, "dialog_fragment_carta_tipo");
                break;

            case R.id.karaoke_pais:
                FragmentManager fmPais = getSupportFragmentManager();
                KaraokesPaisDialogFragment karaokesPaisDialogFragment = KaraokesPaisDialogFragment.newInstance("Elegir pais");
                karaokesPaisDialogFragment.show(fmPais, "dialog_fragment_karaokes_pais");
                break;
        }

        if (toggle.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);

    }

    // Para llamadas a Fragments desde el Menu
    public void setFragmentMenu(int position) {
        FragmentManager fragmentManager;
        FragmentTransaction fragmentTransaction;
        switch (position) {

            case Constante.FRAGMENT_INICIO:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                OfertasFragment ofertasFragment = new OfertasFragment();
                fragmentTransaction.replace(R.id.flFragment, ofertasFragment);
                fragmentTransaction.commit();
                break;

            case Constante.FRAGMENT_TUTORIAL:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                TutorialFragment tutorialFragment = new TutorialFragment();
                fragmentTransaction.replace(R.id.flFragment, tutorialFragment);
                fragmentTransaction.commit();
                break;

            case Constante.FRAGMENT_CANCIONES:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                ListaFragment listaFragment = new ListaFragment();
                fragmentTransaction.replace(R.id.flFragment, listaFragment);
                fragmentTransaction.commit();
                break;

            case Constante.FRAGMENT_NUEVA_CANCION:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                NuevaCancionFragment nuevaCancionFragment = new NuevaCancionFragment();
                fragmentTransaction.replace(R.id.flFragment, nuevaCancionFragment);
                fragmentTransaction.commit();
                break;

            case Constante.FRAGMENT_CARTA:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                TragosFragment tragosFragment = new TragosFragment();
                fragmentTransaction.replace(R.id.flFragment, tragosFragment);
                fragmentTransaction.commit();
                break;

            case Constante.FRAGMENT_TURNOS_NAV:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                TurnosFragment turnosFragment = new TurnosFragment();
                fragmentTransaction.replace(R.id.flFragment, turnosFragment);
                fragmentTransaction.commit();
                break;

            case Constante.FRAGMENT_MESAS_NAV:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                MesasFragment mesasFragment = new MesasFragment();
                fragmentTransaction.replace(R.id.flFragment, mesasFragment);
                fragmentTransaction.commit();
                break;

            //KARAOOOOKES
            case Constante.FRAGMENT_KARAOKES:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                KaraokesFragment karaokesFragment = new KaraokesFragment();
                fragmentTransaction.replace(R.id.flFragment, karaokesFragment);
                fragmentTransaction.commit();
                break;
            case Constante.FRAGMENT_BUSCAR_CANCION:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                BuscarCancionFragment buscarCancionFragment = new BuscarCancionFragment();
                fragmentTransaction.replace(R.id.flFragment, buscarCancionFragment);
                fragmentTransaction.commit();
                break;

            case Constante.FRAGMENT_MI_PERFIL:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                DatosPerfilFragment datosPerfilFragment = new DatosPerfilFragment();
                fragmentTransaction.replace(R.id.flFragment, datosPerfilFragment);
                fragmentTransaction.commit();
                break;

            case Constante.FRAGMENT_MI_MESA:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                UsuariosMesaFragment usuariosMesaFragment = new UsuariosMesaFragment();
                fragmentTransaction.replace(R.id.flFragment, usuariosMesaFragment);
                fragmentTransaction.commit();
                break;

            //Apertura de mi mesa
            //case Constante.FRAGMENT_APERTURA_MI_MESA:
            //  Intent in= new Intent(this, ScanActivity.class);
            //startActivity(in);
            //break;
        }
    }

    // Para llamadas a Fragments desde la Activity
    public void setFragment(int position) {
        FragmentManager fragmentManager;
        FragmentTransaction fragmentTransaction;
        switch (position) {
            // INICIO
            case Constante.FRAGMENT_OFERTAS:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                OfertasFragment ofertasFragment = new OfertasFragment();
                fragmentTransaction.replace(R.id.flFragment, ofertasFragment);
                fragmentTransaction.commit();
                break;
            case Constante.FRAGMENT_EVENTOS:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                EventosFragment eventosFragment = new EventosFragment();
                fragmentTransaction.replace(R.id.flFragment, eventosFragment);
                fragmentTransaction.commit();
                break;
            //TUTORIAL
            case Constante.FRAGMENT_TUTORIAL_F:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                TutorialFragment tutorialFragment = new TutorialFragment();
                fragmentTransaction.replace(R.id.flFragment, tutorialFragment);
                fragmentTransaction.commit();
                break;
            // CANCIONES
            case Constante.FRAGMENT_LISTA:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                ListaFragment listaFragment = new ListaFragment();
                fragmentTransaction.replace(R.id.flFragment, listaFragment);
                fragmentTransaction.commit();
                break;
            case Constante.FRAGMENT_RANKING:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                RankingFragment rankingFragment = new RankingFragment();
                fragmentTransaction.replace(R.id.flFragment, rankingFragment);
                fragmentTransaction.commit();
                break;
            case Constante.FRAGMENT_INGRESOS:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                IngresosFragment ingresosFragment = new IngresosFragment();
                fragmentTransaction.replace(R.id.flFragment, ingresosFragment);
                fragmentTransaction.commit();
                break;
            // NUEVA CANCION
            // CARTA
            case Constante.FRAGMENT_TRAGOS:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                TragosFragment tragosFragment = new TragosFragment();
                fragmentTransaction.replace(R.id.flFragment, tragosFragment);
                fragmentTransaction.commit();
                break;
            /*
            case Constante.FRAGMENT_PIQUEOS:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                PiqueosFragment piqueosFragment = new PiqueosFragment();
                fragmentTransaction.replace(R.id.flFragment, piqueosFragment);
                fragmentTransaction.commit();
                break;
            */
            // TURNOS
            case Constante.FRAGMENT_TURNOS_ACT:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                TurnosFragment turnosFragment = new TurnosFragment();
                fragmentTransaction.replace(R.id.flFragment, turnosFragment);
                fragmentTransaction.commit();
                break;
            case Constante.FRAGMENT_PLANO:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                PlanoFragment planoFragment = new PlanoFragment();
                fragmentTransaction.replace(R.id.flFragment, planoFragment);
                fragmentTransaction.commit();
                break;
            // MESAS
            case Constante.FRAGMENT_MESAS_ACT:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                MesasFragment mesasFragment = new MesasFragment();
                fragmentTransaction.replace(R.id.flFragment, mesasFragment);
                fragmentTransaction.commit();
                break;

            case Constante.FRAGMENT_CONSUMO:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                ConsumoFragment consumoFragment = new ConsumoFragment();
                fragmentTransaction.replace(R.id.flFragment, consumoFragment);
                fragmentTransaction.commit();
                break;
            // KARAOKES
            case Constante.FRAGMENT_KARAOES_F:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                KaraokesFragment karaokesFragment = new KaraokesFragment();
                fragmentTransaction.replace(R.id.flFragment, karaokesFragment);
                fragmentTransaction.commit();
                break;
            /*
            case Constante.FRAGMENT_EVENTOS_KARAOKES:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                EventoKaraokeFragment eventoKaraokeFragment = new EventoKaraokeFragment();
                fragmentTransaction.replace(R.id.flFragment, eventoKaraokeFragment);
                fragmentTransaction.commit();
                break;

            case Constante.FRAGMENT_LISTACANCIONES_KARAOKES:

                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                ListarCancionKaraokeFragment listarCancionKaraokeFragment = new ListarCancionKaraokeFragment();
                fragmentTransaction.replace(R.id.flFragment, listarCancionKaraokeFragment);
                fragmentTransaction.commit();
                break;
*/
            // BUSCAR CANCIOON
            case Constante.FRAGMENT_BUSCAR_CANCION_F:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                BuscarCancionFragment buscarCancionFragment = new BuscarCancionFragment();
                fragmentTransaction.replace(R.id.flFragment, buscarCancionFragment);
                fragmentTransaction.commit();
                break;

            // MI PERFIL
            case Constante.FRAGMENT_DATOS_PERFIL:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                DatosPerfilFragment datosPerfilFragment = new DatosPerfilFragment();
                fragmentTransaction.replace(R.id.flFragment, datosPerfilFragment);
                fragmentTransaction.commit();
                break;

            case Constante.FRAGMENT_CANCIONES_PERFIL:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                CancionesPerfilFragment cancionesPerfilFragment = new CancionesPerfilFragment();
                fragmentTransaction.replace(R.id.flFragment, cancionesPerfilFragment);
                fragmentTransaction.commit();
                break;

            case Constante.FRAGMENT_CONSUMO_PERFIL:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                ConsumoPerfilFragment consumoPerfilFragment = new ConsumoPerfilFragment();
                fragmentTransaction.replace(R.id.flFragment, consumoPerfilFragment);
                fragmentTransaction.commit();
                break;

            // MI MESA
            case Constante.FRAGMENT_USUARIOS_MESA:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                UsuariosMesaFragment usuariosMesaFragment = new UsuariosMesaFragment();
                fragmentTransaction.replace(R.id.flFragment, usuariosMesaFragment);
                fragmentTransaction.commit();
                break;

            case Constante.FRAGMENT_MI_LISTA_MESA:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                MiListaMesaFragment miListaMesaFragment = new MiListaMesaFragment();
                fragmentTransaction.replace(R.id.flFragment, miListaMesaFragment);
                fragmentTransaction.commit();
                break;

            case Constante.FRAGMENT_MI_LISTA_CANTADAS_MESA:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                MiListaMesaCantadasFragment miListaMesaCantadasFragment = new MiListaMesaCantadasFragment();
                fragmentTransaction.replace(R.id.flFragment, miListaMesaCantadasFragment);
                fragmentTransaction.commit();
                break;

            case Constante.FRAGMENT_CONSUMO_MESA:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                ConsumoMesaFragment consumoMesaFragment = new ConsumoMesaFragment();
                fragmentTransaction.replace(R.id.flFragment, consumoMesaFragment);
                fragmentTransaction.commit();
                break;
        }
    }

    private void UsuarioAbandonar() {
        try {
            com.kruma.kanta.entidad.AperturaUsuario obj_AperturaUsuario = new com.kruma.kanta.entidad.AperturaUsuario();
            //obj_AperturaUsuario.setIdLocal(Integer.parseInt(Constante.ID_LOCAL));
            obj_AperturaUsuario.setIdLocal(com.kruma.core.security.SecurityManager.getKeyInteger(Constante.SESSION_IDLOCAL));
            //obj_AperturaUsuario.setIdApertura(Constante.ID_APERTURA);
            obj_AperturaUsuario.setIdApertura(com.kruma.core.security.SecurityManager.getKeyInteger(Constante.SESSION_IDAPERTURA));
            //obj_AperturaUsuario.setIdAperturaUsuario(Constante.ID_APERTURA_USUARIO);
            obj_AperturaUsuario.setIdAperturaUsuario(com.kruma.core.security.SecurityManager.getKeyInteger(Constante.SESSION_IDAPERTURAUSUARIO));
            //obj_AperturaUsuario.setIdUsuario(Constante.TXT_USUARIO_LOGEADO);
            obj_AperturaUsuario.setIdUsuario(com.kruma.core.security.SecurityManager.getUsuario());
            obj_AperturaUsuario.setAdministrador(Constante.CONDICION_NEGATIVO);
            obj_AperturaUsuario.setEstado(Constante.ESTADO_INACTIVO);
            //obj_AperturaUsuario.setUsuarioModificacion(Constante.TXT_USUARIO_LOGEADO);
            obj_AperturaUsuario.setUsuarioModificacion(com.kruma.core.security.SecurityManager.getUsuario());

            // Se realiza la inserción del usuario
            com.kruma.kanta.logical.AperturaUsuario.Modificar(
                    obj_AperturaUsuario,
                    new ProcessCallback<ProcessResult>() {
                        @Override
                        public void success(ProcessResult obj_pResultado) {
                            Toast.makeText(App.getContext(), "Usted dejo de ser usuario de esta mesa", Toast.LENGTH_LONG).show();
                            //Constante.ID_LOCAL = null;
                            //session.logoutUser();
                            com.kruma.core.security.SecurityManager.CerrarSesion();
                            CerrarFacebook();
                            finish();
                            //Intent intent = new Intent(App.getContext(), MainActivity.class);
                            //intent.putExtra("Logeado", Constante.TXT_USUARIO_LOGEADO);
                            //startActivity(intent);
                        }

                        @Override
                        public void failure(ProcessResult obj_pResultado) {
                            Toast.makeText(App.getContext(), obj_pResultado.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });

        } catch (Exception ex) {
            Toast.makeText(App.getContext(), ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void AdministradorAbandonar() {
        try {
            com.kruma.kanta.entidad.AperturaUsuario obj_AperturaUsuario = new com.kruma.kanta.entidad.AperturaUsuario();

            //obj_AperturaUsuario.setIdLocal(Integer.parseInt(Constante.ID_LOCAL));
            obj_AperturaUsuario.setIdLocal(com.kruma.core.security.SecurityManager.getKeyInteger(Constante.SESSION_IDLOCAL));
            //obj_AperturaUsuario.setIdApertura(Constante.ID_APERTURA);
            obj_AperturaUsuario.setIdApertura(com.kruma.core.security.SecurityManager.getKeyInteger(Constante.SESSION_IDAPERTURA));
            //obj_AperturaUsuario.setIdAperturaUsuario(Constante.ID_APERTURA_USUARIO);
            obj_AperturaUsuario.setIdAperturaUsuario(com.kruma.core.security.SecurityManager.getKeyInteger(Constante.SESSION_IDAPERTURAUSUARIO));
            //obj_AperturaUsuario.setIdUsuario(Constante.TXT_USUARIO_LOGEADO);
            obj_AperturaUsuario.setIdUsuario(com.kruma.core.security.SecurityManager.getUsuario());
            obj_AperturaUsuario.setAdministrador(Constante.CONDICION_NEGATIVO);
            obj_AperturaUsuario.setEstado(Constante.ESTADO_INACTIVO);
            //obj_AperturaUsuario.setUsuarioModificacion(Constante.TXT_USUARIO_LOGEADO);
            obj_AperturaUsuario.setUsuarioModificacion(com.kruma.core.security.SecurityManager.getUsuario());

            // Se realiza la inserción del usuario
            com.kruma.kanta.logical.AperturaUsuario.Modificar(
                    obj_AperturaUsuario,
                    new ProcessCallback<ProcessResult>() {

                        @Override
                        public void success(ProcessResult obj_pResultado) {

                            Toast.makeText(App.getContext(), "Usted dejo de ser administrador de esta mesa", Toast.LENGTH_LONG).show();
                            //*Constante.ID_LOCAL = null;
                            //session.logoutUser();
                            com.kruma.core.security.SecurityManager.CerrarSesion();
                            CerrarFacebook();
                            finish();
                        }

                        @Override
                        public void failure(ProcessResult obj_pResultado) {
                            Toast.makeText(App.getContext(), obj_pResultado.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });

        } catch (Exception ex) {
            Toast.makeText(App.getContext(), ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void CerrarApertura() {
        try {
            com.kruma.kanta.entidad.Apertura obj_Apertura = new com.kruma.kanta.entidad.Apertura();

            //obj_Apertura.setIdLocal(Integer.parseInt(Constante.ID_LOCAL));
            obj_Apertura.setIdLocal(com.kruma.core.security.SecurityManager.getKeyInteger(Constante.SESSION_IDLOCAL));
            //obj_Apertura.setIdApertura(Constante.ID_APERTURA);
            obj_Apertura.setIdApertura(com.kruma.core.security.SecurityManager.getKeyInteger(Constante.SESSION_IDAPERTURA));
            //obj_Apertura.setUsuarioModificacion(Constante.TXT_USUARIO_LOGEADO);
            obj_Apertura.setUsuarioModificacion(com.kruma.core.security.SecurityManager.getUsuario());

            // Se realiza la inserción del usuario
            com.kruma.kanta.logical.Apertura.Cerrar(
                    obj_Apertura,
                    new ProcessCallback<ProcessResult>() {
                        @Override
                        public void success(ProcessResult obj_pResultado) {
                            Toast.makeText(App.getContext(), "Se Realizo correctamente, Usted dejo de ser Administrador de esta mesa", Toast.LENGTH_LONG).show();
                            //*Constante.ID_LOCAL = null;
                            //session.logoutUser();
                            com.kruma.core.security.SecurityManager.CerrarSesion();
                            CerrarFacebook();
                            finish();
                        }

                        @Override
                        public void failure(ProcessResult obj_pResultado) {
                            Toast.makeText(App.getContext(), obj_pResultado.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });

        } catch (Exception ex) {
            Toast.makeText(App.getContext(), ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
/*
    private void CantidadUsuarios() {

        com.kruma.kantape.logical.AperturaUsuario.ListarAperturaUsuario(Integer.parseInt(Constante.ID_LOCAL), Constante.ID_APERTURA,
                new ProcessCallback<List<AperturaUsuario>>(){

                    @Override
                    public void success(List<com.kruma.kantape.entidad.AperturaUsuario> obj_pResultado) {
                        if(obj_pResultado.getTotal() == 1){
                            AdministradorAbandonar();
                            ModificarCancionesUsuario();
                        } else
                            //DEJAR DE SER ADMINISTRADOR Y DEJAR A OTRO
                            AdministradorAbandonar();

                    }

                    @Override
                    public void failure(ProcessResult obj_pResultado) {

                    }
                });
    }
*/


    private void ModificarCancionesUsuario() {
        try {
            com.kruma.kanta.entidad.AperturaCancion obj_AperturaCancion = new com.kruma.kanta.entidad.AperturaCancion();

            //obj_AperturaCancion.setIdLocal(Integer.parseInt(Constante.ID_LOCAL));
            obj_AperturaCancion.setIdLocal(com.kruma.core.security.SecurityManager.getKeyInteger(Constante.SESSION_IDLOCAL));
            //obj_AperturaCancion.setIdApertura(Constante.ID_APERTURA);
            obj_AperturaCancion.setIdApertura(com.kruma.core.security.SecurityManager.getKeyInteger(Constante.SESSION_IDAPERTURA));
            //obj_AperturaCancion.setIdUsuario(Constante.TXT_USUARIO_LOGEADO);
            obj_AperturaCancion.setIdUsuario(com.kruma.core.security.SecurityManager.getUsuario());


            // Se realiza la inserción del usuario
            com.kruma.kanta.logical.AperturaUsuario.ModificarAperturaCancion(
                    obj_AperturaCancion,
                    new ProcessCallback<ProcessResult>() {

                        @Override
                        public void success(ProcessResult obj_pResultado) {

                            Toast.makeText(App.getContext(), "Se inactivaron sus canciones pedidas", Toast.LENGTH_LONG).show();
                        }

                        @Override
                        public void failure(ProcessResult obj_pResultado) {
                            //Toast.makeText(App.getContext(), obj_pResultado.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });

        } catch (Exception ex) {
            Toast.makeText(App.getContext(), ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        //Validacion de session - PATCH
        if (!bln_gSession) {
            return false;
        }

        Menu nav_Menu = navigationView.getMenu();

        getMenuInflater().inflate(R.menu.main_menu, menu);
        getMenuInflater().inflate(R.menu.canciones_menu, menu);

        //Search
        searchItem = menu.findItem(R.id.menu_search);

        searchView = (SearchView) menu.findItem(R.id.menu_search).getActionView();
        SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setSubmitButtonEnabled(true);
        searchView.setOnQueryTextListener(this);

        //Filtros de Busqueda
        optionGenero = menu.findItem(R.id.canciones_genero);
        optionIdioma = menu.findItem(R.id.canciones_idioma);
        optionTipo = menu.findItem(R.id.carta_tipo);
        optionPais = menu.findItem(R.id.karaoke_pais);

        searchItem.setVisible(false);
        optionGenero.setVisible(false);
        optionIdioma.setVisible(false);
        optionTipo.setVisible(false);
        optionPais.setVisible(false);

        txtMiUsuarioLogin = (TextView) findViewById(R.id.txtMiUsuarioLogin);

        if (AccessToken.getCurrentAccessToken() != null) {
            Profile profile = Profile.getCurrentProfile();
            if (profile != null) {
                DatosFacebook(profile);
            }
        } else {
            txtMiUsuarioLogin.setText(com.kruma.core.security.SecurityManager.getUsuario());
        }


        //TODO condicion a corregir
        // if(Constante.FLAG_MOZO == null)
        //Constante.FLAG_MOZO = Flag_Mozo;

        //nav_Menu.findItem(R.id.nav_menu_buscar_cancion).setVisible(false);

        if (com.kruma.core.security.SecurityManager.getKey(Constante.SESSION_FLAGMOZO) != null &&
                com.kruma.core.security.SecurityManager.getKey(Constante.SESSION_IDLOCAL) == null)

            //if (Constante.FLAG_MOZO.equals("S")) {
            if (com.kruma.core.security.SecurityManager.getKey(Constante.SESSION_FLAGMOZO).equals("S")) {
                nav_Menu.findItem(R.id.nav_menu_nueva_cancion).setVisible(false);
                nav_Menu.findItem(R.id.nav_menu_mi_mesa).setVisible(false);
                nav_Menu.findItem(R.id.nav_menu_canciones).setVisible(false);

            } else {

                //INICIO
                nav_Menu.findItem(R.id.nav_menu_tutorial).setVisible(false);
                nav_Menu.findItem(R.id.nav_menu_canciones).setVisible(false);
                nav_Menu.findItem(R.id.nav_menu_nueva_cancion).setVisible(false);
                nav_Menu.findItem(R.id.nav_menu_carta).setVisible(false);
                nav_Menu.findItem(R.id.nav_menu_mi_mesa).setVisible(false);
                nav_Menu.findItem(R.id.nav_menu_turnos).setVisible(false);
            }

        //if (Constante.FLAG_MOZO != null && Constante.ID_LOCAL != null) {
        if (com.kruma.core.security.SecurityManager.getKey(Constante.SESSION_FLAGMOZO) != null &&
                com.kruma.core.security.SecurityManager.getKey(Constante.SESSION_IDLOCAL) != null) {
            nav_Menu.findItem(R.id.nav_menu_turnos).setVisible(false);
            nav_Menu.findItem(R.id.nav_menu_nueva_cancion).setVisible(false);
        }

        return super.onCreateOptionsMenu(menu);
    }

    private void DatosFacebook(Profile perfil) {
        if (perfil != null) {
            txtMiUsuarioLogin.setText(perfil.getName());
        }
    }

    @Override
    public void showMessageFragment(String message, String fragmentName) {
    }

    //region SearchView
    @Override
    public boolean onQueryTextSubmit(String query) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment currentFragment = fragmentManager.findFragmentById(R.id.flFragment);
        if (currentFragment instanceof BuscarCancionFragment) {
            BuscarCancionFragment.ListarCancionesPorFiltro(Constante.ID_GENERO, Constante.ID_IDIOMA, query);
        }
        if (currentFragment instanceof KaraokesFragment) {
            KaraokesFragment.ListarKaraoke(Constante.ID_PAIS, query);
        }
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        if (searchView.getQuery().length() == 0) {
            onQueryTextSubmit(null);
        }
        return false;
    }
    //endregion
}
