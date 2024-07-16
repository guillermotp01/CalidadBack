package com.proyecto.calidad.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.calidad.models.Carrito;
import com.proyecto.calidad.models.DetalleCarrito;
import com.proyecto.calidad.models.Producto;
import com.proyecto.calidad.models.Usuario;
import com.proyecto.calidad.repositories.CarritoRepository;
import com.proyecto.calidad.repositories.DetalleCarritoRepository;
import com.proyecto.calidad.repositories.ProductoRepository;
import java.util.List;
import java.util.Optional;

@Service
public class CarritoService {

    @Autowired
    private CarritoRepository carritoRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private DetalleCarritoRepository detalleCarritoRepository;

    public Carrito agregarProducto(Integer productoId, Integer cantidad, Usuario usuario) {
        Optional<Producto> productoOpt = productoRepository.findById(productoId);

        if (!productoOpt.isPresent()) {
            throw new IllegalArgumentException("Producto no encontrado");
        }

        Producto producto = productoOpt.get();

        Carrito carrito = carritoRepository.findByUsuarioAndEstado(usuario, "Pendiente")
                .orElseGet(() -> {
                    Carrito nuevoCarrito = new Carrito();
                    nuevoCarrito.setUsuario(usuario);
                    nuevoCarrito.setEstado("Pendiente");
                    return carritoRepository.save(nuevoCarrito);
                });

        DetalleCarrito detalleCarrito = new DetalleCarrito();
        detalleCarrito.setCarrito(carrito);
        detalleCarrito.setProducto(producto);
        detalleCarrito.setCantidad(cantidad);
        detalleCarrito.setPrecio(producto.getPrecio() * cantidad);

        detalleCarritoRepository.save(detalleCarrito);

        carrito.actualizarTotales();
        return carritoRepository.save(carrito);
    }

    public List<Carrito> obtenerTodasCompras() {
        return carritoRepository.findAll();
    }

    public List<Carrito> obtenerCarritoPorUsuario(Usuario usuario) {
        return carritoRepository.findByUsuario(usuario);
    }

    public List<Carrito> obtenerCarritosPendientes(Usuario usuario) {
        return carritoRepository.findAllByUsuarioAndEstado(usuario, "Pendiente");
    }

    public List<Carrito> obtenerComprasConfirmadas(Usuario usuario) {
        return carritoRepository.findAllByUsuarioAndEstado(usuario, "Confirmado");
    }

    public Carrito confirmarCarrito(Usuario usuario) {
        Optional<Carrito> carritoOpt = carritoRepository.findByUsuarioAndEstado(usuario, "Pendiente");

        if (!carritoOpt.isPresent() || carritoOpt.get().getDetallesCarrito().isEmpty()) {
            throw new IllegalArgumentException("Carrito vacío");
        }

        Carrito carrito = carritoOpt.get();
        carrito.setEstado("Confirmado");
        carrito.actualizarTotales();

        for (DetalleCarrito detalle : carrito.getDetallesCarrito()) {
            Producto producto = detalle.getProducto();
            int cantidad = detalle.getCantidad();
            producto.actualizarStock(cantidad); 
            productoRepository.save(producto); 
        }

        return carritoRepository.save(carrito);
    }

    public Carrito obtenerCarritoPorId(Integer id) {
        return carritoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Carrito no encontrado"));
    }
}
