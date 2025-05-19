package com.example.listaplanetas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView listview; //null

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview = findViewById(R.id.listview);
        PlanetaDAO planetaDAO = new PlanetaDAO();
        PlanetaAdapter planetaAdapter = new PlanetaAdapter(this,R.layout.itemplaneta, planetaDAO.planetas);

        listview.setAdapter(planetaAdapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(MainActivity.this,Integer.toString(position), Toast.LENGTH_LONG).show();
            }
        });
    }
}