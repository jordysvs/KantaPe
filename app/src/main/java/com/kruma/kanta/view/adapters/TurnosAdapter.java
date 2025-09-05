package com.kruma.kanta.view.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.kruma.kanta.R;
import com.kruma.kanta.entidad.Turno;

import java.util.List;

/**
 * Created by Enrique on 05/09/2016.
 */
public class TurnosAdapter extends BaseAdapter {

    private Context context;
    private List<Turno> lsTurnoEntities;

    public TurnosAdapter(Context context, List<Turno> lsTurnoEntities) {
        this.context = context;
        this.lsTurnoEntities = lsTurnoEntities;
    }

    @Override
    public int getCount() {
        return lsTurnoEntities.size();
    }

    @Override
    public Object getItem(int position) {
        return lsTurnoEntities.get(position);
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
            v = inflater.inflate(R.layout.row_turnos, null);
            ViewHolder holder = new ViewHolder();

            holder.txtMesa = (TextView) v.findViewById(R.id.txtMesa);
            holder.txtTiempo = (TextView) v.findViewById(R.id.txtTiempo);
            holder.iviAlarma = (ImageView) v.findViewById(R.id.iviAlarma);
            v.setTag(holder);
        }

        Turno obj_pTurno = lsTurnoEntities.get(position);

        if (obj_pTurno != null) {

            ViewHolder holder = (ViewHolder) v.getTag();

            holder.txtMesa.setText(obj_pTurno.getMesa());
            holder.txtTiempo.setText(obj_pTurno.getTiempo());
            holder.iviAlarma.setImageResource(obj_pTurno.getAlarma());
        }

        return v;
    }

    static class ViewHolder {
        TextView txtMesa;
        TextView txtTiempo;
        ImageView iviAlarma;
    }
}
