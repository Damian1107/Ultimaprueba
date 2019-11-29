package com.example.ultimaprueba;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editUsuarios, editRamos, editProfesion;
    Button buttonAceptar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editUsuarios=(EditText)findViewById(R.id.editUsuarios);
        editRamos=(EditText)findViewById(R.id.editRamos);
        editProfesion=(EditText)findViewById(R.id.editProfesion);
        buttonAceptar=(Button) findViewById(R.id.buttonAceptar);

        final Inscripciones Inscripciones_bd = new Inscripciones(getApplicationContext());

        buttonAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Inscripciones_bd.agregarCursos(editUsuarios.getText().toString(),editRamos.getText().toString(),editProfesion.getText().toString());
                Toast.makeText(getApplicationContext(), "SE AGREGO", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

