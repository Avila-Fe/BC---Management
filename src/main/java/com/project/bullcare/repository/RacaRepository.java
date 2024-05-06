package com.project.bullcare.repository;

import com.project.bullcare.model.RacaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RacaRepository extends JpaRepository<RacaModel, Long> {

    RacaModel findByRaca(String raca);
}
