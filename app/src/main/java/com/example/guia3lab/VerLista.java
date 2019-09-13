package com.example.guia3lab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


import static com.example.guia3lab.MainActivity.ListNombres;

public class VerLista extends AppCompatActivity {

    private ListView listNomb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_lista);

            listNomb = findViewById(R.id.liswNombres);

            listNomb.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, ListNombres));
    }
}
