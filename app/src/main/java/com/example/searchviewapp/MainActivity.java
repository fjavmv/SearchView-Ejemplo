package com.example.searchviewapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.app.ComponentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener{

    private RecyclerView recyclerView;
    private SearchView searchView;
    private ArrayList<String> miLista;
    private AdapterLIsta adapterLIsta;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rcyview);
        searchView = findViewById(R.id.search);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
        miLista = Utils.getMiLista();
        adapterLIsta = new AdapterLIsta(miLista);
        recyclerView.setAdapter(adapterLIsta);
        searchView.setOnQueryTextListener(this);

    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        filtro(newText);
        return false;
    }


    private void filtro(String text) {
        // Arreglo de la lista a filtrar
        ArrayList<String> list = new ArrayList<>();

        // for each para recorrer los elementos del arraylist
        for (String item : miLista) {
            // Revisamos si los elemntos coninciden
            if (item.toLowerCase().contains(text.toLowerCase())) {
                // Si coincide lo agregadmos a la lista
                list.add(item);
            }
        }
        if (list.isEmpty()) {
            //Si no hay coincidencias notificamos
            Toast.makeText(this, "No existen coincidencias..", Toast.LENGTH_SHORT).show();
        } else {
            // Pasamos los elementos al adaptador
            adapterLIsta.filtroList(list);
        }
    }

}