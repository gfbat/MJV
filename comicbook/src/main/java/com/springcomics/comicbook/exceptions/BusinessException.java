package com.springcomics.comicbook.exceptions;

public class BusinessException extends RuntimeException{

    public BusinessException(String message){
        super(message);
    }
}
