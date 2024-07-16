package com.proyecto.calidad.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name="Pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Double total;

    @Column(nullable = false)
    private String estado;

    @ManyToOne
    @JoinColumn(name = "metodo_pago_id")
    private MetodoDePago metodoDePago;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @Column(name = "fecha", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private java.sql.Timestamp fecha;

    @OneToMany(mappedBy = "pedido")
    private List<DetallePedido> detallesPedido;
}
