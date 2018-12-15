package com.edpay.exceptionHandler;

public class UnAuthorizedException extends RestException {

	private static final long serialVersionUID = -3163616754972919149L;

	public UnAuthorizedException(IIErrorCodeDescription code) {
        super(code, code.getErrorDescription());
    }
}
