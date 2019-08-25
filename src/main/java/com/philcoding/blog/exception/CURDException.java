package com.philcoding.blog.exception;

public class CURDException extends RuntimeException {

    private static final long serialVersionUID = -7540623706302539162L;

    private int code;
    private String message;

    public CURDException() {
        super();
    }

    public CURDException(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
