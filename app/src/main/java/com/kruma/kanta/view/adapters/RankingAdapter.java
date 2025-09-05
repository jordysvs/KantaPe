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
 * Created by Enrique  on 01/08/2016.
 */
public class RankingAdapter extends BaseAdapter {

    static LocalCancion obj_pLocalCancion;

    private Context context;
    public static int idcancion;
    public static int idLocalCancion;
    private static List<LocalCancion> lsCancionEntities;


    public RankingAdapter(Context context, List<LocalCancion> lsCancionEntities) {
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


            holder.txtIdLocalCancion = (TextView) v.findViewById(R.id.txtIdLocalCancionRow);

            holder.txtCancion = (TextView) v.findViewById(R.id.txtCancion);
            holder.txtCantante = (TextView) v.findViewById(R.id.txtCantante);
            holder.txtGenero = (TextView) v.findViewById(R.id.txtGenero);
            holder.txtIdioma = (TextView) v.findViewById(R.id.txtIdioma);

            holder.ivAgregarCancion = (ImageView) v.findViewById(R.id.ivAgregarCancion);

            // Activamos o seleccionamos los TextView para que
            // tengan la animacion de movimiento horizontal

            holder.txtIdLocalCancion.setSelected(true);
            holder.txtCancion.setSelected(true);
            holder.txtCantante.setSelected(true);
            holder.txtGenero.setSelected(true);
            holder.txtIdioma.setSelected(true);


            v.setTag(holder);
        }

        obj_pLocalCancion = lsCancionEntities.get(position);

        if (obj_pLocalCancion != null) {

            ViewHolder holder = (ViewHolder) v.getTag();


            holder.txtIdLocalCancion.setText(obj_pLocalCancion.getCancion().getDescripcion());

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

    public static int getIdCancion(int pos) {
        return idcancion = lsCancionEntities.get(pos).getIdCancion();
    }


    public static int getIdLocalCancion(int pos) {
        return idLocalCancion = lsCancionEntities.get(pos).getIdLocalCancion();
    }



    static class ViewHolder {
        TextView txtIdLocalCancion;
        TextView txtCancion;
        TextView txtCantante;
        TextView txtGenero;
        TextView txtIdioma;
        ImageView ivAgregarCancion;
    }
}
