package com.project.bullcare.controller;

import com.project.bullcare.domain.dto.AnimalDTO;
import com.project.bullcare.domain.dto.ResponseDTO;
import com.project.bullcare.repository.AnimalRepository;
import com.project.bullcare.service.AnimalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/animal")
public class AnimalController {

    AnimalService animalService;

    @GetMapping("/consultar/{identificacao}")
    public ResponseEntity<ResponseDTO> consultaAnimal(@PathVariable(name = "identificacao") String identificacao) {
        ResponseDTO responseDTO = animalService.pesquisaAnimal(identificacao);
        return ResponseEntity.ok(responseDTO);
    }

    @PostMapping()
    public ResponseEntity<ResponseDTO> cadastroAnimal(@RequestBody AnimalDTO animalDTO){
        ResponseDTO responseDTO = animalService.verificaDados(animalDTO);
        return ResponseEntity.ok(responseDTO);
    }
}
