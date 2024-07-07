
package Dao;

import Modelo.Producto;
import Utils.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductoDaoI implements ProductoDAO {

    @Override
    public void create(Producto producto) {
        String sql = "INSERT INTO productos (nombre, descripcion, precio_base, precio_venta, categoria, cantidad_disponible) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            System.out.println("Insertando producto: " + producto);
            stmt.setString(1, producto.getNombre());
            stmt.setString(2, producto.getDescripcion());
            stmt.setDouble(3, producto.getPrecioBase());
            stmt.setDouble(4, producto.getPrecioVenta());
            stmt.setString(5, producto.getCategoria());
            stmt.setInt(6, producto.getCantidadDisponible());

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                ResultSet generatedKeys = stmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int codigoGenerado = generatedKeys.getInt(1);
                    producto.setCodigoProducto(codigoGenerado);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Producto read(int codigoProducto) {
        Producto producto = null;
        String sql = "SELECT * FROM productos WHERE codigo_producto = ?";
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, codigoProducto);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    producto = new Producto(
                        rs.getInt("codigo_producto"),
                        rs.getString("nombre"),
                        rs.getString("descripcion"),
                        rs.getDouble("precio_base"),
                        rs.getDouble("precio_venta"),
                        rs.getString("categoria"),
                        rs.getInt("cantidad_disponible")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return producto;
    }

    @Override
    public void update(Producto producto) {
        String sql = "UPDATE productos SET nombre = ?, descripcion = ?, precio_base = ?, precio_venta = ?, categoria = ?, cantidad_disponible = ? WHERE codigo_producto = ?";
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, producto.getNombre());
            stmt.setString(2, producto.getDescripcion());
            stmt.setDouble(3, producto.getPrecioBase());
            stmt.setDouble(4, producto.getPrecioVenta());
            stmt.setString(5, producto.getCategoria());
            stmt.setInt(6, producto.getCantidadDisponible());
            stmt.setInt(7, producto.getCodigoProducto());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int codigoProducto) {
        String sql = "DELETE FROM productos WHERE codigo_producto = ?";
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, codigoProducto);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Producto> getAll() {
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT * FROM productos";
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Producto producto = new Producto(
                    rs.getInt("codigo_producto"),
                    rs.getString("nombre"),
                    rs.getString("descripcion"),
                    rs.getDouble("precio_base"),
                    rs.getDouble("precio_venta"),
                    rs.getString("categoria"),
                    rs.getInt("cantidad_disponible")
                );
                productos.add(producto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productos;
    }
}
