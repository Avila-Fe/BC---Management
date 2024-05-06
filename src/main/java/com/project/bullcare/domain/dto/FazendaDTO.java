package com.project.bullcare.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.bullcare.model.AnimalModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FazendaDTO {
    private String cpfUsuario;
    private String nomeFazenda;
    private String referencia;
    private String area;
    @JsonProperty(value = "animais")
    private List<AnimalModel> modelList;
}
