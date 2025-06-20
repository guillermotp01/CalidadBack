package com.proyecto.calidad.domain.dto;

public record DetailCarDto(
      Integer id,
      Integer cantidad,
      Double precio,
      Integer carritoId,
      Integer productoId
){}
