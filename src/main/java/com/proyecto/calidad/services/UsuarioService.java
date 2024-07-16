package com.proyecto.calidad.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.calidad.models.Producto;
import com.proyecto.calidad.models.Usuario;
import com.proyecto.calidad.repositories.UsuarioRepository;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;


    public ArrayList<Usuario> Listar(){
        return (ArrayList<Usuario>) usuarioRepository.findAll();
    }

    public Usuario Guardar(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public Usuario BuscarPorId(int id){
        return usuarioRepository.findById(id).get();
    }

    public void Eliminar(int id){
        usuarioRepository.deleteById(id);
    }

    public Usuario Actualizar(Usuario request, Integer id){
        Usuario usuario = usuarioRepository.findById(id).get();
        usuario.setNombre(request.getNombre());
        usuario.setApellido(request.getApellido());
        usuario.setTipo_documento(request.getTipo_documento());
        usuario.setNro_documento(request.getNro_documento());
        usuario.setCorreo(request.getCorreo());
        usuario.setUsername(request.getUsername());
        usuario.setPassword(request.getPassword());
        usuario.setDireccion(request.getDireccion());
        usuario.setCelular(request.getCelular());
        usuario.setRol(request.getRol());

        return usuarioRepository.save(usuario);
    }

    public Usuario obtenerUsuario(String username) {
        return usuarioRepository.findByUsername(username);
    }

    public boolean existeNombreUsuario(String username) {
        return usuarioRepository.existsByUsername(username);
    }

    public boolean existeNombre(String nombre) {
        return usuarioRepository.existsByNombre(nombre);
    }
}
