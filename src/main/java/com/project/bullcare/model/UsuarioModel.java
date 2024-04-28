package com.project.bullcare.model;

import com.project.bullcare.domain.Endereco;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "usuario")
public class UsuarioModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "sobreNome")
    private String sobreNome;
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "endereco")
    @Embedded
    private Endereco endereco;
    @Column(name = "email")
    private String email;
    @Column(name = "telefone")
    private String telefone;
    @Column(name = "senha")
    private String senha;
    @Column(name = "status")
    private String status;
    @Column(name = "tipoUsuario")
    private String tipoUsuario;

    @OneToMany(mappedBy = "usuario")
    private List<FazendaModel> fazenda;
}
