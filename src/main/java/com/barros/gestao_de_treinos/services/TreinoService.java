package com.barros.gestao_de_treinos.services;

import com.barros.gestao_de_treinos.entities.Treino;
import com.barros.gestao_de_treinos.repositories.TreinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TreinoService {

    @Autowired
    private TreinoRepository respository;

    public List<Treino> findAll() {
        return respository.findAll();
    }

    public Treino findById(Long id) {
        Optional<Treino> obj = respository.findById(id);
        return obj.get();
    }
}
