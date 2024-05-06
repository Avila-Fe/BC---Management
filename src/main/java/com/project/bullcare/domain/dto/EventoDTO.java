package com.project.bullcare.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EventoDTO {

    private String descricao;
    private String unidadeMedida;
    private String dataEvento;
    private String tipoEvento;
}
