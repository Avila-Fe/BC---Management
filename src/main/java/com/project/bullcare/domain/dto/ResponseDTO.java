package com.project.bullcare.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDTO {

    private String status;
    private String mensagem;
    private String erro;
    private List<String> listaErro;
    @JsonProperty(value = "resultado")
    private Object objeto;
    @JsonProperty(value = "resultado")
    private List<Object> listaObjeto;

    public ResponseDTO(String status, String mensagem) {
        this.status = status;
        this.mensagem = mensagem;
    }

    public ResponseDTO(String status, String mensagem, String erro) {
        this.status = status;
        this.mensagem = mensagem;
        this.erro = erro;
    }

    public ResponseDTO(String status, String mensagem, List<String> listaErro) {
        this.status = status;
        this.mensagem = mensagem;
        this.listaErro = listaErro;
    }

    public ResponseDTO(String status, Object objeto) {
        this.status = status;
        this.objeto = objeto;
    }

    public ResponseDTO(String status, List<Object> listaObjeto) {
        this.status = status;
        this.listaObjeto = listaObjeto;
    }
}
