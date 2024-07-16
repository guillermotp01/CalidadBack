package com.proyecto.calidad.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.proyecto.calidad.models.Carrito;
import com.proyecto.calidad.models.Usuario;

public interface CarritoRepository extends JpaRepository<Carrito, Integer> {
    Carrito findByUsuarioId(int usuarioId);
    List<Carrito> findByUsuario(Usuario usuario);
    @Query("SELECT c FROM Carrito c JOIN c.detallesCarrito d WHERE d.id = :detalleId")
    Optional<Carrito> findByDetalleCarritoId(@Param("detalleId") Integer detalleId);
    Optional<Carrito> findByUsuarioAndEstado(Usuario usuario, String estado);
    List<Carrito> findAllByUsuarioAndEstado(Usuario usuario, String estado);
    Page<Carrito> findByUsuario(Usuario usuario, Pageable pageable);
}
