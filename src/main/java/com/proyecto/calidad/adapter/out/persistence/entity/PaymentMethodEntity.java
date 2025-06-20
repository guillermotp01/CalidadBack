package com.proyecto.calidad.adapter.out.persistence.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("MetodosDePago")
public class PaymentMethodEntity {
    @Id
    private Integer id;

    @Column("nombre")
    private String nombre;

    @Column("descripcion")
    private String descripcion;
}