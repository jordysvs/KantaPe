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
import com.kruma.kanta.entidad.Carta;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Carlos Gomez on 28/10/2016.
 */

public class SearchResultsCartaAdapter extends BaseAdapter {

    private Context context;
    private List<Carta> lsCartaEntities;

    public SearchResultsCartaAdapter(Context context, List<Carta> lsCartaEntities) {
        this.context = context;
        this.lsCartaEntities = lsCartaEntities;
    }

    @Override
    public int getCount() {
        return lsCartaEntities.size();
    }

    @Override
    public Object getItem(int position) {
        return lsCartaEntities.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {

        View v = convertView;

        if (v == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            v = inflater.inflate(R.layout.row_carta, null);
            ViewHolder holder = new ViewHolder();

            holder.txtNombre = (TextView) v.findViewById(R.id.txtNombre);
            holder.txtPrecio = (TextView) v.findViewById(R.id.txtPrecio);
            holder.iviFoto = (ImageView) v.findViewById(R.id.iviFoto);

            v.setTag(holder);
        }

        Carta obj_pCarta = lsCartaEntities.get(position);

        if (obj_pCarta != null) {

            ViewHolder holder = (ViewHolder) v.getTag();

            holder.txtNombre.setText(obj_pCarta.getNombre());
            holder.txtPrecio.setText("S/." + String.valueOf(obj_pCarta.getPrecio()));

            try {
                if (obj_pCarta.getImagenURL() == null) {
                    holder.iviFoto.setImageResource(R.drawable.sinimagen);
                } else
                    Picasso.with(App.getContext()).load(obj_pCarta.getImagenURL()).into(holder.iviFoto);
            }

            catch (Exception ex) {
                holder.iviFoto.setImageResource(R.drawable.sinimagen);
            }

        }

        return v;

    }

    static class ViewHolder {
        TextView txtNombre;
        TextView txtPrecio;

        ImageView iviFoto;
    }
}
