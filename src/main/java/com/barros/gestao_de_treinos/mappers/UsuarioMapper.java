package com.barros.gestao_de_treinos.mappers;

import com.barros.gestao_de_treinos.DTOs.UsuarioDTO;
import com.barros.gestao_de_treinos.entities.Usuario;
import com.barros.gestao_de_treinos.entities.enums.Perfil;

public class UsuarioMapper {

    public static UsuarioDTO toDTO(Usuario entity) {
        if (entity == null) return null;

        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setEmail(entity.getEmail());
        dto.setSenha(entity.getSenha());
        dto.setDataNascimento(entity.getDataNascimento());
        dto.setPerfil(entity.getPerfil().name());

        return dto;
    }

    public static Usuario toEntity(UsuarioDTO dto) {
        if (dto == null) return null;

        Usuario entity = new Usuario();
        entity.setId(dto.getId());
        entity.setNome(dto.getNome());
        entity.setEmail(dto.getEmail());
        entity.setSenha(dto.getSenha());
        entity.setDataNascimento(dto.getDataNascimento());

        if (dto.getPerfil() != null) {
            try {
                entity.setPerfil(Perfil.valueOf(dto.getPerfil()));
            } catch (IllegalArgumentException e) {
                throw new RuntimeException("Perfil inválido: " + dto.getPerfil());
            }
        }

        return entity;
    }
}
