package com.project.bullcare.mapper;

import com.project.bullcare.domain.dto.RacaDTO;
import com.project.bullcare.model.RacaModel;
import org.springframework.stereotype.Component;

@Component
public class RacaMapper {

    public RacaModel parse(RacaDTO racaDTO){
        return RacaModel.builder()
                .raca(racaDTO.getRaca())
                .build();
    }

}
