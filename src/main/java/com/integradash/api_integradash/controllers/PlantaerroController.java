package com.integradash.api_integradash.controllers;

import com.integradash.api_integradash.dtos.PlantaerroDto;
import com.integradash.api_integradash.models.PlantaerroModel;
import com.integradash.api_integradash.repositories.PlantaerroRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/plantaerro", produces = {"application/json"})
public class PlantaerroController {

    @Autowired
    PlantaerroRepository plantaerroRepository;

    @GetMapping
    public ResponseEntity<List<PlantaerroModel>> listarPlantaerro() {
        return ResponseEntity.status(HttpStatus.OK).body(plantaerroRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Object> cadastrarPlamtaerro(@RequestBody @Valid PlantaerroDto plantaerroDto) {
        if (plantaerroRepository.findByDescricao(plantaerroDto.descricao()) != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Planta Erro já cadastrado");
        }

        PlantaerroModel plantaerro = new PlantaerroModel();
        BeanUtils.copyProperties(plantaerroDto, plantaerro);

        return ResponseEntity.status(HttpStatus.CREATED).body(plantaerroRepository.save(plantaerro));
    }
}
