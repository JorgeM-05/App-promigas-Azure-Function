package com.promigas.domain.exception;

public class PromigasException extends RuntimeException{
    private long codeException;
    private String message;

    private int responseCode;

    public PromigasException(long codeException, String message, int responseCode){
        this.codeException = codeException;
        this.message = message;
        this.responseCode = responseCode;
    }

    public long getCodeException() {
        return codeException;
    }

    public void setCodeException(long codeException) {
        this.codeException = codeException;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }
}
