package com.kruma.kanta.view.adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.kruma.kanta.R;

import com.kruma.kanta.entidad.TutorialMiLista;

import java.util.List;

/**
 * Created by Enrique on 08/09/2016.
 */
public class TutorialAdapter extends PagerAdapter {

    Context context;

    List<TutorialMiLista> lsTutorialMiListas;;

    public TutorialAdapter(Context context, List<TutorialMiLista> lsTutorialMiListas) {
        this.context = context;
        this.lsTutorialMiListas = lsTutorialMiListas;
    }

    @Override
    public int getCount() {
        return lsTutorialMiListas.size();
    }


    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((View)object);
    }




    @Override
    public Object instantiateItem(ViewGroup viewGroup, int position) {

        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.row_tutorial,null);

        ImageView ivTutorial = (ImageView) view.findViewById(R.id.ivTutorial);

        TutorialMiLista obj_pTutorial = lsTutorialMiListas.get(position);


        if (obj_pTutorial != null) {


                    ivTutorial.setImageResource(obj_pTutorial.getFoto());

        }

        viewGroup.addView(view);
        return view;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
