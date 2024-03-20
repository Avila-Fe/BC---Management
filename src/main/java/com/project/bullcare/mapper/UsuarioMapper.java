package com.project.bullcare.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.bullcare.domain.Usuario;
import com.project.bullcare.model.UsuarioModel;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public UsuarioModel dtoToModel(Usuario usuario) {
        return UsuarioModel.builder()
                .nome(usuario.getNome())
                .sobreNome(usuario.getSobreNome())
                .cpf(usuario.getCpf())
                .endereco(usuario.getEndereco())
                .telefone(usuario.getTelefone())
                .senha(usuario.getSenha())
                .tipoUsuario(usuario.getTipoUsuario())
                .status(usuario.getStatus())
                .email(usuario.getEmail())
                .build();
    }
}
