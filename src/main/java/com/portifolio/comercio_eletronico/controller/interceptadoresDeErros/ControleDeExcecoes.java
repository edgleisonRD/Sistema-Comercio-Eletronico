package com.portifolio.comercio_eletronico.controller.interceptadoresDeErros;

import com.portifolio.comercio_eletronico.dto.ErroCustomizado;
import com.portifolio.comercio_eletronico.exceptions.DbException;
import com.portifolio.comercio_eletronico.exceptions.ExceptionsParaRecursosNaoEncontrado;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.time.Instant;

@ControllerAdvice
public class ControleDeExcecoes {
    @ExceptionHandler(ExceptionsParaRecursosNaoEncontrado.class)
    public ResponseEntity<ErroCustomizado> recursoNaoEncontrado(ExceptionsParaRecursosNaoEncontrado e,
                                                                 HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErroCustomizado err = new ErroCustomizado(Instant.now(), status.value(), e.getMessage(),
                request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
    @ExceptionHandler(DbException.class)
    public ResponseEntity<ErroCustomizado> excecaoDeBanco(DbException e,
                                                                HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;//BAD_REQUEST erro generico
        ErroCustomizado err = new ErroCustomizado(Instant.now(), status.value(), e.getMessage(),
                request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}
