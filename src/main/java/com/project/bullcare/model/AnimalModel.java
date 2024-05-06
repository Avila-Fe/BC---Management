package com.project.bullcare.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "animal")
@Entity
public class AnimalModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String identificacao;
    @Column
    private String data;
    @Column
    private String sexo;
    @Column
    private String cor;
    @Column
    private String lote;
    @Column
    private String status;
    @Column
    private String descricao;
    @Column
    private String dataEntrada;
    @Column
    private String dataSaida;

    @ManyToOne
    @JoinColumn(name = "raca")
    private RacaModel raca;

    @ManyToOne
    @JoinColumn(name = "fazenda")
    private FazendaModel fazenda;

    @OneToMany(mappedBy = "animal")
    private Set<HistoricoModel> historico = new HashSet<>();
}
