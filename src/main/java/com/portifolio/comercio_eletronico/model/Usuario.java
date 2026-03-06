package com.portifolio.comercio_eletronico.model;

import java.time.LocalDate;

public class Usuario {
    private long id;
    private String nome;
    private String email;
    private String senha;
    private String telefone;
    private LocalDate dNascimento;

    public Usuario(long id, String nome, String email, String senha, String telefone, LocalDate dNascimento) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.dNascimento = dNascimento;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDate getdNascimento() {
        return dNascimento;
    }

    public void setdNascimento(LocalDate dNascimento) {
        this.dNascimento = dNascimento;
    }
}
