package com.edpay.exceptionHandler;

import java.io.Serializable;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorObject implements Serializable {
    private static final long serialVersionUID = -6221373693513083945L;

    @JsonProperty(value = "error_code")
    int errorCode;

    @JsonProperty(value = "error_description")
    String errorDescription;

    @JsonProperty(value = "message")
    String message;

    public ErrorObject() {}

    public ErrorObject(RestException ex) {
        String template;
        int code;
        ResourceBundle bundle = ResourceBundle.getBundle("message", Locale.getDefault());
        try {
            template = bundle.getString(String.valueOf(ex.getErrorCodeDescription().getErrorCode()));
            code = ex.getErrorCodeDescription().getErrorCode();

        } catch (MissingResourceException e) {
            template = bundle.getString("1000");
            code = 1000;
        }

        if (ex.getErrorCodeDescription().getErrorCode() == 3002) {
            template = ex.getMessage();
            code = ex.getErrorCodeDescription().getErrorCode();
        }

        this.errorCode = code;
        this.message = template;
        this.errorDescription = template;
    }

    public ErrorObject(int errorCode, String errorDescription, String message) {
        this.errorCode = errorCode;
        this.message = message;
        this.errorDescription = message;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    @Override
    public String toString() {
        return "ErrorObject [errorCode=" + errorCode + ", message=" + message + "]";
    }

}
