package com.project.bullcare.service;

import com.project.bullcare.domain.dto.AnimalDTO;
import com.project.bullcare.domain.dto.ResponseDTO;
import com.project.bullcare.mapper.AnimalMapper;
import com.project.bullcare.mapper.RacaMapper;
import com.project.bullcare.model.AnimalModel;
import com.project.bullcare.model.RacaModel;
import com.project.bullcare.repository.AnimalRepository;
import com.project.bullcare.repository.RacaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.project.bullcare.util.Constantes.*;

@Service
public class AnimalService {

    @Autowired
    AnimalRepository animalRepository;
    @Autowired
    AnimalMapper animalMapper;
    @Autowired
    RacaRepository racaRepository;
    @Autowired
    ValidacaoService validacaoService;

    public ResponseDTO cadastraAnimal(AnimalDTO animalDTO) {
        List<String> erros = validacaoService.validaDadosAnimal(animalDTO);
        if (erros.isEmpty()){

            RacaModel racaModel = racaRepository.findByRaca(animalDTO.getRaca());
            AnimalModel animalModel = animalMapper.parse(animalDTO, racaModel);
            animalRepository.save(animalModel);

            return new ResponseDTO(CONCLUIDO, ANIMAL_ADICIONADO);
        }
        return new ResponseDTO(ERRO, ERRO_VALIDACAO, erros);
    }

    public ResponseDTO pesquisaAnimal(String identificacao) {
        if (identificacao != null) {
            AnimalModel animal = animalRepository.findByIdentificacao(identificacao);
            return new ResponseDTO(CONCLUIDO, animal);
        }
        return new ResponseDTO(ERRO, ANIMAL_NAO_ENCONTRADO, CAMPO_IDENTIFICACAO_VAZIO);
    }
}
