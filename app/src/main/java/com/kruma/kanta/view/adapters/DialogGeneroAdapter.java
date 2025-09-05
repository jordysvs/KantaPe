package com.kruma.kanta.view.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.kruma.kanta.R;
import com.kruma.kanta.entidad.GeneroMusical;

import java.util.List;

/**
 * Created by Carlos Gomez on 14/10/2016.
 */

public class DialogGeneroAdapter extends BaseAdapter {

    private Context context;
    private static List<GeneroMusical> lsGeneroMusicalEntities;
    public static int id;
    public static String desc;

    public DialogGeneroAdapter(Context context, List<GeneroMusical> lsGeneroMusicalEntities) {
        this.context = context;
        this.lsGeneroMusicalEntities = lsGeneroMusicalEntities;
    }

    public DialogGeneroAdapter() {

    }

    @Override
    public int getCount() {
        return lsGeneroMusicalEntities.size();
    }

    @Override
    public Object getItem(int i) {
        return lsGeneroMusicalEntities.get(i);
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
            v = inflater.inflate(R.layout.row_dialog_genero, null);
            ViewHolder holder = new ViewHolder();

            holder.txtGenero = (TextView) v.findViewById(R.id.txtGeneroDialog);
            v.setTag(holder);
        }

        GeneroMusical obj_pGenero = lsGeneroMusicalEntities.get(position);



        if (obj_pGenero != null) {

            ViewHolder holder = (ViewHolder) v.getTag();
            holder.txtGenero.setText(obj_pGenero.getDescripcion());
        }

        return v;
    }

    public static int getIdGeneroMusical (int pos){
        return id = lsGeneroMusicalEntities.get(pos).getIdGenero();
    }

    public static String getDescripcionGeneroMusical (int pos){
        return desc = lsGeneroMusicalEntities.get(pos).getDescripcion();
    }

    static class ViewHolder {
        TextView txtGenero;
    }
}
