package com.example.listaplanetas;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class PlanetaAdapter extends ArrayAdapter<Planeta> {

    Context mContext;
    Integer mResouceXML;
    List<Planeta> planetas;

    public PlanetaAdapter(@NonNull Context context, int resource, @NonNull List<Planeta> objects) {
        super(context, resource, objects);
        mContext=context;
        mResouceXML=resource;
        planetas=objects;
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View v = layoutInflater.inflate(mResouceXML,parent,false);
        TextView tvnomeplaneta = v.findViewById(R.id.lblnome); //liga variavel local aos componentes vies
        ImageView imageview = v.findViewById(R.id.imageview);

        Planeta planeta = planetas.get(position);
        tvnomeplaneta.setText(planeta.nome);
        imageview.setImageResource(planeta.foto);

        return v;
    }
}
