package com.portifolio.comercio_eletronico.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class ItemPedidoPK {

    @ManyToOne
    @JoinColumn(name="pedido_id")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name="produto_id")
    private Produto produto;
    //Observação: adicione apenas construtor vazio, Gets e Sets

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}


