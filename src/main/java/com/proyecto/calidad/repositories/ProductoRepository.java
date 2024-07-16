package com.proyecto.calidad.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.proyecto.calidad.models.Categoria;
import com.proyecto.calidad.models.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    public Producto findByNombre(String nombre);
    boolean existsByNombre(String nombre);
    List<Producto> findByCategoria(Categoria categoria);
    List<Producto> findByNombreContainingIgnoreCase(String nombre);
    List<Producto> findByDescripcionContainingIgnoreCase(String descripcion);
    @SuppressWarnings("null")
    Page<Producto> findAll(Pageable pageable);
}
