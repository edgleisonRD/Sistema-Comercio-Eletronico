package com.portifolio.comercio_eletronico.model;

import jakarta.persistence.*;

import java.time.Instant;
@Entity
@Table(name="tb_pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant horario;
    private StatusPedido status;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Usuario cliente;

    @OneToOne(cascade = CascadeType.ALL)
    private Pagamento pagamento;

    public Pedido() {

    }//Adicione Construtores, Gets e Sets
    public Pedido(long id, Instant horario, StatusPedido status, Usuario cliente, Pagamento pagamento) {
        this.id = id;
        this.horario = horario;
        this.status = status;
        this.cliente = cliente;
        this.pagamento = pagamento;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Instant getHorario() {
        return horario;
    }

    public void setHorario(Instant horario) {
        this.horario = horario;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }
}
