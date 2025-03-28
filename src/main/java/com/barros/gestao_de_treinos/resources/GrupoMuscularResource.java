package com.barros.gestao_de_treinos.resources;

import com.barros.gestao_de_treinos.entities.GrupoMuscular;
import com.barros.gestao_de_treinos.services.GrupoMuscularService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
