package com.portifolio.comercio_eletronico.exceptions;

public class DbException extends  RuntimeException {
    public DbException(String msg){
        super(msg);
    }
}
