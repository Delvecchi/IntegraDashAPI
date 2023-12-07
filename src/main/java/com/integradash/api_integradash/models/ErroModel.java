package com.integradash.api_integradash.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "tb_erro")
public class ErroModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_erro", nullable = false)
    private UUID id;

    private String nomeerro;

    @Temporal(TemporalType.DATE)
    private Date data_erro;

    private String descricao_erro;

    private String status_erro;


}
