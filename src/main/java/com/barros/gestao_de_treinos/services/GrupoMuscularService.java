package com.barros.gestao_de_treinos.services;

import com.barros.gestao_de_treinos.entities.GrupoMuscular;
import com.barros.gestao_de_treinos.repositories.GrupoMuscularRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GrupoMuscularService {

    @Autowired
    private GrupoMuscularRepository repository;

    public List<GrupoMuscular> findAll() {
        return repository.findAll();
    }

    public GrupoMuscular findById(Long id) {
        Optional<GrupoMuscular> obj = repository.findById(id);
        return obj.get();
    }
}
