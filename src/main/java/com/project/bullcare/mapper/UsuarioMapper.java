package com.project.bullcare.mapper;

import com.project.bullcare.domain.dto.UsuarioDTO;
import com.project.bullcare.model.UsuarioModel;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public UsuarioModel dtoToModel(UsuarioDTO usuarioDTO) {
        return UsuarioModel.builder()
                .nome(usuarioDTO.getNome())
                .sobreNome(usuarioDTO.getSobreNome())
                .cpf(usuarioDTO.getCpf())
                .endereco(usuarioDTO.getEndereco())
                .telefone(usuarioDTO.getTelefone())
                .senha(usuarioDTO.getSenha())
                .tipoUsuario(usuarioDTO.getTipoUsuario())
                .status(usuarioDTO.getStatus())
                .email(usuarioDTO.getEmail())
                .build();
    }
}
