package com.barros.gestao_de_treinos.entities;

import com.barros.gestao_de_treinos.entities.enums.Perfil;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome é obrigatório")
    @Size(min = 3, max = 100, message = "O nome deve ter entre {min} e {max} caracteres")
    @Column(nullable = false, length = 100)
    private String nome;

    @NotBlank(message = "O email é obrigatório")
    @Email(message = "Por favor, forneça um endereço de email válido")
    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @NotBlank(message = "A senha é obrigatória")
    @Size(min = 8, message = "A senha deve ter no mínimo {min} caracteres")
    @Column(nullable = false, length = 50)
    private String senha;

    @NotNull(message = "A data de nascimento é obrigatória")
    @Past(message = "A data de nascimento deve ser no passado")
    @Column(nullable = false)
    private LocalDate dataNascimento;

    @NotNull(message = "O perfil é obrigatório")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private Perfil perfil;

    @ManyToMany
    @JoinTable(
            name = "aluno_treinos",
            joinColumns = @JoinColumn(name = "aluno_id"),
            inverseJoinColumns = @JoinColumn(name = "treino_id")
    )
    private List<Treino> treinos = new ArrayList<>();

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

    public List<Treino> getTreinos() {
        return treinos;
    }

    public void addTreino(Treino treino) {
        this.treinos.add(treino);
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
                ", treinos=" + treinos +
                '}';
    }
}
