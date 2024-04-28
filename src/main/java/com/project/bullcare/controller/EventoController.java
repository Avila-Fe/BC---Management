package com.project.bullcare.controller;

import com.project.bullcare.domain.dto.EventoDTO;
import com.project.bullcare.domain.dto.ResponseDTO;
import com.project.bullcare.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bc/evento")
public class EventoController {

    @Autowired
    EventoService eventoService;

    @GetMapping("/consultar/{tipo}")
    public ResponseEntity<ResponseDTO> consultaEvento(@PathVariable(name = "tipo") String tipo){
        ResponseDTO responseDTO = eventoService.pesquisaEvento(tipo);
        return ResponseEntity.ok(responseDTO);
    }

    @PostMapping()
    public ResponseEntity<ResponseDTO> cadastroEvento(@RequestBody EventoDTO eventoDTO){
        ResponseDTO responseDTO = eventoService.cadastraEvento(eventoDTO);
        return ResponseEntity.ok(responseDTO);
    }
}
