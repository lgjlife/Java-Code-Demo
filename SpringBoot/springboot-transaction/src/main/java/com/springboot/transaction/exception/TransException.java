package com.springboot.transaction.exception;

public class TransException extends  RuntimeException {
    public TransException(String message) {
        super(message);
    }

    public TransException(String message, Throwable cause) {
        super(message, cause);
    }


}
