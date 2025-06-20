package com.proyecto.calidad.domain.dto;

public record ProductDto(
        Integer id,
        String descripcion,
        String imagen,
        String nombre,
        Double precio,
        Integer stock,
        Integer categoryId,
        Integer proveedorId
){}
