package Servicio;

import Modelo.Producto;
import Dao.ProductoDaoI;
import java.util.List;

public class ProductoServicio {

    private ProductoDaoI productoDao;

    public ProductoServicio() {
        this.productoDao = new ProductoDaoI(); // Inicialización del DAO
    }

    public void createProducto(String nombre, String descripcion, double precioBase, double precioVenta, String categoria, int cantidadDisponible) {
        Producto producto = new Producto(nombre, descripcion, precioBase, precioVenta, categoria, cantidadDisponible);
        productoDao.create(producto);
    }

    public void updateProducto(int codigoProducto, String nuevoNombre, String nuevaDescripcion, double nuevoPrecioBase, double nuevoPrecioVenta, String nuevaCategoria, int nuevaCantidadDisponible) {
        Producto producto = new Producto(codigoProducto, nuevoNombre, nuevaDescripcion, nuevoPrecioBase, nuevoPrecioVenta, nuevaCategoria, nuevaCantidadDisponible);
        productoDao.update(producto);
    }

    public void deleteProducto(int codigoProducto) {
        productoDao.delete(codigoProducto);
    }

    public Producto getProducto(int codigoProducto) {
        return productoDao.read(codigoProducto);
    }

    public List<Producto> getAllProductos() {
        return productoDao.getAll();
    }
}


