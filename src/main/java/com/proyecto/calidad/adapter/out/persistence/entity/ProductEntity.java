package com.proyecto.calidad.adapter.out.persistence.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.*;

@Data
@Table("Productos")
public class ProductEntity {
    @Id
    private Integer id;

    @Column("descripcion")
    private String descripcion;

    @Column("imagen")
    private String imagen;

    @Column("nombre")
    private String nombre;

    @Column("precio")
    private Double precio;

    @Column("stock")
    private Integer stock;

    @Column("categoria_id")
    private Integer categoryId;

    @Column("proveedor_id")
    private Integer proveedorId;
}