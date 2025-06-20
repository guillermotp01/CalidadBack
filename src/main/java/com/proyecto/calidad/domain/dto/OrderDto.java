package com.proyecto.calidad.domain.dto;

import java.util.Date;

public record OrderDto(
        Integer id,
        String estado,
        Date fecha,
        Double total,
        Integer paymentMethodId,
        Integer usuarioId
){}
