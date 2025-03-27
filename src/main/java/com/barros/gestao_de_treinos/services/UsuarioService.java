package com.barros.gestao_de_treinos.services;

import com.barros.gestao_de_treinos.entities.Usuario;
import com.barros.gestao_de_treinos.repositories.UsuarioRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRespository usuarioRespository;

    public List<Usuario> findAll() {
        return usuarioRespository.findAll();
    }

    public Usuario findById(Long id) {
        Optional<Usuario> obj = usuarioRespository.findById(id);
        return obj.get();
    }
}
