package Modelo;

import java.io.Serializable;

public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;

    private int codigoProducto;
    private String nombre;
    private String descripcion;
    private double precioBase;
    private double precioVenta;
    private String categoria;
    private int cantidadDisponible;

    // Constructor vacío
    public Producto() {
    }

    // Constructor sin el parámetro codigoProducto
    public Producto(String nombre, String descripcion, double precioBase, double precioVenta, String categoria, int cantidadDisponible) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioBase = precioBase;
        this.precioVenta = precioVenta;
        this.categoria = categoria;
        this.cantidadDisponible = cantidadDisponible;
    }

    // Constructor con todos los parámetros
    public Producto(int codigoProducto, String nombre, String descripcion, double precioBase, double precioVenta, String categoria, int cantidadDisponible) {
        this.codigoProducto = codigoProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioBase = precioBase;
        this.precioVenta = precioVenta;
        this.categoria = categoria;
        this.cantidadDisponible = cantidadDisponible;
    }

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "codigoProducto=" + codigoProducto +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precioBase=" + precioBase +
                ", precioVenta=" + precioVenta +
                ", categoria='" + categoria + '\'' +
                ", cantidadDisponible=" + cantidadDisponible +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Producto producto = (Producto) obj;
        return codigoProducto == producto.codigoProducto;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(codigoProducto);
    }
}
