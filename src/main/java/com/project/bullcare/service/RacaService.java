package com.project.bullcare.service;

import com.project.bullcare.domain.dto.RacaDTO;
import com.project.bullcare.domain.dto.ResponseDTO;
import com.project.bullcare.mapper.RacaMapper;
import com.project.bullcare.model.RacaModel;
import com.project.bullcare.repository.RacaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.project.bullcare.util.Constantes.*;

@Service
public class RacaService {

    @Autowired
    RacaRepository repository;

    @Autowired
    RacaMapper mapper;

    public ResponseDTO pesquisaRaca() {
        List<RacaModel> raca = repository.findAll();
        if (raca != null) {
            return new ResponseDTO(CONCLUIDO, raca);
        }
        return new ResponseDTO(ERRO, RACA_NAO_ENCONTRADA);
    }

    public ResponseDTO cadastraRaca(RacaDTO racaDTO) {
        if (racaDTO != null) {
            RacaModel racaModel = mapper.parse(racaDTO);
            repository.save(racaModel);
            return new ResponseDTO(CONCLUIDO, RACA_ADICIONADA);
        }
        return new ResponseDTO(ERRO, RACA_NAO_ADICIONADA, CAMPOS_VAZIOS);
    }
}
