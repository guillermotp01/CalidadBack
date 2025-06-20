package com.proyecto.calidad.adapter.out.persistence.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.*;
import java.util.Date;

@Data
@Table("Pedidos")
public class OrderEntity {
    @Id
    private Integer id;

    @Column("estado")
    private String estado;

    @Column("fecha")
    private Date fecha;

    @Column("total")
    private Double total;

    @Column("metodo_pago_id")
    private Integer paymentMethodId;

    @Column("usuario_id")
    private Integer usuarioId;
}
