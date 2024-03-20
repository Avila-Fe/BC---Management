package com.project.bullcare.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO {

    private String status;
    private String mensagem;
    private String erro;

    public ResponseDTO(String status, String mensagem) {
        this.status = status;
        this.mensagem = mensagem;
    }
}
