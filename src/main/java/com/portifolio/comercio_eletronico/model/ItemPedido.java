package com.portifolio.comercio_eletronico.model;


import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_item_pedido")
public class ItemPedido {
    @EmbeddedId
    private ItemPedidoPK id = new ItemPedidoPK();
    private Integer quantidade;
    private Double preco;

    public ItemPedido() {
    }

    /*No contrutor não podemos permitir que seja acessado o atributo de instância
    ItemPedidoPK Mas vamos passar as classes Pedido e Produto dentro do construtor,
     para que os atributos sejam inicializados, chamamos o set de Pedido e Produto
     */
 public ItemPedido(Pedido pedido, Produto produto, Integer quantidade, Double preco) {
        id.setPedido(pedido);
        id.setProduto(produto);
        this.quantidade = quantidade;
        this.preco = preco;
    }

  /*Da mesma forma os gets e sets não serão do atributo de instância, quantidade e preco
     continuam sedo os mesmos*/

    public Pedido getPedido() {
        return id.getPedido();
    }

    public void setPedido(Pedido pedido) {
        id.setPedido(pedido);
    }

    public Produto getProduto() {
        return id.getProduto();
    }

    public void setProduto(Produto produto) {
        id.setProduto(produto);
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}




