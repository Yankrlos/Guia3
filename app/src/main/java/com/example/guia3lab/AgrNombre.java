package com.example.guia3lab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.guia3lab.MainActivity.ListNombres;

public class AgrNombre extends AppCompatActivity {

    EditText edtNombre;
    Button btnGuardar;
    TextView txtPorcentaje;
    ProgressBar prossBar;
    Handler h = new Handler();
    int i = 0;
    boolean banderaAct = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agr_nombre);

        edtNombre = findViewById(R.id.edtNombre);
        txtPorcentaje = findViewById(R.id.txtPorcentaje);
        prossBar = findViewById(R.id.prossBar);
        btnGuardar = findViewById(R.id.btnGuardar);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GuardarN();
            }
        });
    }

    private void GuardarN() {
        if(edtNombre.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(),"No a ingresado un nombre", Toast.LENGTH_SHORT).show();
        } else if(!banderaAct) {
            Thread hr = new Thread(new Runnable() {
                @Override
                public void run() {
                    while(i <=100){
                        h.post(new Runnable() {
                            @Override
                            public void run() {
                                txtPorcentaje.setText(i + " %");
                                prossBar.setProgress(i);
                            }
                        });
                        try{
                            Thread.sleep(20);
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                        if(i == 100){
                            ListNombres.add(edtNombre.getText().toString());
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(getApplicationContext(),"nombre Guardado", Toast.LENGTH_SHORT).show();
                                    banderaAct = false;
                                    i=0;
                                    txtPorcentaje.setText("");
                                    edtNombre.setText("");
                                    prossBar.setProgress(0);
                                }
                            });
                        }
                        i++;
                        banderaAct = true;
                    }
                }
            });
            hr.start();
        }
    }
}
