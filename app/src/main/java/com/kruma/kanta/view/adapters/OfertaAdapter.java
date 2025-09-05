package com.kruma.kanta.view.adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.kruma.core.configuration.App;
import com.kruma.kanta.R;
import com.kruma.kanta.entidad.Oferta;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Jordy Vilchez on 24/04/2017.
 */

public class OfertaAdapter extends PagerAdapter {


    private Oferta obj_pOferta;

    private Context context;
    private List<Oferta> lsOfertaEntities;

    //private LayoutInflater layoutInflater;


    public OfertaAdapter(Context context, List<Oferta> lsOfertaEntities) {
        this.context = context;
        this.lsOfertaEntities = lsOfertaEntities;
    }



    @Override
    public int getCount() {
        return lsOfertaEntities.size();
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
        View view = inflater.inflate(R.layout.row_oferta,null);
        ImageView ivOferta = (ImageView) view.findViewById(R.id.ivOferta);
        Oferta obj_pOferta = lsOfertaEntities.get(position);

        //View view = this.layoutInflater.inflate(R.layout.row_oferta, container, false);
        //ImageView ivOferta = (ImageView) view.findViewById(R.id.ivOferta);
        //ivOferta.setImageResource(R.drawable.sinimagen);

        Picasso.with(App.getContext()).load(obj_pOferta.getImagenURL()).into(ivOferta);

        if (obj_pOferta != null) {

            try {
                if (obj_pOferta.getImagenURL() != null) {
                    Picasso.with(App.getContext()).load(obj_pOferta.getImagenURL()).into(ivOferta);
                }else{
                    ivOferta.setImageResource(R.drawable.sinimagen);
                }
            } catch (Exception ex) {
                ivOferta.setImageResource(R.drawable.sinimagen);
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