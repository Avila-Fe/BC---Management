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
    private Long id;
    @Column
    private String tipo;

    @OneToMany
    private List<EventoModel> eventoModel;
}
