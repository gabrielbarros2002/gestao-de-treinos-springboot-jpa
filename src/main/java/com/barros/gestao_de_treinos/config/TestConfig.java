package com.barros.gestao_de_treinos.config;

import com.barros.gestao_de_treinos.entities.*;
import com.barros.gestao_de_treinos.entities.enums.Perfil;
import com.barros.gestao_de_treinos.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;
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

    @Autowired
    private TreinoRepository treinoRepository;

    @Autowired
    private TreinoExercicioRepository treinoExercicioRepository;

    @Override
    public void run(String... args) throws Exception {

        Usuario usuario1 = new Usuario(null, "Barros", "gabrielobarros11@gmail.com", "senha",
                LocalDate.now(), Perfil.ALUNO);
        Usuario usuario2 = new Usuario(null, "Lorenzo", "lorenzo@gmail.com", "senha",
                LocalDate.now(), Perfil.INSTRUTOR);

        usuarioRepository.saveAll(Arrays.asList(usuario1, usuario2));

        GrupoMuscular grupoMuscular1 = new GrupoMuscular(null, "Bíceps");
        GrupoMuscular grupoMuscular2 = new GrupoMuscular(null, "Costas");
        GrupoMuscular grupoMuscular3 = new GrupoMuscular(null, "Quadríceps");

        grupoMuscularRepository.saveAll(Arrays.asList(grupoMuscular1, grupoMuscular2, grupoMuscular3));

        Exercicio exercicio1 = new Exercicio(null, "Rosca direta", "Descrição rosca direta", grupoMuscular1);
        Exercicio exercicio2 = new Exercicio(null, "Remada sentado", "Descrição remada sentado", grupoMuscular2);
        Exercicio exercicio3 = new Exercicio(null, "Extensora", "Descrição extensora", grupoMuscular3);

        exercicioRepository.saveAll(Arrays.asList(exercicio1, exercicio2, exercicio3));

        Treino treino1 = new Treino(null, "Full body", usuario1, usuario2);
        Treino treino2 = new Treino(null, "Costas", usuario1, usuario2);

        treinoRepository.saveAll(Arrays.asList(treino1, treino2));

        TreinoExercicio treinoExercicio1 = new TreinoExercicio(treino1, exercicio1, 3, 10);
        TreinoExercicio treinoExercicio2 = new TreinoExercicio(treino1, exercicio2, 3, 10);
        TreinoExercicio treinoExercicio3 = new TreinoExercicio(treino1, exercicio3, 3, 10);

        treinoExercicioRepository.saveAll(Arrays.asList(treinoExercicio1, treinoExercicio2, treinoExercicio3));
    }
}
