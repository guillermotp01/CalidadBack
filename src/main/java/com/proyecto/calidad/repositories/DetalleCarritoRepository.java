package com.proyecto.calidad.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.calidad.models.DetalleCarrito;

public interface DetalleCarritoRepository extends JpaRepository<DetalleCarrito, Integer> {

}