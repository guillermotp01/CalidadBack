package com.proyecto.calidad.application;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.calidad.adapter.out.persistence.entity.UserEntity;
import com.proyecto.calidad.infrastructure.UsuarioRepository;

@Service
public class UsuarioService {

    /*
    @Autowired
    private UsuarioRepository usuarioRepository;


    public ArrayList<UserEntity> Listar(){
        return (ArrayList<UserEntity>) usuarioRepository.findAll();
    }

    public UserEntity Guardar(UserEntity userEntity){
        return usuarioRepository.save(userEntity);
    }

    public UserEntity BuscarPorId(int id){
        return usuarioRepository.findById(id).get();
    }

    public void Eliminar(int id){
        usuarioRepository.deleteById(id);
    }

    public UserEntity Actualizar(UserEntity request, Integer id){
        UserEntity userEntity = usuarioRepository.findById(id).get();
        userEntity.setNombre(request.getNombre());
        userEntity.setApellido(request.getApellido());
        userEntity.setTipo_documento(request.getTipo_documento());
        userEntity.setNro_documento(request.getNro_documento());
        userEntity.setCorreo(request.getCorreo());
        userEntity.setUsername(request.getUsername());
        userEntity.setPassword(request.getPassword());
        userEntity.setDireccion(request.getDireccion());
        userEntity.setCelular(request.getCelular());
        userEntity.setRol(request.getRol());

        return usuarioRepository.save(userEntity);
    }

    public UserEntity obtenerUsuario(String username) {
        return usuarioRepository.findByUsername(username);
    }

    public boolean existeNombreUsuario(String username) {
        return usuarioRepository.existsByUsername(username);
    }

    public boolean existeNombre(String nombre) {
        return usuarioRepository.existsByNombre(nombre);
    }*/
}
