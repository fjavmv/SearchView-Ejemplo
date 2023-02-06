package com.example.searchviewapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Locale;

public class AdapterLIsta extends RecyclerView.Adapter<AdapterLIsta.VieHolderDatos> {

    private ArrayList<String> data;
    public AdapterLIsta(ArrayList<String> data){
        this.data = data;
    }


    // metodo para filtrar los elementos de tipo string pueden ser otro tipo de objetos ejemplo alumno, etc.
    public void filtroList(ArrayList<String> filtroList) {
        // agregamos el filtro a la lista
        data = filtroList;
        // notificamos cambios
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public AdapterLIsta.VieHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mi_list_item,null,false);
        return new AdapterLIsta.VieHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterLIsta.VieHolderDatos holder, int position) {
        holder.llenar(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class VieHolderDatos  extends RecyclerView.ViewHolder{

        private TextView textView;
        public VieHolderDatos(@NonNull View itemView) {
            super(itemView);
            iniciar(itemView);

        }

         public void iniciar(View view){
            textView = view.findViewById(R.id.miElemento);
         }

         public void llenar (String data){
            textView.setText(data);
         }

    }
}
