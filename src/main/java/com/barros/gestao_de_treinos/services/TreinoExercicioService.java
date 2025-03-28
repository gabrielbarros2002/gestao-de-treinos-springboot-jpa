package com.barros.gestao_de_treinos.services;

import com.barros.gestao_de_treinos.entities.PK.TreinoExercicioPK;
import com.barros.gestao_de_treinos.entities.TreinoExercicio;
import com.barros.gestao_de_treinos.repositories.TreinoExercicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TreinoExercicioService {

    @Autowired
    private TreinoExercicioRepository respository;

    public List<TreinoExercicio> findAll() {
        return respository.findAll();
    }

    public TreinoExercicio findById(TreinoExercicioPK id) {
        Optional<TreinoExercicio> obj = respository.findById(id);
        return obj.get();
    }
}
