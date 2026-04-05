package com.portifolio.comercio_eletronico.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidacaoDeErros extends ErroCustomizado{
    private List<MensagensParaCampos> erros = new ArrayList<>();

    public ValidacaoDeErros(Instant timestamp, Integer status, String error, String path) {
        super(timestamp, status, error, path);
    }
    public List<MensagensParaCampos> getErros() {
        return erros;
    }
    public void adicionarErro(String nomeCampo, String mensagem) {
        erros.add(new MensagensParaCampos(nomeCampo, mensagem));
    }
}
