package com.portifolio.comercio_eletronico.servico;

import com.portifolio.comercio_eletronico.dto.ProdutoDTO;
import com.portifolio.comercio_eletronico.model.Produto;
import com.portifolio.comercio_eletronico.repositorios.ProdutoRepositorio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service // Indica ao Spring que esta classe é um "Bean" de serviço, onde fica a lógica de negócio.
public class ProdutoServico {

    // Dependência do Repositório (que faz a comunicação direta com o banco de dados)
    private ProdutoRepositorio repositorio;

    // Construtor para Injeção de Dependência.
    // O Spring entrega automaticamente uma instância de 'ProdutoRepositorio' aqui.
    public ProdutoServico(ProdutoRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Transactional(readOnly = true)
    public ProdutoDTO fitrarPorId(Long id) {// Busca o produto no banco pelo ID.
        Produto produto = repositorio.findById(id).get();
        return new ProdutoDTO(produto);
    }

    @Transactional(readOnly = true)
    public Page<ProdutoDTO> filtrarTodos(Pageable pageable) {
        Page<Produto> result = repositorio.findAll(pageable);
        return result.map(x -> new ProdutoDTO(x));
    }
    @Transactional
    public ProdutoDTO inserir(ProdutoDTO dto) {
        Produto produto = new Produto();
        produto.setNome(dto.getNome());
        produto.setDescricao(dto.getDescricao());
        produto.setPreco(dto.getPreco());
        produto.setImgUrl(dto.getImgUrl());
        repositorio.save(produto);
        return  new ProdutoDTO(produto);//retornamos um objeto salvo atualizado
    }
}