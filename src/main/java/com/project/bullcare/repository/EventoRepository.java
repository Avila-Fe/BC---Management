package com.project.bullcare.repository;

import com.project.bullcare.model.EventoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoRepository extends JpaRepository<EventoModel, Long> {

    EventoModel findByTipoEvento(String tipo);
}
