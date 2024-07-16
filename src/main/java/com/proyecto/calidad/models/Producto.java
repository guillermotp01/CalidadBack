package com.proyecto.calidad.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="Productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nombre;

    private String descripcion;

    @Column(nullable = false)
    private Double precio;

    @Column(nullable = false)
    private Integer stock;

    private String imagen;

    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "proveedor_id", nullable = false)
    private Proveedor proveedor;

    public void actualizarStock(int cantidad) {
        if (cantidad <= this.stock) {
            this.stock -= cantidad;
        } else {
            throw new IllegalArgumentException("Stock insuficiente para este producto");
        }
    }
}