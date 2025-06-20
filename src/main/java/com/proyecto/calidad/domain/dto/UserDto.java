package com.proyecto.calidad.domain.dto;

public record UserDto(
        Integer id,
        String apellido,
        String celular,
        String correo,
        String direccion,
        boolean enabled,
        String nombre,
        Integer nroDocumento,
        String password,
        String rol,
        String tipoDocumento,
        String username
){}
