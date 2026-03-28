/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofacturacion;

public class Venta {
    
    private int idVenta;
    private double total;

    public double calcularTotalVenta(double precio, int cantidad) {
        total = precio * cantidad;
        return total;
    }
}
