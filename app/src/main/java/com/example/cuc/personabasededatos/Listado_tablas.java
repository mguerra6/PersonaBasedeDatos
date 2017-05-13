package com.example.cuc.personabasededatos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;

import java.util.ArrayList;

public class Listado_tablas extends AppCompatActivity {

    private TableLayout tabla;
    private ArrayList<Persona> personas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_tablas);

        tabla = (TableLayout)findViewById(R.id.tablaPersonas);
        personas = Datos.traerPersona(getApplicationContext());
    }
}
