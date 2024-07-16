package com.proyecto.calidad.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.proyecto.calidad.models.Producto;
import com.proyecto.calidad.models.Usuario;
import com.proyecto.calidad.services.UsuarioService;


@RestController
@RequestMapping("/usuario")
@CrossOrigin("*")
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/listar")
    public ArrayList<Usuario> Listar() {
        return this.usuarioService.Listar();
    }

    @PostMapping("/registrar")
    public Usuario Guardar(@RequestBody Usuario usuario) {
        String passwordEncriptado = passwordEncoder.encode(usuario.getPassword());
        usuario.setPassword(passwordEncriptado);
        return this.usuarioService.Guardar(usuario);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarUsuario(@PathVariable("id") Integer usuarioId) {
        this.usuarioService.Eliminar(usuarioId);
    }

    @GetMapping("/obtener/{username}")
    public Usuario obtenerUsuario(@PathVariable("username") String username) {
            return this.usuarioService.obtenerUsuario(username);
    }

    @PutMapping("/actualizar/{id}")
    public Usuario Actualizar( @RequestBody Usuario usuario, @PathVariable("id") int id){
        return this.usuarioService.Actualizar(usuario, id);
    }

    @GetMapping("/existeUsuario/{username}")
    public ResponseEntity<Boolean> existeNombreUsuario(@PathVariable String username) {
        boolean exists = this.usuarioService.existeNombreUsuario(username);
        return new ResponseEntity<>(exists, HttpStatus.OK);
    }

    @GetMapping("/existe/{nombre}")
    public ResponseEntity<Boolean> existeNombre(@PathVariable String nombre) {
        boolean exists = this.usuarioService.existeNombre(nombre);
        return new ResponseEntity<>(exists, HttpStatus.OK);
    }
}
