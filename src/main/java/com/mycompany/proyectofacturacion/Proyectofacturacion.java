package com.mycompany.proyectofacturacion;

import java.util.List;
import java.util.Scanner;

public class Proyectofacturacion {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ProductosDAO dao = new ProductosDAO();

        int opcion;

        do {
            System.out.println("\n=== MENU PRODUCTOS ===");
            System.out.println("1. Insertar");
            System.out.println("2. Mostrar");
            System.out.println("3. Actualizar producto");
            System.out.println("4. Eliminar");
            System.out.println("5. Salir");
            System.out.print("Seleccione: ");

            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    sc.nextLine(); // limpiar buffer

                    System.out.print("Codigo: ");
                    String codigo = sc.nextLine();

                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    System.out.print("Marca: ");
                    String marca = sc.nextLine();

                    System.out.print("Precio: ");
                    double precio = sc.nextDouble();

                    System.out.print("Stock: ");
                    int stock = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Fecha vencimiento (YYYY-MM-DD): ");
                    String fecha = sc.nextLine();

                    System.out.print("Imagen: ");
                    String imagen = sc.nextLine();

                    Producto p = new Producto(0, codigo, nombre, marca, precio, stock, fecha, imagen);
                    dao.insertarProducto(p);
                    break;

                case 2:
                    List<Producto> lista = dao.listarProductos();

                    for (Producto prod : lista) {
                        System.out.println("ID: " + prod.getId());
                        System.out.println("Nombre: " + prod.getNombre());
                        System.out.println("Precio: " + prod.getPrecioVenta());
                        System.out.println("Stock: " + prod.getStock());
                        System.out.println("-----------------------");
                    }
                    break;

                case 3:
                    System.out.print("ID del producto: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // limpiar buffer

                    System.out.print("Nuevo nombre: ");
                    String nuevoNombre = sc.nextLine();

                    System.out.print("Nueva marca: ");
                    String nuevaMarca = sc.nextLine();

                    System.out.print("Nuevo precio: ");
                    double nuevoPrecio = sc.nextDouble();

                    System.out.print("Nuevo stock: ");
                    int nuevoStock = sc.nextInt();

                    Producto pActualizar = new Producto(
                            id,
                            "COD001",
                            nuevoNombre,
                            nuevaMarca,
                            nuevoPrecio,
                            nuevoStock,
                            "2026-12-31",
                            "img.jpg"
                    );

                    dao.actualizarProducto(pActualizar);
                    System.out.println("Producto actualizado ✔");
                    break;

                case 4:
                    System.out.print("ID del producto: ");
                    int idEliminar = sc.nextInt();

                    dao.eliminarProducto(idEliminar);
                    System.out.println("Producto eliminado ✔");
                    break;

                case 5:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida");
            }

        } while (opcion != 5);

        sc.close();
    }
}