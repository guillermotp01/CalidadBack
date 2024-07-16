package com.proyecto.calidad.controllers;

import com.proyecto.calidad.models.Carrito;
import com.proyecto.calidad.models.Usuario;
import com.proyecto.calidad.services.CarritoService;
import com.proyecto.calidad.services.DetalleCarritoService;

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

        Usuario usuario = (Usuario) authentication.getPrincipal();

        try {
            carritoService.agregarProducto(productoId, cantidad, usuario);
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
        Usuario usuario = (Usuario) authentication.getPrincipal();
        return ResponseEntity.ok(carritoService.obtenerCarritosPendientes(usuario));
    }

    @GetMapping("/listarTodo")
    public List<Carrito> obtenerCarrito() {
        return this.carritoService.obtenerTodasCompras();
    }

    @PostMapping("/confirmar")
    public ResponseEntity<Map<String, String>> confirmarCarrito(Authentication authentication) {
        Usuario usuario = (Usuario) authentication.getPrincipal();
        Map<String, String> response = new HashMap<>();
    
        try {
            carritoService.confirmarCarrito(usuario);
            response.put("message", "Carrito confirmado");
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            response.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }
    

    @GetMapping("/misCompras")
    public ResponseEntity<?> obtenerCompras(Authentication authentication) {
        Usuario usuario = (Usuario) authentication.getPrincipal();
        return ResponseEntity.ok(carritoService.obtenerComprasConfirmadas(usuario));
    }

    @GetMapping("/obtener/{id}")
    public ResponseEntity<?> obtenerCarrito(@PathVariable("id") Integer id) {
        try {
            Carrito carrito = carritoService.obtenerCarritoPorId(id);
            return ResponseEntity.ok(carrito);
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
    }
}