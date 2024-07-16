package com.proyecto.calidad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.proyecto.calidad.models.Categoria;


public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
    
}