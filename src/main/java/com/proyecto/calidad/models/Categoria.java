package com.proyecto.calidad.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="Categorias")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nombre;
}