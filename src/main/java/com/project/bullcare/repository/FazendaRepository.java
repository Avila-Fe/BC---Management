package com.project.bullcare.repository;

import com.project.bullcare.model.FazendaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FazendaRepository extends JpaRepository<FazendaModel, Long> {
}
