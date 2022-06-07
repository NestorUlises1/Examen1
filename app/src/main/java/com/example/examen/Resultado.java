package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.*;
import android.os.Bundle;

public class Resultado extends AppCompatActivity {
    private TextView lblDatos;
    private TextView lblMostrar;
    private RadioButton rbArea;
    private RadioButton rbPerimetro;
    private Button btnCalcular;
    private Button btnRegresar;
    private Rectangulo rectangulo=new Rectangulo();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        lblDatos=(TextView) findViewById(R.id.lblDatos);
        lblMostrar=(TextView) findViewById(R.id.lblMostrar);
        rbArea=(RadioButton) findViewById(R.id.rbArea);
        rbPerimetro=(RadioButton) findViewById(R.id.rbPerimetro);
        btnCalcular=(Button) findViewById(R.id.btnCalcular);
        btnRegresar=(Button) findViewById(R.id.btnRegresar);
        Bundle datos=getIntent().getExtras();
        rectangulo.setAltura(Double.parseDouble(datos.getString("altura")));
        rectangulo.setBase(Double.parseDouble(datos.getString("base")));
        lblDatos.setText(""+datos.getString("nombre")+"\nAltura: "+datos.getString("altura")+
                "\nBase: "+datos.getString("base"));

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rbArea.isChecked()){
                    lblMostrar.setText("El area es de: "+rectangulo.calcularArea());
                }
                else{
                    if(rbPerimetro.isChecked()){
                        lblMostrar.setText("El Perimetro es de: "+rectangulo.calcularPerimetro());
                    }
                }
            }
    });
        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}