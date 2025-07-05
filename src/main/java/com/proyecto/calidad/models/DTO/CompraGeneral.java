package com.proyecto.calidad.models.DTO;

public record CompraGeneral(
        int cantidadBoletos,
        Double precioTotal,
        String descripcion,
        String nombre,
        String email
) {}