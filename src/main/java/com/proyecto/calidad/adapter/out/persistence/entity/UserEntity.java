package com.proyecto.calidad.adapter.out.persistence.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.*;
import lombok.Data;

@Data
@Table("Usuarios")
public class UserEntity{
    @Id
    private Integer id;

    @Column("apellido")
    private String apellido;

    @Column("celular")
    private String celular;

    @Column("correo")
    private String correo;

    @Column("direccion")
    private String direccion;

    @Column("enabled")
    private boolean enabled = true;

    @Column("nombre")
    private String nombre;

    @Column("nro_documento")
    private Integer nroDocumento;

    @Column("password")
    private String password;

    @Column("rol")
    private String rol;

    @Column("tipo_documento")
    private String tipoDocumento;

    @Column("username")
    private String username;
}