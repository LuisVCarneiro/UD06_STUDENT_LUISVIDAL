package com.luis.ud06_student_luisvidal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;

public class provincia extends AppCompatActivity {

    private EditText etProvincia;
    private Button button_cerrar;
    private String sProvincia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provincia);
        setupView();
    }

    private void setupView(){
        etProvincia = findViewById(R.id.etProvincia);
        etProvincia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etProvincia.setText("");
            }
        });
        button_cerrar = findViewById(R.id.button_cerrar);
        button_cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkEditText();
            }
        });
    }

    private void getProvincia(){
        //sProvincia = String.valueOf(etProvincia.getText());
        Intent intent = new Intent(this,MainActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("key1",sProvincia);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void onBackPressed(){
        super.onBackPressed();
        Toast.makeText(getApplicationContext(),"Saliste de la actividad secundaria sin pulsar el botón CERRAR",
                Toast.LENGTH_LONG).show();
    }

    private void checkEditText(){
        sProvincia = String.valueOf(etProvincia.getText());
        if (sProvincia.equals("Teclea una provincia") || (sProvincia.equals(""))) {
            Toast.makeText(getApplicationContext(), "Introduce una provincia", Toast.LENGTH_SHORT).show();
            return;
        }
        else {
            getProvincia();
        }
    }
}