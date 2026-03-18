/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofacturacion;

public class Producto {

    private int idProductos;
    private String codigo;
    private String nombre;
    private String marca;
    private double precioVenta;
    private int stock;
    private String fechaVencimiento;
    private String imagen;

    public Producto(int idProductos, String codigo, String nombre, String marca, double precioVenta, int stock, String fechaVencimiento, String imagen) {
        this.idProductos = idProductos;
        this.codigo = codigo;
        this.nombre = nombre;
        this.marca = marca;
        this.precioVenta = precioVenta;
        this.stock = stock;
        this.fechaVencimiento = fechaVencimiento;
        this.imagen = imagen;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMarca() {
        return marca;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public int getStock() {
        return stock;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public String getImagen() {
        return imagen;
    }
}