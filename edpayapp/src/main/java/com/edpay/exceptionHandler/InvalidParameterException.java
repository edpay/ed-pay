package com.edpay.exceptionHandler;

public class InvalidParameterException extends RestException {
    private static final long serialVersionUID = 560706381475201668L;

    public InvalidParameterException(IIErrorCodeDescription code, String description) {
        super(code, description);
    }
}
