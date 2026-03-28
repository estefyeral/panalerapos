/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofacturacion;

/**
 *
 * @author estef
 */
public class Cliente {
    
    private int idCliente;
    private String nombreCliente;
    private String telefono;

    public Cliente(int idCliente, String nombreCliente, String telefono) {
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.telefono = telefono;
    }

    public void registrarCliente() {
        System.out.println("Cliente registrado correctamente");
    }

}
   
