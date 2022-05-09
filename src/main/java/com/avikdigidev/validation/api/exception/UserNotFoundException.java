package com.avikdigidev.validation.api.exception;

public class UserNotFoundException  extends Exception{
    private final String errorCode;
    private final String errorMessage;
    public UserNotFoundException(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
