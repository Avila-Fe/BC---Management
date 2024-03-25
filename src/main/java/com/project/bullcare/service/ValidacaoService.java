package com.project.bullcare.service;

import com.project.bullcare.model.AnimalModel;
import com.project.bullcare.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidacaoService {

    @Autowired
    AnimalRepository repository;

    public boolean existeAnimal(String identificacao){
        AnimalModel animal = repository.findByIdentificacao(identificacao);
        if (animal == null){
            return true;
        } else {
            return false;
        }
    }
}
