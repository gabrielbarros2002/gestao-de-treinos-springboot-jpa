package com.barros.gestao_de_treinos.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ExercicioTreinoId implements Serializable {

    @Column(name = "treino_id")
    private Long treinoId;

    @Column(name = "exercicio_id")
    private Long exercicioId;

    public ExercicioTreinoId() {
    }

    public ExercicioTreinoId(Long treinoId, Long exercicioId) {
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
        ExercicioTreinoId that = (ExercicioTreinoId) o;
        return Objects.equals(treinoId, that.treinoId) && Objects.equals(exercicioId, that.exercicioId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(treinoId, exercicioId);
    }
}
