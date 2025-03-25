package com.barros.gestao_de_treinos.resources;

import com.barros.gestao_de_treinos.entities.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {

    @GetMapping
    public ResponseEntity<Usuario> findAll() {
        Usuario usuario = new Usuario(1, "Barros", "gabrielobarros11@gmail.com", "senha",
                LocalDate.now(), LocalDateTime.now());

        return ResponseEntity.ok().body(usuario);
    }
}
