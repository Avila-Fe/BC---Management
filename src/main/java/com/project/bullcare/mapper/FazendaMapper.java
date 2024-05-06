package com.project.bullcare.mapper;

import com.project.bullcare.domain.dto.FazendaDTO;
import com.project.bullcare.domain.dto.UsuarioDTO;
import com.project.bullcare.model.AnimalModel;
import com.project.bullcare.model.FazendaModel;
import com.project.bullcare.model.UsuarioModel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FazendaMapper {

    public FazendaModel dtoToModel(FazendaDTO fazendaDTO, UsuarioModel usuarioModel, List<AnimalModel> animalModel){
        return FazendaModel.builder()
                .nomeFazenda(fazendaDTO.getNomeFazenda())
                .referencia(fazendaDTO.getReferencia())
                .area(fazendaDTO.getArea())
                .animalModel(animalModel)
                .usuario(usuarioModel)
                .build();
    }

    public FazendaModel modelToJson(FazendaModel fazendaModel){
        fazendaModel.getUsuario().setFazenda(null);
        return FazendaModel.builder()
                .nomeFazenda(fazendaModel.getNomeFazenda())
                .referencia(fazendaModel.getReferencia())
                .area(fazendaModel.getArea())
                .usuario(fazendaModel.getUsuario())
                .animalModel(fazendaModel.getAnimalModel())
                .build();
    }
}
