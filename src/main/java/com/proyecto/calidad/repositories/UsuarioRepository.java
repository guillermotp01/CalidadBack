package com.proyecto.calidad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.proyecto.calidad.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    public Usuario findByUsername(String username);
    boolean existsByUsername(String username);
    boolean existsByNombre(String nombre);
}
