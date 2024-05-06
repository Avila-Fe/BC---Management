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
@Table(name = "evento")
@Entity
public class EventoModel implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String descricao;
    @Column
    private String unidadeMedida;
    @Column
    private String dataEvento;

    @ManyToOne
    @JoinColumn(name = "tipoEvento")
    private TipoEventoModel tipoEvento;

    @OneToMany(mappedBy = "evento")
    private Set<HistoricoModel> historico = new HashSet<>();
}
