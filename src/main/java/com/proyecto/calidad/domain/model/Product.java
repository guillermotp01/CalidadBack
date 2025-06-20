package com.proyecto.calidad.domain.model;

public class Product {
    private Integer id;
    private String descripcion;
    private String imagen;
    private String nombre;
    private Double precio;
    private Integer stock;
    private Integer categoryId;
    private Integer proveedorId;

    public void actualizarStock(int cantidad) {
        if (cantidad <= this.stock) {
            this.stock -= cantidad;
        } else {
            throw new IllegalArgumentException("Stock insuficiente para este producto");
        }
    }
}
