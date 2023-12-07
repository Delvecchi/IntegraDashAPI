package com.integradash.api_integradash.repositories;

import com.integradash.api_integradash.models.ErroModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ErroRepository extends JpaRepository<ErroModel, UUID> {
    ErroModel findByNomeerro(String nomeerro);
}
