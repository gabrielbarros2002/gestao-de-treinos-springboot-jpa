package com.barros.gestao_de_treinos.config;

import com.barros.gestao_de_treinos.entities.*;
import com.barros.gestao_de_treinos.entities.enums.Perfil;
import com.barros.gestao_de_treinos.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

        GrupoMuscular grupoMuscular1 = new GrupoMuscular(null, "Peito");
        GrupoMuscular grupoMuscular2 = new GrupoMuscular(null, "Costas");
        GrupoMuscular grupoMuscular3 = new GrupoMuscular(null, "Pernas");
        GrupoMuscular grupoMuscular4 = new GrupoMuscular(null, "Ombros");
        GrupoMuscular grupoMuscular5 = new GrupoMuscular(null, "Bíceps");
        GrupoMuscular grupoMuscular6 = new GrupoMuscular(null, "Tríceps");
        GrupoMuscular grupoMuscular7 = new GrupoMuscular(null, "Glúteos");
        GrupoMuscular grupoMuscular8 = new GrupoMuscular(null, "Panturrilhas");
        GrupoMuscular grupoMuscular9 = new GrupoMuscular(null, "Abdômen");
        GrupoMuscular grupoMuscular10 = new GrupoMuscular(null, "Antebraços");

        grupoMuscularRepository.saveAll(Arrays.asList(grupoMuscular1, grupoMuscular2, grupoMuscular3, grupoMuscular4,
                grupoMuscular5, grupoMuscular6, grupoMuscular7, grupoMuscular8, grupoMuscular9, grupoMuscular10));

        Exercicio exercicio1 = new Exercicio(null, "Supino reto", "Exercício clássico para trabalhar o peitoral maior", grupoMuscular1);
        Exercicio exercicio2 = new Exercicio(null, "Puxada frente", "Trabalha o latíssimo do dorso", grupoMuscular2);
        Exercicio exercicio3 = new Exercicio(null, "Agachamento livre", "Trabalha quadríceps, glúteos e posteriores", grupoMuscular3);
        Exercicio exercicio4 = new Exercicio(null, "Desenvolvimento com halteres", "Fortalece os deltoides", grupoMuscular4);
        Exercicio exercicio5 = new Exercicio(null, "Rosca direta", "Isola o bíceps braquial", grupoMuscular5);
        Exercicio exercicio6 = new Exercicio(null, "Tríceps testa", "Exercício para a cabeça longa do tríceps", grupoMuscular6);
        Exercicio exercicio7 = new Exercicio(null, "Elevação pélvica", "Trabalha os glúteos e posteriores", grupoMuscular7);
        Exercicio exercicio8 = new Exercicio(null, "Elevação de panturrilhas em pé", "Foco nos gastrocnêmios", grupoMuscular8);
        Exercicio exercicio9 = new Exercicio(null, "Abdominal infra", "Trabalha a parte inferior do abdômen", grupoMuscular9);
        Exercicio exercicio10 = new Exercicio(null, "Rosca punho", "Fortalece os músculos do antebraço", grupoMuscular10);
        Exercicio exercicio11 = new Exercicio(null, "Crucifixo reto", "Isolamento para o peitoral", grupoMuscular1);
        Exercicio exercicio12 = new Exercicio(null, "Remada curvada", "Exercício composto para costas", grupoMuscular2);
        Exercicio exercicio13 = new Exercicio(null, "Cadeira flexora", "Foca nos posteriores de coxa", grupoMuscular3);
        Exercicio exercicio14 = new Exercicio(null, "Elevação lateral", "Isola a cabeça média do deltoide", grupoMuscular4);
        Exercicio exercicio15 = new Exercicio(null, "Rosca martelo", "Trabalha o braquiorradial e o bíceps", grupoMuscular5);
        Exercicio exercicio16 = new Exercicio(null, "Tríceps corda", "Foco na cabeça lateral do tríceps", grupoMuscular6);
        Exercicio exercicio17 = new Exercicio(null, "Glúteo na polia", "Isolamento para glúteos", grupoMuscular7);
        Exercicio exercicio18 = new Exercicio(null, "Panturrilha no leg press", "Variação para panturrilhas", grupoMuscular8);
        Exercicio exercicio19 = new Exercicio(null, "Prancha abdominal", "Trabalha toda a região do core", grupoMuscular9);
        Exercicio exercicio20 = new Exercicio(null, "Extensão de punho", "Isola os extensores do antebraço", grupoMuscular10);

        exercicioRepository.saveAll(Arrays.asList(exercicio1, exercicio2, exercicio3, exercicio4, exercicio5,
                exercicio6, exercicio7, exercicio8, exercicio9, exercicio10, exercicio11, exercicio12, exercicio13,
                exercicio14, exercicio15, exercicio16, exercicio17, exercicio18, exercicio19, exercicio20
        ));

        Treino treino1 = new Treino(null, "Treino A - Peito e Tríceps", usuario2);
        Treino treino2 = new Treino(null, "Treino B - Costas e Bíceps", usuario2);
        Treino treino3 = new Treino(null, "Treino C - Pernas e Ombros", usuario2);

        treinoRepository.saveAll(Arrays.asList(treino1, treino2, treino3));

        List<TreinoExercicio> treinoExercicios = new ArrayList<>();

        treinoExercicios.add(new TreinoExercicio(treino1, exercicio1, 4, 10));
        treinoExercicios.add(new TreinoExercicio(treino1, exercicio6, 4, 12));
        treinoExercicios.add(new TreinoExercicio(treino2, exercicio2, 4, 10));
        treinoExercicios.add(new TreinoExercicio(treino2, exercicio5, 3, 12));
        treinoExercicios.add(new TreinoExercicio(treino3, exercicio3, 4, 8));
        treinoExercicios.add(new TreinoExercicio(treino3, exercicio4, 3, 10));

        for (TreinoExercicio te : treinoExercicios) {
            te.getTreino().getExercicios().add(te);
        }

        treinoExercicioRepository.saveAll(treinoExercicios);

        usuario1.getTreinos().addAll(Arrays.asList(treino1, treino2));
        usuarioRepository.save(usuario1);

    }
}
