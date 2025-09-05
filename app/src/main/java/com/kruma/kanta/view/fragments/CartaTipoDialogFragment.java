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
import com.kruma.kanta.entidad.ProductoTipo;
import com.kruma.kanta.view.adapters.DialogProductoTipoAdapter;

/**
 * Created by Enrique on 05/09/2016.
 */
public class CartaTipoDialogFragment extends DialogFragment {

    Button btnAceptar;
    Button btnCancelar;
    private ListView lstDialogProductoTipo;
    private DialogProductoTipoAdapter dialogProductoTipoAdapter;

    public CartaTipoDialogFragment() {
    }

    public static CartaTipoDialogFragment newInstance(String titulo) {
        CartaTipoDialogFragment frag = new CartaTipoDialogFragment();
        Bundle args = new Bundle();
        args.putString("titulo", titulo);
        frag.setArguments(args);
        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_fragment_carta_tipo, container);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String tituloDialog = getArguments().getString("titulo", "Elegir tipo");
        getDialog().setTitle(tituloDialog);
        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_MODE_CHANGED);

        lstDialogProductoTipo = (ListView) getView().findViewById(R.id.lstDialogCartaTipo);

        com.kruma.kanta.logical.ProductoTipo.ListarProductoTipo(
                new ProcessCallback<List<ProductoTipo>>() {
                    @Override
                    public void success(List<ProductoTipo> obj_pResultado) {
                        dialogProductoTipoAdapter = new DialogProductoTipoAdapter(App.getContext(), obj_pResultado.getResult());
                        lstDialogProductoTipo.setAdapter(dialogProductoTipoAdapter);
                    }

                    @Override
                    public void failure(ProcessResult obj_pResultado) {

                    }
                });

        lstDialogProductoTipo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                //Llenar la constante para l filtro
                Constante.ID_PRODUCTO_TIPO = String.valueOf(DialogProductoTipoAdapter.getIdProductoTipo(position));

                Constante.TXT_FILTRO_BEBIDA_PIQUEO = position + 1 ;

                TragosFragment.ListarCartaPorFiltro( String.valueOf(DialogProductoTipoAdapter.getIdProductoTipo(position)), null);
                dismiss();
            }
        });
    }
}
