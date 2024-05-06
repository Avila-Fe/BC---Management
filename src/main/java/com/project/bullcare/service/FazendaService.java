package com.project.bullcare.service;

import com.project.bullcare.domain.dto.FazendaDTO;
import com.project.bullcare.domain.dto.ResponseDTO;
import com.project.bullcare.mapper.FazendaMapper;
import com.project.bullcare.model.FazendaModel;
import com.project.bullcare.model.UsuarioModel;
import com.project.bullcare.repository.FazendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import static com.project.bullcare.util.Constantes.*;

@Service
public class FazendaService {

    @Autowired
    ValidacaoService validacaoService;
    @Autowired
    FazendaMapper fazendaMapper;
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    FazendaRepository repository;

    public ResponseDTO cadastrarFazenda(FazendaDTO fazenda){
        List<String> erros = validacaoService.validaFazenda(fazenda);
        if(erros.isEmpty()){
            ResponseDTO usuario = usuarioService.pesquisaUsuarioCpf(fazenda.getCpfUsuario());
            if(usuario.getStatus().equals(CONCLUIDO)){
                FazendaModel fazendaModel = fazendaMapper.dtoToModel(fazenda, (UsuarioModel) usuario.getObjeto(), fazenda.getModelList());
                repository.save(fazendaModel);

                return new ResponseDTO(CONCLUIDO, FAZENDA_ADICIONADA);
            }
        }

        return new ResponseDTO(ERRO, FAZENDA_NAO_ADICIONADA, erros);
    }

    public ResponseDTO listarFazendas(){
        List<FazendaModel> fazendaModel = repository.findAll();
        if (!fazendaModel.isEmpty()) {
            List<FazendaModel> modelList = new ArrayList<>();
            fazendaModel.forEach((fazenda) -> {
                modelList.add(fazendaMapper.modelToJson(fazenda));
            });
            return new ResponseDTO(CONCLUIDO, modelList);
        }

        return new ResponseDTO(ERRO, FAZENDA_NAO_ENCONTRADO, FAZENDA_NAO_ENCONTRADOS);
    }
}
