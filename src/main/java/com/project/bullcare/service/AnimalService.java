package com.project.bullcare.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.bullcare.domain.dto.AnimalDTO;
import com.project.bullcare.domain.dto.ResponseDTO;
import com.project.bullcare.model.AnimalModel;
import com.project.bullcare.repository.AnimalRepository;
import com.project.bullcare.util.ParseAnimalDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.project.bullcare.util.Constantes.*;

@Service
public class AnimalService {
    @Autowired
    AnimalRepository animalRepository;
    @Autowired
    ParseAnimalDTO parseAnimalDTO;

    public ResponseDTO verificaDados(AnimalDTO animalDTO) {

        if (animalDTO != null) {
            AnimalModel animalModel = parseAnimalDTO.parse(animalDTO);
            animalRepository.save(animalModel);
            return new ResponseDTO(CONCLUIDO, ANIMAL_ADICIONADO);
        }

        return new ResponseDTO(ERRO, ANIMAL_NAO_ADICIONADO, CAMPOS_VAZIOS);
    }

    public ResponseDTO pesquisaAnimal(String identificacao) throws JsonProcessingException {
        if (identificacao != null) {
            AnimalModel animal = animalRepository.findByIdentificacao(identificacao);
            return new ResponseDTO(CONCLUIDO, animal);
        }
        return new ResponseDTO(ERRO, ANIMAL_NAO_ENCONTRADO, CAMPO_IDENTIFICACAO_VAZIO);
    }
}
