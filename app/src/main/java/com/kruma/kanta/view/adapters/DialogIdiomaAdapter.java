package com.kruma.kanta.view.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.kruma.kanta.R;
import com.kruma.kanta.entidad.Idioma;

import java.util.List;

/**
 * Created by Carlos Gomez on 28/10/2016.
 */

public class DialogIdiomaAdapter extends BaseAdapter {

    private Context context;
    private static List<Idioma> lsIdiomaEntities;
    public static int id;
    public static String desc;

    public DialogIdiomaAdapter(Context context, List<Idioma> lsIdiomaEntities) {
        this.context = context;
        this.lsIdiomaEntities = lsIdiomaEntities;
    }

    @Override
    public int getCount() {
        return lsIdiomaEntities.size();
    }

    @Override
    public Object getItem(int i) {
        return lsIdiomaEntities.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        View v = view;

        if (v == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            v = inflater.inflate(R.layout.row_dialog_idioma, null);
            ViewHolder holder = new ViewHolder();

            holder.txtIdioma = (TextView) v.findViewById(R.id.txtIdiomaDialog);
            v.setTag(holder);
        }

        Idioma obj_pIdioma = lsIdiomaEntities.get(position);

        if (obj_pIdioma != null) {

            ViewHolder holder = (ViewHolder) v.getTag();
            holder.txtIdioma.setText(obj_pIdioma.getDescripcion());
        }

        return v;
    }

    public static int getIdIdioma (int pos){
        return id = lsIdiomaEntities.get(pos).getIdIdioma();
    }

    public static String getDescripcionIdioma (int pos){
        return desc = lsIdiomaEntities.get(pos).getDescripcion();
    }

    static class ViewHolder {
        TextView txtIdioma;
    }
}
