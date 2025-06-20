package com.proyecto.calidad.adapter.in.web;

import com.proyecto.calidad.adapter.out.persistence.entity.CategoryEntity;
import com.proyecto.calidad.adapter.out.persistence.entity.ProductEntity;
import com.proyecto.calidad.application.CategoriaService;
import com.proyecto.calidad.application.ProductoService;
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
    /*
    @Autowired
    private ProductoService productoService;

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/listar")
    public ArrayList<ProductEntity> Listar() {
        return this.productoService.Listar();
    }

    @PostMapping("/registrar")
    public ProductEntity Guardar(@RequestBody ProductEntity productEntity) {
        return this.productoService.Guardar(productEntity);
    }
    
    @DeleteMapping("/eliminar/{id}")
    public void eliminarProducto(@PathVariable("id") Integer productoId) {
        this.productoService.Eliminar(productoId);
    }

    @GetMapping("/obtener/{id}")
    public ProductEntity obtenerProducto(@PathVariable("id") Integer id) {
        return this.productoService.BuscarPorId(id);
    }

    @PutMapping("/actualizar/{id}")
    public ProductEntity Actualizar(@RequestBody ProductEntity productEntity, @PathVariable("id") int id){
        return this.productoService.Actualizar(productEntity, id);
    }

    @GetMapping("/existeProducto/{nombre}")
    public ResponseEntity<Boolean> existeNombreProducto(@PathVariable String nombre) {
        boolean exists = this.productoService.existeNombre(nombre);
        return new ResponseEntity<>(exists, HttpStatus.OK);
    }

    @GetMapping("/buscarCategoria/{categoriaId}")
    public List<ProductEntity> obtenerProductosPorCategoria(@PathVariable Integer categoriaId) {
        CategoryEntity categoryEntity = categoriaService.Listar().stream()
                                .filter(cat -> cat.getId().equals(categoriaId))
                                .findFirst()
                                .orElse(null);
        if (categoryEntity == null) {
            throw new RuntimeException("Categoría no encontrada");
        }
        return productoService.obtenerPorCategoria(categoryEntity);
    }

    @GetMapping("/buscar")
    public List<ProductEntity> buscar(@RequestParam("query") String query) {
        return productoService.buscarPorNombreODescripcion(query);
    }

    @SuppressWarnings("null")
    @GetMapping("/listarPaginado")
    public ResponseEntity<Page<ProductEntity>> listarProductosPaginado(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "6") int size) {
        try {
            Page<ProductEntity> productos = productoService.listarPaginado(page, size);
            if (productos.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(productos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }*/
}
