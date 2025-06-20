package com.proyecto.calidad.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.calidad.adapter.out.persistence.entity.CarEntity;
import com.proyecto.calidad.infrastructure.CarritoRepository;
import com.proyecto.calidad.infrastructure.DetalleCarritoRepository;

@Service
public class DetalleCarritoService {
    /*
    @Autowired
    private DetalleCarritoRepository detalleCarritoRepository;
    

    @Autowired
    private CarritoRepository carritoRepository;

    @Transactional
    public void eliminarDetalle(int detalleId) {
        // Buscar el carrito al que pertenece el detalle
        CarEntity carEntity = carritoRepository.findByDetalleCarritoId(detalleId)
                .orElseThrow(() -> new IllegalArgumentException("Carrito no encontrado para este detalle"));

        // Eliminar el detalle del carrito
        detalleCarritoRepository.deleteById(detalleId);

        // Remover el detalle del carrito en la entidad
        carEntity.getDetallesCarrito().removeIf(detalle -> detalle.getId().equals(detalleId));

        // Actualizar los totales del carrito y guardar
        carEntity.actualizarTotales();
        carritoRepository.save(carEntity);
    }*/
}
