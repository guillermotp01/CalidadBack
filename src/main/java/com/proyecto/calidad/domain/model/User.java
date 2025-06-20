package com.proyecto.calidad.domain.model;

public class User {
    private Integer id;
    private String apellido;
    private String celular;
    private String correo;
    private String direccion;
    private boolean enabled = true;
    private String nombre;
    private Integer nroDocumento;
    private String password;
    private String rol;
    private String tipoDocumento;
    private String username;

    public Integer getId() {
        return id;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCelular() {
        return celular;
    }

    public String getCorreo() {
        return correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getNroDocumento() {
        return nroDocumento;
    }

    public String getPassword() {
        return password;
    }

    public String getRol() {
        return rol;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public String getUsername() {
        return username;
    }
}
