package com.project.bullcare.mapper;

import com.project.bullcare.domain.dto.AnimalDTO;
import com.project.bullcare.model.AnimalModel;
import org.springframework.stereotype.Component;

@Component
public class AnimalMapper {

    public AnimalModel parse(AnimalDTO animalDTO) {
        return AnimalModel.builder()
                .identificacao(animalDTO.getIdentificacao())
                .data(animalDTO.getData())
                .sexo(animalDTO.getSexo())
                .cor(animalDTO.getCor())
                .lote(animalDTO.getLote())
                .status(animalDTO.getStatus())
                .descricao(animalDTO.getStatus())
                .dataEntrada(animalDTO.getDataEntrada())
                .dataSaida(animalDTO.getDataSaida()).build();
    }
}
