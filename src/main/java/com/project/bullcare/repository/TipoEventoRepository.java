package com.project.bullcare.repository;

import com.project.bullcare.model.TipoEventoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoEventoRepository extends JpaRepository<TipoEventoModel, Long> {

    TipoEventoModel findByTipo(String tipo);
}
