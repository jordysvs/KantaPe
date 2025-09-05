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
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Jordy  on 05/04/2016.
 */
public class BuscarCancionesAdapter extends BaseAdapter {

    static LocalCancion obj_pLocalCancion;
    private Context context;
    public static int id;
    public static int idLocal;
    private static List<LocalCancion> lsBuscarCancionEntities;

    public BuscarCancionesAdapter(Context context, List<LocalCancion> lsBuscarCancionEntities) {
        this.context = context;
        this.lsBuscarCancionEntities = lsBuscarCancionEntities;
    }

    @Override
    public int getCount() {
        return lsBuscarCancionEntities.size();
    }

    @Override
    public Object getItem(int position) {
        return lsBuscarCancionEntities.get(position);
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
            v = inflater.inflate(R.layout.row_buscar_cancion, null);
            ViewHolder holder = new ViewHolder();

            holder.txtCancion = (TextView) v.findViewById(R.id.txtCancion);
            holder.txtCantante = (TextView) v.findViewById(R.id.txtCantante);
            holder.txtGenero = (TextView) v.findViewById(R.id.txtGenero);
            holder.txtIdioma = (TextView) v.findViewById(R.id.txtIdioma);


            holder.ivAgregarCancion = (ImageView) v.findViewById(R.id.ivAgregarCancion);

            // Activamos o seleccionamos los TextView para que
            // tengan la animacion de movimiento horizontal
            holder.txtCancion.setSelected(true);
            holder.txtCantante.setSelected(true);
            holder.txtGenero.setSelected(true);
            holder.txtIdioma.setSelected(true);

            v.setTag(holder);
        }

        obj_pLocalCancion = lsBuscarCancionEntities.get(position);

        if (obj_pLocalCancion != null) {

            ViewHolder holder = (ViewHolder) v.getTag();

            holder.txtCancion.setText(obj_pLocalCancion.getCancion().getDescripcion());
            holder.txtCantante.setText(obj_pLocalCancion.getArtista().getNombre());
            holder.txtGenero.setText(obj_pLocalCancion.getGenero().getDescripcion());
            holder.txtIdioma.setText(obj_pLocalCancion.getIdioma().getDescripcion());


            try{
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

        return obj_pLocalCancion = lsBuscarCancionEntities.get(pos);

    }


    public static int getIdCancion(int pos) {
        return idLocal = lsBuscarCancionEntities.get(pos).getIdCancion();
    }

    static class ViewHolder {
        TextView txtCancion;
        TextView txtCantante;
        TextView txtGenero;
        TextView txtIdioma;

        ImageView ivAgregarCancion;
    }

    public void addListItemToAdapter(List<LocalCancion> list) {
        lsBuscarCancionEntities.addAll(list);
        this.notifyDataSetChanged();
    }
}


//android:src="@drawable/gustavocerati"