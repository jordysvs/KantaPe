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
 * Created by Enrique on 05/09/2016.
 */
public class CartaAdapter extends BaseAdapter {

    static Carta obj_pCarta;
    private Context context;

    private List<Carta> lsCartaEntities;

    public CartaAdapter(Context context, List<Carta> lsCartaEntities) {
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
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (v == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            v = inflater.inflate(R.layout.row_carta, null);
            ViewHolder holder = new ViewHolder();

            holder.txtNombre = (TextView) v.findViewById(R.id.txtNombre);
            holder.txtPrecio = (TextView) v.findViewById(R.id.txtPrecio);
            holder.iviFoto = (ImageView) v.findViewById(R.id.iviFoto);

            // Activamos o seleccionamos los TextView para que
            // tengan la animacion de movimiento horizontal
            holder.txtNombre.setSelected(true);

            v.setTag(holder);
        }

         obj_pCarta = lsCartaEntities.get(position);

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
                //Toast.makeText(App.getContext(), ex.getMessage(), Toast.LENGTH_SHORT).show();
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
