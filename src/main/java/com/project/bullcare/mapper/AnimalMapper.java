package com.project.bullcare.mapper;

import com.project.bullcare.domain.dto.AnimalDTO;
import com.project.bullcare.domain.dto.RacaDTO;
import com.project.bullcare.model.AnimalModel;
import com.project.bullcare.model.RacaModel;
import org.springframework.stereotype.Component;

@Component
public class AnimalMapper {

    public AnimalModel parse(AnimalDTO animalDTO, RacaModel racaModel) {

        return AnimalModel.builder()
                .identificacao(animalDTO.getIdentificacao())
                .data(animalDTO.getData())
                .sexo(animalDTO.getSexo())
                .cor(animalDTO.getCor())
                .lote(animalDTO.getLote())
                .status(animalDTO.getStatus())
                .descricao(animalDTO.getStatus())
                .dataEntrada(animalDTO.getDataEntrada())
                .dataSaida(animalDTO.getDataSaida())
                .raca(racaModel)
                .build();
    }
}
