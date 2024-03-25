package com.project.bullcare.service;

import com.project.bullcare.domain.dto.AnimalDTO;
import com.project.bullcare.domain.dto.ResponseDTO;
import com.project.bullcare.mapper.AnimalMapper;
import com.project.bullcare.model.AnimalModel;
import com.project.bullcare.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.project.bullcare.util.Constantes.*;

@Service
public class AnimalService {

    @Autowired
    AnimalRepository repository;

    @Autowired
    AnimalMapper mapper;

    @Autowired
    ValidacaoService validacaoService;

    public ResponseDTO cadastraAnimal(AnimalDTO animalDTO) {
        boolean existeAnimal = validacaoService.existeAnimal(animalDTO.getIdentificacao());

        if (existeAnimal) {
            AnimalModel animalModel = mapper.parse(animalDTO);
            repository.save(animalModel);
            return new ResponseDTO(CONCLUIDO, ANIMAL_ADICIONADO);
        }
        return new ResponseDTO(ERRO, ANIMAL_NAO_ADICIONADO, CAMPOS_VAZIOS);
    }

    public ResponseDTO pesquisaAnimal(String identificacao) {
        if (identificacao != null) {
            AnimalModel animal = repository.findByIdentificacao(identificacao);
            return new ResponseDTO(CONCLUIDO, animal.toString());
        }
        return new ResponseDTO(ERRO, ANIMAL_NAO_ENCONTRADO, CAMPO_IDENTIFICACAO_VAZIO);
    }
}
