package com.barros.gestao_de_treinos.services;

import com.barros.gestao_de_treinos.entities.Treino;
import com.barros.gestao_de_treinos.repositories.TreinoRepository;
import com.barros.gestao_de_treinos.services.exceptions.DatabaseException;
import com.barros.gestao_de_treinos.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TreinoService {

    @Autowired
    private TreinoRepository repository;

    public List<Treino> findAll() {
        return repository.findAll();
    }

    public Treino findById(Long id) {
        Optional<Treino> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public Treino update(Long id, Treino obj) {
        try {
            Treino entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Treino entity, Treino obj) {
        entity.setNome(obj.getNome());
        entity.setExercicios(obj.getExercicios());
    }
}
