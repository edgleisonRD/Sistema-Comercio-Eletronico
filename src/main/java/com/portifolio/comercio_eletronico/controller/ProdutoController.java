package com.portifolio.comercio_eletronico.controller;

import com.portifolio.comercio_eletronico.model.Produto;
import com.portifolio.comercio_eletronico.repositorios.ProdutoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/produto")
public class ProdutoController {


    private final ProdutoRepositorio repositorio;
    //Injeção via construtor
    public ProdutoController(ProdutoRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @GetMapping
    public String teste(){
    Optional<Produto> result=repositorio.findById(10L);
    Produto produto=result.get();
    return produto.getNome();
    }
}
