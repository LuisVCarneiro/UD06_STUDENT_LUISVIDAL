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

    /*
    Inicializo los objetos del diseño (un EditText y un Button)
     */
    private void setupView(){
        etProvincia = findViewById(R.id.etProvincia);
        etProvincia.setOnClickListener(new View.OnClickListener() {
            /*
            Cuando se hace click en el EditText elimino el texto inicial para que solamente se lea
            la provincia escrita por el usuario
             */
            @Override
            public void onClick(View v) {
                etProvincia.setText("");
            }
        });
        button_cerrar = findViewById(R.id.button_cerrar);
        button_cerrar.setOnClickListener(new View.OnClickListener() {
            /*
            Cuando se hace click en el botón CERRAR, lanza un método que chequea el texto del EditText
             */
            @Override
            public void onClick(View v) {
                checkEditText();
            }
        });
    }

    /*
    Creo el bundle que envía la información recogida en el EditText a la primera activity, por medio
    de un par clave (key1) valor (String con la variable sProvincia)
     */
    private void getProvincia(){
        //sProvincia = String.valueOf(etProvincia.getText());
        Intent intent = new Intent(this,MainActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("key1",sProvincia);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    /*
    Si, estando en esta actividad, se pulsa el botón back del sistema, lanza un Toast con el aviso
    correspondiente
     */
    public void onBackPressed(){
        super.onBackPressed();
        Toast.makeText(getApplicationContext(),"Saliste de la actividad secundaria sin pulsar el botón CERRAR",
                Toast.LENGTH_LONG).show();
    }

    /*
    Si al pulsar el botón CERRAR, no se ha escrito nada o no se ha cambiado el texto inicial, lanzo
    un Toast advirtiéndolo. En caso contrario, lanzo el método que construye el bundle para enviarlo
    a la primera actividad
     */
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