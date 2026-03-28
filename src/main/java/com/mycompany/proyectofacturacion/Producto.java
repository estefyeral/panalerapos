package com.mycompany.proyectofacturacion;

public class Producto {

    private int id_Producto;
    private final String codigo;
    private final String nombre;
    private final String marca;
    private final double precioVenta;
    private final int stock;
    private final String fechaVencimiento;
    private final String imagen;

    public Producto(int idProductos, String codigo, String nombre, String marca, double precioVenta, int stock, String fechaVencimiento, String imagen) {
        this.id_Producto = idProductos;
        this.codigo = codigo;
        this.nombre = nombre;
        this.marca = marca;
        this.precioVenta = precioVenta;
        this.stock = stock;
        this.fechaVencimiento = fechaVencimiento;
        this.imagen = imagen;
    }

    // 🔥 ESTE ES EL QUE TE FALTABA
    public int getId() {
        return id_Producto;
    }

    public void setId(int id) {
        this.id_Producto = id;
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