package com.project.bullcare.controller;

import com.project.bullcare.domain.dto.FazendaDTO;
import com.project.bullcare.domain.dto.ResponseDTO;
import com.project.bullcare.service.FazendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bc/fazenda")
public class FazendaController {

    @Autowired
    FazendaService fazendaService;

    @PostMapping
    public ResponseEntity<ResponseDTO> cadastroFazenda(@RequestBody FazendaDTO fazendaDTO){
        ResponseDTO responseDTO = fazendaService.cadastrarFazenda(fazendaDTO);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping
    public ResponseEntity<ResponseDTO> listarFazendas(){
        ResponseDTO responseDTO = fazendaService.listarFazendas();
        return ResponseEntity.ok(responseDTO);
    }
}
