package com.project.bullcare.service;

import com.project.bullcare.domain.dto.UsuarioDTO;
import com.project.bullcare.domain.dto.ResponseDTO;
import com.project.bullcare.mapper.UsuarioMapper;
import com.project.bullcare.model.UsuarioModel;
import com.project.bullcare.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.project.bullcare.util.Constantes.*;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository repository;
    @Autowired
    UsuarioMapper mapper;
    @Autowired
    ValidacaoService validacaoService;

    public ResponseDTO pesquisaUsuario() {
        List<UsuarioModel> usuarioModel = repository.findAll();
        if (!usuarioModel.isEmpty()) {
            return new ResponseDTO(CONCLUIDO, usuarioModel);
        }

        return new ResponseDTO(ERRO, USUARIO_NAO_ENCONTRADO, USUARIOS_NAO_ENCONTRADOS);
    }

    public ResponseDTO pesquisaUsuarioCpf(String cpf) {
        UsuarioModel usuarioModel = repository.findByCpf(cpf);
        if (!validacaoService.isNullOrEmpty(usuarioModel.getCpf())) {
            return new ResponseDTO(CONCLUIDO, usuarioModel);
        }

        return new ResponseDTO(ERRO, USUARIO_NAO_ENCONTRADO, USUARIOS_NAO_ENCONTRADOS);
    }

    public ResponseDTO cadastraUsuario(UsuarioDTO usuarioDTO) {
        List<String> erros = validacaoService.validaDadosUsuario(usuarioDTO);
        if (erros.isEmpty()) {
            UsuarioModel usuarioModel = mapper.dtoToModel(usuarioDTO);
            repository.save(usuarioModel);
            return new ResponseDTO(CONCLUIDO, USUARIO_ADICIONADO);
        }
        return new ResponseDTO(ERRO, USUARIO_NAO_ADICIONADO, USUARIO_EXISTENTE);
    }
}
