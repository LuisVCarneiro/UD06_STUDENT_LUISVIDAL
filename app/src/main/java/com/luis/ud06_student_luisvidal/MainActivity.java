package com.luis.ud06_student_luisvidal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button button_1;
    private Button button_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupView();
    }

    private void setupView (){
        button_1 = findViewById(R.id.button1);
        button_2 = findViewById(R.id.button2);
        registerForContextMenu(button_1);

        button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),provincia.class);
                startActivityForResult(intent,0);
            }
        });

        button_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                leerBundle();
            }
        });
    }

    private void leerBundle(){
        Bundle bundle = getIntent().getExtras();
        String sProvincia = bundle.getString("key1","Default");
        Toast.makeText(getApplicationContext(), "La provincia del usuario es: " + sProvincia.toString(), Toast.LENGTH_LONG).show();
    }

    public void onCreateContextMenu (ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_long_click, menu);
    }

    public boolean onContextItemSelected (MenuItem item){
        switch (item.getItemId()){
            case R.id.menuCalculadora:
                Toast.makeText(getApplicationContext(), "Calculadora", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuEmail:
                Toast.makeText(getApplicationContext(), "Email", Toast.LENGTH_LONG).show();
                break;
        }
        return true;
    }

}