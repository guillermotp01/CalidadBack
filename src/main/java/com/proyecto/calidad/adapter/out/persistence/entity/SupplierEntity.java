package com.proyecto.calidad.adapter.out.persistence.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.*;

@Data
@Table("Proveedores")
public class SupplierEntity {
    @Id
    private Integer id;

    @Column("celular")
    private String celular;

    @Column("nombre")
    private String nombre;
}
