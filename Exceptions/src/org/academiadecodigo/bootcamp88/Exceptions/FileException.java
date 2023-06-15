package org.academiadecodigo.bootcamp88.Exceptions;

import java.security.PublicKey;

public abstract class FileException extends Exception {

    private String ex;

    public FileException(String ex){
        this.ex = ex;
    }

    public String getMessage(){
        return ex;
    }
}