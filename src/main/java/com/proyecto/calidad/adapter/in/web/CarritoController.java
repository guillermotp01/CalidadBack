package com.proyecto.calidad.adapter.in.web;

import com.proyecto.calidad.adapter.out.persistence.entity.CarEntity;
import com.proyecto.calidad.adapter.out.persistence.entity.UserEntity;
import com.proyecto.calidad.application.CarritoService;
import com.proyecto.calidad.application.DetalleCarritoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/carrito")
@CrossOrigin("*")
public class CarritoController {

    /*
    @Autowired
    private CarritoService carritoService;

    @Autowired
    private DetalleCarritoService detalleCarritoService;

    @PostMapping("/agregar")
    public ResponseEntity<Map<String, Object>> agregarProducto(@RequestBody Map<String, Object> body, Authentication authentication) {
        Integer productoId = (Integer) body.get("productoId");
        Integer cantidad = (Integer) body.get("cantidad");

        Map<String, Object> response = new HashMap<>();

        if (productoId == null || cantidad == null) {
            response.put("success", false);
            response.put("message", "Los campos 'productoId' y 'cantidad' son requeridos");
            return ResponseEntity.badRequest().body(response);
        }

        UserEntity userEntity = (UserEntity) authentication.getPrincipal();

        try {
            carritoService.agregarProducto(productoId, cantidad, userEntity);
                response.put("success", true);
            response.put("message", "Producto agregado al carrito");
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            response.put("success", false);
            response.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<?> obtenerCarrito(Authentication authentication) {
        UserEntity userEntity = (UserEntity) authentication.getPrincipal();
        return ResponseEntity.ok(carritoService.obtenerCarritosPendientes(userEntity));
    }

    @GetMapping("/listarTodo")
    public List<CarEntity> obtenerCarrito() {
        return this.carritoService.obtenerTodasCompras();
    }

    @PostMapping("/confirmar")
    public ResponseEntity<Map<String, String>> confirmarCarrito(Authentication authentication) {
        UserEntity userEntity = (UserEntity) authentication.getPrincipal();
        Map<String, String> response = new HashMap<>();
    
        try {
            carritoService.confirmarCarrito(userEntity);
            response.put("message", "Carrito confirmado");
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            response.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }
    

    @GetMapping("/misCompras")
    public ResponseEntity<?> obtenerCompras(Authentication authentication) {
        UserEntity userEntity = (UserEntity) authentication.getPrincipal();
        return ResponseEntity.ok(carritoService.obtenerComprasConfirmadas(userEntity));
    }

    @GetMapping("/obtener/{id}")
    public ResponseEntity<?> obtenerCarrito(@PathVariable("id") Integer id) {
        try {
            CarEntity carEntity = carritoService.obtenerCarritoPorId(id);
            return ResponseEntity.ok(carEntity);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarDetalleCarrito(@PathVariable("id") Integer detalleId) {
        try {
            detalleCarritoService.eliminarDetalle(detalleId);
            Map<String, String> response = new HashMap<>();
            response.put("message", "Detalle de carrito eliminado correctamente.");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            Map<String, String> response = new HashMap<>();
            response.put("message", "Error al eliminar el detalle de carrito: " + e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }*/
}