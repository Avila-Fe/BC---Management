package com.project.bullcare.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    @JsonIgnoreProperties("raca")
    private List<AnimalModel> animal;

}
