package com.project.bullcare.service;

import com.project.bullcare.domain.dto.HistoricoDTO;
import com.project.bullcare.domain.dto.ResponseDTO;
import com.project.bullcare.model.AnimalModel;
import com.project.bullcare.model.EventoModel;
import com.project.bullcare.model.HistoricoModel;
import com.project.bullcare.repository.AnimalRepository;
import com.project.bullcare.repository.EventoRepository;
import com.project.bullcare.repository.HistoricoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.project.bullcare.util.Constantes.*;

@Service
public class HistoricoService {

    @Autowired
    private HistoricoRepository historicoRepository;
    @Autowired
    private AnimalRepository animalRepository;
    @Autowired
    private EventoRepository eventoRepository;

    public ResponseDTO adicionarAnimalAoEvento(Long animalId, Long eventoId) {
        Optional<AnimalModel> animalOp = animalRepository.findById(animalId);
        Optional<EventoModel> eventoOp = eventoRepository.findById(eventoId);

        if (animalOp.isPresent() || eventoOp.isPresent()){
            AnimalModel animal = animalOp.get();
            EventoModel evento = eventoOp.get();

            HistoricoModel historico = new HistoricoModel();
            historico.setAnimal(animal);
            historico.setEvento(evento);

            historicoRepository.save(historico);

            HistoricoDTO historicoDTO = new HistoricoDTO(animal.getIdentificacao(), evento.getDescricao());

            return new ResponseDTO(CONCLUIDO, ANIMAL_ADICIONADO, String.valueOf(historicoDTO));
        }
        return new ResponseDTO(ERRO, ERRO_VALIDACAO);
    }

    public ResponseDTO obterAnimaisDoEvento(Long eventoId) {
        Optional<EventoModel> evento = eventoRepository.findById(eventoId);
        List<AnimalModel> animais = historicoRepository.findAnimaisByEvento(evento);
        return new ResponseDTO(CONCLUIDO, animais);
    }

    public ResponseDTO obterEventosDoAnimal(Long animalId) {
        Optional<AnimalModel> animal = animalRepository.findById(animalId);
        List<EventoModel> eventos = historicoRepository.findEventosByAnimal(animal);
        return new ResponseDTO(CONCLUIDO, eventos);
    }
}
