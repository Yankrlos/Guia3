package com.example.guia3lab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity<override> extends AppCompatActivity {

    public static List<String> ListNombres;

    Button btnLista, btnDatos, btnAgr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListNombres = new ArrayList<>();

        btnLista = findViewById(R.id.btnLista);
        btnAgr = findViewById(R.id.btnAgr);
        btnDatos = findViewById(R.id.btnDatos);

        btnLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Lista();
            }
        });
        btnAgr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AgrNomb();
            }
        });
        btnDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VerDatos();
            }
        });
    }

    private void VerDatos() {
        Intent in = new Intent(this, MisDatos.class);
        startActivity(in);
    }

    private void AgrNomb() {
        Intent in = new Intent(this, AgrNombre.class);
        startActivity(in);
    }

    private void Lista() {
        if(ListNombres == null || ListNombres.size() == 0){
            Toast.makeText(getApplicationContext(), "Lista esta vacia", Toast.LENGTH_LONG).show();
        }else{
            Intent in = new Intent(this, VerLista.class);
            startActivity(in);
        }

    }

}
