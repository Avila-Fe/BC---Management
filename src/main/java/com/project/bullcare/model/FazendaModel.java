package com.project.bullcare.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "fazenda")
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
}