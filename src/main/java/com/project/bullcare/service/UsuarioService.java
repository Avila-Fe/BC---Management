package com.project.bullcare.service;

import com.project.bullcare.domain.Usuario;
import com.project.bullcare.domain.dto.ResponseDTO;
import com.project.bullcare.mapper.UsuarioMapper;
import com.project.bullcare.model.AnimalModel;
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

    public ResponseDTO cadastraUsuario(Usuario usuario) {
        boolean existeUsuario = validacaoService.existeUsuario(usuario.getCpf());
        if (!existeUsuario) {
            UsuarioModel usuarioModel = mapper.dtoToModel(usuario);
            repository.save(usuarioModel);
            return new ResponseDTO(CONCLUIDO, USUARIO_ADICIONADO);
        }
        return new ResponseDTO(ERRO, USUARIO_NAO_ADICIONADO, USUARIO_EXISTENTE);
    }
}
