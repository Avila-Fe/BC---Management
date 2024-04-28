package com.project.bullcare.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HistoricoDTO {

    private String animal;
    private String evento;
    private String unidadeDeMedida;
    private int quantidade;
    private String descricao;
}
