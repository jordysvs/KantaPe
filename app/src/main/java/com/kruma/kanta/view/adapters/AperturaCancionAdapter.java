package com.kruma.kanta.view.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.kruma.kanta.R;
import com.kruma.kanta.entidad.AperturaCancion;

import java.util.List;

/**
 * Created by Enrique  on 01/08/2016.
 */
public class AperturaCancionAdapter extends BaseAdapter {

    static AperturaCancion obj_pAperturaCancion;

    private Context context;
    private static List<AperturaCancion> lsAperturaCancionEntities;


    public AperturaCancionAdapter(Context context, List<AperturaCancion> lsAperturaCancionEntities) {
        this.context = context;
        this.lsAperturaCancionEntities = lsAperturaCancionEntities;
    }

    @Override
    public int getCount() {
        return lsAperturaCancionEntities.size();
    }

    @Override
    public Object getItem(int position) {
        return lsAperturaCancionEntities.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (v == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            v = inflater.inflate(R.layout.row_cancion, null);
            ViewHolder holder = new ViewHolder();

            holder.txtCancion = (TextView) v.findViewById(R.id.txtCancion);
            holder.txtCantante = (TextView) v.findViewById(R.id.txtCantante);
            holder.txtGenero = (TextView) v.findViewById(R.id.txtGenero);
            holder.txtIdioma = (TextView) v.findViewById(R.id.txtIdioma);

            // Activamos o seleccionamos los TextView para que
            // tengan la animacion de movimiento horizontal
            holder.txtCancion.setSelected(true);
            holder.txtCantante.setSelected(true);
            holder.txtGenero.setSelected(true);
            holder.txtIdioma.setSelected(true);

            v.setTag(holder);
        }

        obj_pAperturaCancion = lsAperturaCancionEntities.get(position);

        if (obj_pAperturaCancion != null) {

            ViewHolder holder = (ViewHolder) v.getTag();

            holder.txtCancion.setText(obj_pAperturaCancion.getIdLocalCancion());
            holder.txtCantante.setText(obj_pAperturaCancion.getIdUsuario());
            holder.txtGenero.setText(obj_pAperturaCancion.getLocalCancion().getGenero().getDescripcion());
            holder.txtIdioma.setText(obj_pAperturaCancion.getLocalCancion().getIdioma().getDescripcion());
        }

        return v;
    }

    public static AperturaCancion getAperturaCancion(int pos) {
        return obj_pAperturaCancion = lsAperturaCancionEntities.get(pos);
    }

    static class ViewHolder {
        TextView txtCancion;
        TextView txtCantante;
        TextView txtGenero;
        TextView txtIdioma;

    }

}
