package com.project.bullcare.controller;

import com.project.bullcare.domain.dto.RacaDTO;
import com.project.bullcare.domain.dto.ResponseDTO;
import com.project.bullcare.service.RacaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bc/raca")
public class RacaController {

    @Autowired
    RacaService service;

    @GetMapping("/consultar-lista")
    public ResponseEntity<ResponseDTO> consultaRaca(){
        ResponseDTO responseDTO = service.pesquisaRaca();
        return ResponseEntity.ok(responseDTO);
    }

    @PostMapping()
    public ResponseEntity<ResponseDTO> cadastraAnimal(@RequestBody RacaDTO racaDTO){
        ResponseDTO responseDTO = service.cadastraRaca(racaDTO);
        return ResponseEntity.ok(responseDTO);
    }
}
