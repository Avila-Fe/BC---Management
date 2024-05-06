package com.project.bullcare.repository;

import com.project.bullcare.model.AnimalModel;
import com.project.bullcare.model.EventoModel;
import com.project.bullcare.model.HistoricoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HistoricoRepository extends JpaRepository<HistoricoModel, Long> {

    List<AnimalModel> findAnimaisByEvento(Optional<EventoModel> eventoId);

    List<EventoModel> findEventosByAnimal(Optional<AnimalModel> animalId);

}
