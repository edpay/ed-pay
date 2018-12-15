package com.edpay.exceptionHandler;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class BadRequestException extends RestException {

    private static final long serialVersionUID = 8263143357588041554L;
    
       public BadRequestException(IIErrorCodeDescription errorCode) {
        super(errorCode, errorCode.getErrorDescription());
    }
     
       public BadRequestException(IIErrorCodeDescription errorCode,String message) {
           super(errorCode,errorCode.getErrorDescription(),message);
       }
       

	public BadRequestException() {
		super();
	}

}
