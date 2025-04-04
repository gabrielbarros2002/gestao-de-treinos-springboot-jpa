package com.barros.gestao_de_treinos.entities;

import com.barros.gestao_de_treinos.entities.enums.Perfil;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private LocalDate dataNascimento;

    @Enumerated(EnumType.STRING)
    private Perfil perfil;

    @OneToMany(mappedBy = "aluno")
    private List<Treino> treinosComoAluno = new ArrayList<>();

    @OneToMany(mappedBy = "instrutor")
    private List<Treino> treinosComoInstrutor = new ArrayList<>();

    public Usuario() {
    }

    public Usuario(Long id, String nome, String email, String senha, LocalDate dataNascimento, Perfil perfil) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
        this.perfil = perfil;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public List<Treino> getTreinosComoAluno() {
        return treinosComoAluno;
    }

    public void setTreinosComoAluno(List<Treino> treinosComoAluno) {
        this.treinosComoAluno = treinosComoAluno;
    }

    public List<Treino> getTreinosComoInstrutor() {
        return treinosComoInstrutor;
    }

    public void setTreinosComoInstrutor(List<Treino> treinosComoInstrutor) {
        this.treinosComoInstrutor = treinosComoInstrutor;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(getId(), usuario.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", perfil=" + perfil +
                '}';
    }
}
