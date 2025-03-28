package com.barros.gestao_de_treinos.entities.PK;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ExercicioTreinoPK implements Serializable {

    @JoinColumn(name = "treino_id")
    private Long treinoId;

    @JoinColumn(name = "exercicio_id")
    private Long exercicioId;

    public ExercicioTreinoPK() {
    }

    public ExercicioTreinoPK(Long treinoId, Long exercicioId) {
        this.treinoId = treinoId;
        this.exercicioId = exercicioId;
    }

    public Long getTreinoId() {
        return treinoId;
    }

    public void setTreinoId(Long treinoId) {
        this.treinoId = treinoId;
    }

    public Long getExercicioId() {
        return exercicioId;
    }

    public void setExercicioId(Long exercicioId) {
        this.exercicioId = exercicioId;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ExercicioTreinoPK that = (ExercicioTreinoPK) o;
        return Objects.equals(treinoId, that.treinoId) && Objects.equals(exercicioId, that.exercicioId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(treinoId, exercicioId);
    }
}
