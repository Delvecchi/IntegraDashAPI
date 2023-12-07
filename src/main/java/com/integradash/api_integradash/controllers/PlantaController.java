package com.integradash.api_integradash.controllers;

import com.integradash.api_integradash.dtos.ErroDto;
import com.integradash.api_integradash.dtos.PlantaDto;
import com.integradash.api_integradash.models.ErroModel;
import com.integradash.api_integradash.models.PlantaModel;
import com.integradash.api_integradash.repositories.ErroRepository;
import com.integradash.api_integradash.repositories.PlantaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = "/planta", produces = {"application/json"})
public class PlantaController {

    @Autowired
    ErroRepository erroRepository;
    @Autowired
    private PlantaRepository plantaRepository;

    @GetMapping
    public ResponseEntity<List<PlantaModel>> listarPlanta() {
        return ResponseEntity.status(HttpStatus.OK).body(plantaRepository.findAll());
    }

    @GetMapping("/{idPlanta}")
    public ResponseEntity<Object> exibirPlanta(@PathVariable(value = "idPlanta") UUID id) {
        Optional<PlantaModel> plantaBuscado = plantaRepository.findById(id);

        if (plantaBuscado.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro não encontrado");
        }

        return ResponseEntity.status(HttpStatus.OK).body(plantaBuscado.get());
    }

    @PostMapping
    public ResponseEntity<Object> cadastrarPlanta(@RequestBody @Valid PlantaDto plantaDto) {
        if (erroRepository.findByNomeerro(plantaDto.nomeplanta()) != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Planta já cadastrado");
        }

        PlantaModel planta = new PlantaModel();
        BeanUtils.copyProperties(plantaDto, planta);

        return ResponseEntity.status(HttpStatus.CREATED).body(plantaRepository.save(planta));
    }

    @PutMapping("/{idPlanta}")
    public ResponseEntity<Object> editarPlanta(@PathVariable(value = "idPlanta") UUID id, @RequestBody @Valid PlantaDto plantaDto) {
        Optional<PlantaModel> plantaBuscado = plantaRepository.findById(id);

        if (plantaBuscado.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Planta não encontrado");
        }

        PlantaModel planta = plantaBuscado.get();
        BeanUtils.copyProperties(plantaDto, planta);

        return ResponseEntity.status(HttpStatus.CREATED).body(plantaRepository.save(planta));
    }

    @DeleteMapping("/{idPlanta}")
    public ResponseEntity<Object> deletarPlanta(@PathVariable(value = "idPlanta") UUID id) {
        Optional<PlantaModel> plantaBuscado = plantaRepository.findById(id);

        if (plantaBuscado.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Planta não encontrado");
        }

        plantaRepository.delete(plantaBuscado.get());
        return ResponseEntity.status(HttpStatus.OK).body("Planta deletado com sucesso");

    }
}