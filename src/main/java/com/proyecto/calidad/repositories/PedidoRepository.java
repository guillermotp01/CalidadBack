package com.proyecto.calidad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.calidad.models.Pedido;



public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

}