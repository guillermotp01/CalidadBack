package com.proyecto.calidad.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.proyecto.calidad.models.Categoria;
import com.proyecto.calidad.models.Producto;
import com.proyecto.calidad.repositories.ProductoRepository;

@Service
public class ProductoService {
    
    @Autowired
    private ProductoRepository productoRepository;

    public ArrayList<Producto> Listar(){
        return (ArrayList<Producto>) productoRepository.findAll();
    }

    public Producto Guardar(Producto producto){
        return productoRepository.save(producto);
    }

    public Producto BuscarPorId(int id){
        return productoRepository.findById(id).get();
    }

    public void Eliminar(int id){
        productoRepository.deleteById(id);
    }

    public boolean existeNombre(String nombre) {
        return productoRepository.existsByNombre(nombre);
    }

    public Producto Actualizar(Producto request, Integer id){
        Producto producto = productoRepository.findById(id).get();
        producto.setNombre(request.getNombre());
        producto.setDescripcion(request.getDescripcion());
        producto.setPrecio(request.getPrecio());
        producto.setStock(request.getStock());
        producto.setImagen(request.getImagen());
        producto.setCategoria(request.getCategoria());
        producto.setProveedor(request.getProveedor());

        return productoRepository.save(producto);
    }

    public List<Producto> obtenerPorCategoria(Categoria categoria) {
        return productoRepository.findByCategoria(categoria);
    }

    public List<Producto> buscarPorNombreODescripcion(String query) {
        List<Producto> productosPorNombre = productoRepository.findByNombreContainingIgnoreCase(query);
        List<Producto> productosPorDescripcion = productoRepository.findByDescripcionContainingIgnoreCase(query);
    
        productosPorNombre.addAll(productosPorDescripcion);
        return productosPorNombre.stream().distinct().toList();
    }

    public Page<Producto> listarPaginado(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return productoRepository.findAll(pageable);
    }
}
