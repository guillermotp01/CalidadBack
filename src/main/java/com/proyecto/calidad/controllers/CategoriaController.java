package com.proyecto.calidad.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.proyecto.calidad.models.Categoria;
import com.proyecto.calidad.services.CategoriaService;


@RestController
@RequestMapping("/categoria")
@CrossOrigin("*")
public class CategoriaController {
    
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/listar")
    public ArrayList<Categoria> Listar() {
        return this.categoriaService.Listar();
    }
}
