package com.example.cuc.personabasededatos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Listado_personalizado extends AppCompatActivity {
    private ListView LstPersonalizado;
    private ArrayList<Persona> personas;
    private AdaptadorPersona adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_personalizado);
        LstPersonalizado = (ListView)findViewById(R.id.lstListado);
        personas = Datos.traerPersona(getApplicationContext());
        adapter = new AdaptadorPersona(getApplicationContext(), personas);
        LstPersonalizado.setAdapter(adapter);

    }
}
