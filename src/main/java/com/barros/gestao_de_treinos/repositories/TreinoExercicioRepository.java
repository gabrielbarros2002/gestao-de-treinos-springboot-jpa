package com.barros.gestao_de_treinos.repositories;

import com.barros.gestao_de_treinos.entities.PK.TreinoExercicioPK;
import com.barros.gestao_de_treinos.entities.TreinoExercicio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TreinoExercicioRepository extends JpaRepository<TreinoExercicio, TreinoExercicioPK> {
}
