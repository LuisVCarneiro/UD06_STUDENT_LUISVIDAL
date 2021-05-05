package com.luis.ud06_student_luisvidal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;

public class provincia extends AppCompatActivity {

    private EditText etProvincia;
    private Button button_provincia;
    private String sProvincia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provincia);
        setupView();
    }

    private void setupView(){
        etProvincia = findViewById(R.id.etProvincia);
        button_provincia = findViewById(R.id.button_provincia);
        button_provincia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getProvincia();
            }
        });
    }

    private void getProvincia(){
        sProvincia = String.valueOf(etProvincia.getText());
        Intent intent = new Intent(this,MainActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("key1",sProvincia);
        intent.putExtras(bundle);
        startActivity(intent);
    }


}