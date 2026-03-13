package com.portifolio.comercio_eletronico.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tb_produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    @Column(columnDefinition = "TEXT")
    private String descricao;
    private double preco;
    private String imgUrl;

    @ManyToMany
    @JoinTable(name="tb_produto_categoria",
    joinColumns = @JoinColumn(name = "produto_id"),
    inverseJoinColumns = @JoinColumn(name="categoria_id"))
    private Set<Categoria> categorias = new HashSet<>();

    @OneToMany(mappedBy = "id.produto")
    private Set<ItemPedido> itens = new HashSet<>();

    //Adicione os construtores Gets e Sets
    //Não adicione Set<Categoria> no construtor
    //Adicione apenas Get para Set<Categoria>
    public Produto() {

    }
    public Produto(long id, String nome, String descricao, double preco, String imgUrl) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.imgUrl = imgUrl;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Set<Categoria> getCategorias() {
        return categorias;
    }

    public Set<ItemPedido> getItens() {
        return itens;
    }
    public List<Pedido> getPedidos() {
        return itens.stream().map(x -> x.getPedido()).toList();
    }
}

