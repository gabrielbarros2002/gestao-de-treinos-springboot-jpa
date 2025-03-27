package com.barros.gestao_de_treinos.config;

import com.barros.gestao_de_treinos.entities.Usuario;
import com.barros.gestao_de_treinos.repositories.UsuarioRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UsuarioRespository usuarioRespository;

    @Override
    public void run(String... args) throws Exception {

        Usuario usuario1 = new Usuario(null, "Barros", "gabrielobarros11@gmail.com", "senha",
                LocalDate.now(), LocalDateTime.now());
        Usuario usuario2 = new Usuario(null, "Lorenzo", "lorenzo@gmail.com", "senha",
                LocalDate.now(), LocalDateTime.now());

        usuarioRespository.saveAll(Arrays.asList(usuario1, usuario2));
    }
}
