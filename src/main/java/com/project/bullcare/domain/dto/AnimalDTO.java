package com.project.bullcare.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AnimalDTO {

    private String identificacao;
    private String data;
    private String sexo;
    private String cor;
    private String lote;
    private String status;
    private String descricao;
    private String dataEntrada;
    private String dataSaida;
    private String raca;

}
