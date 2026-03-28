package com.mycompany.proyectofacturacion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductosDAO {

    // INSERTAR
    public void insertarProducto(Producto p) {
        String sql = "INSERT INTO productos (codigo, nombre, marca, precio_venta, stock, fecha_vencimiento, imagen) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            Connection con = new Conexion().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, p.getCodigo());
            ps.setString(2, p.getNombre());
            ps.setString(3, p.getMarca());
            ps.setDouble(4, p.getPrecioVenta());
            ps.setInt(5, p.getStock());
            ps.setString(6, p.getFechaVencimiento());
            ps.setString(7, p.getImagen());

            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error insertar: " + e.getMessage());
        }
    }

    // LISTAR
    public List<Producto> listarProductos() {
        List<Producto> lista = new ArrayList<>();
        String sql = "SELECT * FROM productos";

        try {
            Connection con = new Conexion().getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                Producto p = new Producto(
                        rs.getInt("id_producto"),
                        rs.getString("codigo"),
                        rs.getString("nombre"),
                        rs.getString("marca"),
                        rs.getDouble("precio_venta"),
                        rs.getInt("stock"),
                        rs.getString("fecha_vencimiento"),
                        rs.getString("imagen")
                );
                lista.add(p);
            }

        } catch (SQLException e) {
            System.out.println("Error listar: " + e.getMessage());
        }

        return lista;
    }

    // OBTENER POR ID (CLAVE PARA EDITAR)
    public Producto obtenerPorId(int id) {
        Producto p = null;
        String sql = "SELECT * FROM productos WHERE id_producto=?";

        try {
            Connection con = new Conexion().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                p = new Producto(
                        rs.getInt("id_producto"),
                        rs.getString("codigo"),
                        rs.getString("nombre"),
                        rs.getString("marca"),
                        rs.getDouble("precio_venta"),
                        rs.getInt("stock"),
                        rs.getString("fecha_vencimiento"),
                        rs.getString("imagen")
                );
            }

        } catch (Exception e) {
            System.out.println("Error obtener: " + e.getMessage());
        }

        return p;
    }

    // ACTUALIZAR
    public void actualizarProducto(Producto p) {
        String sql = "UPDATE productos SET nombre=?, marca=?, precio_venta=?, stock=? WHERE id_producto=?";

        try {
            Connection con = new Conexion().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, p.getNombre());
            ps.setString(2, p.getMarca());
            ps.setDouble(3, p.getPrecioVenta());
            ps.setInt(4, p.getStock());
            ps.setInt(5, p.getId());

            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error actualizar: " + e.getMessage());
        }
    }

    // ELIMINAR
    public void eliminarProducto(int id) {
        String sql = "DELETE FROM productos WHERE id_producto=?";

        try {
            Connection con = new Conexion().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error eliminar: " + e.getMessage());
        }
    }
}