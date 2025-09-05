package com.kruma.kanta.view.adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.kruma.kanta.R;
import com.kruma.kanta.entidad.AperturaUsuario;
import com.kruma.kanta.entidad.Constante;

import java.util.List;

/**
 * Created by Jordy Viclhez  on 20/04/2016.
 */
public class UsuariosMesaAdapter extends BaseAdapter {

    static AperturaUsuario obj_pAperturaUsuario;
    public static String id;
    public static String administrador;
    public static String estado;
    public static int idAperturaUsuario;

    //Para el Dialog
    //private Fragment parentActivity;

    private Context context;
    private static List<AperturaUsuario> lsAperturaUsuarioEntities;

    public UsuariosMesaAdapter(Context context, List<AperturaUsuario> lsAperturaUsuarioEntities) {
        this.context = context;
        this.lsAperturaUsuarioEntities = lsAperturaUsuarioEntities;
        //this.parentActivity = parentActivity;
    }

    @Override
    public int getCount() {
        return lsAperturaUsuarioEntities.size();
    }

    @Override
    public Object getItem(int position) {
        return lsAperturaUsuarioEntities.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }



    @Override
    public View getView(int position, final View convertView, ViewGroup parent) {

        View v = convertView;

        if (v == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            v = inflater.inflate(R.layout.row_usuarios_mesa, null);
            ViewHolder holder = new ViewHolder();

            holder.txtUsuarioMiMesa = (TextView) v.findViewById(R.id.txtUsuarioMiMesa);
            holder.iconoperfil = (ImageView) v.findViewById(R.id.iconoperfil);
            //holder.iconoadministrador = (ImageView) v.findViewById(R.id.iconoadministrador);
            holder.btnAccion = (ImageView) v.findViewById(R.id.btnAccion);

            // Activamos o seleccionamos los TextView para que
            // tengan la animacion de movimiento horizontal
            holder.txtUsuarioMiMesa.setSelected(true);


            v.setTag(holder);
        }

        obj_pAperturaUsuario = lsAperturaUsuarioEntities.get(position);

        if (obj_pAperturaUsuario != null) {

            ViewHolder holder = (ViewHolder) v.getTag();

            holder.txtUsuarioMiMesa.setText(obj_pAperturaUsuario.getUsuario().getPersona().getNombres());


            if(obj_pAperturaUsuario.getAdministrador() != null) {

                if (obj_pAperturaUsuario.getAdministrador().equals(Constante.CONDICION_NEGATIVO) && obj_pAperturaUsuario.getEstado().equals(Constante.ESTADO_ACTIVO)) {
                    //holder.iconoadministrador.setImageResource(R.drawable.iconomiperfil);
                    holder.iconoperfil.setImageResource(R.drawable.iconomiperfil);
                    holder.txtUsuarioMiMesa.setTextColor(holder.txtUsuarioMiMesa.getContext().getResources().getColor(R.color.colorIcons));
                    holder.btnAccion.setImageResource(R.drawable.iconoaceptar);

                } else if (obj_pAperturaUsuario.getAdministrador().equals(Constante.CONDICION_NEGATIVO) && obj_pAperturaUsuario.getEstado().equals(Constante.ESTADO_PENDIENTE)) {
                    //holder.iconoadministrador.setImageResource(R.drawable.iconomiperfil);
                    holder.iconoperfil.setImageResource(R.drawable.iconomiperfil);
                    holder.txtUsuarioMiMesa.setTextColor(holder.txtUsuarioMiMesa.getContext().getResources().getColor(R.color.colorIcons));
                    holder.btnAccion.setImageResource(R.drawable.iconoequis);

                } else {
                    holder.iconoperfil.setImageResource(R.drawable.iconoadministrador);
                    //holder.iconoadministrador.setImageResource(R.drawable.iconoadministrador);
                    holder.txtUsuarioMiMesa.setTextColor(holder.txtUsuarioMiMesa.getContext().getResources().getColor(R.color.colorIcons));
                    holder.btnAccion.setImageResource(R.drawable.iconocandado);
                }



            }

        }

        return v;
    }

    public static AperturaUsuario getAperturaUsuario(int pos) {
        return obj_pAperturaUsuario = lsAperturaUsuarioEntities.get(pos);
    }

    public static String getIdUsuario (int pos){
        return id = lsAperturaUsuarioEntities.get(pos).getIdUsuario();
    }

    public static String getAdministrador(int pos){
        return administrador = lsAperturaUsuarioEntities.get(pos).getAdministrador();
    }

    public static String getEstado(int pos){
        return estado = lsAperturaUsuarioEntities.get(pos).getEstado();
    }

    public static int getIdAperturaUsuario(int pos){
        return idAperturaUsuario = lsAperturaUsuarioEntities.get(pos).getIdAperturaUsuario();
    }

    static class ViewHolder {
        ImageView iconoperfil;
        TextView txtUsuarioMiMesa;
        //ImageView iconoadministrador;
        ImageView btnAccion;
    }


    //AGREGUEEE

    public void addListItemToAdapter(List<AperturaUsuario> list) {
        lsAperturaUsuarioEntities.addAll(list);
        this.notifyDataSetChanged();
    }

}
