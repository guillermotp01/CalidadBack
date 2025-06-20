package com.proyecto.calidad.domain.model;

import com.proyecto.calidad.domain.dto.DetailCarDto;

import java.util.Date;
import java.util.List;

public class Car {
    private Integer id;
    private Integer cantidadTotal;
    private String estado;
    private Date fechaCreacion;
    private Double precioDelivery = 5.90;
    private Double precioTotal;
    private Double subTotal;
    private Integer usuarioId;

    public void actualizarTotales(List<DetailCarDto> detalles) {
        this.subTotal = 0.0;
        this.cantidadTotal = 0;
        for (DetailCarDto d : detalles) {
            this.subTotal += d.precio();
            this.cantidadTotal += d.cantidad();
        }
        this.precioTotal = this.subTotal + this.precioDelivery;
    }

    public Car() {
    }

    public Car(Integer id, Integer cantidadTotal, String estado, Date fechaCreacion, Double precioDelivery, Double precioTotal, Double subTotal, Integer usuarioId) {
        this.id = id;
        this.cantidadTotal = cantidadTotal;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
        this.precioDelivery = precioDelivery;
        this.precioTotal = precioTotal;
        this.subTotal = subTotal;
        this.usuarioId = usuarioId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCantidadTotal() {
        return cantidadTotal;
    }

    public void setCantidadTotal(Integer cantidadTotal) {
        this.cantidadTotal = cantidadTotal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Double getPrecioDelivery() {
        return precioDelivery;
    }

    public void setPrecioDelivery(Double precioDelivery) {
        this.precioDelivery = precioDelivery;
    }

    public Double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(Double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }
}
