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
import com.kruma.core.util.common.List;
import com.kruma.core.util.common.ProcessCallback;
import com.kruma.core.util.common.ProcessResult;
import com.kruma.kanta.R;
import com.kruma.kanta.entidad.Constante;
import com.kruma.kanta.entidad.GeneroMusical;
import com.kruma.kanta.entidad.LocalCancion;
import com.kruma.kanta.entidad.Pais;
import com.kruma.kanta.view.adapters.DialogPaisAdapter;
import com.kruma.kanta.view.storage.Cheeses;

/**
 * Created by Enrique on 04/09/2016.
 */
public class KaraokesPaisDialogFragment extends DialogFragment {

    ImageView iviAceptar;
    ImageView iviCancelar;
    static int var = 0;
    private ListView lstDialogPais;

    private DialogPaisAdapter dialogPaisAdapter;


    // 1. Origen de datos
    private String[] mStrings = Cheeses.sCheeseStrings;

    public KaraokesPaisDialogFragment() {
    }


    public static KaraokesPaisDialogFragment newInstance(String titulo) {

        KaraokesPaisDialogFragment frag = new KaraokesPaisDialogFragment();
        Bundle args = new Bundle();
        args.putString("titulo", titulo);
        frag.setArguments(args);
        return frag;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_fragment_karaokes_pais, container);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String tituloDialog = getArguments().getString("titulo", "Elegir pais");
        getDialog().setTitle(tituloDialog);
        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_MODE_CHANGED);

        // 2. View: ListView, GridView, Spinner
        lstDialogPais = (ListView) getView().findViewById(R.id.lstDialogPais);




        com.kruma.kanta.logical.Local.ListarPais(
                new ProcessCallback<List<Pais>>() {

                    @Override
                    public void success(List<Pais> obj_pResultado) {
                        dialogPaisAdapter = new DialogPaisAdapter(App.getContext(), obj_pResultado.getResult());
                        lstDialogPais.setAdapter(dialogPaisAdapter);
                    }

                    @Override
                    public void failure(ProcessResult obj_pResultado) {

                    }
                });



        if (var == Constante.SEARCHRESULTS_KARAOKES) {

            lstDialogPais.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override

                public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                    Constante.TXT_FILTRAR_PAIS = DialogPaisAdapter.getDescripcionPais(position);
                    Constante.ID_PAIS = String.valueOf(DialogPaisAdapter.getIdPais(position));
                    KaraokesFragment.ListarKaraoke(Constante.ID_PAIS,null);
                    dismiss();
                }
            });
        }
    }

    public static void ToPrint(int i) {
        var = i;
    }
}
