package com.integradash.api_integradash.repositories;

import com.integradash.api_integradash.models.PlantaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PlantaRepository extends JpaRepository<PlantaModel, UUID> {
    PlantaModel findByNomeplanta(String nomeplanta);
}
