package com.portifolio.comercio_eletronico.servico;

import com.portifolio.comercio_eletronico.dto.ProdutoDTO;
import com.portifolio.comercio_eletronico.model.Produto;
import com.portifolio.comercio_eletronico.repositorios.ProdutoRepositorio;
import org.springframework.stereotype.Service;
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
    // Define que o método é uma transação de banco de dados.
    // 'readOnly=true' otimiza a performance, avisando que você só vai ler dados, não vai alterar nada.
    @Transactional(readOnly=true)
    public ProdutoDTO fitrarId(Long id) {// Busca o produto no banco pelo ID.

        // O .get() extrai o objeto de dentro do 'Optional' retornado pelo Spring Data.
        Produto produto = repositorio.findById(id).get();

        // Converte a entidade 'Produto' (do banco) para um 'ProdutoDTO' (objeto de transferência).
        // Isso evita expor detalhes internos do banco para o usuário final.
        return new ProdutoDTO(produto);
    }
}

