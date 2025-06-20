package com.proyecto.calidad.domain.dto;

import java.util.Date;

public record CarDto(
   Integer id,
   Integer cantidadTotal,
   String estado,
   Date fechaCreacion,
   Double precioDelivery,
   Double precioTotal,
   Double subTotal,
   Integer usuarioId
) {}
