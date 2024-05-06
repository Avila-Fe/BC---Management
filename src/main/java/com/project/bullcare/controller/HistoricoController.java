package com.project.bullcare.controller;

import com.project.bullcare.domain.dto.ResponseDTO;
import com.project.bullcare.model.AnimalModel;
import com.project.bullcare.model.EventoModel;
import com.project.bullcare.service.HistoricoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bc/historico")
public class HistoricoController {

    @Autowired
    HistoricoService historicoService;

    @PostMapping("/{animalId}/{eventoId}")
    public ResponseEntity<ResponseDTO> adicionarAnimalAoEvento(@PathVariable Long animalId, @PathVariable Long eventoId) {
        ResponseDTO responseDTO = historicoService.adicionarAnimalAoEvento(animalId, eventoId);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("/consulta/evento/{eventoId}")
    public ResponseEntity<ResponseDTO> obterAnimaisDoEvento(@PathVariable Long eventoId) {
        ResponseDTO responseDTO = historicoService.obterAnimaisDoEvento(eventoId);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("/consulta/animal/{animalId}")
    public ResponseEntity<ResponseDTO> obterEventosDoAnimal(@PathVariable Long animalId) {
        ResponseDTO responseDTO =  historicoService.obterEventosDoAnimal(animalId);
        return ResponseEntity.ok(responseDTO);
    }

}
