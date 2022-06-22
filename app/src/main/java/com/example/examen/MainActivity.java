package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.*;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private EditText txtCodigo,txtDescripcion,txtUnidad,txtVenta,txtCompra,txtCantidad;
    private Button btnEnviar,btnLimpiar;
    private EntradaProducto eP=new EntradaProducto();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtCodigo=(EditText) findViewById(R.id.txtCodigo);
        txtDescripcion=(EditText) findViewById(R.id.txtDescripcion);
        txtUnidad=(EditText) findViewById(R.id.txtUnidad);
        txtVenta=(EditText) findViewById(R.id.txtVenta);
        txtCompra=(EditText) findViewById(R.id.txtCompra);
        txtCantidad=(EditText) findViewById(R.id.txtCantidad);
        btnEnviar=(Button) findViewById(R.id.btnEnviar);
        btnLimpiar=(Button) findViewById(R.id.btnLimpiar);
        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtCodigo.setText("");
                txtDescripcion.setText("");
                txtUnidad.setText("");
                txtVenta.setText("");
                txtCompra.setText("");
                txtCantidad.setText("");
            }
        });
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtCodigo.getText().toString().matches("")|| txtDescripcion.getText().toString().matches("")||
                txtUnidad.getText().toString().matches("")|| txtVenta.getText().toString().matches("")||
                        txtCompra.getText().toString().matches("")|| txtCantidad.getText().toString().matches("")){
                    Toast.makeText(MainActivity.this, "Faltan rellenar campos", Toast.LENGTH_SHORT).show();
                }
                else{
                    String codigo=txtCodigo.getText().toString();
                    String descripcion=txtDescripcion.getText().toString();
                    String unidad=txtUnidad.getText().toString();
                    String venta=txtVenta.getText().toString();
                    String compra=txtCompra.getText().toString();
                    String cantidad=txtCantidad.getText().toString();

                    Intent intent = new Intent(MainActivity.this, Producto.class);
                    intent.putExtra("Codigo",codigo);
                    intent.putExtra("Descripcion",descripcion);
                    intent.putExtra("Unidad",unidad);
                    intent.putExtra("Venta",venta);
                    intent.putExtra("Compra",compra);
                    intent.putExtra("Cantidad",cantidad);
                    startActivity(intent);

                }
            }
        });
    }
}
