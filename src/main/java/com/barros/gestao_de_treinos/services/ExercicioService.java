package com.barros.gestao_de_treinos.services;

import com.barros.gestao_de_treinos.entities.Exercicio;
import com.barros.gestao_de_treinos.repositories.ExercicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExercicioService {

    @Autowired
    private ExercicioRepository respository;

    public List<Exercicio> findAll() {
        return respository.findAll();
    }

    public Exercicio findById(Long id) {
        Optional<Exercicio> obj = respository.findById(id);
        return obj.get();
    }
}
