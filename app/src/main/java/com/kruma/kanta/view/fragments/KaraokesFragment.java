package com.kruma.kanta.view.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.kruma.core.configuration.App;
import com.kruma.core.util.common.List;
import com.kruma.core.util.common.ProcessCallback;
import com.kruma.core.util.common.ProcessResult;
import com.kruma.kanta.KaraokesActivity;
import com.kruma.kanta.MainActivity;
import com.kruma.kanta.OnNavigationListener;
import com.kruma.kanta.R;
import com.kruma.kanta.entidad.AperturaUsuario;
import com.kruma.kanta.entidad.Constante;
import com.kruma.kanta.entidad.Local;
import com.kruma.kanta.view.activity.SearchResultsActivity;
import com.kruma.kanta.view.adapters.CancionesAdapter;
import com.kruma.kanta.view.adapters.KaraokesAdapter;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

public class KaraokesFragment extends Fragment {

    private OnNavigationListener mListener;
    private static TextView txtFiltroPaisKaraokes;
    private static KaraokesAdapter karaokesAdapter;
    private static ListView lstKaraoke;
    public static ProgressBar mProgressBar;

    public KaraokesFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        KaraokesPaisDialogFragment.ToPrint(com.kruma.kanta.entidad.Constante.SEARCHRESULTS_KARAOKES);

        return inflater.inflate(R.layout.fragment_karaokes, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnNavigationListener) {
            mListener = (OnNavigationListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("KARAOKES");
        ((MainActivity) getActivity()).getSupportActionBar().setSubtitle("");

        mProgressBar = (ProgressBar) getActivity().findViewById(R.id.progress_bar);

        lstKaraoke = (ListView) getView().findViewById(R.id.lstKaraokes);
        txtFiltroPaisKaraokes = (TextView) getView().findViewById(R.id.txtFiltroKaraoke);

        Constante.TXT_FILTRAR_PAIS = null;
        Constante.ID_PAIS = null;
        ListarKaraoke(null, null);
        lstKaraoke.setOnItemClickListener(onItemClickListener);
    }

    private AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Integer IdLocal = KaraokesAdapter.getIdLocal(position);
            String NombreLocal = KaraokesAdapter.getNombre(position);
            com.kruma.core.security.SecurityManager.setKey(Constante.SESSION_IDKARAOKE, String.valueOf(IdLocal));
            com.kruma.core.security.SecurityManager.setKey(Constante.SESSION_NOMBREKARAOKE, NombreLocal);

            Intent intent = new Intent(App.getContext(), KaraokesActivity.class);
            startActivity(intent);
        }
    };

    public static void ListarKaraoke(
            final String str_pIdPais,
            final String str_pPalabraClave) {

        mProgressBar.setVisibility(View.VISIBLE);

        Integer int_IdPais = null;
        if (str_pIdPais != null)
            if (str_pIdPais != "")
                int_IdPais = Integer.parseInt(str_pIdPais);

        com.kruma.kanta.logical.Local.ListarLocal(
                null, int_IdPais, str_pPalabraClave, null, null,
                new ProcessCallback<List<Local>>() {
                    @Override
                    public void success(com.kruma.core.util.common.List<Local> obj_pResultado) {
                        karaokesAdapter = new KaraokesAdapter(App.getContext(), obj_pResultado.getResult());
                        lstKaraoke.setAdapter(karaokesAdapter);
                        if (Constante.TXT_FILTRAR_PAIS != null) {
                            if (!Constante.TXT_FILTRAR_PAIS.equals("")) {
                                txtFiltroPaisKaraokes.setText("Pais  : " + Constante.TXT_FILTRAR_PAIS);
                            }
                        }
                        mProgressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void failure(ProcessResult obj_pResultado) {
                        mProgressBar.setVisibility(View.GONE);
                    }
                });
    }
}
