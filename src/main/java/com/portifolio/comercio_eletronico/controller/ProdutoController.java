package com.portifolio.comercio_eletronico.controller;

import com.portifolio.comercio_eletronico.dto.ProdutoDTO;
import com.portifolio.comercio_eletronico.servico.ProdutoServico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/produto")
public class ProdutoController {


    private final ProdutoServico produtoServico;
    //Injeção via construtor
    public ProdutoController(ProdutoServico produtoServico) {
        this.produtoServico = produtoServico;
    }

    // O value = "/{id}" indica que a URL terá um número variável, ex: /produto/5
    @GetMapping(value = "/{id}")
    public ProdutoDTO filtrarPorId(@PathVariable Long id) {
        // @PathVariable diz ao Spring: "pegue o número que está na URL e coloque na variável 'id'".

        // O Controller chama o Serviço para buscar o dado e já o retorna como DTO.
        return produtoServico.fitrarPorId(id);
    }
    @GetMapping
    public Page<ProdutoDTO> filtrarTodos(Pageable pageable) {
        return  produtoServico.filtrarTodos(pageable);
    }
}
