package com.project.bullcare.domain.dto;

import com.project.bullcare.model.AnimalModel;
import lombok.*;

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
    private List<AnimalModel> modelList;
}
