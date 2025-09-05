package com.kruma.kanta.view.activity;

import android.app.SearchManager;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.kruma.core.configuration.App;
import com.kruma.core.util.common.ProcessCallback;
import com.kruma.core.util.common.List;
import com.kruma.core.util.common.ProcessResult;
import com.kruma.kanta.CancioneroActivity;
import com.kruma.kanta.KaraokesActivity;
import com.kruma.kanta.R;
import com.kruma.kanta.entidad.Carta;
import com.kruma.kanta.entidad.Constante;
import com.kruma.kanta.entidad.Local;
import com.kruma.kanta.entidad.LocalCancion;
import com.kruma.kanta.view.adapters.BuscarCancionesAdapter;
import com.kruma.kanta.view.adapters.KaraokesAdapter;
import com.kruma.kanta.view.adapters.SearchResultsCancionesAdapter;
import com.kruma.kanta.view.adapters.SearchResultsCartaAdapter;
import com.kruma.kanta.view.adapters.SearchResultsKaraokesAdapter;
import com.kruma.kanta.view.fragments.CancionesVersionDialogFragment;

public class SearchResultsActivity extends AppCompatActivity  {

    private KaraokesAdapter karaokesAdapter;
    private SearchResultsCartaAdapter searchResultsCartaAdapter;
    private SearchResultsCancionesAdapter searchResultsCancionesAdapter;
    private SearchResultsKaraokesAdapter searchResultsKaraokesAdapter;
    private ListView lstCancionesResults;
    private ListView lstCartaResults;
    private ListView lstListarCancionKaraokeResults;

    private ListView lstKaraokeFragmentResults;
    private ListView lstCancioneroResults;
    static int var = 0;

    private TextView txtResultado;


    private Button btnSolicitarPedidoCarta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);

        init();
    }

    private void init() {

        Intent searchIntent = getIntent();
        String query = "";

        if (Intent.ACTION_SEARCH.equals(searchIntent.getAction())) {
            query = searchIntent.getStringExtra(SearchManager.QUERY);
            //Toast.makeText(App.getContext(), query, Toast.LENGTH_SHORT).show();
        }
        //getSupportActionBar().setHomeButtonEnabled(true);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setSubtitle("Resultados para " + "\"" + query + "\"");
        getSupportActionBar().setTitle("Buscar");

        lstCancionesResults = (ListView) findViewById(R.id.lstResults);
        lstCartaResults = (ListView) findViewById(R.id.lstResultsCarta);
        lstListarCancionKaraokeResults = (ListView) findViewById(R.id.lstResultsListarCancionKaraoke);
        lstKaraokeFragmentResults = (ListView) findViewById(R.id.lstKaraokeFragment);
        lstCancioneroResults = (ListView) findViewById(R.id.lstResultsCancionero);

        txtResultado = (TextView) findViewById(R.id.txtResultado);
        lstCancionesResults.setBackgroundColor(Color.TRANSPARENT);

        btnSolicitarPedidoCarta = (Button) findViewById(R.id.btnSolicitarPedidoResultado);

        btnSolicitarPedidoCarta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SolicitarPedido();


            }
        });

        if (var == com.kruma.kanta.entidad.Constante.SEARCHRESULTS_RANKING) {

            com.kruma.kanta.logical.LocalCancion.ListarRankingFiltro(
                    //Integer.parseInt(Constante.ID_LOCAL),
                    com.kruma.core.security.SecurityManager.getKeyInteger(Constante.SESSION_IDLOCAL),
                    Constante.ID_GENERO,
                    Constante.ID_IDIOMA,
                    query, null, null,

                    new ProcessCallback<List<LocalCancion>>() {
                        @Override
                        public void success(List<LocalCancion> obj_pResultado) {

                            searchResultsCancionesAdapter = new SearchResultsCancionesAdapter(App.getContext(), obj_pResultado.getResult());
                            lstCancionesResults.setAdapter(searchResultsCancionesAdapter);

                            if(obj_pResultado.getResult().size() == 0){

                                txtResultado.setVisibility(View.VISIBLE);
                            }


                        }

                        @Override
                        public void failure(ProcessResult obj_pResultado) {

                        }
                    });

            btnSolicitarPedidoCarta.setVisibility(View.GONE);
        }

        if (var == com.kruma.kanta.entidad.Constante.SEARCHRESULTS_INGRESOS) {
            com.kruma.kanta.logical.LocalCancion.ListarNovedadesFiltro(
                    //Integer.parseInt(Constante.ID_LOCAL),
                    com.kruma.core.security.SecurityManager.getKeyInteger(Constante.SESSION_IDLOCAL),
                    Constante.ID_GENERO,
                    Constante.ID_IDIOMA,
                    query, null, null,
                    new ProcessCallback<List<LocalCancion>>() {
                        @Override
                        public void success(List<LocalCancion> obj_pResultado) {

                            searchResultsCancionesAdapter = new SearchResultsCancionesAdapter(App.getContext(), obj_pResultado.getResult());
                            lstCancionesResults.setAdapter(searchResultsCancionesAdapter);

                            if(obj_pResultado.getResult().size() == 0){

                                txtResultado.setVisibility(View.VISIBLE);
                            }


                        }

                        @Override
                        public void failure(ProcessResult obj_pResultado) {

                        }
                    });
            btnSolicitarPedidoCarta.setVisibility(View.GONE);
        }

        if (var == com.kruma.kanta.entidad.Constante.SEARCHRESULTS_LISTA) {
            com.kruma.kanta.logical.LocalCancion.ListarListaFiltro(
                    //Integer.parseInt(Constante.ID_LOCAL),
                    com.kruma.core.security.SecurityManager.getKeyInteger(Constante.SESSION_IDLOCAL),
                    Constante.ID_GENERO,
                    Constante.ID_IDIOMA,
                    query, null, null,
                    new ProcessCallback<List<LocalCancion>>() {
                        @Override
                        public void success(List<LocalCancion> obj_pResultado) {

                            searchResultsCancionesAdapter = new SearchResultsCancionesAdapter(App.getContext(), obj_pResultado.getResult());
                            lstCancionesResults.setAdapter(searchResultsCancionesAdapter);

                            if(obj_pResultado.getResult().size() == 0){

                                txtResultado.setVisibility(View.VISIBLE);
                            }


                        }

                        @Override
                        public void failure(ProcessResult obj_pResultado) {

                        }
                    });

            btnSolicitarPedidoCarta.setVisibility(View.GONE);
        }

        if (var == Constante.SEARCHRESULTS_KARAOKES) {
            if(Constante.ID_PAIS != null){
            com.kruma.kanta.logical.Local.ListarLocal(
                    null,
                    Integer.parseInt(Constante.ID_PAIS),
                    query, null, null,
                    new ProcessCallback<List<Local>>() {
                        @Override
                        public void success(List<Local> obj_pResultado) {

                            searchResultsKaraokesAdapter = new SearchResultsKaraokesAdapter(App.getContext(), obj_pResultado.getResult());
                            lstKaraokeFragmentResults.setAdapter(searchResultsKaraokesAdapter);

                            if(obj_pResultado.getResult().size() == 0){

                                txtResultado.setVisibility(View.VISIBLE);
                            }


                        }

                        @Override
                        public void failure(ProcessResult obj_pResultado) {

                        }
                    });

            btnSolicitarPedidoCarta.setVisibility(View.GONE);
            } else {com.kruma.kanta.logical.Local.ListarLocal(
                    null,
                    null,
                    query, null, null,
                    new ProcessCallback<List<Local>>() {
                        @Override
                        public void success(List<Local> obj_pResultado) {

                            searchResultsKaraokesAdapter = new SearchResultsKaraokesAdapter(App.getContext(), obj_pResultado.getResult());
                            lstKaraokeFragmentResults.setAdapter(searchResultsKaraokesAdapter);

                            if(obj_pResultado.getResult().size() == 0){

                                txtResultado.setVisibility(View.VISIBLE);
                            }


                        }

                        @Override
                        public void failure(ProcessResult obj_pResultado) {

                        }
                    });

                btnSolicitarPedidoCarta.setVisibility(View.GONE);}
        }



        if (var == Constante.SEARCHRESULTS_LISTAR_CANCION_KARAOKES) {
            com.kruma.kanta.logical.LocalCancion.ListarListaFiltro(
                    com.kruma.core.security.SecurityManager.getKeyInteger(Constante.SESSION_IDKARAOKE),
                    Constante.ID_GENERO,
                    Constante.ID_IDIOMA,
                    query, null, null,
                    new ProcessCallback<List<LocalCancion>>() {
                        @Override
                        public void success(List<LocalCancion> obj_pResultado) {

                            searchResultsCancionesAdapter = new SearchResultsCancionesAdapter(App.getContext(), obj_pResultado.getResult());
                            lstListarCancionKaraokeResults.setAdapter(searchResultsCancionesAdapter);

                            if(obj_pResultado.getResult().size() == 0){

                                txtResultado.setVisibility(View.VISIBLE);
                            }


                        }

                        @Override
                        public void failure(ProcessResult obj_pResultado) {

                        }
                    });

            btnSolicitarPedidoCarta.setVisibility(View.GONE);
        }

        if (var == com.kruma.kanta.entidad.Constante.SEARCHRESULTS_CARTA) {

            com.kruma.kanta.logical.Carta.ListarCarta(null, 1, null, query, Constante.ID_PRODUCTO_TIPO, null, null,
                    new ProcessCallback<List<Carta>>() {
                        @Override
                        public void success(List<Carta> obj_pResultado) {

                                searchResultsCartaAdapter = new SearchResultsCartaAdapter(App.getContext(), obj_pResultado.getResult());
                                lstCartaResults.setAdapter(searchResultsCartaAdapter);

                            if(obj_pResultado.getResult().size() == 0){

                                txtResultado.setVisibility(View.VISIBLE);
                            }


                        }

                        @Override
                        public void failure(ProcessResult obj_pResultado) {

                        }
                    });


        }

        if (var == Constante.SEARCHRESULTS_BUSCARCANCION) {
            com.kruma.kanta.logical.LocalCancion.ListarTodos(
                    Constante.ID_GENERO,
                    Constante.ID_IDIOMA,
                    query, null, null,
                    new ProcessCallback<List<LocalCancion>>() {
                        @Override
                        public void success(List<LocalCancion> obj_pResultado) {

                            searchResultsCancionesAdapter = new SearchResultsCancionesAdapter(App.getContext(), obj_pResultado.getResult());
                            lstCancioneroResults.setAdapter(searchResultsCancionesAdapter);

                            if(obj_pResultado.getResult().size() == 0){

                                txtResultado.setVisibility(View.VISIBLE);
                            }


                        }

                        @Override
                        public void failure(ProcessResult obj_pResultado) {

                        }
                    });

            btnSolicitarPedidoCarta.setVisibility(View.GONE);
        }

        lstCancionesResults.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Constante.ID_LOCALCANCION = SearchResultsCancionesAdapter.getLocalCancion(i).getIdLocalCancion();
                FragmentManager fmVersion = getSupportFragmentManager();
                CancionesVersionDialogFragment cancionesVersionDialogFragment = CancionesVersionDialogFragment.newInstance("Elegir versión");
                cancionesVersionDialogFragment.show(fmVersion, "dialog_fragment_canciones_version");

            }
        });

        lstCancioneroResults.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Constante.ID_LOCALCANCION = BuscarCancionesAdapter.getLocalCancion(i).getIdLocalCancion();
                Intent intent = new Intent(App.getContext(), CancioneroActivity.class);

                startActivity(intent);
            }
        });

        lstKaraokeFragmentResults.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Integer IdLocal = KaraokesAdapter.getIdLocal(i);
                // Constante.ID_STRING_TRAMITE = String.valueOf(TramiteAdapter.getIdTramite(position));
                com.kruma.core.security.SecurityManager.setKey(Constante.SESSION_IDKARAOKE,  String.valueOf(IdLocal));
                Intent intent = new Intent(App.getContext(), KaraokesActivity.class);
                startActivity(intent);
            }
        });
    }

    public void SolicitarPedido() {
        try {

            // Se realiza la inserción del usuario
            com.kruma.kanta.logical.Carta.SolicitarPedido(

                    //Integer.parseInt(Constante.ID_LOCAL),
                    com.kruma.core.security.SecurityManager.getKeyInteger(Constante.SESSION_IDLOCAL),
                    //Integer.parseInt(Constante.ID_UBICACION),
                    com.kruma.core.security.SecurityManager.getKeyInteger(Constante.SESSION_IDUBICACION),
                    //Constante.TXT_USUARIO_LOGEADO,
                    com.kruma.core.security.SecurityManager.getUsuario(),

                    new ProcessCallback<ProcessResult>() {

                        @Override
                        public void success(ProcessResult obj_pResultado) {
                            Toast.makeText(App.getContext(), obj_pResultado.getMessage().toString() , Toast.LENGTH_LONG).show();

                        }

                        @Override
                        public void failure(ProcessResult obj_pResultado) {
                            Toast.makeText(App.getContext(),  obj_pResultado.getMessage().toString(), Toast.LENGTH_LONG).show();
                        }
                    });

        } catch (Exception ex) {
            Toast.makeText(App.getContext(), ex.getMessage(), Toast.LENGTH_SHORT).show();
        }


    }


    public static void ToPrint(int i) {
        var = i;
    }
}
