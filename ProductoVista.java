package Vista;

import Servicio.ProductoServicio;
import Modelo.Producto;
import java.util.List;
import java.util.Scanner;

public class ProductoVista {

    private ProductoServicio productoServicio;
    private Scanner scanner;

    public ProductoVista() {
        productoServicio = new ProductoServicio();
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        while (true) {
            System.out.println("MENU INVENTARIOS KD ELECTRONICS");
            System.out.println("1. Crear producto");
            System.out.println("2. Actualizar producto");
            System.out.println("3. Eliminar producto");
            System.out.println("4. Ver todos los productos");
            System.out.println("5. Salir");
            System.out.println("Seleccione una opción");


            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (opcion) {
                case 1:
                    crearProducto();
                    break;
                case 2:
                    actualizarProducto();
                    break;
                case 3:
                    eliminarProducto();
                    break;
                case 4:
                    verTodosLosProductos();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }
    }

    private void crearProducto() {
        System.out.println("Ingrese el nombre del producto:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese la descripción del producto:");
        String descripcion = scanner.nextLine();
        System.out.println("Ingrese el precio base del producto:");
        double precioBase = scanner.nextDouble();
        System.out.println("Ingrese el precio de venta del producto:");
        double precioVenta = scanner.nextDouble();
        System.out.println("Ingrese la categoría del producto:");
        String categoria = scanner.next();
        System.out.println("Ingrese la cantidad disponible del producto:");
        int cantidadDisponible = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        productoServicio.createProducto(nombre, descripcion, precioBase, precioVenta, categoria, cantidadDisponible);
    }

    private void actualizarProducto() {
        System.out.println("Ingrese el código del producto a actualizar:");
        int codigo = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.println("Ingrese el nuevo nombre del producto:");
        String nuevoNombre = scanner.nextLine();
        System.out.println("Ingrese la nueva descripción del producto:");
        String nuevaDescripcion = scanner.nextLine();
        System.out.println("Ingrese el nuevo precio base del producto:");
        double nuevoPrecioBase = scanner.nextDouble();
        System.out.println("Ingrese el nuevo precio de venta del producto:");
        double nuevoPrecioVenta = scanner.nextDouble();
        System.out.println("Ingrese la nueva categoría del producto:");
        String nuevaCategoria = scanner.next();
        System.out.println("Ingrese la nueva cantidad disponible del producto:");
        int nuevaCantidadDisponible = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        productoServicio.updateProducto(codigo, nuevoNombre, nuevaDescripcion, nuevoPrecioBase, nuevoPrecioVenta, nuevaCategoria, nuevaCantidadDisponible);
    }

    private void eliminarProducto() {
        System.out.println("Ingrese el código del producto a eliminar:");
        int codigo = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        productoServicio.deleteProducto(codigo);
    }

    private void verTodosLosProductos() {
        List<Producto> productos = productoServicio.getAllProductos();

        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------- ");
        System.out.printf("%-15s %-30s %-50s %-15s %-15s %-20s %-20s%n ", "Código", "Nombre", "Descripción", "Precio Base", "Precio Venta", "Categoría", "Cantidad Disponible");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");

        for (Producto producto : productos) {
            System.out.printf("%-15d %-30s %-50s %-15.2f %-15.2f %-20s %-20d%n", 
                producto.getCodigoProducto(), 
                producto.getNombre(), 
                producto.getDescripcion(), 
                producto.getPrecioBase(), 
                producto.getPrecioVenta(), 
                producto.getCategoria(), 
                producto.getCantidadDisponible());
        }

        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    public static void main(String[] args) {
        ProductoVista vista = new ProductoVista();
        vista.mostrarMenu();
    }
}

