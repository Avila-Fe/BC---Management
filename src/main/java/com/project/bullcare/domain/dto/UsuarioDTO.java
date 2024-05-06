package com.project.bullcare.domain.dto;

import com.project.bullcare.domain.Endereco;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
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
