package com.kruma.kanta.view.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kruma.kanta.R;


/**
 * Created by JORDY on 19/01/2017.
 */

public class HeaderActivity extends Fragment {


    //Para el header

    public TextView txtMiUsuarioLogeadoHeader;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.nav_header, container, false);



 //   @Override
   // protected void onCreate(Bundle savedInstanceState) {
     //   super.onCreate(savedInstanceState);
       // setContentView(R.layout.nav_header);
//

       txtMiUsuarioLogeadoHeader = (TextView) view.findViewById(R.id.txtMiUsuarioLogin);


        //txtMiUsuarioLogeadoHeader.setText(Constante.TXT_USUARIO_LOGEADO);
        txtMiUsuarioLogeadoHeader.setText(com.kruma.core.security.SecurityManager.getUsuario());

        return view;

    }


   // public void pintarTexto(String texto) {

        //TextView txtMiUsuarioLogeadoHeader;

//        txtMiUsuarioLogeadoHeader = (TextView)findViewById(R.id.txtMiUsuarioLogin);

  //      txtMiUsuarioLogeadoHeader.setText(texto);
    //}


}
