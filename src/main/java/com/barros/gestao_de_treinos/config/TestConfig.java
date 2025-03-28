package com.barros.gestao_de_treinos.config;

import com.barros.gestao_de_treinos.entities.Exercicio;
import com.barros.gestao_de_treinos.entities.GrupoMuscular;
import com.barros.gestao_de_treinos.entities.Usuario;
import com.barros.gestao_de_treinos.repositories.ExercicioRepository;
import com.barros.gestao_de_treinos.repositories.GrupoMuscularRepository;
import com.barros.gestao_de_treinos.repositories.UsuarioRepository;
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
    private UsuarioRepository usuarioRepository;

    @Autowired
    private GrupoMuscularRepository grupoMuscularRepository;

    @Autowired
    private ExercicioRepository exercicioRepository;

    @Override
    public void run(String... args) throws Exception {

        Usuario usuario1 = new Usuario(null, "Barros", "gabrielobarros11@gmail.com", "senha",
                LocalDate.now(), LocalDateTime.now());
        Usuario usuario2 = new Usuario(null, "Lorenzo", "lorenzo@gmail.com", "senha",
                LocalDate.now(), LocalDateTime.now());

        usuarioRepository.saveAll(Arrays.asList(usuario1, usuario2));

        GrupoMuscular grupoMuscular1 = new GrupoMuscular(null, "Bíceps");
        GrupoMuscular grupoMuscular2 = new GrupoMuscular(null, "Costas");
        GrupoMuscular grupoMuscular3 = new GrupoMuscular(null, "Quadríceps");

        grupoMuscularRepository.saveAll(Arrays.asList(grupoMuscular1, grupoMuscular2, grupoMuscular3));

        Exercicio exercicio1 = new Exercicio(null, "Rosca direta", "Descrição rosca direta", grupoMuscular1);
        Exercicio exercicio2 = new Exercicio(null, "Remada sentado", "Descrição remada sentado", grupoMuscular2);
        Exercicio exercicio3 = new Exercicio(null, "Extensora", "Descrição extensora", grupoMuscular3);

        exercicioRepository.saveAll(Arrays.asList(exercicio1, exercicio2, exercicio3));

    }
}
