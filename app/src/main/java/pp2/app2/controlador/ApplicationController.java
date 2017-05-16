package pp2.app2.controlador;

import android.content.Context;

import pp2.app2.controlador.comandos.ComandoMostrarProducto;
import pp2.app2.controlador.comandos.ComandoPedido;
import pp2.app2.controlador.comandos.ComandoProcesarSolicitud;
import pp2.app2.controlador.targets.TargetAgregarProducto;
import pp2.app2.controlador.targets.TargetComprar;
import pp2.app2.controlador.targets.TargetDomiciliar;
import pp2.app2.controlador.targets.TargetPagar;
import pp2.app2.modelo.domain.Carrito;
import pp2.app2.modelo.domain.Domicilio;
import pp2.app2.modelo.domain.MedioDePago;
import pp2.app2.modelo.domain.Producto;
import pp2.app2.modelo.domain.SolicitudDeCompra;
import pp2.app2.presenter.CompraFinalizadaPresenter;
import pp2.app2.presenter.CompraPresenter;
import pp2.app2.presenter.DomicilioPresenter;
import pp2.app2.presenter.PagoPresenter;
import pp2.app2.presenter.ProductoPresenter;

/**
 * Created by fcazzari on 05/05/2017.
 */

public class ApplicationController {

    private static ComandoPedido pedido;

    private static MapProximaPantalla map = new MapProximaPantalla();
    private static SolicitudDeCompra solicitud;

    private static ProductoPresenter productoPresenter = new ProductoPresenter();
    private static DomicilioPresenter domicilioPresenter = new DomicilioPresenter();
    private static PagoPresenter pagoPresenter = new PagoPresenter();
    private static CompraPresenter compraPresenter = new CompraPresenter();
    private static CompraFinalizadaPresenter compraFinalizadaPresenter = new CompraFinalizadaPresenter();

    public static void agregarProducto (Context contexto, Producto producto)
    {
        solicitud = new TargetAgregarProducto().administrar(producto);
        mostrarProximaVista(contexto, map.obtenerProximaPantalla(solicitud));
    }

    public static void confirmarDomicilio (Context context, SolicitudDeCompra solicitudDeCompra, Domicilio domicilio) {
        solicitud = new TargetDomiciliar().administrar(solicitudDeCompra, domicilio);
        mostrarProximaVista(context, map.obtenerProximaPantalla(solicitud));
    }

    public static void confirmarMedioDePago (Context context, SolicitudDeCompra solicitudp, MedioDePago medioDePago) {
        solicitud = new TargetPagar().administrar(solicitudp, medioDePago);
        mostrarProximaVista(context, map.obtenerProximaPantalla(solicitud));
    }

    public static void confirmarCompra (Context context, SolicitudDeCompra sc) {
        solicitud = new TargetComprar().administrar(sc);
        mostrarProximaVista(context, map.obtenerProximaPantalla(solicitud));
    }


    private static void mostrarProximaVista(Context contexto, String proximaVista)
    {
        if(contexto != null)    //Para los test.
        {
            switch(proximaVista) {
                //Listar las vistas
                case "sinProductos":
                    // productoPresenter.armarVista(contexto);
                    break;
                case "elegirDomicilio":
                    domicilioPresenter.armarVista(contexto, solicitud);
                    break;
                case "medioDePago":
                    pagoPresenter.armarVista(contexto, solicitud);
                    break;
                case "finalizarCompra":
                    compraPresenter.armarVista(contexto, solicitud);
                case "verCompraFinalizada":
                    compraFinalizadaPresenter.armarVista(contexto, solicitud);
                    break;
                default:
                    break;
            }
        }

    }

    public static void prepararPedido (Context contexto, Producto producto) {

        Carrito carrito = new Carrito();
        carrito.agregarItem(producto);

        pedido = new ComandoPedido(carrito);

        switch(pedido.execute()) {
            case 0:
                /*
                  Caso básico para comprar. Después:
                  - agregar un domicilio de entrega
                  - instanciar la solicitud (siempre va a estar en memoria)
                  - agregarle el producto
                  - llamar a la vista correspondiente
                 */
                // procesarSolicitud(contexto, producto);
                /*
                    //Mostrar vista con domicilio/s Registrados
                    mostrarVistaDomicilios();
                }
                else
                {
                    //Mostrar vista para ingresar domicilio
                    mostrarVistaNuevoDomicilio();
                }
                 */
                break;
            case 1:
                Mensajes.informarSinStock(contexto);
                break;
            case 2:
                Mensajes.informarErrorDeConexion(contexto);
                break;
            default:
                Mensajes.informarErrorGeneral(contexto);
                break;
        }
    }

}
