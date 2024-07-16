package com.proyecto.calidad.controllers;

import com.proyecto.calidad.models.Categoria;
import com.proyecto.calidad.models.Producto;
import com.proyecto.calidad.services.CategoriaService;
import com.proyecto.calidad.services.ProductoService;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/producto")
@CrossOrigin("*")
public class ProductoController {
    
    @Autowired
    private ProductoService productoService;

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/listar")
    public ArrayList<Producto> Listar() {
        return this.productoService.Listar();
    }

    @PostMapping("/registrar")
    public Producto Guardar(@RequestBody Producto producto) {
        return this.productoService.Guardar(producto);
    }
    
    @DeleteMapping("/eliminar/{id}")
    public void eliminarProducto(@PathVariable("id") Integer productoId) {
        this.productoService.Eliminar(productoId);
    }

    @GetMapping("/obtener/{id}")
    public Producto obtenerProducto(@PathVariable("id") Integer id) {
        return this.productoService.BuscarPorId(id);
    }

    @PutMapping("/actualizar/{id}")
    public Producto Actualizar( @RequestBody Producto producto, @PathVariable("id") int id){
        return this.productoService.Actualizar(producto, id);
    }

    @GetMapping("/existeProducto/{nombre}")
    public ResponseEntity<Boolean> existeNombreProducto(@PathVariable String nombre) {
        boolean exists = this.productoService.existeNombre(nombre);
        return new ResponseEntity<>(exists, HttpStatus.OK);
    }

    @GetMapping("/buscarCategoria/{categoriaId}")
    public List<Producto> obtenerProductosPorCategoria(@PathVariable Integer categoriaId) {
        Categoria categoria = categoriaService.Listar().stream()
                                .filter(cat -> cat.getId().equals(categoriaId))
                                .findFirst()
                                .orElse(null);
        if (categoria == null) {
            throw new RuntimeException("Categoría no encontrada");
        }
        return productoService.obtenerPorCategoria(categoria);
    }

    @GetMapping("/buscar")
    public List<Producto> buscar(@RequestParam("query") String query) {
        return productoService.buscarPorNombreODescripcion(query);
    }

    @SuppressWarnings("null")
    @GetMapping("/listarPaginado")
    public ResponseEntity<Page<Producto>> listarProductosPaginado(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "6") int size) {
        try {
            Page<Producto> productos = productoService.listarPaginado(page, size);
            if (productos.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(productos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
