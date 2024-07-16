package com.proyecto.calidad.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.calidad.models.Carrito;
import com.proyecto.calidad.repositories.CarritoRepository;
import com.proyecto.calidad.repositories.DetalleCarritoRepository;

@Service
public class DetalleCarritoService {
    
    @Autowired
    private DetalleCarritoRepository detalleCarritoRepository;
    

    @Autowired
    private CarritoRepository carritoRepository;

    @Transactional
    public void eliminarDetalle(int detalleId) {
        // Buscar el carrito al que pertenece el detalle
        Carrito carrito = carritoRepository.findByDetalleCarritoId(detalleId)
                .orElseThrow(() -> new IllegalArgumentException("Carrito no encontrado para este detalle"));

        // Eliminar el detalle del carrito
        detalleCarritoRepository.deleteById(detalleId);

        // Remover el detalle del carrito en la entidad
        carrito.getDetallesCarrito().removeIf(detalle -> detalle.getId().equals(detalleId));

        // Actualizar los totales del carrito y guardar
        carrito.actualizarTotales();
        carritoRepository.save(carrito);
    }
}
