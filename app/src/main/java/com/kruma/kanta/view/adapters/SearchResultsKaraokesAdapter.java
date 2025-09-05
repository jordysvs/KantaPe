package com.kruma.kanta.view.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.kruma.core.configuration.App;
import com.kruma.kanta.R;
import com.kruma.kanta.entidad.Local;
import com.kruma.kanta.entidad.LocalCancion;
import com.kruma.kanta.entidad.Pais;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Carlos Gomez   on 26/10/2016.
 */

public class SearchResultsKaraokesAdapter extends BaseAdapter {

    static Local obj_pLocal;
    private Context context;
    public static int id;
    private static List<Local> lsLocalEntities;

    public SearchResultsKaraokesAdapter(Context context, List<Local> lsLocalEntities) {
        this.context = context;
        this.lsLocalEntities = lsLocalEntities;
    }

    @Override
    public int getCount() {
        return lsLocalEntities.size();
    }

    @Override
    public Object getItem(int position) {
        return lsLocalEntities.get(position);
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
            v = inflater.inflate(R.layout.row_karaokes, null);
            ViewHolder holder = new ViewHolder();

            holder.txtNombre = (TextView) v.findViewById(R.id.txtNombre);
            holder.txtDireccion = (TextView) v.findViewById(R.id.txtDireccion);
            holder.iviFoto = (ImageView) v.findViewById(R.id.iviFoto);

            // Activamos o seleccionamos los TextView para que
            // tengan la animacion de movimiento horizontal
            holder.txtNombre.setSelected(true);
            holder.txtDireccion.setSelected(true);

            v.setTag(holder);
        }

        obj_pLocal = lsLocalEntities.get(position);

        if (obj_pLocal != null) {

            ViewHolder holder = (ViewHolder) v.getTag();

            holder.txtNombre.setText(obj_pLocal.getNombre());
            holder.txtDireccion.setText(obj_pLocal.getDireccion());



            try {
                if (obj_pLocal.getImagenURL() == null) {
                    holder.iviFoto.setImageResource(R.drawable.sinimagen);
                } else
                    Picasso.with(App.getContext()).load(obj_pLocal.getImagenURL()).into(holder.iviFoto);
            }

            catch (Exception ex) {
                holder.iviFoto.setImageResource(R.drawable.sinimagen);
            }
        }
        return v;
    }

    public static int getIdLocal(int pos) {
        return id = lsLocalEntities.get(pos).getIdLocal();
    }

    static class ViewHolder {
        TextView txtNombre;
        TextView txtDireccion;
        ImageView iviFoto;
    }
}
