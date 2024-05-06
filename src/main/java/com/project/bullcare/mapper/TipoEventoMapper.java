package com.project.bullcare.mapper;

import com.project.bullcare.domain.dto.RacaDTO;
import com.project.bullcare.domain.dto.TipoEventoDTO;
import com.project.bullcare.model.RacaModel;
import com.project.bullcare.model.TipoEventoModel;
import org.springframework.stereotype.Component;

@Component
public class TipoEventoMapper {

    public TipoEventoModel parse(TipoEventoDTO tipoEventoDTO){
        return TipoEventoModel.builder()
                .tipo(tipoEventoDTO.getTipo())
                .build();
    }
}
