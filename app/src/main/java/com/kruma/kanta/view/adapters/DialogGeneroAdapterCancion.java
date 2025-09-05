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
 * Created by Jordy  on 05/04/2016.
 */
public class DialogGeneroAdapterCancion extends BaseAdapter {

    static LocalCancion obj_pLocalCancion;
    private Context context;
    public static int id;
    public static int int_gIdLocalCancion;
    public static String desc;
    private static List<LocalCancion> lsCancionEntities;

    public DialogGeneroAdapterCancion(Context context, List<LocalCancion> lsCancionEntities) {
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
            v = inflater.inflate(R.layout.row_dialog_genero, null);
            ViewHolder holder = new ViewHolder();

            holder.txtGenero = (TextView) v.findViewById(R.id.txtGeneroDialog);
            v.setTag(holder);
        }

        obj_pLocalCancion = lsCancionEntities.get(position);

        if (obj_pLocalCancion != null) {

            ViewHolder holder = (ViewHolder) v.getTag();

            //for (int i = 0; i <= obj_pLocalCancion.getGenero().getIdGenero(); i++) {
                holder.txtGenero.setText(obj_pLocalCancion.getGenero().getDescripcion());
            //}
        }

        return v;
    }

    public static LocalCancion getLocalCancion(int pos) {

        return obj_pLocalCancion = lsCancionEntities.get(pos);

    }

    static class ViewHolder {

        TextView txtGenero;

    }
    public static int getIdGeneroMusical (int pos){
        return id = lsCancionEntities.get(pos).getIdGenero();
    }

    public static String getDescripcionGeneroMusical (int pos){
        return desc = lsCancionEntities.get(pos).getGenero().getDescripcion();
    }
    public void addListItemToAdapter(List<LocalCancion> list) {
        lsCancionEntities.addAll(list);
        this.notifyDataSetChanged();
    }
}


//android:src="@drawable/gustavocerati"