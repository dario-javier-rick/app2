package pp2.app2.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import pp2.app2.R;
import pp2.app2.controlador.ApplicationController;
import pp2.app2.helpers.DatosTemp;
import pp2.app2.modelo.Producto;

public class ProductoActivity extends AppCompatActivity {

    private Producto producto;
    private DatosTemp datosTemp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto);

        this.datosTemp = new DatosTemp();
        this.producto = datosTemp.obtenerProducto(102);

        this.producto = new Producto(producto.getId(), producto.getNombre(), producto.getPrecio());

        final TextView producto_nombre = (TextView)findViewById(R.id.producto_nombre);
        producto_nombre.setText(producto.getNombre());

        Button btn_preparar_pedido = (Button) findViewById(R.id.button_comprar);
        btn_preparar_pedido.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ApplicationController.recibirCommand("verSugerencias", getApplicationContext(), producto);
            }
        });

    }
}
