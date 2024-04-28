package com.project.bullcare.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "historico")
public class HistoricoModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "animal")
    private AnimalModel animal;

    @ManyToOne
    @JoinColumn(name = "evento")
    private EventoModel evento;

    private String unidadeDeMedida;
    private int quantidade;
    private String descricao;
}
