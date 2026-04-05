package com.portifolio.comercio_eletronico.dto;


import com.portifolio.comercio_eletronico.model.Produto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class ProdutoDTO {
    private long id;
    @Size(min = 3, max = 80, message = "Nome precisa ter entre três e oitenta caracteres!")
    @NotBlank(message = "Campo obrigatorio!")
    private String nome;

    @Size(min = 10, message = "Descrição deve ter no minimo dez caracteres!")
    @NotBlank(message = "Campo obrigatorio!")
    private String descricao;

    @Positive(message = "O preço deve ser positivo!")
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
