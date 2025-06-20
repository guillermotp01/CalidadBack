package com.proyecto.calidad.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record Reponse<T>(
        boolean success,
        String message,
        T data
) {}
