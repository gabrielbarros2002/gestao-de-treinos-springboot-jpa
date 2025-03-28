package com.barros.gestao_de_treinos.repositories;

import com.barros.gestao_de_treinos.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
