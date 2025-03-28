package com.barros.gestao_de_treinos.entities;

import com.barros.gestao_de_treinos.entities.PK.TreinoExercicioPK;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class TreinoExercicio implements Serializable {

    @EmbeddedId
    private TreinoExercicioPK id;

    private Integer series;
    private Integer repeticoes;
    private Double cargaKg;
    private Integer descansoSegundos;

    public TreinoExercicio() {
    }

    public TreinoExercicio(Treino treino, Exercicio exercicio, Integer series, Integer repeticoes, Double cargaKg,
            Integer descansoSegundos) {
        this.id = new TreinoExercicioPK(treino, exercicio);
        this.series = series;
        this.repeticoes = repeticoes;
        this.cargaKg = cargaKg;
        this.descansoSegundos = descansoSegundos;
    }

    public Treino getTreino() {
        return id.getTreino();
    }

    public void setTreino(Treino treino) {
        id.setTreino(treino);
    }

    public Exercicio getExercicio() {
        return id.getExercicio();
    }

    public void setExercicio(Exercicio exercicio) {
        id.setExercicio(exercicio);
    }

    public Integer getSeries() {
        return series;
    }

    public void setSeries(Integer series) {
        this.series = series;
    }

    public Integer getRepeticoes() {
        return repeticoes;
    }

    public void setRepeticoes(Integer repeticoes) {
        this.repeticoes = repeticoes;
    }

    public Double getCargaKg() {
        return cargaKg;
    }

    public void setCargaKg(Double cargaKg) {
        this.cargaKg = cargaKg;
    }

    public Integer getDescansoSegundos() {
        return descansoSegundos;
    }

    public void setDescansoSegundos(Integer descansoSegundos) {
        this.descansoSegundos = descansoSegundos;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TreinoExercicio that = (TreinoExercicio) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
