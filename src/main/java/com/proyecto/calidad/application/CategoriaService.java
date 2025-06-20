package com.proyecto.calidad.application;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.calidad.adapter.out.persistence.entity.CategoryEntity;
import com.proyecto.calidad.infrastructure.CategoriaRepository;

@Service
public class CategoriaService {
    /*
    @Autowired
    private CategoriaRepository categoriaRepository;

    public ArrayList<CategoryEntity> Listar(){
        return (ArrayList<CategoryEntity>) categoriaRepository.findAll();
    }
    */
}
