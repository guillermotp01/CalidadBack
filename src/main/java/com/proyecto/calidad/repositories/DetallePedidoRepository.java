package com.proyecto.calidad.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.calidad.models.DetallePedido;

public interface DetallePedidoRepository extends JpaRepository<DetallePedido, Integer> {
    List<DetallePedido> findById(int id);
}
