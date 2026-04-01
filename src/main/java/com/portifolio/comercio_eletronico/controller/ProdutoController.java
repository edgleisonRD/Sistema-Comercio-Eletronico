package com.portifolio.comercio_eletronico.controller;

import com.portifolio.comercio_eletronico.dto.ErroCustomizado;
import com.portifolio.comercio_eletronico.dto.ProdutoDTO;
import com.portifolio.comercio_eletronico.exceptions.ExceptionsParaRecursosNaoEncontrado;
import com.portifolio.comercio_eletronico.servico.ProdutoServico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.Instant;


@RestController
@RequestMapping("/produto")
public class ProdutoController {


    private final ProdutoServico produtoServico;
    //Injeção via construtor
    public ProdutoController(ProdutoServico produtoServico) {
        this.produtoServico = produtoServico;
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<ProdutoDTO> filtrarPorId(@PathVariable Long id) {
            ProdutoDTO dto = produtoServico.fitrarPorId(id);
            return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<Page<ProdutoDTO>> filtrarTodos(Pageable pageable) {
        Page<ProdutoDTO> dto = produtoServico.filtrarTodos(pageable);
        return ResponseEntity.ok(dto);
    }
    @PostMapping
    public ResponseEntity <ProdutoDTO> inserir(@RequestBody ProdutoDTO produtoDTO){
        produtoDTO = produtoServico.inserir(produtoDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(produtoDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(produtoDTO);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<ProdutoDTO> atualizar(@PathVariable Long id, @RequestBody ProdutoDTO produtoDTO) {
        produtoDTO = produtoServico.atualizar(id, produtoDTO);
        return ResponseEntity.ok(produtoDTO);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        produtoServico.deletar(id);
        return ResponseEntity.noContent().build();/*O noContent() é para retornar um corpo vazio,
         o build() é para garantir a instancia do ResponseEntity o status a ser retornado é 204 No Content*/
    }
}
