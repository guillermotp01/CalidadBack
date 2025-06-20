package com.proyecto.calidad.adapter.out.persistence.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.*;

@Data
@Table("Categorias")
public class CategoryEntity {
    @Id
    private Integer id;

    @Column("nombre")
    private String nombre;
}