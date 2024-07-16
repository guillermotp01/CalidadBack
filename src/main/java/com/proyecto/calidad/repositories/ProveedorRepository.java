package com.proyecto.calidad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.calidad.models.Proveedor;

public interface ProveedorRepository extends JpaRepository<Proveedor, Integer> {
    
}