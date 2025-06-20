package com.proyecto.calidad.domain.dto;

public record DetailOrderDto(
        Integer id,
        Integer cantidad,
        Double precio,
        Integer pedidoId,
        Integer productoId
){}
