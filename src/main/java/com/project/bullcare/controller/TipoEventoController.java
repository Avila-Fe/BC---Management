package com.project.bullcare.controller;

import com.project.bullcare.domain.dto.ResponseDTO;
import com.project.bullcare.domain.dto.TipoEventoDTO;
import com.project.bullcare.service.TipoEventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bc/tipoEvento")
public class TipoEventoController {

    @Autowired
    TipoEventoService tipoEventoService;

    @GetMapping("/consultar/{tipo}")
    public ResponseEntity<ResponseDTO> consultaTipoEvento(){
        ResponseDTO responseDTO = tipoEventoService.pesquisaTipoEvento();
        return ResponseEntity.ok(responseDTO);
    }

    @PostMapping()
    public ResponseEntity<ResponseDTO> cadastroTipoEvento(@RequestBody TipoEventoDTO tipoEventoDTO){
        ResponseDTO responseDTO = tipoEventoService.cadastraTipoEvento(tipoEventoDTO);
        return ResponseEntity.ok(responseDTO);
    }
}
