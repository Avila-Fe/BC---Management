package com.project.bullcare.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "raca")
@Entity
public class RacaModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String raca;

    @OneToMany(mappedBy = "raca")
    private List<AnimalModel> animais;

}
