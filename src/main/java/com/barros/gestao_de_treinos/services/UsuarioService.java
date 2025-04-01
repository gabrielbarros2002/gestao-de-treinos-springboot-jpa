package com.barros.gestao_de_treinos.services;

import com.barros.gestao_de_treinos.entities.Usuario;
import com.barros.gestao_de_treinos.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository respository;

    public List<Usuario> findAll() {
        return respository.findAll();
    }

    public Usuario findById(Long id) {
        Optional<Usuario> obj = respository.findById(id);
        return obj.get();
    }

    public Usuario insert(Usuario obj) {
        return respository.save(obj);
    }

    public void delete(Long id) {
        respository.deleteById(id);
    }

    public Usuario update(Long id, Usuario obj) {
        Usuario entity = respository.getReferenceById(id);
        updateData(entity, obj);
        return respository.save(entity);
    }

    private void updateData(Usuario entity, Usuario obj) {
        entity.setNome(obj.getNome());
        entity.setEmail(obj.getEmail());
    }
}
