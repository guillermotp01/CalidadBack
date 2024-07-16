package com.proyecto.calidad.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proyecto.calidad.models.Proveedor;
import com.proyecto.calidad.repositories.ProveedorRepository;

@Service
public class ProveedorService {
    
    @Autowired
    private ProveedorRepository proveedorRepository;

    public ArrayList<Proveedor> Listar(){
        return (ArrayList<Proveedor>) proveedorRepository.findAll();
    }
}
