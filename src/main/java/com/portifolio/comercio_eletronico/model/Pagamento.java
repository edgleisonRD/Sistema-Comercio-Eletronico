package com.portifolio.comercio_eletronico.model;

import jakarta.persistence.*;

import java.time.Instant;
@Entity
@Table(name="tb_pagamento")
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant horario;

    @OneToOne
    @MapsId//Utilizada para criar uma Chave Primária Compartilhada entre duas entidades.
    private Pedido pedido;
//Falta construtores Gets e Sets
}


