package com.kruma.kanta.view.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.kruma.kanta.R;
import com.kruma.kanta.entidad.GeneroMusical;
import com.kruma.kanta.entidad.Pais;

import java.util.List;

/**
 * Created by Carlos Gomez on 14/10/2016.
 */

public class DialogPaisAdapter extends BaseAdapter {

    private Context context;
    private static List<Pais> lsPaisEntities;
    public static int id;
    public static String desc;

    public DialogPaisAdapter(Context context, List<Pais> lsPaisEntities) {
        this.context = context;
        this.lsPaisEntities = lsPaisEntities;
    }

    public DialogPaisAdapter() {

    }

    @Override
    public int getCount() {
        return lsPaisEntities.size();
    }

    @Override
    public Object getItem(int i) {
        return lsPaisEntities.get(i);
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
            v = inflater.inflate(R.layout.row_dialog_pais, null);
            ViewHolder holder = new ViewHolder();

            holder.txtPais = (TextView) v.findViewById(R.id.txtPaisDialog);

            v.setTag(holder);
        }

        Pais obj_pPais = lsPaisEntities.get(position);

        if (obj_pPais != null) {

            ViewHolder holder = (ViewHolder) v.getTag();
            holder.txtPais.setText(obj_pPais.getDescripcion());
        }

        return v;
    }

    public static int getIdPais (int pos){
        return id = lsPaisEntities.get(pos).getIdPais();
    }

    public static String getDescripcionPais  (int pos){
        return desc = lsPaisEntities.get(pos).getDescripcion();
    }

    static class ViewHolder {
        TextView txtPais;
    }
}
