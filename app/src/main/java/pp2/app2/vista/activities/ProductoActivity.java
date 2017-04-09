package pp2.app2.vista.activities;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import pp2.app2.R;
import pp2.app2.modelo.Producto;

public class ProductoActivity extends AppCompatActivity {

    private Producto actual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto);

        String id_producto = getIntent().getStringExtra("id_producto");
        String nombre_producto = getIntent().getStringExtra("nombre_producto");
        String categoria_producto = getIntent().getStringExtra("categoria_producto");

        this.actual = new Producto(Integer.valueOf(id_producto), nombre_producto, Integer.valueOf(categoria_producto));

        TextView producto_categoria = (TextView)findViewById(R.id.producto_categoria);
        producto_categoria.setText(""+actual.getIdCategoria());

        TextView producto_nombre = (TextView)findViewById(R.id.producto_nombre);
        producto_nombre.setText(actual.getNombre());

        FloatingActionButton fab_agregar = (FloatingActionButton) findViewById(R.id.fab_agregar);
        fab_agregar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(),
                        "Se agregó el producto " + actual.getNombre() + " al carrito (mentira)",
                        Toast.LENGTH_SHORT).show();

            }
        });

        /* para recibir data de activities
        Bundle b = getIntent().getExtras();
        producto_id = -1;
        if(b != null)
            producto_id = b.getInt("id");

        // busco en el catalogo por id
        catalogoController = new AppController();
        List<Producto> productos = catalogoController.getCatalogo(getResources());
        this.actual = catalogoController.getProducto(productos, producto_id); */

    }
}
