package com.example.cuc.personabasededatos;

import android.content.Context;
import android.media.Image;
import android.support.v7.view.menu.MenuView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by CUC on 13/05/2017.
 */

public class AdaptadorPersona extends BaseAdapter{

    private Context contexto;
    private ArrayList<Persona> personas;

    public AdaptadorPersona(Context contexto, ArrayList<Persona> personas) {
        this.contexto = contexto;
        this.personas = personas;
    }

    @Override
    public int getCount() {
        return personas.size();
    }

    @Override
    public Object getItem(int position) {
        return personas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return Long.parseLong(personas.get(position).getCedula());
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //declarar variables
        TextView cajaNombre, cajaApellido, cajacedula;
        ImageView foto;
        LayoutInflater inflater;
        View itemView;

        // Uso del inflater
        inflater = (LayoutInflater)contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        itemView = inflater.inflate(R.layout.item_personalizado, null);

        //Captura los objetos
        cajacedula = (TextView)itemView.findViewById(R.id.txtcedulap);
        cajaNombre = (TextView)itemView.findViewById(R.id.txtnombrep);
        cajaApellido = (TextView)itemView.findViewById(R.id.txtapellidop);
        foto = (ImageView)itemView.findViewById(R.id.imgp);

        //Pasar informacion

        foto.setImageResource(Integer.parseInt(personas.get(position).getFoto()));
        cajacedula.setText((personas.get(position).getCedula()));
        cajaNombre.setText((personas.get(position).getNombre()));
        cajaApellido.setText((personas.get(position).getApellido()));


        //Retorna el itemView
        return itemView;
    }
}
