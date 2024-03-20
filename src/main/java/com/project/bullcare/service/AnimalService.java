package com.project.bullcare.service;

import com.project.bullcare.domain.dto.AnimalDTO;
import com.project.bullcare.domain.dto.ResponseDTO;
import com.project.bullcare.model.AnimalModel;
import com.project.bullcare.repository.AnimalRepository;
import com.project.bullcare.util.ParseAnimalDTO;
import org.springframework.stereotype.Service;

import static com.project.bullcare.util.Constantes.*;

@Service
public class AnimalService {

    AnimalRepository animalRepository;
    ParseAnimalDTO parseAnimalDTO;

    public ResponseDTO verificaDados(AnimalDTO animalDTO){

        if (animalDTO != null){
            AnimalModel animalModel = parseAnimalDTO.parse(animalDTO);
            animalRepository.save(animalModel);
            return new ResponseDTO(CONCLUIDO,ANIMAL_ADICIONADO);
        }

        return new ResponseDTO(ERRO,ANIMAL_NAO_ADICIONADO,CAMPOS_VAZIOS);
    }

    public ResponseDTO pesquisaAnimal(String identificacao){
        if (identificacao != null){
           AnimalDTO animal = animalRepository.findByIdentificacao(identificacao);
            return new ResponseDTO(CONCLUIDO, animal.toString());
        }
            return new ResponseDTO(ERRO,ANIMAL_NAO_ENCONTRADO,CAMPO_IDENTIFICACAO_VAZIO);
    }
}
