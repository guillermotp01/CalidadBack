package com.proyecto.calidad.adapter.in.web;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.proyecto.calidad.adapter.out.persistence.entity.UserEntity;
import com.proyecto.calidad.application.UsuarioService;


@RestController
@RequestMapping("/usuario")
@CrossOrigin("*")
public class UsuarioController {
    /*
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/listar")
    public ArrayList<UserEntity> Listar() {
        return this.usuarioService.Listar();
    }

    @PostMapping("/registrar")
    public UserEntity Guardar(@RequestBody UserEntity userEntity) {
        String passwordEncriptado = passwordEncoder.encode(userEntity.getPassword());
        userEntity.setPassword(passwordEncriptado);
        return this.usuarioService.Guardar(userEntity);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarUsuario(@PathVariable("id") Integer usuarioId) {
        this.usuarioService.Eliminar(usuarioId);
    }

    @GetMapping("/obtener/{username}")
    public UserEntity obtenerUsuario(@PathVariable("username") String username) {
            return this.usuarioService.obtenerUsuario(username);
    }

    @PutMapping("/actualizar/{id}")
    public UserEntity Actualizar(@RequestBody UserEntity userEntity, @PathVariable("id") int id){
        return this.usuarioService.Actualizar(userEntity, id);
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
     */
}
