/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplo.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ejemplo.demo.entity.Usuario;
import com.ejemplo.demo.repository.UsuarioRepository;
@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UsuarioRepository repo;
    @PostMapping("/login")
    public String login(@RequestBody Usuario usuario) {
        Usuario encontrado = repo.findByCorreoAndPassword(
        usuario.getCorreo(),
        usuario.getPassword()
        );
        if (encontrado != null) {
        return "Bienvenido " + encontrado.getNombre();
        } else {
        return "Error: credenciales incorrectas";
        }
    }
}

