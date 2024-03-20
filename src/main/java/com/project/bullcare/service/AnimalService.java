package com.project.bullcare.service;

import com.project.bullcare.domain.dto.AnimalDTO;
import com.project.bullcare.domain.dto.ResponseDTO;
import com.project.bullcare.model.AnimalModel;
import com.project.bullcare.repository.AnimalRepository;
import com.project.bullcare.util.ParseAnimalDTO;
import org.springframework.stereotype.Service;

@Service
public class AnimalService {

    AnimalRepository animalRepository;
    ParseAnimalDTO parseAnimalDTO;

    public ResponseDTO verificaDados(AnimalDTO animalDTO){

        if (animalDTO != null){
            AnimalModel animalModel = parseAnimalDTO.parse(animalDTO);
            animalRepository.save(animalModel);
            return new ResponseDTO("Concluido","Animal adicionado com sucesso!");
        }

        return new ResponseDTO("Erro", "Erro ao adicionar animal","Os campos não podem ser vazios!");
    }

    public ResponseDTO pesquisaAnimal(String identificacao){
        if (identificacao != null){
           AnimalDTO animal = animalRepository.findByIdentificacao(identificacao);
            return new ResponseDTO("Concluido", animal.toString());
        }
        return new ResponseDTO("Erro", "Erro ao pesquisar animal","O campo identificacão não pode ser vazio!");
    }
}
