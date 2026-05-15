/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplo.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.ejemplo.demo.entity.Usuario;
import com.ejemplo.demo.repository.UsuarioRepository;
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
 @Autowired
 private UsuarioRepository repo;
 // CREAR USUARIO
 @PostMapping
 public String guardar(@RequestBody Usuario usuario) {
 repo.save(usuario);
 return "Usuario guardado correctamente";
 }
 // LISTAR USUARIOS
 @GetMapping
 public List<Usuario> listar() {
 return repo.findAll();
 }
}