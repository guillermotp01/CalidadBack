package com.proyecto.calidad.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.calidad.adapter.out.persistence.entity.CarEntity;
import com.proyecto.calidad.adapter.out.persistence.entity.DetailCarEntity;
import com.proyecto.calidad.adapter.out.persistence.entity.ProductEntity;
import com.proyecto.calidad.adapter.out.persistence.entity.UserEntity;
import com.proyecto.calidad.infrastructure.CarritoRepository;
import com.proyecto.calidad.infrastructure.DetalleCarritoRepository;
import com.proyecto.calidad.infrastructure.ProductoRepository;
import java.util.List;
import java.util.Optional;

@Service
public class CarritoService {
    /*
    @Autowired
    private CarritoRepository carritoRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private DetalleCarritoRepository detalleCarritoRepository;

    public CarEntity agregarProducto(Integer productoId, Integer cantidad, UserEntity userEntity) {
        Optional<ProductEntity> productoOpt = productoRepository.findById(productoId);

        if (!productoOpt.isPresent()) {
            throw new IllegalArgumentException("Producto no encontrado");
        }

        ProductEntity productEntity = productoOpt.get();

        CarEntity carEntity = carritoRepository.findByUsuarioAndEstado(userEntity, "Pendiente")
                .orElseGet(() -> {
                    CarEntity nuevoCarEntity = new CarEntity();
                    nuevoCarEntity.setUsuario(userEntity);
                    nuevoCarEntity.setEstado("Pendiente");
                    return carritoRepository.save(nuevoCarEntity);
                });

        DetailCarEntity detailCarEntity = new DetailCarEntity();
        detailCarEntity.setCarEntity(carEntity);
        detailCarEntity.setProducto(productEntity);
        detailCarEntity.setCantidad(cantidad);
        detailCarEntity.setPrecio(productEntity.getPrecio() * cantidad);

        detalleCarritoRepository.save(detailCarEntity);

        carEntity.actualizarTotales();
        return carritoRepository.save(carEntity);
    }

    public List<CarEntity> obtenerTodasCompras() {
        return carritoRepository.findAll();
    }

    public List<CarEntity> obtenerCarritoPorUsuario(UserEntity userEntity) {
        return carritoRepository.findByUsuario(userEntity);
    }

    public List<CarEntity> obtenerCarritosPendientes(UserEntity userEntity) {
        return carritoRepository.findAllByUsuarioAndEstado(userEntity, "Pendiente");
    }

    public List<CarEntity> obtenerComprasConfirmadas(UserEntity userEntity) {
        return carritoRepository.findAllByUsuarioAndEstado(userEntity, "Confirmado");
    }

    public CarEntity confirmarCarrito(UserEntity userEntity) {
        Optional<CarEntity> carritoOpt = carritoRepository.findByUsuarioAndEstado(userEntity, "Pendiente");

        if (!carritoOpt.isPresent() || carritoOpt.get().getDetallesCarrito().isEmpty()) {
            throw new IllegalArgumentException("Carrito vacío");
        }

        CarEntity carEntity = carritoOpt.get();
        carEntity.setEstado("Confirmado");
        carEntity.actualizarTotales();

        for (DetailCarEntity detalle : carEntity.getDetallesCarrito()) {
            ProductEntity productEntity = detalle.getProducto();
            int cantidad = detalle.getCantidad();
            productEntity.actualizarStock(cantidad);
            productoRepository.save(productEntity);
        }

        return carritoRepository.save(carEntity);
    }

    public CarEntity obtenerCarritoPorId(Integer id) {
        return carritoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Carrito no encontrado"));
    }*/
}
