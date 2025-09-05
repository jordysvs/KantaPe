package com.kruma.kanta.view.fragments;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.kruma.core.configuration.App;
import com.kruma.core.util.common.ProcessCallback;
import com.kruma.core.util.common.List;
import com.kruma.core.util.common.ProcessResult;
import com.kruma.kanta.R;
import com.kruma.kanta.entidad.Constante;
import com.kruma.kanta.entidad.Idioma;
import com.kruma.kanta.entidad.LocalCancion;
import com.kruma.kanta.view.adapters.DialogGeneroAdapterCancion;
import com.kruma.kanta.view.adapters.DialogIdiomaAdapter;
import com.kruma.kanta.view.adapters.DialogIdiomaAdapterCancion;

/**
 * Created by Enrique on 05/09/2016.
 */
public class CancionesIdiomaDialogFragment extends DialogFragment {

    Button btnAceptar;
    Button btnCancelar;
    static int var = 0;
    private ListView lstDialogIdioma;
    private DialogIdiomaAdapterCancion dialogIdiomaAdapterCancion;

    public CancionesIdiomaDialogFragment() {
    }

    public static CancionesIdiomaDialogFragment newInstance(String titulo) {
        CancionesIdiomaDialogFragment frag = new CancionesIdiomaDialogFragment();
        Bundle args = new Bundle();
        args.putString("titulo", titulo);
        frag.setArguments(args);
        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_fragment_canciones_idioma, container);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String tituloDialog = getArguments().getString("titulo", "Elegir idioma");
        getDialog().setTitle(tituloDialog);
        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_MODE_CHANGED);

        lstDialogIdioma = (ListView) getView().findViewById(R.id.lstDialogIdioma);

        /*
        com.kruma.kanta.logical.Idioma.ListarIdioma(new ProcessCallback<List<Idioma>>() {
            @Override
            public void success(List<Idioma> obj_pResultado) {
                DialogIdiomaAdapter dialogIdiomaAdapter = new DialogIdiomaAdapter(App.getContext(),obj_pResultado.getResult());
                lstDialogIdioma.setAdapter(dialogIdiomaAdapter);
            }

            @Override
            public void failure(ProcessResult obj_pResultado) {

            }
        });
        */

        if (com.kruma.core.security.SecurityManager.getKeyInteger(Constante.SESSION_IDLOCAL) != null) {
            com.kruma.kanta.logical.Idioma.ListarIdiomaPorLocal(
                    com.kruma.core.security.SecurityManager.getKeyInteger(Constante.SESSION_IDLOCAL), new ProcessCallback<List<Idioma>>() {
                        @Override
                        public void success(List<Idioma> obj_pResultado) {
                            DialogIdiomaAdapter dialogIdiomaAdapter = new DialogIdiomaAdapter(App.getContext(), obj_pResultado.getResult());
                            lstDialogIdioma.setAdapter(dialogIdiomaAdapter);
                        }

                        @Override
                        public void failure(ProcessResult obj_pResultado) {

                        }
                    });
        } else {
            if (var == Constante.SEARCHRESULTS_KARAOKES) {
                com.kruma.kanta.logical.Idioma.ListarIdiomaPorLocal(
                        com.kruma.core.security.SecurityManager.getKeyInteger(Constante.SESSION_IDKARAOKE), new ProcessCallback<List<Idioma>>() {
                            @Override
                            public void success(List<Idioma> obj_pResultado) {
                                DialogIdiomaAdapter dialogIdiomaAdapter = new DialogIdiomaAdapter(App.getContext(), obj_pResultado.getResult());
                                lstDialogIdioma.setAdapter(dialogIdiomaAdapter);
                            }

                            @Override
                            public void failure(ProcessResult obj_pResultado) {

                            }
                        });

            } else {
                com.kruma.kanta.logical.Idioma.ListarIdioma(
                        new ProcessCallback<List<Idioma>>() {
                            @Override
                            public void success(List<Idioma> obj_pResultado) {
                                DialogIdiomaAdapter dialogIdiomaAdapter = new DialogIdiomaAdapter(App.getContext(), obj_pResultado.getResult());
                                lstDialogIdioma.setAdapter(dialogIdiomaAdapter);
                            }

                            @Override
                            public void failure(ProcessResult obj_pResultado) {

                            }
                        });
            }

        }



/*
if(Constante.CANCIONERO == 1){
    CargarIdiomaLista();
} else if(Constante.CANCIONERO == 2){
    CargarIdiomaRanking();
} else  CargarIdiomaNovedades();
*/

        if (var == com.kruma.kanta.entidad.Constante.SEARCHRESULTS_RANKING) {

            lstDialogIdioma.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                    Constante.ID_IDIOMA = String.valueOf(DialogIdiomaAdapter.getIdIdioma(position));
                    Constante.TXT_FILTRAR_IDIOMA = DialogIdiomaAdapter.getDescripcionIdioma(position);

                    RankingFragment.ListarCancionesPorFiltro(Constante.ID_GENERO, String.valueOf(DialogIdiomaAdapter.getIdIdioma(position)));
                    dismiss();
                }
            });

        }

        if (var == com.kruma.kanta.entidad.Constante.SEARCHRESULTS_INGRESOS) {

            lstDialogIdioma.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                    Constante.ID_IDIOMA = String.valueOf(DialogIdiomaAdapter.getIdIdioma(position));
                    Constante.TXT_FILTRAR_IDIOMA = DialogIdiomaAdapter.getDescripcionIdioma(position);

                    IngresosFragment.ListarCancionesPorFiltro(Constante.ID_GENERO, String.valueOf(DialogIdiomaAdapter.getIdIdioma(position)));
                    dismiss();
                }
            });

        }

        if (var == com.kruma.kanta.entidad.Constante.SEARCHRESULTS_LISTA) {

            lstDialogIdioma.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                    Constante.ID_IDIOMA = String.valueOf(DialogIdiomaAdapter.getIdIdioma(position));
                    Constante.TXT_FILTRAR_IDIOMA = DialogIdiomaAdapter.getDescripcionIdioma(position);

                    ListaFragment.ListarCancionesPorFiltro(Constante.ID_GENERO, String.valueOf(DialogIdiomaAdapter.getIdIdioma(position)));
                    dismiss();
                }
            });


        }

        if (var == Constante.SEARCHRESULTS_LISTAR_CANCION_KARAOKES) {
            lstDialogIdioma.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                    Constante.ID_IDIOMA = String.valueOf(DialogIdiomaAdapter.getIdIdioma(position));
                    Constante.TXT_FILTRAR_IDIOMA = DialogIdiomaAdapter.getDescripcionIdioma(position);
                    ListarCancionKaraokeFragment.ListarCancionesPorFiltro(Constante.ID_GENERO, Constante.ID_IDIOMA, null);
                    dismiss();
                }
            });


        }
        if (var == Constante.SEARCHRESULTS_BUSCARCANCION) {
            lstDialogIdioma.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                    Constante.ID_IDIOMA = String.valueOf(DialogIdiomaAdapter.getIdIdioma(position));
                    Constante.TXT_FILTRAR_IDIOMA = DialogIdiomaAdapter.getDescripcionIdioma(position);
                    BuscarCancionFragment.ListarCancionesPorFiltro(Constante.ID_GENERO, Constante.ID_IDIOMA, null);
                    dismiss();
                }
            });

        }

    }

    private void CargarIdiomaLista() {

        com.kruma.kanta.logical.LocalCancion.ListarLista(
                //Integer.parseInt(Constante.ID_LOCAL),
                com.kruma.core.security.SecurityManager.getKeyInteger(Constante.SESSION_IDLOCAL),
                null, null,
                new ProcessCallback<List<LocalCancion>>() {
                    @Override
                    public void success(List<LocalCancion> obj_pResultado) {
                        dialogIdiomaAdapterCancion = new DialogIdiomaAdapterCancion(App.getContext(), obj_pResultado.getResult());
                        try {
                            lstDialogIdioma.setAdapter(dialogIdiomaAdapterCancion);
                        } catch (Exception ex) {
                            String a = "";
                        }
                    }

                    @Override
                    public void failure(ProcessResult obj_pResultado) {

                    }
                });
    }

    private void CargarIdiomaRanking() {

        com.kruma.kanta.logical.LocalCancion.ListarRanking(
                //Integer.parseInt(Constante.ID_LOCAL),
                com.kruma.core.security.SecurityManager.getKeyInteger(Constante.SESSION_IDLOCAL),
                null, null,
                new ProcessCallback<List<LocalCancion>>() {
                    @Override
                    public void success(List<LocalCancion> obj_pResultado) {

                        dialogIdiomaAdapterCancion = new DialogIdiomaAdapterCancion(App.getContext(), obj_pResultado.getResult());
                        try {
                            lstDialogIdioma.setAdapter(dialogIdiomaAdapterCancion);
                        } catch (Exception ex) {
                            String a = "";
                        }
                    }

                    @Override
                    public void failure(ProcessResult obj_pResultado) {

                    }
                });
    }

    private void CargarIdiomaNovedades() {

        com.kruma.kanta.logical.LocalCancion.ListarNovedades(
                //Integer.parseInt(Constante.ID_LOCAL),
                com.kruma.core.security.SecurityManager.getKeyInteger(Constante.SESSION_IDLOCAL),
                null, null,
                new ProcessCallback<List<LocalCancion>>() {
                    @Override
                    public void success(List<LocalCancion> obj_pResultado) {

                        dialogIdiomaAdapterCancion = new DialogIdiomaAdapterCancion(App.getContext(), obj_pResultado.getResult());
                        try {
                            lstDialogIdioma.setAdapter(dialogIdiomaAdapterCancion);
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
