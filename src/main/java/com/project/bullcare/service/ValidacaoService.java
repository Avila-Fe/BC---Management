package com.project.bullcare.service;

import com.project.bullcare.domain.dto.AnimalDTO;
import com.project.bullcare.model.AnimalModel;
import com.project.bullcare.model.RacaModel;
import com.project.bullcare.model.UsuarioModel;
import com.project.bullcare.repository.AnimalRepository;
import com.project.bullcare.repository.RacaRepository;
import com.project.bullcare.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.project.bullcare.util.Constantes.ANIMAL_EXISTENTE;
import static com.project.bullcare.util.Constantes.RACA_NAO_ENCONTRADA;

@Service
public class ValidacaoService {

    @Autowired
    AnimalRepository animalRepository;
    @Autowired
    RacaRepository racaRepository;
    @Autowired
    UsuarioRepository usuarioRepository;

    public List<String> validaDados(AnimalDTO animalDTO){
        List<String> erros = new ArrayList<>();

        existeAnimal(animalDTO.getIdentificacao(), erros);
        existeRaca(animalDTO.getRaca(), erros);

        return erros;
    }

    public void existeAnimal(String identificacao, List<String> erro){
        AnimalModel animal = animalRepository.findByIdentificacao(identificacao);
        if (animal == null){
            erro.add(ANIMAL_EXISTENTE);
        }
    }

    public void existeRaca(String raca, List<String> erro){
        RacaModel racaModel = racaRepository.findByRaca(raca);
        if (racaModel == null){
            erro.add(RACA_NAO_ENCONTRADA);
        }
    }

    public boolean existeUsuario(String cpf){
        UsuarioModel usuario = usuarioRepository.findByCpf(cpf);
        if (usuario == null){
            return true;
        } else {
            return false;
        }
    }

}
