package com.project.bullcare.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "tipoEvento")
@Entity
public class TipoEventoModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String tipo;

    @OneToMany
    private List<EventoModel> evento;

    public TipoEventoModel(String tipo) {
        this.tipo = tipo;
    }
}
