package com.proyecto.calidad.models;

import java.util.List;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="Carritos")
public class Carrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @Column(name = "fecha_creacion", nullable = false, updatable = true, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date fechaCreacion;  

    @OneToMany(mappedBy = "carrito", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleCarrito> detallesCarrito = new ArrayList<>();

    private String estado;

    private Integer cantidadTotal;

    private Double precioDelivery = 5.90;

    private Double subtotal;
    
    private Double precioTotal;

    public void actualizarTotales() {
        this.subtotal = 0.0;
        this.cantidadTotal = 0;
        for (DetalleCarrito detalle : detallesCarrito) {
            this.subtotal += detalle.getPrecio();
            this.cantidadTotal += detalle.getCantidad();
        }
        DecimalFormat df = new DecimalFormat("#.##");
        this.precioTotal = Double.valueOf(df.format(this.subtotal + this.precioDelivery));
        actualizarFechaCreacion();
    }

    public void actualizarFechaCreacion() {
        this.fechaCreacion = new Date();
    }
}
