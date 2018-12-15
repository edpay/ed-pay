package com.edpay.exceptionHandler;

public class InvalidRequestException extends RestException {

    private static final long serialVersionUID = -7050154061340999132L;

    public InvalidRequestException(final IIErrorCodeDescription errorcode) {
        super(errorcode,errorcode.name());
    }

}
