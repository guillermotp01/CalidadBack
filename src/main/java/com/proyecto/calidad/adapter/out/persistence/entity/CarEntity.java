package com.proyecto.calidad.adapter.out.persistence.entity;

import java.util.*;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.*;

@Data
@Table("carritos")
public class CarEntity {
    @Id
    private Integer id;

    @Column("cantidad_total")
    private Integer cantidadTotal;

    @Column("estado")
    private String estado;

    @Column("fecha_creacion")
    private Date fechaCreacion;

    @Column("precio_delivery")
    private Double precioDelivery = 5.90;

    @Column("precio_total")
    private Double precioTotal;

    @Column("subtotal")
    private Double subTotal;

    @Column("usuario_id")
    private Integer usuarioId;
}
