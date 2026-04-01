package com.portifolio.comercio_eletronico.servico;

import com.portifolio.comercio_eletronico.controller.interceptadoresDeErros.ControleDeExcecoes;
import com.portifolio.comercio_eletronico.dto.ProdutoDTO;
import com.portifolio.comercio_eletronico.exceptions.DbException;
import com.portifolio.comercio_eletronico.exceptions.ExceptionsParaRecursosNaoEncontrado;
import com.portifolio.comercio_eletronico.model.Produto;
import com.portifolio.comercio_eletronico.repositorios.ProdutoRepositorio;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.ObjectNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
    public ProdutoDTO fitrarPorId(Long id) {
        Produto produto = repositorio.findById(id).orElseThrow(
        () -> new ExceptionsParaRecursosNaoEncontrado("Não foi possivel localizar o id!" + id));
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
        copiandoDtoParaClasse(dto, produto);
        repositorio.save(produto);
        return new ProdutoDTO(produto);
    }

    @Transactional
    public ProdutoDTO atualizar(Long id, ProdutoDTO dto) {
        if(!repositorio.findById(id).isPresent()) {
            throw new ExceptionsParaRecursosNaoEncontrado("Não foi possivel atualizar com o id!" + id);
        }
        try {
            Produto produto = repositorio.getReferenceById(id);
            copiandoDtoParaClasse(dto, produto);
            repositorio.save(produto);
            return new ProdutoDTO(produto);
        } catch (ObjectNotFoundException e) {
            throw new ExceptionsParaRecursosNaoEncontrado("Produto não encontrado!");
        }
    }
//    @Transactional
//    public void deletar(Long id) {
//        if (!repositorio.existsById(id)) {
//            throw new ExceptionsParaRecursosNaoEncontrado("Recurso não encontrado! Id: " + id);
//        }
//        repositorio.deleteById(id);
//    }

   @Transactional(propagation = Propagation.SUPPORTS)//propagation para o caso de FK
    public void deletar(Long id) {
        try {
            repositorio.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ExceptionsParaRecursosNaoEncontrado("Recurso não encontrado! Id: " + id);
        } catch (DataIntegrityViolationException e) {
            throw new DbException("Não é possível excluir o " + id + " ele está relacionado a outros dados.");
        }
    }

    private void copiandoDtoParaClasse(ProdutoDTO dto, Produto produto) {
        produto.setNome(dto.getNome());
        produto.setDescricao(dto.getDescricao());
        produto.setPreco(dto.getPreco());
        produto.setImgUrl(dto.getImgUrl());

    }
    
}

