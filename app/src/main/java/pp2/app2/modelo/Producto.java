package pp2.app2.modelo;

import android.graphics.drawable.Drawable;

public class Producto {

    private int id;
    private String nombre;
    private int idCategoria;

    public Producto() {

    }

    Producto (int id, String nombre, int idCategoria) {

        this.id = id;
        this.nombre = nombre;
        this.idCategoria = idCategoria;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

}

