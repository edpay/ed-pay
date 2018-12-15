package com.edpay.exceptionHandler;

public class RestException extends RuntimeException {

    private static final long serialVersionUID = 562199380252119284L;

    private IIErrorCodeDescription errorCodeDescription;

    private String message;
    
    private String errorCode;
    
    private String errorResponse;

    public RestException() {

    }

    public RestException(IIErrorCodeDescription errorCodeDescription) {
        this.errorCodeDescription = errorCodeDescription;     
    }

    public RestException(String message) {
        super(message);
    }

    public String getErrorResponse() {
		return errorResponse;
	}

	public void setErrorResponse(String errorResponse) {
		this.errorResponse = errorResponse;
	}

	public RestException(IIErrorCodeDescription exceptionCode, String message) {
        this.errorCodeDescription = exceptionCode;
        this.message = message;
    }
    
    public RestException(IIErrorCodeDescription exceptionCode, String message,String errorCode) {
        this.errorCodeDescription = exceptionCode;
        this.message = message;
        this.errorCode = errorCode;
    }
    
    public RestException(IIErrorCodeDescription exceptionCode, String message,String errorCode, String errorResponse) {
        this.errorCodeDescription = exceptionCode;
        this.message = message;
        this.errorCode = errorCode;
        this.errorResponse=errorResponse;
    }

    public IIErrorCodeDescription getErrorCodeDescription() {
        return errorCodeDescription;
    }

    public String getMessage() {
        return message;
    }
    
    public String getErrorCode() {
		return errorCode;
	}

	@Override
    public String toString() {
        return "RestException [errorCodeDescription=" + errorCodeDescription + ", message=" + message + "]";
    }

}
