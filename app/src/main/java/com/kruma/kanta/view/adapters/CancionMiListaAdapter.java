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
import com.kruma.kanta.entidad.AperturaCancion;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Enrique on 08/09/2016.
 */
public class CancionMiListaAdapter extends BaseAdapter {

    static AperturaCancion obj_pAperturaCancion;
    public static int id;
    private Context context;
    private static List<AperturaCancion> lsCancionMiListaEntities;

    public CancionMiListaAdapter(Context context, List<AperturaCancion> lsCancionMiListaEntities) {
        this.context = context;
        this.lsCancionMiListaEntities = lsCancionMiListaEntities;
    }

    @Override
    public int getCount() {
        return lsCancionMiListaEntities.size();
    }

    @Override
    public Object getItem(int position) {
        return lsCancionMiListaEntities.get(position);
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
            v = inflater.inflate(R.layout.row_mi_lista, null);

            CancionMiListaAdapter.ViewHolder holder = new CancionMiListaAdapter.ViewHolder();

            holder.txtCancion = (TextView) v.findViewById(R.id.txtCancion);
            holder.txtCantante = (TextView) v.findViewById(R.id.txtCantante);
            holder.txtGenero = (TextView) v.findViewById(R.id.txtGenero);
            holder.txtIdioma = (TextView) v.findViewById(R.id.txtIdioma);

            //Agregue esto
            holder.iviEstado = (ImageView) v.findViewById(R.id.ivEstado);
            holder.iviFoto = (ImageView) v.findViewById(R.id.ivAgregarCancion);
            // Activamos o seleccionamos los TextView para que
            // tengan la animacion de movimiento horizontal

            holder.txtCancion.setSelected(true);
            holder.txtCantante.setSelected(true);
            holder.txtGenero.setSelected(true);
            holder.txtIdioma.setSelected(true);

            v.setTag(holder);
        }

        AperturaCancion obj_pAperturaCancion = lsCancionMiListaEntities.get(position);

        if (obj_pAperturaCancion != null) {
            String str_Titulo = "";
            String str_Artista = "";
            String str_Genero = "";
            String str_Idioma = "";

            Integer int_IdAperturaCancionSolicitud = 0;
            Integer int_IdAperturaCancionTipo = 0;

            CancionMiListaAdapter.ViewHolder holder = (CancionMiListaAdapter.ViewHolder) v.getTag();

            str_Titulo = obj_pAperturaCancion.getLocalCancion().getCancion().getDescripcion();

            if (obj_pAperturaCancion.getLocalCancion().getArtista() != null)
                str_Artista = obj_pAperturaCancion.getLocalCancion().getArtista().getNombre();
            if (obj_pAperturaCancion.getLocalCancion().getGenero() != null)
                str_Genero = obj_pAperturaCancion.getLocalCancion().getGenero().getDescripcion();
            if (obj_pAperturaCancion.getLocalCancion().getIdioma() != null)
                str_Idioma = obj_pAperturaCancion.getLocalCancion().getIdioma().getDescripcion();

            if (obj_pAperturaCancion.getIdAperturaCancionTipo() != null)
                int_IdAperturaCancionTipo = obj_pAperturaCancion.getIdAperturaCancionTipo();

            if (obj_pAperturaCancion.getIdAperturaCancionSolicitud() != null)
                int_IdAperturaCancionSolicitud = obj_pAperturaCancion.getIdAperturaCancionSolicitud();

                /*
                holder.txtCancion.setBackgroundColor(holder.txtCancion.getContext().getResources().getColor(R.color.colorPrimaryLight));
                holder.txtCantante.setBackgroundColor(holder.txtCantante.getContext().getResources().getColor(R.color.colorPrimaryLight));
                holder.txtGenero.setBackgroundColor(holder.txtGenero.getContext().getResources().getColor(R.color.colorPrimaryLight));
                holder.txtIdioma.setBackgroundColor(holder.txtIdioma.getContext().getResources().getColor(R.color.colorPrimaryLight));
                */

                holder.txtCancion.setTextColor(holder.txtCancion.getContext().getResources().getColor(R.color.colorIcons));
                holder.txtCantante.setTextColor(holder.txtCantante.getContext().getResources().getColor(R.color.colorIcons));
                holder.txtGenero.setTextColor(holder.txtGenero.getContext().getResources().getColor(R.color.colorIcons));
                holder.txtIdioma.setTextColor(holder.txtIdioma.getContext().getResources().getColor(R.color.colorIcons));

                holder.txtCancion.setText(str_Titulo);
                holder.txtCantante.setText(str_Artista);
                holder.txtGenero.setText(str_Genero);
                holder.txtIdioma.setText(str_Idioma);





            if (int_IdAperturaCancionSolicitud == 1) {
                holder.iviEstado.setImageResource(R.drawable.iconocantar);
            } else {
                holder.iviEstado.setImageResource(R.drawable.iconoescuchar);
            }

            try{
                //obj_pLocalCancion.getAlbum().getImagenURL()!= null &&
                if( obj_pAperturaCancion.getAlbum() != null ){
                    try{
                        if(!obj_pAperturaCancion.getAlbum().getImagenURL().equals("")){
                            Picasso.with(App.getContext()).load(obj_pAperturaCancion.getAlbum().getImagenURL()).into(holder.iviFoto);
                        } else {
                            Picasso.with(App.getContext()).load(obj_pAperturaCancion.getArtista().getImagenURL()).into(holder.iviFoto);
                        }
                    } catch (Exception e){
                        holder.iviFoto.setImageResource(R.drawable.sinimagen);
                    }
                } else {
                    try{
                        Picasso.with(App.getContext()).load(obj_pAperturaCancion.getArtista().getImagenURL()).into(holder.iviFoto);

                    } catch (Exception e){
                        holder.iviFoto.setImageResource(R.drawable.sinimagen);
                    }
                }
            } catch (Exception e){
                holder.iviFoto.setImageResource(R.drawable.sinimagen);
            }
        }
        return v;
    }

    public static AperturaCancion getAperturaCancion(int pos) {
        return obj_pAperturaCancion = lsCancionMiListaEntities.get(pos);
    }

    public static int getIdAperturaCancion(int pos) {
        return id = lsCancionMiListaEntities.get(pos).getIdAperturaCancion();
    }

    static class ViewHolder {
        TextView txtCancion;
        TextView txtCantante;
        TextView txtGenero;
        TextView txtIdioma;
        ImageView iviEstado;
        ImageView iviFoto;
    }
}
