package com.luis.ud06_student_luisvidal;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button button_1;
    private Button button_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupView();
    }

    /*
    Método donde inicializo los objetos incluídos en el diseño, en este caso dos botones
     */
    private void setupView (){
        button_1 = findViewById(R.id.button1);
        button_2 = findViewById(R.id.button2);
        /*
        Registro el button_1 para el menú contextual
         */
        registerForContextMenu(button_1);

    /*
    Con el método setOnclickListener implemento la acción a realizar cuando se hace click en el
    primer botón (Provincia/Calculadora/Email). En este caso, hace un intent para llamar a la
    segunda activity.
     */
        button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),provincia.class);
                startActivityForResult(intent,0);
            }
        });

    /*
    Lo mismo hago para el segundo botón, donde inicializo el método que lee el bundle recibido por
    la segunda activity.
     */
        button_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                leerBundle();
            }
        });
    }

    /*
    Método que recoje el bundle de la segunda actividad en un String con el nombre de la provincia
    para posteriormente mostrarlo en el Toast.
    En caso de que el valor esté en blanco, o bien, si no cambia el texto inicial, muestra un mensaje
    diferente en el Toast
     */
    private void leerBundle(){
        Bundle bundle = getIntent().getExtras();
        String sProvincia = bundle.getString("key1","Default");
        if (sProvincia.equals("Default")) {
            Toast.makeText(getApplicationContext(), "Teclea una provincia", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(getApplicationContext(), "La provincia del usuario es: " + sProvincia.toString(), Toast.LENGTH_LONG).show();
        }
    }

    /*
    onCreateContextMenu crea el menú contextual que emerge cuando realizamos un longClick en el botón 1.
    Los item de este menú están definidos en res/menu/menu_long_click
     */
    public void onCreateContextMenu (ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_long_click, menu);
    }

    /*
    Con este método manejo la selección de los item del menu contextual, lanzando la calculadora en el
    primer caso o gmail en el segundo. Para este último caso, seguí el código de los apuntes haciendo
    una llamada según la acción de las app del SO, en este caso SEND.
     */
    public boolean onContextItemSelected (MenuItem item){
        switch (item.getItemId()){
            case R.id.menuCalculadora:
                Intent intent = new Intent();
                intent.setClassName("com.android.calculator2","com.android.calculator2.Calculator");
                startActivity(intent);
                break;
            case R.id.menuEmail:
                Intent intent1 = new Intent (Intent.ACTION_SEND);
                intent1.setType("application/octet-stream");
                intent1.putExtra(Intent.EXTRA_SUBJECT,"Subject");
                intent1.putExtra(Intent.EXTRA_TEXT,"Texto do email");
                intent1.putExtra(Intent.EXTRA_EMAIL,new String[]{"android@cursoandroid.es"});
                startActivity(intent1);
                break;
        }
        return true;
    }

}