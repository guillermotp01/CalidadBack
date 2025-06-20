package com.proyecto.calidad.domain.model;

public class DetailCar {
    private Integer id;
    private Integer cantidad;
    private Double precio;
    private Integer carritoId;
    private Integer productoId;

    public DetailCar() {
    }

    public DetailCar(Integer id, Integer cantidad, Double precio, Integer carritoId, Integer productoId) {
        this.id = id;
        this.cantidad = cantidad;
        this.precio = precio;
        this.carritoId = carritoId;
        this.productoId = productoId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getCarritoId() {
        return carritoId;
    }

    public void setCarritoId(Integer carritoId) {
        this.carritoId = carritoId;
    }

    public Integer getProductoId() {
        return productoId;
    }

    public void setProductoId(Integer productoId) {
        this.productoId = productoId;
    }
}
