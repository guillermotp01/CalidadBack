package com.proyecto.calidad.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.calidad.models.Proveedor;
import com.proyecto.calidad.services.ProveedorService;


@RestController
@RequestMapping("/proveedor")
@CrossOrigin("*")
public class ProveedorController {
    
    @Autowired
    private ProveedorService proveedorService;

    @GetMapping("/listar")
    public ArrayList<Proveedor> Listar() {
        return this.proveedorService.Listar();
    }
}
