package com.project.bullcare.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.bullcare.domain.Usuario;
import com.project.bullcare.mapper.UsuarioMapper;
import com.project.bullcare.model.UsuarioModel;
import com.project.bullcare.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/bc")
public class UserController {

    @Autowired
    UsuarioMapper usuarioMapper;
    @Autowired
    UsuarioRepository repository;

    ObjectMapper mapper = new ObjectMapper();

    @PostMapping("/save")
    public ResponseEntity<String> usuario(@RequestBody Usuario payload) throws JsonProcessingException {
        UsuarioModel usuarioModel = usuarioMapper.dtoToModel(payload);
        repository.save(usuarioModel);
        return ResponseEntity.ok(mapper.writeValueAsString(usuarioModel));
    }

    @GetMapping("/listar")
    public ResponseEntity<String> usuarioListar() throws JsonProcessingException {
        List<UsuarioModel> usuarioModel = repository.findAll();

        return ResponseEntity.ok(mapper.writeValueAsString(usuarioModel));
    }
}
