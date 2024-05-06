package com.project.bullcare.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.bullcare.domain.dto.UsuarioDTO;
import com.project.bullcare.domain.dto.ResponseDTO;
import com.project.bullcare.mapper.UsuarioMapper;
import com.project.bullcare.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/bc/usuario")
public class UsuarioController {

    @Autowired
    UsuarioMapper usuarioMapper;
    @Autowired
    UsuarioService usuarioService;

    ObjectMapper mapper = new ObjectMapper();

    @PostMapping("/save")
    public ResponseEntity<ResponseDTO> usuario(@RequestBody UsuarioDTO usuarioDTO) {
        ResponseDTO responseDTO = usuarioService.cadastraUsuario(usuarioDTO);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("/listar")
    public ResponseEntity<ResponseDTO> usuarioListar() {
        ResponseDTO responseDTO = usuarioService.pesquisaUsuario();
        return ResponseEntity.ok(responseDTO);
    }
}
