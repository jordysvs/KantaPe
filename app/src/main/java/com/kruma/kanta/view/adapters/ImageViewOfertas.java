package com.kruma.kanta.view.adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.kruma.kanta.R;

/**
 * Created by JORDY on 06/04/2017.
 */

public class ImageViewOfertas extends PagerAdapter{


    private int[] imagenes = {R.mipmap.oferta, R.mipmap.evento};

    private Context ctx;

    private LayoutInflater layoutInflater;


    public ImageViewOfertas (Context ctx){
        this.ctx = ctx;
    }

    @Override
    public int getCount() {
        return imagenes.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == (LinearLayout)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        //layoutInflater = (LayoutInflater) ctx.getSystemService(Context.ACCESSIBILITY_SERVICE);
        layoutInflater = LayoutInflater.from(ctx);
        View view = layoutInflater.inflate(R.layout.imageview_ofertas, container, false);

        ImageView imageView = (ImageView) view.findViewById(R.id.iviImagenes);

        imageView.setImageResource(imagenes[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView((LinearLayout)object);

    }


}
