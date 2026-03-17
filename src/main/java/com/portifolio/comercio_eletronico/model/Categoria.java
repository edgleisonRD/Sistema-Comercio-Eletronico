package com.portifolio.comercio_eletronico.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="tb_categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String nome;
    @ManyToMany(mappedBy = "categorias")
    private Set<Produto> produtos = new HashSet<>();

    public Categoria(long id, String nome) {
        this.id = id;
        this.nome = nome;
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

    public Set<Produto> getProdutos() {
        return produtos;
    }

    @Override
    public boolean equals(Object o) {

        /* 1. Verifica se é o MESMO objeto na memória
        (mesma referência)*/
        if (this == o) return true;

        /* 2. Verifica se o objeto é nulo OU de outra
         classe
         Evita ClassCastException*/
        if (o == null || getClass() != o.getClass())
            return false;

        // 3. Faz o cast seguro
        Categoria categoria = (Categoria) o;

        /* 4. Compara os IDs de forma segura
         Objects.equals trata null automaticamente*/
        return Objects.equals(id, categoria.id);
    }

    @Override
    public int hashCode() {

        /* Gera um hash baseado no ID
         Isso garante consistência com equals()*/
        return Objects.hash(id);
    }
}


