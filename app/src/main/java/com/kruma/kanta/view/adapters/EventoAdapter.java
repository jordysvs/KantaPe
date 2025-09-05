package com.kruma.kanta.view.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.kruma.kanta.R;
import com.kruma.kanta.entidad.Evento;

import java.util.List;

/**
 * Created by Carlos Gomez on 21/10/2016.
 */

public class EventoAdapter extends BaseAdapter {

    private Evento obj_pEvento;

    private Context context;
    private List<Evento> lsEventoEntities;

    public EventoAdapter(Context context, List<Evento> lsEventoEntities) {
        this.context = context;
        this.lsEventoEntities = lsEventoEntities;
    }

    @Override
    public int getCount() {
        return lsEventoEntities.size();
    }

    @Override
    public Object getItem(int i) {
        return lsEventoEntities.get(i);
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
            v = inflater.inflate(R.layout.row_evento, null);
            ViewHolder holder = new ViewHolder();

            holder.txtNombreEvento = (TextView) v.findViewById(R.id.txtNombreEvento);
            holder.txtDescripcionEvento = (TextView) v.findViewById(R.id.txtDescripcionEvento);
            holder.txtFechaInicioEvento = (TextView) v.findViewById(R.id.txtFechaInicioEvento);
            //holder.txtFechaVencimientoEvento = (TextView) v.findViewById(R.id.txtFechaVencimientoEvento);

            // Activamos o seleccionamos los TextView para que
            // tengan la animacion de movimiento horizontal
            holder.txtNombreEvento.setSelected(true);
            holder.txtDescripcionEvento.setSelected(true);
            holder.txtFechaInicioEvento.setSelected(true);
            //holder.txtFechaVencimientoEvento.setSelected(true);

            v.setTag(holder);
        }

        obj_pEvento = lsEventoEntities.get(position);

        if (obj_pEvento != null) {

            ViewHolder holder = (ViewHolder) v.getTag();

            holder.txtNombreEvento.setText(obj_pEvento.getNombre());
            holder.txtDescripcionEvento.setText(obj_pEvento.getDescripcion());
            holder.txtFechaInicioEvento.setText(obj_pEvento.getFechaEvento().toString());
            //holder.txtFechaVencimientoEvento.setText(obj_pEvento.getFechaVencimiento().toString());
        }

        return v;

    }

    static class ViewHolder {
        TextView txtNombreEvento;
        TextView txtDescripcionEvento;
        TextView txtFechaInicioEvento;
        //TextView txtFechaVencimientoEvento;
    }
}
