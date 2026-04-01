package com.portifolio.comercio_eletronico.dto;


import com.portifolio.comercio_eletronico.model.Produto;

public class ProdutoDTO {
    private long id;
    private String nome;
    private String descricao;
    private double preco;
    private String imgUrl;
    public ProdutoDTO() {}
    public ProdutoDTO(long id, String nome, String descricao, double preco, String imgUrl) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.imgUrl = imgUrl;
    }
    // O construtor recebe como parâmetro o objeto 'produto' original (a Classe)
    public ProdutoDTO(Produto produto) {
       //Copia todos os valores recebidos na classe Produto()
       id = produto.getId();
       nome = produto.getNome();
       descricao = produto.getDescricao();
       preco = produto.getPreco();
       imgUrl = produto.getImgUrl();
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPreco() {
        return preco;
    }

    public String getImgUrl() {
        return imgUrl;
    }
}
