package com.barros.gestao_de_treinos.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class AvaliacaoFisica implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "aluno_id", nullable = false)
    private Usuario aluno;

    @Column(nullable = false)
    private LocalDate data;

    @Column(nullable = false)
    private Double peso;

    @Column(nullable = false)
    private Double altura;

    @Column(nullable = false)
    private Double imc;

    @Column(nullable = false)
    private Double percentualGordura;

    @Column(nullable = false)
    private Double massaMuscularKg;

    public AvaliacaoFisica() {
    }

    public AvaliacaoFisica(Long id, Usuario aluno, LocalDate data, Double peso, Double altura, Double imc,
            Double percentualGordura, Double massaMuscularKg) {
        this.id = id;
        this.aluno = aluno;
        this.data = data;
        this.peso = peso;
        this.altura = altura;
        this.imc = imc;
        this.percentualGordura = percentualGordura;
        this.massaMuscularKg = massaMuscularKg;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getImc() {
        return imc;
    }

    public void setImc(Double imc) {
        this.imc = imc;
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

