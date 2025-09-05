package com.kruma.kanta;

import android.Manifest;
import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.kruma.core.configuration.App;
import com.kruma.core.util.common.List;
import com.kruma.core.util.common.ProcessCallback;
import com.kruma.core.util.common.ProcessResult;
import com.kruma.kanta.entidad.Apertura;
import com.kruma.kanta.entidad.AperturaUsuario;
import com.kruma.kanta.entidad.Constante;
import com.kruma.kanta.entidad.Local;
import com.kruma.kanta.entidad.Ubicacion;
import com.kruma.kanta.view.activity.RespuestaAperturaActivity;
import com.kruma.kanta.view.activity.RespuestaAperturaAdministradorActivity;
import com.kruma.kanta.view.adapters.KaraokesAdapter;

//import com.google.android.gms.common.api.GoogleApiClient;

/**
 * Created by JORDY on 09/11/2017.
 */

public class CancioneroActivity extends Activity {

    private static KaraokesAdapter karaokesAdapter;
    private static ListView lstCancionero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancionero);

        //String str_IdLocalCancion = getIntent().getStringExtra("IdLocalCancion");
        //Integer.valueOf(IdLocalCancion);
        //int IdLocalCancion = Integer.parseInt(str_IdLocalCancion);

        lstCancionero = (ListView) findViewById(R.id.lstCancionero);
        lstCancionero.setOnItemClickListener(onItemClickListener);
        cargarCancionero();
    }


    private void cargarCancionero() {

        com.kruma.kanta.logical.Local.ListarLocal(com.kruma.core.security.SecurityManager.getKeyInteger(Constante.SESSION_IDLOCAL_CANCION), null, null, null, null,
                new ProcessCallback<List<Local>>() {
                    @Override
                    public void success(com.kruma.core.util.common.List<Local> obj_pResultado) {

                        karaokesAdapter = new KaraokesAdapter(App.getContext(), obj_pResultado.getResult());
                        lstCancionero.setAdapter(karaokesAdapter);

                    }

                    @Override
                    public void failure(ProcessResult obj_pResultado) {

                    }
                });
    }


    private AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            Integer Id_Karaoke = KaraokesAdapter.getIdLocal(position);
            String NombreLocal = KaraokesAdapter.getNombre(position);

            com.kruma.core.security.SecurityManager.setKey(Constante.SESSION_IDKARAOKE,  String.valueOf(Id_Karaoke));
            com.kruma.core.security.SecurityManager.setKey(Constante.SESSION_NOMBREKARAOKE, NombreLocal);
            Intent intent = new Intent(App.getContext(), KaraokesActivity.class);
            startActivity(intent);

        }
    };


}
