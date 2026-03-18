/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofacturacion;

import java.sql.*;

public class ProductosDAO {

    public void insertarProducto(Producto producto) {
        Conexion con = new Conexion();
        Connection conexion = con.getConnection();

        String sql = "INSERT INTO productos(codigo, nombre, marca, precio_venta, stock, fecha_vencimiento, imagen) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, producto.getCodigo());
            ps.setString(2, producto.getNombre());
            ps.setString(3, producto.getMarca());
            ps.setDouble(4, producto.getPrecioVenta());
            ps.setInt(5, producto.getStock());
            ps.setString(6, producto.getFechaVencimiento());
            ps.setString(7, producto.getImagen());

            ps.executeUpdate();
            System.out.println("✅ Producto insertado");

        } catch (SQLException e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }

    public void mostrarProductos() {
        Conexion con = new Conexion();
        Connection conexion = con.getConnection();

        String sql = "SELECT * FROM productos";

        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id_productos"));
                System.out.println("Nombre: " + rs.getString("nombre"));
                System.out.println("Precio: " + rs.getDouble("precio_venta"));
                System.out.println("Stock: " + rs.getInt("stock"));
                System.out.println("----------------------");
            }

        } catch (SQLException e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }

    public void actualizarProducto(int id, double nuevoPrecio) {
        Conexion con = new Conexion();
        Connection conexion = con.getConnection();

        String sql = "UPDATE productos SET precio_venta=? WHERE id_productos=?";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setDouble(1, nuevoPrecio);
            ps.setInt(2, id);

            ps.executeUpdate();
            System.out.println("✅ Producto actualizado");

        } catch (SQLException e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }

    public void eliminarProducto(int id) {
        Conexion con = new Conexion();
        Connection conexion = con.getConnection();

        String sql = "DELETE FROM productos WHERE id_productos=?";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();
            System.out.println("✅ Producto eliminado");

        } catch (SQLException e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }
}