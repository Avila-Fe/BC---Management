package com.project.bullcare.repository;

import com.project.bullcare.domain.dto.AnimalDTO;
import com.project.bullcare.model.AnimalModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<AnimalModel, Long> {
    AnimalModel findByIdentificacao(String identificacao);

}
