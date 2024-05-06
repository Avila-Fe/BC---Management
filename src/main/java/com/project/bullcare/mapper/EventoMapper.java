package com.project.bullcare.mapper;

import com.project.bullcare.domain.dto.AnimalDTO;
import com.project.bullcare.domain.dto.EventoDTO;
import com.project.bullcare.model.AnimalModel;
import com.project.bullcare.model.EventoModel;
import com.project.bullcare.model.RacaModel;
import com.project.bullcare.model.TipoEventoModel;
import org.springframework.stereotype.Component;

@Component
public class EventoMapper {

    public EventoModel parse(EventoDTO eventoDTO, TipoEventoModel tipoEventoModel) {

        return EventoModel.builder()
                .descricao(eventoDTO.getDescricao())
                .unidadeMedida(eventoDTO.getUnidadeMedida())
                .dataEvento(eventoDTO.getDataEvento())
                .tipoEvento(tipoEventoModel)
                .build();
    }
}
