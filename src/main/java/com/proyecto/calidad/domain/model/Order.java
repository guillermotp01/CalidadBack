package com.proyecto.calidad.domain.model;

import java.util.Date;

public class Order {
    private Integer id;
    private String estado;
    private Date fecha;
    private Double total;
    private Integer paymentMethodId;
    private Integer usuarioId;
}
