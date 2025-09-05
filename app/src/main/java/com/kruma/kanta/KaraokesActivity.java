package com.kruma.kanta;

import android.app.SearchManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.Profile;
import com.kruma.kanta.entidad.Constante;
import com.kruma.kanta.view.fragments.CancionesGeneroDialogFragment;
import com.kruma.kanta.view.fragments.CancionesIdiomaDialogFragment;
import com.kruma.kanta.view.fragments.CartaTipoDialogFragment;
import com.kruma.kanta.view.fragments.EventoKaraokeFragment;
import com.kruma.kanta.view.fragments.ListarCancionKaraokeFragment;
import com.kruma.kanta.view.fragments.OfertasKaraokeFragment;
import com.kruma.kanta.view.fragments.TragosFragment;

//import com.google.android.gms.common.api.GoogleApiClient;

/**
 * Created by JORDY on 27/01/2017.
 */

public class KaraokesActivity extends AppCompatActivity implements OnNavigationListener, SearchView.OnQueryTextListener {

    //region CONTROLES
    //KARAOKE
    SearchView searchView;

    public Button btn_gOfertasKaraoke;
    public Button btn_gEventosKaraoke;
    public Button btn_gCartaKaraoke;
    public Button btn_gCancionesKaraoke;

    public TextView txtMiUsuarioLogin;

    android.support.v7.app.ActionBarDrawerToggle toggle;
    NavigationView nv_gNavigationView;
    MenuItem searchItem;
    MenuItem optionIdioma;
    MenuItem optionGenero;
    MenuItem optionTipo;
    MenuItem optionPais;

    LinearLayout ll_gLinearLayoutBotones;
    //endregion

    // ----- TRAMITE
    private View.OnClickListener btn_gOfertasKaraokeLlamarFragmentOfertas = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            setFragment(Constante.FRAGMENT_OFERTAS_KARAOKES);

            setColorButtonActivado(btn_gOfertasKaraoke);
            setColorButtonDesactivado(btn_gEventosKaraoke);
            setColorButtonDesactivado(btn_gCartaKaraoke);
            setColorButtonDesactivado(btn_gCancionesKaraoke);

        }
    };

    private View.OnClickListener btn_gEventosKaraokeLlamarFragmentEventos = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            setFragment(Constante.FRAGMENT_EVENTOS_KARAOKES);

            setColorButtonActivado(btn_gEventosKaraoke);
            setColorButtonDesactivado(btn_gOfertasKaraoke);
            setColorButtonDesactivado(btn_gCartaKaraoke);
            setColorButtonDesactivado(btn_gCancionesKaraoke);
        }
    };

    private View.OnClickListener btn_gCartaKaraokeLlamarFragmentCarta = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            setFragment(Constante.FRAGMENT_CARTA_KARAOKES);

            setColorButtonActivado(btn_gCartaKaraoke);
            setColorButtonDesactivado(btn_gOfertasKaraoke);
            setColorButtonDesactivado(btn_gEventosKaraoke);
            setColorButtonDesactivado(btn_gCancionesKaraoke);
        }
    };

    private View.OnClickListener btn_gCancionesKaraokeLlamarFragmentCanciones = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            setFragment(Constante.FRAGMENT_LISTACANCIONES_KARAOKES);

            setColorButtonActivado(btn_gCancionesKaraoke);
            setColorButtonDesactivado(btn_gOfertasKaraoke);
            setColorButtonDesactivado(btn_gEventosKaraoke);
            setColorButtonDesactivado(btn_gCartaKaraoke);

        }
    };



    private NavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener = new NavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(MenuItem item) {
            switch (item.getItemId()) {
                case R.id.nav_llamar_karaokes:

                    ocultarBotones();

                    mostrarBoton(btn_gOfertasKaraoke);
                    mostrarBoton(btn_gCartaKaraoke);
                    mostrarBoton(btn_gCancionesKaraoke);

                    setColorButtonActivado(btn_gOfertasKaraoke);
                    setColorButtonDesactivado(btn_gCartaKaraoke);
                    setColorButtonDesactivado(btn_gCancionesKaraoke);

                    setFragmentMenu(Constante.FRAGMENT_KARAOES_F);

                    break;
            }

            DrawerLayout dl = (DrawerLayout) findViewById(R.id.drawerLayoutKaraoke);
            if (dl.isDrawerOpen(GravityCompat.START))
                dl.closeDrawer(GravityCompat.START);

            return false;
        }
    };

    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_karaokes);
        Inicializar();
    }

    //region METODOS PRIVADOS
    private void Inicializar() {

        // Reconocer el DrawerLayout del xml
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayoutKaraoke);

        // El ActionBarDrawerToggle toggle sirve para darle funcionalidad al Drawerlayout
        toggle = new android.support.v7.app.ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);

        // Adds the specified listener to the list of listeners that will be notified of drawer events.
        // Agrega el receptor especificado a la lista de oyentes que será notificada de los acontecimientos del cajón.
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        //Navigator
        nv_gNavigationView = (NavigationView) findViewById(R.id.navigationViewKaraokes);

        // Activamos el evento click del NavigationView
        nv_gNavigationView.setNavigationItemSelectedListener(navigationItemSelectedListener);

        // Reconocer LinearLayout del xml
        ll_gLinearLayoutBotones = (LinearLayout) findViewById(R.id.linearLayoutBotonesKaraokes);

        // Agregar propiedades al Layout
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        ll_gLinearLayoutBotones.setOrientation(LinearLayout.HORIZONTAL);

        // Con esta linea lo que hacemos en que los botones tengan pesos o weight
        TableLayout.LayoutParams paramsButton = new TableLayout.LayoutParams(0, TableLayout.LayoutParams.WRAP_CONTENT, 1f);


        btn_gOfertasKaraoke = new Button(this);
        setButtons(btn_gOfertasKaraoke, "NOVEDADES", paramsButton);
        btn_gOfertasKaraoke.setId(R.id.btnOfertasKaraoke);

        // Agregar Boton Eventos
        btn_gEventosKaraoke = new Button(this);
        setButtons(btn_gEventosKaraoke, "EVENTOS", paramsButton);
        btn_gEventosKaraoke.setId(R.id.btnEventosKaraoke);


        // Agregar Boton Carta
        btn_gCartaKaraoke = new Button(this);
        setButtons(btn_gCartaKaraoke, "CARTA", paramsButton);
        btn_gCartaKaraoke.setId(R.id.btnCartaKaraoke);

        // Agregar Boton Cancionero
        btn_gCancionesKaraoke = new Button(this);
        setButtons(btn_gCancionesKaraoke, "CANCIONERO", paramsButton);
        btn_gCancionesKaraoke.setId(R.id.btnCancionesKaraoke);


        // Agregar el Button al LinearLayout
        ll_gLinearLayoutBotones.addView(btn_gOfertasKaraoke);
        ll_gLinearLayoutBotones.addView(btn_gEventosKaraoke);
        ll_gLinearLayoutBotones.addView(btn_gCartaKaraoke);
        ll_gLinearLayoutBotones.addView(btn_gCancionesKaraoke);

        setFragmentMenu(Constante.FRAGMENT_KARAOES_F);

        ocultarBotones();

        mostrarBoton(btn_gOfertasKaraoke);
        mostrarBoton(btn_gEventosKaraoke);
        mostrarBoton(btn_gCartaKaraoke);
        mostrarBoton(btn_gCancionesKaraoke);

        setColorButtonActivado(btn_gOfertasKaraoke);
        setColorButtonDesactivado(btn_gEventosKaraoke);
        setColorButtonDesactivado(btn_gCartaKaraoke);
        setColorButtonDesactivado(btn_gCancionesKaraoke);


        btn_gOfertasKaraoke.setOnClickListener(btn_gOfertasKaraokeLlamarFragmentOfertas);
        btn_gEventosKaraoke.setOnClickListener(btn_gEventosKaraokeLlamarFragmentEventos);
        btn_gCartaKaraoke.setOnClickListener(btn_gCartaKaraokeLlamarFragmentCarta);
        btn_gCancionesKaraoke.setOnClickListener(btn_gCancionesKaraokeLlamarFragmentCanciones);

        btn_gEventosKaraoke.setVisibility(View.GONE);
    }

    public void ocultarBotones() {

        // KARAOKES

        btn_gOfertasKaraoke.setVisibility(View.GONE);
        btn_gEventosKaraoke.setVisibility(View.GONE);
        btn_gCartaKaraoke.setVisibility(View.GONE);
        btn_gCancionesKaraoke.setVisibility(View.GONE);

    }

    // Método para mostrar boton
    public void mostrarBoton(Button btnButton) {
        btnButton.setVisibility(View.VISIBLE);
    }

    // Método para setear valores del los botonoes
    private void setButtons(Button btn_pButton, String str_pNameButton, TableLayout.LayoutParams obj_pParamsButton) {
        btn_pButton.setText(str_pNameButton);
        btn_pButton.setLayoutParams(obj_pParamsButton);
        //btn_pButton.setTextSize(12);
        btn_pButton.setTypeface(null, Typeface.BOLD);
        btn_pButton.setBackgroundResource(R.drawable.mybuttonregister);
    }

    private void setColorButtonActivado(Button button) {
        button.setTextColor(getApplication().getResources().getColor(R.color.selectedState));
    }

    private void setColorButtonDesactivado(Button button) {
        button.setTextColor(getApplication().getResources().getColor(R.color.unselectedState));
    }

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

            case Constante.FRAGMENT_KARAOES_F:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                OfertasKaraokeFragment ofertasKaraokeFragment = new OfertasKaraokeFragment();
                fragmentTransaction.replace(R.id.flFragmentKaraoke, ofertasKaraokeFragment);
                fragmentTransaction.commit();
                break;
        }
    }

    // Para llamadas a Fragments desde la Activity
    private void setFragment(int position) {
        FragmentManager fragmentManager;
        FragmentTransaction fragmentTransaction;

        switch (position) {
            // TRAMITE
            case Constante.FRAGMENT_OFERTAS_KARAOKES:
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

                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                OfertasKaraokeFragment ofertasKaraokeFragment = new OfertasKaraokeFragment();
                fragmentTransaction.replace(R.id.flFragmentKaraoke, ofertasKaraokeFragment);
                fragmentTransaction.commit();
                break;
            case Constante.FRAGMENT_EVENTOS_KARAOKES:

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

                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                EventoKaraokeFragment eventoKaraokeFragment = new EventoKaraokeFragment();
                fragmentTransaction.replace(R.id.flFragmentKaraoke, eventoKaraokeFragment);
                fragmentTransaction.commit();
                break;

            // TRAMITE
            case Constante.FRAGMENT_CARTA_KARAOKES:

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

                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                TragosFragment tragosFragment = new TragosFragment();
                fragmentTransaction.replace(R.id.flFragmentKaraoke, tragosFragment);
                fragmentTransaction.commit();
                break;

            case Constante.FRAGMENT_LISTACANCIONES_KARAOKES:

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

                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                ListarCancionKaraokeFragment listarCancionKaraokeFragment = new ListarCancionKaraokeFragment();
                fragmentTransaction.replace(R.id.flFragmentKaraoke, listarCancionKaraokeFragment);
                fragmentTransaction.commit();
                break;

        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        Menu nav_Menu = nv_gNavigationView.getMenu();

        getMenuInflater().inflate(R.menu.main_menu, menu);
        getMenuInflater().inflate(R.menu.canciones_menu, menu);

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

            }
        } else {
            txtMiUsuarioLogin.setText(com.kruma.core.security.SecurityManager.getUsuario());
        }

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void showMessageFragment(String message, String fragmentName) {
    }

    //region SearchView
    @Override
    public boolean onQueryTextSubmit(String query) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment currentFragment = fragmentManager.findFragmentById(R.id.flFragmentKaraoke);
        if (currentFragment instanceof ListarCancionKaraokeFragment) {
            ListarCancionKaraokeFragment.ListarCancionesPorFiltro(Constante.ID_GENERO, Constante.ID_IDIOMA, query);
        }
        if (currentFragment instanceof TragosFragment) {
            TragosFragment.ListarCartaPorFiltro(Constante.ID_PRODUCTO_TIPO, query);
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

//endregion



