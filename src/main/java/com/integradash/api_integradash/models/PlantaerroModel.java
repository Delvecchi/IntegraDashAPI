package com.integradash.api_integradash.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "tb_planta_erro")
public class PlantaerroModel implements Serializable {
    private static final long serialVersionUID =1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_planta_erro", nullable = false)
    private UUID id;

    private String descricao;


    @ManyToOne
    @JoinColumn(name = "id_erro", referencedColumnName = "id_erro")
    private ErroModel id_erro;

    @ManyToOne
    @JoinColumn(name = "id_planta", referencedColumnName = "id_planta")
    private PlantaModel id_planta;
}


