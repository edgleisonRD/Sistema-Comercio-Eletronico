package com.portifolio.comercio_eletronico.dto;

public class MensagensParaCampos {
    private String nomeCampo;
    private String mensagem;

    public MensagensParaCampos(String nomeCampo, String mensagem) {
        this.nomeCampo = nomeCampo;
        this.mensagem = mensagem;
    }
    public String getNomeCampo() {
        return nomeCampo;
    }

    public String getMensagem() {
        return mensagem;
    }
}


