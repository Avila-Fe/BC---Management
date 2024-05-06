package com.project.bullcare.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "fazenda")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FazendaModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nomeFazenda")
    private String nomeFazenda;
    @Column(name = "referencia")
    private String referencia;
    @Column(name = "area")
    private String area;

    @ManyToOne
    @JoinColumn(name = "usuario")
    @JsonIgnoreProperties("usuario")
    private UsuarioModel usuario;

    @OneToMany(mappedBy = "fazenda")
    private List<AnimalModel>  animalModel;
}