package com.barros.gestao_de_treinos.resources;

import com.barros.gestao_de_treinos.entities.Exercicio;
import com.barros.gestao_de_treinos.services.ExercicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/exercicios")
public class ExercicioResource {

    @Autowired
    private ExercicioService service;

    @GetMapping
    public ResponseEntity<List<Exercicio>> findAll() {
        List<Exercicio> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Exercicio> findById(@PathVariable Long id) {
        Exercicio obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
