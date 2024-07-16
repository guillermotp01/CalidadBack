package com.proyecto.calidad.models;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="Proveedores")
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String celular;
}
