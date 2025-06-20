package com.proyecto.calidad.application;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.proyecto.calidad.adapter.out.persistence.entity.CategoryEntity;
import com.proyecto.calidad.adapter.out.persistence.entity.ProductEntity;
import com.proyecto.calidad.infrastructure.ProductoRepository;

@Service
public class ProductoService {
    
    /*@Autowired
    private ProductoRepository productoRepository;

    public ArrayList<ProductEntity> Listar(){
        return (ArrayList<ProductEntity>) productoRepository.findAll();
    }

    public ProductEntity Guardar(ProductEntity productEntity){
        return productoRepository.save(productEntity);
    }

    public ProductEntity BuscarPorId(int id){
        return productoRepository.findById(id).get();
    }

    public void Eliminar(int id){
        productoRepository.deleteById(id);
    }

    public boolean existeNombre(String nombre) {
        return productoRepository.existsByNombre(nombre);
    }

    public ProductEntity Actualizar(ProductEntity request, Integer id){
        ProductEntity productEntity = productoRepository.findById(id).get();
        productEntity.setNombre(request.getNombre());
        productEntity.setDescripcion(request.getDescripcion());
        productEntity.setPrecio(request.getPrecio());
        productEntity.setStock(request.getStock());
        productEntity.setImagen(request.getImagen());
        productEntity.setCategoryEntity(request.getCategoryEntity());
        productEntity.setProveedor(request.getProveedor());

        return productoRepository.save(productEntity);
    }

    public List<ProductEntity> obtenerPorCategoria(CategoryEntity categoryEntity) {
        return productoRepository.findByCategoria(categoryEntity);
    }

    public List<ProductEntity> buscarPorNombreODescripcion(String query) {
        List<ProductEntity> productosPorNombre = productoRepository.findByNombreContainingIgnoreCase(query);
        List<ProductEntity> productosPorDescripcion = productoRepository.findByDescripcionContainingIgnoreCase(query);
    
        productosPorNombre.addAll(productosPorDescripcion);
        return productosPorNombre.stream().distinct().toList();
    }

    public Page<ProductEntity> listarPaginado(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return productoRepository.findAll(pageable);
    }*/
}
