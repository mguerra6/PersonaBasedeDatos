package com.example.cuc.personabasededatos;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

public class Registrar extends AppCompatActivity {

    private EditText cajaCedula;
    private EditText cajaNombre;
    private EditText cajaApellido;
    private RadioButton rdMasculino;
    private RadioButton rdFemenino;
    private CheckBox chkProgramas;
    private CheckBox chkLeer;
    private CheckBox chkBailar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
        cajaCedula = (EditText)findViewById(R.id.txtcedula);
        cajaNombre = (EditText)findViewById(R.id.txtnombre);
        cajaApellido = (EditText)findViewById(R.id.txtapellido);
        rdMasculino = (RadioButton)findViewById(R.id.rbmasculino);
        rdFemenino = (RadioButton)findViewById(R.id.rbfemenino);
        chkProgramas = (CheckBox)findViewById(R.id.cbprogramar);
        chkLeer = (CheckBox)findViewById(R.id.cbleer);
        chkBailar = (CheckBox)findViewById(R.id.cbescribir);

    }

    public boolean ValidarTodo(){
        if(cajaCedula. getText().toString().isEmpty())
        {
            cajaCedula.setError("Digite la cédula");
            cajaCedula.requestFocus();
            return false;
        }
        if(cajaNombre. getText().toString().isEmpty())
        {
            cajaNombre.setError("Digite el nombre");
            cajaNombre.requestFocus();
            return false;
        }
        if(cajaApellido. getText().toString().isEmpty())
        {
            cajaApellido.setError("Digite el apellido");
            cajaApellido.requestFocus();
            return false;
        }
        if( (!chkProgramas.isChecked()) && (!chkLeer.isChecked()) && (!chkBailar.isChecked()) )
        {
            new AlertDialog.Builder(this).setMessage("Selccione por lo menos un pasatiempo").setCancelable(true).show();
            return false;
        }
        return true;
    }

    public Boolean validarCedula(){
        if(cajaCedula.getText().toString().isEmpty())
        {
            cajaCedula.setError("Digitar la cédula");
            cajaCedula.requestFocus();
            return false;
        }
        else {
            return true;
        }
    }

    public void limpiar(){
        cajaCedula.setText("");
        cajaNombre.setText("");
        cajaApellido.setText("");
        rdMasculino.setChecked(true);
        rdFemenino.setChecked(false);
        chkProgramas.setChecked(false);
        chkLeer.setChecked(false);
        chkBailar.setChecked(false);

        cajaCedula.requestFocus();

    }

    public int fotoAleatoria()
    {
    int foto[] = {R.drawable.images, R.drawable.images2, R.drawable.images3};
        int numero = (int)(Math.random() * 3);
        return foto[numero];
    }

    public void guardar(View v ){
        String foto, nombre, apellido, sexo, cedula, pasatiempo = "";
        Persona p;
        if(ValidarTodo())
        {
            foto = String.valueOf(fotoAleatoria());
            nombre = cajaNombre.getText().toString();
            apellido = cajaApellido.getText().toString();
            cedula = cajaCedula.getText().toString();
            if(rdMasculino.isChecked()) sexo = getResources().getString(R.string.masculino);
            else sexo = getResources().getString(R.string.femenino);
            if(chkProgramas.isChecked())
            {
                pasatiempo = getResources().getString(R.string.programar) + ", ";
            }
            if(chkLeer.isChecked())
            {
                pasatiempo = getResources().getString(R.string.leer) + ", ";
            }
            if(chkBailar.isChecked())
            {
                pasatiempo = getResources().getString(R.string.Bailar) + ", ";
                pasatiempo = pasatiempo.substring(pasatiempo.length()-1);
            }

            p = new Persona(foto,  cedula, nombre, apellido, sexo, pasatiempo);
            p.Guardar(getApplicationContext());

            new AlertDialog.Builder(this).setMessage("Datos guardados").setCancelable(true).show();

            limpiar();
        }

    }
}
