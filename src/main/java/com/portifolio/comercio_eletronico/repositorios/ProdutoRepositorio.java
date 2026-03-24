package com.portifolio.comercio_eletronico.repositorios;


import com.portifolio.comercio_eletronico.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepositorio extends JpaRepository<Produto, Long> {
}
