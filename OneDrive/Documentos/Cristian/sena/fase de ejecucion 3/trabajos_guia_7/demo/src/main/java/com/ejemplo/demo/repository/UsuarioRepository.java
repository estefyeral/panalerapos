/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ejemplo.demo.repository;

// IMPORTS 
import org.springframework.data.jpa.repository.JpaRepository; 
import com.ejemplo.demo.entity.Usuario; 
// INTERFAZ 
public interface UsuarioRepository extends JpaRepository<Usuario, Long> { 
// MÉTODO PARA LOGIN 
Usuario findByCorreoAndPassword(String correo, String password); 
}
