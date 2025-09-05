package com.kruma.kanta.view.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.kruma.kanta.R;
import com.kruma.kanta.entidad.LocalCancion;

import java.util.List;

/**
 * Created by Jordy  on 05/04/2016.
 */
public class DialogIdiomaAdapterCancion extends BaseAdapter {

    static LocalCancion obj_pLocalCancion;
    private Context context;
    public static int id;
    public static int int_gIdLocalCancion;
    public static String desc;
    private static List<LocalCancion> lsCancionEntities;

    public DialogIdiomaAdapterCancion(Context context, List<LocalCancion> lsCancionEntities) {
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
            v = inflater.inflate(R.layout.row_dialog_idioma, null);
            ViewHolder holder = new ViewHolder();

            holder.txtIdioma = (TextView) v.findViewById(R.id.txtIdiomaDialog);
            v.setTag(holder);
        }

        obj_pLocalCancion = lsCancionEntities.get(position);

        if (obj_pLocalCancion != null) {

            ViewHolder holder = (ViewHolder) v.getTag();

            holder.txtIdioma.setText(obj_pLocalCancion.getIdioma().getDescripcion());

        }

        return v;
    }

    public static LocalCancion getLocalCancion(int pos) {

        return obj_pLocalCancion = lsCancionEntities.get(pos);

    }

    static class ViewHolder {

        TextView txtIdioma;

    }
    public static int getIdIdioma (int pos){
        return id = lsCancionEntities.get(pos).getIdIdioma();
    }

    public static String getDescripcionIdioma (int pos){
        return desc = lsCancionEntities.get(pos).getIdioma().getDescripcion();
    }
    public void addListItemToAdapter(List<LocalCancion> list) {
        lsCancionEntities.addAll(list);
        this.notifyDataSetChanged();
    }
}


//android:src="@drawable/gustavocerati"