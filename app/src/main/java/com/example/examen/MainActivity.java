package com.example.examen;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.*;
import android.os.Bundle;
import android.content.DialogInterface;

public class MainActivity extends AppCompatActivity {
    private EditText txtNombre;
    private EditText txtBase;
    private EditText txtAltura;
    private Button btnLimpiar;
    private Button btnSiguiente;
    private Button btnSalir;
    private Rectangulo rectangulo=new Rectangulo();
    private void btnCerrar(){
        AlertDialog.Builder confirmar=new AlertDialog.Builder(this);
        confirmar.setTitle("¿Cerrar aplicación?");
        confirmar.setMessage("Se borrara la información ingreada");
        confirmar.setPositiveButton("Confirmar",new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialogInterface, int i){
                finish();
            }
        });
        confirmar.setNegativeButton("Cancelar", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialogInterface, int i){

            }
        });
        confirmar.show();
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNombre=(EditText) findViewById(R.id.txtNombre);
        txtBase=(EditText) findViewById(R.id.txtBase);
        txtAltura=(EditText) findViewById(R.id.txtAltura);
        btnLimpiar=(Button) findViewById(R.id.btnLimpiar);
        btnSiguiente=(Button) findViewById(R.id.btnSiguiente);
        btnSalir=(Button) findViewById(R.id.btnSalir);

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtNombre.setText("");
                txtBase.setText("");
                txtAltura.setText("");
            }
        });
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtBase.getText().toString().matches("") || txtAltura.getText().toString().matches("")|| txtNombre.getText().toString().matches("")){
                    Toast.makeText(MainActivity.this,"Favor de llenar todos los campos",Toast.LENGTH_SHORT).show();

                }
                else{
                    if(txtBase.equals(txtAltura)){
                        Toast.makeText(MainActivity.this,"Favor de no poner valores iguales",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        rectangulo.setBase(Double.parseDouble(txtBase.getText().toString()));
                        rectangulo.setAltura(Double.parseDouble(txtAltura.getText().toString()));
                        Intent intent=new Intent(MainActivity.this,Rectangulo.class);
                        Bundle bundle=new Bundle();
                        intent.putExtra("nombre",txtNombre.getText().toString());
                        intent.putExtra("altura",txtAltura.getText().toString());
                        intent.putExtra("base",txtBase.getText().toString());
                        bundle.putSerializable("rec", rectangulo);
                        startActivity(intent);
                    }
                }

            }
        });
        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnCerrar();
            }
        });
    }
}