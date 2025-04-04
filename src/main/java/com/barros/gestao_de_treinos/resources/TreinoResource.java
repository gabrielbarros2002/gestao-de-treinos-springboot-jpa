package com.barros.gestao_de_treinos.resources;

import com.barros.gestao_de_treinos.entities.Treino;
import com.barros.gestao_de_treinos.services.TreinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/treinos")
public class TreinoResource {

    @Autowired
    private TreinoService service;

    @GetMapping
    public ResponseEntity<List<Treino>> findAll() {
        List<Treino> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Treino> findById(@PathVariable Long id) {
        Treino obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Treino> update(@PathVariable Long id, @RequestBody Treino obj) {
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }
}
