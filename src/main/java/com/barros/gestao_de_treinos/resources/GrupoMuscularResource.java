package com.barros.gestao_de_treinos.resources;

import com.barros.gestao_de_treinos.entities.GrupoMuscular;
import com.barros.gestao_de_treinos.services.GrupoMuscularService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/grupos-musculares")
public class GrupoMuscularResource {

    @Autowired
    private GrupoMuscularService service;

    @GetMapping
    public ResponseEntity<List<GrupoMuscular>> findAll() {
        List<GrupoMuscular> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<GrupoMuscular> findById(@PathVariable Long id) {
        GrupoMuscular obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<GrupoMuscular> update(@PathVariable Long id, @RequestBody GrupoMuscular obj) {
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }
}
