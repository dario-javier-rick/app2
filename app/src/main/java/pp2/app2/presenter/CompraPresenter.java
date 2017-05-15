package pp2.app2.presenter;

import android.content.Context;
import android.content.Intent;

import pp2.app2.activities.CompraActivity;
import pp2.app2.activities.SugerenciaActivity;
import pp2.app2.modelo.domain.Producto;

/**
 * Created by Jony on 14/05/2017.
 */

public class CompraPresenter {

    public void armarVista (Context context, Producto producto) {

//        Producto producto = solicitud.getItems().get(0).getProducto();

        Intent i = new Intent(context, CompraActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        i.putExtra("id_producto", String.valueOf(producto.getId().getField()));
        i.putExtra("nombre_producto", producto.getNombre());
        i.putExtra("precio_producto", String.valueOf(producto.getPrecio()));

        context.startActivity( i );
    }

}
