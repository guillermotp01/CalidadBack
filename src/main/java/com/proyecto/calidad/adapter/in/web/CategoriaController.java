package com.proyecto.calidad.adapter.in.web;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.proyecto.calidad.adapter.out.persistence.entity.CategoryEntity;
import com.proyecto.calidad.application.CategoriaService;


@RestController
@RequestMapping("/categoria")
@CrossOrigin("*")
public class CategoriaController {
    /*
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/listar")
    public ArrayList<CategoryEntity> Listar() {
        return this.categoriaService.Listar();
    }
    */
}
