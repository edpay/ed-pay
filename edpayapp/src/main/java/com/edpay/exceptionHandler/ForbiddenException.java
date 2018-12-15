package com.edpay.exceptionHandler;

public class ForbiddenException extends RestException {
    private static final long serialVersionUID = 8263143357588041554L;

    public ForbiddenException(IIErrorCodeDescription errorCode) {
        super(errorCode, errorCode.getErrorDescription());
    }
}
