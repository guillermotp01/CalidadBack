package com.proyecto.calidad.adapter.out.persistence.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.*;

@Data
@Table("DetallesPedido")
public class DetailOrderEntity {

    @Id
    private Integer id;

    @Column("cantidad")
    private Integer cantidad;

    @Column("precio")
    private Double precio;

    @Column("pedido_id")
    private Integer pedidoId;

    @Column("producto_id")
    private Integer productoId;
}