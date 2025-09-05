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
import com.kruma.kanta.entidad.LocalCancion;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Carlos Gomez   on 26/10/2016.
 */

public class SearchResultsCancionesAdapter extends BaseAdapter {

    static LocalCancion obj_pLocalCancion;

    private Context context;
    private static List<LocalCancion> lsCancionEntities;

    public SearchResultsCancionesAdapter(Context context, List<LocalCancion> lsCancionEntities) {
        this.context = context;
        this.lsCancionEntities = lsCancionEntities;
    }

    @Override
    public int getCount() {
        return lsCancionEntities.size();
    }

    @Override
    public Object getItem(int position) {
        return lsCancionEntities.get(position);
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
            v = inflater.inflate(R.layout.row_cancion, null);
            ViewHolder holder = new ViewHolder();

            holder.txtCancion = (TextView) v.findViewById(R.id.txtCancion);
            holder.txtCantante = (TextView) v.findViewById(R.id.txtCantante);
            holder.txtGenero = (TextView) v.findViewById(R.id.txtGenero);
            holder.txtIdioma = (TextView) v.findViewById(R.id.txtIdioma);

            holder.ivAgregarCancion = (ImageView) v.findViewById(R.id.ivAgregarCancion);

            v.setTag(holder);
        }

        obj_pLocalCancion = lsCancionEntities.get(position);

        if (obj_pLocalCancion != null) {

            ViewHolder holder = (ViewHolder) v.getTag();

            holder.txtCancion.setText(obj_pLocalCancion.getCancion().getDescripcion());
            holder.txtCantante.setText(obj_pLocalCancion.getArtista().getNombre());
            holder.txtGenero.setText(obj_pLocalCancion.getGenero().getDescripcion());
            holder.txtIdioma.setText(obj_pLocalCancion.getIdioma().getDescripcion());

            try{
                //obj_pLocalCancion.getAlbum().getImagenURL()!= null &&
                if( obj_pLocalCancion.getAlbum() != null ){
                    try{
                        if(!obj_pLocalCancion.getAlbum().getImagenURL().equals("")){
                            Picasso.with(App.getContext()).load(obj_pLocalCancion.getAlbum().getImagenURL()).into(holder.ivAgregarCancion);
                        } else {
                            Picasso.with(App.getContext()).load(obj_pLocalCancion.getArtista().getImagenURL()).into(holder.ivAgregarCancion);
                        }
                    } catch (Exception e){
                        holder.ivAgregarCancion.setImageResource(R.drawable.sinimagen);
                    }
                } else {
                    try{
                        Picasso.with(App.getContext()).load(obj_pLocalCancion.getArtista().getImagenURL()).into(holder.ivAgregarCancion);

                    } catch (Exception e){
                        holder.ivAgregarCancion.setImageResource(R.drawable.sinimagen);
                    }
                }
            } catch (Exception e){
                holder.ivAgregarCancion.setImageResource(R.drawable.sinimagen);
            }

        }

        return v;
    }

    public static LocalCancion getLocalCancion(int pos) {
        return obj_pLocalCancion = lsCancionEntities.get(pos);
    }

    static class ViewHolder {
        TextView txtCancion;
        TextView txtCantante;
        TextView txtGenero;
        TextView txtIdioma;

        ImageView ivAgregarCancion;

    }
}
