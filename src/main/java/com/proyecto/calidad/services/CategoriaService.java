package com.proyecto.calidad.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.calidad.models.Categoria;
import com.proyecto.calidad.repositories.CategoriaRepository;

@Service
public class CategoriaService {
    
    @Autowired
    private CategoriaRepository categoriaRepository;

    public ArrayList<Categoria> Listar(){
        return (ArrayList<Categoria>) categoriaRepository.findAll();
    }
}
