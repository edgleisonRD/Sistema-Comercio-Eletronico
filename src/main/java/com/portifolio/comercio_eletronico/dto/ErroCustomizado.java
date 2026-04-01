package com.portifolio.comercio_eletronico.dto;

import java.time.Instant;

public class ErroCustomizado {
    private Instant timestamp;//Instant é o momento que erro ocorrer
    private Integer status;
    private String error;
    private String path;

    /*Crie o construtor com argumentos
      Gere apenas Gets
     */

    public ErroCustomizado(Instant timestamp, Integer status, String error, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.path = path;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getPath() {
        return path;
    }
}
