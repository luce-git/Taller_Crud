package Dao;

import Modelo.Producto;
import java.util.List;

public interface ProductoDAO {
    void create(Producto producto);
    Producto read(int codigoProducto);  // int
    void update(Producto producto);
    void delete(int codigoProducto);    // int
    List<Producto> getAll();
}

