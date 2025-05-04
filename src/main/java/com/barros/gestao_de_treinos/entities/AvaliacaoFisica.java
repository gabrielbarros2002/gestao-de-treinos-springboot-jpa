package com.barros.gestao_de_treinos.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "avaliacoes_fisicas")
public class AvaliacaoFisica implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O aluno é obrigatório")
    @ManyToOne
    @JoinColumn(name = "aluno_id", nullable = false)
    private Usuario aluno;

    @NotNull(message = "A data da avaliação é obrigatória")
    @PastOrPresent(message = "A data da avaliação não pode ser no futuro")
    @Column(nullable = false)
    private LocalDate data;

    @NotNull(message = "O peso é obrigatório")
    @Positive(message = "O peso deve ser maior que zero")
    @Column(nullable = false, precision = 5, scale = 2)
    private Double peso;

    @NotNull(message = "A altura é obrigatória")
    @Positive(message = "A altura deve ser maior que zero")
    @Column(nullable = false, precision = 3, scale = 2)
    private Double altura;

    @NotNull(message = "O IMC é obrigatório")
    @Positive(message = "O IMC deve ser maior que zero")
    @Column(nullable = false, precision = 4, scale = 2)
    private Double imc;

    @NotNull(message = "O percentual de gordura é obrigatório")
    @Positive(message = "O percentual de gordura deve ser maior que zero")
    @Column(nullable = false, precision = 4, scale = 2)
    private Double percentualGordura;

    @NotNull(message = "A massa muscular é obrigatória")
    @Positive(message = "A massa muscular deve ser maior que zero")
    @Column(nullable = false, precision = 5, scale = 2)
    private Double massaMuscularKg;

    @PrePersist
    @PreUpdate
    private void calcularIMC() {
        if (peso != null && altura != null && altura > 0) {
            this.imc = peso / (altura * altura);
        }
    }

    public Long getId() {
        return id;
    }

    public Usuario getAluno() {
        return aluno;
    }

    public void setAluno(Usuario aluno) {
        this.aluno = aluno;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
        calcularIMC();
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
        calcularIMC();
    }

    public Double getImc() {
        return imc;
    }

    public Double getPercentualGordura() {
        return percentualGordura;
    }

    public void setPercentualGordura(Double percentualGordura) {
        this.percentualGordura = percentualGordura;
    }

    public Double getMassaMuscularKg() {
        return massaMuscularKg;
    }

    public void setMassaMuscularKg(Double massaMuscularKg) {
        this.massaMuscularKg = massaMuscularKg;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AvaliacaoFisica that = (AvaliacaoFisica) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "AvaliacaoFisica{" +
                "id=" + id +
                ", aluno=" + aluno +
                ", data=" + data +
                ", peso=" + peso +
                ", altura=" + altura +
                ", imc=" + imc +
                ", percentualGordura=" + percentualGordura +
                ", massaMuscularKg=" + massaMuscularKg +
                '}';
    }
}

