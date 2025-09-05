package com.kruma.kanta.view.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.kruma.kanta.R;
import com.kruma.kanta.entidad.AperturaCancionSolicitud;

import java.util.List;

/**
 * Created by Carlos Gomez on 31/10/2016.
 */

public class DialogAperturaCancionSolicitudAdapter extends BaseAdapter {

    private Context context;
    private static List<AperturaCancionSolicitud> lsAperturaCancionSolicitudEntities;
    public static int id;
    public static String desc;

    public DialogAperturaCancionSolicitudAdapter(Context context, List<AperturaCancionSolicitud> lsAperturaCancionSolicitudEntities) {
        this.context = context;
        this.lsAperturaCancionSolicitudEntities = lsAperturaCancionSolicitudEntities;
    }

    @Override
    public int getCount() {
        return lsAperturaCancionSolicitudEntities.size();
    }

    @Override
    public Object getItem(int position) {
        return lsAperturaCancionSolicitudEntities.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        View v = view;

        if (v == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            v = inflater.inflate(R.layout.row_dialog_apertura_cancion_solicitud, null);
            ViewHolder holder = new ViewHolder();

            holder.txtAperturaCancionSolicitud = (ImageView) v.findViewById(R.id.txtAperturaCancionSolicitudDialog);
            holder.txtDescripcionAperturaCancion = (TextView) v.findViewById(R.id.txtDescripcionAperturaCancion);

            v.setTag(holder);
        }

        AperturaCancionSolicitud obj_pAperturaCancionSolicitud = lsAperturaCancionSolicitudEntities.get(position);

        if (obj_pAperturaCancionSolicitud != null) {

            ViewHolder holder = (ViewHolder) v.getTag();

            if(obj_pAperturaCancionSolicitud.getIdAperturaCancionSolicitud()==1)
            {
                holder.txtAperturaCancionSolicitud.setImageResource(R.drawable.iconocantar);
                holder.txtDescripcionAperturaCancion.setText("PARA CANTAR");
            } else {
                holder.txtAperturaCancionSolicitud.setImageResource(R.drawable.iconoescuchar);
                holder.txtDescripcionAperturaCancion.setText("PARA ESCUCHAR");
            }

        }

        return v;

    }

    public static int getIdAperturaCancionSolicitud (int pos){
        return id = lsAperturaCancionSolicitudEntities.get(pos).getIdAperturaCancionSolicitud();
    }

    public static String getDescripcionAperturaCancionSolicitud (int pos){
        return desc = lsAperturaCancionSolicitudEntities.get(pos).getDescripcion();
    }

    static class ViewHolder {
        ImageView txtAperturaCancionSolicitud;
        TextView txtDescripcionAperturaCancion;
    }

}
