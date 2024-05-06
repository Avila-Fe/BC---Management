package com.project.bullcare.domain.dto;

import com.project.bullcare.domain.Endereco;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {

    private String nome;
    private String sobreNome;
    private String cpf;
    private Endereco endereco;
    private String email;
    private String telefone;
    private String senha;
    private String status;
    private String tipoUsuario;



}
