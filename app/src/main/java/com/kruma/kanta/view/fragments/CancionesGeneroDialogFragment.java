package com.kruma.kanta.view.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;


import com.kruma.core.configuration.App;
import com.kruma.core.util.common.ProcessCallback;
import com.kruma.core.util.common.List;
import com.kruma.core.util.common.ProcessResult;
import com.kruma.kanta.R;
import com.kruma.kanta.entidad.Constante;
import com.kruma.kanta.entidad.GeneroMusical;
import com.kruma.kanta.entidad.LocalCancion;
import com.kruma.kanta.view.adapters.DialogGeneroAdapter;
import com.kruma.kanta.view.adapters.DialogGeneroAdapterCancion;
import com.kruma.kanta.view.storage.Cheeses;

/**
 * Created by Enrique on 04/09/2016.
 */
public class CancionesGeneroDialogFragment extends DialogFragment {

    ImageView iviAceptar;
    ImageView iviCancelar;
    static int var = 0;
    private ListView lstDialogGenero;

    private DialogGeneroAdapter dialogGeneroAdapter;
    private DialogGeneroAdapterCancion dialogGeneroAdapterCancion;

    // 1. Origen de datos
    private String[] mStrings = Cheeses.sCheeseStrings;

    public CancionesGeneroDialogFragment() {
    }


    public static CancionesGeneroDialogFragment newInstance(String titulo) {

        CancionesGeneroDialogFragment frag = new CancionesGeneroDialogFragment();
        Bundle args = new Bundle();
        args.putString("titulo", titulo);
        frag.setArguments(args);
        return frag;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_fragment_canciones_genero, container);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String tituloDialog = getArguments().getString("titulo", "Elegir género");
        getDialog().setTitle(tituloDialog);
        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_MODE_CHANGED);

        // 2. View: ListView, GridView, Spinner
        lstDialogGenero = (ListView) getView().findViewById(R.id.lstDialogGenero);

        // 3. Adapter
        /*
        com.kruma.core.business.logical.Genero.Listar(
                new com.kruma.core.util.common.ProcessCallback<
                        com.kruma.core.util.common.List<com.kruma.core.util.common.Entity>>(){
                    @Override
                    public void success(ServiceResult<List<Entity>> obj_pServiceResult) {
                        ArrayAdapter<com.kruma.core.util.common.Entity> adapter = new ArrayAdapter<com.kruma.core.util.common.Entity>(App.getContext(), android.R.layout.simple_list_item_1, obj_pServiceResult.getResultado().getResult());
                        lstDialogGenero.setAdapter(adapter);
                    }

                    @Override
                    public void failure(ServiceResult<List<Entity>> obj_pServiceResult) {

                    }
                });
        */


        /*

        com.kruma.kanta.logical.GeneroMusical.ListarGeneroMusical(
                new ProcessCallback<List<GeneroMusical>>() {

                    @Override
                    public void success(List<GeneroMusical> obj_pResultado) {
                        dialogGeneroAdapter = new DialogGeneroAdapter(App.getContext(), obj_pResultado.getResult());
                        lstDialogGenero.setAdapter(dialogGeneroAdapter);
                    }

                    @Override
                    public void failure(ProcessResult obj_pResultado) {

                    }
                });

*/

        if (com.kruma.core.security.SecurityManager.getKeyInteger(Constante.SESSION_IDLOCAL) != null) {
            com.kruma.kanta.logical.GeneroMusical.ListarGeneroMusicalPorLocal(
                    com.kruma.core.security.SecurityManager.getKeyInteger(Constante.SESSION_IDLOCAL),
                    new ProcessCallback<List<GeneroMusical>>() {

                        @Override
                        public void success(List<GeneroMusical> obj_pResultado) {
                            dialogGeneroAdapter = new DialogGeneroAdapter(App.getContext(), obj_pResultado.getResult());
                            lstDialogGenero.setAdapter(dialogGeneroAdapter);
                        }

                        @Override
                        public void failure(ProcessResult obj_pResultado) {

                        }
                    });
        } else {
            if (var == Constante.SEARCHRESULTS_KARAOKES) {
                com.kruma.kanta.logical.GeneroMusical.ListarGeneroMusicalPorLocal(
                        com.kruma.core.security.SecurityManager.getKeyInteger(Constante.SESSION_IDKARAOKE),
                        new ProcessCallback<List<GeneroMusical>>() {

                            @Override
                            public void success(List<GeneroMusical> obj_pResultado) {
                                dialogGeneroAdapter = new DialogGeneroAdapter(App.getContext(), obj_pResultado.getResult());
                                lstDialogGenero.setAdapter(dialogGeneroAdapter);
                            }

                            @Override
                            public void failure(ProcessResult obj_pResultado) {

                            }
                        });
            } else {
                com.kruma.kanta.logical.GeneroMusical.ListarGeneroMusical(
                        new ProcessCallback<List<GeneroMusical>>() {

                            @Override
                            public void success(List<GeneroMusical> obj_pResultado) {
                                dialogGeneroAdapter = new DialogGeneroAdapter(App.getContext(), obj_pResultado.getResult());
                                lstDialogGenero.setAdapter(dialogGeneroAdapter);
                            }

                            @Override
                            public void failure(ProcessResult obj_pResultado) {

                            }
                        });
            }
        }

        if (var == com.kruma.kanta.entidad.Constante.SEARCHRESULTS_RANKING) {

            lstDialogGenero.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                    Constante.TXT_FILTRAR_GENERO = DialogGeneroAdapter.getDescripcionGeneroMusical(position);
                    Constante.ID_GENERO = String.valueOf(DialogGeneroAdapter.getIdGeneroMusical(position));

                    RankingFragment.ListarCancionesPorFiltro(String.valueOf(DialogGeneroAdapter.getIdGeneroMusical(position)), Constante.ID_IDIOMA);
                    dismiss();
                }
            });
        }

        if (var == com.kruma.kanta.entidad.Constante.SEARCHRESULTS_INGRESOS) {
            lstDialogGenero.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                    Constante.TXT_FILTRAR_GENERO = DialogGeneroAdapter.getDescripcionGeneroMusical(position);
                    Constante.ID_GENERO = String.valueOf(DialogGeneroAdapter.getIdGeneroMusical(position));

                    IngresosFragment.ListarCancionesPorFiltro(String.valueOf(DialogGeneroAdapter.getIdGeneroMusical(position)), Constante.ID_IDIOMA);
                    dismiss();
                }
            });
        }

        if (var == com.kruma.kanta.entidad.Constante.SEARCHRESULTS_LISTA) {

            lstDialogGenero.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override

                public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                    Constante.TXT_FILTRAR_GENERO = DialogGeneroAdapter.getDescripcionGeneroMusical(position);
                    Constante.ID_GENERO = String.valueOf(DialogGeneroAdapter.getIdGeneroMusical(position));

                    ListaFragment.ListarCancionesPorFiltro(String.valueOf(DialogGeneroAdapter.getIdGeneroMusical(position)), Constante.ID_IDIOMA);
                    dismiss();
                }
            });
        }

        if (var == Constante.SEARCHRESULTS_LISTAR_CANCION_KARAOKES) {

            lstDialogGenero.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override

                public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                    Constante.TXT_FILTRAR_GENERO = DialogGeneroAdapter.getDescripcionGeneroMusical(position);
                    Constante.ID_GENERO = String.valueOf(DialogGeneroAdapter.getIdGeneroMusical(position));
                    ListarCancionKaraokeFragment.ListarCancionesPorFiltro(Constante.ID_GENERO, Constante.ID_IDIOMA, null);
                    dismiss();
                }
            });
        }

        if (var == Constante.SEARCHRESULTS_BUSCARCANCION) {

            lstDialogGenero.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override

                public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                    Constante.TXT_FILTRAR_GENERO = DialogGeneroAdapter.getDescripcionGeneroMusical(position);
                    Constante.ID_GENERO = String.valueOf(DialogGeneroAdapter.getIdGeneroMusical(position));
                    BuscarCancionFragment.ListarCancionesPorFiltro(Constante.ID_GENERO, Constante.ID_IDIOMA, null);
                    dismiss();
                }
            });
        }
    }

    private void CargarGeneroLista() {

        com.kruma.kanta.logical.LocalCancion.ListarLista(
                com.kruma.core.security.SecurityManager.getKeyInteger(Constante.SESSION_IDLOCAL),
                null, null,
                new ProcessCallback<List<LocalCancion>>() {
                    @Override
                    public void success(List<LocalCancion> obj_pResultado) {
                        dialogGeneroAdapterCancion = new DialogGeneroAdapterCancion(App.getContext(), obj_pResultado.getResult());
                        try {
                            lstDialogGenero.setAdapter(dialogGeneroAdapterCancion);
                        } catch (Exception ex) {
                            String a = "";
                        }
                    }

                    @Override
                    public void failure(ProcessResult obj_pResultado) {

                    }
                });
    }

    private void CargarGeneroRanking() {

        com.kruma.kanta.logical.LocalCancion.ListarRanking(
                //Integer.parseInt(Constante.ID_LOCAL),
                com.kruma.core.security.SecurityManager.getKeyInteger(Constante.SESSION_IDLOCAL),
                null, null,
                new ProcessCallback<List<LocalCancion>>() {
                    @Override
                    public void success(List<LocalCancion> obj_pResultado) {

                        dialogGeneroAdapterCancion = new DialogGeneroAdapterCancion(App.getContext(), obj_pResultado.getResult());
                        try {
                            lstDialogGenero.setAdapter(dialogGeneroAdapterCancion);
                        } catch (Exception ex) {
                            String a = "";
                        }
                    }

                    @Override
                    public void failure(ProcessResult obj_pResultado) {

                    }
                });
    }

    private void CargarGeneroNovedades() {

        com.kruma.kanta.logical.LocalCancion.ListarNovedades(
                //Integer.parseInt(Constante.ID_LOCAL),
                com.kruma.core.security.SecurityManager.getKeyInteger(Constante.SESSION_IDLOCAL),
                null, null,
                new ProcessCallback<List<LocalCancion>>() {
                    @Override
                    public void success(List<LocalCancion> obj_pResultado) {

                        dialogGeneroAdapterCancion = new DialogGeneroAdapterCancion(App.getContext(), obj_pResultado.getResult());
                        try {
                            lstDialogGenero.setAdapter(dialogGeneroAdapterCancion);
                        } catch (Exception ex) {
                            String a = "";
                        }
                    }

                    @Override
                    public void failure(ProcessResult obj_pResultado) {

                    }
                });
    }

    public static void ToPrint(int i) {
        var = i;
    }
}
