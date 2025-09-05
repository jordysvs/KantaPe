package com.kruma.kanta.view.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.kruma.kanta.R;
import com.kruma.kanta.entidad.ProductoTipo;

import java.util.List;

/**
 * Created by Carlos Gomez on 28/10/2016.
 */

public class DialogProductoTipoAdapter extends BaseAdapter {

    private Context context;
    private static List<ProductoTipo> lsProductoTipoEntities;
    public static int id;
    public static String desc;

    public DialogProductoTipoAdapter(Context context, List<ProductoTipo> lsProductoTipoEntities) {
        this.context = context;
        this.lsProductoTipoEntities = lsProductoTipoEntities;
    }

    @Override
    public int getCount() {
        return lsProductoTipoEntities.size();
    }

    @Override
    public Object getItem(int position) {
        return lsProductoTipoEntities.get(position);
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
            v = inflater.inflate(R.layout.row_dialog_producto_tipo, null);
            ViewHolder holder = new ViewHolder();

            holder.txtProductoTipo = (TextView) v.findViewById(R.id.txtProductoTipoDialog);

            v.setTag(holder);
        }

        ProductoTipo obj_pIdioma = lsProductoTipoEntities.get(position);

        if (obj_pIdioma != null) {

            ViewHolder holder = (ViewHolder) v.getTag();
            holder.txtProductoTipo.setText(obj_pIdioma.getDescripcion());
        }

        return v;
    }

    public static int getIdProductoTipo (int pos){
        return id = lsProductoTipoEntities.get(pos).getIdProductoTipo();
    }

    public static int getDescripcionProductoTipo (int pos){
        return id = lsProductoTipoEntities.get(pos).getIdProductoTipo();
    }

    static class ViewHolder {
        TextView txtProductoTipo;
    }

}
