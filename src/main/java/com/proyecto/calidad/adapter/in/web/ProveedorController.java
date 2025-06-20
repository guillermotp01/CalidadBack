package com.proyecto.calidad.adapter.in.web;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.calidad.adapter.out.persistence.entity.SupplierEntity;
import com.proyecto.calidad.application.ProveedorService;


@RestController
@RequestMapping("/proveedor")
@CrossOrigin("*")
public class ProveedorController {
    /*
    @Autowired
    private ProveedorService proveedorService;

    @GetMapping("/listar")
    public ArrayList<SupplierEntity> Listar() {
        return this.proveedorService.Listar();
    }
     */
}
