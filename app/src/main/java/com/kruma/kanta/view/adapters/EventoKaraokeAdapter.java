package com.kruma.kanta.view.adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.kruma.core.configuration.App;
import com.kruma.kanta.R;
import com.kruma.kanta.entidad.Evento;
import com.kruma.kanta.entidad.Oferta;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Jordy Vilchez on 24/04/2017.
 */

public class EventoKaraokeAdapter extends PagerAdapter {


    private Evento obj_pEvento;

    private Context context;
    private List<Evento> lsEventoEntities;

    //private LayoutInflater layoutInflater;


    public EventoKaraokeAdapter(Context context, List<Evento> lsEventoEntities) {
        this.context = context;
        this.lsEventoEntities = lsEventoEntities;
    }



    @Override
    public int getCount() {
        return lsEventoEntities.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((View)object);
    }

    /*
        @Override
        public void onBindViewHolder(OfertaAdapter.ViewHolder holder, int position) {

            obj_pOferta = lsOfertaEntities.get(position);

            if (obj_pOferta != null) {

                try {
                    if (obj_pOferta.getImagenURL() != null) {
                        //holder.ivOferta.setImageResource(R.mipmap.oferta);
                        Picasso.with(App.getContext()).load(obj_pOferta.getImagenURL()).into(holder.ivOferta);
                    }else{
                        holder.ivOferta.setImageResource(R.drawable.sinimagen);
                    }

                } catch (Exception ex) {
                    holder.ivOferta.setImageResource(R.drawable.sinimagen);

                }
            }
        }
        */
    @Override
    public Object instantiateItem(ViewGroup viewGroup, int position) {

        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.row_evento_karaoke,null);

        ImageView ivEventoKaraoke = (ImageView) view.findViewById(R.id.ivEventoKaraoke);

        Evento obj_pEvento = lsEventoEntities.get(position);


        Picasso.with(App.getContext()).load(obj_pEvento.getImagenURL()).into(ivEventoKaraoke);

        if (obj_pEvento != null) {

            try {
                if (obj_pEvento.getImagenURL() != null) {

                    Picasso.with(App.getContext()).load(obj_pEvento.getImagenURL()).into(ivEventoKaraoke);
                }else{
                    ivEventoKaraoke.setImageResource(R.drawable.sinimagen);
                }

            } catch (Exception ex) {
                ivEventoKaraoke.setImageResource(R.drawable.sinimagen);

            }
        }

        viewGroup.addView(view);
        return view;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}