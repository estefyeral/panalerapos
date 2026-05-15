package com.mycompany.proyectofacturacion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static final String URL = "jdbc:mysql://localhost:3306/panalera?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "3108759090";

    public Connection getConnection() {
        Connection con = null;
        try {
            // 🔥 ESTA LÍNEA ES LA CLAVE
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅ Conexión exitosa");

        } catch (ClassNotFoundException e) {
            System.out.println("❌ Driver no encontrado: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("❌ Error de conexión: " + e.getMessage());
        }
        return con;
    }
}