package com.proyecto.calidad.adapter.out.persistence.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.*;

@Data
@Table("DetallesCarrito")
public class DetailCarEntity {
    @Id
    private Integer id;

    @Column("cantidad")
    private Integer cantidad;

    @Column("precio")
    private Double precio;

    @Column("carrito_id")
    private Integer carritoId;

    @Column("producto_id")
    private Integer productoId;
}
