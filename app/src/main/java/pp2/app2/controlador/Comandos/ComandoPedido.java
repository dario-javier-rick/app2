package pp2.app2.controlador.Comandos;

import pp2.app2.modelo.Carrito;

/**
 * Created by jalvarez on 10/05/2017.
 */

public class ComandoPedido
{
    private Carrito carrito;
    //El resto de los atributos pueden se cosas que pueden pasar cuando compras

    public ComandoPedido(Carrito carrito)
    {
        this.carrito = carrito;
    }

    //Podria ser un int y manejar errores, obviamente como recomienda gateway, desde el cliente
    public int realizarPedido()
    {
        //Conectarse al servidor y realizar el pedido
        //Hay que documentar que significa cada número de error
        return 0;
    }
}
