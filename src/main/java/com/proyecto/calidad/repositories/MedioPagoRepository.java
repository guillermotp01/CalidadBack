package com.proyecto.calidad.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.calidad.models.MetodoDePago;

public interface MedioPagoRepository extends JpaRepository<MetodoDePago, Integer>{
    List<MetodoDePago> findAllByNombre(String nombre);
}
